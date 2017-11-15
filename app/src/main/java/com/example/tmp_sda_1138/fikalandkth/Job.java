package com.example.tmp_sda_1138.fikalandkth;

/**
 * Created by tmp-sda-1138 on 11/6/17.
 */

class Job {

    int pay;
    String type;
    int requiredTech;
    int requiredSocial;
    int requiredSwedish;
    int requiredEnglish;

    public Job(int pay, String type, int requiredTech, int requiredSocial, int requiredSwedish, int requiredEnglish) {

        this.pay = pay;
        this.type = type;
        this.requiredTech = requiredTech;
        this.requiredSocial = requiredSocial;
        this.requiredSwedish = requiredSwedish;
        this.requiredEnglish = requiredEnglish;
    }

    public int getPay() {
        return pay;
    }

    public String getType() {
        return type;
    }

    public int getRequiredTech() {
        return requiredTech;
    }

    public int getRequiredSocial() {
        return requiredSocial;
    }

    public int getRequiredSwedish() {
        return requiredSwedish;
    }

    public int getRequiredEnglish() {
        return requiredEnglish;
    }
}
