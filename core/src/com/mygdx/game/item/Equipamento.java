package com.mygdx.game.item;

public class Equipamento extends Item {
    int estato;

    public Equipamento(int tipoEquipamento, String nome, int estato) {
        this.tipoEquipamento = tipoEquipamento;
        this.nome = nome;
        this.estato = estato;
    }
    //ATRIBUI OS ESTATOS AO JOGADOR
    public void Equipar(){

    }
}
