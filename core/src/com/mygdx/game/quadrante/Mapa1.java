package com.mygdx.game.quadrante;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Mapa1 {
    public Texture texture[];
    public Sprite sprite[];
    public int xy[][];

    public boolean Criar(){
        //IMPORTANDO IMAGENS
        sprite=new Sprite[1];
        texture=new Texture[1];
        xy=new int[1][2];

        texture[0]= new Texture("A2.png");
        sprite[0]= new Sprite(texture[0]);

        xy[0][0]=0;
        xy[0][1]=0;

        return true;
    }

    public void Deletar(){
        texture[0].dispose();
    }
}
