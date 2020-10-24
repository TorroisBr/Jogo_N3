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

import static com.mygdx.game.CameraView.naAreaDaCamera;
import static com.mygdx.game.colisão.Hitbox.*;

public class MyGdxGame2 extends Game {


    public static int telaLarg = 1280, telaAlt = 720;
    private float timeSeconds = 0f;
    private float period = 1f;
    //Criando objetos dos quadrantes
    Quadrante Q = new Quadrante();
    SpriteBatch batch;
    public int fundoatual = 4;
    Player jogador = new Player();
    Rectangle doorHitbox, playerHitbox;
    ShapeRenderer renderer;
    Rectangle recCasa;
    public static OrthographicCamera camera;
    public Viewport viewport;

    int recX = 50;
    int recY = 50;


    @Override
    public void create() {
        recCasa = new Rectangle(110, 3043, 330 - 110, 3201 - 3043);
        batch = new SpriteBatch();
        playerHitbox = new Rectangle(jogador.x, jogador.y, jogador.larg, jogador.alt);
        doorHitbox = new Rectangle(recX, recY, jogador.larg, jogador.alt);
        //metodo de criação das texturas e sprites
        Q.Criar();
        jogador.Criar();
        renderer = new ShapeRenderer();

        camera = new OrthographicCamera();
        viewport = new FitViewport(telaLarg, telaAlt, camera);
        camera.setToOrtho(false, 1280.0F, 4720.0F);
        camera.position.set(1280.0F, 720.0F, 0.0F);
        camera.position.x = jogador.x + jogador.larg / 2.0F;
        camera.position.y = jogador.y + jogador.alt / 2.0F;
        camera.update();

    }

    @Override
    public void resize(int width, int height) {
        //updated our game viewport
        viewport.update(width, height);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        renderer.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);
        Mover();

        playerHitbox.setPosition(jogador.x, jogador.y);


        batch.begin();
        //MapaCidadeHitbox();
        MapaCidadeDesenhar();
        jogador.Desenharr(batch);
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(jogador.x, jogador.y, jogador.larg, jogador.alt);
        renderer.end();
        if (Hitbox(playerHitbox, recCasa)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                jogador.x = 800;
                jogador.y = 4265;
            }
        }

//        for (int i = 0; i < 50000; i++) {
//            if (naAreaDaCamera(recX + i * 10, recY, jogador.tPlayer, camera)) {
//
//
//            }
//        }

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            System.out.println(jogador.currentFrame);
        }


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


    public void MapaCidadeDesenhar() {
        if (naAreaDaCamera(Q.x4, Q.y4, Q.t4, camera))
            Q.Desenhar(fundoatual, batch);

    }

    private void Mover() {
        //Movimento Player-----------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            jogador.direita = false;
            jogador.cima = false;
            jogador.baixo = false;

            jogador.esquerda = true;
            jogador.x += (-1f * jogador.velo);

            jogador.animar(jogador, jogador.animEsquerdaSprite);

        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            jogador.cima = false;
            jogador.baixo = false;
            jogador.esquerda = false;

            jogador.direita = true;
            jogador.x += (1f * jogador.velo);

            jogador.animar(jogador, jogador.animDireitaSprite);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            jogador.baixo = false;
            jogador.esquerda = false;
            jogador.direita = false;

            jogador.cima = true;
            jogador.y += (1f * jogador.velo);

            jogador.animar(jogador, jogador.animCimaSprite);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            jogador.esquerda = false;
            jogador.direita = false;
            jogador.cima = false;

            jogador.baixo = true;
            jogador.y += (-1f * jogador.velo);

            jogador.animar(jogador, jogador.animBaixoSprite);
        }


        //if (jogador.x >= telaLarg / 2 && jogador.x <= telaLarg)
        camera.position.x = jogador.x;


        //if (jogador.y >= telaAlt / 2 && jogador.y <= telaAlt)
        camera.position.y = jogador.y;


        camera.update();
    }


}


