package com.mygdx.game.item;

import com.badlogic.gdx.math.Rectangle;

public class Espada extends Arma {
    Rectangle hitbox;
    int dano;

    public Espada(String nome,int larg,int alt,int dano){
        this.nome=nome;
        this.tipoEquipamento=0;
        this.hitbox=new Rectangle(0,0,larg,alt);
        this.dano=dano;

    }

    //ALTERA ESTADO DO PERSONAGEM PARA ATACANDO
    public void Atacar(){

    }

    //CHAMA O METODO QUE INFLIGE DANO NOS INIMIGOS
    public void CausarDano(){
        //if(hitbox.overlaps(inimigo.hitbox))
    }
}
