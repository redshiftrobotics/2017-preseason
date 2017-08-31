package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "MainAuto")
public class MainAuto extends LinearOpMode {
    DcMotor motorL;
    DcMotor motorR;
    static float fullEncoder = 1440.0f;
    Movement movement;

    @Override
    public void runOpMode() throws InterruptedException {
        motorL = hardwareMap.dcMotor.get("motorLeft");
        motorR = hardwareMap.dcMotor.get("motorRight");
        motorR.setDirection(DcMotorSimple.Direction.REVERSE);

        movement = new Movement(hardwareMap.i2cDeviceSynch.get("imu"), motorL, motorR, telemetry, this);

        waitForStart();

        telemetry.addData("moving forward 56 inches", "");
        telemetry.update();
        moveForInches(56);

        telemetry.addData("turning right", "");
        telemetry.update();
        turn(90f);

        telemetry.addData("moving forward 93 inches", "");
        telemetry.update();
        moveForInches(93);

        telemetry.addData("turning right", "");
        telemetry.update();
        turn(180f);

        telemetry.addData("moving forward 40 inches", "");
        telemetry.update();
        moveForInches(90);

        telemetry.addData("turning right", "");
        telemetry.update();
        turn(270f);

        telemetry.addData("moving forward 98 inches", "");
        telemetry.update();
        moveForInches(120);

        telemetry.addData("turning right", "");
        telemetry.update();
        turn(360f);

        telemetry.addData("moving forward 40 inches", "");
        telemetry.update();
        moveForInches(40);
    }

    public void startAllMotors(){
        motorL.setPower(0.5);
        motorR.setPower(0.5);
    }

    public void moveForInches(float inches) {
        moveForRotations(inches/12f);
    }

    public void turn(float degrese) {
        movement.turn(degrese);
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
