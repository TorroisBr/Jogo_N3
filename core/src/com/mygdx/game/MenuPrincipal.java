package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.mygdx.game.MyGdxGame2.*;

public class MenuPrincipal {
    public Texture[] texture;
    public Sprite[] sprite;
    public Color cor;

    public MenuPrincipal() {
        cor = batch.getColor();

        texture = new Texture[14];
        texture[0] = new Texture("Menus/Bergamota2_Capa.png");
        texture[1] = new Texture("Menus/Sensatos_Black.png");
        texture[2] = new Texture("Menus/Creditos.png");
        texture[3] = new Texture("Menus/Creditos_Expandido.png");
        texture[4] = new Texture("Menus/Instrucoes.png");
        texture[5] = new Texture("Menus/Instrucoes_Expandido.png");
        texture[6] = new Texture("Menus/Jogar.png");
        texture[7] = new Texture("Menus/Jogar_Expandido.png");
        texture[8] = new Texture("Menus/Sair.png");
        texture[9] = new Texture("Menus/Sair_Expandido.png");
        texture[10] = new Texture("Menus/Bergamota2_Instrucoes.png");
        texture[11] = new Texture("Menus/Bergamota2_Creditos.png");
        texture[12] = new Texture("Menus/Bergamota_Logo.png");
        texture[13] = new Texture("Menus/TelaPreta.png");

        sprite = new Sprite[14];
        sprite[0] = new Sprite(texture[0]);
        sprite[1] = new Sprite(texture[1]);
        sprite[2] = new Sprite(texture[2]);
        sprite[3] = new Sprite(texture[3]);
        sprite[4] = new Sprite(texture[4]);
        sprite[5] = new Sprite(texture[5]);
        sprite[6] = new Sprite(texture[6]);
        sprite[7] = new Sprite(texture[7]);
        sprite[8] = new Sprite(texture[8]);
        sprite[9] = new Sprite(texture[9]);
        sprite[10] = new Sprite(texture[10]);
        sprite[11] = new Sprite(texture[11]);
        sprite[12] = new Sprite(texture[12]);
        sprite[13] = new Sprite(texture[13]);
    }

    public void Draw(int tela, int selecao) {
        if(tela == -1)
        {
            if(tempoTransicao <= 0)
            {
                cor = batch.getColor();
                batch.setColor(cor.r, cor.g, cor.b, transicaoAlpha);
                batch.draw(sprite[13], 0, 0);
                batch.setColor(cor.r, cor.g, cor.b, 1);
            }
            else if(tempoTransicao < 4)
            {

                cor = batch.getColor();
                batch.setColor(cor.r, cor.g, cor.b, transicaoAlpha);
                batch.draw(sprite[12], telaLarg / 2 - sprite[12].getHeight() / 2, telaAlt / 2 - sprite[12].getWidth() / 2);
                batch.setColor(cor.r, cor.g, cor.b, 1);

                transicaoAlpha += 1 * Gdx.graphics.getDeltaTime();
                if(transicaoAlpha > 1)
                {
                    transicaoAlpha = 1;
                }
            }
            else
            {
                transicaoAlpha += 1 * Gdx.graphics.getDeltaTime();
                if(transicaoAlpha > 1)
                {
                    transicaoAlpha = 1;
                }

                batch.draw(sprite[12], telaLarg / 2 - sprite[12].getHeight() / 2, telaAlt / 2 - sprite[12].getWidth() / 2);

                cor = batch.getColor();
                batch.setColor(cor.r, cor.g, cor.b, transicaoAlpha);
                batch.draw(sprite[13], 0, 0);
                batch.setColor(cor.r, cor.g, cor.b, 1);
            }
        }

        if (tela == 0) {
            batch.draw(sprite[0], 0, 0);
            batch.draw(sprite[1], 35, telaAlt - sprite[1].getRegionHeight() - 50);

            if (selecao == 0) {
                batch.draw(sprite[7], 35 + sprite[1].getWidth() / 2 - sprite[7].getRegionWidth() / 2, 290);
            } else {
                batch.draw(sprite[6], 35 + sprite[1].getWidth() / 2 - sprite[6].getRegionWidth() / 2, 290);
            }

            if (selecao == 1) {
                batch.draw(sprite[5], 35 + sprite[1].getWidth() / 2 - sprite[5].getRegionWidth() / 2, 210);
            } else {
                batch.draw(sprite[4], 35 + sprite[1].getWidth() / 2 - sprite[4].getRegionWidth() / 2, 210);
            }

            if (selecao == 2) {
                batch.draw(sprite[3], 35 + sprite[1].getWidth() / 2 - sprite[3].getRegionWidth() / 2, 130);
            } else {
                batch.draw(sprite[2], 35 + sprite[1].getWidth() / 2 - sprite[2].getRegionWidth() / 2, 130);
            }

            if (selecao == 3) {
                batch.draw(sprite[9], 35 + sprite[1].getWidth() / 2 - sprite[9].getRegionWidth() / 2, 50);
            } else {
                batch.draw(sprite[8], 35 + sprite[1].getWidth() / 2 - sprite[8].getRegionWidth() / 2, 50);
            }

            if(transicaoAlpha > 0)
            {
                cor = batch.getColor();
                batch.setColor(cor.r, cor.g, cor.b, transicaoAlpha);
                batch.draw(sprite[13], 0, 0);
                batch.setColor(cor.r, cor.g, cor.b, 1);

                transicaoAlpha -= 1 * Gdx.graphics.getDeltaTime();
                if(transicaoAlpha < 0)
                {
                    transicaoAlpha = 0;
                }
            }
        }

        if (tela == 1) {
            batch.draw(sprite[10], 0, 0);

            if(transicaoAlpha > 0)
            {
                cor = batch.getColor();
                batch.setColor(cor.r, cor.g, cor.b, transicaoAlpha);
                batch.draw(sprite[13], 0, 0);
                batch.setColor(cor.r, cor.g, cor.b, 1);

                transicaoAlpha -= 1 * Gdx.graphics.getDeltaTime();
                if(transicaoAlpha < 0)
                {
                    transicaoAlpha = 0;
                }
            }
        }

        if (tela == 2) {
            batch.draw(sprite[11], 0, 0);

            if(transicaoAlpha > 0)
            {
                cor = batch.getColor();
                batch.setColor(cor.r, cor.g, cor.b, transicaoAlpha);
                batch.draw(sprite[13], 0, 0);
                batch.setColor(cor.r, cor.g, cor.b, 1);

                transicaoAlpha -= 1 * Gdx.graphics.getDeltaTime();
                if(transicaoAlpha < 0)
                {
                    transicaoAlpha = 0;
                }
            }
        }

        if (tela == 4)
        {
            batch.draw(sprite[0], 0, 0);
        }

    }
}
