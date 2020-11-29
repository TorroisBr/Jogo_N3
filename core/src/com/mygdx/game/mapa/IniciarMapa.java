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
import static com.mygdx.game.MyGdxGame2.telaLarg;


public class IniciarMapa {



    public void Esgoto01(Mapa mapa) {

        Slime slime = new Slime(1000, 700, 3, 39, 52, 39, 25);
        Slime slime2 = new Slime(1025, 735, 3, 39, 52, 39, 25);
        Ladrao ladrao = new Ladrao(800, 800, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 1581, 118, "cidade/esgoto_Parede_01");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[5];

        mapa.inimigoarray.add(slime);
        mapa.inimigoarray.add(slime2);

        mapa.portaLocal = new Portas[1];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/esgoto01.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(-325, 358 - 358, 325, 358);
        mapa.colisoes[1] = new Rectangle(-1, 786 - 432, 325, 432);
        mapa.colisoes[2] = new Rectangle(324, 789 - 311, 229, 311);
        mapa.colisoes[3] = new Rectangle(554, 787 - 368, 1026, 368);
        mapa.colisoes[4] = new Rectangle(0, 58 - 196, 1581, 196);


        //PORTAS
        mapa.portaLocal[0] = new Portas(1549, 418 - 362, 68, 362, 3, 100, 300 - 87);
    }

    public void Esgoto02(Mapa mapa) {

        Slime slime = new Slime(500, 300, 3, 39, 52, 39, 25);
        Slime slime2 = new Slime(100, 400, 3, 39, 52, 39, 25);
        Slime slime3 = new Slime(1000, 500, 3, 39, 52, 39, 25);

        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 1449, 113, "cidade/esgoto_Parede_02");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[3];

        mapa.inimigoarray.add(slime);
        mapa.inimigoarray.add(slime2);
        mapa.inimigoarray.add(slime3);

        mapa.portaLocal = new Portas[2];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/esgoto02.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(1, 695 - 321, 1276, 321);
        mapa.colisoes[1] = new Rectangle(1276, 696 - 454, 114, 696);
        mapa.colisoes[2] = new Rectangle(0, 36 - 93, 1392, 93);


        //  pota certa pra aqui      mapa.portaLocal[0] = new Portas(1548, 890 - 76, 50, 50, 2, 100, 909 - 87);
        //PORTAS
        mapa.portaLocal[0] = new Portas(-34, 380 - 344, 81, 344, 2, 1358, 302 - 71);
        mapa.portaLocal[1] = new Portas(1344, 239 - 206, 81, 206, 4, 100, 302 - 71);
    }

    public void Esgoto03(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 482, 0, "cidade/esgoto_Parede_03");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[6];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[2];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/esgoto03.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(0, 569 - 322, 79, 322);
        mapa.colisoes[1] = new Rectangle(79, 723 - 323, 324, 323);


        mapa.colisoes[2] = new Rectangle(440, 400 - 392, 58, 392);

        mapa.colisoes[3] = new Rectangle(0, 157 - 204, 47, 204);

        mapa.colisoes[4] = new Rectangle(0, 26 - 46, 203, 46);
        mapa.colisoes[5] = new Rectangle(308, 26 - 46, 203, 46);


        //PORTAS
        mapa.portaLocal[0] = new Portas(-83, 294 - 110, 66, 110, 3, 1200, 250);
        mapa.portaLocal[1] = new Portas(172, 19 - 45, 137, 45, 5, 265, 1095 - 38);
    }

    public void SalaJantar(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 1145, 1412, "cidade/SalaDeJantarIncendiada_Parede");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[6];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
        //mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[2];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/SalaDeJantarIncendiada.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(81, 1410-307, 978, 307);
        mapa.colisoes[1] = new Rectangle(1057, 1109 - 577, 89, 577);

        mapa.colisoes[2] = new Rectangle(1089, 452 - 453, 89, 423);
        mapa.colisoes[3] = new Rectangle(755, 29 - 31, 334, 31);
        mapa.colisoes[4] = new Rectangle(41, 29 - 31, 356, 31);
        mapa.colisoes[5] = new Rectangle(-47, 1413 - 1415, 89, 1415);


        //PORTAS
        mapa.portaLocal[0] = new Portas(1146, 531 - 78, 89, 78, 6, 1200, 250);
        mapa.portaLocal[1] = new Portas(398, 1 - 78, 334, 78, 6, 557, 1009 - 102);
    }

    public void SalaFoço(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 1198, 1198, "cidade/SalaDeBaixoDaSalaDeJantar_Parede");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[10];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[2];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/SalaDeBaixoDaSalaDeJantar.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(82, 1199-284, 385, 284);
        mapa.colisoes[1] = new Rectangle(754, 1199-284, 385, 284);

        mapa.colisoes[2] = new Rectangle(220, 815 - 241, 285, 241);
        mapa.colisoes[3] = new Rectangle(735, 815 - 241, 285, 241);
        mapa.colisoes[4] = new Rectangle(220, 437 - 241, 285, 241);
        mapa.colisoes[5] = new Rectangle(735, 437 - 241, 285, 241);

        mapa.colisoes[6] = new Rectangle(0, 1199 - 1199, 46, 1199);
        mapa.colisoes[7] = new Rectangle(1153, 1199 - 1199, 46, 1199);

        mapa.colisoes[8] = new Rectangle(46, 34 - 117, 420, 117);
        mapa.colisoes[9] = new Rectangle(733, 34 - 117, 420, 117);




        //PORTAS
        mapa.portaLocal[0] = new Portas(467, 1301 - 102, 290, 102, 5, 450, 70);
        mapa.portaLocal[1] = new Portas(466, 0 - 82, 266, 82, 6, 100, 302 - 71);
    }


    public void Cidade01(Mapa mapa) {
        //CRIANDO INIMIGOS
        Slime slime = new Slime(600, 600, 3, 39, 52, 39, 25);
        Slime slime2 = new Slime(0, 0, 3, 39, 52, 39, 25);
        Ladrao ladrao = new Ladrao(800, 800, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(510, 333 - 113, 161, 113, "hitbox");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[4];
        mapa.spriteLocal = new Sprite[4];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[12];
        mapa.inimigoarray.add(slime);
        mapa.inimigoarray.add(slime2);
        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[1];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

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


        //PORTAS
        mapa.portaLocal[0] = new Portas(1500, 890 - 76, 50, 50, 2, 387, 487 - 93);


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

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
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
