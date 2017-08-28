package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Owen Sangster on 8/28/2017.
 */

public class ColorSensorData {
    private ColorSensor cs;

    public ColorSensorData(ColorSensor colorSensor){
        cs = colorSensor;
    }

    public String GetColor(){
        if (cs.red() > 3){
            return "Red";
        }else if(cs.blue() > 3){
            return "Blue";
        }else{
            return "Neither";
        }
    }
}
