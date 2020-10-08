package com.mygdx.game.quadrante;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Quadrante3 extends ApplicationAdapter {
    public int x,y;
    public int tam,larg;
    public Texture textura;
    public Sprite sprite;
    //metodo de criação da imagem/textura
    SpriteBatch batch;
    //metodo de criação da imagem/textura

    public void Criar(){
        batch = new SpriteBatch();
        textura= new Texture("A3.png");
        sprite= new Sprite(textura);
    }
    public void Desenhar(){
        batch.begin();
        batch.draw(sprite,sprite.getX(), sprite.getY());
        batch.end();

    }
    public void Deletar(){
        textura.dispose();
    }

}


