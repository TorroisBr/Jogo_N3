package com.mygdx.game.tiro;

import com.badlogic.gdx.math.Rectangle;

public abstract class Tiro {
    Rectangle hitbox;
    public int x,y;


    public abstract void seMover();
    public abstract void conferindoInteracao();

}
