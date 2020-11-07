package com.mygdx.game.unidade;

import com.badlogic.gdx.math.Rectangle;

public abstract class Inimigo extends Unidade {

    public int vida;
    public int direcao;
    public int vela;
    public float movX = 0, movY = 0;
    public int velo;
    Rectangle hitboxMapa;
    int hitboxMapaLarg, hitboxMapaAlt;

    public abstract void Andar();

    public abstract void Atacar();

    public void tomarDano(int dano){
        vida -= dano;
        if (vida <= 0)
            morrer();

    }

    public void morrer(){
        if (vida == 0){
            //AIIII
        }
    }

    public void Drop(){
        //Pegar itens da lista de itens do GameController
    }
}