package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import static com.mygdx.game.MyGdxGame2.*;

public class CameraView {



    //FUNÇÂO QUE VERIFICA SE O SPRITE ESTA NA AREA DA CAMERA

    private static boolean naAreaDaCamera(int x, int y, OrthographicCamera camera, SpriteBatch batch, Sprite sprite) {
        float larg = sprite.getWidth();
        float alt = sprite.getHeight();
        boolean resposta;

        if ((x < camera.position.x + telaLarg / 2 && x + larg > camera.position.x - telaLarg / 2) && (y < camera.position.y + telaAlt / 2 && y + alt > camera.position.y - telaAlt / 2)) {
            resposta = true;

        } else
            resposta = false;


        return resposta;
    }

    //CHAMA O MAPANUM



    //EXECUTA FUNÇÂO NA AREA DA CEMARA E CONFORME RESPOSTA DESENHA O MAPA
    public static void Desenhar(int x, int y, Sprite sprite, SpriteBatch batch, OrthographicCamera camera) {
        if (naAreaDaCamera(x, y, camera, batch, sprite)) {
            batch.draw(sprite, x, y);

        }
    }


    //PASSA PELAS IMAGENS E DEFINE OS LIMITES EXTERIORES DA CAMERA
    public static void DefinirLimites(Sprite sprite[], int XY[][]) {
        for (int i = 0; i < sprite.length; i++) {
            if (XY[i][0] < esquerdo) {
                esquerdo = XY[i][0];
            }
            if (XY[i][0] + sprite[i].getWidth() > direito) {
                direito = XY[i][0] + (int) sprite[i].getWidth();
            }

            if (XY[i][1] < baixo) {
                baixo = XY[i][1];
            }
            if (XY[i][1] + (int) sprite[i].getHeight() > cima) {
                cima = XY[i][1] + (int) sprite[i].getHeight();
            }
        }

    }

    //PERCORRE O ARRAY E DESENHA O MAPA NA POSICAO PASSADA
    public static void percorrerArrayMapa(Sprite sprite[], int XY[][]) {
        for (int i = 0; i < sprite.length; i++) {
            Desenhar(XY[i][0], XY[0][1], sprite[i], batch, camera);

        }

    }



}











