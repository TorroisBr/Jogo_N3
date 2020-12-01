package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.item.Espada;

import static com.mygdx.game.CameraView.Desenhar;
import static com.mygdx.game.MyGdxGame2.*;
import static com.mygdx.game.MyGdxGame2.fundoatual;

public class Ladrao extends Inimigo {
    public Texture[][][] texture;
    public Sprite[][][] sprite;
    public float tempoAtaque = 0;


    public Espada espada = new Espada("FROSTMOURNE", 0, 0, 3, 10, 320);

    public Ladrao(int x, int y, int direcao, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt,int velo) {
        this.hitboxDano = new Rectangle(x, y, HitBoxDanoLarg, HitBoxDanoAlt);
        this.hitboxMapa = new Rectangle(x, y, HitBoxMapaLarg, HitBoxMapaAlt);
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.vida = 30;
        this.velo = velo;
        this.estado = 0;
        this.visivel = true;
    }

    public void AtualizarHitboxEspada(int x, int y, float larg, float alt, boolean ativo) {
        //FRAME ATIVO DA ESPADA RECALCULA ONDE ESTA A HITBOX SE FOR FALSO CRIA UM RETANGULO VAZIO
        if (!ativo) {
            espada.hitbox.x = 0;
            espada.hitbox.y = 0;
            espada.hitbox.width = 0;
            espada.hitbox.height = 0;
        }

        if (ativo) {
            espada.hitbox.x = hitboxDano.x + x;
            espada.hitbox.y = hitboxDano.y + y;
            espada.hitbox.width = hitboxDano.getWidth() + larg;
            espada.hitbox.height = hitboxDano.getHeight() + alt;


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
            animar(true, 0.1F);
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


        if (Math.sqrt(((distanciaX * distanciaX) + (distanciaY * distanciaY))) < (R + JR + 80.0F)) {
            estado = 1;
            currentFrame = 0;
            animAtual = 2;
            tempo = 0;

            switch ((int) (Math.random() * 2))
            {
                case 0:
                    soundController.tocarSom(4);
                    break;

                case 1:
                    soundController.tocarSom(5);
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

    public void ColisaoPlayer() {
        if (espada.hitbox.overlaps(jogador.hitboxMapa) && jogador.estado != 3 && jogador.estado != -1 && jogador.invencibilidade <= 0) {
            jogador.tempo = 0;
            //SO PERMITE QUE ACERTE O JOGADOR EM UM FRAME
            jogador.estado = 3;
            jogador.tomarDano(espada.dano);
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


    @Override
    public void Andar() {
        AtualizaRetangulos();
        Seguir();
        Move(mapas[fundoatual].colisoes);
        DanoEspada();

        if (tempoAtaque < 2)
            tempoAtaque += Gdx.graphics.getDeltaTime();
        else
            ConferirAtaque();


    }

    @Override
    public void Atacar() {
        switch (direcao) {
            //DEPENDENDO DA DIREÇÂO ELE PASSA VARIAVES PRA SER SOMADA E ALTERAR A HITBOX DA ESPADA
            case 0:
                AtualizarHitboxEspada(-15, 0, +50, -65, true);
                break;
            case 1:
                AtualizarHitboxEspada(-50, 0, 0, -10, true);
                break;
            case 2:
                AtualizarHitboxEspada(-30, 80, +50, -65, true);
                break;
            case 3:
                AtualizarHitboxEspada(+50, 0, 0, -10, true);
                break;
        }
        if ((int) currentFrame != 1 && (int) currentFrame != 2)
            AtualizarHitboxEspada(0, 0, 0, 0, false);

        ColisaoPlayer();
        if (currentFrame < 2) {
            animar(false, 0.20F);

        } else if (tempo < 0) {
            tempo += Gdx.graphics.getDeltaTime();


        } else if ((int) currentFrame < sprite[direcao][animAtual].length - 1) {
            animar(false, 0.20F);

        } else {
            tempoAtaque = 0;
            currentFrame = 0;
            estado = 0;
            animAtual = 1;
        }
        tempo = 0;
    }

    @Override
    public void Draw() {
        if (estado != 1)
            AtualizarHitboxEspada(0, 0, 0, 0, false);
        Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getWidth() / 2, y + (int) hitboxDano.getHeight() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getHeight() / 2, sprite[direcao][animAtual][(int) currentFrame], batch, camera);

    }

    @Override
    public void morrendo() {
        if (tempo < 2) {
            tempo += Gdx.graphics.getDeltaTime();
        }
        else if (tempo < 4)
        {
            tempo += Gdx.graphics.getDeltaTime();
            if ((int) (tempo * 100) % 2 == 0) {
                visivel = !visivel;
            }
        } else
            estado = -2;
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
        texture[0][1] = new Texture[4];
        texture[0][2] = new Texture[6];
        texture[0][3] = new Texture[2];
        texture[0][4] = new Texture[2];
        texture[0][5] = new Texture[2];

        texture[1][0] = new Texture[1];
        texture[1][1] = new Texture[4];
        texture[1][2] = new Texture[6];
        texture[1][3] = new Texture[2];
        texture[1][4] = new Texture[2];
        texture[1][5] = new Texture[2];

        texture[2][0] = new Texture[1];
        texture[2][1] = new Texture[4];
        texture[2][2] = new Texture[6];
        texture[2][3] = new Texture[1];
        texture[2][4] = new Texture[2];
        texture[2][5] = new Texture[2];

        texture[3][0] = new Texture[1];
        texture[3][1] = new Texture[4];
        texture[3][2] = new Texture[6];
        texture[3][3] = new Texture[2];
        texture[3][4] = new Texture[2];
        texture[3][5] = new Texture[2];


        sprite = new Sprite[4][][];
        sprite[0] = new Sprite[5][];
        sprite[1] = new Sprite[5][];
        sprite[2] = new Sprite[5][];
        sprite[3] = new Sprite[5][];


        sprite[0][0] = new Sprite[1];
        sprite[0][1] = new Sprite[4];
        sprite[0][2] = new Sprite[6];
        sprite[0][3] = new Sprite[1];
        sprite[0][4] = new Sprite[1];

        sprite[1][0] = new Sprite[1];
        sprite[1][1] = new Sprite[4];
        sprite[1][2] = new Sprite[6];
        sprite[1][3] = new Sprite[1];
        sprite[1][4] = new Sprite[1];

        sprite[2][0] = new Sprite[1];
        sprite[2][1] = new Sprite[4];
        sprite[2][2] = new Sprite[6];
        sprite[2][3] = new Sprite[1];
        sprite[2][4] = new Sprite[1];

        sprite[3][0] = new Sprite[1];
        sprite[3][1] = new Sprite[4];
        sprite[3][2] = new Sprite[6];
        sprite[3][3] = new Sprite[1];
        sprite[3][4] = new Sprite[1];


        //CARREGANDO AS IMAGENS

        carregarIdle();
        carregarAndar();
        carregarEspada();
        carregarDano();
        carregarMorte();

    }
    //IMPORTA OS SPRITES DE MOVIMENTAMENTO

    public void carregarIdle() {
        //IDLE BAIXO

        texture[0][0][0] = new Texture("inimigo/Ladrao/Ladrao_FI.png");
        sprite[0][0][0] = new Sprite(texture[0][0][0]);

        //IDLE ESQUERDO

        texture[1][0][0] = new Texture("inimigo/Ladrao/Ladrao_LI.png");
        sprite[1][0][0] = new Sprite(texture[1][0][0]);
        sprite[1][0][0].flip(true, false);

        //IDLE CIMA

        texture[2][0][0] = new Texture("inimigo/Ladrao/Ladrao_CI.png");
        sprite[2][0][0] = new Sprite(texture[2][0][0]);

        //IDLE DIREITA

        texture[3][0][0] = new Texture("inimigo/Ladrao/Ladrao_LI.png");
        sprite[3][0][0] = new Sprite(texture[3][0][0]);
    }

    public void carregarAndar() {
        //ANDAR BAIXO

        texture[0][1][0] = new Texture("inimigo/Ladrao/Ladrao_FI.png");
        texture[0][1][1] = new Texture("inimigo/Ladrao/Ladrao_FA01.png");
        texture[0][1][2] = new Texture("inimigo/Ladrao/Ladrao_FA02.png");

        sprite[0][1][0] = new Sprite(texture[0][1][0]);
        sprite[0][1][1] = new Sprite(texture[0][1][1]);
        sprite[0][1][2] = new Sprite(texture[0][1][0]);
        sprite[0][1][3] = new Sprite(texture[0][1][2]);

        //ANDAR ESQUERDA
        texture[1][1][0] = new Texture("inimigo/Ladrao/Ladrao_LI.png");
        texture[1][1][1] = new Texture("inimigo/Ladrao/Ladrao_LA01.png");
        texture[1][1][2] = new Texture("inimigo/Ladrao/Ladrao_LA02.png");

        sprite[1][1][0] = new Sprite(texture[1][1][0]);
        sprite[1][1][1] = new Sprite(texture[1][1][1]);
        sprite[1][1][2] = new Sprite(texture[1][1][0]);
        sprite[1][1][3] = new Sprite(texture[1][1][2]);

        sprite[1][1][0].flip(true, false);
        sprite[1][1][1].flip(true, false);
        sprite[1][1][2].flip(true, false);
        sprite[1][1][3].flip(true, false);

        //ANDAR CIMA
        texture[2][1][0] = new Texture("inimigo/Ladrao/Ladrao_CI.png");
        texture[2][1][1] = new Texture("inimigo/Ladrao/Ladrao_CA01.png");
        texture[2][1][2] = new Texture("inimigo/Ladrao/Ladrao_CA02.png");

        sprite[2][1][0] = new Sprite(texture[2][1][0]);
        sprite[2][1][1] = new Sprite(texture[2][1][1]);
        sprite[2][1][2] = new Sprite(texture[2][1][0]);
        sprite[2][1][3] = new Sprite(texture[2][1][2]);

        //ANDAR DIREITA
        texture[3][1][0] = new Texture("inimigo/Ladrao/Ladrao_LI.png");
        texture[3][1][1] = new Texture("inimigo/Ladrao/Ladrao_LA01.png");
        texture[3][1][2] = new Texture("inimigo/Ladrao/Ladrao_LA02.png");

        sprite[3][1][0] = new Sprite(texture[3][1][0]);
        sprite[3][1][1] = new Sprite(texture[3][1][1]);
        sprite[3][1][2] = new Sprite(texture[3][1][0]);
        sprite[3][1][3] = new Sprite(texture[3][1][2]);
    }

    public void carregarEspada() {
        //ATACAR ESPADA BAIXO

        texture[0][2][0] = new Texture("inimigo/Ladrao/Ladrao_FAt01.png");
        texture[0][2][1] = new Texture("inimigo/Ladrao/Ladrao_FAt02.png");
        texture[0][2][2] = new Texture("inimigo/Ladrao/Ladrao_FAt03.png");
        texture[0][2][3] = new Texture("inimigo/Ladrao/Ladrao_FAt04.png");
        texture[0][2][4] = new Texture("inimigo/Ladrao/Ladrao_FAt05.png");
        texture[0][2][5] = new Texture("inimigo/Ladrao/Ladrao_FAt06.png");

        sprite[0][2][0] = new Sprite(texture[0][2][0]);
        sprite[0][2][1] = new Sprite(texture[0][2][1]);
        sprite[0][2][2] = new Sprite(texture[0][2][2]);
        sprite[0][2][3] = new Sprite(texture[0][2][3]);
        sprite[0][2][4] = new Sprite(texture[0][2][4]);
        sprite[0][2][5] = new Sprite(texture[0][2][5]);


        //ATACAR ESPADA ESQUERDA
        texture[1][2][0] = new Texture("inimigo/Ladrao/Ladrao_LAt01.png");
        texture[1][2][1] = new Texture("inimigo/Ladrao/Ladrao_LAt02.png");
        texture[1][2][2] = new Texture("inimigo/Ladrao/Ladrao_LAt03.png");
        texture[1][2][3] = new Texture("inimigo/Ladrao/Ladrao_LAt04.png");
        texture[1][2][4] = new Texture("inimigo/Ladrao/Ladrao_LAt05.png");
        texture[1][2][5] = new Texture("inimigo/Ladrao/Ladrao_LAt06.png");


        sprite[1][2][0] = new Sprite(texture[1][2][0]);
        sprite[1][2][1] = new Sprite(texture[1][2][1]);
        sprite[1][2][2] = new Sprite(texture[1][2][2]);
        sprite[1][2][3] = new Sprite(texture[1][2][3]);
        sprite[1][2][4] = new Sprite(texture[1][2][4]);
        sprite[1][2][5] = new Sprite(texture[1][2][5]);

        sprite[1][2][0].flip(true, false);
        sprite[1][2][1].flip(true, false);
        sprite[1][2][2].flip(true, false);
        sprite[1][2][3].flip(true, false);
        sprite[1][2][4].flip(true, false);
        sprite[1][2][5].flip(true, false);

        //ATACAR ESPADA CIMA

        texture[2][2][0] = new Texture("inimigo/Ladrao/Ladrao_CAt01.png");
        texture[2][2][1] = new Texture("inimigo/Ladrao/Ladrao_CAt02.png");
        texture[2][2][2] = new Texture("inimigo/Ladrao/Ladrao_CAt03.png");
        texture[2][2][3] = new Texture("inimigo/Ladrao/Ladrao_CAt04.png");
        texture[2][2][4] = new Texture("inimigo/Ladrao/Ladrao_CAt05.png");
        texture[2][2][5] = new Texture("inimigo/Ladrao/Ladrao_CAt06.png");

        sprite[2][2][0] = new Sprite(texture[2][2][0]);
        sprite[2][2][1] = new Sprite(texture[2][2][1]);
        sprite[2][2][2] = new Sprite(texture[2][2][2]);
        sprite[2][2][3] = new Sprite(texture[2][2][3]);
        sprite[2][2][4] = new Sprite(texture[2][2][4]);
        sprite[2][2][5] = new Sprite(texture[2][2][5]);

        //ATACAR ESPADA DIREITA
        texture[3][2][0] = new Texture("inimigo/Ladrao/Ladrao_LAt01.png");
        texture[3][2][1] = new Texture("inimigo/Ladrao/Ladrao_LAt02.png");
        texture[3][2][2] = new Texture("inimigo/Ladrao/Ladrao_LAt02.png");
        texture[3][2][3] = new Texture("inimigo/Ladrao/Ladrao_LAt03.png");
        texture[3][2][4] = new Texture("inimigo/Ladrao/Ladrao_LAt04.png");
        texture[3][2][5] = new Texture("inimigo/Ladrao/Ladrao_LAt05.png");

        sprite[3][2][0] = new Sprite(texture[3][2][0]);
        sprite[3][2][1] = new Sprite(texture[3][2][1]);
        sprite[3][2][2] = new Sprite(texture[3][2][2]);
        sprite[3][2][3] = new Sprite(texture[3][2][3]);
        sprite[3][2][4] = new Sprite(texture[3][2][4]);
        sprite[3][2][5] = new Sprite(texture[3][2][5]);

    }

    public void carregarDano() {
        //DANO BAIXO
        texture[0][3][0] = new Texture("inimigo/Ladrao/Ladrao_FDa01.png");
        sprite[0][3][0] = new Sprite(texture[0][3][0]);

        //DANO ESQUERDO

        texture[1][3][0] = new Texture("inimigo/Ladrao/Ladrao_LDa01.png");
        sprite[1][3][0] = new Sprite(texture[1][3][0]);

        sprite[1][3][0].flip(true, false);

        //DANO COSTAS

        texture[2][3][0] = new Texture("inimigo/Ladrao/Ladrao_CDa01.png");
        sprite[2][3][0] = new Sprite(texture[2][3][0]);

        //DANO DIREITA

        texture[3][3][0] = new Texture("inimigo/Ladrao/Ladrao_LDa01.png");
        sprite[3][3][0] = new Sprite(texture[3][3][0]);
    }

    public void carregarMorte() {

        //MORTE BAIXO
        texture[0][4][0] = new Texture("inimigo/Ladrao/Ladrao_FMo01.png");
        sprite[0][4][0] = new Sprite(texture[0][4][0]);

        //MORTE ESQUERDO

        texture[1][4][0] = new Texture("inimigo/Ladrao/Ladrao_LMo01.png");
        sprite[1][4][0] = new Sprite(texture[1][4][0]);

        sprite[1][4][0].flip(true, false);

        //MORTE COSTAS

        texture[2][4][0] = new Texture("inimigo/Ladrao/Ladrao_CMo01.png");
        sprite[2][4][0] = new Sprite(texture[2][4][0]);

        //MORTE DIREITA

        texture[3][4][0] = new Texture("inimigo/Ladrao/Ladrao_LMo01.png");
        sprite[3][4][0] = new Sprite(texture[3][4][0]);
    }
}
