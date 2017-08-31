package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by matt on 8/28/17.
 */

public class Movement {
    BNO055IMU imu;
    public BNO055IMU.Parameters imuParameters;
    DcMotor m0;
    DcMotor m1;
    Telemetry tm;
    LinearOpMode opmode;
    Movement(I2cDeviceSynch imuHardware, DcMotor m0, DcMotor m1, Telemetry tm, LinearOpMode opmode) {

        imuParameters = new BNO055IMU.Parameters();
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imuParameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imu = new AdafruitBNO055IMU(imuHardware);
        imu.initialize(imuParameters);
        this.m0 = m0;
        this.m0.setDirection(DcMotorSimple.Direction.REVERSE);
        this.m1 = m1;
        this.tm = tm;
        this.opmode = opmode;
    }

    public float getAngle() {
        return this.imu.getAngularOrientation().firstAngle;
    }

    public void turn (float target) {
        float error;
        float motorValue;
        while (Math.abs(this.imu.getAngularOrientation().firstAngle - target) > 0.3 && opmode.opModeIsActive()) {
            error = target - imu.getAngularOrientation().firstAngle;
            motorValue = (error / 180);
            m0.setPower(motorValue);
            m1.setPower(-motorValue);
            tm.update();
        }
        m0.setPower(0);
        m1.setPower(0);
    }
}
