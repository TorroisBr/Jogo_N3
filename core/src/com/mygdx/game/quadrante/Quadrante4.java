package com.mygdx.game.quadrante;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Quadrante4 extends ApplicationAdapter {
    public int x=0,y=0;
    public int larg=1664,alt=1668;
    public Texture textura;
    public Sprite sprite;
    SpriteBatch batch;
    //metodo de criação da imagem/textura

    public void Criar(){
        batch = new SpriteBatch();
        textura= new Texture("b1.png");
        sprite= new Sprite(textura);
    }
    public void Desenhar(){
        batch.begin();
        batch.draw(sprite,x, y);
        batch.end();

    }
    public void Deletar(){
        textura.dispose();
    }

}

