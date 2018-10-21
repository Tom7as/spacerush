package com.jerabek.spacerush.screens.playClass;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jerabek.spacerush.model.GameConfig;
import com.jerabek.spacerush.model.GameData;
import com.jerabek.spacerush.screens.playClass.ui.UI;
import com.jerabek.spacerush.utils.Benchmark;

import static com.jerabek.spacerush.utils.Functions.logMsgUserAction;

/**
 * Created by Tomas-PC on 01.01.2018.
 */

public class PlayScreen implements Screen {

    private static GameData gameData;
    private Game game;
    private Benchmark benchmark = new Benchmark();
    private SpriteBatch batch = new SpriteBatch();
    private OrthographicCamera cam = new OrthographicCamera();
    private Stage stage = new Stage(new FitViewport(1080, 1920, cam));
    private UI ui;

    public PlayScreen(final Game game, GameConfig gameConfig) {
        this.game = game;
        gameData = new GameData(gameConfig);
        ui = new UI(gameData);

        if(gameConfig.debugging) stage.addActor(benchmark.getOutputLabel());

        ui.getUI().forEach(widget -> stage.addActor(widget));

        Gdx.input.setInputProcessor(stage);

        ui.endTurnBtn().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                logMsgUserAction("End turn clicked. Game date: "+gameData.getDate());
                gameData.endTurn();
            }
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
//            game.setScreen(SpaceRush.menuScreen);
        }

        ui.updateLabels(gameData);
        batch.begin();
//        draw sprites, images

        batch.end();

        stage.act();// this will draw UI
        stage.draw();
    }

    private void update(){

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
