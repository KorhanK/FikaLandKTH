package com.example.tmp_sda_1138.fikalandkth;

import android.widget.Toast;

import java.util.Random;

/**
 * Created by korha on 11/12/2017.
 */

class Checker{

    Random random;
    Player player;
    Toast toast;




    public Checker(){

        random = new Random();


    }


    public void turnChecker(){
        if(player.getTime().getTurns() == 0){
            player.getTime().setMonth(player.getTime().getMonth() + 1);
            if(player.getJob() != null) {
                player.setMoney(player.getMoney() + player.getJob().getPay());
                if (player.getHouse() != null)
                    player.setMoraleModifier(player.getHouse().getMoraleModifier() + 1);
                else
                    player.setMoraleModifier(0);
            }
            else{
                if(player.getHouse()!=null)
                    player.setMoraleModifier(player.getHouse().getMoraleModifier());
                else
                    player.setMoraleModifier(-2);
            }
            player.setMorale(player.getMorale()+player.getMoraleModifier());

            if(player.getTravelCardMonths()>0){
                player.setTravelCardMonths(player.getTravelCardMonths()-1);
                player.setTurnNumber(6);
            }
            else
                player.setTurnNumber(5);

            if(player.getFoodForMoths()==0){
                player.setTurnModifier(-2);
                player.getTime().setTurns(player.getTurnNumber()+player.getTurnModifier());
                //Toast.makeText(MainActivity.this, "You didn't eat last month so your turn number decreased.", Toast.LENGTH_LONG).show();
                //MainActivity.changeMainText("You didn't eat last month so your turn number decreased.");
            }
            else{
                player.setFoodForMoths(player.getFoodForMoths()-1);
                player.getTime().setTurns(player.getTurnNumber());
            }



        }
        else
            return;
    }



}
