package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.quadrante.Mapa1;
import com.mygdx.game.quadrante.Mapa2;

import static com.mygdx.game.MyGdxGame2.telaAlt;
import static com.mygdx.game.MyGdxGame2.telaLarg;

public class CameraView {
    static Mapa1 Q1 = new Mapa1();
    static Mapa2 Q2 = new Mapa2();
    private static Sprite sprite;

    //FUNÇÂO QUE VERIFICA SE A IMAGEM ESTA NA AREA DA CAMERA

    private static boolean naAreaDaCamera(int x, int y, OrthographicCamera camera, SpriteBatch batch, Sprite sprite) {
        float larg = sprite.getWidth();
        float alt = sprite.getHeight();
        boolean resposta = false;

        if ((x < camera.position.x + telaLarg / 2 && x + larg > camera.position.x - telaLarg / 2) && (y < camera.position.y + telaAlt / 2 && y + alt > camera.position.y - telaAlt / 2)) {
            resposta = true;

        } else
            resposta = false;


        return resposta;
    }

    public static void Mapa(int x, int y, OrthographicCamera camera, SpriteBatch batch,int fundoatual) {
        sprite = MapaNum(fundoatual);
        Desenhar(x, y, sprite, batch, camera);
    }

    public static void Desenhar(int x, int y, Sprite sprite, SpriteBatch batch, OrthographicCamera camera) {
        if (naAreaDaCamera(x, y, camera, batch, sprite)) {
            batch.draw(sprite, x, y);

        }
    }


    public static Sprite MapaNum(int fundoatual) {
        switch (fundoatual) {
            case 1:
                return Q1.sprite;
            case 2:
                return Q2.sprite;
        }
        return Q1.sprite;
    }

}





