package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class Camera implements ApplicationListener {
    private OrthographicCamera camera;

    private SpriteBatch batch;

    private Texture texture;

    private Sprite sprite;

    @Override

    public void create() {

        camera = new OrthographicCamera(1280, 720);


        batch = new SpriteBatch();


        texture = new Texture("A2.jpg");



        sprite = new Sprite(texture);

        sprite.setOrigin(0, 0);

        sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);



    }
        public void dispose(){

            batch.dispose();

            texture.dispose();

        }



        @Override

        public void render() {

            Gdx.gl.glClearColor(1, 1, 1, 1);

            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



            batch.setProjectionMatrix(camera.combined);

            batch.begin();

            sprite.draw(batch);

            batch.end();

        }



        @Override

        public void resize(int width, int height) {

        }



        @Override

        public void pause() {

        }



        @Override

        public void resume() {

        }
public boolean pan(float x, float y, float deltaX, float deltaY) {



            camera.translate(deltaX,0);

            camera.update();

            return false;

        }



        }





