package com.mygdx.game.quadrante;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;



public class Quadrante3 extends ApplicationAdapter {
    public int x,y;
    public int tam,larg;
    public Texture textura;
    public Sprite sprite;
    //metodo de criação da imagem/textura
    public void criar(){
        textura= new Texture("A3.png");
        sprite= new Sprite(textura);
    }

}

