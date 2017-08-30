package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Owen Sangster on 8/29/2017.
 */
@Autonomous(name = "RampStop")
public class RampStop extends LinearOpMode {

    DcMotor Left;
    DcMotor Right;
    ColorSensorData color;
    int Counter = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        Left = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");
        Left.setDirection(DcMotorSimple.Direction.REVERSE);
        ColorSensor cs = hardwareMap.colorSensor.get("cs");
        color = new ColorSensorData(cs);
        waitForStart();
        Left.setPower(0.2);
        Right.setPower(0.2);

        while(Counter!=3 && opModeIsActive()){
            telemetry.addData("Counter", Counter);
            telemetry.update();
            if (color.GetColor() == "Red" && Counter == 0){
                Counter ++;
            }
            else if(color.GetColor() == "Blue" && Counter == 1){
                Counter ++;
            }
            else if(color.GetColor() == "Red" && Counter == 2){
                Counter ++;
            }
            else if(color.GetColor() == "Neither"){
                Counter = 0;
            }

        }

        Left.setPower(0);
        Right.setPower(0);

    }
}
