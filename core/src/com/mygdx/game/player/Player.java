package com.mygdx.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    int telaLarg = 1280, telaAlt = 720;
    public int x = (telaLarg / 2);
    public int y = (telaAlt / 2);
    public Texture tPlayer;
    public Sprite sPlayer;
    public int larg = 64, alt = 128;
    public int velo = 8;

    public boolean espelhado;
    public boolean idle;
    public boolean esquerda;
    public boolean direita;
    public boolean cima;
    public boolean baixo;
    public int animAtual;

    public Texture animCimaTextura[];
    public Sprite animCimaSprite[];


    public void Criar() {
        tPlayer = new Texture("player.png");
        sPlayer = new Sprite(tPlayer);

        animCimaTextura = new Texture[3];
        animCimaSprite = new Sprite[3];

        animCimaTextura[0]=new Texture("player/severinoCI.png");
        animCimaTextura[1]=new Texture("player/severinoCA01.png");
        animCimaTextura[2]=new Texture("player/severinoCA02.png");

        animCimaSprite[0]=new Sprite(animCimaTextura[0]);
        animCimaSprite[1]=new Sprite(animCimaTextura[1]);
        animCimaSprite[2]=new Sprite(animCimaTextura[2]);
    }

    public void Deletar() {
        tPlayer.dispose();
    }

    public void Desenharr(SpriteBatch aux) {
        if(cima)
            aux.draw(animCimaSprite[0],x,y);
        aux.draw(sPlayer, x, y);
    }
}
