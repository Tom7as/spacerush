package com.jerabek.spacerush.model;

import com.jerabek.spacerush.model.resources.Resources;
import com.jerabek.spacerush.screens.playClass.Workers;


public class GameData {

    public Date date;
    public Resources resources;
    public Workers workers;

    public GameData(GameConfig gameConfig) {
        date = new Date(gameConfig.startYear);
        workers = new Workers(this, gameConfig);
        resources = new Resources();

    }

    public String getDate() {
        return date.toString();
    }

    public void endTurn(){
        date.addMonth();

        workers.production();
        workers.foodConsumption();
    }

    public class Date {
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

        @Override
        public String toString() {
            return year+"/"+month;
        }

        public boolean isMonth(int monthNumber){
            return month == monthNumber;
        }
    }
}
