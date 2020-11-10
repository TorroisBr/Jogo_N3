package com.mygdx.game.controladores;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.inimigo.Inimigo;

public class RotinaInimigo {

    public int direcaoAntes,direcaoDepois;
    public Rectangle hitbox;

    public RotinaInimigo(int direcaoAntes, int direcaoDepois, int x, int y, int larg, int alt){
        this.direcaoAntes = direcaoAntes;
        this.direcaoDepois = direcaoDepois;
        this.hitbox = new Rectangle(x, y, larg, alt);
    }

    public void trocarDirecao(Inimigo inimigo){
        if (inimigo.direcao == direcaoAntes){
            inimigo.direcao = direcaoDepois;
        }
    }

    public void Colidir(Inimigo InimigoLocal[]){
        for(Inimigo inimigo: InimigoLocal){
            if(inimigo.hitboxDano.overlaps(hitbox)){
                trocarDirecao(inimigo);
            }
        }
    }
}