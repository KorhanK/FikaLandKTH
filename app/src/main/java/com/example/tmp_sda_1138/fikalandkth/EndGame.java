package com.example.tmp_sda_1138.fikalandkth;

/**
 * Created by korha on 11/18/2017.
 */

class EndGame {

    String type;
    int points;
    int money;

    public EndGame(String type, int points, int money) {
        this.type = type;
        this.points = points;
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }
}
