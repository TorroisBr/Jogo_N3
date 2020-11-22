package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.tiro.Tiro;
import com.mygdx.game.unidade.Unidade;

import static com.mygdx.game.MyGdxGame2.jogador;

public abstract class Inimigo extends Unidade {

    public int vida;
    public int x;
    public int y;
    public int direcao;
    public int velo;
    public Rectangle hitboxMapa;
    public boolean morto;
    public float tempo = 0;
    public int movX, movY;
    public int animAtual=1;
    public float currentFrame = 0;;

    public abstract void Andar();

    public abstract void Atacar();

    public abstract void Draw();
    public abstract void morrendo();

    public void tomarDano(int dano) {
        vida -= dano;

    }

    public void Move() {
        if (movX > 0) {
            x += movX;
        } else if (movX < 0) {
            x += movX;
        }

        if (movY < 0) {
            y += movY;
        } else if (movY > 0) {
            y += movY;
        }

        movX = 0;
        movY = 0;

        AtualizaRetangulos();
    }


    public void LevandoDano() {
        tempo += Gdx.graphics.getDeltaTime();
        if (tempo  <= 0.5) {

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
            Move();
        }
        //SE O TEMPO FOR SUPERIOR A 3 FRAMES RESETA ELE
        else {
            if (vida > 0) {
                currentFrame=0;
                estado = 0;
                animAtual=1;
            } else {
                direcao=0;
                currentFrame=0;
                estado = -1;
                animAtual=5;
            }

        }
    }


        public void DanoEspada () {
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
                currentFrame=0;
                animAtual=4;
            }
        }

        public void DanoFlecha () {
//        if(hitboxDano.overlaps(tiro.hitbox)){
//            tomarDano(tiro.dano);

        }
//    }




        public void Drop () {
            //Pegar itens da lista de itens do GameController
        }

        public void AtualizaRetangulos () {
            hitboxDano.set(x, y, hitboxDano.width, hitboxDano.height);
            hitboxMapa.set(x, y, hitboxMapa.width, hitboxMapa.height);
        }
    }