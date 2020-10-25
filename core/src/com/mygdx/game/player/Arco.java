package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Arco {
    public int x = 1;
    int y = 1;
    int dano = 1;
    int cdr = 1;
    public Sprite sFlecha;
    public Texture tFlecha;

    public void criar (){
        tFlecha = new Texture("player/flecha.png");
        sFlecha = new Sprite(tFlecha);
    }

    public void Desenhar(SpriteBatch aux, int x, int y) {
        aux.draw(sFlecha,x,y);
    }
    public void Deletar() {
        tFlecha.dispose();
    }
}
