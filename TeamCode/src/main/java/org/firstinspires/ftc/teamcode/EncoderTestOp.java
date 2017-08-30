package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name= "EncoderTestOp")
public class EncoderTestOp extends OpMode {
    DcMotor motorL;
    DcMotor motorR;

    @Override
    public void init() {
        motorL = hardwareMap.dcMotor.get("motorLeft");
        motorR = hardwareMap.dcMotor.get("motorRight");
        motorR.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        motorL.setPower(1);
        motorR.setPower(1);
        //telemetry.addData("mototrRight: ", motorR.getCurrentPosition());
        telemetry.addData("motorLeft: ", motorL.getCurrentPosition());
        telemetry.update();
    }
}
