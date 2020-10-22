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

import static com.mygdx.game.MyGdxGame2.telaAlt;
import static com.mygdx.game.MyGdxGame2.telaLarg;

public class CameraView {

//FUNÇÂO QUE VERIFICA SE A IMAGEM ESTA NA AREA DA CAMERA
    public static boolean naAreaDaCamera(int x, int y, Texture imagem,OrthographicCamera camera) {

        int larg = imagem.getWidth();
        int alt = imagem.getHeight();
        boolean resposta;

        if ((x < camera.position.x + telaLarg / 2 && x + larg > camera.position.x - telaLarg / 2) && (y < camera.position.y + telaAlt / 2 && y + alt > camera.position.y - telaAlt / 2)) {
            resposta = true;
        } else
            resposta = false;
        return resposta;


    }
}





