package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.unidade.Jogador.*;
import com.mygdx.game.MyGdxGame2;

import static com.mygdx.game.CameraView.Desenhar;
import static com.mygdx.game.MyGdxGame2.*;

public class Slime extends Inimigo {
    Texture texture[][][];
    public Sprite sprite[][][];
    public float currentFrame = 0;
    public int animAtual = 1;
    public int dano;
    public int andar = 0;
    public int movX, movY;
    public double bufalobill = 0.03;


    public Slime(int x, int y, int direcao, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt) {
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.vida = 30;
        this.velo = 3;
        this.estado = 0;
        this.hitboxDano = new Rectangle(x, y, HitBoxDanoLarg, HitBoxDanoAlt);
        this.hitboxMapa = new Rectangle(x, y, HitBoxMapaLarg, HitBoxMapaAlt);
        this.dano = 5;
        this.morto = false;
    }

    public void morrer() {
        if (vida <= 0) {
            direcao = 0;
            animAtual = 4;
            animar(sprite);
        }
    }


    public void ColisaoPlayer() {

    }


    public void Draw() {
        Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getWidth() / 2, y + (int) hitboxDano.getHeight() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getHeight() / 2, sprite[direcao][animAtual][(int) currentFrame], batch, camera);
    }

    public void animar(Sprite[][][] array) {
        for (int i = 0; i < sprite[direcao][animAtual].length; i++) {
            currentFrame += bufalobill;

            if ((int) currentFrame > array[direcao][4].length-1  && animAtual == 4) {
                direcao=0;
                morto = true;
            }

            if ((int) currentFrame > array[direcao][animAtual].length - 1) {
                if(animAtual!=4)
                currentFrame = 0;
                //animAtual = 1;

            }

        }

    }

    //Atualiza a hitbox do inimigo
    public void AtualizaRetangulos() {
        hitboxDano.set(x, y, hitboxDano.getWidth(), hitboxDano.getHeight());
        hitboxMapa.set(x, y, hitboxMapa.getWidth(), hitboxMapa.getHeight());
    }


    //Moviemnta o slime baseado no movX ou movY
    public void Move() {
        if (movX > 0) {
            x += movX;
        } else if (movX < 0) {
            x += movX;
        }

        if (movY < 0) {
            y += movY;
        } else if (movY > 0) {
            y += movY;
        }

        movX = 0;
        movY = 0;
    }

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
            animar(sprite);
        }
    }

    @Override
    public void Atacar() {

//        if(jogador.hitboxDano.overlaps(hitboxDano)){
//            jogador.tomarDano(dano);
//
//        }

    }


    @Override
    public void Andar() {
        tomarDano();
        if (vida > 0) {
            Seguir();
            Move();
        }
        AtualizaRetangulos();
    }

    @Override

    public void iniciar() {
        //INICIALIZANDO OS ARRAYS ONDE SERÂO GUARDADOS OS SPRITES DOS PERSONAGENS

        texture = new Texture[4][][];
        texture[0] = new Texture[5][];
        texture[1] = new Texture[5][];
        texture[2] = new Texture[5][];
        texture[3] = new Texture[5][];

        texture[0][0] = new Texture[1];
        texture[0][1] = new Texture[6];
        texture[0][2] = new Texture[4];
        texture[0][3] = new Texture[1];
        texture[0][4] = new Texture[4];

        texture[1][0] = new Texture[1];
        texture[1][1] = new Texture[6];
        texture[1][2] = new Texture[4];
        texture[1][3] = new Texture[1];
        texture[1][4] = new Texture[4];

        texture[2][0] = new Texture[1];
        texture[2][1] = new Texture[6];
        texture[2][2] = new Texture[4];
        texture[2][3] = new Texture[1];
        texture[2][4] = new Texture[4];

        texture[3][0] = new Texture[1];
        texture[3][1] = new Texture[6];
        texture[3][2] = new Texture[4];
        texture[3][3] = new Texture[1];
        texture[3][4] = new Texture[4];

        sprite = new Sprite[4][][];
        sprite[0] = new Sprite[5][];
        sprite[1] = new Sprite[5][];
        sprite[2] = new Sprite[5][];
        sprite[3] = new Sprite[5][];

        sprite[0][0] = new Sprite[1];
        sprite[0][1] = new Sprite[6];
        sprite[0][2] = new Sprite[6];
        sprite[0][3] = new Sprite[1];
        sprite[0][4] = new Sprite[4];

        sprite[1][0] = new Sprite[1];
        sprite[1][1] = new Sprite[6];
        sprite[1][2] = new Sprite[6];
        sprite[1][3] = new Sprite[1];
        sprite[1][4] = new Sprite[4];

        sprite[2][0] = new Sprite[1];
        sprite[2][1] = new Sprite[6];
        sprite[2][2] = new Sprite[6];
        sprite[2][3] = new Sprite[1];
        sprite[2][4] = new Sprite[4];

        sprite[3][0] = new Sprite[1];
        sprite[3][1] = new Sprite[6];
        sprite[3][2] = new Sprite[6];
        sprite[3][3] = new Sprite[1];
        sprite[3][4] = new Sprite[4];


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

        texture[0][2][0] = new Texture("inimigo/Slime/GosmaCAt01.png");
        texture[0][2][1] = new Texture("inimigo/Slime/GosmaF_e_CAt02.png");
        texture[0][2][2] = new Texture("inimigo/Slime/GosmaF_e_CAt03.png");


        sprite[0][2][0] = new Sprite(texture[0][2][0]);
        sprite[0][2][1] = new Sprite(texture[0][2][1]);
        sprite[0][2][2] = new Sprite(texture[0][2][2]);
        sprite[0][2][3] = new Sprite(texture[0][2][0]);
        sprite[0][2][4] = new Sprite(texture[0][2][1]);
        sprite[0][2][5] = new Sprite(texture[0][2][2]);


        //ATACAR ESPADA ESQUERDA
        texture[1][2][0] = new Texture("inimigo/Slime/GosmaLAt01.png");
        texture[1][2][1] = new Texture("inimigo/Slime/GosmaLAt02.png");
        texture[1][2][2] = new Texture("inimigo/Slime/GosmaLAt03.png");


        sprite[1][2][0] = new Sprite(texture[1][2][0]);
        sprite[1][2][1] = new Sprite(texture[1][2][1]);
        sprite[1][2][2] = new Sprite(texture[1][2][2]);
        sprite[1][2][3] = new Sprite(texture[1][2][0]);
        sprite[1][2][4] = new Sprite(texture[1][2][1]);
        sprite[1][2][5] = new Sprite(texture[1][2][2]);


        sprite[1][2][0].flip(true, false);
        sprite[1][2][1].flip(true, false);
        sprite[1][2][2].flip(true, false);
        sprite[1][2][3].flip(true, false);
        sprite[1][2][4].flip(true, false);
        sprite[1][2][5].flip(true, false);


        //ATACAR ESPADA CIMA

        texture[2][2][0] = new Texture("inimigo/Slime/GosmaFAt01.png");
        texture[2][2][1] = new Texture("inimigo/Slime/GosmaF_e_CAt02.png");
        texture[2][2][2] = new Texture("inimigo/Slime/GosmaF_e_CAt03.png");


        sprite[2][2][0] = new Sprite(texture[2][2][0]);
        sprite[2][2][1] = new Sprite(texture[2][2][1]);
        sprite[2][2][2] = new Sprite(texture[2][2][2]);
        sprite[2][2][3] = new Sprite(texture[2][2][0]);
        sprite[2][2][4] = new Sprite(texture[2][2][1]);
        sprite[2][2][5] = new Sprite(texture[2][2][2]);

        //ATACAR ESPADA DIREITA
        texture[3][2][0] = new Texture("inimigo/Slime/GosmaLAt01.png");
        texture[3][2][1] = new Texture("inimigo/Slime/GosmaLAt02.png");
        texture[3][2][2] = new Texture("inimigo/Slime/GosmaLAt03.png");


        sprite[3][2][0] = new Sprite(texture[3][2][0]);
        sprite[3][2][1] = new Sprite(texture[3][2][1]);
        sprite[3][2][2] = new Sprite(texture[3][2][2]);
        sprite[3][2][3] = new Sprite(texture[3][2][0]);
        sprite[3][2][4] = new Sprite(texture[3][2][1]);
        sprite[3][2][5] = new Sprite(texture[3][2][2]);

    }

    public void carregarDano() {
        //DANO BAIXO
        texture[0][4][0] = new Texture("inimigo/Slime/GosmaCDa01.png");
        sprite[0][4][0] = new Sprite(texture[0][4][0]);

        //DANO ESQUERDO

        texture[1][4][0] = new Texture("inimigo/Slime/GosmaLDa01.png");
        sprite[1][4][0] = new Sprite(texture[1][4][0]);
        sprite[1][4][0].flip(true, false);

        //DANO COSTAS

        texture[2][4][0] = new Texture("inimigo/Slime/GosmaFDa01.png");
        sprite[2][4][0] = new Sprite(texture[2][4][0]);

        //DANO DIREITA

        texture[3][4][0] = new Texture("inimigo/Slime/GosmaLDa01.png");
        sprite[3][4][0] = new Sprite(texture[3][4][0]);
    }

    public void carregarMorte() {

        //MORTE BAIXO
        texture[0][4][0] = new Texture("inimigo/Slime/GosmaMo01.png");
        texture[0][4][1] = new Texture("inimigo/Slime/GosmaMo02.png");
        texture[0][4][2] = new Texture("inimigo/Slime/GosmaMo03.png");
        texture[0][4][3] = new Texture("inimigo/Slime/GosmaMo04.png");

        sprite[0][4][0] = new Sprite(texture[0][4][0]);
        sprite[0][4][1] = new Sprite(texture[0][4][1]);
        sprite[0][4][2] = new Sprite(texture[0][4][2]);
        sprite[0][4][3] = new Sprite(texture[0][4][3]);

    }
}




