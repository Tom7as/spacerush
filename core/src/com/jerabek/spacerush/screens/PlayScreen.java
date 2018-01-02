package com.jerabek.spacerush.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jerabek.spacerush.SpaceRush;
import com.jerabek.spacerush.screens.inGameObjects.MeteorList;
import com.jerabek.spacerush.screens.inGameObjects.PlayerShip;
import com.jerabek.spacerush.utils.Benchmarker;
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
    World world;
    Box2DDebugRenderer debugRenderer;
    Body body;
    Benchmarker benchmarker;
    CircleShape circleShip;

    public PlayScreen(final Game game) {
        this.game = game;
        cam = new OrthographicCamera();
        stage = new Stage(new FitViewport(1080, 1920, cam));
        Gdx.input.setInputProcessor(stage);
        mySkin = new MySkin().getSkin();
        benchmarker = new Benchmarker(cam);
        playerShip = new PlayerShip(540, 200, 110, 200, 0, 1, 1, 1, 1);
        meteorList = new MeteorList(200, 1200, 318, 233, 1, 1, 1);

        debugRenderer = new Box2DDebugRenderer();
        world = new World(new Vector2(0, 0), true);

/*  using Box2D
        // First we create a body definition
        BodyDef bodyDef = new BodyDef();
// We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
        bodyDef.type = BodyDef.BodyType.DynamicBody;
// Set our body's starting position in the world
        bodyDef.position.set(540, 200);

// Create our body in the world using our body definition
        body = world.createBody(bodyDef);

// Create a circleShip shape and set its radius to 6
        circleShip = new CircleShape();
        circleShip.setRadius(49f);

// Create a fixture definition to apply our shape to
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShip;
        fixtureDef.density = 0f;
        fixtureDef.friction = 0f;

// Create our fixture and attach it to the body
        Fixture fixture = body.createFixture(fixtureDef);

        circleShip.dispose();
        */

        stage.addActor(benchmarker.getOutputLabel());

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

//        System.out.println(body.getLinearVelocity().x);
//        body.applyLinearImpulse((0-body.getLinearVelocity().x),0 , 0, 25, true);
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(SpaceRush.menuScreen);
        }

        moveShipIfPlayerTouched();

//        debugRenderer.render(world, cam.combined);

        batch.begin();
        playerShip.getSprite().draw(batch);
        meteorList.getSprite().draw(batch);
        batch.end();

        stage.act();
        stage.draw();

        world.step(1/60f, 6, 2);

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
//        circleShip.dispose();
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
        if(Gdx.input.isTouched()){
            touchPoint = touchPoint.set(Gdx.input.getX(), 0, 0);
            cam.unproject(touchPoint);

            if(touchPoint.x < 540){//left
                playerShip.moveShip(-10-playerShip.getSpeed());
//                body.applyLinearImpulse(-1300, 0, 0, 25, false);
            }
            else{ //right
                playerShip.moveShip(10+playerShip.getSpeed());
//                body.applyLinearImpulse(1300, 0, 0, 25, true);

            }
            benchmarker.printString("x: "+playerShip.getShipPosition());

        }
    }
}
