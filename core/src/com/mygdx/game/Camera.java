package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Camera extends MyGdxGame2 {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    public Viewport viewport;


    @Override

    public void create() {

        camera = new OrthographicCamera();
        viewport = new FitViewport(1280,720,camera);
        camera.setToOrtho(false, 1280.0F, 4720.0F);
        camera.position.set(1280.0F, 720.0F, 0.0F);
        camera.update();
        batch = new SpriteBatch();



    }
        public void dispose(){

            batch.dispose();


        }



        @Override

        public void render() {

            Gdx.gl.glClearColor(1, 1, 1, 1);

            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            camera.position.x= jogador.x+ jogador.larg/ 2.0F;
            camera.position.y = jogador.y + jogador.alt / 2.0F;
            camera.update();

            batch.setProjectionMatrix(camera.combined);

            batch.begin();

            //sprite.draw(batch);

            batch.end();

        }




        }





