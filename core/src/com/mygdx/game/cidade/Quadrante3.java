package com.mygdx.game.cidade;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Quadrante3 extends ApplicationAdapter {
    public int tam,larg;
    public Texture textura;
    public Sprite sprite;
    public SpriteBatch batch;
    public void criar(){
        textura= new Texture("A3.png");
        sprite= new Sprite(textura);
    }

}

