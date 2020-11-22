package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.mapa.IniciarMapa;
import com.mygdx.game.mapa.Mapa;
import com.mygdx.game.mapa.Portas;
import com.mygdx.game.player.*;
import com.mygdx.game.unidade.Jogador;
import com.mygdx.game.unidade.Player;
import com.mygdx.game.unidade.inimigo.Inimigo;
import com.mygdx.game.unidade.inimigo.Slime;
import com.mygdx.game.unidade.Jogador.*;

import java.util.Iterator;

import static com.mygdx.game.CameraView.*;

public class MyGdxGame2 extends Game {
    public static Mapa mapas[];
    public static Jogador jogador;
    public Mapa mapaB01;
    public Mapa mapaB02;

    public static IniciarMapa iniciarMapa;
    public static int telaLarg = 1280, telaAlt = 720;

    public static int esquerdo = 0, direito = 0, cima = 0, baixo = 0;
    public static SpriteBatch batch;
    public static ShapeRenderer renderer;

    public static int fundoatual = 0;
    public static OrthographicCamera camera;
    public Viewport viewport;
    int VRX = 0;
    int VRY = 0;

    @Override
    public void create() {
        //LISTA COM OS MAPAS
        iniciarMapa = new IniciarMapa();
        jogador = new Jogador(500, 500, 0, 56, 126, 56, 39, 1);

        //INICIANDO CADA MAPA
        mapaB01 = new Mapa();
        mapaB02 = new Mapa();

        //ALOCANDO ARRAY
        mapas = new Mapa[2];
        //QUAL MAPA REPRESENTA CADA NO ARRAY
        mapas[0] = mapaB01;
        mapas[1] = mapaB02;

        iniciarMapa.Cidade01(mapas[0]);
        iniciarMapa.Cidade02(mapas[1]);


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


        jogador.iniciar();

        DefinirLimites(mapas[fundoatual].spriteLocal, mapas[fundoatual].posicaoSprite);

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
        jogador.Movimento(mapas[fundoatual].colisoes);

        //VERIFICA QUAL O TIPO DE INIMIGO E O MOVIMENTA
        for (Inimigo inimigo : mapas[fundoatual].inimigoarray) {
            if (inimigo instanceof Slime) {
                switch (inimigo.estado) {
                    case -1:
                        inimigo.morrendo();
                        break;
                    case 0:
                        inimigo.Andar();
                        break;
                    case 1:
                        inimigo.Atacar();
                        break;
                    case 2:
                        inimigo.LevandoDano();
                        break;
                }

            }
        }
        //FOR QUE REMOVE O INIMIGO DO ARRAY SE ELE ESTIVER MORTO
        for (Iterator<Inimigo> iter = mapas[fundoatual].inimigoarray.iterator(); iter.hasNext(); ) {
            Inimigo enemy = iter.next();
            if (enemy.estado == -2)
                iter.remove();
        }
        for (Portas porta : mapas[fundoatual].portaLocal) {
            porta.conferindoInteracao(jogador);
        }


        //ACOMPANHA A CAMERA
        renderer.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);


        //Desenha
        batch.begin();
        MapaDesenhar(mapas[fundoatual]);

        //DESENHA OS INIMIGOS DO ARRAY
        for (Inimigo inimigo : mapas[fundoatual].inimigoarray) {
            if (inimigo instanceof Slime)
                if (inimigo.visivel)
                    inimigo.Draw();
        }

        if (jogador.visivel)
            jogador.Draw();
        batch.end();
        //FINAL DO DESENHO

        //RENDER HITBOX BEGIN

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Rectangle retangulo : mapas[fundoatual].colisoes) {
//            renderer.rect(retangulo.x, retangulo.y, retangulo.width, retangulo.height);
        }
        for (Inimigo inimigo : mapas[fundoatual].inimigoarray) {
            renderer.rect(inimigo.hitboxMapa.x, inimigo.hitboxMapa.y, inimigo.hitboxMapa.getWidth(), inimigo.hitboxMapa.getHeight());

        }
        for (Portas portas : mapas[fundoatual].portaLocal) {
            renderer.rect(portas.colisao.x, portas.colisao.y, portas.colisao.getWidth(), portas.colisao.getHeight());

        }
//        renderer.rect(jogador.espada.hitbox.x, jogador.espada.hitbox.y, jogador.espada.hitbox.getWidth(), jogador.espada.hitbox.getHeight());
        renderer.rect(jogador.hitboxMapa.x, jogador.hitboxMapa.y, jogador.hitboxMapa.getWidth(), jogador.hitboxMapa.getHeight());
//        renderer.rect(jogador.hitboxDano.x, jogador.hitboxDano.y, jogador.hitboxDano.getWidth(), jogador.hitboxDano.getHeight());
        renderer.end();

        //RENDER HITBOX END

    }

    @Override   //metodo dispose deleta as texturas e exclui os objetos
    public void dispose() {
        renderer.dispose();
        batch.dispose();
    }

    //METODO DE DESNHAR O MAPA (passa o proprio mapa)
    public void MapaDesenhar(Mapa mapa) {
        for (int i = 0; i < mapa.spriteLocal.length; i++) {
            Desenhar(mapa.posicaoSprite[i][0], mapa.posicaoSprite[i][1], mapa.spriteLocal[i], batch, camera);

        }
    }

    private void Mover() {

        //Movimento Player-----------------------------------
        switch (jogador.estado) {
            case 0:
                jogador.animar(true, 0.09F);
                break;
            case 1:
                jogador.Atacando();
                break;
            case 2:
                jogador.Arcada();
                break;
            case 3:
                jogador.levandoDano();
        }
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


