package com.mygdx.game.unidade;

import com.badlogic.gdx.math.Rectangle;

public abstract class Inimigo extends Unidade {

    public int vida;
    public int x;
    public int y;
    public int direcao;
    public int velo;
    public int estado;
    public Rectangle hitboxMapa;

    public abstract void Andar();

    public abstract void Atacar();

    public void tomarDano(int dano) {
        vida -= dano;
        if (vida <= 0)
            morrer();

    }

    public void morrer() {
        //AIIII
    }

    public void Drop() {
        //Pegar itens da lista de itens do GameController
    }

    public void AtualizaRetangulos() {
        hitboxDano.set(x, y, hitboxDano.width, hitboxDano.height);
        hitboxMapa.set(x, y, hitboxMapa.width, hitboxMapa.height);
    }
}