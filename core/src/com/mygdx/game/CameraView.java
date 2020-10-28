package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.MyGdxGame2.telaAlt;
import static com.mygdx.game.MyGdxGame2.telaLarg;

public class CameraView {

    //FUNÇÂO QUE VERIFICA SE A IMAGEM ESTA NA AREA DA CAMERA
    public static void naAreaDaCamera(int x, int y, OrthographicCamera camera, SpriteBatch batch, Sprite sprite) {

        float larg = sprite.getWidth();
        float alt = sprite.getHeight();
        boolean resposta;

        //Calculo para ver se o objeto esta dentro da  area da camera
        if ((x < camera.position.x + telaLarg / 2 && x + larg > camera.position.x - telaLarg / 2) && (y < camera.position.y + telaAlt / 2 && y + alt > camera.position.y - telaAlt / 2)) {
            resposta = true;

        } else
            resposta = false;

        if (resposta) {
            batch.draw(sprite, x, y);
        }

    }

}





