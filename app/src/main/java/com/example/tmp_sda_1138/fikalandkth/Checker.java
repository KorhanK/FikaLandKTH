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

            if(player.getTravelCardMonths()>0){
                player.setTravelCardMonths(player.getTravelCardMonths()-1);
                player.setTurnNumber(6);
            }
            else
                player.setTurnNumber(5);

            if(player.getFoodForMoths()==0){
                player.getTime().setTurns(player.getTurnNumber()-2);
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
