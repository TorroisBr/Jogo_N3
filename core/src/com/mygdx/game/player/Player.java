package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.CameraView.*;
import static com.mygdx.game.MyGdxGame2.*;

import java.lang.reflect.Array;

public class Player {
    public  int x = 300;
    public int y = 300;
    public Rectangle playerHitbox, playerColHitbox;
    public int direcao;
    //direcao: 0=esquerda , 1=cima , 2= direita , 3=baixo;


    public int largImagen, altImagen;
    public int largHitbox = 56, altHitbox = 122 - 9;
    public int colHitboxLarg = 56, colHitboxAlt = 39;

    public Texture tPlayer;
    public Sprite sPlayer;
    public int velo = 5;

    public Sprite currentAnimation[];
    public float currentFrame = 0;
    public float movX = 0, movY = 0;

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

        playerHitbox = new Rectangle(x, y, largHitbox, altHitbox);
        playerColHitbox = new Rectangle(x, y, colHitboxLarg, colHitboxAlt);
    }

    //DELETA AS TEXTURAS
    public void Deletar() {
        tPlayer.dispose();

    }

    //VERIFICA QUAL LADO o player esta olhando e desenha com o batch passado
    public void Desenharr() {
        //CHAMA A FUNÇÂO DE DESENHO DA CLASSE CAMERAVIEW
//        switch (direcao){
//            case 0:Desenhar(x + largHitbox / 2 - largImagen / 2, y - altImagen / 2, currentAnimation[(int) currentFrame], batch, camera);
//                return;
//            case 1:Desenhar(x + largHitbox / 2 - largImagen / 2, y - altImagen / 2, currentAnimation[(int) currentFrame], batch, camera);
//                return;
//        }
//
//        if (cima) {
//
//        }
        if (baixo || direita || cima || esquerda) {
            Desenhar(x + largHitbox / 2 - largImagen / 2, y - altImagen / 2, currentAnimation[(int) currentFrame], batch, camera);

        }
//        if (direita) {
//            Desenhar(x + largHitbox / 2 - largImagen / 2, y - altImagen / 2, currentAnimation[(int) currentFrame], batch, camera);
//
//        }


        AtualizaRetangulos();
    }
    //ATUALIZA AS HITBOX DO PLAYER CONFORME ELE ANDA
    public void AtualizaRetangulos() {
        playerHitbox.set(x, y, largHitbox, altHitbox);
        playerColHitbox.set(x, y, colHitboxLarg, colHitboxAlt);
    }

    //METODO DE ANIMAÇÂO
    public void animar(Player aux, Sprite[] direcao) {
        if (currentAnimation != direcao) {
            currentAnimation = direcao;
            currentFrame = 0;
        } else {
            currentFrame += Gdx.graphics.getRawDeltaTime() * 5;
            if ((int) currentFrame > currentAnimation.length - 1) {
                //tranformar esse 5 em variavel de controle de velocidade
                currentFrame = 0;
            }
        }
    }

    //METODO DE MOVIMENTO
    public void Movimento() {
        if (movX > 0) {//Direita
            x += movX;

        } else if (movX < 0) {//Esquerda
            x -= -movX;

        }


        if (movY > 0) {//Cima
            y += movY;
        } else if (movY < 0) {//Baixo
            y -= -movY;
        }


        movX = 0;
        movY = 0;
//        if (movY != 0) {
//            y += movY;
//            while (ColisaoComCenario(rectangles)) {
//                if (movY > 0)
//                    y--;
//                else
//                    y++;
//                AtualizaRetangulos();
//            }
//            movY = 0;
//        }

    }

    public boolean ColisaoComCenario(Rectangle rectangles[]) {
        for (Rectangle retangulo : rectangles) {
            if (playerColHitbox.overlaps(retangulo))
                return true;
        }
        return false;
    }


    //CARREGA TODAS IMAGENS EM SEUS ARRAYS
    public void carregarPlayer() {
        tPlayer = new Texture("player.png");
        sPlayer = new Sprite(tPlayer);

        animCimaTextura = new Texture[3];
        animCimaSprite = new Sprite[4];

        animCimaTextura[0] = new Texture("player/severinoCI.png");
        animCimaTextura[1] = new Texture("player/severinoCA01.png");
        animCimaTextura[2] = new Texture("player/severinoCA02.png");

        animCimaSprite[0] = new Sprite(animCimaTextura[0]);
        animCimaSprite[1] = new Sprite(animCimaTextura[1]);
        animCimaSprite[2] = new Sprite(animCimaTextura[0]);
        animCimaSprite[3] = new Sprite(animCimaTextura[2]);

        // animação para baixo
        animBaixoTextura = new Texture[3];
        animBaixoSprite = new Sprite[4];

        animBaixoTextura[0] = new Texture("player/severinoFI.png");
        animBaixoTextura[1] = new Texture("player/severinoFA01.png");
        animBaixoTextura[2] = new Texture("player/severinoFA02.png");

        animBaixoSprite[0] = new Sprite(animBaixoTextura[0]);
        animBaixoSprite[1] = new Sprite(animBaixoTextura[1]);
        animBaixoSprite[2] = new Sprite(animBaixoTextura[0]);
        animBaixoSprite[3] = new Sprite(animBaixoTextura[2]);

        // animação para direita
        animDireitaTextura = new Texture[3];
        animDireitaSprite = new Sprite[4];

        animDireitaTextura[0] = new Texture("player/severinoLI.png");
        animDireitaTextura[1] = new Texture("player/severinoLA01.png");
        animDireitaTextura[2] = new Texture("player/severinoLA02.png");

        animDireitaSprite[0] = new Sprite(animDireitaTextura[0]);
        animDireitaSprite[1] = new Sprite(animDireitaTextura[1]);
        animDireitaSprite[2] = new Sprite(animDireitaTextura[0]);
        animDireitaSprite[3] = new Sprite(animDireitaTextura[2]);

        // animação esquerda
        animEsquerdaTextura = new Texture[3];
        animEsquerdaSprite = new Sprite[4];

        animEsquerdaTextura[0] = new Texture("player/severinoLI.png");
        animEsquerdaTextura[1] = new Texture("player/severinoLA01.png");
        animEsquerdaTextura[2] = new Texture("player/severinoLA02.png");

        animEsquerdaSprite[0] = new Sprite(animEsquerdaTextura[0]);
        animEsquerdaSprite[1] = new Sprite(animEsquerdaTextura[1]);
        animEsquerdaSprite[2] = new Sprite(animEsquerdaTextura[0]);
        animEsquerdaSprite[3] = new Sprite(animEsquerdaTextura[2]);

        animEsquerdaSprite[0].flip(true, false);
        animEsquerdaSprite[1].flip(true, false);
        animEsquerdaSprite[2].flip(true, false);
        animEsquerdaSprite[3].flip(true, false);
    }

}
