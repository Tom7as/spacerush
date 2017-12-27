package com.jerabek.spacerush.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

/**
 * Created by Tomas-PC on 24.12.2017.
 */

public final class Fonts {
    private LabelStyle gothic64FontStyle, gothic100FontStyle, gothic128FontStyle;
    private BitmapFont gothic64Font, gothic100Font, gothic128Font;

    public Fonts() {
        Texture gothic64Texture = new Texture(Gdx.files.internal("font/gothic64.png"), false);
        gothic64Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        gothic64Font = new BitmapFont(Gdx.files.internal("font/gothic64.fnt"), new TextureRegion(gothic64Texture), false);
        gothic64Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapNearestLinear);
        gothic64FontStyle = new LabelStyle(gothic64Font, Color.WHITE);

        Texture gothic100Texture = new Texture(Gdx.files.internal("font/gothic100.png"), false);
        gothic100Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        gothic100Font = new BitmapFont(Gdx.files.internal("font/gothic100.fnt"), new TextureRegion(gothic100Texture), false);
        gothic100Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapNearestLinear);
        gothic100FontStyle = new LabelStyle(gothic100Font, Color.WHITE);

        Texture gothic128Texture = new Texture(Gdx.files.internal("font/gothic100.png"), false);
        gothic128Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        gothic128Font = new BitmapFont(Gdx.files.internal("font/gothic128.fnt"), new TextureRegion(gothic128Texture), false);
        gothic128Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.MipMapNearestLinear);
        gothic128FontStyle = new LabelStyle(gothic128Font, Color.WHITE);

    }

    public BitmapFont getGothic64Font() {
        return gothic64Font;
    }

    public BitmapFont getGothic100Font() {
        return gothic100Font;
    }

    public BitmapFont getGothic128Font() {
        return gothic128Font;
    }

    public LabelStyle getGothic64FontStyle(){
        return gothic64FontStyle;
    }

    public LabelStyle getGothic100FontStyle(){
        return gothic100FontStyle;
    }

    public LabelStyle getGothic128FontStyle(){
        return gothic128FontStyle;
    }

}
