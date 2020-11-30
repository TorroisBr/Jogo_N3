package com.mygdx.game.mapa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.ObjetoCenario;
import com.mygdx.game.unidade.inimigo.Inimigo;
import com.mygdx.game.unidade.inimigo.Ladrao;
import com.mygdx.game.unidade.inimigo.Slime;

import static com.mygdx.game.MyGdxGame2.jogador;


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

        mapa.colisoes[4] = new Rectangle(0, 26 - 46, 170, 46);
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
        mapa.colisoes = new Rectangle[7];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
        //mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[3];

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
        mapa.colisoes[0] = new Rectangle(81, 1410-307, 140, 307);
        mapa.colisoes[1] = new Rectangle(360, 1410-307, 698, 307);
        mapa.colisoes[2] = new Rectangle(1057, 1109 - 577, 89, 577);

        mapa.colisoes[3] = new Rectangle(1089, 452 - 453, 89, 423);
        mapa.colisoes[4] = new Rectangle(755, 29 - 31, 334, 31);
        mapa.colisoes[5] = new Rectangle(41, 29 - 31, 356, 31);
        mapa.colisoes[6] = new Rectangle(-47, 1413 - 1415, 89, 1415);


        //PORTAS
        mapa.portaLocal[0] = new Portas(1146, 531 - 78, 89, 78, 10, 79, 1039-205);
        mapa.portaLocal[1] = new Portas(398, 1 - 78, 334, 78, 6, 557, 1009 - 102);
        mapa.portaLocal[2] = new Portas(225, 1268 - 89, 132, 89, 4, 174, 152 - 75);

    }

    public void SalaFosso(Mapa mapa) {

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
        mapa.portaLocal[0] = new Portas(467, 1301 - 102, 290, 102, 5, 520, 70);
        mapa.portaLocal[1] = new Portas(466, 0 - 82, 266, 82, 7, 449, 877 - 151);
    }

    public void SalaTresPortas(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 1198, 1198, "cidade/Sala3Portas_Parede");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[7];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[3];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/Sala3Portas.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(80, 929-324, 234, 324);
        mapa.colisoes[1] = new Rectangle(654, 929-324, 817, 324);

        mapa.colisoes[2] = new Rectangle(0, 830 - 610, 80, 610);
        mapa.colisoes[3] = new Rectangle(1468, 830 - 610, 80, 610);

        mapa.colisoes[4] = new Rectangle(-32, 53 - 151, 80, 151);
        mapa.colisoes[5] = new Rectangle(47, 53 - 90, 1499, 90);
        mapa.colisoes[6] = new Rectangle(1466, 53 - 151, 80, 151);


        //PORTAS
        mapa.portaLocal[0] = new Portas(314, 1001 - 72, 340, 72, 6, 450, 70);
        mapa.portaLocal[1] = new Portas(-103, 220 - 218, 103, 218, 8, 737, 208 - 87);
        mapa.portaLocal[2] = new Portas(1548, 218 - 218, 103, 218, 9, 100, 302 - 71);

    }

    public void SalaBauEsquerdo(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 1198, 1198, "cidade/SalaBauEsquerdo_Parede");
        casa1.sprite.flip(true,false);


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[7];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
//        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[1];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/SalaBauEsquerdo.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);
        mapa.spriteLocal[0].flip(true,false);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(68, 581-358, 438, 358);
        mapa.colisoes[1] = new Rectangle(501, 581-278, 306, 278);
        mapa.colisoes[2] = new Rectangle(804, 581-372, 67, 372);

        mapa.colisoes[3] = new Rectangle(843, 121 - 159, 67, 159);
        mapa.colisoes[4] = new Rectangle(-39, 581 - 583, 67, 583);
        mapa.colisoes[5] = new Rectangle(28, 28 - 30, 816, 30);

        mapa.colisoes[6] = new Rectangle(68, 140 -75, 438, 75);



        //PORTAS
        mapa.portaLocal[0] = new Portas(872, 208 - 87, 67, 87, 7, 117, 217-55);


    }

    public void SalaBauDireito(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 1198, 1198, "cidade/SalaBauEsquerdo_Parede");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[7];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
