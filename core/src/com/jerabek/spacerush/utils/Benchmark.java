package com.jerabek.spacerush.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Tomas-PC on 24.12.2017.
 */

public class Benchmark {
    private long timestamp;
    private double deltaTimeUsed=0;
    private static String timeOn60Frames = "";
    private static String touchPosition = "";
    private static String printer;
    private Label label;
    private static int trigger = 1;

    public Benchmark() {
        label = new Label("Debug", new Fonts().getGothic64FontStyle());
        label.setSize(1080,180);
        label.setWrap(true);
        label.setPosition(0, 0);
        label.setAlignment(Align.left);
    }

    public Label getOutputLabel(){
        return label;
    }

    public void print(String outputText){
        printer = outputText;
    }

    public void updateBenchmarker(Vector3 touchPoint){
        updateFrameCounter();
        setTouchPosition(touchPoint);

        label.setText(timeOn60Frames + "\n" + touchPosition + "\n" + printer);
    }

    private void updateFrameCounter(){
        if (trigger>=60) {

            timeOn60Frames = "60 frames took " + (System.currentTimeMillis() - timestamp) + " seconds";

            trigger=0;
            timestamp = System.currentTimeMillis();
        }
        trigger++;
    }

    private void setTouchPosition(Vector3 touchPoint){
        touchPosition = "X: " + touchPoint.x + "| Y: " + touchPoint.y;
    }
}
