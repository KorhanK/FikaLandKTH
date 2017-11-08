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
        if (canIPayForIt(0)) {
            moraleBoost(2);
            if (iGetAnyFriends(20)){
                int index = random.nextInt(player.getNameList().personNames.size());
                String friend = player.getNameList().personNames.get(index);
                player.addFriend(friend);
            }
        }
    }
}
