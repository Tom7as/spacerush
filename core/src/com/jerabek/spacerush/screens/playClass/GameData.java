package com.jerabek.spacerush.screens.playClass;

import com.jerabek.spacerush.screens.NewGameConfig;

public class GameData {
    public int money, food, population;
    public GameDate gameDate;

    public GameData(NewGameConfig.GameConfig gameConfig) {
        gameDate = new GameDate(gameConfig.getStartDate());
        money = gameConfig.getResources().get("money");
        food = gameConfig.getResources().get("food");
        population = gameConfig.getResources().get("population");
    }

    public String getGameDate() {
        return gameDate.year+"/"+gameDate.month;
    }

    public void endTurn(){
        gameDate.addMonth();
        food-=population/12;

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
