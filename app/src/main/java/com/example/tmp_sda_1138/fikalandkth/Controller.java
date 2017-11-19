package com.example.tmp_sda_1138.fikalandkth;

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

   ArrayList<Job> jobsOffered;

    ArrayList<House> housesOnTheMarket;

    //JSONArray playerJson;

    //MainActivity mainActivity;





    public Controller() {

        random = new Random();
        int english = random.nextInt(50)+10;
        int swedish = random.nextInt(50)+5;
        int tech = random.nextInt(100);
        int social = random.nextInt(100);
        player = new Player(20000, 40, english, tech, social, swedish);


        checker = new Checker();
        checker.player = player;

        jobsOffered = new ArrayList<>();
        housesOnTheMarket = new ArrayList<>();



    }



    public void addPoints(int points){
        player.setPoints(player.getPoints()+points);
    }

    /**
     * Creates a player with high skills, money and morale
     */

    public void setGodPlayer(){
        this.player = new Player(500000,100,300,800,800,300);
        player.setTime(new Time(50, 5));
        checker.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    /**
     * Turn over.
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
        addPoints(2);

    }

    /**
     * Increases social education Random5-10.
     */

    public void getSocialEducation() {
        int addition = random.nextInt(6) + 5;
        player.setSocialEducation(player.getSocialEducation() + addition);
        substractTurn();
        addPoints(2);
    }


    public Player getPlayer() {
        return player;
    }

    /**
     * Increases swedish skills 5-7
     */

    public void learnSwedish() {
        int addition = random.nextInt(3) + 5;
        player.setSwedishLevel(player.getSwedishLevel() + addition);
        substractTurn();
        addPoints(3);

    }

    /**
     * Increases englisgh skills 4-5
     */


    public void learnEnglish() {
        int addition = random.nextInt(2) + 4;
        player.setEnglishLevel(player.getEnglishLevel() + addition);
        substractTurn();
        addPoints(1);
    }

    /**
     * Art event interaction button. Adds morale boost and sometimes a friend.
     */
    public void artClick() {
        int price = 0;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(3);
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
     * Concert event interaction button. Adds morale boost and sometimes a friend.
     */
    public void concertClick() {
        int price = 1000;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(5);
            addPoints(2);
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
     * Pub interaction button. Adds morale boost and sometimes a friend.
     */
    public void pubClick() {
        int price = 2500;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(8);
            addPoints(4);
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
     * Dance club interaction button. Adds morale boost and sometimes a friend.
     */
    public void danceClick() {
        int price = 3000;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            substractTurn();
            moraleBoost(10);
            addPoints(6);
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
            addPoints(4);
            return name;
        } else
            return null;
    }

    /**
     * Let's the player get married with his/her date.
     */

    public String getMarried() {
        if (player.getDateName().equals("no")||!player.getPartnerName().equals("no"))
            return "no";
        else {
            player.setPartnerName(player.getDateName());
            substractTurn();
            addPoints(20);
            player.setDateName("no");
            return player.getPartnerName();
        }



    }

    /**
     * Checks if the player is married and adds random(0-3) children to the family.
     * returns the number of children
     *
     */

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
                    addPoints(5);
                    return howMany;

                }
                else{
                    player.setNumberOfChildren(player.getNumberOfChildren() + 1);
                    addPoints(5);
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
                addPoints(1);
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
            substractTurn();
            addPoints(4);
            player.setTravelCardMonths(player.getTravelCardMonths()+6);
            return true;
        }
        else
            return false;

    }

    public boolean buyFoodMembership() {
        if(canIPayForIt(30000)){
            substractMoney(30000);
            substractTurn();
            addPoints(4);
            player.setFoodForMoths(player.getFoodForMoths()+12);
            return true;
        }
        else
            return false;
    }

    public boolean buyHobby() {
        if (canIPayForIt(2000)){
            substractMoney(2000);
            substractTurn();
            addPoints(2);
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

    /**
     * Creates 3 random jobs and their text info to pass them as an ArrayList to the caller.
     */

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

    /**
     *Creates random job and returns it.
    */

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

    /**
     * Different job application selection.
     */

    public boolean getJob1() {
        if (createdJob1.getRequiredTech()<=player.getTechnicalEducation() && createdJob1.getRequiredSocial()<=player.getSocialEducation() && createdJob1.getRequiredSwedish()<=player.getSwedishLevel() && createdJob1.getRequiredEnglish()<=player.getEnglishLevel()){
            player.setJob(createdJob1);
            addPoints(10);

            return true;
        }
        else
            return false;
    }

    public boolean getJob2() {
        if (createdJob2.getRequiredTech()<=player.getTechnicalEducation() && createdJob2.getRequiredSocial()<=player.getSocialEducation() && createdJob2.getRequiredSwedish()<=player.getSwedishLevel() && createdJob2.getRequiredEnglish()<=player.getEnglishLevel()){
            player.setJob(createdJob2);
            addPoints(10);

            return true;
        }
        else
            return false;
    }

    public boolean getJob3() {
        if (createdJob3.getRequiredTech()<=player.getTechnicalEducation() && createdJob3.getRequiredSocial()<=player.getSocialEducation() && createdJob3.getRequiredSwedish()<=player.getSwedishLevel() && createdJob3.getRequiredEnglish()<=player.getEnglishLevel()){
            player.setJob(createdJob3);
            addPoints(10);

            return true;
        }
        else
            return false;
    }

    /**
     * House commands.
     */

    //Let's player rent a room if he has the money and doesn't have better.

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
            player.setHouse(new House(false, true, false, false, 1, 6000, 0,  moraleM ));
            addPoints(1);
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

    //Lets player rent a randomly generated flat.

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
        addPoints(3);
        ArrayList<Integer> values = new ArrayList<>();
        values.add(rooms);
        values.add(rent);

        return values;

    }

    //House buying methods.

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
            addPoints(8);
            return true;

        }
        else
            return false;


    }

    public boolean getHouse2() {
        if (canIPayForIt(housesOnTheMarket.get(1).getDeposit())){
            substractMoney(housesOnTheMarket.get(1).getDeposit());
            player.setHouse(housesOnTheMarket.get(1));
            addPoints(8);
            return true;
        }
        else
            return false;


    }

    public boolean getHouse3() {
        if (canIPayForIt(housesOnTheMarket.get(2).getDeposit())){
            substractMoney(housesOnTheMarket.get(2).getDeposit());
            player.setHouse(housesOnTheMarket.get(2));
            addPoints(8);

            return true;
        }
        else
            return false;


    }

    public void backFromHouseSearch() {
        housesOnTheMarket.clear();
    }


    /**
     * Game Ending Method.
     */
    public static void endGame(EndGame endgame){
                String type = endgame.getType();
                int points = endgame.getPoints();
                int money = endgame.getMoney();
                MainActivity.endGame(type, points, money);
    }

    /**
     * Hourly work method.
     */

    public int hourlyJob() {
        substractTurn();
        addPoints(1);
        int money = random.nextInt(2000) + 1500;
        player.setMoney(player.getMoney() + money);
        return money;
    }










