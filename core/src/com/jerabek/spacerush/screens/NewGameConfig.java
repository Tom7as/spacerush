package com.jerabek.spacerush.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jerabek.spacerush.SpaceRush;

import java.util.HashMap;

import static com.jerabek.spacerush.utils.Functions.logMsg;

public class NewGameConfig implements Screen{

    private OrthographicCamera cam;
    private Game game;
    private Stage stage;
    private GameConfig gameConfig;

    public NewGameConfig(final Game game) {
        this.game = game;
        cam = new OrthographicCamera();
        stage = new Stage(new FitViewport(1080, 1920, cam));
        gameConfig = new GameConfig();

        Gdx.input.setInputProcessor(stage);

        TextButton buttonNewGame = new TextButton("New game", SpaceRush.mySkin);
        buttonNewGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                logMsg("Button New game was clicked");
                game.setScreen(new PlayScreen(game, gameConfig.easy()));
            }
        });

        Table table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center);
        table.setPosition(0,600);

        table.add(buttonNewGame).width(750).height(200);
        stage.addActor(table);

        gameConfig.debugging = true;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        stage.act();
        stage.draw();
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

    public class GameConfig {
        Boolean debugging;
        HashMap<String, Integer> resources = new HashMap<>();
        private int startDate;

        GameConfig(){}

        GameConfig(Boolean debugging, int money, int food, int population) {
            this.debugging = debugging;
            resources.put("money", money);
            resources.put("food", food);
            resources.put("population", population);
        }

        public GameConfig easy(){
            debugging = false;
            startDate = -4000;
            resources.put("money", 10000);
            resources.put("food", 100);
            resources.put("population", 50);
            return this;
        }

        public HashMap<String, Integer> getResources() {
            return resources;
        }

        public int getStartDate() {
            return startDate;
        }
    }
}