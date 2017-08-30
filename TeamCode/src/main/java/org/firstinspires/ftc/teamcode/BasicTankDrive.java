package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Owen Sangster on 8/29/2017.
 */
@TeleOp(name = "Teleop")
public class BasicTankDrive extends OpMode {

    DcMotor Left;
    DcMotor Right;

    @Override
    public void init() {

        Left = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");
        Left.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        Left.setPower(gamepad1.left_stick_y);
        Right.setPower(gamepad1.right_stick_y);

    }
}
