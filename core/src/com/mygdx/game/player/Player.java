package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.lang.reflect.Array;

public class Player {
    public int x = 0;
    public int y = 0;

    public int largImagen, altImagen;
    public int largHitbox=86, altHitbox=122;

    public Texture tPlayer;
    public Sprite sPlayer;
    public int velo = 5;

    public Sprite currentAnimation[];
    public float currentFrame = 0;


    //LADOS DO PLAYER
    public boolean espelhado;
    public boolean idle;
    public boolean esquerda;
    public boolean direita;
    public boolean cima;
    public boolean baixo;

    //VETORES
    public Texture animCimaTextura[];
    public Sprite animCimaSprite[];
    public Texture animBaixoTextura[];
    public Sprite animBaixoSprite[];
    public Texture animDireitaTextura[];
    public Sprite animDireitaSprite[];
    public Texture animEsquerdaTextura[];
    public Sprite animEsquerdaSprite[];


    public void Criar() {
        //IMPORT DAS IMAGENS EM TEXTURA E TRANSFORMAR EM SPRITE
        carregarPlayer();
        largImagen = tPlayer.getWidth();
        altImagen = tPlayer.getHeight();
        largHitbox = largImagen;


    }
        //DELETA AS TEXTURAS
    public void Deletar() {
        tPlayer.dispose();

    }
        //VERIFICA QUAL LADO o player esta olhando e desenha com o batch passado
    public void Desenharr(SpriteBatch aux) {
        if (cima) {
            aux.draw(currentAnimation[(int) currentFrame], x + largHitbox / 2 - largImagen / 2, y - altImagen / 2);
        }
        if (baixo) {
            aux.draw(currentAnimation[(int) currentFrame], x, y - altImagen / 2);
        }
        if (direita) {
            aux.draw(currentAnimation[(int) currentFrame], x, y - altImagen / 2);
        }
        if (esquerda) {
            aux.draw(currentAnimation[(int) currentFrame], x, y - altImagen / 2);
        }
        if (idle) {
            aux.draw(currentAnimation[0], x, y);
        }

    }

    public void animar(Player aux, Sprite[] direcao) {
        if (aux.currentAnimation != direcao) {
            aux.currentAnimation = direcao;
            aux.currentFrame = 0;
        } else {
            aux.currentFrame += Gdx.graphics.getRawDeltaTime() * 5;
            if ((int) aux.currentFrame > aux.currentAnimation.length - 1) {
                //tranformar esse 5 em variavel de controle de velocidade
                aux.currentFrame = 0;
            }
        }
    }
            //CARREGA TODAS IMAGENS EM SEUS VETORES
    public void carregarPlayer() {
        tPlayer = new Texture("player.png");
        sPlayer = new Sprite(tPlayer);

        animCimaTextura = new Texture[3];
        animCimaSprite = new Sprite[3];

        animCimaTextura[0] = new Texture("player/severinoCI.png");
        animCimaTextura[1] = new Texture("player/severinoCA01.png");
        animCimaTextura[2] = new Texture("player/severinoCA02.png");

        animCimaSprite[0] = new Sprite(animCimaTextura[0]);
        animCimaSprite[1] = new Sprite(animCimaTextura[1]);
        animCimaSprite[2] = new Sprite(animCimaTextura[2]);

        // animação para baixo
        animBaixoTextura = new Texture[3];
        animBaixoSprite = new Sprite[3];

        animBaixoTextura[0] = new Texture("player/severinoFI.png");
        animBaixoTextura[1] = new Texture("player/severinoFA01.png");
        animBaixoTextura[2] = new Texture("player/severinoFA02.png");

        animBaixoSprite[0] = new Sprite(animBaixoTextura[0]);
        animBaixoSprite[1] = new Sprite(animBaixoTextura[1]);
        animBaixoSprite[2] = new Sprite(animBaixoTextura[2]);

        // animação para direita
        animDireitaTextura = new Texture[3];
        animDireitaSprite = new Sprite[3];

        animDireitaTextura[0] = new Texture("player/severinoLI.png");
        animDireitaTextura[1] = new Texture("player/severinoLA01.png");
        animDireitaTextura[2] = new Texture("player/severinoLA02.png");

        animDireitaSprite[0] = new Sprite(animDireitaTextura[0]);
        animDireitaSprite[1] = new Sprite(animDireitaTextura[1]);
        animDireitaSprite[2] = new Sprite(animDireitaTextura[2]);

        // animação esquerda
        animEsquerdaTextura = new Texture[3];
        animEsquerdaSprite = new Sprite[3];

        animEsquerdaTextura[0] = new Texture("player/severinoLI.png");
        animEsquerdaTextura[1] = new Texture("player/severinoLA01.png");
        animEsquerdaTextura[2] = new Texture("player/severinoLA02.png");

        animEsquerdaSprite[0] = new Sprite(animEsquerdaTextura[0]);
        animEsquerdaSprite[1] = new Sprite(animEsquerdaTextura[1]);
        animEsquerdaSprite[2] = new Sprite(animEsquerdaTextura[2]);
        animEsquerdaSprite[0].flip(true, false);
        animEsquerdaSprite[1].flip(true, false);
        animEsquerdaSprite[2].flip(true, false);
    }

}
