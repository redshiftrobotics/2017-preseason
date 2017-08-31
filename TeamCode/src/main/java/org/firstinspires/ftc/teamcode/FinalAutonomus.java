package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

/**
 * Created by Owen Sangster on 8/30/2017.
 */
@Autonomous(name = "Final Auto")
public class FinalAutonomus extends LinearOpMode {

    DcMotor motorL;
    DcMotor motorR;
    ColorSensorData color;
    static float fullEncoder = 1440.0f;
    int Counter = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        motorL = hardwareMap.dcMotor.get("motorLeft");
        motorR = hardwareMap.dcMotor.get("motorRight");
        motorL.setDirection(DcMotorSimple.Direction.REVERSE);
        ColorSensor cs = hardwareMap.colorSensor.get("cs");
        color = new ColorSensorData(cs);
        I2cDeviceSynch imu = hardwareMap.i2cDeviceSynch.get("imu");
        Movement movement = new Movement(imu, motorL, motorR, telemetry, this);
        waitForStart();

        float angleCounter = 0f;
        moveForInches(40);
        //Turn right 90
        angleCounter += 90;
        movement.turn(angleCounter % 360);

        moveForInches(100);
        //turn right 90
        angleCounter += 90;
        movement.turn(angleCounter % 360);

        moveForInches(35);
        //turn right 90
        angleCounter += 90;
        movement.turn(angleCounter % 360);

        moveForInches(110);

        angleCounter += 90;
        movement.turn(angleCounter % 360);

        motorL.setPower(0.2);
        motorR.setPower(0.2);

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

        motorL.setPower(0);
        motorR.setPower(0);



    }
    public void startAllMotors(){
        motorL.setPower(0.5);
        motorR.setPower(0.5);
    }

    public void moveForInches(float inches) {
        moveForRotations(inches/12f);
    }

    public void moveForRotations(float input) {
        int rot = Math.round(input * fullEncoder);

        int startEncoderCount = motorL.getCurrentPosition();

        while (motorL.getCurrentPosition() <= startEncoderCount + rot && opModeIsActive()) {
            startAllMotors();
            telemetry.addData("in while loop: ", motorL.getCurrentPosition());
            telemetry.update();
        }
        motorL.setPower(0);
        motorR.setPower(0);
    }
}
