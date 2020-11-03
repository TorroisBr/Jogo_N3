package com.mygdx.game.quadrante;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CIDADE {
    public Texture texture[];
    public Sprite sprite[];
    public int xy[][];
    public static Portas porta1;

    public boolean Criar(){
        sprite=new Sprite[2];
        texture=new Texture[2];
        xy=new int[2][2];

        texture[0]= new Texture("B1.png");
        sprite[0]= new Sprite(texture[0]);


        texture[1]= new Texture("B2.png");
        sprite[1]= new Sprite(texture[1]);

        xy[0][0]=0;
        xy[0][1]=0;

        xy[1][0]=(int) sprite[0].getWidth();
        xy[1][1]=0;

        //IMPORTANDO IAMAGENS E DEFININDO POSICAO X,Y

        //CRIANDO PORTA PARA TRANSICAO
          porta1=new Portas(600,600,50,50,4,50,50);


        return true;
    }
}
