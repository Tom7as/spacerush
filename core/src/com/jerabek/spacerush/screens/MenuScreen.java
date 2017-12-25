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

/**
 * Created by Tomas-PC on 23.12.2017.
 */

public class MenuScreen implements Screen{

    private SpriteBatch batch = new SpriteBatch();
    private Texture img = new Texture("badlogic.jpg");
    private Stage stage;
    private OrthographicCamera cam;
    private Benchmarker benchmarker;
    private Skin uiSkin ;


    public MenuScreen(Game game) {
        cam = new OrthographicCamera();
        benchmarker = new Benchmarker(cam);
        uiSkin = new Skin(Gdx.files.internal("skin/orangepeelui/uiskin.json"));
//        stage = new Stage(new ScreenViewport());
        stage = new Stage(new FitViewport(1080, 1920, cam));

        stage.addActor(benchmarker.getOutputLabel());

        Table table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center);
        table.setPosition(0,1200);

        Button button1 = new TextButton("Butt1",uiSkin);
        button1.setWidth(600);
        button1.setHeight(200);
        button1.setScale(5);
        Button button2 = new TextButton("Butt2",uiSkin);
        button2.setWidth(600);
        button2.setHeight(200);

        stage.addActor(button1);
        table.row();
        table.add(button2);

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
