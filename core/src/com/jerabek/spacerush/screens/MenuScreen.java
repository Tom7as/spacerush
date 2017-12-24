package com.jerabek.spacerush.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jerabek.spacerush.utils.Benchmarker;

/**
 * Created by Tomas-PC on 23.12.2017.
 */

public class MenuScreen implements Screen{
    private Label label;
    private Label.LabelStyle fontStyle96;
    private Label.LabelStyle fontStyle48;
    private SpriteBatch batch = new SpriteBatch();
    private Texture img = new Texture("badlogic.jpg");
    private Stage stage;
    private OrthographicCamera cam;
    private Texture segoe96Texture, segoe48Texture;
    private BitmapFont segoe96Font, segoe48Font;
    private Benchmarker benchmarker;


    public MenuScreen(Game game) {
        cam = new OrthographicCamera();
        benchmarker = new Benchmarker();
//        stage = new Stage(new ScreenViewport());
        stage = new Stage(new FitViewport(1080, 1920, cam));

        segoe96Texture = new Texture(Gdx.files.internal("font/segoe96.png"), false);
        segoe96Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        segoe96Font = new BitmapFont(Gdx.files.internal("font/segoe96.fnt"), new TextureRegion(segoe96Texture), false);
        segoe96Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.MipMapNearestLinear);
        fontStyle96 = new Label.LabelStyle(segoe96Font, Color.WHITE);

        segoe48Texture = new Texture(Gdx.files.internal("font/segoe48.png"), false);
        segoe48Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        segoe48Font = new BitmapFont(Gdx.files.internal("font/segoe48.fnt"), new TextureRegion(segoe48Texture), false);
        segoe48Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapNearestLinear);
        fontStyle48 = new Label.LabelStyle(segoe48Font, Color.WHITE);

        label = new Label("output", fontStyle96);
        label.setSize(1080,100);
        label.setWrap(true);
        label.setPosition(cam.position.x - label.getWidth()/2, 1920 - label.getHeight());
        label.setAlignment(Align.center);
        stage.addActor(label);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        label.setText(benchmarker.getPercentUsage(delta));
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
