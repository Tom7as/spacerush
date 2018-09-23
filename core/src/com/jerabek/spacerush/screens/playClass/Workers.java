package com.jerabek.spacerush.screens.playClass;

import com.jerabek.spacerush.screens.NewGameConfig;
import com.jerabek.spacerush.screens.playClass.model.professions.Builder;
import com.jerabek.spacerush.screens.playClass.model.professions.Farmer;
import com.jerabek.spacerush.screens.playClass.model.professions.Hunter;
import com.jerabek.spacerush.screens.playClass.model.professions.Unemployed;

public class Workers {

    private final GameData data;

    public int population;

    public final Unemployed unemployed;
    public final Builder builders;
    public final Farmer farmers;
    public final Hunter hunters;

    Workers(GameData data, NewGameConfig.GameConfig gameConfig) {
        this.data = data;

        population = gameConfig.getResources().get("population");
        unemployed = new Unemployed(gameConfig.getResources().get("population"));

        builders = new Builder(0,5);
        farmers = new Farmer(0,5);
        hunters = new Hunter(0,5);
    }

    public void production(){
        data.resources.food += farmers.work();
    }

    public void foodConsumption(){
        data.resources.food = data.resources.food - (unemployed.eat() +
                builders.eat() +
                farmers.eat() +
                hunters.eat());
    }
}
