package com.example.tmp_sda_1138.fikalandkth;
import java.util.ArrayList;

/**
 * Created by korha on 11/3/2017.
 */

class Player {
    private String name;

    private int money;
    private int morale;
    private int luck;

     boolean isMarried;
    private int numberOfChildren;
    private Job job;
    private int technicalEducation;
    private int socialEducation;
    private ArrayList<String> friends;
    private int score;
    private House house;
    private int swedishLevel;
    private int englishLevel;
    private String dating = null;
    private int workingForMonths;
    private Time time;
    private ArrayList<String> achievements;
    private NameList nameList;

    public Player(int money, int morale, int luck, int englishLevel, int technicalEducation, int socialEducation) {
        //super();
        this.setMoney(money);
        this.morale = morale;
        this.luck = luck;
        this.englishLevel = englishLevel;
        this.isMarried = false;
        this.score = 0;
        this.technicalEducation = technicalEducation;
        this.socialEducation = socialEducation;
        friends = new ArrayList<String>();
        time = new Time(0, 5);
        achievements = new ArrayList<String>();
        nameList = new NameList();
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

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
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

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public String getDating() {
        return dating;
    }

    public void setDating(String dating) {
        this.dating = dating;
    }

    public int getWorkingForMonths() {
        return workingForMonths;
    }

    public void setWorkingForMonths(int workingForMonths) {
        this.workingForMonths = workingForMonths;
    }

    public ArrayList<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<String> achievements) {
        this.achievements = achievements;
    }

    public NameList getNameList() {
        return nameList;
    }

    public void addFriend(String name){
        friends.add(name);
    }

    public int friendsSize(){
        return friends.size();
    }

    public String getFriend(int index){
        return friends.get(index);
    }
}