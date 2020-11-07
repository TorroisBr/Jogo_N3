package com.mygdx.game.item;

import com.badlogic.gdx.math.Rectangle;

public class Arco extends Item {

    public Arco(String nome, int larg, int alt, int dano) {
        this.nome = nome;
        this.tipoEquipamento = 1;

    }

    //TRAVAR JOGADOR NA POSICAO DE TIRO PARA ASSIM ATIRAR
    public void Mirar() {

    }

    //ATIRAR A FLECHA BASEADO EM MIRAR
    public void Atirar() {

        ConsumirFlecha();
    }//CONSOME A PROPRIA FLECHA QUE ACABOU DE SER CRIADA

    public void ConsumirFlecha() {

    }
}
