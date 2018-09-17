package com.jerabek.spacerush.screens.playClass.model.professions;

public abstract class AbstractWorker {

    public int count;
    public int productivity;
    public int foodConsumption;
//    public Resource resource;

    public AbstractWorker(int count, int productivity, int foodConsumption) {
        this.count = count;
        this.productivity = productivity;
        this.foodConsumption = foodConsumption;

    }

    public void addOne(){
        ++count;
    }

    public void removeOne(){
        --count;
    }

    public int work(){
        return count*productivity;
    }

    public int eat(){
        return count*foodConsumption;
    }
}
