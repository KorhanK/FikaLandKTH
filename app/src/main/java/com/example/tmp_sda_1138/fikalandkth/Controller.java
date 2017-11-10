package com.example.tmp_sda_1138.fikalandkth;

import java.util.Random;

/**
 * Created by tmp-sda-1138 on 11/6/17.
 */



class Controller {

    Player player;
    Random random;



    public Controller(){
        player = new Player(20000, 50, 25, 0, 10, 0);
        random = new Random();


    }

    private void substractTurn(){
        player.getTime().setTurns(player.getTime().getTurns() - 1);
    }
    private void substractMoney(int money){
        player.setMoney(player.getMoney() - money);

    }

    private void moraleBoost(int boost){
        player.setMorale(player.getMorale()+boost);
    }

    public void getTechEducation(){

        int addition = random.nextInt(5) + 5;
        player.setTechnicalEducation(player.getTechnicalEducation() + addition);
        substractTurn();

    }

    public Player getPlayer() {
        return player;
    }

    public void getSocialEducation() {
        int addition = random.nextInt(6) + 5;
        player.setSocialEducation(player.getSocialEducation() + addition);
        substractTurn();
    }

    public void learnSwedish() {
        int addition = random.nextInt(3) + 2;
        player.setSwedishLevel(player.getSwedishLevel() + addition);
        substractTurn();

    }

    public void learnEnglish() {
        int addition = random.nextInt(2) + 2;
        player.setEnglishLevel(player.getEnglishLevel() + addition);
        substractTurn();
    }


    public void artClick() {
        int price = 0;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            moraleBoost(2);
            if (iGetAnyFriends(15)){
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met "+ friend + ", you are friends now.");
            }
            else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        }
        else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }


    public void concertClick() {
        int price = 1000;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            moraleBoost(4);
            if (iGetAnyFriends(25)){
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met "+ friend + ", you are friends now.");
            }
            else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        }
        else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }

    public void pubClick() {
        int price = 2500;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            moraleBoost(7);
            if (iGetAnyFriends(35)){
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met "+ friend + ", you are friends now.");
            }
            else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        }
        else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }

    public void danceClick() {
        int price = 3000;
        if (canIPayForIt(price)) {
            player.setMoney(player.getMoney() - price);
            moraleBoost(10);
            if (iGetAnyFriends(50)){
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
                MainActivity.changeMainText("You had some morale and you met "+ friend + ", you are friends now.");
            }
            else
                MainActivity.changeMainText("You had some morale but you didn't get any friends.");
        }
        else
            MainActivity.changeMainText("You don't have enough money to pay for it.");
    }

    public void dateClick() {
        if (player.friendsSize() > 0){
            String friendsList = "Who do you want to date?";
            for (int y = 0; y<player.friendsSize(); y++){
                String candidate = player.getFriend(y);
                friendsList = friendsList + (y+1) + "-" +  candidate;
            }
            MainActivity.changeMainText(friendsList);
        }
        else
            MainActivity.changeMainText("You must have at least one friend to be able to date.");
    }




    private boolean iGetAnyFriends(int i) {
        int percent = random.nextInt(100) + 1;
        if (percent <= i)
            return true;
        else
            return false;
    }

    private boolean canIPayForIt(int i) {
        if ((player.getMoney() - i) < 0)
            return false;
        else
            return true;
    }


}
