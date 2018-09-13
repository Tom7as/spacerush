package com.jerabek.spacerush.inGameObjects;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tomas-PC on 01.01.2018.
 */

public class MeteorList extends GameObject {

    private int hithpoints;
    private int damage;
    private int speed;

    public MeteorList(float x, float y, float width, float height, int hitpoints, int damage, int speed) {
        super(x, y, width, height, new Texture("graphics/meteor.png"));

        this.hithpoints=hitpoints;
        this.damage = damage;
        this.speed=speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getHithpoints() {
        return hithpoints;
    }

    public void meteorHitted(int hithpoints) {
        this.hithpoints = hithpoints;
    }
}
