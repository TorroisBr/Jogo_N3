package com.mygdx.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Player {
    int telaLarg = 1280, telaAlt = 720;
    public int x = (telaLarg / 2);
    public int y = (telaAlt / 2);
    public Texture tPlayer;
    public Sprite sPlayer;
    public int larg=64,alt=128;
    public int velo=8;
    SpriteBatch batch;

    public void Criar(){
        batch = new SpriteBatch();
        tPlayer = new Texture("player.png");
        sPlayer = new Sprite(tPlayer);
    }
    public void Deletar(){

        tPlayer.dispose();
    }
    public void Desenharr(){
        batch.begin();
        batch.draw(sPlayer, x, y);
        batch.end();
    }
}
