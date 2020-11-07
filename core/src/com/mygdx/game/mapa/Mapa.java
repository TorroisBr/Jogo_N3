package com.mygdx.game.mapa;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.tiro.Tiro;
import com.mygdx.game.unidade.Npc;
import com.mygdx.game.unidade.Unidade;


public class Mapa {
    public Sprite spriteLocal[];
    public int posicaoSprite[][];
    public Rectangle colisoes[];
    public Inimigo inimgosLocal[];
    public Npc npcLocal[];
    public Tiro tiroLocal[];
    public Portas portaLocal[];
    // public Unidade propsLocal[];
}
