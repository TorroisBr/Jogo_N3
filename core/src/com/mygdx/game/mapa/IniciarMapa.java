package com.mygdx.game.mapa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.ObjetoCenario;
import com.mygdx.game.unidade.Unidade;
import com.mygdx.game.unidade.inimigo.Inimigo;
import com.mygdx.game.unidade.inimigo.Ladrao;
import com.mygdx.game.unidade.inimigo.Slime;

import static com.mygdx.game.MyGdxGame2.jogador;


public class IniciarMapa {


    public void Cidade01(Mapa mapa) {
        //CRIANDO INIMIGOS
        Slime slime = new Slime(600, 600, 3, 39, 52, 39, 25);
        Slime slime2 = new Slime(0, 0, 3, 39, 52, 39, 25);
        Ladrao ladrao = new Ladrao(800, 800, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(310, 233 - 113, 161, 113, "hitbox");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[4];
        mapa.spriteLocal = new Sprite[4];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[12];
        mapa.inimigoarray.add(slime);
        mapa.inimigoarray.add(slime2);
        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[1];

        mapa.tudoArray.add(casa1);
        mapa.tudoArray.add(slime);
        mapa.tudoArray.add(slime2);
        mapa.tudoArray.add(ladrao);
        mapa.tudoArray.add(jogador);

        mapa.todosRetangulos = new Rectangle[3][/*mapa.spriteLocal.length+*/mapa.inimigoarray.size + mapa.colisoes.length + 1];

        //FOR QUE INICIA OS inimigos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();

        }
        for(Unidade unidade: mapa.tudoArray)
            unidade.iniciar();

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
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

//        mapa.colisoes[12] = new Rectangle(-19, 1668 - 1668, 19, 1668);
//        mapa.colisoes[13] = new Rectangle(0, 1667 - 19, 1664, 19);
//        mapa.colisoes[14] = new Rectangle(1664, 1668 - 1671, 21, 1671);
//        mapa.colisoes[15] = new Rectangle(0, 0, 1664, 17);

        mapa.todosRetangulos[0][0] = mapa.colisoes[0];
        mapa.todosRetangulos[0][1] = mapa.colisoes[1];
        mapa.todosRetangulos[0][2] = mapa.colisoes[2];
        mapa.todosRetangulos[0][3] = mapa.colisoes[3];
        mapa.todosRetangulos[0][4] = mapa.colisoes[4];
        mapa.todosRetangulos[0][5] = mapa.colisoes[5];
        mapa.todosRetangulos[0][6] = mapa.colisoes[6];
        mapa.todosRetangulos[0][7] = mapa.colisoes[7];
        mapa.todosRetangulos[0][8] = mapa.colisoes[8];
        mapa.todosRetangulos[0][9] = mapa.colisoes[9];
        mapa.todosRetangulos[0][10] = mapa.colisoes[10];
        mapa.todosRetangulos[0][11] = mapa.colisoes[11];

        mapa.todosRetangulos[1][12] = slime.hitboxDano;
        mapa.todosRetangulos[1][13] = slime2.hitboxDano;
        mapa.todosRetangulos[1][14] = ladrao.hitboxDano;


        mapa.todosRetangulos[2][15] = jogador.hitboxDano;


        //PORTAS
        mapa.portaLocal[0] = new Portas(1548, 890 - 76, 50, 50, 1, 100, 909 - 87);


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
        mapa.todosRetangulos = new Rectangle[3][/*mapa.spriteLocal.length+*/mapa.inimigoarray.size + mapa.colisoes.length + 1];


        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
        }

        //EXEMPLO COM 9 IMAGENS
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

        //HITBOX
        mapa.colisoes[0] = new Rectangle(77, 1408 - 63, 97, 63);
        mapa.colisoes[1] = new Rectangle(198, 1289 - 63, 97, 63);
        mapa.colisoes[2] = new Rectangle(318, 1411 - 63, 97, 63);
        mapa.colisoes[3] = new Rectangle(1331, 1085 - 63, 97, 63);
        mapa.colisoes[4] = new Rectangle(1460, 1085 - 63, 97, 63);
        mapa.colisoes[5] = new Rectangle(154, 223 - 63, 97, 63);
        mapa.colisoes[6] = new Rectangle(352, 142 - 63, 97, 63);
        mapa.colisoes[7] = new Rectangle(753, 947 - 144, 162, 144);

        mapa.portaLocal[0] = new Portas(35, 909 - 87, 50, 50, 0, 100, 890 - 76);


    }


}
