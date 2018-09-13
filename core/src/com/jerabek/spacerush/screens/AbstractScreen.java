package com.jerabek.spacerush.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jerabek.spacerush.SpaceRush;
import com.jerabek.spacerush.utils.Benchmark;

public abstract class AbstractScreen implements Screen {
    Game game;
    Benchmark benchmark;
    SpriteBatch batch = new SpriteBatch();
    Stage stage;
    OrthographicCamera cam;
    Skin mySkin;
    public Vector3 touchPoint = new Vector3(0,0,0);

    AbstractScreen(final Game game) {
        this.game = game;
        cam = new OrthographicCamera();
        stage = new Stage(new FitViewport(1080, 1920, cam));
        Gdx.input.setInputProcessor(stage);
        benchmark = new Benchmark();

        stage.addActor(benchmark.getOutputLabel());
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(SpaceRush.menuScreen);
        }
        if(Gdx.input.isTouched()){
            touchPoint = touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPoint);
        }

        benchmark.updateBenchmarker(touchPoint);

        batch.begin();
        // draw sprites, objects

        batch.end();

        stage.act();// this will draw UI
        stage.draw();
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

    /** ===== User control, touch handling ===== */
    void getTouchPixel() {
        /**
         * 1. dva buttony s onclick
         * 2. leva prava pulka obrazovky a pomoci x souradnice zjistit smer
         * 3. naklaneni
         *
         */
        // switch pro vyber modu, def = 2 ?
        if(Gdx.input.isTouched()){
            touchPoint = touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPoint);
        }
    }

    public static void logMsg(String string){
        System.out.println("||| " + string + " |||");
    }

    //benchmark.printString("x: "+playerShip.getShipPosition());
}
