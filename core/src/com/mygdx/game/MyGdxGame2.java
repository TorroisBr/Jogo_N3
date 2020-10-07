package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.cidade.Casa;
import com.mygdx.game.cidade.Quadrante2;
import com.mygdx.game.cidade.Quadrante3;
import com.mygdx.game.player.Player;

public class MyGdxGame2 extends ApplicationAdapter {
    Quadrante2 Q2=new Quadrante2();
    Quadrante3 Q3=new Quadrante3();
    SpriteBatch batch;
    int fundoatual = 4;
    Casa npcCasa = new Casa();
    Player jogador = new Player();
    Sprite sa2, sa3, sb1, sb2, sb3, sc2;
    Texture ta2, ta3, tb1, tb2, tb3, tc2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        jogador.tPlayer = new Texture("player.png");
        Q2.criar();
        Q3.criar();
//        ta2 = new Texture("A2.png");
//        sa2 = new Sprite(ta2);

//        ta3 = new Texture("A3.png");
//        sa3 = new Sprite(ta3);
        tb1 = new Texture("B1.png");
        sb1 = new Sprite(tb1);
        tb2 = new Texture("B2.png");
        sb2 = new Sprite(tb2);
        tb3 = new Texture("B3.png");
        sb3 = new Sprite(tb3);
        tc2 = new Texture("C2.png");
        sc2 = new Sprite(tc2);

        jogador.sPlayer = new Sprite(jogador.tPlayer);

        jogador.x = (1280 / 2);
        jogador.y = (720 / 2);
    }

    @Override
    public void render() {

 
//Movimento Player-----------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            jogador.x += (-1f * jogador.velo);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            jogador.x += (1f * jogador.velo);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            jogador.y += (1f * jogador.velo);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            jogador.y += (-1f * jogador.velo);


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        MapaCidade();


        batch.draw(jogador.sPlayer, jogador.x, jogador.y);
        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
        jogador.tPlayer.dispose();
        Q2.textura.dispose();
        Q3.textura.dispose();
        //ta2.dispose();
        ta3.dispose();
        tb1.dispose();
        tb2.dispose();
        tb3.dispose();
        tc2.dispose();
    }

    private void MapaCidade() {
        //Pontos de colisão fim da tela
        int ladoEsquerdo = 10;
        int ladoDireito = 1270 - jogador.larg;
        int ladoTopo = 720 - jogador.alt;
        int ladoBaixo = 10;

        //Colisões limite da tela
        if (fundoatual == 2 || fundoatual == 3 || fundoatual == 4 || fundoatual == 8) {
            if (jogador.x <= ladoEsquerdo) {
                jogador.x += (jogador.velo);
            }
        }
        if (fundoatual == 2 || fundoatual == 3 || fundoatual == 6 || fundoatual == 8) {
            if (jogador.x >= ladoDireito) {
                jogador.x += (-jogador.velo);
            }
        }
        if (fundoatual == 2 || fundoatual == 3 || fundoatual == 4) {
            if (jogador.y >= ladoTopo) {
                jogador.y += (-jogador.velo);
            }
        }

        if (fundoatual == 4 || fundoatual == 6 || fundoatual == 8) {
            if (jogador.y <= ladoBaixo) {
                jogador.y += (jogador.velo);
            }
        }

        //Pontos iniciais de transição de tela
        int xInicial = 40 - (jogador.larg / 2);
        int xFinal = 1240 - (jogador.larg / 2);
        int yInicial = 40 - (jogador.alt / 2);
        int yFinal = 680 - (jogador.alt / 2);

        //Desenhar imagem e transição de tela
        switch (fundoatual) {
            case 2:
                //batch.draw(sa2, sa2.getX(), sa2.getY());
                batch.draw(Q2.sprite, Q2.sprite.getX(), Q2.sprite.getY());
                if (jogador.y < yInicial) {
                    fundoatual = 5;
                    jogador.y = (yFinal);
                }
                break;
            case 3:
                batch.draw(Q3.sprite, Q3.sprite.getX(), Q3.sprite.getY());
                if (jogador.y < yInicial) {
                    fundoatual = 6;
                    jogador.y = (yFinal);
                }
                break;
            case 4:
                batch.draw(sb1, sb1.getX(), sb1.getY());

                if (jogador.x > xFinal) {
                    fundoatual = 5;
                    jogador.x = (xInicial);
                }
                break;
            case 5:
                batch.draw(sb2, sb2.getX(), sb2.getY());
                if (jogador.x < xInicial) {
                    fundoatual = 4;
                    jogador.x = (xFinal);
                }
                if (jogador.y > yFinal) {
                    fundoatual = 2;
                    jogador.y = (yInicial);
                }
                if (jogador.y < yInicial) {
                    fundoatual = 8;
                    jogador.y = yFinal;
                }
                if (jogador.x > xFinal) {
                    fundoatual = 6;
                    jogador.x = xInicial;
                }
                break;
            case 6:
                batch.draw(sb3, sb3.getX(), sb3.getY());
                if (fundoatual == 6) {
                    if (jogador.x < xInicial) {
                        fundoatual = 5;
                        jogador.x = xFinal;
                    }
                    if (jogador.y > yFinal) {
                        fundoatual = 3;
                        jogador.y = yInicial;
                    }
                }
                break;
            case 8:
                batch.draw(sc2, sc2.getX(), sc2.getY());
                if (fundoatual == 8) {
                    if (jogador.y > yFinal) {
                        fundoatual = 5;
                        jogador.y = yInicial;
                    }
                }
                break;


        }


    }
}

