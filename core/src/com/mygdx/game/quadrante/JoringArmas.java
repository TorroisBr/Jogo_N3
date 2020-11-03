package com.mygdx.game.quadrante;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MyGdxGame2;

import static com.mygdx.game.CameraView.*;


public class JoringArmas {
    public Texture texture[];
    public Sprite sprite[];
    public int colx=0,coly=0,colLarg=75,colAlt=1000;
    public int colx1=600,coly1=300,colLarg1=75,colAlt1=1000;
    public Rectangle rectangle,rectangle1;
    public Rectangle rectanglesX[];

    public boolean Criar() {
        sprite=new Sprite[1];
        texture=new Texture[1];

        texture[0]= new Texture("A3.png");
        sprite[0]= new Sprite(texture[0]);
        rectangle = new Rectangle(colx, coly, colLarg, colAlt);
        rectangle1 = new Rectangle(colx1, coly1, colLarg1, colAlt1);
        rectanglesX= new Rectangle[]{rectangle, rectangle1};

        return true;
    }

    public Rectangle Parede() {

        return rectangle;
    }


    public void Deletar() {
        texture[0].dispose();
    }
}

