package com.jerabek.spacerush.screens.newGame;

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
import com.jerabek.spacerush.model.GameConfig;
import com.jerabek.spacerush.screens.playClass.PlayScreen;

import static com.jerabek.spacerush.utils.Functions.logMsgUserAction;

public class NewGame implements Screen{

    private OrthographicCamera cam;
    private Game game;
    private Stage stage;
    private GameConfig gameConfig;

    public NewGame(final Game game) {
        this.game = game;
        cam = new OrthographicCamera();
        stage = new Stage(new FitViewport(1080, 1920, cam));
        gameConfig = GameConfig.easy();

        Gdx.input.setInputProcessor(stage);

        TextButton buttonNewGame = new TextButton("New game", SpaceRush.mySkin);
        buttonNewGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                logMsgUserAction("Button New game was clicked");
                game.setScreen(new PlayScreen(game, gameConfig));
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
}
