package com.jerabek.spacerush.screens.inGameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tomas-PC on 02.01.2018.
 */

 class GameObject {
    public final Vector2 position;
    public final Rectangle bounds;
    private Sprite sprite;

    public GameObject (float x, float y, float width, float height, Texture texture) {
        this.position = new Vector2(x, y);
        this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
        this.sprite = new Sprite(texture);
        sprite.setSize(width, height);
        sprite.setPosition(x,y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void moveSprite(int x){
        position.x+=x;
        sprite.setPosition(position.x, position.y);
    }
}