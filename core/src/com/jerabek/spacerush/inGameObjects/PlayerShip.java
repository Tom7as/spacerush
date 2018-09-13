package com.jerabek.spacerush.inGameObjects;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tomas-PC on 01.01.2018.
 */

public class PlayerShip extends com.jerabek.spacerush.inGameObjects.GameObject { //https://stackoverflow.com/questions/28812776/game-character-items-libgdx

    private int shipID=0;
    private int attack;
    private int health;
    private int speed;
    private int shield;
    int rightBorder, leftBorder;

    public PlayerShip(float x, float y, float width, float height, int shipID, int attack, int health, int speed, int shield) {
        super(x, y, width, height, new Texture("graphics/shipBasic.png"));

        this.shipID = shipID;
        this.attack = attack;
        this.health = health;
        this.speed = speed;
        this.shield = shield;
        rightBorder=1040-(int)width;
        leftBorder=40;
    }

    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public float getShipPosition(){
        return super.position.x;
    }

    public void moveShip(int px){
        if (super.getPosition().x + px < rightBorder && super.getPosition().x + px > leftBorder) {
            super.getPosition().x += px;
            super.moveSprite(px);
        }

    }
}
