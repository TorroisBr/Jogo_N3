package com.mygdx.game.unidade;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class Unidade {

    public int x;
    public int y;
    public Rectangle hitboxDano;
    public int HitBoxDanoLarg, HitBoxDanoAlt;
    public boolean visivel;
    public int estado;





    public abstract void iniciar();

}

