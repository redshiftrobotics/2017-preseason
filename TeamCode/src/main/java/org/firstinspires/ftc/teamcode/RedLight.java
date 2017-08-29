package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Owen Sangster on 8/29/2017.
 */
@Autonomous(name = "Stop light")
public class RedLight extends LinearOpMode {
    DcMotor Left;
    DcMotor Right;
    ColorSensorData color;

    @Override
    public void runOpMode() throws InterruptedException {
        Left = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");
        Left.setDirection(DcMotorSimple.Direction.REVERSE);
        ColorSensor cs = hardwareMap.colorSensor.get("cs");
        color = new ColorSensorData(cs);
        waitForStart();
        Left.setPower(0.5);
        Right.setPower(0.5);

        while(color.GetColor()!="Blue" && opModeIsActive()){

        }
        Left.setPower(0);
        Right.setPower(0);
    }


}