//        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[1];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/SalaBauEsquerdo.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(394, 581-358, 438, 358);
        mapa.colisoes[1] = new Rectangle(92, 581-278, 306, 278);
        mapa.colisoes[2] = new Rectangle(28, 581-372, 67, 372);

        mapa.colisoes[3] = new Rectangle(-10, 121 - 159, 67, 159);
        mapa.colisoes[4] = new Rectangle(872, 581 - 583, 67, 583);
        mapa.colisoes[5] = new Rectangle(56, 28 - 30, 816, 30);

        mapa.colisoes[6] = new Rectangle(394, 140 -75, 438, 75);



        //PORTAS NOVO X 96 NOVO Y 208-87
        mapa.portaLocal[0] = new Portas(-39, 208 - 87, 67, 87, 7, 117, 217-55);


    }

    public void SalaSaguao(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 652, 601, "cidade/Parede_de_baixo");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[23];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
//        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[3];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/Primeiro_andar.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(0, 1321-298, 457, 298);
        mapa.colisoes[1] = new Rectangle(0, 1022-24, 396, 24);
        mapa.colisoes[2] = new Rectangle(0, 997-24, 328, 24);
        mapa.colisoes[3] = new Rectangle(0, 972-80, 152, 80);
        mapa.colisoes[4] = new Rectangle(144, 972-376, 8, 376);
        mapa.colisoes[5] = new Rectangle(0, 892-605, 74, 905);
        mapa.colisoes[6] = new Rectangle(0, 162-162, 36, 162);
        mapa.colisoes[7] = new Rectangle(36, 34-34, 503, 34);

        mapa.colisoes[8] = new Rectangle(910, 1321-282, 463, 282);
        mapa.colisoes[9] = new Rectangle(972, 1038-40, 400, 40);
        mapa.colisoes[10] = new Rectangle(1035, 1000-24, 337, 24);
        mapa.colisoes[11] = new Rectangle(1214, 975-80, 158, 80);
        mapa.colisoes[12] = new Rectangle(1214, 975-380, 8, 380);
        mapa.colisoes[13] = new Rectangle(1298, 895-605, 74, 895);
        mapa.colisoes[14] = new Rectangle(1336, 162-162, 36, 162);
        mapa.colisoes[15] = new Rectangle(833, 34-34, 539, 34);

        mapa.colisoes[16] = new Rectangle(325, 820-230, 8, 230);
        mapa.colisoes[17] = new Rectangle(333, 820-28, 58, 28);
        mapa.colisoes[18] = new Rectangle(392, 848-28, 66, 28);
        mapa.colisoes[19] = new Rectangle(458, 889-40, 450, 40);
        mapa.colisoes[20] = new Rectangle(909, 848-28, 66, 28);
        mapa.colisoes[21] = new Rectangle(975, 820-28, 61, 28);
        mapa.colisoes[22] = new Rectangle(1029, 791-195, 8, 195);


        mapa.portaLocal[0] = new Portas(-42, 286 - 124, 42, 124, 7, 117, 217-55);
        mapa.portaLocal[1] = new Portas(1373, 286 - 124, 42, 124, 7, 117, 217-55);
        mapa.portaLocal[2] = new Portas(457, 1380 - 59, 453, 59, 10, 910, 262-85);


    }

    public void SalaDragao(Mapa mapa) {

        Ladrao ladrao = new Ladrao(200, 50, 0, 56, 126, 56, 39, 1);
        ObjetoCenario casa1 = new ObjetoCenario(0, 0, 2079, 943, "cidade/SalaDoDragao_Parede");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];
        mapa.colisoes = new Rectangle[24];
