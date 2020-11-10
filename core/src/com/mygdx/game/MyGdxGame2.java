package com.mygdx.game;

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
import com.mygdx.game.unidade.Jogador;
import com.mygdx.game.unidade.Player;


import static com.mygdx.game.CameraView.*;

public class MyGdxGame2 extends Game {
    public int largHitbox = 56, altHitbox = 122 - 9;
    public int colHitboxLarg = 56, colHitboxAlt = 39;

    public Jogador jogador = new Jogador(10, 10, 0, largHitbox, altHitbox, colHitboxLarg, colHitboxAlt);

    public static int telaLarg = 1280, telaAlt = 720;
    private float timeSeconds = 0f;
    private float period = 1f;

    Arco flecha = new Arco();
    public static int esquerdo = 0, direito = 0, cima = 0, baixo = 0;
    public static SpriteBatch batch;
    public static ShapeRenderer renderer;

    public static int fundoatual = 1;
    public static OrthographicCamera camera;
    public Viewport viewport;
    int VRX = 0;
    int VRY = 0;

    @Override
    public void create() {

        //INICIANDO OS MAPAS
        Q1.Criar();
        Q2.Criar();
        Q3.Criar();
        Q4.Criar();
        jogador.iniciar();


        //BATCH OBJETO QUE DESENHA precisa de um tipo Sprite
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();

        //CRIACAO DE CAMERA
        camera = new OrthographicCamera();
        viewport = new FitViewport(telaLarg, telaAlt, camera);
        camera.setToOrtho(false, 1280.0F, 4720.0F);
        camera.position.set(1280.0F, 720.0F, 0.0F);
        camera.position.x = jogador.x + jogador.hitboxDano.getHeight() / 2.0F;
        camera.position.y = jogador.y + jogador.hitboxDano.getWidth() / 2.0F;
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
        Mover();
        //METODO DE MOVIMENTO
        jogador.Movimento();
        //ACOMPANHA A CAMERA
        renderer.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        MapaCidadeDesenhar();
        batch.end();


        //CONFERINDO HITBOX DE TROCA DE MAPA PASSANDO O RETANGULO DO PLAYER
        Q4.porta1.conferindoInteracao(jogador.hitboxMapa, jogador);

//        renderer.end();
//        renderer.begin(ShapeRenderer.ShapeType.Filled);


        //desenha o jogador passando o batch
        batch.begin();
        jogador.Draw();
        batch.end();


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
        flecha.Deletar();
    }

    //METODO DE DESNHAR O MAPA (ELE ESTA DESATUALIZADO)
    public void MapaCidadeDesenhar() {
        Mapa(VRX, VRY, camera, batch, fundoatual);
        //DESENHA O MACA PASSANDO O FUNDOATUAL
    }

    private void Mover() {

        //ATUALIZA OS LIMITES DA CAMERA
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            DefinirLimites(Q1.sprite, Q1.xy);
        }

        //Movimento Player-----------------------------------
        jogador.input();


        //TRAVA DE CAMERA CONFORME CAMERAVIEWLIMITES

        camera.position.x = jogador.x;
        camera.position.y = jogador.y;

        if (camera.position.x < esquerdo + telaLarg / 2) {
            camera.position.x = esquerdo + telaLarg / 2;
        }

        if (camera.position.x > direito - telaLarg / 2)
            camera.position.x = direito - telaLarg / 2;

        if (camera.position.y > cima - telaAlt / 2) {
            camera.position.y = cima - telaAlt / 2;
        }

        if (camera.position.y < baixo + telaAlt / 2)
            camera.position.y = baixo + telaAlt / 2;


        camera.update();
    }


}


