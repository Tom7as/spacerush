package com.jerabek.spacerush.screens.playClass.model.professions;

import com.jerabek.spacerush.screens.playClass.Workers;

public final class Unemployed {
    public int count;
    public int foodConsumption;

    public Unemployed(int count) {
        this.count = count;
        this.foodConsumption = 3;
    }

    public int eat(){
        return count*foodConsumption;
    }
}
