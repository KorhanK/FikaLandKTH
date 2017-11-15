package com.example.tmp_sda_1138.fikalandkth;

import java.util.Random;

/**
 * Created by tmp-sda-1138 on 11/6/17.
 */

class House {
    boolean isRent = false;
    boolean isRoom = false;
    boolean isForSale = false;
    boolean isSocialRoom = false;

    int room;
    int moraleModifier;

    int rent;
    int deposit;

    static Random random = new Random();


    public House(boolean isSocialRoom, boolean isRoom, boolean isRent, boolean isForSale, int room, int rent, int deposit, int moraleModifier){
        this.isSocialRoom = isSocialRoom;
        this.isRoom = isRoom;
        this.isRent = isRent;
        this.isForSale = isForSale;
        this.room = room;
        this.rent = rent;
        this.deposit = deposit;
        this.moraleModifier = moraleModifier;

    }

    public static int rentCalc(boolean isSocialRoom, boolean isRoom, boolean isRent, boolean isForSale, int room){
        int rent=0;
        if (isSocialRoom)
            rent = 0;
        else if(isRoom){
            rent = 6000;
        }
        else if (isRent){

            rent = ((room)*random.nextInt(4000)) + 10001;
        }
        else if (isForSale){
            rent = (room)*(random.nextInt(2000) + 2000);
        }

        if (rent > 20000)
            rent = 20000;

        return rent;

    }

    public static int depositCalc(int room){
        int deposit = (room*random.nextInt(50000)) + 200000;
        return deposit;
    }

    public static int moraleModifierCalc(int rent, int pay, boolean isForSale, boolean isSocialRoom){
        int moraleModifier=0;
        if (pay > rent/3){
            moraleModifier = 2;
        }
        if (isForSale){
            moraleModifier = moraleModifier + 2;
        }
        if (isSocialRoom){
            moraleModifier = moraleModifier - 2;
        }
        return  moraleModifier;
    }

    public boolean isSocialRoom() {
        return isSocialRoom;
    }

    public boolean isRent() {
        return isRent;
    }

    public boolean isRoom() {
        return isRoom;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public int getRoom() {
        return room;
    }

    public int getMoraleModifier() {
        return moraleModifier;
    }

    public int getRent() {
        return rent;
    }

    public int getDeposit() {
        return deposit;
    }
}
