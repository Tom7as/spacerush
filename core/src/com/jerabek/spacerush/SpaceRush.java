package com.jerabek.spacerush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.jerabek.spacerush.screens.MenuScreen;

public class SpaceRush extends Game {
	public static Screen menuScreen;

	@Override
	public void create () {
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

	public static void logMsg(String string){
		System.out.println("||| " + string + " |||");
	}

}
