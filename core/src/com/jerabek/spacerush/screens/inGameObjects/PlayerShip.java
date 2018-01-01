package com.jerabek.spacerush.screens.inGameObjects;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tomas-PC on 01.01.2018.
 */

public class PlayerShip { //https://stackoverflow.com/questions/28812776/game-character-items-libgdx
    private Texture shipImage = new Texture("graphics/logo.png");


    int shipID=0;
    int attack;
    int health;
    int speed;
    int shield;
    int position=0;

    public PlayerShip(int shipID, int attack, int health, int speed, int shield, int position) {
        this.shipID = shipID;
        this.attack = attack;
        this.health = health;
        this.speed = speed;
        this.shield = shield;
        this.position = position;
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

    public int getPosition(){
        return position;
    }

    public void moveShip(int px){
        if (position+px<1040&&position+px>40)
            position += px;
    }
}
