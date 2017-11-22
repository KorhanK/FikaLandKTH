package com.example.tmp_sda_1138.fikalandkth;

import java.util.ArrayList;

/**
 * Created by korha on 11/3/2017.
 */

class Player {
    private String name;

    private int money;
    private int morale;
    private int technicalEducation;
    private int socialEducation;
    private int swedishLevel;
    private int englishLevel;

    boolean isMarried;
    private int numberOfChildren;
    private String dateName = "no";
    private String partnerName = "no";

    private Job job;
    private House house;

    private ArrayList<String> friends;

    private int points;

    private Time time;

    private NameList nameList;

    private int turnNumber = 5;

    private int foodForMoths=0;
    int travelCardMonths=0;

    private int moraleModifier;

    private int turnModifier;




    public Player(int money, int morale, int englishLevel, int technicalEducation, int socialEducation, int swedishLevel) {

        this.setMoney(money);
        this.morale = morale;

        this.englishLevel = englishLevel;
        this.isMarried = false;
        this.points = 0;
        this.technicalEducation = technicalEducation;
        this.socialEducation = socialEducation;
        friends = new ArrayList<String>();
        time = new Time(0, 5);
        //achievements = new ArrayList<String>();
        nameList = new NameList();
        travelCardMonths = 0;
        this.swedishLevel = swedishLevel;
        this.house = null;
        this.moraleModifier=-2;
    }


    /**
     * Getters and setters for the whole Player class
     *
     */


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }



    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getTechnicalEducation() {
        return technicalEducation;
    }

    public void setTechnicalEducation(int technicalEducation) {
        this.technicalEducation = technicalEducation;
    }

    public int getSocialEducation() {
        return socialEducation;
    }

    public void setSocialEducation(int socialEducation) {
        this.socialEducation = socialEducation;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getSwedishLevel() {
        return swedishLevel;
    }

    public void setSwedishLevel(int swedishLevel) {
        this.swedishLevel = swedishLevel;
    }

    public int getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(int englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getFoodForMoths() {
        return foodForMoths;
    }

    public void setFoodForMoths(int foodForMoths) {
        this.foodForMoths = foodForMoths;
    }

    public int getTravelCardMonths() {
        return travelCardMonths;
    }

    public void setTravelCardMonths(int travelCardMonths) {
        this.travelCardMonths = travelCardMonths;
    }

    public int getMoraleModifier() {
        return moraleModifier;
    }

    public void setMoraleModifier(int moraleModifier) {
        this.moraleModifier = moraleModifier;
    }

    public NameList getNameList() {
        return nameList;
    }



    /**
     * Friends list methods.
     */

    public void addFriend(String name){
        friends.add(name);
    }

    public int friendsSize(){
        return friends.size();
    }

    public String getFriend(int index){
        return friends.get(index);
    }

    public String getDateName() {
        return dateName;
    }

    public void removeFriend(int index){
        friends.remove(index);
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public int getTurnModifier() {
        return turnModifier;
    }

    public void setTurnModifier(int turnModifier) {
        this.turnModifier = turnModifier;
    }


}