package com.example.tmp_sda_1138.fikalandkth;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tmp-sda-1138 on 11/6/17.
 */



class Controller {

    Player player;
    Random random;
    Checker checker;
    Job createdJob1;
    Job createdJob2;
    Job createdJob3;

    House createdHouse1;
    House createdHouse2;
    House createdHouse3;

    ArrayList<Job> jobsOffered;

    ArrayList<House> housesOnTheMarket;



    public Controller() {
        player = new Player(200000, 50, 25, 200, 800, 0, 200);
        random = new Random();
        checker = new Checker();
        checker.player = player;

        jobsOffered = new ArrayList<>();
        housesOnTheMarket = new ArrayList<>();


    }




    /**
     * Get turns one down.
     */

    public void substractTurn() {

        player.getTime().setTurns(player.getTime().getTurns() - 1);
        moraleBoost(player.getMoraleModifier());
        checker.turnChecker();
    }

    /**
     * Substract @param amount of money.
     */
    private void substractMoney(int money) {
        player.setMoney(player.getMoney() - money);

    }

    /**
     * Boost morale as much as the @param
     */
    private void moraleBoost(int boost) {
        player.setMorale(player.getMorale() + boost);
    }

    /**
     * Increases technical education Random5-9.
     */
    public void getTechEducation() {

        int addition = random.nextInt(5) + 5;
        player.setTechnicalEducation(player.getTechnicalEducation() + addition);
        substractTurn();

    }

    /**
     * Increases social education Random5-10.
     */

    public void getSocialEducation() {
        int addition = random.nextInt(6) + 5;
        player.setSocialEducation(player.getSocialEducation() + addition);
        substractTurn();
    }


    public Player getPlayer() {
        return player;
    }

    /**
     * Increases swedish skills 2-4
     */

    public void learnSwedish() {
        int addition = random.nextInt(3) + 2;
        player.setSwedishLevel(player.getSwedishLevel() + addition);
        substractTurn();

    }

    /**
     * Increases swedish skills 2-3
     */


    public void learnEnglish() {
        int addition = random.nextInt(2) + 2;
        player.setEnglishLevel(player.getEnglishLevel() + addition);
        substractTurn();
    }

