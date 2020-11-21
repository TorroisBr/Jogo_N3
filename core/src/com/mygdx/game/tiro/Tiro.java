package com.mygdx.game.tiro;

import com.badlogic.gdx.math.Rectangle;

public abstract class Tiro {
    public Rectangle hitbox;
    public int x,y;
    public int dano;

    public abstract void seMover();
    public abstract void conferindoInteracao();

}
