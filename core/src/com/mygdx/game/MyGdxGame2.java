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

import static com.mygdx.game.CameraView.*;
import static com.mygdx.game.colisão.Hitbox.*;

public class MyGdxGame2 extends Game {


    public static int telaLarg = 1280, telaAlt = 720;
    private float timeSeconds = 0f;
    private float period = 1f;
    //Criando objetos
    Player jogador = new Player();
    Arco flecha = new Arco();


    public static SpriteBatch batch;
    Rectangle doorHitbox, playerHitbox;
    ShapeRenderer renderer;
    Rectangle recCasa;
    public int fundoatual = 1;
    public static OrthographicCamera camera;
    public Viewport viewport;
    int recX = 50;
    int recY = 50;
    int VRX = 0;
    int VRY = 0;

    @Override
    public void create() {
        Q1.Criar();
        Q2.Criar();

        //RETANGULO DE COLISÂO DA CASA
        recCasa = new Rectangle(110, 3043, 330 - 110, 3201 - 3043);
        //BATCH OBJETO QUE DESENHA precisa de um tipo Sprite
        batch = new SpriteBatch();
        //HITOBX do retangulo
        playerHitbox = new Rectangle(jogador.x, jogador.y, jogador.largHitbox, jogador.altHitbox);
        //metodo de criação das texturas e sprites mapas e jogador

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

        batch.begin();
        MapaCidadeDesenhar();
        batch.end();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(jogador.x, jogador.y, jogador.largHitbox, jogador.altHitbox - 9);
        renderer.end();
        //desenha o jogador passando o batch
        batch.begin();
        jogador.Desenharr();
        batch.end();

        //Teste de overlaps se o player estiver encima da casa da esquerda superior e apertar o espaço toma tp
        if (Hitbox(playerHitbox, recCasa)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                jogador.x = 800;
                jogador.y = 4265;
            }
        }


        //Compara o tempo e


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

        jogador.Deletar();
        flecha.Deletar();
    }

    //METODO DE DESNHAR O MAPA (ELE ESTA DESATUALIZADO)
    public void MapaCidadeDesenhar() {
        Mapa(VRX, VRY, camera, batch, fundoatual);

//        if (jogador.x > MapaNum(fundoatual).getWidth()) {
//            fundoatual++;
//            VRX = (int) MapaNum(fundoatual).getWidth()-telaLarg/2;
//            jogador.x=VRX+50;
//            camera.position.x= jogador.x;
//
//        }

//        else if (jogador.x < VRX) {
//            fundoatual = 1;
//            VRX = 0;
//        }

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
        if (jogador.x + telaLarg / 2 <= MapaNum(fundoatual).getWidth())
            camera.position.x = jogador.x;

        //if (jogador.y >= telaAlt / 2 && jogador.y <= telaAlt)
        camera.position.y = jogador.y;


        camera.update();
    }


}


