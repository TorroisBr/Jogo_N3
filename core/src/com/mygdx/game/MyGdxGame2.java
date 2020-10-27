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
import com.mygdx.game.player.*;
import com.mygdx.game.quadrante.*;

import static com.mygdx.game.CameraView.naAreaDaCamera;
import static com.mygdx.game.colisão.Hitbox.*;

public class MyGdxGame2 extends Game {


    public static int telaLarg = 1280, telaAlt = 720;
    private float timeSeconds = 0f;
    private float period = 1f;
    //Criando objetos
    Player jogador = new Player();
    Arco flecha = new Arco();
    Quadrante Q = new Quadrante();

    SpriteBatch batch;
    Rectangle doorHitbox, playerHitbox;
    ShapeRenderer renderer;
    Rectangle recCasa;
    public int fundoatual = 4;
    public static OrthographicCamera camera;
    public Viewport viewport;

    int recX = 50;
    int recY = 50;


    @Override
    public void create() {
        //RETANGULO DE COLISÂO DA CASA
        recCasa = new Rectangle(110, 3043, 330 - 110, 3201 - 3043);
        //BATCH OBJETO QUE DESENHA precisa de um tipo Sprite
        batch = new SpriteBatch();
        //HITOBX do retangulo
        playerHitbox = new Rectangle(jogador.x, jogador.y, jogador.largHitbox, jogador.altHitbox);
        //metodo de criação das texturas e sprites mapas e jogador
        Q.Criar();
        jogador.Criar();
        renderer = new ShapeRenderer();

        //CRIACAO DE CAMERA
        camera = new OrthographicCamera();
        viewport = new FitViewport(telaLarg, telaAlt, camera);
        camera.setToOrtho(false, 1280.0F, 4720.0F);
        camera.position.set(1280.0F, 720.0F, 0.0F);
        camera.position.x = jogador.x + jogador.largHitbox / 2.0F;
        camera.position.y = jogador.y + jogador.altHitbox / 2.0F;
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

        //ACOMPANHA A CAMERA
        renderer.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);
        //METODO DE MOVIMENTO
        Mover();

        //Hitbox acompanha o xy do player
        playerHitbox.setPosition(jogador.x, jogador.y);

        //batch é o que desenha sempre tem que ter begin e end
        batch.begin();
        //Onde desenha a cidade (mas tem que arruma)
        MapaCidadeDesenhar();
        batch.end();
        //render utiliza para fazer formas geometricas
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        //HITBOX DE HIT INIMIGO
        renderer.rect(jogador.x, jogador.y, jogador.largHitbox, jogador.altHitbox - 9);
        renderer.end();
        batch.begin();
        //desenha o jogador passando o batch
        jogador.Desenharr(batch);
        batch.end();

        //Teste de overlaps se o player estiver encima da casa da esquerda superior e apertar o espaço toma tp
        if (Hitbox(playerHitbox, recCasa)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                jogador.x = 800;
                jogador.y = 4265;
            }
        }


        //Compara o tempo e
        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
        }

//        flecha.criar();
//        if (Gdx.input.isKeyPressed(Input.Keys.S)){
//        batch.begin();
//        flecha.Desenhar(batch, jogador.x, jogador.y);
//        batch.end();}

    }

    @Override   //metodo dispose deleta as texturas e exclui os objetos
    public void dispose() {
        renderer.dispose();
        batch.dispose();
        jogador.tPlayer.dispose();
        Q.Deletar();
        jogador.Deletar();
        flecha.Deletar();
    }

        //METODO DE DESNHAR O MAPA (ELE ESTA DESATUALIZADO)
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
            //QUANDO O PLAYER ANDA PRA UM LADO OS OUTROS FICAM FALSO
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

        //ATUALIZA A CAMERA PRA POSIÇÂO DO JOGADOR
        camera.position.x = jogador.x;
        //if (jogador.y >= telaAlt / 2 && jogador.y <= telaAlt)
        camera.position.y = jogador.y;


        camera.update();
    }


}


