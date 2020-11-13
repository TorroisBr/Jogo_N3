package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.quadrante.CIDADE;
import com.mygdx.game.quadrante.JoringArmas;
import com.mygdx.game.quadrante.Mapa1;
import com.mygdx.game.quadrante.Mapa2;

import static com.mygdx.game.MyGdxGame2.*;

public class CameraView {
    public static Mapa1 Q1 = new Mapa1();
    public static Mapa2 Q2 = new Mapa2();
    public static JoringArmas Q3 = new JoringArmas();
    public static CIDADE Q4 = new CIDADE();


    //FUNÇÂO QUE VERIFICA SE O SPRITE ESTA NA AREA DA CAMERA

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

    //CHAMA O MAPANUM
    public static void Mapa(int x, int y, OrthographicCamera camera, SpriteBatch batch, int fundoatual) {
        MapaNum(fundoatual);

    }


    //EXECUTA FUNÇÂO NA AREA DA CEMARA E CONFORME RESPOSTA DESENHA O MAPA
    public static void Desenhar(int x, int y, Sprite sprite, SpriteBatch batch, OrthographicCamera camera) {
        if (naAreaDaCamera(x, y, camera, batch, sprite)) {
            batch.draw(sprite, x, y);

        }
    }
    public static void DesenharHitbox(int x,int y,Sprite sprite,int larg,int alt){
        if (naAreaDaCamera(x, y, camera, batch, sprite)) {
            renderer.begin(ShapeRenderer.ShapeType.Line);
            renderer.rect(x,y,larg,alt);
            renderer.end();
        }
    }


//CHAMA PERCORRER ARRAY COM O FUNDO ATUAL
    public static void MapaNum(int fundoatual) {
        switch (fundoatual) {
            case 1:
                percorrerArrayMapa(Q1.sprite, Q1.xy);
                break;
            case 4:
                percorrerArrayMapa(Q4.sprite, Q4.xy);

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

    //CHAMA O METODO DEFINIR LIMETES COM O MAPA CORRETO
    public static void escolherDefinirLimites(int mapa) {
        switch (mapa) {
            case 1:
                DefinirLimites(Q1.sprite, Q1.xy);
                break;
            case 2:
//                DefinirLimites(Q2.sprite, Q2.xy)
                break;
            case 3:
//                DefinirLimites(Q3.sprite, Q3.xy);
                break;
            case 4:
                DefinirLimites(Q4.sprite, Q4.xy);
                break;

        }

    }

}











