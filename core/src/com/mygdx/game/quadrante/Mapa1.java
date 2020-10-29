package com.mygdx.game.quadrante;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Mapa1 {
    public Texture texture;
    public Sprite sprite;

    public boolean Criar(){
        texture= new Texture("A2.png");
        sprite= new Sprite(texture);

        return true;
    }

    public void Deletar(){
        texture.dispose();
    }
}
