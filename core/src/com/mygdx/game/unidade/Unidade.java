package com.mygdx.game.unidade;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.inimigo.Ladrao;
import com.mygdx.game.unidade.inimigo.Slime;

public abstract class Unidade implements Comparable{

    public int x;
    public int y;
    public Rectangle hitboxDano;
    public int HitBoxDanoLarg, HitBoxDanoAlt;
    public boolean visivel;
    public int estado;

    @Override
    public int compareTo(Object o) {

        if(o instanceof Slime)
        {
            Slime objeto = (Slime) o;

            if(hitboxDano.y < objeto.hitboxDano.y)
            {
                return 1;
            }
            else if(hitboxDano.y > objeto.hitboxDano.y)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        if(o instanceof Ladrao)
        {
            Ladrao objeto = (Ladrao) o;

            if(hitboxDano.y < objeto.hitboxDano.y)
            {
                return 1;
            }
            else if(hitboxDano.y > objeto.hitboxDano.y)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        if(o instanceof Jogador)
        {
            Jogador objeto = (Jogador) o;

            if(hitboxDano.y < objeto.hitboxDano.y)
            {
                return 1;
            }
            else if(hitboxDano.y > objeto.hitboxDano.y)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        if(o instanceof ObjetoCenario)
        {
            ObjetoCenario objeto = (ObjetoCenario) o;

            if(hitboxDano.y < objeto.hitboxDano.y)
            {
                return 1;
            }
            else if(hitboxDano.y > objeto.hitboxDano.y)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        return 0;
    }

    public abstract void iniciar();

}

