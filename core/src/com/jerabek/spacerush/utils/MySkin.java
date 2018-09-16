package com.jerabek.spacerush.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

/**
 * Created by Tomas-PC on 26.12.2017.
 */

public class MySkin {
    private static Skin skin = new Skin();

    public MySkin(){
        Color toxicGreen = new Color(0f, 0.76f, 0.23f, 1f);
        Color lightGrey = new Color(0.5f, 0.5f, 0.5f, 1f);
        Fonts fonts = new Fonts();

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));

        skin.add("gothic64", fonts.getGothic64Font());
        skin.add("gothic100", fonts.getGothic100Font());
        skin.add("gothic128", fonts.getGothic128Font());

//        Texture textButtonTexture = new Texture(Gdx.files.internal("skin/button-green.png"));
//        NinePatchDrawable textButtonNinePatch = new NinePatchDrawable(new NinePatch(textButtonTexture, 25, 25, 25, 25));
//        TextButton.TextButtonStyle testButtonStyle = new TextButton.TextButtonStyle();
//        testButtonStyle.up = textButtonNinePatch;
//        testButtonStyle.down = textButtonNinePatch;
////        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
////        textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
//        testButtonStyle.font = skin.getFont("gothic100");
//        testButtonStyle.fontColor = toxicGreen;
//        skin.add("greenTextBtn", testButtonStyle);

        Texture textButtonTexture = new Texture(Gdx.files.internal("skin/button-green.png"));
        NinePatchDrawable textButtonNinePatch = new NinePatchDrawable(new NinePatch(textButtonTexture, 25, 25, 25, 25));
        TextButton.TextButtonStyle testButtonStyle = new TextButton.TextButtonStyle();
        testButtonStyle.up = textButtonNinePatch;
        testButtonStyle.down = textButtonNinePatch;
//        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
//        textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
        testButtonStyle.font = skin.getFont("gothic100");
        testButtonStyle.fontColor = lightGrey;
        skin.add("default", testButtonStyle);

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = skin.getFont("gothic64");
        labelStyle.fontColor = lightGrey;
//        labelStyle.background = ;
        skin.add("default", labelStyle);
    }

    public Skin getSkin() {
        return skin;
    }
}
