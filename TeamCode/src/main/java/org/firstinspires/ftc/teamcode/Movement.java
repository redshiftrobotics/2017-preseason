package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by matt on 8/28/17.
 */

public class Movement {
    BNO055IMU imu;
    BNO055IMU.Parameters imuParameters;
    DcMotor m0;
    DcMotor m1;
    Telemetry tm;
    Movement(I2cDeviceSynch imuHardware, DcMotor m0, DcMotor m1, Telemetry tm) {

        imuParameters = new BNO055IMU.Parameters();
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imuParameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imu = new AdafruitBNO055IMU(imuHardware);
        imu.initialize(imuParameters);
        this.m0 = m0;
        this.m1 = m1;
        this.tm = tm;
    }

    public float getAngle() {
        return this.imu.getAngularOrientation().firstAngle;
    }

    public void turn (float target) {
        while (Math.abs(this.imu.getAngularOrientation().firstAngle - target) > 0.3) {
            tm.addData("termination condition", Math.abs(this.imu.getAngularOrientation().firstAngle - target));
            m0.setPower(Math.max(Math.min(-((imu.getAngularOrientation().firstAngle - target)/180)+.2, -1), 1));
            m1.setPower(Math.max(Math.min(((imu.getAngularOrientation().firstAngle - target)/180)+.2, -1), 1));
            tm.addData("motor value:", (Math.max(Math.min(((imu.getAngularOrientation().firstAngle - target)/180)+.2, -1), 1)));
            tm.update();
        }
    }
}
