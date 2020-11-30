package com.mygdx.game.unidade;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.item.Arco;
import com.mygdx.game.item.Espada;
import com.mygdx.game.MyGdxGame2.*;

import static com.mygdx.game.CameraView.Desenhar;
import static com.mygdx.game.MyGdxGame2.*;

public class Jogador extends Unidade {
    public Texture texture[][][];
    public Sprite sprite[][][];
    public int vida,
               vidaMax;
    public int direcao;
    public int velo;
    public float movX = 0, movY = 0;
    public Rectangle hitboxMapa;
    public float currentFrame = 0;
    public int animAtual = 1;
    public int estado;
    public float arcocdr = 10;
    public float tempo = 0;
    public boolean teclaEspadaApertada = false;
    public float invencibilidade = 0;


    //CRIANDO ESPADA
    public Espada espada = new Espada("FROSTMOURNE", 0, 0, 10, 10, 320);
    public Arco arco = new Arco("Ak-47", 0, 0, 0);


    //CONSTRUTOR
    public Jogador(int x, int y, int direcao, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt, int estado) {
        this.hitboxDano = new Rectangle(x, y, HitBoxDanoLarg, HitBoxDanoAlt);
        this.hitboxMapa = new Rectangle(x, y, HitBoxMapaLarg, HitBoxMapaAlt);
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.vidaMax = 12;
        this.vida = vidaMax;
        this.velo = 5;
        this.estado = 0;
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
            espada.hitbox.x = jogador.hitboxDano.x + x;
            espada.hitbox.y = jogador.hitboxDano.y + y;
            espada.hitbox.width = jogador.hitboxDano.getWidth() + larg;
            espada.hitbox.height = jogador.hitboxDano.getHeight() + alt;


        }

    }


    //RECEBE DANO
    public void tomarDano(int dano) {
        vida -= dano;
    }

    public void levandoDano() {
        tempo += Gdx.graphics.getDeltaTime();
        if (tempo <= 0.5) {
            switch (direcao) {
                //VERIFICA A DIRECAO DO INIMIGO E CAUSA UMA REPULSAO

                case 0:
                    movY = (int) ((float) 340 * Gdx.graphics.getDeltaTime());
                    break;
                case 1:
                    movX = (int) ((float) 340 * Gdx.graphics.getDeltaTime());
                    break;
                case 2:
                    movY = -(int) ((float) 340 * Gdx.graphics.getDeltaTime());
                    break;
                case 3:
                    movX = -(int) ((float) 340 * Gdx.graphics.getDeltaTime());
                    break;
            }
            Movimento(mapas[fundoatual].colisoes);
        }
        //SE O TEMPO FOR SUPERIOR A 3 FRAMES RESETA ELE
        else {
            if (vida > 0) {
                invencibilidade = 1.5F;
                currentFrame = 0;
                estado = 0;
                animAtual = 0;
            } else {
                currentFrame = 0;
                tempo = 0;
                estado = -1;
                animAtual = 5;
            }

        }
    }

    public void morrendo() {
        if (tempo < 2) {
            tempo += Gdx.graphics.getDeltaTime();
        }
        else if (tempo < 4)
        {
            tempo += Gdx.graphics.getDeltaTime();
            if ((int) (tempo * 100) % 2 == 0) {
                if (visivel)
                    visivel = false;
                else
                    visivel = true;
            }
        } else if(tempo < 6)
        {
            tempo += Gdx.graphics.getDeltaTime();
            visivel = false;
        }
        else
            System.exit(0);

    }


    //input movimento
    public void input() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.L))
            fundoatual=11;
        if (invencibilidade > 0) {
            invencibilidade -= Gdx.graphics.getDeltaTime();
            if ((int) (invencibilidade * 100) % 2 == 0) {

                if (visivel)
                    visivel = false;
                else
                    visivel = true;

            }
        } else if (!visivel && estado != -1)
            visivel = true;


        if (estado != 1 && estado != 2 && estado != 3 && estado != -1) {
            //ATAQUE
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !teclaEspadaApertada) {
                teclaEspadaApertada = true;
                Espadada();
            }
        }


        if (estado != 1 && estado != 2 && estado != 3 && estado != -1) {
            //ATAQUE
            if (Gdx.input.isKeyPressed(Input.Keys.C) && !teclaEspadaApertada) {
                teclaEspadaApertada = true;
                Arcada();
            }
        }


        if (estado != 1 && estado != 2 && estado != 3 && estado != -1) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                movX = -velo;


            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                movX = velo;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                movY = velo;

            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                movY = -velo;
            }


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
        }

        if (estado != 1 && estado != 2 && estado != 3 && estado != -1) {
            if (!Gdx.input.isKeyPressed(Input.Keys.DOWN) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.UP)) {
                if (animAtual != 0) {
                    animAtual = 0;
                    currentFrame = 0;
                }
            }
        }
        if (estado != 1 && estado != 2 && estado != 3 && estado != -1) {
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
                if (animAtual != 1) {
                    animAtual = 1;
                    currentFrame = 1;
                }

            }
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            teclaEspadaApertada = false;
        }
    }


    //MOVIMENTA O JOGADOR
    public void Movimento(Rectangle retangulo[]) {
        if (movX != 0) {
            x += movX;
            AtualizaRetangulos();
            while (ColisaoComCenario(retangulo)) {
                if (movX > 0)
                    x--;
                else
                    x++;
                AtualizaRetangulos();
            }
            movX = 0;
        }
        if (movY != 0) {
            y += movY;
            AtualizaRetangulos();
            while (ColisaoComCenario(retangulo)) {
                if (movY > 0)
                    y--;
                else
                    y++;
                AtualizaRetangulos();
            }
            movY = 0;
        }


    }

    public boolean ColisaoComCenario(Rectangle rectangles[]) {
        for (Rectangle retangulo : rectangles) {
            if (hitboxMapa.overlaps(retangulo))
                return true;
        }
        return false;
    }

    public void AtualizaRetangulos() {
        hitboxDano.set(x, y, hitboxDano.width, hitboxDano.height);
        hitboxMapa.set(x, y, hitboxMapa.width, hitboxMapa.height);
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

    public void Draw() {
        Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getWidth() / 2, y + (int) hitboxDano.getHeight() / 2 - (int) sprite[direcao][animAtual][(int) currentFrame].getHeight() / 2, sprite[direcao][animAtual][(int) currentFrame], batch, camera);
    }

    public void Atacando() {
        if (currentFrame < sprite[direcao][animAtual].length - 1) {
            animar(false, 0.25F);
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
        } else {
            estado = 0;
            currentFrame = 0;
            animAtual = 0;
        }

    }

    public void Espadada() {
        estado = 1;
        currentFrame = 0;
        animAtual = 2;

    }

    public void Arcada() {


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
        sprite[0] = new Sprite[6][];
        sprite[1] = new Sprite[6][];
        sprite[2] = new Sprite[6][];
        sprite[3] = new Sprite[6][];


        sprite[0][0] = new Sprite[1];
        sprite[0][1] = new Sprite[4];
        sprite[0][2] = new Sprite[6];
        sprite[0][3] = new Sprite[2];
        sprite[0][4] = new Sprite[2];
        sprite[0][5] = new Sprite[2];

        sprite[1][0] = new Sprite[1];
        sprite[1][1] = new Sprite[4];
        sprite[1][2] = new Sprite[6];
        sprite[1][3] = new Sprite[2];
        sprite[1][4] = new Sprite[2];
        sprite[1][5] = new Sprite[2];

        sprite[2][0] = new Sprite[1];
        sprite[2][1] = new Sprite[4];
        sprite[2][2] = new Sprite[6];
        sprite[2][3] = new Sprite[1];
        sprite[2][4] = new Sprite[2];
        sprite[2][5] = new Sprite[2];

        sprite[3][0] = new Sprite[1];
        sprite[3][1] = new Sprite[4];
        sprite[3][2] = new Sprite[6];
        sprite[3][3] = new Sprite[2];
        sprite[3][4] = new Sprite[2];
        sprite[3][5] = new Sprite[2];


        //CARREGANDO AS IMAGENS

        carregarIdle();
        carregarAndar();
        carregarEspada();
        carregarArco();
        carregarDano();
        carregarMorte();

    }
    //IMPORTA OS SPRITES DE MOVIMENTAMENTO

    public void carregarIdle() {
        //IDLE BAIXO

        texture[0][0][0] = new Texture("player/severinoFI.png");
        sprite[0][0][0] = new Sprite(texture[0][0][0]);

        //IDLE ESQUERDO

        texture[1][0][0] = new Texture("player/severinoLI.png");
        sprite[1][0][0] = new Sprite(texture[1][0][0]);
        sprite[1][0][0].flip(true, false);

        //IDLE CIMA

        texture[2][0][0] = new Texture("player/severinoCI.png");
        sprite[2][0][0] = new Sprite(texture[2][0][0]);

        //IDLE DIREITA

        texture[3][0][0] = new Texture("player/severinoLI.png");
        sprite[3][0][0] = new Sprite(texture[3][0][0]);
    }

    public void carregarAndar() {
        //ANDAR BAIXO

        texture[0][1][0] = new Texture("player/severinoFI.png");
        texture[0][1][1] = new Texture("player/severinoFA01.png");
        texture[0][1][2] = new Texture("player/severinoFA02.png");

        sprite[0][1][0] = new Sprite(texture[0][1][0]);
        sprite[0][1][1] = new Sprite(texture[0][1][1]);
        sprite[0][1][2] = new Sprite(texture[0][1][0]);
        sprite[0][1][3] = new Sprite(texture[0][1][2]);

        //ANDAR ESQUERDA
        texture[1][1][0] = new Texture("player/severinoLI.png");
        texture[1][1][1] = new Texture("player/severinoLA01.png");
        texture[1][1][2] = new Texture("player/severinoLA02.png");

        sprite[1][1][0] = new Sprite(texture[1][1][0]);
        sprite[1][1][1] = new Sprite(texture[1][1][1]);
        sprite[1][1][2] = new Sprite(texture[1][1][0]);
        sprite[1][1][3] = new Sprite(texture[1][1][2]);

        sprite[1][1][0].flip(true, false);
        sprite[1][1][1].flip(true, false);
        sprite[1][1][2].flip(true, false);
        sprite[1][1][3].flip(true, false);

        //ANDAR CIMA
        texture[2][1][0] = new Texture("player/severinoCI.png");
        texture[2][1][1] = new Texture("player/severinoCA01.png");
        texture[2][1][2] = new Texture("player/severinoCA02.png");

        sprite[2][1][0] = new Sprite(texture[2][1][0]);
        sprite[2][1][1] = new Sprite(texture[2][1][1]);
        sprite[2][1][2] = new Sprite(texture[2][1][0]);
        sprite[2][1][3] = new Sprite(texture[2][1][2]);

        //ANDAR DIREITA
        texture[3][1][0] = new Texture("player/severinoLI.png");
        texture[3][1][1] = new Texture("player/severinoLA01.png");
        texture[3][1][2] = new Texture("player/severinoLA02.png");

        sprite[3][1][0] = new Sprite(texture[3][1][0]);
        sprite[3][1][1] = new Sprite(texture[3][1][1]);
        sprite[3][1][2] = new Sprite(texture[3][1][0]);
        sprite[3][1][3] = new Sprite(texture[3][1][2]);
    }

    public void carregarEspada() {
        //ATACAR ESPADA BAIXO

        texture[0][2][0] = new Texture("player/severinoFAt01.png");
        texture[0][2][1] = new Texture("player/severinoFAt02.png");
        texture[0][2][2] = new Texture("player/severinoFAt03.png");
        texture[0][2][3] = new Texture("player/severinoFAt04.png");
        texture[0][2][4] = new Texture("player/severinoFAt05.png");
        texture[0][2][5] = new Texture("player/severinoFAt06.png");

        sprite[0][2][0] = new Sprite(texture[0][2][0]);
        sprite[0][2][1] = new Sprite(texture[0][2][1]);
        sprite[0][2][2] = new Sprite(texture[0][2][2]);
        sprite[0][2][3] = new Sprite(texture[0][2][3]);
        sprite[0][2][4] = new Sprite(texture[0][2][4]);
        sprite[0][2][5] = new Sprite(texture[0][2][5]);


        //ATACAR ESPADA ESQUERDA
        texture[1][2][0] = new Texture("player/severinoLAt01.png");
        texture[1][2][1] = new Texture("player/severinoLAt02.png");
        texture[1][2][2] = new Texture("player/severinoLAt03.png");
        texture[1][2][3] = new Texture("player/severinoLAt04.png");
        texture[1][2][4] = new Texture("player/severinoLAt05.png");
        texture[1][2][5] = new Texture("player/severinoLAt06.png");


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

        texture[2][2][0] = new Texture("player/severinoCAt01.png");
        texture[2][2][1] = new Texture("player/severinoCAt02.png");
        texture[2][2][2] = new Texture("player/severinoCAt03.png");
        texture[2][2][3] = new Texture("player/severinoCAt04.png");
        texture[2][2][4] = new Texture("player/severinoCAt05.png");
        texture[2][2][5] = new Texture("player/severinoCAt06.png");

        sprite[2][2][0] = new Sprite(texture[2][2][0]);
        sprite[2][2][1] = new Sprite(texture[2][2][1]);
        sprite[2][2][2] = new Sprite(texture[2][2][2]);
        sprite[2][2][3] = new Sprite(texture[2][2][3]);
        sprite[2][2][4] = new Sprite(texture[2][2][4]);
        sprite[2][2][5] = new Sprite(texture[2][2][5]);

        //ATACAR ESPADA DIREITA
        texture[3][2][0] = new Texture("player/severinoLAt01.png");
        texture[3][2][1] = new Texture("player/severinoLAt02.png");
        texture[3][2][2] = new Texture("player/severinoLAt02.png");
        texture[3][2][3] = new Texture("player/severinoLAt03.png");
        texture[3][2][4] = new Texture("player/severinoLAt04.png");
        texture[3][2][5] = new Texture("player/severinoLAt05.png");

        sprite[3][2][0] = new Sprite(texture[3][2][0]);
        sprite[3][2][1] = new Sprite(texture[3][2][1]);
        sprite[3][2][2] = new Sprite(texture[3][2][2]);
        sprite[3][2][3] = new Sprite(texture[3][2][3]);
        sprite[3][2][4] = new Sprite(texture[3][2][4]);
        sprite[3][2][5] = new Sprite(texture[3][2][5]);

    }

    public void carregarArco() {

        //ATACAR ARCO FRENTE

        texture[0][3][0] = new Texture("player/severinoFAr01.png");
        texture[0][3][1] = new Texture("player/severinoFAr02.png");

        sprite[0][3][0] = new Sprite(texture[0][3][0]);
        sprite[0][3][1] = new Sprite(texture[0][3][1]);

        //ATACAR ARCO LADO ESQUERDO

        texture[1][3][0] = new Texture("player/severinoLAr01.png");
        texture[1][3][1] = new Texture("player/severinoLAr02.png");

        sprite[1][3][0] = new Sprite(texture[1][3][0]);
        sprite[1][3][1] = new Sprite(texture[1][3][1]);

        sprite[1][3][0].flip(true, false);
        sprite[1][3][1].flip(true, false);

        //ATACAR ARCO COSTAS

        texture[2][3][0] = new Texture("player/severinoCAr01.png");

        sprite[2][3][0] = new Sprite(texture[2][3][0]);

        //ATACAR ARCO DIREITA

        texture[3][3][0] = new Texture("player/severinoLAr01.png");
        texture[3][3][1] = new Texture("player/severinoLAr02.png");

        sprite[3][3][0] = new Sprite(texture[3][3][0]);
        sprite[3][3][1] = new Sprite(texture[3][3][1]);

    }

    public void carregarDano() {
        //DANO BAIXO
        texture[0][4][0] = new Texture("player/severinoFDa01.png");
        sprite[0][4][0] = new Sprite(texture[0][4][0]);

        //DANO ESQUERDO

        texture[1][4][0] = new Texture("player/severinoLDa01.png");
        sprite[1][4][0] = new Sprite(texture[1][4][0]);

        sprite[1][4][0].flip(true, false);

        //DANO COSTAS

        texture[2][4][0] = new Texture("player/severinoCDa01.png");
        sprite[2][4][0] = new Sprite(texture[2][4][0]);

        //DANO DIREITA

        texture[3][4][0] = new Texture("player/severinoLDa01.png");
        sprite[3][4][0] = new Sprite(texture[3][4][0]);
    }

    public void carregarMorte() {

        //MORTE BAIXO
        texture[0][5][0] = new Texture("player/severinoFMo01.png");
        sprite[0][5][0] = new Sprite(texture[0][5][0]);

        //MORTE ESQUERDO

        texture[1][5][0] = new Texture("player/severinoLMo01.png");
        sprite[1][5][0] = new Sprite(texture[1][5][0]);

        sprite[1][5][0].flip(true, false);

        //MORTE COSTAS

        texture[2][5][0] = new Texture("player/severinoCMo01.png");
        sprite[2][5][0] = new Sprite(texture[2][5][0]);

        //MORTE DIREITA

        texture[3][5][0] = new Texture("player/severinoLMo01.png");
        sprite[3][5][0] = new Sprite(texture[3][5][0]);
    }
}
