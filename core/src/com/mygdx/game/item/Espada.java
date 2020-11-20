package com.mygdx.game.item;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.Unidade;
import com.mygdx.game.unidade.inimigo.Inimigo;

public class Espada extends Arma {
    public Rectangle hitbox;
     public int dano;
    public float cdr;

    public Espada(String nome,int larg,int alt,int dano,float espadacdr){
        this.nome=nome;
        this.tipoEquipamento=0;
        this.hitbox=new Rectangle(0,0,larg,alt);
        this.dano=dano;
        this.cdr=espadacdr;

    }

    //ALTERA ESTADO DO PERSONAGEM PARA ATACANDO
    public void Atacar(){

    }



}
