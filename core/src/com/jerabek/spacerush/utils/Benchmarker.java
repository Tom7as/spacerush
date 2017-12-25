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
        label = new Label("output", new Fonts().getGothic48FontStyle());
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
        if(frameCount>=60) {
            float timestampDiff = (System.currentTimeMillis() - timestamp)/10f;
            setLabelText("\nLoad: " + String.format("%.02f", timestampDiff) + "%");
            frameCount = 0;
            timestamp = System.currentTimeMillis();
        }
        frameCount++;
    }
}
