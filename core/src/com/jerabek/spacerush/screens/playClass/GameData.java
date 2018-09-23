package com.jerabek.spacerush.screens.playClass;

import com.jerabek.spacerush.screens.NewGameConfig;
import com.jerabek.spacerush.screens.playClass.model.Resources.Resources;


public class GameData {
//    public NewGameConfig.GameConfig gameConfig;
    public Date date;
    public Resources resources;
    public Workers workers;

    public GameData(NewGameConfig.GameConfig gameConfig) {
//        this.gameConfig = gameConfig;
        date = new Date(gameConfig.getStartDate());
        workers = new Workers(this, gameConfig);
        resources = new Resources();

    }

    public String getDate() {
        return date.year+"/"+ date.month;
    }

    public void endTurn(){
        date.addMonth();

        workers.production();
        workers.foodConsumption();
    }

    private static class Date {
        int year;
        int month;

        Date(int year) {
            this.year = year;
            this.month = 1;
        }

        private void addMonth() {
            ++month;
            if(month>12) {
                month = 1;
                ++year;
            }
        }
    }
}