//        mapa.inimigoarray.add(slime);
//        mapa.inimigoarray.add(slime2);
//        mapa.inimigoarray.add(ladrao);
        mapa.portaLocal = new Portas[4];

        mapa.desenhoArray.add(casa1);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/SalaDoDragao.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes[0] = new Rectangle(543, 2081-254, 371, 254);
        mapa.colisoes[1] = new Rectangle(311, 1827-233, 231, 233);
        mapa.colisoes[2] = new Rectangle(79, 1593-233, 231, 233);
        mapa.colisoes[3] = new Rectangle(3, 1359-320, 75, 320);

        mapa.colisoes[4] = new Rectangle(1173, 2079-254, 371, 254);
        mapa.colisoes[5] = new Rectangle(1541, 1825-233, 231, 233);
        mapa.colisoes[6] = new Rectangle(1775, 1596-233, 231, 233);
        mapa.colisoes[7] = new Rectangle(2007, 1363-321, 78, 321);

        mapa.colisoes[8] = new Rectangle(2, 641-246, 232, 246);
        mapa.colisoes[9] = new Rectangle(232, 405-246, 232, 246);
        mapa.colisoes[10] = new Rectangle(466, 176-185, 443, 185);
        mapa.colisoes[11] = new Rectangle(1176, 178-175, 443, 175);
        mapa.colisoes[12] = new Rectangle(1851, 637-256, 232, 256);
        mapa.colisoes[13] = new Rectangle(1622, 413-256, 232, 256);
        mapa.colisoes[14] = new Rectangle(2, 842-201, 22, 201);
        mapa.colisoes[15] = new Rectangle(2060, 838-201, 22, 201);


        mapa.colisoes[16] = new Rectangle(608, 644-50, 78, 50);
        mapa.colisoes[17] = new Rectangle(533, 575-88, 78, 88);

        mapa.colisoes[18] = new Rectangle(1392, 644-50, 78, 50);
        mapa.colisoes[19] = new Rectangle(1466, 577-88, 78, 89);

        mapa.colisoes[20] = new Rectangle(609, 1385-30, 77, 30);
        mapa.colisoes[21] = new Rectangle(530, 1403-19, 83, 19);

        mapa.colisoes[22] = new Rectangle(1393, 1386-30, 77, 30);
        mapa.colisoes[23] = new Rectangle(1466, 1405-19, 83, 19);





        mapa.portaLocal[0] = new Portas(-72, 1039 - 205, 75, 205, 5, 117, 217-55);
        mapa.portaLocal[1] = new Portas(2083, 1044 - 205, 75, 205, 7, 117, 217-55);
        mapa.portaLocal[2] = new Portas(909, 2182 - 102, 263, 102, 7, 117, 217-55);
        mapa.portaLocal[3] = new Portas(910, 1 - 102, 263, 102, 9, 117, 217-55);


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

    public void Labirinto(Mapa mapa)
    {
        Slime slime = new Slime(1000, 700, 3, 39, 52, 39, 25);
        Slime slime2 = new Slime(1025, 735, 3, 39, 52, 39, 25);
        Ladrao ladrao = new Ladrao(800, 800, 0, 56, 126, 56, 39, 1);

        ObjetoCenario parede1 = new ObjetoCenario(245, 1333 - 444, 253, 444, "cidade/Labirinto_Parede1");
        ObjetoCenario parede2 = new ObjetoCenario(757, 1131 - 207, 389, 207, "cidade/Labirinto_Parede2");
        ObjetoCenario parede3 = new ObjetoCenario(566, 1131 - 335, 580, 335, "cidade/Labirinto_Parede3");
        ObjetoCenario parede4 = new ObjetoCenario(756, 1131 - 610, 390, 610, "cidade/Labirinto_Parede4");
        ObjetoCenario parede5 = new ObjetoCenario(0, 1004 - 544, 819, 544, "cidade/Labirinto_Parede5");
        ObjetoCenario parede6 = new ObjetoCenario(0, 1334 - 604, 308, 604, "cidade/Labirinto_Parede6");
        ObjetoCenario parede7 = new ObjetoCenario(214, 450 - 384, 553, 384, "cidade/Labirinto_Parede7");
        ObjetoCenario parede8 = new ObjetoCenario(755, 811 - 207, 191, 207, "cidade/Labirinto_Parede8");
        ObjetoCenario parede9 = new ObjetoCenario(908, 455 - 207, 239, 207, "cidade/Labirinto_Parede9");
        ObjetoCenario parede10 = new ObjetoCenario(1, 829 - 829, 1335, 829, "cidade/Labirinto_Parede10");


        //INSTANCIANDO VETORES
        mapa.texturaLocal = new Texture[1];
        mapa.spriteLocal = new Sprite[1];
        mapa.posicaoSprite = new int[mapa.spriteLocal.length][2];

        //mapa.inimigoarray.add(slime);
        //mapa.inimigoarray.add(slime2);

        mapa.desenhoArray.add(parede1);
        mapa.desenhoArray.add(parede2);
        mapa.desenhoArray.add(parede3);
        mapa.desenhoArray.add(parede4);
        mapa.desenhoArray.add(parede5);
        mapa.desenhoArray.add(parede6);
        mapa.desenhoArray.add(parede7);
        mapa.desenhoArray.add(parede8);
        mapa.desenhoArray.add(parede9);
        mapa.desenhoArray.add(parede10);

        mapa.desenhoArray.add(jogador);

        //Inicia os inimigos e os coloca no array de desenhos
        for (Inimigo inimigo : mapa.inimigoarray) {
            inimigo.iniciar();
            mapa.desenhoArray.add(inimigo);
        }

        //IMPORTANDO IMAGENS (IMPORTAR NESSA ORDEM) COM IMAGENS
        mapa.texturaLocal[0] = new Texture("cidade/Labirinto.png");


        //CARREGANDO SPRITES
        mapa.spriteLocal[0] = new Sprite(mapa.texturaLocal[0]);


        //POSICOES DO SPRITE
        mapa.posicaoSprite[0][0] = 0;
        mapa.posicaoSprite[0][1] = 0;


        //COLOCANDO COLISOES
        mapa.colisoes = new Rectangle[24];

        mapa.colisoes[0] = new Rectangle(216, 4, 1120, 63);
        mapa.colisoes[1] = new Rectangle(0, 478, 63, 537);
        mapa.colisoes[2] = new Rectangle(1273, 723, 63, 727);
        mapa.colisoes[3] = new Rectangle(883, 663, 63, 722);
        mapa.colisoes[4] = new Rectangle(883, 307, 264, 63);
        mapa.colisoes[5] = new Rectangle(755, 663, 191, 63);
        mapa.colisoes[6] = new Rectangle(214, 125, 553, 63);
        mapa.colisoes[7] = new Rectangle(214, 301, 63, 239);
        mapa.colisoes[8] = new Rectangle(705, 301, 63, 239);
        mapa.colisoes[9] = new Rectangle(1084, 983, 63, 466);
        mapa.colisoes[10] = new Rectangle(758, 983, 389, 63);
        mapa.colisoes[11] = new Rectangle(756, 983, 63, 191);
        mapa.colisoes[12] = new Rectangle(567, 855, 252, 63);
        mapa.colisoes[13] = new Rectangle(565, 855, 63, 398);
        mapa.colisoes[14] = new Rectangle(246, 520, 382, 63);
        mapa.colisoes[15] = new Rectangle(244, 791, 63, 333);
        mapa.colisoes[16] = new Rectangle(0, 791, 307, 63);
        mapa.colisoes[17] = new Rectangle(0, 1185, 63, 457);
        mapa.colisoes[18] = new Rectangle(245, 1187, 63, 300);
        mapa.colisoes[19] = new Rectangle(245, 949, 253, 63);
        mapa.colisoes[20] = new Rectangle(0, 1185, 1335, 63);
        mapa.colisoes[21] = new Rectangle(1273, 1183, 63, 283);
        mapa.colisoes[22] = new Rectangle(73, 1183, 153, 117);
        mapa.colisoes[23] = new Rectangle(955, 70, 311, 74);

        for(Rectangle retangulo : mapa.colisoes)
        {
            retangulo.y = retangulo.y - retangulo.height;
        }


        //PORTAS
        mapa.portaLocal = new Portas[3];

        mapa.portaLocal[0] = new Portas(-63, 728, 62, 250, 10, 100, 300 - 87);
        mapa.portaLocal[1] = new Portas(1336, 900, 62, 177, 10, 100, 300 - 87);
        mapa.portaLocal[2] = new Portas(63, -58, 154, 63, 10, 100, 300 - 87);

        for(Portas porta : mapa.portaLocal)
        {
            porta.colisao.y = porta.colisao.y - porta.colisao.height;
        }
    }


}
