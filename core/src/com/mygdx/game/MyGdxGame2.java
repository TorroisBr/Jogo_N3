package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.cidade.*;
import com.mygdx.game.player.Player;
import com.mygdx.game.quadrante.*;

public class MyGdxGame2 extends ApplicationAdapter {
    int telaLarg = 1280, telaAlt = 720;
    //Criando objetos dos quadrantes
    Quadrante Q = new Quadrante();
    SpriteBatch batch;
    public int fundoatual = 4;
    Player jogador = new Player();
    Rectangle doorHitbox,playerHitbox;
    ShapeRenderer renderer;
    int recX= Q.larg2-500;
    int recY;
    @Override
    public void create() {
        batch = new SpriteBatch();
        playerHitbox=new Rectangle(jogador.x, jogador.y, jogador.larg, jogador.alt);
        doorHitbox=new Rectangle(recX,recY, jogador.larg, jogador.alt );
        //metodo de criação das texturas e sprites
        Q.Criar();
        jogador.Criar();
        renderer=new ShapeRenderer();
    }

    @Override
    public void render() {

        Mover();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        playerHitbox.setPosition(jogador.x, jogador.y);
        if(fundoatual==4 && playerHitbox.overlaps(doorHitbox)){
            System.out.println("ajjj");
        }
        batch.begin();

        System.out.println();
        Scroll();
        //batch.draw(jogador.sPlayer, jogador.x, jogador.y);
        MapaCidadeHitbox();
        MapaCidadeDesenhar();
        jogador.Desenharr();
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(recX,recY, jogador.larg, jogador.alt);
        renderer.end();
    }


    @Override
    public void dispose() {
        renderer.dispose();
        //Deletando as texturas
        batch.dispose();
        jogador.tPlayer.dispose();
        Q.Deletar();
        jogador.Deletar();
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

    public void MapaCidadeDesenhar() {
        //Pontos iniciais de transição de tela
        int xInicial = 40 - (jogador.larg / 2);
        int xFinal = 1240 - (jogador.larg / 2);
        int yInicial = 40 - (jogador.alt / 2);
        int yFinal = 680 - (jogador.alt / 2);

        //Desenhar imagem e transição de tela
        switch (fundoatual) {
            case 2:

                if (jogador.y < yInicial) {
                    fundoatual = 5;
                    jogador.y = (yFinal);
                }
                break;
            case 3:

                if (jogador.y < yInicial) {
                    fundoatual = 6;
                    jogador.y = (yFinal);
                }
                break;
            case 4:


                if (jogador.x > xFinal) {
                    fundoatual = 5;
                    jogador.x = (xInicial);

                }
                break;
            case 5:

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

                if (fundoatual == 8) {
                    if (jogador.y > yFinal) {
                        fundoatual = 5;
                        jogador.y = yInicial;
                    }
                }
                break;

        }
        Q.Desenhar(fundoatual);

    }

    private void Mover() {
        //Movimento Player-----------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            jogador.x += (-1f * jogador.velo);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            jogador.x += (1f * jogador.velo);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            jogador.y += (1f * jogador.velo);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            jogador.y += (-1f * jogador.velo);
    }
    public void Scroll(){
        if (fundoatual == 2) {
            Q.x2 = ScrollH(Q.x2, Q.larg2);
            Q.y2 = ScrollV(Q.y2, Q.tam2);
        }
        if (fundoatual == 3) {
            Q.x3 = ScrollH(Q.x3, Q.larg3);
            Q.y3 = ScrollV(Q.y3, Q.tam3);
        }
        if (fundoatual == 4) {
            Q.x4 = ScrollH(Q.x4, Q.larg4);
            Q.y4 = ScrollV(Q.y4, Q.tam4);
        }
        if (fundoatual == 5) {
            Q.x5 = ScrollH(Q.x5, Q.larg5);
            Q.y5 = ScrollV(Q.y5, Q.tam5);
        }
        if (fundoatual == 6) {
            Q.x6 = ScrollH(Q.x6, Q.larg6);
            Q.y6 = ScrollV(Q.y6, Q.tam6);
        }
        if (fundoatual == 8) {
            Q.x8 = ScrollH(Q.x8, Q.larg8);
            Q.y8 = ScrollV(Q.y8, Q.tam8);
        }
    }
    public int ScrollH(int x, int lar) {

        int a;
        a = telaLarg - lar;
        if (x >= a) {
            if (jogador.x >= (telaLarg / 3) * 2) {
                x += -16;
                recX+=-16;
                jogador.x -= jogador.velo;
                return x;
            }
        }

        int b;
        b = 0;
        if (x <= b) {
            if (jogador.x <= (telaLarg / 3)) {
                x += +16;
                recX+=+16;
                jogador.x += jogador.velo;
                return x;
            }

        }
        return x;
    }
    public int ScrollV(int y, int alt) {
        int c;
        c = telaAlt - alt;
        if (y >= c) {
            if (jogador.y >= (telaAlt / 3) * 2) {
                y += -16;
                recY+=-16;
                jogador.y -= jogador.velo;
                return y;
            }
        }
        int d;
        d = 0;
        if (y <= d) {
            if (jogador.y <= (telaAlt / 3)) {
                y += +16;
                recY+=+16;
                jogador.y += jogador.velo;
                return y;
            }
        }
        return y;
    }

}


