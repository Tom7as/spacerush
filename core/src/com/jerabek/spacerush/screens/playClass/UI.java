package com.jerabek.spacerush.screens.playClass;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

import java.util.HashSet;

import static com.jerabek.spacerush.SpaceRush.mySkin;

public class UI {
    private static HashSet<Actor> table = new HashSet<>();

    private static Label cityNameLabel = new Label("Your city name", mySkin);
    private static Label moneyLabel = new Label("0", mySkin);
    private static Label foodLabel = new Label("0", mySkin);
    private static Label popLabel = new Label("0", mySkin);
    private static Label dateLabel = new Label("0", mySkin);

    private static TextButton endTurnBtn = new TextButton("End turn", mySkin);

    public UI() {
        cityNameLabel.setPosition(0, 1820);
        cityNameLabel.setSize(540, 100);

        dateLabel.setPosition(540, 1820);
        dateLabel.setSize(540, 100);
        dateLabel.setAlignment(Align.right);

        moneyLabel.setPosition(0, 1720);
        moneyLabel.setSize(360, 100);

        foodLabel.setPosition(360, 1720);
        foodLabel.setSize(360, 100);

        popLabel.setPosition(720, 1720);
        popLabel.setSize(360, 100);

        endTurnBtn.setPosition(720, 0);
        endTurnBtn.setSize(360, 200);

//        table.setWidth(1080);
//        table.align(Align.top);
//        table.setPosition(0,1920);
//        table.debugAll();
//
        table.add(cityNameLabel);
        table.add(dateLabel);
        table.add(moneyLabel);
        table.add(foodLabel);
        table.add(popLabel);
        table.add(endTurnBtn);
    }

    public HashSet<Actor> getUI() {
        return table;
    }

    public void updateLabels(GameData data){
        moneyLabel.setText("$: " + data.money);
        foodLabel.setText("F: " + data.food);
        popLabel.setText("P: " + data.population);
        dateLabel.setText("D" + data.getGameDate());

    }

    public TextButton endTurnBtn() {
        return endTurnBtn;
    }
}
