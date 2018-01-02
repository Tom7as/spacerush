package com.jerabek.spacerush.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jerabek.spacerush.SpaceRush;
import com.jerabek.spacerush.utils.Benchmarker;
import com.jerabek.spacerush.utils.MySkin;

import static com.jerabek.spacerush.SpaceRush.logMsg;

/**
 * Created by Tomas-PC on 23.12.2017.
 */

public class MenuScreen implements Screen{

    private SpriteBatch batch = new SpriteBatch();
    private Texture logo = new Texture("graphics/logo.png");
    private Stage stage;
    private OrthographicCamera cam;
    private Benchmarker benchmarker;
    private Skin mySkin;
    private Game game;

    public MenuScreen(final Game game) {
        this.game = game;
        cam = new OrthographicCamera();
        benchmarker = new Benchmarker(cam);
        mySkin = new MySkin().getSkin();

        stage = new Stage(new FitViewport(1080, 1920, cam));
        Gdx.input.setInputProcessor(stage);

        stage.addActor(benchmarker.getOutputLabel());

        TextButton buttonNewGame = new TextButton("New game", mySkin);
        buttonNewGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                logMsg("Button New game was clicked");
                game.setScreen(new PlayScreen(game));
            }
        });

        TextButton buttonHighscores = new TextButton("High scores", mySkin);
        buttonHighscores.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                logMsg("Button High scores was clicked");
//                game.setScreen(screen);
            }
        });

        TextButton buttonSettings = new TextButton("Settings", mySkin);
        buttonSettings.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                logMsg("Button Settings was clicked");
//                game.setScreen(screen);
            }
        });

        TextButton buttonAccount = new TextButton("Account", mySkin);
        buttonAccount.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                logMsg("Button Account was clicked");
//                game.setScreen(screen);
            }
        });

        Table table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center);
        table.setPosition(0,600);

        table.add(buttonNewGame).width(750).height(200);
        table.row();
        table.add(buttonHighscores).width(750).height(200);
        table.row();
        table.add(buttonSettings).width(750).height(200);
        table.row();
        table.add(buttonAccount).width(750).height(200);
        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

//        float a = 0;
//        for (int b=0;b<10000;++b){
//            for (int i=0;i<1000;++i){
//                a=delta*i-a;
//            }
//        }
        benchmarker.updateBenchData(delta);
//        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(logo, 207, 1170, 666, 246);
        batch.end();

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
        batch.dispose();
        logo.dispose();
        stage.dispose();

    }

/** --------------------------  there start some custom code  ----------------------------------- */

}
