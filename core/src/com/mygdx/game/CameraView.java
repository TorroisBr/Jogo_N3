package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import static com.mygdx.game.MyGdxGame2.telaAlt;
import static com.mygdx.game.MyGdxGame2.telaLarg;

public class CameraView {

//FUNÇÂO QUE VERIFICA SE A IMAGEM ESTA NA AREA DA CAMERA
    public static boolean naAreaDaCamera(int x, int y, Texture imagem,OrthographicCamera camera) {

        int larg = imagem.getWidth();
        int alt = imagem.getHeight();
        boolean resposta;

        //Calculo para ver se o objeto esta dentro da  area da camera
        if ((x < camera.position.x + telaLarg / 2 && x + larg > camera.position.x - telaLarg / 2) && (y < camera.position.y + telaAlt / 2 && y + alt > camera.position.y - telaAlt / 2)) {
            resposta = true;
        } else
            resposta = false;
        return resposta;


    }
}





