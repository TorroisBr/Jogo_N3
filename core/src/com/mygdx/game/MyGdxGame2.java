package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.cidade.*;
import com.mygdx.game.player.Player;
import com.mygdx.game.quadrante.*;

public class MyGdxGame2 extends ApplicationAdapter {
    int telaLarg=1280,telaAlt=720;
    //Criando objetos dos quadrantes
    Quadrante2 Q2 = new Quadrante2();
    Quadrante3 Q3 = new Quadrante3();
    Quadrante4 Q4 = new Quadrante4();
    Quadrante5 Q5 = new Quadrante5();
    Quadrante6 Q6 = new Quadrante6();
    Quadrante8 Q8 = new Quadrante8();
    SpriteBatch batch;
    int fundoatual = 4;
    Casa npcCasa = new Casa();
    Player jogador = new Player();


    @Override
    public void create() {
        batch = new SpriteBatch();
        jogador.tPlayer = new Texture("player.png");
        //metodo de criação das texturas e sprites
        Q2.Criar();
        Q3.Criar();
        Q4.Criar();
        Q5.Criar();
        Q6.Criar();
        Q8.Criar();
        jogador.sPlayer = new Sprite(jogador.tPlayer);
        jogador.x = (telaLarg / 2);
        jogador.y = (telaAlt / 2);
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
        Scroll(Q4.x, Q4.y, Q4.larg,Q4.alt);
        MapaCidadeHitbox();
        MapaCidadeDesenhar();
        batch.draw(jogador.sPlayer, jogador.x, jogador.y);
        batch.end();
        //Scroll();
    }


    @Override
    public void dispose() {
        batch.dispose();
        jogador.tPlayer.dispose();
        //Deletando as texturas
        Q2.Deletar();
        Q3.Deletar();
        Q4.Deletar();
        Q5.Deletar();
        Q6.Deletar();
        Q8.Deletar();
    }

    public void Scroll(int x,int y,int lar,int alt) {
        int a;
        a = telaLarg - lar;
        if (x >= a) {
            if (jogador.x >= (telaLarg / 3) * 2) {
                Q4.x += -16;
                jogador.x -= jogador.velo;
            }
        }
        int b;
        b=0;
        if (x <= b) {
            if (jogador.x <= (telaLarg / 3)) {
                Q4.x += +16;
                jogador.x += jogador.velo;
            }


            System.out.println(Q4.x);
        }
    }

    private void MapaCidadeHitbox() {
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
    }
    public void MapaCidadeDesenhar(){
        //Pontos iniciais de transição de tela
        int xInicial = 40 - (jogador.larg / 2);
        int xFinal = 1240 - (jogador.larg / 2);
        int yInicial = 40 - (jogador.alt / 2);
        int yFinal = 680 - (jogador.alt / 2);

        //Desenhar imagem e transição de tela
        switch (fundoatual) {
            case 2:
                Q2.Desenhar();
                if (jogador.y < yInicial) {
                    fundoatual = 5;
                    jogador.y = (yFinal);
                }
                break;
            case 3:
                Q3.Desenhar();
                if (jogador.y < yInicial) {
                    fundoatual = 6;
                    jogador.y = (yFinal);
                }
                break;
            case 4:
                Q4.Desenhar();

                if (jogador.x > xFinal) {
                    fundoatual = 5;
                    jogador.x = (xInicial);
                }
                break;
            case 5:
                Q5.Desenhar();
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
                Q6.Desenhar();
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
                Q8.Desenhar();
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


