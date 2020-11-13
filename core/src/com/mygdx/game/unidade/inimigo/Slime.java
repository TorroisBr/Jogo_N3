package com.mygdx.game.unidade.inimigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.CameraView.Desenhar;
import static com.mygdx.game.MyGdxGame2.batch;
import static com.mygdx.game.MyGdxGame2.camera;
import static com.mygdx.game.MyGdxGame2.jogador;

public class Slime extends Inimigo {
    Texture texture[][][];
    public Sprite sprite[][][];
    public float currentFrame = 0;
    public int animAtual = 1;
    public int dano;
    public int andar = 0;
    public int movX, movY;


    public Slime(int x, int y, int direcao, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt) {
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.vida = 200;
        this.velo = 3;
        this.estado = 0;
        this.hitboxDano = new Rectangle(x, y, HitBoxDanoLarg, HitBoxDanoAlt);
        this.hitboxMapa = new Rectangle(x, y, HitBoxMapaLarg, HitBoxMapaAlt);
        this.dano = 5;

    }


    public void Draw() {
        Desenhar(x + (int) hitboxDano.getWidth() / 2 - (int) hitboxDano.getWidth() / 2, y - (int) hitboxDano.getHeight() / 2, sprite[direcao][animAtual][(int) currentFrame], batch, camera);
    }

    public void animar(Sprite[][][] array) {
        if (sprite != array) {
            sprite = array;
            currentFrame = 0;
        } else {
            currentFrame += Gdx.graphics.getRawDeltaTime() * 5;
            if ((int) currentFrame > sprite.length - 1) {
                currentFrame = 0;

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
        Seguir();
        Move();
        AtualizaRetangulos();
        animar(sprite);
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
        texture[0][1] = new Texture[4];
        texture[0][2] = new Texture[3];
        texture[0][3] = new Texture[2];
        texture[0][4] = new Texture[2];

        texture[1][0] = new Texture[1];
        texture[1][1] = new Texture[4];
        texture[1][2] = new Texture[3];
        texture[1][3] = new Texture[2];
        texture[1][4] = new Texture[2];

        texture[2][0] = new Texture[1];
        texture[2][1] = new Texture[4];
        texture[2][2] = new Texture[3];
        texture[2][3] = new Texture[2];
        texture[2][4] = new Texture[2];

        texture[3][0] = new Texture[1];
        texture[3][1] = new Texture[4];
        texture[3][2] = new Texture[3];
        texture[3][3] = new Texture[2];
        texture[3][4] = new Texture[2];

        sprite = new Sprite[4][][];
        sprite[0] = new Sprite[5][];
        sprite[1] = new Sprite[5][];
        sprite[2] = new Sprite[5][];
        sprite[3] = new Sprite[5][];


        sprite[0][0] = new Sprite[1];
        sprite[0][1] = new Sprite[4];
        sprite[0][2] = new Sprite[3];
        sprite[0][3] = new Sprite[2];
        sprite[0][4] = new Sprite[2];

        sprite[1][0] = new Sprite[1];
        sprite[1][1] = new Sprite[4];
        sprite[1][2] = new Sprite[3];
        sprite[1][3] = new Sprite[2];
        sprite[1][4] = new Sprite[2];

        sprite[2][0] = new Sprite[1];
        sprite[2][1] = new Sprite[4];
        sprite[2][2] = new Sprite[3];
        sprite[2][3] = new Sprite[2];
        sprite[2][4] = new Sprite[2];

        sprite[3][0] = new Sprite[1];
        sprite[3][1] = new Sprite[4];
        sprite[3][2] = new Sprite[3];
        sprite[3][3] = new Sprite[2];
        sprite[3][4] = new Sprite[2];


        //CARREGANDO AS IMAGENS
        carregarAndar();


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
}

