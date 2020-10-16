package com.mygdx.game.quadrante;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame2;

public class Quadrante extends ApplicationAdapter {
    public int x2=0,x3=0,x4=0,x5=0,x6=0,x8=0;
    public int y2=0,y3=0,y4=0,y5=0,y6=0,y8=0;
    public int tam2=1765,tam3=1553,tam4=1664,tam5=1773,tam6=1557,tam8=1780;
    public int larg2=1662,larg3=1649,larg4=1668,larg5=1685,larg6=1685,larg8=1647;
    public Texture t2,t3,t4,t5,t6,t8;
    public Sprite  s2,s3,s4,s5,s6,s8;
    //metodo de criação da imagem/textura
    SpriteBatch batch;
    //metodo de criação da imagem/textura
    public void Criar(){
        batch = new SpriteBatch();

        t2= new Texture("A2.png");
        s2= new Sprite(t2);

        t3= new Texture("A3.png");
        s3= new Sprite(t3);

        t4= new Texture("b1.png");
        s4= new Sprite(t4);

        t5= new Texture("b2.png");
        s5= new Sprite(t5);

        t6= new Texture("b3.png");
        s6= new Sprite(t6);

        t8= new Texture("c2.png");
        s8= new Sprite(t8);
    }
    public int Desenhar(int aux){
        batch.begin();
        if(aux==2)
            batch.draw(s2,x2,y2);
        if(aux==3)
            batch.draw(s3,x3,y3);
        if(aux==4){
            batch.draw(s4,x4,y4);
        }
        if(aux==5)
            batch.draw(s5,x5,y5);
        if(aux==6)
            batch.draw(s6,x6,y6);
        if(aux==8)
            batch.draw(s8,x8,y8);
        batch.end();

    return x4;
    }
    public void Deletar(){
        t2.dispose();
        t3.dispose();
        t4.dispose();
        t5.dispose();
        t6.dispose();
        t8.dispose();

    }

}


