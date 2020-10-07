package com.mygdx.game.quadrante;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Quadrante6 extends ApplicationAdapter {
    public int x,y;
    public int tam,larg;
    public Texture textura;
    public Sprite sprite;
    public void criar(){
        textura= new Texture("b3.png");
        sprite= new Sprite(textura);
    }

}

