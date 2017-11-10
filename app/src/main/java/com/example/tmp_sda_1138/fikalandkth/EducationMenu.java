package com.example.tmp_sda_1138.fikalandkth;

import android.widget.TextView;

/**
 * Created by tmp-sda-1138 on 11/8/17.
 */

class EducationMenu extends MainActivity{

    TextView technicalSkill;
    TextView socialSkill;


    public EducationMenu(){
        //super();

    }

    public void techClick(){
        controller.getTechEducation();
        technicalSkill.setText(player.getTechnicalEducation()+"");
    }

}
