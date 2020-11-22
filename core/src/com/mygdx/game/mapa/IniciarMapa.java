package com.mygdx.game.mapa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.unidade.inimigo.Inimigo;
import com.mygdx.game.unidade.inimigo.Slime;

public class IniciarMapa {
    public void Cidade01(Mapa mapa) {
        //CRIANDO INIMIGOS
        Slime slime = new Slime(600, 600, 3, 39, 52, 39, 25);
        Slime slime2 = new Slime(0, 0, 3, 39, 52, 39, 25);

        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[4];
        mapa.spriteLocal = new Sprite[4];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[12];
        mapa.inimigoarray.add(slime);
        mapa.inimigoarray.add(slime2);
        mapa.portaLocal = new Portas[1];

        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM)
        mapa.texturaLocal[0] = new Texture("cidade/B1_03.png");
        mapa.texturaLocal[1] = new Texture("cidade/B1_04.png");
        mapa.texturaLocal[2] = new Texture("cidade/B1_01.png");
        mapa.texturaLocal[3] = new Texture("cidade/B1_02.png");

        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);
        mapa.spriteLocal[1] = new Sprite(mapa.texturaLocal[1]);
        mapa.spriteLocal[2] = new Sprite(mapa.texturaLocal[2]);
        mapa.spriteLocal[3] = new Sprite(mapa.texturaLocal[3]);

        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;

        mapa.posicaoSprite[1][0] = 0 + mapa.texturaLocal[0].getWidth();
        mapa.posicaoSprite[1][1] = 0;

        mapa.posicaoSprite[2][0] = 0;
        mapa.posicaoSprite[2][1] = 0 + mapa.texturaLocal[0].getHeight();

        mapa.posicaoSprite[3][0] = 0 + mapa.texturaLocal[0].getWidth();
        mapa.posicaoSprite[3][1] = 0 + mapa.texturaLocal[0].getHeight();

        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(310, 233 - 113, 161, 113);
        mapa.colisoes[1] = new Rectangle(959, 265 - 133, 239, 133);

        mapa.colisoes[2] = new Rectangle(142, 1488 - 84, 159, 84);
        mapa.colisoes[3] = new Rectangle(505, 1054 - 134, 162, 134);
        mapa.colisoes[4] = new Rectangle(1235, 1050 - 131, 162, 131);

        mapa.colisoes[5] = new Rectangle(126, 413 - 59, 96, 59);
        mapa.colisoes[6] = new Rectangle(658, 216 - 59, 96, 59);
        mapa.colisoes[7] = new Rectangle(678, 1303 - 59, 96, 59);
        mapa.colisoes[8] = new Rectangle(821, 1239 - 59, 96, 59);
        mapa.colisoes[9] = new Rectangle(1037, 1303 - 59, 96, 59);
        mapa.colisoes[10] = new Rectangle(1290, 1245 - 59, 96, 59);
        mapa.colisoes[11] = new Rectangle(1451, 1305 - 59, 96, 59);

        //PORTAS
        mapa.portaLocal[0] = new Portas(600, 600, 50, 50, 1, 35, 909 - 87);


    }

    public void Cidade02(Mapa mapa) {
        Slime slime3 = new Slime(600, 600, 3, 39, 52, 39, 25);
        Slime slime4 = new Slime(0, 0, 3, 39, 52, 39, 25);
//INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[9];
        mapa.spriteLocal = new Sprite[9];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[8];
        mapa.inimigoarray.add(slime3);
        mapa.inimigoarray.add(slime4);
        mapa.portaLocal = new Portas[1];

        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM)
        mapa.texturaLocal[0] = new Texture("cidade/B2_07.png");
        mapa.texturaLocal[1] = new Texture("cidade/B2_08.png");
        mapa.texturaLocal[2] = new Texture("cidade/B2_09.png");
        mapa.texturaLocal[3] = new Texture("cidade/B2_04.png");
        mapa.texturaLocal[4] = new Texture("cidade/B2_05.png");
        mapa.texturaLocal[5] = new Texture("cidade/B2_06.png");
        mapa.texturaLocal[6] = new Texture("cidade/B2_01.png");
        mapa.texturaLocal[7] = new Texture("cidade/B2_02.png");
        mapa.texturaLocal[8] = new Texture("cidade/B2_03.png");

        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);
        mapa.spriteLocal[1] = new Sprite(mapa.texturaLocal[1]);
        mapa.spriteLocal[2] = new Sprite(mapa.texturaLocal[2]);
        mapa.spriteLocal[3] = new Sprite(mapa.texturaLocal[3]);
        mapa.spriteLocal[4] = new Sprite(mapa.texturaLocal[4]);
        mapa.spriteLocal[5] = new Sprite(mapa.texturaLocal[5]);
        mapa.spriteLocal[6] = new Sprite(mapa.texturaLocal[6]);
        mapa.spriteLocal[7] = new Sprite(mapa.texturaLocal[7]);
        mapa.spriteLocal[8] = new Sprite(mapa.texturaLocal[8]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;

        mapa.posicaoSprite[1][0] = 0 + mapa.texturaLocal[0].getWidth();
        mapa.posicaoSprite[1][1] = 0;

        mapa.posicaoSprite[2][0] = mapa.posicaoSprite[1][0] + mapa.texturaLocal[1].getWidth();
        mapa.posicaoSprite[2][1] = 0;

        mapa.posicaoSprite[3][0] = 0;
        mapa.posicaoSprite[3][1] = 0 + mapa.texturaLocal[0].getHeight();

        mapa.posicaoSprite[4][0] = 0 + mapa.texturaLocal[3].getWidth();
        mapa.posicaoSprite[4][1] = 0 + mapa.texturaLocal[1].getHeight();

        mapa.posicaoSprite[5][0] = mapa.posicaoSprite[4][0] + mapa.texturaLocal[4].getWidth();
        mapa.posicaoSprite[5][1] = 0 + mapa.texturaLocal[2].getHeight();

        mapa.posicaoSprite[6][0] = 0;
        mapa.posicaoSprite[6][1] = mapa.posicaoSprite[3][1] + mapa.texturaLocal[3].getHeight();

        mapa.posicaoSprite[7][0] = 0 + mapa.texturaLocal[6].getWidth();
        mapa.posicaoSprite[7][1] = mapa.posicaoSprite[4][1] + mapa.texturaLocal[4].getHeight();

        mapa.posicaoSprite[8][0] = mapa.posicaoSprite[7][0] + mapa.texturaLocal[7].getWidth();
        mapa.posicaoSprite[8][1] = mapa.posicaoSprite[5][1] + mapa.texturaLocal[5].getHeight();


        mapa.colisoes[0] = new Rectangle(77, 1408 - 63, 97, 63);
        mapa.colisoes[1] = new Rectangle(198, 1289 - 63, 97, 63);
        mapa.colisoes[2] = new Rectangle(318, 1411 - 63, 97, 63);
        mapa.colisoes[3] = new Rectangle(1331, 1085 - 63, 97, 63);
        mapa.colisoes[4] = new Rectangle(1460, 1085 - 63, 97, 63);
        mapa.colisoes[5] = new Rectangle(154, 223 - 63, 97, 63);
        mapa.colisoes[6] = new Rectangle(352, 142 - 63, 97, 63);
        mapa.colisoes[7] = new Rectangle(753, 947 - 144, 162, 144);

        mapa.portaLocal[0] = new Portas(600, 600, 50, 50, 0, 10, 10);


    }


}
