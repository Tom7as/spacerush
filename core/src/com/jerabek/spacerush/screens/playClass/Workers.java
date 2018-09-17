package com.jerabek.spacerush.screens.playClass;

import com.jerabek.spacerush.screens.playClass.model.professions.Builder;
import com.jerabek.spacerush.screens.playClass.model.professions.Farmer;
import com.jerabek.spacerush.screens.playClass.model.professions.Hunter;
import com.jerabek.spacerush.screens.playClass.model.professions.Unemployed;

class Workers {

    private final GameData gameData;

    private final Unemployed unemployed;
    private final Builder builders;
    private final Farmer farmers;
    private final Hunter hunters;

    Workers(GameData gameData) {
        this.gameData = gameData;
        unemployed = new Unemployed(gameData.resources.population, 0);
        builders = new Builder(0,5);
        farmers = new Farmer(0,5);
        hunters = new Hunter(0,5);
    }


    public void production(){
        gameData.resources.food = farmers.work();

    }

    public int foodConsumption(){
        return unemployed.eat() +
                builders.eat() +
                farmers.eat() +
                hunters.eat();
    }
}
