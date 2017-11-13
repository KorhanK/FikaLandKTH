package com.example.tmp_sda_1138.fikalandkth;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    Button educationButton;
    Button languageButton;
    Button jobButton;
    Button houseButton;
    Button socializeButton;
    Button otherButton;
    Button eatButton;
    Button infoButton;

    String clickName;

    EducationMenu educationMenu;
    LanguagesMenu languagesMenu;
    JobMenu jobsMenu;
    HousingMenu housingMenu;
    SocializeMenu socializeMenu;
    OtherMenu otherMenuO;
    BuyMenu buyingMenu;


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

    EditText dateNumber;
    EditText nameText;



    Player player;
    Controller controller;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        educationButton = (Button)findViewById(R.id.educationButton);
        languageButton = (Button) findViewById(R.id.languageButton);
        jobButton = (Button) findViewById(R.id.jobButton);
        houseButton = (Button) findViewById(R.id.housingButton);
        socializeButton = (Button) findViewById(R.id.socializeButton);
        otherButton = (Button) findViewById(R.id.otherButton);
        eatButton = (Button) findViewById(R.id.eatButton);
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
        player = controller.getPlayer();

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

        nameScreen = findViewById(R.id.nameScreen);

        technicalSkill = (TextView) findViewById(R.id.techNumber);
        socialSkill = (TextView) findViewById(R.id.socialNumber);
        swedishSkill = (TextView) findViewById(R.id.swedishNumber);
        englishSkill = (TextView) findViewById(R.id.englishNumber);


        nameText = (EditText) findViewById(R.id.nameText);

        job1 = (TextView) findViewById(R.id.job1);
        job2 = (TextView) findViewById(R.id.job2);
        job3 = (TextView) findViewById(R.id.job3);


        updateTopView();

    }

    /**
     * Main and menu screens player stats updater
     */
    public void updateTopView(){
        playerMoney.setText(player.getMoney()+"");
        playerMonths.setText(player.getTime().getMonth()+"");
        playerTurns.setText(player.getTime().getTurns()+"");
        playerMorale.setText(player.getMorale()+"");
        playerPoints.setText(player.getScore()+"");
        technicalSkill.setText(player.getTechnicalEducation()+"");
        socialSkill.setText(player.getSocialEducation()+"");
        swedishSkill.setText(player.getSwedishLevel()+"");
        englishSkill.setText(player.getEnglishLevel()+"");
        playerName.setText(player.getName());

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
                currentView = "social";
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

    }

    public void getJob1(View view){
        boolean gotTheJob = controller.getJob1();
        if(gotTheJob)
            changeMainText("Congratulations you got the job.");
        else
            changeMainText("Please check your skills and apply for a job that suits your skills.");
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
    }

    public void getJob2(View view){
        boolean gotTheJob = controller.getJob2();
        if(gotTheJob)
            changeMainText("Congratulations you got the job.");
        else
            changeMainText("Please check your skills and apply for a job that suits your skills.");
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
    }

    public void getJob3(View view){
        boolean gotTheJob = controller.getJob3();
        if(gotTheJob)
            changeMainText("Congratulations you got the job.");
        else
            changeMainText("Please check your skills and apply for a job that suits your skills.");
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
    }

    public void backJobSearch(View view){
        searchJob.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);
    }


}

