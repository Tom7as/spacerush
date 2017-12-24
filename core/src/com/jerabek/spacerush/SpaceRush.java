package com.jerabek.spacerush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.jerabek.spacerush.screens.MenuScreen;

public class SpaceRush extends Game {

	
	@Override
	public void create () {
		Screen menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
