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
    private LabelStyle segoe96FontStyle, segoe48FontStyle, gothic96FontStyle, gothic48FontStyle;
    private BitmapFont segoe96Font, segoe48Font, gothic96Font, gothic48Font;

    public Fonts() {

        Texture gothic96Texture = new Texture(Gdx.files.internal("font/bankGothic96.png"), false);
        gothic96Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        gothic96Font = new BitmapFont(Gdx.files.internal("font/bankGothic96.fnt"), new TextureRegion(gothic96Texture), false);
        gothic96Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapNearestLinear);
        gothic96FontStyle = new LabelStyle(gothic96Font, Color.WHITE);

        Texture gothic48Texture = new Texture(Gdx.files.internal("font/bankGothic48.png"), false);
        gothic48Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        gothic48Font = new BitmapFont(Gdx.files.internal("font/bankGothic48.fnt"), new TextureRegion(gothic48Texture), false);
        gothic48Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapNearestLinear);
        gothic48FontStyle = new LabelStyle(gothic48Font, Color.WHITE);

        Texture segoe96Texture = new Texture(Gdx.files.internal("font/segoe96.png"), false);
        segoe96Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        segoe96Font = new BitmapFont(Gdx.files.internal("font/segoe96.fnt"), new TextureRegion(segoe96Texture), false);
        segoe96Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.MipMapNearestLinear);
        segoe96FontStyle = new LabelStyle(segoe96Font, Color.WHITE);

        Texture segoe48Texture = new Texture(Gdx.files.internal("font/segoe48.png"), false);
        segoe48Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        segoe48Font = new BitmapFont(Gdx.files.internal("font/segoe48.fnt"), new TextureRegion(segoe48Texture), false);
        segoe48Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapNearestLinear);
        segoe48FontStyle = new LabelStyle(segoe48Font, Color.WHITE);
    }

    public LabelStyle getGothic96FontStyle(){
        return gothic96FontStyle;
    }

    public LabelStyle getGothic48FontStyle(){
        return gothic48FontStyle;
    }

    public LabelStyle getSegoe48FontStyle(){
        return segoe48FontStyle;
    }

    public LabelStyle getSegoe96FontStyle(){
        return segoe96FontStyle;
    }
}
