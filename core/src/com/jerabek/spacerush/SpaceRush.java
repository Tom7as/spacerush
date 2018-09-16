package com.jerabek.spacerush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jerabek.spacerush.screens.MenuScreen;
import com.jerabek.spacerush.screens.PlayScreen;
import com.jerabek.spacerush.utils.MySkin;

public class SpaceRush extends Game {
	public static Screen menuScreen;
	public static Skin mySkin;

	@Override
	public void create () {
		System.setProperty("debug", "1");
		mySkin = new MySkin().getSkin();

		menuScreen = new MenuScreen(this);

		setScreen(menuScreen);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose () {

	}


}
