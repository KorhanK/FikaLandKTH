package com.example.tmp_sda_1138.fikalandkth;

import android.widget.Toast;

import java.util.Random;

/**
 * Created by korha on 11/12/2017.
 */

class Checker{

    Random random;
    Player player;







    public Checker(){

        random = new Random();


    }

    /**
     * Monthly events
     */

    public void turnChecker(){
        if(player.getTime().getTurns() == 0){
            player.getTime().setMonth(player.getTime().getMonth() + 1);
            if(player.getTime().getMonth() == 60){
                Controller.endGame(new EndGame("turnsOver", player.getPoints(), player.getMoney()));
            }
            else {
                if (player.getJob() != null) {
                    player.setMoney(player.getMoney() + player.getJob().getPay());
                    if (player.getHouse() != null)
                        player.setMoraleModifier(player.getHouse().getMoraleModifier() + 1);
                    else
                        player.setMoraleModifier(0);
                } else {
                    if (player.getHouse() != null)
                        player.setMoraleModifier(player.getHouse().getMoraleModifier());
                    else
                        player.setMoraleModifier(-2);
                }
                player.setMorale(player.getMorale() + player.getMoraleModifier() + 1);

                if (player.getTravelCardMonths() > 0) {
                    player.setTravelCardMonths(player.getTravelCardMonths() - 1);
                    player.setTurnNumber(6);
                } else
                    player.setTurnNumber(5);

                if (player.getFoodForMoths() == 0) {
                    player.setTurnModifier(-2);
                    player.getTime().setTurns(player.getTurnNumber() + player.getTurnModifier());

                } else {
                    player.setFoodForMoths(player.getFoodForMoths() - 1);
                    player.getTime().setTurns(player.getTurnNumber());
                }

                try {
                    player.setMoney(player.getMoney() - player.getHouse().getRent());
                    if (player.getMoney() < 0) {
                        player.setMoney(0);
                        player.setHouse(new House(true, false, false, false, 1, 500, 0, -1));

                    }
                } catch (Exception e) {
                    player.setHouse(new House(true, false, false, false, 1, 500, 0, -1));
                }

                try {
                    if (player.getJob() != null) {
                        player.getTime().setTurns(player.getTurnNumber() - 1);
                    } else
                        return;


                } catch (Exception f) {
                    return;
                }
            }


        }

        /**
         * Negative morale END
         */
        if (player.getMorale()<0){
            Controller.endGame(new EndGame("moraleDown", player.getPoints(), player.getMoney()));
        }

        return;

    }



}
