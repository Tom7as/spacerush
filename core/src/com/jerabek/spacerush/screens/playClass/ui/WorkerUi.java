package com.jerabek.spacerush.screens.playClass.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jerabek.spacerush.model.professions.AbstractWorker;
import com.jerabek.spacerush.screens.playClass.Workers;

import java.util.HashSet;

import static com.jerabek.spacerush.SpaceRush.mySkin;

public class WorkerUi {

    private final ImageButton upBtn = new ImageButton(mySkin, "upArrow");
    private final Label countLabel = new Label("-", mySkin);
    private final ImageButton downBtn = new ImageButton(mySkin, "upArrow");

    private AbstractWorker displayedWorker;
    private Workers workers;


    public WorkerUi(AbstractWorker displayedWorker, Workers workers, int posX) {
        this.workers = workers;
        this.displayedWorker = displayedWorker;

        setUp(posX);
    }

    private void setUp(int posX){
        upBtn.setPosition(posX * 128, 192);
        upBtn.setSize(128, 128);

        countLabel.setPosition(posX * 128, 128);
        countLabel.setSize(128, 64);

        downBtn.setPosition(posX * 128, 0); //x u dalsiho bude (128 + 7) * n
        downBtn.setSize(128, 128);

        upBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                workers.addWorker(displayedWorker);
            }
        });
        countLabel.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                countLabel.setText(displayedWorker.count+"");
            }
        });
        downBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                workers.removeWorker(displayedWorker);
            }
        });
    }

    public HashSet<Actor> getUI() {
        HashSet<Actor> uiElements = new HashSet<>();

        uiElements.add(upBtn);
        uiElements.add(countLabel);
        uiElements.add(downBtn);

        return uiElements;
    }

    public Label getCountLabel(){
        return countLabel;
    }




}
