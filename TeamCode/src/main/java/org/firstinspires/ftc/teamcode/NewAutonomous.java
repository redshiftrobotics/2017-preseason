package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

/**
 * Created by Owen Sangster on 8/24/2017.
 */

public class NewAutonomous extends LinearOpMode {

    DcMotor DcMotor1;
    DcMotor DcMotor2;

    ModernRoboticsI2cColorSensor colorSensor;

    // motor2
    @Override
    public void runOpMode() throws InterruptedException  {
        DcMotor1 = hardwareMap.dcMotor.get("motor2");
        colorSensor = hardwareMap.colorSensor.get("")

        waitForStart();

    }
}