    /**
     * Art event interraction button. Adds morale boost and sometimes friends.
     */
    public void artClick() {
        int price = 0;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(2);
            if (iGetAnyFriends(15)) {
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met " + friend + ", you are friends now.");
            } else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        } else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }

    /**
     * Concert event interraction button. Adds morale boost and sometimes friends.
     */
    public void concertClick() {
        int price = 1000;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(4);
            if (iGetAnyFriends(25)) {
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met " + friend + ", you are friends now.");
            } else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        } else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }
    /**
     * Pub interraction button. Adds morale boost and sometimes friends.
     */
    public void pubClick() {
        int price = 2500;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(7);
            if (iGetAnyFriends(35)) {
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met " + friend + ", you are friends now.");
            } else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        } else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }
    /**
     * Dance club interraction button. Adds morale boost and sometimes friends.
     */
    public void danceClick() {
        int price = 3000;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(10);
            if (iGetAnyFriends(50)) {
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met " + friend + ", you are friends now.");
            } else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        } else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }
    /**
     * Dating button. Checks and lists any potential dates from the friends list.
     * Returns true if there is at least one friend.
     */
    public boolean dateClick() {
        if (player.friendsSize() > 0&&player.getPartnerName().equals("no")&&player.getDateName().equals("no")) {
            String friendsList = "Who do you want to date?";
            for (int y = 0; y < player.friendsSize(); y++) {
                String candidate = player.getFriend(y);
                friendsList = friendsList + (y + 1) + "-" + candidate;
            }
            MainActivity.changeMainText(friendsList);
            return true;
        } else {
            MainActivity.changeMainText("You must have at least one friend, not be married and not dating anyone!");
            return false;
        }
    }

    /**
     * Calculates if the player get any friend from the social events. @param is  chances in %
     */
    private boolean iGetAnyFriends(int i) {
        int percent = random.nextInt(100) + 1;
        if (percent <= i)
            return true;
        else
            return false;
    }

    /**
     * Checks if the player can pay for it.
     * Returns true if the player can.
     */

    public boolean canIPayForIt(int i) {
        if ((player.getMoney() - i) < 0)
            return false;
        else
            return true;
    }

    /**
     * Sets the name of the person that the player is dating.
     */

    public String startToDate(int index) {
        if (index < player.friendsSize() && index >= 0) {
            String name = player.getFriend(index);
            player.setDateName(name);
            player.removeFriend(index);
            substractTurn();
            return name;
        } else
            return null;
    }

    public String getMarried() {
        if (player.getDateName().equals("no")||!player.getPartnerName().equals("no"))
            return "no";
        else {
            player.setPartnerName(player.getDateName());
            player.setDateName("no");
            return player.getPartnerName();
        }



    }

    public int haveKids() {
        if (player.getPartnerName().equals("no")){
            return -1;
        }
        else{
            substractTurn();
            int random = this.random.nextInt(100) + 1;
            if (random <= 20){
                int isOne = this.random.nextInt(67) + 1;
                if(isOne == 1){
                    int howMany = this.random.nextInt(2) +2;
                    player.setNumberOfChildren(player.getNumberOfChildren() + howMany);
                    return howMany;

                }
                else{
                    player.setNumberOfChildren(player.getNumberOfChildren() + 1);
                    return 1;
                }
            }
            else{
                return 0;
            }

        }
    }

    public String eat() {
        if(player.getFoodForMoths() == 0){
            if(canIPayForIt(2000)){
                substractMoney(2000);
                player.setFoodForMoths(1);
                return "ok";
            }
            else
                return "nomoney";

        }
        else
            return "already";
    }

    public boolean buyTravelCard() {
        if(canIPayForIt(10000)){
            substractMoney(10000);
            player.setTravelCardMonths(player.getTravelCardMonths()+6);
            return true;
        }
        else
            return false;

    }

    public boolean buyFoodMembership() {
        if(canIPayForIt(30000)){
            substractMoney(30000);
            player.setFoodForMoths(player.getFoodForMoths()+12);
            return true;
        }
        else
            return false;
    }

    public boolean buyHobby() {
        if (canIPayForIt(2000)){
            substractMoney(2000);
            moraleBoost(10);
            return true;
        }
        else
            return false;
    }

    public boolean checkMoraleEligebility() {
        if (player.getMorale() >= 50){
            return true;
        }
        else
            return false;
    }

    public ArrayList<String> createThreeJobs() {
        substractTurn();
        createdJob1 = createJob();
        jobsOffered.add(createdJob1);
        createdJob2 = createJob();
        jobsOffered.add(createdJob2);
        createdJob3 = createJob();
        jobsOffered.add(createdJob3);

        ArrayList<String> jobTexts = new ArrayList<>();
        jobTexts.add("JOB 1. Type: " + createdJob1.getType() + " Pay: " + createdJob1.getPay() + " Technical Skill Required: " + createdJob1.getRequiredTech() + " Social Skill Required: " + createdJob1.getRequiredSocial() + " Swedish Level Required: " + createdJob1.getRequiredSwedish() + " English Level Required : " + createdJob1.getRequiredEnglish() );
        jobTexts.add("JOB 2. Type: " + createdJob2.getType() + " Pay: " + createdJob2.getPay() + " Technical Skill Required: " + createdJob2.getRequiredTech() + " Social Skill Required: " + createdJob2.getRequiredSocial() + " Swedish Level Required: " + createdJob2.getRequiredSwedish() + " English Level Required : " + createdJob2.getRequiredEnglish() );
        jobTexts.add("JOB 3. Type: " + createdJob3.getType() + " Pay: " + createdJob3.getPay() + " Technical Skill Required: " + createdJob3.getRequiredTech() + " Social Skill Required: " + createdJob3.getRequiredSocial() + " Swedish Level Required: " + createdJob3.getRequiredSwedish() + " English Level Required : " + createdJob3.getRequiredEnglish() );

        return jobTexts;
    }

    private Job createJob(){

        int jobTypeRandom = random.nextInt(3);
        if (jobTypeRandom == 0){
            String type = "technical";
            int technicalRequirement = random.nextInt(500) + 200;
            int swedishRequirement = random.nextInt(100) + 100;
            int englishRequirement = random.nextInt(100) + 50;
            int pay = random.nextInt(10000) + 17000;
            Job temp = new Job(pay, type, technicalRequirement,0, swedishRequirement, englishRequirement );
            return temp;
        }
        else if(jobTypeRandom == 1){
            String type = "social";
            int socialRequirement = random.nextInt(500) + 200;
            int swedishRequirement = random.nextInt(100) + 100;
            int englishRequirement = random.nextInt(100) + 50;
            int pay = random.nextInt(10000) + 17000;
            Job temp = new Job(pay, type, 0,socialRequirement, swedishRequirement, englishRequirement );
            return temp;
        }
        else{
            String type = "mixed";
            int socialRequirement = random.nextInt(200) + 200;
            int technicalRequirement = random.nextInt(200) + 200;
            int swedishRequirement = random.nextInt(100) + 100;
            int englishRequirement = random.nextInt(100) + 50;
            int pay = random.nextInt(10000) + 17000;
            Job temp = new Job(pay, type, technicalRequirement, socialRequirement, swedishRequirement, englishRequirement );
            return temp;
        }

    }

    public boolean getJob1() {
        if (createdJob1.getRequiredTech()<=player.getTechnicalEducation() && createdJob1.getRequiredSocial()<=player.getSocialEducation() && createdJob1.getRequiredSwedish()<=player.getSwedishLevel() && createdJob1.getRequiredEnglish()<=player.getEnglishLevel()){
            player.setJob(createdJob1);

            return true;
        }
        else
            return false;
    }

    public boolean getJob2() {
        if (createdJob2.getRequiredTech()<=player.getTechnicalEducation() && createdJob2.getRequiredSocial()<=player.getSocialEducation() && createdJob2.getRequiredSwedish()<=player.getSwedishLevel() && createdJob2.getRequiredEnglish()<=player.getEnglishLevel()){
            player.setJob(createdJob2);

            return true;
        }
        else
            return false;
    }

    public boolean getJob3() {
        if (createdJob3.getRequiredTech()<=player.getTechnicalEducation() && createdJob3.getRequiredSocial()<=player.getSocialEducation() && createdJob3.getRequiredSwedish()<=player.getSwedishLevel() && createdJob3.getRequiredEnglish()<=player.getEnglishLevel()){
            player.setJob(createdJob3);

            return true;
        }
        else
            return false;
    }


    public boolean rentRoom() {
        if((player.getHouse() == null || player.getHouse().isSocialRoom) && canIPayForIt(6000)){
            int pay;
            try{
                pay = player.getJob().getPay();
            }
            catch (Exception e){
                pay =0;
            }


            int moraleM = House.moraleModifierCalc(6000, pay,false,false);
            player.setHouse(new House(false, true, false, false, 1, 0, 0,  moraleM ));
            return true;
        }
        else
            return false;

    }


    public boolean isEligeableToRent() {
        int pay;
        try{
            pay = player.getJob().getPay();
        }
        catch (Exception e){
            pay =0;
        }
        if((player.getHouse() == null || player.getHouse().isSocialRoom || player.getHouse().isRoom) && pay > 20000){
            return true;
        }
        else
            return false;
    }


    public ArrayList<Integer> rentFlat() {
        int rooms;
        int moralemodifier;
        int rent;
        int pay;
        int roomRandomizer = random.nextInt(100)+1;
        if (roomRandomizer <=50){
            rooms = 1;
        }
        else if(roomRandomizer<=75){
            rooms = 2;
        }
        else if(roomRandomizer<=90){
            rooms = 3;
        }
        else{
            rooms = 4;
        }

        try{
            pay = player.getJob().getPay();
        }
        catch (Exception e){
            pay =0;
        }

        rent = House.rentCalc(false, false, true,false, rooms);
        moralemodifier = House.moraleModifierCalc(rent, pay,false,false);
        player.setHouse(new House(false, false,true,false, rooms, rent, 0, moralemodifier));
        ArrayList<Integer> values = new ArrayList<>();
        values.add(rooms);
        values.add(rent);

        return values;

    }

    public boolean canIbuyAHouse() {
        if(player.getJob() != null && canIPayForIt(200000))
            return true;
        else
            return false;
    }

    public ArrayList<String> createThreeHouses() {
        substractTurn();
        int rooms;
        int moralemodifier;
        int rent;
        int deposit;
        for(int i=0;i<3;i++) {
            int roomRandomizer = random.nextInt(100) + 1;
            if (roomRandomizer <= 50) {
                rooms = 1;
            } else if (roomRandomizer <= 75) {
                rooms = 2;
            } else if (roomRandomizer <= 90) {
                rooms = 3;
            } else
                rooms = 4;
            rent = House.rentCalc(false, false, false, true, rooms);
            moralemodifier = House.moraleModifierCalc(rent, player.getJob().getPay(), true, false);
            deposit = House.depositCalc(rooms);
            housesOnTheMarket.add(new House(false, false, true, false, rooms, rent, deposit, moralemodifier));
        }

        ArrayList<String> houseTexts = new ArrayList<>();

        for(int i=1; i<4; i++) {
            houseTexts.add("House " + i + ". Rooms:" + housesOnTheMarket.get(i - 1).getRoom() + " - Rent:" + housesOnTheMarket.get(i - 1).getRent() + " - Deposit:" + housesOnTheMarket.get(i - 1).getDeposit() + " - Morale Modifier:" + housesOnTheMarket.get(i - 1).getMoraleModifier() + ".");
        }

        return houseTexts;
    }

    public boolean getHouse1() {
        if (canIPayForIt(housesOnTheMarket.get(0).getDeposit())){
            substractMoney(housesOnTheMarket.get(0).getDeposit());
            player.setHouse(housesOnTheMarket.get(0));
            return true;
        }
        else
            return false;


    }

    public boolean getHouse2() {
        if (canIPayForIt(housesOnTheMarket.get(1).getDeposit())){
            substractMoney(housesOnTheMarket.get(1).getDeposit());
            player.setHouse(housesOnTheMarket.get(1));
            return true;
        }
        else
            return false;


    }

    public boolean getHouse3() {
        if (canIPayForIt(housesOnTheMarket.get(2).getDeposit())){
            substractMoney(housesOnTheMarket.get(2).getDeposit());
            player.setHouse(housesOnTheMarket.get(2));
            return true;
        }
        else
            return false;


    }

    public void backFromHouseSearch() {
        housesOnTheMarket.clear();
    }




}
