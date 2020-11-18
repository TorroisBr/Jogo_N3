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
import com.mygdx.game.unidade.inimigo.Slime;


import static com.mygdx.game.CameraView.*;

public class MyGdxGame2 extends Game {
    Rectangle rec1, rec2, rec3;
    Rectangle rec[];
    public static Jogador jogador = new Jogador(500, 500, 0, 56, 126,56, 39, 1);
    public Slime slime = new Slime(600, 600, 3, 56, 122, 56, 39);


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
        slime.iniciar();


        //BATCH OBJETO QUE DESENHA precisa de um tipo Sprite
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
        rec1 = new Rectangle(900, 900, 30, 30);
        rec2 = new Rectangle(200, 200, 500, 80);
        rec3 = new Rectangle(700, 700, 300, 300);
        rec = new Rectangle[3];
        rec[0] = rec1;
        rec[1] = rec2;
        rec[2] = rec3;

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
        jogador.cdr();
        //METODO DE MOVIMENTO
        jogador.Movimento(rec);
        //slime.Andar();
        slime.Atacar();
        //slime.ColisaoPlayer();
        //ACOMPANHA A CAMERA
        renderer.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        MapaCidadeDesenhar();
        batch.end();


        //CONFERINDO HITBOX DE TROCA DE MAPA PASSANDO O RETANGULO DO PLAYER
//        Q4.porta1.conferindoInteracao(jogador.hitboxMapa, jogador);

//        renderer.end();
//        renderer.begin(ShapeRenderer.ShapeType.Filled);


        //desenha o jogador passando o batch
        batch.begin();
        slime.Draw();
        jogador.Draw();

        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Rectangle retangulo : rec) {
//            renderer.rect(retangulo.x, retangulo.y, retangulo.width, retangulo.height);
        }

//        renderer.rect(jogador.hitboxMapa.x, jogador.hitboxMapa.y, jogador.hitboxMapa.getWidth(), jogador.hitboxMapa.getHeight());
//        renderer.rect(jogador.hitboxDano.x, jogador.hitboxDano.y, jogador.hitboxDano.getWidth(), jogador.hitboxDano.getHeight());
        renderer.end();

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


