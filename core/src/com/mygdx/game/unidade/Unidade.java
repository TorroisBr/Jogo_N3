package com.mygdx.game.unidade;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class Unidade {
    public int x;
    public int y;
    public int direcao;
    public Rectangle hitboxDano;
    public int HitBoxDanoLarg, HitBoxDanoAlt;


    public Unidade(int x, int y, int direcao, Rectangle hitboxDano, int HitBoxDanoLarg, int HitBoxDanoAlt) {
        hitboxDano = new Rectangle(x, y, HitBoxDanoLarg, HitBoxDanoAlt);
        this.x = x;
        this.y = y;
        this.direcao = direcao;

    }


    public abstract void iniciar();

}
