package com.jerabek.spacerush.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Tomas-PC on 24.12.2017.
 */

public class Benchmarker {
    private long timestamp;
    private int frameCount=0;
    private double deltaTimeUsed=0;
    private String percentUsage = "N/A";
    private Label label, spammer;

    public Benchmarker(OrthographicCamera cam) {
        label = new Label("output", new Fonts().getGothic64FontStyle());
        label.setSize(1080,150);
        label.setWrap(true);
        label.setPosition(0, 0);
        label.setAlignment(Align.left);
    }

    public Label getOutputLabel(){
        return label;
    }

    private void setLabelText(String outputText){
        label.setText(outputText);
    }

    public void updateBenchData(float delta) {
//        percentUsage, frameCount, deltaTimeUsed;
        if(frameCount>=120) {
            float timestampDiff = (System.currentTimeMillis() - timestamp)/2;
            setLabelText("1Sec took: " + String.format("%.02f", timestampDiff) + "ms\nEqual to " + 1000 / timestampDiff * 60 + " fps");
            frameCount = 0;
            timestamp = System.currentTimeMillis();
        }
        frameCount++;
    }
}
