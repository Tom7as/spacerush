package com.jerabek.spacerush.screens.playClass;

import com.jerabek.spacerush.model.GameConfig;
import com.jerabek.spacerush.model.GameData;
import com.jerabek.spacerush.model.professions.AbstractWorker;
import com.jerabek.spacerush.model.professions.Builder;
import com.jerabek.spacerush.model.professions.Farmer;
import com.jerabek.spacerush.model.professions.Hunter;
import com.jerabek.spacerush.model.professions.Unemployed;
import com.jerabek.spacerush.utils.Functions;

public class Workers {

    private final GameData data;

    public int population;

    public final Unemployed unemployed;
    public final Builder builders;
    public final Farmer farmers;
    public final Hunter hunters;

    public Workers(GameData data, GameConfig gameConfig) {
        this.data = data;

        population = gameConfig.population;

        unemployed = new Unemployed(this, gameConfig.population);
        builders = new Builder(0,9);
        farmers = new Farmer(0,13, 7);
        hunters = new Hunter(0,5);
    }

    public void addWorker(AbstractWorker worker){
        if(unemployed.count>0){
            Functions.logMsgUserAction("added " + worker.getClass().getSimpleName());
            worker.addOne();
            unemployed.removeOne();
        } else {
            Functions.logMsgSystemInfo("can not add worker. Unemployed count is: " + unemployed.count);
        }
    }

    public void removeWorker(AbstractWorker worker){
        if(worker.count>0){
            Functions.logMsgUserAction("removed " + worker.getClass().getSimpleName());
            worker.removeOne();
            unemployed.addOne();
        } else {
            Functions.logMsgSystemInfo("can not remove worker. Worker count is: " + worker.count);
        }
    }

    public void production(){
        data.resources.food += farmers.work(data);
    }

    public void foodConsumption(){
        data.resources.food = data.resources.food - (unemployed.eat() +
                builders.eat() +
                farmers.eat() +
                hunters.eat());
    }
}
