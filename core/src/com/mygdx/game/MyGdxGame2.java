package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.mapa.IniciarMapa;
import com.mygdx.game.mapa.Mapa;
import com.mygdx.game.mapa.Portas;
import com.mygdx.game.unidade.Jogador;
import com.mygdx.game.unidade.ObjetoCenario;
import com.mygdx.game.unidade.Unidade;
import com.mygdx.game.unidade.inimigo.Inimigo;
import com.mygdx.game.unidade.inimigo.Ladrao;
import com.mygdx.game.unidade.inimigo.Slime;

import java.awt.*;
import java.util.Iterator;

import static com.mygdx.game.CameraView.*;

public class MyGdxGame2 extends Game {
    public static Mapa[] mapas;
    public static Jogador jogador;
    public Mapa mapaB01;
    public Mapa mapaB02;
    public Mapa mapaEsg01;
    public Mapa mapaEsg02;
    public Mapa mapaEsg03;


    public static IniciarMapa iniciarMapa;
    public static int telaLarg = 1280, telaAlt = 720;

    public static int esquerdo = 0, direito = 0, cima = 0, baixo = 0;
    public static SpriteBatch batch;
    public static ShapeRenderer renderer;

    public static int tela = 0;
    public static int fundoatual = 0;
    public static OrthographicCamera camera;
    public Viewport viewport;

    @Override
    public void create() {
        //LISTA COM OS MAPAS
        iniciarMapa = new IniciarMapa();
        jogador = new Jogador(500, 500, 0, 56, 126, 56, 39, 1);

        //INICIANDO CADA MAPA
        mapaB01 = new Mapa();
        mapaB02 = new Mapa();
        mapaEsg01 = new Mapa();
        mapaEsg02 = new Mapa();
        mapaEsg03 = new Mapa();


        //ALOCANDO ARRAY
        mapas = new Mapa[5];

        //QUAL MAPA REPRESENTA CADA NO ARRAY
        mapas[0] = mapaB01;
        mapas[1] = mapaB02;
        mapas[2] = mapaEsg01;
        mapas[3] = mapaEsg02;
        mapas[4] = mapaEsg03;




        iniciarMapa.Cidade01(mapas[0]);
        iniciarMapa.Cidade02(mapas[1]);
        iniciarMapa.Esgoto01(mapas[2]);
        iniciarMapa.Esgoto02(mapas[3]);
        iniciarMapa.Esgoto03(mapas[4]);



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
        //Atualiza a janela do jogo
        viewport.update(width, height);

    }

