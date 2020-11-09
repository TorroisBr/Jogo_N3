package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.Inimigo;

public class Slime extends Inimigo {

    public Slime(int x, int y, int direcao, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt){
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.vida = 200;
        this.velo = 3;
        this.estado = 0;
        this.hitboxDano = new Rectangle(x, y, HitBoxDanoLarg, HitBoxDanoAlt);
        this.hitboxMapa = new Rectangle(x, y, HitBoxMapaLarg, HitBoxMapaAlt);
    }

    @Override
    public void Andar() {
        if (direcao == 1) {//Esquerda
            x += velo;
        } else if (direcao == 3) {//Direita
            x -= velo;

        }
        if (direcao == 2) {//Cima
            y += velo;
        } else if (direcao == 0) {//Baixo
            y -= velo;
        }
    }

    @Override
    public void Atacar() {
        if (hitboxDano.overlaps())
    }

    @Override
    public void iniciar() {


    }
}
