package com.jerabek.spacerush.screens.playClass.model.professions;

import com.jerabek.spacerush.screens.playClass.GameData;
import com.jerabek.spacerush.screens.playClass.Workers;

public abstract class AbstractWorker {

    public int count;
    public int productivity;
    public int foodConsumption;

    public AbstractWorker(int count, int productivity, int foodConsumption) {
        this.count = count;
        this.productivity = productivity;
        this.foodConsumption = foodConsumption;
    }

    public void addOne(Workers workers){
        if(workers.unemployed.count>0){
            ++count;
            --workers.unemployed.count;
        }
    }

    public void removeOne(Workers workers){
        if(count>0) {
            --count;
            ++workers.unemployed.count;
        }
    }

    public int work(){
        return count*productivity;
    }

    public int eat(){
        return count*foodConsumption;
    }
}
