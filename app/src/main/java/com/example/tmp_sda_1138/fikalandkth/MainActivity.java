package com.example.tmp_sda_1138.fikalandkth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button educationButton;
    Button languageButton;
    Button jobButton;
    Button houseButton;
    Button socializeButton;
    Button otherButton;
    Button eatButton;

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

    EditText dateNumber;



    Player player;
    Controller controller;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        educationButton = (Button)findViewById(R.id.educationButton);
        languageButton = (Button) findViewById(R.id.languageButton);
        jobButton = (Button) findViewById(R.id.jobButton);
        houseButton = (Button) findViewById(R.id.housingButton);
        socializeButton = (Button) findViewById(R.id.socializeButton);
        otherButton = (Button) findViewById(R.id.otherButton);
        eatButton = (Button) findViewById(R.id.eatButton);

        mainString = "What do you want to do?";
        playerMoney = (TextView) findViewById(R.id.moneyText);
        playerMorale = (TextView) findViewById(R.id.moraleText);
        playerMonths =  (TextView) findViewById(R.id.playerMonths);
        playerTurns =  (TextView) findViewById(R.id.playerTurns);
        playerPoints = (TextView) findViewById(R.id.playerPoints);
        mainText = (TextView) findViewById(R.id.mainText);

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

        technicalSkill = (TextView) findViewById(R.id.techNumber);
        socialSkill = (TextView) findViewById(R.id.socialNumber);
        swedishSkill = (TextView) findViewById(R.id.swedishNumber);
        englishSkill = (TextView) findViewById(R.id.englishNumber);







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
        controller.dateClick();
        updateTopView();

    }



    public static void changeMainText(String text){
        mainText.setText(text);
    }

//
//    public String getClickName() {
//        return clickName;
//    }
}

