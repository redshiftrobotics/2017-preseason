package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Owen Sangster on 8/28/2017.
 */
@Autonomous(name="CSTest")
public class ColorSensorTest extends OpMode {

    ColorSensorData color;

    @Override
    public void init() {
        ColorSensor cs = hardwareMap.colorSensor.get("cs");
        color = new ColorSensorData(cs);

    }

    @Override
    public void loop() {
        telemetry.addData("Color", color.GetColor());
        telemetry.update();
    }
}
