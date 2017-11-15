package com.example.tmp_sda_1138.fikalandkth;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

//    Button educationButton;
//    Button languageButton;
//    Button jobButton;
//    Button houseButton;
//    Button socializeButton;
//    Button otherButton;
//    Button eatButton;
      Button infoButton;

//    String clickName;
//
//    EducationMenu educationMenu;
//    LanguagesMenu languagesMenu;
//    JobMenu jobsMenu;
//    HousingMenu housingMenu;
//    SocializeMenu socializeMenu;
//    OtherMenu otherMenuO;
//    BuyMenu buyingMenu;


    View mainMenu;
    View eduMenu;
    View langMenu;
    View jobMenu;
    View houseMenu;
    View socialMenu;
    View otherMenu;
    View buyMenu;
    View dateFinalMenu;
    View nameScreen;
    View topSide;
    View searchJob;
    View houseSelection;
    View playerStatsPage;

    String currentView;

    TextView playerMoney;
    TextView playerMorale;
    TextView playerMonths;
    TextView playerTurns;
    TextView playerPoints;
    static TextView mainText;
    String mainString;
    TextView technicalSkill;
    TextView socialSkill;
    TextView swedishSkill;
    TextView englishSkill;
    TextView playerName;
    TextView job1;
    TextView job2;
    TextView job3;
    TextView house1;
    TextView house2;
    TextView house3;

    TextView nameF;
    TextView moneyF;
    TextView moraleF;
    TextView monthsF;
    TextView turnsLeftF;
    TextView techF;
    TextView socialF;
    TextView swedishF;
    TextView englishF;
    TextView friendsF;
    TextView datingF;
    TextView marriedF;
    TextView kidsF;
    TextView salaryF;
    TextView houseTypeF;
    TextView rentF;
    TextView roomsF;
    TextView moraleModifierF;
    TextView turnModifierF;


    EditText dateNumber;
    EditText nameText;



    Player player;
    Controller controller;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
