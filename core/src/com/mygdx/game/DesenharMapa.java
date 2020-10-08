package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.quadrante.*;

public class DesenharMapa extends ApplicationAdapter {
    Quadrante2 Q2=new Quadrante2();
    Quadrante3 Q3=new Quadrante3();
    Quadrante4 Q4=new Quadrante4();
    Quadrante5 Q5=new Quadrante5();
    Quadrante6 Q6=new Quadrante6();
    Quadrante8 Q8=new Quadrante8();
    SpriteBatch batch;

    public void Desenhar(){

        batch.draw(Q2.sprite, Q2.sprite.getX(), Q2.sprite.getY());

    }
}
