package com.mygdx.game.mapa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.tiro.Tiro;
import com.mygdx.game.unidade.Npc;
import com.mygdx.game.unidade.Unidade;
import com.mygdx.game.unidade.inimigo.Inimigo;

import java.util.Map;


public class Mapa {
    public Texture texturaLocal[];
    public Sprite spriteLocal[];
    public int posicaoSprite[][];
    public Rectangle colisoes[];
    public Inimigo inimgosLocal[];
    public Npc npcLocal[];
    public Tiro tiroLocal[];
    public Portas portaLocal[];

    // public Unidade propsLocal[];
    public Mapa() {


    }

    public void Criar(){
        this.texturaLocal =texturaLocal;
    }

}

