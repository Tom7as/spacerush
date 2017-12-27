package com.jerabek.spacerush.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jerabek.spacerush.utils.Benchmarker;
import com.jerabek.spacerush.utils.MySkin;

/**
 * Created by Tomas-PC on 23.12.2017.
 */

public class MenuScreen implements Screen{

    private SpriteBatch batch = new SpriteBatch();
    private Texture img = new Texture("badlogic.jpg");
    private Stage stage;
    private OrthographicCamera cam;
    private Benchmarker benchmarker;
    private Skin mySkin;


    public MenuScreen(Game game) {
        cam = new OrthographicCamera();
        benchmarker = new Benchmarker(cam);
        mySkin = new MySkin().getSkin();
//        Skin skin2 = new Skin(Gdx.files.internal("jamesPlazin/plain.json"));
//        stage = new Stage(new ScreenViewport());
        stage = new Stage(new FitViewport(1080, 1920, cam));

        stage.addActor(benchmarker.getOutputLabel());

        Table table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center);
        table.setPosition(0,800);

        Button button1 = new TextButton("New Game", mySkin);
        Button button2 = new TextButton("High scores", mySkin);
        Button button3 = new TextButton("Settings", mySkin);
        Button button4 = new TextButton("Account", mySkin);

        table.add(button1).width(750).height(200);
        table.row();
        table.add(button2).width(750).height(200);
        table.row();
        table.add(button3).width(750).height(200);
        table.row();
        table.add(button4).width(750).height(200);
        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        float a = 0;
//        for (int b=0;b<10000;++b){
//            for (int i=0;i<1000;++i){
//                a=delta*i-a;
//            }
//        }
        benchmarker.updateBenchData(delta);
//        batch.setProjectionMatrix(cam.combined);
        batch.begin();
//        batch.draw(img, 0, 0, 2000, 2000);
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
        img.dispose();
        stage.dispose();

    }
}
