package com.mygdx.game.tiro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Flecha extends Tiro {
    public int estado;
    public int direcao;
    public int dano;


    public Texture texture[];
    public Sprite sprites[];

    public Flecha(int x,int y,int direcao,int dano){
        this.x=x;
        this.y=y;
        this.estado=1;
        this.direcao=direcao;
        this.dano=dano;

    }

    //VERIFICA SE ENCOSTOU EM ALGUMA HITBOX


    //ADICIONAR UMA FLECA A MAIS AO JOGADOR E SE DESTRUIR
    public void serPego(){

    }

    //CAUSA DANO A HITBOX INTERAGIDO
    public void causarDano(){

    }

    @Override
    public void conferindoInteracao(){
        //causarDano();
        //serPego();
    }

    @Override
    public void seMover() {



    }
}
