package com.example.tmp_sda_1138.fikalandkth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    boolean running =true;

    TextView playerMoney;
    TextView playerMorale;
    TextView playerMonths;
    TextView playerTurns;
    TextView playerPoints;


    Player player;



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


        playerMoney = (TextView) findViewById(R.id.moneyText);
        playerMorale = (TextView) findViewById(R.id.moraleText);
        playerMonths =  (TextView) findViewById(R.id.playerMonths);
        playerTurns =  (TextView) findViewById(R.id.playerTurns);
        playerPoints = (TextView) findViewById(R.id.playerPoints);

        player = new Player();
        Controller controller = new Controller();

        player.setMoney(1717);

        updateTopView();





    }

//    public void educationClick(View view){
//
//
//
//    }

    public void updateTopView(){
        playerMoney.setText(player.getMoney()+"");
        playerMonths.setText(player.time.getMonth()+"");
        playerTurns.setText(player.time.getTurns()+"");


    }

    public void educationClick(View view){
        View mainMenu = findViewById(R.id.mainMenu);
        View eduMenu = findViewById(R.id.educationMenu);
        mainMenu.setVisibility(View.INVISIBLE);
        eduMenu.setVisibility(View.VISIBLE);

    }

    public void languagesClick(View view){
        View mainMenu = findViewById(R.id.mainMenu);
        View langMenu = findViewById(R.id.languagesMenu);
        mainMenu.setVisibility(View.INVISIBLE);
        langMenu.setVisibility(View.VISIBLE);

    }

    public void jobClick(View view){
        View mainMenu = findViewById(R.id.mainMenu);
        View jobMenu = findViewById(R.id.jobMenu);
        mainMenu.setVisibility(View.INVISIBLE);
        jobMenu.setVisibility(View.VISIBLE);

    }

    public void housingClick(View view){
        View mainMenu = findViewById(R.id.mainMenu);
        View houseMenu = findViewById(R.id.houseMenu);
        mainMenu.setVisibility(View.INVISIBLE);
        houseMenu.setVisibility(View.VISIBLE);

    }



}

