package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.player.Player;
import com.mygdx.game.quadrante.*;

public class MyGdxGame2 extends Game {
    private
    int telaLarg = 1280, telaAlt = 720;
    //Criando objetos dos quadrantes
    Quadrante Q = new Quadrante();
    SpriteBatch batch;
    public int fundoatual = 4;
    Player jogador = new Player();
    Rectangle doorHitbox, playerHitbox;
    ShapeRenderer renderer;
    public OrthographicCamera camera;
    public Viewport viewport;

    int recX=Q.larg2-700;
    int recY=50;
    int res=0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        playerHitbox = new Rectangle(jogador.x, jogador.y, jogador.larg, jogador.alt);
        doorHitbox = new Rectangle(recX, recY, jogador.larg, jogador.alt);
        //metodo de criação das texturas e sprites
        Q.Criar();
        jogador.Criar();
        renderer = new ShapeRenderer();

        camera = new OrthographicCamera();
        viewport = new FitViewport(telaLarg,telaAlt,camera);
        camera.setToOrtho(false, 1280.0F, 4720.0F);
        camera.position.set(1280.0F, 720.0F, 0.0F);
        camera.update();
    }
    @Override
    public void resize(int width, int height) {
        //updated our game viewport
        viewport.update(width,height);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.setProjectionMatrix(camera.combined);
        Mover();



        playerHitbox.setPosition(jogador.x, jogador.y);


        if (fundoatual == 4 && playerHitbox.overlaps(doorHitbox)) {
            System.out.println("ajjj");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            System.out.println("JOGADOR X: "+jogador.x+"\nCAMERA X: "+camera.position.x+"\nMAPA X: "+res);
        }


        batch.begin();

        //Scroll();
        //MapaCidadeHitbox();
        MapaCidadeDesenhar();
        jogador.Desenharr(batch);
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(camera.position.x, recY, jogador.larg, jogador.alt);
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

        res=Q.Desenhar(fundoatual,batch);

    }

    private void Mover() {
        //Movimento Player-----------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){

            jogador.x += (-1f * jogador.velo);}

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){

            jogador.x += (1f * jogador.velo);}

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            jogador.y += (1f * jogador.velo);}


        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            jogador.y += (-1f * jogador.velo);}


        camera.position.x= jogador.x+ jogador.larg/ 2.0F;
        camera.position.y = jogador.y + jogador.alt / 2.0F;

        camera.update();
    }




}


