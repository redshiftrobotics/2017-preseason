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
        moveForRotations(0.5f);
    }

    public void startAllMotors(){
        motorL.setPower(1);
        motorR.setPower(1);
    }

    public void moveForRotations(float input) {
        int rot = Math.round(input * fullEncoder);

        int startEncoderCount = motorL.getCurrentPosition();

        while (motorL.getCurrentPosition() <= startEncoderCount+rot) {
            startAllMotors();
            telemetry.addData("in while loop: ", motorL.getCurrentPosition());
            telemetry.update();
        }
    }
}