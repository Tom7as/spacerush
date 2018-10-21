package com.jerabek.spacerush.screens.playClass.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.jerabek.spacerush.model.GameData;

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

    private WorkerUi builderUi;
    private WorkerUi hunterUi;
    private WorkerUi farmerUi;

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

        uiElements.add(cityNameLabel);
        uiElements.add(dateLabel);
        uiElements.add(moneyLabel);
        uiElements.add(foodLabel);
        uiElements.add(popLabel);
        uiElements.add(endTurnBtn);

        builderUi = new WorkerUi(gameData.workers.builders, gameData.workers, 0);
        hunterUi = new WorkerUi(gameData.workers.hunters, gameData.workers, 1);
        farmerUi = new WorkerUi(gameData.workers.farmers, gameData.workers, 2);

        uiElements.addAll(builderUi.getUI());
        uiElements.addAll(hunterUi.getUI());
        uiElements.addAll(farmerUi.getUI());
//        uiElements.addAll();
    }

    public HashSet<Actor> getUI() {
        return uiElements;
    }

    public void updateLabels(GameData data){
        moneyLabel.setText("$: " + data.resources.money);
        foodLabel.setText("F: " + data.resources.food);
        popLabel.setText("P: " + data.workers.population + "(" + data.workers.unemployed.count + ")");
        dateLabel.setText("D" + data.getDate());

        builderUi.getCountLabel().setText("" + data.workers.builders.count);
        hunterUi.getCountLabel().setText("" + data.workers.hunters.count);
        farmerUi.getCountLabel().setText("" + data.workers.farmers.count);
    }

    public TextButton endTurnBtn() {
        return endTurnBtn;
    }
}