//
//        educationButton = (Button)findViewById(R.id.educationButton);
//        languageButton = (Button) findViewById(R.id.languageButton);
//        jobButton = (Button) findViewById(R.id.jobButton);
//        houseButton = (Button) findViewById(R.id.housingButton);
//        socializeButton = (Button) findViewById(R.id.socializeButton);
//        otherButton = (Button) findViewById(R.id.otherButton);
//        eatButton = (Button) findViewById(R.id.eatButton);
        infoButton = (Button) findViewById(R.id.infoButton);

        mainString = "What do you want to do?";
        playerMoney = (TextView) findViewById(R.id.moneyText);
        playerMorale = (TextView) findViewById(R.id.moraleText);
        playerMonths =  (TextView) findViewById(R.id.playerMonths);
        playerTurns =  (TextView) findViewById(R.id.playerTurns);
        playerPoints = (TextView) findViewById(R.id.playerPoints);
        mainText = (TextView) findViewById(R.id.mainText);
        playerName = (TextView) findViewById(R.id.playerName);

        dateNumber = (EditText) findViewById(R.id.dateNumber);

        controller = new Controller();
        //player = controller.getPlayer();

        currentView = "main";
        mainMenu = findViewById(R.id.mainMenu);
        eduMenu = findViewById(R.id.educationMenu);
        langMenu = findViewById(R.id.languagesMenu);
        jobMenu = findViewById(R.id.jobMenu);
        houseMenu = findViewById(R.id.houseMenu);
        socialMenu = findViewById(R.id.socializeMenu);
        otherMenu = findViewById(R.id.otherMenu);
        buyMenu = findViewById(R.id.buyMenu);
        dateFinalMenu = findViewById(R.id.dateFinalMenu);
        topSide = findViewById(R.id.topSide);
        searchJob = findViewById(R.id.jobSearch);
        houseSelection = findViewById(R.id.houseSearch);
        playerStatsPage = findViewById(R.id.playerStats);


        nameScreen = findViewById(R.id.nameScreen);

        technicalSkill = (TextView) findViewById(R.id.techNumber);
        socialSkill = (TextView) findViewById(R.id.socialNumber);
        swedishSkill = (TextView) findViewById(R.id.swedishNumber);
        englishSkill = (TextView) findViewById(R.id.englishNumber);


        nameText = (EditText) findViewById(R.id.nameText);

        job1 = (TextView) findViewById(R.id.job1);
        job2 = (TextView) findViewById(R.id.job2);
        job3 = (TextView) findViewById(R.id.job3);

        house1 = (TextView) findViewById(R.id.house1);
        house2 = (TextView) findViewById(R.id.house2);
        house3 = (TextView) findViewById(R.id.house3);

        nameF = (TextView) findViewById(R.id.nameF);
        moraleF = (TextView) findViewById(R.id.moraleF);
        moneyF = (TextView) findViewById(R.id.moneyF);
        monthsF = (TextView) findViewById(R.id.monthsF);
        turnsLeftF = (TextView) findViewById(R.id.turnsLeftF);
        techF = (TextView) findViewById(R.id.technicalSkillsF);
        socialF = (TextView) findViewById(R.id.socialSkillsF);
        swedishF = (TextView) findViewById(R.id.swedishLevelF);
        englishF = (TextView) findViewById(R.id.englishLevelF);
        friendsF = (TextView) findViewById(R.id.friendsF);
        datingF = (TextView) findViewById(R.id.isDatingF);
        marriedF = (TextView) findViewById(R.id.isMarriedF);
        kidsF = (TextView) findViewById(R.id.numberOfKidsF);
        salaryF = (TextView) findViewById(R.id.salaryF);
        houseTypeF = (TextView) findViewById(R.id.houseTypeF);
        rentF = (TextView) findViewById(R.id.rentF);
        roomsF = (TextView) findViewById(R.id.roomsF);
        moraleModifierF = (TextView) findViewById(R.id.currentMonthlyMorakleModifierF);
        turnModifierF = (TextView) findViewById(R.id.turnModifierF);




        updateTopView();

    }

    /**
     * Main and menu screens player stats updater
     */
    public void updateTopView(){
        playerMoney.setText(controller.player.getMoney()+"");
        playerMonths.setText(controller.player.getTime().getMonth()+"");
        playerTurns.setText(controller.player.getTime().getTurns()+"");
        playerMorale.setText(controller.player.getMorale()+"");
        playerPoints.setText(controller.player.getScore()+"");
        technicalSkill.setText(controller.player.getTechnicalEducation()+"");
        socialSkill.setText(controller.player.getSocialEducation()+"");
        swedishSkill.setText(controller.player.getSwedishLevel()+"");
        englishSkill.setText(controller.player.getEnglishLevel()+"");
        playerName.setText(controller.player.getName());

    }

    public void startGame(View view){
        if (nameText.getText().length()==0)
            nameText.setError("Please enter a number!");
        else {
            String name = nameText.getText().toString();
            controller.player.setName(name);
            nameScreen.setVisibility(View.INVISIBLE);
            topSide.setVisibility(View.VISIBLE);
            mainMenu.setVisibility(View.VISIBLE);
            infoButton.setVisibility(View.VISIBLE);
            updateTopView();

        }

    }









    /**
     * Main Menu Buttons
     * Making mainMenu invisible and the chosen Menu visible
     * Changes the mainText accordingly
     */

    public void educationClick(View view){
        mainMenu.setVisibility(View.INVISIBLE);
        eduMenu.setVisibility(View.VISIBLE);
        currentView = "education";
        mainText.setText("What do you want to study?");

    }

    public void languagesClick(View view){
        mainMenu.setVisibility(View.INVISIBLE);
        langMenu.setVisibility(View.VISIBLE);
        currentView = "language";
        mainText.setText("Which language do you want to study?");

    }

    public void jobClick(View view){
        mainMenu.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
        currentView = "job";
        mainText.setText("Which way are you going to use to find a job?");

    }

    public void housingClick(View view){
        mainMenu.setVisibility(View.INVISIBLE);
        houseMenu.setVisibility(View.VISIBLE);
        currentView = "housing";
        mainText.setText("Renting or buying?");

    }

    public void socializeClick(View view){
        mainMenu.setVisibility(View.INVISIBLE);
        socialMenu.setVisibility(View.VISIBLE);
        currentView = "socialize";
        mainText.setText("Where do you want to go to socialize?");

    }

    public void otherClick(View view){
        mainMenu.setVisibility(View.INVISIBLE);
        otherMenu.setVisibility(View.VISIBLE);
        currentView = "other";
        mainText.setText("Thinking about the future?");

    }

    public void buyClick(View view){
        otherMenu.setVisibility(View.INVISIBLE);
        buyMenu.setVisibility(View.VISIBLE);
        currentView = "buy";
        mainText.setText("You capitalist pig. What do you want to buy?");

    }

    /**
     * General button to return to previous menu
     * Also changes the mainText
     */

    public void mainMenu (View view){
        switch (currentView) {
            case "education":
                eduMenu.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                currentView = "main";
                mainText.setText(mainString);
                break;
            case "language":
                langMenu.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                currentView = "main";
                mainText.setText(mainString);
                break;
            case "job":
                jobMenu.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                currentView = "main";
                mainText.setText(mainString);
                break;
            case "housing":
                houseMenu.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                currentView = "main";
                mainText.setText(mainString);
                break;
            case "socialize":
                socialMenu.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                currentView = "main";
                mainText.setText(mainString);
                break;
            case "other":
                otherMenu.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                currentView = "main";
                mainText.setText(mainString);
                break;
            case "buy":
                buyMenu.setVisibility(View.INVISIBLE);
                otherMenu.setVisibility(View.VISIBLE);
                currentView = "other";
                mainText.setText(mainString);
                break;
            case "date":
                dateFinalMenu.setVisibility(View.INVISIBLE);
                socialMenu.setVisibility(View.VISIBLE);
                currentView = "socialize";
                mainText.setText("Where do you want to go to socialize?");
                break;
        }

    }



    /**
     * Education Menu redirections
     * The controller is reached from here
     */

    public void technicalEducationClick(View view){
        controller.getTechEducation();
        updateTopView();
    }

    public void socialEducationClick(View view){
        controller.getSocialEducation();
        updateTopView();
    }
    /**
     * Languages Menu redirections
     * The controller is reached from here
     */


    public void learnSwedishClick(View view){
        controller.learnSwedish();
        updateTopView();
    }

    public void learnEnglishClick(View view){
        controller.learnEnglish();
        updateTopView();
    }


    /**
     *
     * Socializing menu button redirections.
     */

    public void artClick(View view){

            controller.artClick();
            updateTopView();

    }

    public void concertClick(View view){

        controller.concertClick();
        updateTopView();

    }

    public void pubClick(View view){

        controller.pubClick();
        updateTopView();

    }

    public void danceClick(View view){

        controller.danceClick();
        updateTopView();

    }

    public void dateClick(View view){

        boolean didIhaveAnyFriends = controller.dateClick();
        if (didIhaveAnyFriends) {
            socialMenu.setVisibility(View.INVISIBLE);
            dateFinalMenu.setVisibility(View.VISIBLE);
            currentView ="date";
        }

        updateTopView();

    }

    public void dateFinalClick(View view) {
        if (dateNumber.getText().length()==0)
            dateNumber.setError("Please enter a number!");
        else {
            int index = Integer.parseInt(dateNumber.getText().toString()) - 1;
            String name = controller.startToDate(index);
            if (name == null) {
                controller.dateClick();
                String main = mainText.getText().toString();
                changeMainText("Please Enter A Correct Number This Time! " + main);
            } else {
                changeMainText("You started to date " + name + ".");
                dateFinalMenu.setVisibility(View.INVISIBLE);
                socialMenu.setVisibility(View.VISIBLE);
                currentView = "socialize";
            }

        }


    }


    /**
     * Changes the main text bubble's text to @param
     * @param text
     */


    public static void changeMainText(String text){
        mainText.setText(text);
    }

    /**
     * Other Menu Clicks
     */

    public void getMarried(View view){
        String name = controller.getMarried();
        if(name.equals("no")){
            changeMainText("You are already married or you are not dating anyone!");
        }
        else
            changeMainText("You are now married to " + name + ".");
        updateTopView();
    }

    public void haveKids(View view){
        int howMany = controller.haveKids();
        if (howMany == -1){
            changeMainText("You must be married to try to have kids.");
        }
        else if (howMany==0){
            changeMainText("It doesn't work every time. You can try again.");
        }
        else if(howMany == 1)
            changeMainText("You will have a baby. You can already count him/her in the family.");
        else
            changeMainText("You will have" + howMany +" baby. You can already count them in the family.");

        updateTopView();
    }
    public void eat(View view){
        String status = controller.eat();
        if (status.equals("already")){
            changeMainText("You have already eaten this month.");
        }
        else if(status.equals("ok")){
            changeMainText("You ate.");
        }
        else if(status.equals("nomoney")){
            changeMainText("You don't have enough money to eat.");
        }
        updateTopView();
    }

    /**
     * Buy Menu Clicks
     */

    public void travelCard(View view){
        if(controller.buyTravelCard())
            changeMainText("You now have +1 turns for "+ controller.player.getTravelCardMonths()+" months." );
        else
            changeMainText("You can't pay for that.");
        updateTopView();
    }

    public void foodMemberShip(View view){
        if(controller.buyFoodMembership()){
            changeMainText("You now have food for "+ controller.player.getFoodForMoths() + " months.");
        }
        else
            changeMainText("You can't pay for that.");
        updateTopView();
    }

    public void hobbyClick(View view){
        if (controller.buyHobby())
            changeMainText("You spent time on your hobbies. You morale increased.");
        else
            changeMainText("You can't pay for that!");

        updateTopView();
    }

    /**
     * Job Search Menu Clicks
     */
    public void arbetsClick(View view){
        controller.substractTurn();
        int randomExcuse = random.nextInt(5);
        switch (randomExcuse){
            case 0 :
               changeMainText("Sorry we can't help you, you must help yourself.");
               break;
            case 1 :
                changeMainText("Sorry, it's 13:00 and we are closed. Please come back soon.");
                break;
            case 2 :
                changeMainText("We called you last weekend yelling out of the window, you didn't respond so we deleted you from our database, you don't exist anymore, sorry.");
                break;
            case 3 :
                changeMainText("We will call you soon for a meeting. Maybe.");
                break;
            case 4 :
                changeMainText("We can't help you find a job, you must do it yourself. We are the masters of the Swedish job-market. You want some apples?");
                break;
        }
        updateTopView();

    }


    public void searchJob(View view){
        boolean isEligeable = controller.checkMoraleEligebility();
        if(isEligeable){
            jobMenu.setVisibility(View.INVISIBLE);
            searchJob.setVisibility(View.VISIBLE);
            ArrayList<String> jobTexts = controller.createThreeJobs();
            int i=0;
            job1.setText(jobTexts.get(0));
            job2.setText(jobTexts.get(1));
            job3.setText(jobTexts.get(2));
            changeMainText("Which job do you want to apply to?");

        }
        else
            changeMainText("You need to have min.50 morale to apply for a job.");
        updateTopView();
    }

    public void getJob1(View view){
        boolean gotTheJob = controller.getJob1();
        if(gotTheJob)
            changeMainText("Congratulations you got the job.");
        else
            changeMainText("Please check your skills and apply for a job that suits your skills.");
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
        updateTopView();
    }

    public void getJob2(View view){
        boolean gotTheJob = controller.getJob2();
        if(gotTheJob)
            changeMainText("Congratulations you got the job.");
        else
            changeMainText("Please check your skills and apply for a job that suits your skills.");
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
        updateTopView();
    }

    public void getJob3(View view){
        boolean gotTheJob = controller.getJob3();
        if(gotTheJob)
            changeMainText("Congratulations you got the job.");
        else
            changeMainText("Please check your skills and apply for a job that suits your skills.");
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
        updateTopView();
    }

    public void backJobSearch(View view){
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
        updateTopView();
    }
