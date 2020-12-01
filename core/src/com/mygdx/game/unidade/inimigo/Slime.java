package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.CameraView.Desenhar;
import static com.mygdx.game.MyGdxGame2.*;

public class Slime extends Inimigo {
    Texture[][][] texture;
    public Sprite[][][] sprite;
    public int dano;
    public float tempoAtaque = 0;


    public Slime(int x, int y, int direcao, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt) {
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.vida = 30;
        this.velo = 2;
        this.estado = 0;
        this.hitboxDano = new Rectangle(x, y, HitBoxDanoLarg, HitBoxDanoAlt);
        this.hitboxMapa = new Rectangle(x, y, HitBoxMapaLarg, HitBoxMapaAlt);
        this.dano = 2;
        this.visivel = true;
    }


    public void ColisaoPlayer() {
        if (hitboxMapa.overlaps(jogador.hitboxMapa) && jogador.estado != 3 && jogador.estado != -1 && jogador.invencibilidade<=0) {
            jogador.tempo = 0;
            //SO PERMITE QUE ACERTE O JOGADOR EM UM FRAME
            jogador.estado = 3;
            jogador.tomarDano(dano);
            switch (direcao) {
                case 0:
                    jogador.direcao = 2;
                    break;
                case 1:
                    jogador.direcao = 3;
                    break;
                case 2:
                    jogador.direcao = 0;
                    break;
                case 3:
                    jogador.direcao = 1;
                    break;
            }
            jogador.currentFrame = 0;
            jogador.animAtual = 4;
        }
    }


