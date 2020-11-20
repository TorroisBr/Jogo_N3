package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.Unidade;
import static com.mygdx.game.MyGdxGame2.jogador;

public abstract class Inimigo extends Unidade {

    public int vida;
    public int x;
    public int y;
    public int direcao;
    public int velo;
    public int estado;
    public Rectangle hitboxMapa;
    public boolean morto;

    public abstract void Andar();

    public abstract void Atacar();

    public abstract void Draw();

    //CHAMA O METODO QUE INFLIGE DANO NOS INIMIGOS QUE VERIFICA SE HOUVE COLISÂO E PASSA O DANO
    public void tomarDano() {
        if (jogador.espada.hitbox.overlaps(hitboxDano))
            vida -= jogador.espada.dano;
        //System.out.println("Dano Causado: " + jogador.espada.dano + " Vida Restante: " + vida);
        if (vida <= 0)
            morrer();

    }

    public void morrer() {
        System.out.println("Morri");
    }


    public void Drop() {
        //Pegar itens da lista de itens do GameController
    }

    public void AtualizaRetangulos() {
        hitboxDano.set(x, y, hitboxDano.width, hitboxDano.height);
        hitboxMapa.set(x, y, hitboxMapa.width, hitboxMapa.height);
    }
}