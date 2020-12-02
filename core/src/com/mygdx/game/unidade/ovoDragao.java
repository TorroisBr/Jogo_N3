package com.mygdx.game.unidade;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.unidade.inimigo.Inimigo;

import static com.mygdx.game.MyGdxGame2.jogador;
import static com.mygdx.game.MyGdxGame2.tela;
import static com.mygdx.game.controladores.PontosController.inimigosMortos;


public class ovoDragao extends Unidade {
    public Texture texture;
    public Sprite sprite;

    public ovoDragao(int x, int y, int larg, int alt) {
        this.x = x;
        this.y = y;
        this.hitboxDano = new Rectangle(x, y, larg, alt);

        texture = new Texture("player/severinoFI.png");
        sprite = new Sprite(texture);
    }

    public void colisao() {
        if (hitboxDano.overlaps(jogador.hitboxMapa))
            tela = 4;
    }

    @Override
    public void iniciar() {
        //nada
    }
}
