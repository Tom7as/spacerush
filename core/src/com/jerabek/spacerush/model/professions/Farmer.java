package com.jerabek.spacerush.model.professions;

import com.jerabek.spacerush.model.GameData;

public final class Farmer extends AbstractWorker {

    private static int expectedHarvest;
    private int harvestingMonth;
    private int weather;

    public Farmer(int count, int productivity, int harvestingMonth) {
        super(count, productivity, 4);
        this.harvestingMonth = harvestingMonth;
        weather = 1;
    }

    @Override
    public int work() {
        throw new UnsupportedOperationException();
    }

    public int work(GameData gameData){
        expectedHarvest+=count*productivity*weather;
        if(gameData.date.isMonth(harvestingMonth)){
            int value = expectedHarvest;
            expectedHarvest = 0;
            return value;
        } else {
            return 0;
        }
    }


}
