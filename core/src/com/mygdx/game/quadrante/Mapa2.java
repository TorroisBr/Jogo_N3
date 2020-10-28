package com.mygdx.game.quadrante;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Mapa2 {
    public Texture texture;
    public Sprite sprite;

    public void Criar(){
        texture= new Texture("A3.png");
        sprite= new Sprite(texture);
    }

    public void Deletar(){
        texture.dispose();
    }
}
