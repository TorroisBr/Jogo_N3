package com.mygdx.game.mapa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.tiro.Tiro;
import com.mygdx.game.unidade.Npc;
import com.mygdx.game.unidade.Unidade;
import com.mygdx.game.unidade.inimigo.Inimigo;


public class Mapa {
    public Texture texturaLocal[];
    public Sprite spriteLocal[];
    public Sprite objetosLocal[];
    public int posicaoSprite[][];
    public Rectangle colisoes[];
    public Array<Inimigo> inimigoarray;
    //    public Npc npcLocal[];
    public Array<Tiro> tiroarray;
    public Rectangle todosRetangulos[][];
    public Array<Unidade> tudoArray;


    public Portas portaLocal[];


    // public Unidade propsLocal[];


    public Mapa() {
        this.inimigoarray = new Array<Inimigo>();
        this.tiroarray = new Array<Tiro>();
        this.tudoArray=new Array<Unidade>();

    }

}

