package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.mygdx.game.MyGdxGame2.*;

public class HUD {
    public Texture[] texture;
    public Sprite[] sprite;

    public HUD ()
    {
        texture = new Texture[4];
        texture[0] = new Texture("HUD/HP_Bar_No_HP.png");
        texture[1] = new Texture("HUD/HP_Point.png");
        texture[2] = new Texture("HUD/HP_Point_Empty.png");
        texture[3] = new Texture("HUD/Espada.png");

        sprite = new Sprite[4];
        sprite[0] = new Sprite(texture[0]);
        sprite[1] = new Sprite(texture[1]);
        sprite[2] = new Sprite(texture[2]);
        sprite[3] = new Sprite(texture[3]);
    }

    public void Draw() {
        batch.draw(sprite[0], 15, telaAlt - 15 - (int) sprite[0].getHeight());
        for(int i=0; i < jogador.vidaMax; i++)
        {
            batch.draw(sprite[2], 15 + 114 + (26 * i), telaAlt - 15 - (int) sprite[0].getHeight() + 7);

            if(i < jogador.vida)
            {
                batch.draw(sprite[1], 15 + 114 + (26 * i), telaAlt - 15 - (int) sprite[0].getHeight() + 7);
            }
        }

        batch.draw(sprite[3], telaLarg - 15 - sprite[3].getWidth(), 15);
    }
}
