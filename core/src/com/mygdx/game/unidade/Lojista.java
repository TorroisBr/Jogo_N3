package com.mygdx.game.unidade;

import com.badlogic.gdx.math.Rectangle;

public class Lojista extends Npc {
    public Lojista(int x, int y, int direcao, Rectangle hitboxDano, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt) {
        super(x, y, direcao, hitboxDano, HitBoxDanoLarg, HitBoxDanoAlt, HitBoxMapaLarg, HitBoxMapaAlt);
    }

    //ABRE O MENU DE COMPRA DO NPC se for um lojista
    public void AbrirInvetarioLoja() {

    }


}
