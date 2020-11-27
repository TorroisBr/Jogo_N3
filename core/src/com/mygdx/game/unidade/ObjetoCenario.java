package com.mygdx.game.unidade;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class ObjetoCenario extends Unidade {
    public String caminho;
    public Texture texture;
    public Sprite sprite;

    public ObjetoCenario(int x, int y, int lar, int alt,String caminho) {
        this.hitboxDano=new Rectangle(x, y, lar, alt);
        this.caminho=caminho+".png";
    }

    @Override
    public void iniciar() {
        texture = new Texture(caminho);
        sprite = new Sprite(texture);
    }
}