    public void Draw() {
        Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getWidth() / 2, y + (int) hitboxDano.getHeight() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getHeight() / 2, sprite[direcao][animAtual][(int) currentFrame], batch, camera);
    }

    public void morrendo() {

        if (currentFrame < sprite[0][5].length - 1)
            animar(false, 0.12F);
        else {
            if (currentFrame == sprite[0][5].length - 1) {
                tempo = 0;
            }
            if (tempo < 2) {
                tempo += Gdx.graphics.getDeltaTime();
                if ((int) (tempo * 100) % 2 == 0) {
                    visivel = !visivel;
                }
            } else
                estado = -2;
        }
    }

    public void animar(boolean loop, float velocidadeAnim) {
        currentFrame += velocidadeAnim;
        if ((int) currentFrame > sprite[direcao][animAtual].length - 1) {
            if (loop) {
                currentFrame = 0;
            } else
                currentFrame = sprite[direcao][animAtual].length - 1;
        }

    }

    //Moviemnta o slime baseado no movX ou movY


    //Seguir o jogador
    public void Seguir() {

        if (vida > 0) {

//MOVIMENTO Y
            if (y > jogador.y + 2) {

                movY = -velo;
            } else if (y < jogador.y - 2) {

                movY = velo;

            } else
                movY = 0;

//MOVIMENTO X
            if (x > jogador.x + 2) {
                movX = -velo;

            } else if (x < jogador.x - 2) {
                movX = velo;

            } else
                movX = 0;
//DIRECAO
            if (movY != 0) {
                if (movY >= 0)
                    direcao = 2;
                else
                    direcao = 0;
            } else if (movX != 0) {

                if (movX >= 0)
                    direcao = 3;
                else
                    direcao = 1;
            }
            ColisaoPlayer();
            animar(true, 0.15F);
        }
    }

    @Override
    public void Atacar() {
        ColisaoPlayer();
        if (currentFrame < 2) {
            animar(false, 0.12F);

        } else if (tempo < 1.5) {
            tempo += Gdx.graphics.getDeltaTime();

            switch (direcao) {
                case 0:
                    movY = -(int) ((float) 120 * Gdx.graphics.getDeltaTime());
                    break;
                case 1:
                    movX = -(int) ((float) 120 * Gdx.graphics.getDeltaTime());
                    break;
                case 2:
                    movY = +(int) ((float) 120 * Gdx.graphics.getDeltaTime());
                    break;
                case 3:
                    movX = (int) ((float) 120 * Gdx.graphics.getDeltaTime());
                    break;
            }
            Move(mapas[fundoatual].colisoes);

        } else if ((int) currentFrame < sprite[direcao][animAtual].length - 1) {
            animar(false, 0.12F);
        } else {
            tempoAtaque = 0;
            currentFrame = 0;
            estado = 0;
            animAtual = 1;
        }
    }


    public void ConferirAtaque() {
        double JX = jogador.x + jogador.hitboxMapa.getWidth() / 2;
        double JY = jogador.y + jogador.hitboxMapa.getHeight() / 2;
        double JR = (jogador.hitboxMapa.getHeight() >= jogador.hitboxMapa.getWidth()) ? jogador.hitboxMapa.getHeight() / 2 : jogador.hitboxMapa.getWidth() / 2;
        double X = x + hitboxMapa.getWidth() / 2;
        double Y = y + hitboxMapa.getHeight() / 2;
        double R = (hitboxMapa.getHeight() >= hitboxMapa.getWidth()) ? hitboxMapa.getHeight() / 2 : hitboxMapa.getWidth() / 2;
        double distanciaX = X - JX;
        double distanciaY = Y - JY;


        if (Math.sqrt(((distanciaX * distanciaX) + (distanciaY * distanciaY))) < (R + JR + 60.0F)) {
            estado = 1;
            currentFrame = 0;
            animAtual = 2;
            tempo = 0;

            switch ((int) (Math.random() * 6))
            {
                case 0:
                    soundController.tocarSom(9);
                    break;

                case 1:
                    soundController.tocarSom(10);
                    break;

                case 2:
                    soundController.tocarSom(11);
                    break;

                case 22:
                    soundController.tocarSom(12);
                    break;

                case 4:
                    soundController.tocarSom(13);
                    break;

                case 5:
                    soundController.tocarSom(14);
                    break;
            }

            if (y > jogador.y + 2) {
                direcao = 0;
            } else if (y < jogador.y - 2) {

                direcao = 2;
            } else if (x > jogador.x + 2) {
                direcao = 1;

            } else {
                direcao = 3;

            }
        }
    }


    @Override
    public void Andar() {
        AtualizaRetangulos();
        DanoEspada();
        Seguir();
        Move(mapas[fundoatual].colisoes);

        if (tempoAtaque < 2)
            tempoAtaque += Gdx.graphics.getDeltaTime();
        else
            ConferirAtaque();


    }

    @Override

    public void iniciar() {
        //INICIALIZANDO OS ARRAYS ONDE SERÂO GUARDADOS OS SPRITES DOS PERSONAGENS

        texture = new Texture[4][][];
        texture[0] = new Texture[6][];
        texture[1] = new Texture[6][];
        texture[2] = new Texture[6][];
        texture[3] = new Texture[6][];

        texture[0][0] = new Texture[1];
        texture[0][1] = new Texture[6];
        texture[0][2] = new Texture[4];
        texture[0][3] = new Texture[1];
        texture[0][4] = new Texture[4];
        texture[0][5] = new Texture[4];

        texture[1][0] = new Texture[1];
        texture[1][1] = new Texture[6];
        texture[1][2] = new Texture[4];
        texture[1][3] = new Texture[1];
        texture[1][4] = new Texture[4];
        texture[1][5] = new Texture[4];


        texture[2][0] = new Texture[1];
        texture[2][1] = new Texture[6];
        texture[2][2] = new Texture[4];
        texture[2][3] = new Texture[1];
        texture[2][4] = new Texture[4];
        texture[2][5] = new Texture[4];


        texture[3][0] = new Texture[1];
        texture[3][1] = new Texture[6];
        texture[3][2] = new Texture[4];
        texture[3][3] = new Texture[1];
        texture[3][4] = new Texture[4];
        texture[3][5] = new Texture[4];


        sprite = new Sprite[4][][];
        sprite[0] = new Sprite[6][];
        sprite[1] = new Sprite[6][];
        sprite[2] = new Sprite[6][];
        sprite[3] = new Sprite[6][];

        sprite[0][0] = new Sprite[1];
        sprite[0][1] = new Sprite[6];
        sprite[0][2] = new Sprite[5];
        sprite[0][3] = new Sprite[1];
        sprite[0][4] = new Sprite[4];
        sprite[0][5] = new Sprite[4];


        sprite[1][0] = new Sprite[1];
        sprite[1][1] = new Sprite[6];
        sprite[1][2] = new Sprite[5];
        sprite[1][3] = new Sprite[1];
        sprite[1][4] = new Sprite[4];
        sprite[1][5] = new Sprite[4];


        sprite[2][0] = new Sprite[1];
        sprite[2][1] = new Sprite[6];
        sprite[2][2] = new Sprite[5];
        sprite[2][3] = new Sprite[1];
        sprite[2][4] = new Sprite[4];
        sprite[2][5] = new Sprite[4];


        sprite[3][0] = new Sprite[1];
        sprite[3][1] = new Sprite[6];
        sprite[3][2] = new Sprite[5];
        sprite[3][3] = new Sprite[1];
        sprite[3][4] = new Sprite[4];
        sprite[3][5] = new Sprite[4];


        //CARREGANDO AS IMAGENS
        carregarIdle();
        carregarAndar();
        carregarAtaque();
        carregarDano();
        carregarMorte();

    }

    public void carregarIdle() {
        //IDLE BAIXO

        texture[0][0][0] = new Texture("inimigo/Slime/GosmaFI.png");
        sprite[0][0][0] = new Sprite(texture[0][0][0]);

        //IDLE ESQUERDO

        texture[1][0][0] = new Texture("inimigo/Slime/GosmaLI.png");
        sprite[1][0][0] = new Sprite(texture[1][0][0]);
        sprite[1][0][0].flip(true, false);

        //IDLE CIMA

        texture[2][0][0] = new Texture("inimigo/Slime/GosmaCI.png");
        sprite[2][0][0] = new Sprite(texture[2][0][0]);

        //IDLE DIREITA

        texture[3][0][0] = new Texture("inimigo/Slime/GosmaLI.png");
        sprite[3][0][0] = new Sprite(texture[3][0][0]);
    }

    public void carregarAndar() {
        //ANDAR BAIXO

        texture[0][1][0] = new Texture("inimigo/Slime/GosmaFI.png");
        texture[0][1][1] = new Texture("inimigo/Slime/GosmaFA01.png");
        texture[0][1][2] = new Texture("inimigo/Slime/GosmaFA02.png");
        texture[0][1][3] = new Texture("inimigo/Slime/GosmaFA03.png");
        texture[0][1][4] = new Texture("inimigo/Slime/GosmaFA04.png");
        texture[0][1][5] = new Texture("inimigo/Slime/GosmaFA05.png");

        sprite[0][1][0] = new Sprite(texture[0][1][0]);
        sprite[0][1][1] = new Sprite(texture[0][1][1]);
        sprite[0][1][2] = new Sprite(texture[0][1][2]);
        sprite[0][1][3] = new Sprite(texture[0][1][3]);
        sprite[0][1][4] = new Sprite(texture[0][1][4]);
        sprite[0][1][5] = new Sprite(texture[0][1][5]);

        //ANDAR ESQUERDA

        texture[1][1][0] = new Texture("inimigo/Slime/GosmaLI.png");
        texture[1][1][1] = new Texture("inimigo/Slime/GosmaLA01.png");
        texture[1][1][2] = new Texture("inimigo/Slime/GosmaLA02.png");
        texture[1][1][3] = new Texture("inimigo/Slime/GosmaLA03.png");
        texture[1][1][4] = new Texture("inimigo/Slime/GosmaLA04.png");
        texture[1][1][5] = new Texture("inimigo/Slime/GosmaLA05.png");

        sprite[1][1][0] = new Sprite(texture[1][1][0]);
        sprite[1][1][1] = new Sprite(texture[1][1][1]);
        sprite[1][1][2] = new Sprite(texture[1][1][2]);
        sprite[1][1][3] = new Sprite(texture[1][1][3]);
        sprite[1][1][4] = new Sprite(texture[1][1][4]);
        sprite[1][1][5] = new Sprite(texture[1][1][5]);

        sprite[1][1][0].flip(true, false);
        sprite[1][1][1].flip(true, false);
        sprite[1][1][2].flip(true, false);
        sprite[1][1][3].flip(true, false);
        sprite[1][1][4].flip(true, false);
        sprite[1][1][5].flip(true, false);

        //ANDAR CIMA

        texture[2][1][0] = new Texture("inimigo/Slime/GosmaCI.png");
        texture[2][1][1] = new Texture("inimigo/Slime/GosmaCA01.png");
        texture[2][1][2] = new Texture("inimigo/Slime/GosmaCA02.png");
        texture[2][1][3] = new Texture("inimigo/Slime/GosmaCA03.png");
        texture[2][1][4] = new Texture("inimigo/Slime/GosmaCA04.png");
        texture[2][1][5] = new Texture("inimigo/Slime/GosmaCA05.png");

        sprite[2][1][0] = new Sprite(texture[2][1][0]);
        sprite[2][1][1] = new Sprite(texture[2][1][1]);
        sprite[2][1][2] = new Sprite(texture[2][1][2]);
        sprite[2][1][3] = new Sprite(texture[2][1][3]);
        sprite[2][1][4] = new Sprite(texture[2][1][4]);
        sprite[2][1][5] = new Sprite(texture[2][1][5]);

        //ANDAR DIREITA
        texture[3][1][0] = new Texture("inimigo/Slime/GosmaLI.png");
        texture[3][1][1] = new Texture("inimigo/Slime/GosmaLA01.png");
        texture[3][1][2] = new Texture("inimigo/Slime/GosmaLA02.png");
        texture[3][1][3] = new Texture("inimigo/Slime/GosmaLA03.png");
        texture[3][1][4] = new Texture("inimigo/Slime/GosmaLA04.png");
        texture[3][1][5] = new Texture("inimigo/Slime/GosmaLA05.png");

        sprite[3][1][0] = new Sprite(texture[3][1][0]);
        sprite[3][1][1] = new Sprite(texture[3][1][1]);
        sprite[3][1][2] = new Sprite(texture[3][1][2]);
        sprite[3][1][3] = new Sprite(texture[3][1][3]);
        sprite[3][1][4] = new Sprite(texture[3][1][4]);
        sprite[3][1][5] = new Sprite(texture[3][1][5]);
    }

    public void carregarAtaque() {
        //ATACAR ESPADA BAIXO

        texture[0][2][0] = new Texture("inimigo/Slime/GosmaFAt01.png");
        texture[0][2][1] = new Texture("inimigo/Slime/GosmaF_e_CAt02.png");
        texture[0][2][2] = new Texture("inimigo/Slime/GosmaF_e_CAt03.png");


        sprite[0][2][0] = new Sprite(texture[0][2][0]);
        sprite[0][2][1] = new Sprite(texture[0][2][1]);
        sprite[0][2][2] = new Sprite(texture[0][2][2]);
        sprite[0][2][3] = new Sprite(texture[0][2][1]);
        sprite[0][2][4] = new Sprite(texture[0][2][0]);


        //ATACAR ESPADA ESQUERDA
        texture[1][2][0] = new Texture("inimigo/Slime/GosmaLAt01.png");
        texture[1][2][1] = new Texture("inimigo/Slime/GosmaLAt02.png");
        texture[1][2][2] = new Texture("inimigo/Slime/GosmaLAt03.png");


        sprite[1][2][0] = new Sprite(texture[1][2][0]);
        sprite[1][2][1] = new Sprite(texture[1][2][1]);
        sprite[1][2][2] = new Sprite(texture[1][2][2]);
        sprite[1][2][3] = new Sprite(texture[1][2][1]);
        sprite[1][2][4] = new Sprite(texture[1][2][0]);


        sprite[1][2][0].flip(true, false);
        sprite[1][2][1].flip(true, false);
        sprite[1][2][2].flip(true, false);
        sprite[1][2][3].flip(true, false);
        sprite[1][2][4].flip(true, false);


        //ATACAR ESPADA CIMA

        texture[2][2][0] = new Texture("inimigo/Slime/GosmaCAt01.png");
        texture[2][2][1] = new Texture("inimigo/Slime/GosmaF_e_CAt02.png");
        texture[2][2][2] = new Texture("inimigo/Slime/GosmaF_e_CAt03.png");


        sprite[2][2][0] = new Sprite(texture[2][2][0]);
        sprite[2][2][1] = new Sprite(texture[2][2][1]);
        sprite[2][2][2] = new Sprite(texture[2][2][2]);
        sprite[2][2][3] = new Sprite(texture[2][2][1]);
        sprite[2][2][4] = new Sprite(texture[2][2][0]);

        //ATACAR ESPADA DIREITA
        texture[3][2][0] = new Texture("inimigo/Slime/GosmaLAt01.png");
        texture[3][2][1] = new Texture("inimigo/Slime/GosmaLAt02.png");
        texture[3][2][2] = new Texture("inimigo/Slime/GosmaLAt03.png");


        sprite[3][2][0] = new Sprite(texture[3][2][0]);
        sprite[3][2][1] = new Sprite(texture[3][2][1]);
        sprite[3][2][2] = new Sprite(texture[3][2][2]);
        sprite[3][2][3] = new Sprite(texture[3][2][1]);
        sprite[3][2][4] = new Sprite(texture[3][2][0]);

    }

    public void carregarDano() {
        //DANO BAIXO
        texture[0][4][0] = new Texture("inimigo/Slime/GosmaFDa01.png");
        sprite[0][4][0] = new Sprite(texture[0][4][0]);

        //DANO ESQUERDO

        texture[1][4][0] = new Texture("inimigo/Slime/GosmaLDa01.png");
        sprite[1][4][0] = new Sprite(texture[1][4][0]);
        sprite[1][4][0].flip(true, false);

        //DANO COSTAS

        texture[2][4][0] = new Texture("inimigo/Slime/GosmaCDa01.png");
        sprite[2][4][0] = new Sprite(texture[2][4][0]);

        //DANO DIREITA

        texture[3][4][0] = new Texture("inimigo/Slime/GosmaLDa01.png");
        sprite[3][4][0] = new Sprite(texture[3][4][0]);
    }

    public void carregarMorte() {

        //MORTE BAIXO
        texture[0][5][0] = new Texture("inimigo/Slime/GosmaMo01.png");
        texture[0][5][1] = new Texture("inimigo/Slime/GosmaMo02.png");
        texture[0][5][2] = new Texture("inimigo/Slime/GosmaMo03.png");
        texture[0][5][3] = new Texture("inimigo/Slime/GosmaMo04.png");

        sprite[0][5][0] = new Sprite(texture[0][5][0]);
        sprite[0][5][1] = new Sprite(texture[0][5][1]);
        sprite[0][5][2] = new Sprite(texture[0][5][2]);
        sprite[0][5][3] = new Sprite(texture[0][5][3]);

    }
}




