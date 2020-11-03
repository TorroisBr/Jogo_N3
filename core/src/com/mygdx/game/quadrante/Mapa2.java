package com.mygdx.game.quadrante;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Mapa2 {
    public Texture texture[];
    public Sprite sprite[];

    public boolean Criar(){
        sprite=new Sprite[1];
        texture=new Texture[1];

        texture[0]= new Texture("A3.png");
        sprite[0]= new Sprite(texture[0]);

        return true;
    }

    public void Deletar(){
        texture[0].dispose();
    }
}
