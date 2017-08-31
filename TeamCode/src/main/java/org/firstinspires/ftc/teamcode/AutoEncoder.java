package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name = "AutoEcoder")
public class AutoEncoder extends LinearOpMode{
    DcMotor motorL;
    DcMotor motorR;
    static float fullEncoder = 1440.0f;

    @Override
    public void runOpMode() throws InterruptedException {
        motorL = hardwareMap.dcMotor.get("motorLeft");
        motorR = hardwareMap.dcMotor.get("motorRight");
        motorR.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        telemetry.addData("Half rotation: ", "");
        telemetry.update();
        moveForRotations(0.5f);
<<<<<<< HEAD
        Thread.sleep(1000);
        moveForRotations(2.0f);
        Thread.sleep(200);
        moveForRotations(1.0f);
=======
        Thread.sleep(3000);
        telemetry.addData("test of 10 inches: ", "");
        telemetry.update();
        moveForInches(10f);
>>>>>>> a549f48f9135937055ed2d1124743cd5497b8c08
    }

    public void startAllMotors(){
        motorL.setPower(1);
        motorR.setPower(1);
    }

    public void moveForInches(float inches) {
        moveForRotations(inches/12f);
    }

    public void moveForRotations(float input) {
        int rot = Math.round(input * fullEncoder);

        int startEncoderCount = motorL.getCurrentPosition();

        while (motorL.getCurrentPosition() <= startEncoderCount+rot && opModeIsActive()) {
            startAllMotors();
            telemetry.addData("in while loop: ", motorL.getCurrentPosition());
            telemetry.update();
        }
        motorL.setPower(0);
        motorR.setPower(0);
    }
}