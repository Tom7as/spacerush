package com.jerabek.spacerush.model;

import com.jerabek.spacerush.model.resources.Resources;
import com.jerabek.spacerush.utils.Functions;

public class GameConfig {
    public Boolean debugging;
    public Resources resources = new Resources();
    public int population;
    public int startYear;

    GameConfig(Builder builder) {
        this.debugging = builder.debugging;
        this.resources.money = builder.money;
        this.resources.food = builder.food;
        this.population = builder.population;
    }

    public static GameConfig easy() {
        Functions.logMsgSystemInfo("i: easy gameconfig set");
        return new Builder()
                .setDebugging(true)
                .setFood(100)
                .setMoney(10000)
                .setPopulation(50)
                .build();
    }

    public static class Builder {
        private Boolean debugging = false;
        private int money = 8000;
        private int food = 80;
        private int population = 500;

        public Builder setDebugging(Boolean debugging) {
            this.debugging = debugging;
            return this;
        }

        public Builder setMoney(int money) {
            this.money = money;
            return this;
        }

        public Builder setFood(int food) {
            this.food = food;
            return this;
        }

        public Builder setPopulation(int population) {
            this.population = population;
            return this;
        }

        public GameConfig build() {
            return new GameConfig(this);
        }
    }
}