//
//    public String readFullyAsString(InputStream inputStream, String encoding)
//            throws IOException {
//        return readFully(inputStream).toString(encoding);
//    }
//
//    public byte[] readFullyAsBytes(InputStream inputStream)
//            throws IOException {
//        return readFully(inputStream).toByteArray();
//    }
//
//    private ByteArrayOutputStream readFully(InputStream inputStream)
//            throws IOException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int length = 0;
//        while ((length = inputStream.read(buffer)) != -1) {
//            baos.write(buffer, 0, length);
//        }
//        return baos;
//    }
//
//
//
//    public void process() throws JSONException {
//        JSONObject playerJson = new JSONObject();
//        playerJson.put("name", player.getName());
//        playerJson.put("money", player.getMoney());
//        playerJson.put("morale", player.getMorale());
//        playerJson.put("months", player.getTime().getMonth());
//        playerJson.put("turns", player.getTime().getTurns());
//        playerJson.put("tech", player.getTechnicalEducation());
//        playerJson.put("social", player.getSocialEducation());
//        playerJson.put("english", player.getEnglishLevel());
//        playerJson.put("swedish", player.getSwedishLevel());
//        playerJson.put("dating", player.getDateName());
//        playerJson.put("partner", player.getPartnerName());
//        playerJson.put("kids", player.getNumberOfChildren());
//        playerJson.put("moraleModifier", player.getMoraleModifier());
//        playerJson.put("turnModifier", player.getTurnModifier());
//        playerJson.put("foodForMonths", player.getFoodForMoths());
//        playerJson.put("travelCardMonths", player.getTravelCardMonths());
//        playerJson.put("points", player.getPoints());
//
//        JSONObject jobJson = new JSONObject();
//
//        try {
//
//            jobJson.put("type", player.getJob().getType());
//            jobJson.put("salary", player.getJob().getPay());
//        }
//        catch(Exception e){
//
//            jobJson.put("type", "no");
//            jobJson.put("salary", 0);
//        }
//
//        playerJson.put("job", jobJson);
//
//        JSONObject houseJson = new JSONObject();
//
//        try{
//            houseJson.put("isSocial", player.getHouse().isSocialRoom());
//            houseJson.put("isRoom", player.getHouse().isRoom());
//            houseJson.put("isRent", player.getHouse().isRent());
//            houseJson.put("isForSale", player.getHouse().isForSale());
//            houseJson.put("room", player.getHouse().getRoom());
//            houseJson.put("rent", player.getHouse().getRent());
//            houseJson.put("deposit", player.getHouse().getDeposit());
//            houseJson.put("moraleModifier", player.getHouse().getMoraleModifier());
//        }
//        catch (Exception e){
//            houseJson.put("rent", 0);
//        }
//
//        playerJson.put("house", houseJson);
//
//        JSONObject friendsJson = new JSONObject();
//
//        try{
//            int counter=1;
//            for(String friend: player.getFriends()){
//                friendsJson.put(String.valueOf(counter), friend);
//                counter++;
//            }
//        }
//        catch (Exception e){
//            friendsJson.put("0", "no");
//        }
//
//        playerJson.put("friends", friendsJson);
//
//
//
//
//
//        public void save() throws JSONException {
//            String playerSave = playerJson.toString(2);
//            FileOutputStream fos = null;
//            try {
//                fos = mainActivity.openFileOutput("mysave.json", Context.MODE_PRIVATE);
//                fos.write(playerSave.getBytes());
//                fos.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    public  load() {
//            JSONArray contentS;
//        try {
//            FileInputStream stream = mainActivity.openFileInput("mysave.json");
//            String content = readFullyAsString(stream, "UTF-8");
//            JSONObject obj = new JSONObject(content);
//            player = new Player(content.getS)
////            contentS = (JSONArray) new JSONTokener(content).nextValue();
////            return contentS;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
//
//
//
//    public void setMainActivity(MainActivity mainActivity) {
//        this.mainActivity = mainActivity;
//    }
}