/**
 * House Menu Clicks
 */
    public void  rentRoomClick(View view){
        boolean didRent = controller.rentRoom();
        if (didRent){
            changeMainText("You did rent a room, in the central part of the city. Your rent is 6000kr");
        }
        else
            changeMainText("You couldn't rent a room because you already have a room or better, or you are just missing the money.");
        updateTopView();
    }

    public void rentFlatClick(View view){
        boolean isEligeableToRent = controller.isEligeableToRent();
        if (isEligeableToRent){
            ArrayList<Integer> details = controller.rentFlat();
            changeMainText("You did rent a flat, it has " + details.get(0) + " rooms and it costs " + details.get(1) + " kr, you can not really choose what you want to rent in Sweden.");
        }
        else
            changeMainText("You couldn't rent a flat because you already have a flat or better or you have a salary less then 20000kr.");
        updateTopView();
    }

    public void buyHouseClick(View view){
        boolean isEligeable = controller.canIbuyAHouse();
        if(isEligeable){
            houseMenu.setVisibility(View.INVISIBLE);
            houseSelection.setVisibility(View.VISIBLE);
            ArrayList<String> houseTexts = controller.createThreeHouses();

            house1.setText(houseTexts.get(0));
            house2.setText(houseTexts.get(1));
            house3.setText(houseTexts.get(2));
            changeMainText("Which house do you want to buy?");

        }
        else
            changeMainText("You need to be working and have min.200000kr to be able to buy a flat.");
        updateTopView();

    }

    public void getHouse1(View view){
        boolean gotTheHouse = controller.getHouse1();
        if(gotTheHouse)
            changeMainText("Congratulations you got the house.");
        else
            changeMainText("Good try. You don't have enough money to buy that house");
        houseSelection.setVisibility(View.INVISIBLE);
        houseMenu.setVisibility(View.VISIBLE);
        updateTopView();
    }

    public void getHouse2(View view){
        boolean gotTheHouse = controller.getHouse2();
        if(gotTheHouse)
            changeMainText("Congratulations you got the house.");
        else
            changeMainText("Good try. You don't have enough money to buy that house");
        houseSelection.setVisibility(View.INVISIBLE);
        houseMenu.setVisibility(View.VISIBLE);
        updateTopView();
    }

    public void getHouse3(View view){
        boolean gotTheHouse = controller.getHouse3();
        if(gotTheHouse)
            changeMainText("Congratulations you got the house.");
        else
            changeMainText("Good try. You don't have enough money to buy that house");
        houseSelection.setVisibility(View.INVISIBLE);
        houseMenu.setVisibility(View.VISIBLE);
        updateTopView();
    }

    public void backHouseSearch(View view){
        controller.backFromHouseSearch();
        houseSelection.setVisibility(View.INVISIBLE);
        houseMenu.setVisibility(View.VISIBLE);
    }

    /**
     * Player Details Page
     */

    public void sClicked(View view){
        playerStatsPage.setVisibility(View.VISIBLE);
        nameF.setText(nameF.getText() + controller.getPlayer().getName());
        moneyF.setText(moneyF.getText() + String.valueOf(controller.getPlayer().getMoney()));
        moraleF.setText(moraleF.getText() + String.valueOf(controller.getPlayer().getMorale()));
        monthsF.setText(monthsF.getText() + String.valueOf(controller.getPlayer().getTime().getMonth()));
        turnsLeftF.setText(turnsLeftF.getText() + String.valueOf(controller.getPlayer().getTime().getTurns()));
        techF.setText(techF.getText() + String.valueOf(controller.getPlayer().getTechnicalEducation()));
        socialF.setText(socialF.getText() + String.valueOf(controller.getPlayer().getSocialEducation()));
        swedishF.setText(swedishF.getText() + String.valueOf(controller.getPlayer().getSwedishLevel()));
        englishF.setText(englishF.getText() + String.valueOf(controller.getPlayer().getEnglishLevel()));
        for (int i=0;i<controller.getPlayer().getFriends().size();i++){
            String temp = controller.getPlayer().getFriend(i);
            friendsF.setText(friendsF.getText()+temp);
            if(i<=controller.getPlayer().getFriends().size()-1){
                friendsF.setText(friendsF.getText()+", ");
            }
        }
        if(!controller.getPlayer().getDateName().equals("No")){
            datingF.setText(datingF.getText() + controller.getPlayer().getDateName());
        }
        else
            datingF.setText(datingF.getText() + "No date.");

        if(!controller.getPlayer().getDateName().equals("No")){
            marriedF.setText(marriedF.getText() + controller.getPlayer().getPartnerName());
        }
        else
            marriedF.setText(marriedF.getText() + "No partner.");

        kidsF.setText(kidsF.getText() + String.valueOf(controller.getPlayer().getNumberOfChildren()));
        try{
            salaryF.setText(salaryF.getText() + String.valueOf(controller.getPlayer().getJob().getPay()));
        }
        catch (Exception e){
            salaryF.setText(salaryF.getText() + "No Job.");
        }
        try{
            if(controller.getPlayer().getHouse().isSocialRoom)
                houseTypeF.setText(houseTypeF.getText() + "State payed room.");
            else if (controller.getPlayer().getHouse().isRent()){
                houseTypeF.setText(houseTypeF.getText() + "Rental house.");
            }
            else if (controller.getPlayer().getHouse().isRoom()){
                houseTypeF.setText(houseTypeF.getText() + "Rental room.");
            }
            else if (controller.getPlayer().getHouse().isForSale()){
                houseTypeF.setText(houseTypeF.getText() + "You own your house.");
            }
            rentF.setText(rentF.getText() + String.valueOf(controller.getPlayer().getHouse().getRent()));
            roomsF.setText(roomsF.getText() + String.valueOf(controller.getPlayer().getHouse().getRoom()));

        }
        catch (Exception e){
            houseTypeF.setText(houseTypeF.getText() + "You don't have housing.");
            rentF.setText(rentF.getText() + "0");
            roomsF.setText(roomsF.getText() + "Null.");
        }

        moraleModifierF.setText(moraleModifierF.getText() + String.valueOf(controller.getPlayer().getMoraleModifier()));

        turnModifierF.setText(turnModifierF.getText() + String.valueOf( controller.getPlayer().getTurnModifier()));



    }

    public void backFromStats(View view){
        playerStatsPage.setVisibility(View.INVISIBLE);
        nameF.setText("Name:");
        moneyF.setText("Money:");
        moraleF.setText("Morale:");
        monthsF.setText("Month:");
        turnsLeftF.setText("Turns Left:");
        techF.setText("Technical Skills:");
        socialF.setText("Social Skills:");
        swedishF.setText("Swedish Level:");
        englishF.setText("English Level:");
        friendsF.setText("Friends:");
        datingF.setText("Is dating:");
        marriedF.setText("Partner name:");
        kidsF.setText("Number of kids:");
        salaryF.setText("Salary:");
        houseTypeF.setText("House type:");
        rentF.setText("Rent:");
        roomsF.setText("Rooms:");
        moraleModifierF.setText("Current Monthly Morale Modifier:");
        turnModifierF.setText("Current Turn Modifier:");
    }

}

