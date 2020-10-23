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
    public Sprite upAnimation [];
    public Sprite currentAnimation [];
    public float currentFrame = 0;
    public int larg = 64, alt = 128;
    public int velo = 8;

    public boolean espelhado;
    public boolean idle;
    public boolean esquerda;
    public boolean direita;
    public boolean cima;
    public boolean baixo;


    public Texture animCimaTextura[];
    public Sprite animCimaSprite[];
    public Texture animBaixoTextura[];
    public Sprite animBaixoSprite[];
    public Texture animDireitaTextura[];
    public Sprite animDireitaSprite[];
    public Texture animEsquerdaTextura[];
    public Sprite animEsquerdaSprite[];


    public void Criar() {
        tPlayer = new Texture("player.png");
        sPlayer = new Sprite(tPlayer);

        // animação para cima
        animCimaTextura = new Texture[3];
        animCimaSprite = new Sprite[3];

        animCimaTextura[0]=new Texture("player/severinoCI.png");
        animCimaTextura[1]=new Texture("player/severinoCA01.png");
        animCimaTextura[2]=new Texture("player/severinoCA02.png");

        animCimaSprite[0]=new Sprite(animCimaTextura[0]);
        animCimaSprite[1]=new Sprite(animCimaTextura[1]);
        animCimaSprite[2]=new Sprite(animCimaTextura[2]);

        // animação para baixo
        animBaixoTextura = new Texture[3];
        animBaixoSprite = new Sprite[3];

        animBaixoTextura[0]=new Texture("player/severinoFI.png");
        animBaixoTextura[1]=new Texture("player/severinoFA01.png");
        animBaixoTextura[2]=new Texture("player/severinoFA02.png");

        animBaixoSprite[0]=new Sprite(animBaixoTextura[0]);
        animBaixoSprite[1]=new Sprite(animBaixoTextura[1]);
        animBaixoSprite[2]=new Sprite(animBaixoTextura[2]);

        // animação para direita
        animDireitaTextura = new Texture[3];
        animDireitaSprite = new Sprite[3];

        animDireitaTextura[0]=new Texture("player/severinoLI.png");
        animDireitaTextura[1]=new Texture("player/severinoLA01.png");
        animDireitaTextura[2]=new Texture("player/severinoLA02.png");

        animDireitaSprite[0]=new Sprite(animDireitaTextura[0]);
        animDireitaSprite[1]=new Sprite(animDireitaTextura[1]);
        animDireitaSprite[2]=new Sprite(animDireitaTextura[2]);

        // animação esquerda
        animEsquerdaTextura = new Texture[3];
        animEsquerdaSprite = new Sprite[3];

        animEsquerdaTextura[0]=new Texture("player/severinoLI.png");
        animEsquerdaTextura[1]=new Texture("player/severinoLA01.png");
        animEsquerdaTextura[2]=new Texture("player/severinoLA02.png");

        animEsquerdaSprite[0]=new Sprite(animEsquerdaTextura[0]);
        animEsquerdaSprite[1]=new Sprite(animEsquerdaTextura[1]);
        animEsquerdaSprite[2]=new Sprite(animEsquerdaTextura[2]);
        animEsquerdaSprite[0].flip(true,false);
        animEsquerdaSprite[1].flip(true,false);
        animEsquerdaSprite[2].flip(true,false);
    }

    public void Deletar() {
        tPlayer.dispose();
    }

    public void Desenharr(SpriteBatch aux) {
        if(cima){
            aux.draw(currentAnimation[(int) currentFrame],x,y);
        }
        if(baixo){
            aux.draw(currentAnimation[(int) currentFrame],x,y);
        }
        if(direita){
            aux.draw(currentAnimation[(int) currentFrame],x,y);
        }
        if(esquerda){
            aux.draw(currentAnimation[(int) currentFrame],x,y);
        }
        if(idle){
            aux.draw(currentAnimation[0],x,y);
        }

    }
}
