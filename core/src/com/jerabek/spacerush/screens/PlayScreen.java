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
import com.jerabek.spacerush.screens.inGameObjects.MeteorList;
import com.jerabek.spacerush.screens.inGameObjects.PlayerShip;
import com.jerabek.spacerush.utils.MySkin;

/**
 * Created by Tomas-PC on 01.01.2018.
 */

public class PlayScreen implements Screen {
    private SpriteBatch batch = new SpriteBatch();
    private Stage stage;
    private OrthographicCamera cam;
    private Skin mySkin;
    private Game game;
    Vector3 touchPoint = new Vector3();
    MeteorList meteorList;
    PlayerShip playerShip;

    public PlayScreen(final Game game) {
        this.game = game;
        cam = new OrthographicCamera();
        stage = new Stage(new FitViewport(1080, 1920, cam));
        Gdx.input.setInputProcessor(stage);
        mySkin = new MySkin().getSkin();

        playerShip = new PlayerShip(0, 1, 1, 1, 1, 0);
        meteorList = new MeteorList();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(SpaceRush.menuScreen);
        }
        moveShipIfPlayerTouched();


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

/** --------------------------  there start some custom code  ----------------------------------- */

    private void moveShipIfPlayerTouched() {
        /**
         * 1. dva buttony s onclick
         * 2. leva prava pulka obrazovky a pomoci x souradnice zjistit smer
         * 3. souradnice dotyku(drzeni prstu) vuci poloze lode (vse x souradnice)
         *
         */
        // switch pro vyber modu, def = 2 ?
        if(Gdx.input.justTouched()){
            touchPoint = touchPoint.set(Gdx.input.getX(), 0, 0);
            cam.unproject(touchPoint);

            if(touchPoint.x < 540){
                playerShip.moveShip(-5*playerShip.getSpeed());
            }
            else{
                playerShip.moveShip(-5*playerShip.getSpeed());
            }
        }
    }
}
