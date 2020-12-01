package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.Unidade;

import static com.mygdx.game.MyGdxGame2.*;

public abstract class Inimigo extends Unidade {

    public int vida;
    public int x;
    public int y;
    public int direcao;
    public int velo;
    public Rectangle hitboxMapa;
    public float tempo = 0;
    public int movX, movY;
    public int animAtual = 1;
    public float currentFrame = 0;


    public abstract void Andar();

    public abstract void Atacar();

    public abstract void Draw();

    public abstract void morrendo();

    public void tomarDano(int dano) {
        vida -= dano;

    }

    public void Move(Rectangle[] retangulo) {
        if (movX != 0) {
            x += movX;
            AtualizaRetangulos();
            while (ColisaoComCenario(retangulo)) {
                if (movX > 0)
                    x--;
                else
                    x++;
                AtualizaRetangulos();
            }
            movX = 0;
        }
        if (movY != 0) {
            y += movY;
            AtualizaRetangulos();
            while (ColisaoComCenario(retangulo)) {
                if (movY > 0)
                    y--;
                else
                    y++;
                AtualizaRetangulos();
            }
            movY = 0;
        }

    }

    public boolean ColisaoComCenario(Rectangle[] rectangles) {
        for (Rectangle retangulo : rectangles) {
            if (hitboxMapa.overlaps(retangulo))
                return true;
        }
        return false;
    }


    public void LevandoDano() {
        tempo += Gdx.graphics.getDeltaTime();
        if (tempo <= 0.5) {

            switch (direcao) {
                //VERIFICA A DIRECAO DO INIMIGO E CAUSA UMA REPULSAO

                case 0:
                    movY = (int) ((float) jogador.espada.repulsao * Gdx.graphics.getDeltaTime());
                    break;
                case 1:
                    movX = (int) ((float) jogador.espada.repulsao * Gdx.graphics.getDeltaTime());
                    break;
                case 2:
                    movY = -(int) ((float) jogador.espada.repulsao * Gdx.graphics.getDeltaTime());
                    break;
                case 3:
                    movX = -(int) ((float) jogador.espada.repulsao * Gdx.graphics.getDeltaTime());
                    break;
            }
            Move(mapas[fundoatual].colisoes);
        }
        //SE O TEMPO FOR SUPERIOR A 3 FRAMES RESETA ELE
        else {
            if (vida > 0) {
                currentFrame = 0;
                estado = 0;
                animAtual = 1;
            } else {
                currentFrame = 0;
                tempo = 0;
                estado = -1;
                soundController.tocarSom(16);

                if (this instanceof Ladrao)
                    animAtual = 4;
                if (this instanceof Slime) {
                    direcao = 0;
                    animAtual = 5;
                }
            }

        }
    }


    public void DanoEspada() {
        if (jogador.espada.hitbox.overlaps(hitboxDano)) {
            tempo = 0;
            //SO PERMITE QUE ACERTE O JOGADOR EM UM FRAME
            estado = 2;
            tomarDano(jogador.espada.dano);
            switch (jogador.direcao) {
                case 0:
                    this.direcao = 2;
                    break;
                case 1:
                    this.direcao = 3;
                    break;
                case 2:
                    this.direcao = 0;
                    break;
                case 3:
                    this.direcao = 1;
                    break;
            }
            currentFrame = 0;
            if (this instanceof Slime)
                animAtual = 4;
            if (this instanceof Ladrao)
                animAtual = 3;

            soundController.tocarSom(15);
        }
    }

    public void Drop() {
        //Pegar itens da lista de itens do GameController
    }

    public void AtualizaRetangulos() {
        hitboxDano.set(x, y, hitboxDano.width, hitboxDano.height);
        hitboxMapa.set(x, y, hitboxMapa.width, hitboxMapa.height);
    }
}