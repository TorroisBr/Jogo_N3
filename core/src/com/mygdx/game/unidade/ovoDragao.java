package com.mygdx.game.unidade;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.CameraView.Desenhar;
import static com.mygdx.game.MyGdxGame2.*;
import static com.mygdx.game.MyGdxGame2.camera;


public class ovoDragao extends Unidade {
    public Texture[] texture;
    public Sprite[] sprite;

    public float tempo;

    public ovoDragao(int x, int y, int larg, int alt) {
        this.x = x;
        this.y = y;
        this.hitboxDano = new Rectangle(x, y, larg, alt);
        this.tempo = 0;
        this.estado = 0;

        texture = new Texture[3];
        sprite = new Sprite[3];

        texture[0] = new Texture("objetos/OvoDragao_Normal.png");
        texture[1] = new Texture("objetos/OvoDragao_EscudoVerde.png");
        texture[2] = new Texture("objetos/OvoDragao_EscudoAzul.png");

        sprite[0] = new Sprite(texture[0]);
        sprite[1] = new Sprite(texture[1]);
        sprite[2] = new Sprite(texture[2]);
    }

    public void colisao() {
        if (hitboxDano.overlaps(jogador.hitboxMapa))
        {
            soundController.tocarMusica(1);
            tela = 4;
        }
    }

    public void Draw()
    {
        if(estado == 0)
        {
            tempo += Gdx.graphics.getDeltaTime();

            if(tempo < 1.5)
            {
                Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) sprite[1].getWidth() / 2, y + (int) hitboxDano.getHeight() / 2 - (int) sprite[1].getHeight() / 2, sprite[1], batch, camera);
            }
            else
            {
                Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) sprite[2].getWidth() / 2, y + (int) hitboxDano.getHeight() / 2 - (int) sprite[2].getHeight() / 2, sprite[2], batch, camera);
            }

            if(tempo > 3)
            {
                tempo = 0;
            }
        }
        else
        {
            Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) sprite[0].getWidth() / 2, y + (int) hitboxDano.getHeight() / 2 - (int) sprite[0].getHeight() / 2, sprite[0], batch, camera);
        }
    }

    @Override
    public void iniciar() {
        //Nada.
    }
}
