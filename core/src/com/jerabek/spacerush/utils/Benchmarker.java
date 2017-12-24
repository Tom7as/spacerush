package com.jerabek.spacerush.utils;

/**
 * Created by Tomas-PC on 24.12.2017.
 */

public class Benchmarker {
    private int frameCount=0;
    private double deltaTimeUsed=0;
    private String percentUsage = "N/A";

    private void countBenchmark(float delta) {
//        percentUsage, frameCount, deltaTimeUsed;
        if(frameCount>=60){
            percentUsage = "Load: " + String.format("%.05f", ((deltaTimeUsed/60)/16)*100) + "%";
            frameCount=0;
            deltaTimeUsed=0;
        }else{
            deltaTimeUsed+=delta;
        }
        frameCount++;
    }

    public String getPercentUsage(){
        return percentUsage;
    }

    public String getPercentUsage(float delta){
        countBenchmark(delta);
        return percentUsage;
    }
}
