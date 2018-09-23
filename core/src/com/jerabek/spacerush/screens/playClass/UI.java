package com.jerabek.spacerush.screens.playClass;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import java.util.HashSet;

import static com.jerabek.spacerush.SpaceRush.mySkin;

public class UI {
    private static HashSet<Actor> uiElements = new HashSet<>();

    private static Label cityNameLabel = new Label("Your city name", mySkin);
    private static Label moneyLabel = new Label("0", mySkin);
    private static Label foodLabel = new Label("0", mySkin);
    private static Label popLabel = new Label("0", mySkin);
    private static Label dateLabel = new Label("0", mySkin);

//    public static final Map map - mapka s lokacema ktere se budou postupne objevovat ?

    private static TextButton endTurnBtn = new TextButton("End turn", mySkin);

    public static final ImageButton buildersUpBtn = new ImageButton(mySkin, "upArrow");
    public static final Label buildersLabel = new Label("0", mySkin);
    public static final ImageButton buildersDownBtn = new ImageButton(mySkin, "upArrow");
    private final GameData gameData;


    public UI(GameData gameData) {
        this.gameData = gameData;

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
        endTurnBtn.setSize(460, 200);

// ---- builder ui
        buildersUpBtn.setPosition(0, 192);
        buildersUpBtn.setSize(128, 128);

        buildersLabel.setPosition(0, 128);
        buildersLabel.setSize(128, 64);

        buildersDownBtn.setPosition(0, 0); //x u dalsiho bude (128 + 7) * n
        buildersDownBtn.setSize(128, 128);

        buildersUpBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameData.workers.farmers.addOne(gameData.workers);
            }
        });
        buildersDownBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameData.workers.farmers.removeOne(gameData.workers);
            }
        });

        uiElements.add(cityNameLabel);
        uiElements.add(dateLabel);
        uiElements.add(moneyLabel);
        uiElements.add(foodLabel);
        uiElements.add(popLabel);
        uiElements.add(endTurnBtn);

        uiElements.add(buildersLabel);
        uiElements.add(buildersUpBtn);
        uiElements.add(buildersDownBtn);

    }

    public HashSet<Actor> getUI() {
        return uiElements;
    }

    public void updateLabels(GameData data){
        moneyLabel.setText("$: " + data.resources.money);
        foodLabel.setText("F: " + data.resources.food);
        popLabel.setText("P: " + data.workers.population + "(" + data.workers.unemployed.count + ")");
        dateLabel.setText("D" + data.getDate());

        buildersLabel.setText("" + data.workers.farmers.count);
    }

    public TextButton endTurnBtn() {
        return endTurnBtn;
    }
}