    @Override
    public void render() {

        //Menu inicial
<<<<<<< HEAD
        if (tela == 0) {
=======
        if(tela ==0)
        {
>>>>>>> parent of c10878d... Menu principal e morte.
            tela = 3;
        }

        //Tela principal do jogo
<<<<<<< HEAD
        if (tela == 3) {
            Gdx.gl.glClearColor(0, 0, 0, 0);
=======
        if(tela == 3)
        {
            Gdx.gl.glClearColor(1, 0, 0, 1);
>>>>>>> parent of c10878d... Menu principal e morte.
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
                if (inimigo instanceof Ladrao) {
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

            //FOR QUE REMOVE O INIMIGO DOS ARRAYS SE ELE ESTIVER MORTO
            for (Iterator<Inimigo> iter = mapas[fundoatual].inimigoarray.iterator(); iter.hasNext(); ) {
                Inimigo enemy = iter.next();
                if (enemy.estado == -2)
                    iter.remove();
            }

            for (Iterator<Unidade> iter = mapas[fundoatual].desenhoArray.iterator(); iter.hasNext(); ) {
                Unidade enemy = iter.next();
                if (enemy.estado == -2)
                    iter.remove();
            }

            //Faz as portas conferirem a colisao com o jogador
            for (Portas porta : mapas[fundoatual].portaLocal) {
                porta.conferindoInteracao(jogador);
            }

            //Faz com que o renderer e o batch acopanhem a camera
            renderer.setProjectionMatrix(camera.combined);
            batch.setProjectionMatrix(camera.combined);

            mapas[fundoatual].desenhoArray.sort();

            batch.begin();

            MapaDesenhar(mapas[fundoatual]);

            for (Unidade unidade : mapas[fundoatual].desenhoArray) {
                if (unidade instanceof Slime) {
                    Slime inimigo = (Slime) unidade;
                    if (inimigo.visivel)
                        inimigo.Draw();
                }

                if (unidade instanceof Ladrao) {
                    Ladrao inimigo = (Ladrao) unidade;
                    if (inimigo.visivel)
                        inimigo.Draw();
                }

                if (unidade instanceof Jogador) {
                    Jogador jogador = (Jogador) unidade;
                    if (jogador.visivel)
                        jogador.Draw();
                }

                if (unidade instanceof ObjetoCenario) {
                    ObjetoCenario objeto = (ObjetoCenario) unidade;
                    Desenhar((int) objeto.hitboxDano.x, (int) objeto.hitboxDano.y, objeto.sprite, batch, camera);
                }
            }

            batch.end();

            //RENDER HITBOX BEGIN
<<<<<<< HEAD


            renderer.begin(ShapeRenderer.ShapeType.Filled);

            for (Rectangle retangulo : mapas[fundoatual].colisoes)
               // renderer.rect(retangulo.x, retangulo.y, retangulo.getWidth(), retangulo.getHeight());
            renderer.end();
/*
        for (Inimigo inimigo : mapas[fundoatual].inimigoarray) {
            renderer.rect(inimigo.hitboxMapa.x, inimigo.hitboxMapa.y, inimigo.hitboxMapa.getWidth(), inimigo.hitboxMapa.getHeight());

        }

        for (Portas portas : mapas[fundoatual].portaLocal) {
            renderer.rect(portas.colisao.x, portas.colisao.y, portas.colisao.getWidth(), portas.colisao.getHeight());

        }
        renderer.rect(ladrao.espada.hitbox.x, ladrao.espada.hitbox.y, ladrao.espada.hitbox.getWidth(), ladrao.espada.hitbox.getHeight());
        renderer.rect(jogador.espada.hitbox.x, jogador.espada.hitbox.y, jogador.espada.hitbox.getWidth(), jogador.espada.hitbox.getHeight());
        renderer.rect(jogador.hitboxMapa.x, jogador.hitboxMapa.y, jogador.hitboxMapa.getWidth(), jogador.hitboxMapa.getHeight());
        renderer.rect(jogador.hitboxDano.x, jogador.hitboxDano.y, jogador.hitboxDano.getWidth(), jogador.hitboxDano.getHeight());

=======
        /*
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Inimigo inimigo : mapas[fundoatual].inimigoarray) {
            renderer.rect(inimigo.hitboxMapa.x, inimigo.hitboxMapa.y, inimigo.hitboxMapa.getWidth(), inimigo.hitboxMapa.getHeight());

        }

        for (Portas portas : mapas[fundoatual].portaLocal) {
            renderer.rect(portas.colisao.x, portas.colisao.y, portas.colisao.getWidth(), portas.colisao.getHeight());

        }
        renderer.rect(ladrao.espada.hitbox.x, ladrao.espada.hitbox.y, ladrao.espada.hitbox.getWidth(), ladrao.espada.hitbox.getHeight());
        renderer.rect(jogador.espada.hitbox.x, jogador.espada.hitbox.y, jogador.espada.hitbox.getWidth(), jogador.espada.hitbox.getHeight());
        renderer.rect(jogador.hitboxMapa.x, jogador.hitboxMapa.y, jogador.hitboxMapa.getWidth(), jogador.hitboxMapa.getHeight());
        renderer.rect(jogador.hitboxDano.x, jogador.hitboxDano.y, jogador.hitboxDano.getWidth(), jogador.hitboxDano.getHeight());

>>>>>>> parent of c10878d... Menu principal e morte.
        renderer.end();
        */
            //RENDER HITBOX END
        }
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


