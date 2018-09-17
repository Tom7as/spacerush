package com.jerabek.spacerush.screens.playClass;

import com.jerabek.spacerush.screens.NewGameConfig;
import com.jerabek.spacerush.screens.playClass.model.Resources.Resources;

public class GameData {
    public GameDate gameDate;
    public Resources resources = new Resources();
    public Workers workers;

    public GameData(NewGameConfig.GameConfig gameConfig) {
        gameDate = new GameDate(gameConfig.getStartDate());
        resources.money = gameConfig.getResources().get("money");
        resources.food = gameConfig.getResources().get("food");
        resources.population = gameConfig.getResources().get("population");
    }

    public String getGameDate() {
        return gameDate.year+"/"+gameDate.month;
    }

    public void endTurn(){
        gameDate.addMonth();

        workers.production();
        workers.foodConsumption();

    }

    private static class GameDate {
        int year;
        int month;

        GameDate(int year) {
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
