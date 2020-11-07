package com.mygdx.game.unidade;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Npc extends Unidade {
    Texture texture[][][];
    Sprite sprite[][][];
    public int direcao;
    public float movX = 0, movY = 0;
    Rectangle hitboxMapa;
    int HitBoxMapaLarg, HitBoxMapaAlt;

    //CONSTRUTOR
    public Npc(int x, int y, int direcao, Rectangle hitboxDano, int HitBoxDanoLarg, int HitBoxDanoAlt, int HitBoxMapaLarg, int HitBoxMapaAlt) {
        hitboxDano = new Rectangle(x, y, HitBoxDanoLarg * 1.25F, HitBoxDanoAlt * 1.25F);
        this.hitboxMapa = new Rectangle(x, y, HitBoxMapaLarg, HitBoxMapaAlt);
        this.x = x;
        this.y = y;
        this.direcao = direcao;

        this.HitBoxMapaLarg = HitBoxMapaLarg;
        this.HitBoxMapaAlt = HitBoxMapaAlt;

    }

    //MOVIMENTA O JOGADOR
    public void Movimento() {

    }

    //DIALOGO
    public void Falar() {

    }

    //CAMINIHO DO NPC
    public void Rotina(){

    }

    public void ChamarMissao(){
        //WHATEVER
    }

    //VERIFICAR SE O PLAYER ESTA INTERAGINDO
    public void checarInteracao() {
        //if(hitboxMapa.overlaps(jogador.hitboxMapa && APERTAR A TECLA))
        Falar();
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

    //IMPORTA OS SPRITES DE MOVIMENTAMENTO
    public void carregarAndar() {
        //ANDAR BAIXO

        texture[0][1][0] = new Texture("player/severinoFI.png");
        texture[0][1][1] = new Texture("player/severinoFA01.png");
        texture[0][1][2] = new Texture("player/severinoFA02.png");

        sprite[0][1][0] = new Sprite(texture[0][1][0]);
        sprite[0][1][1] = new Sprite(texture[0][1][1]);
        sprite[0][1][2] = new Sprite(texture[0][1][2]);

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
        sprite[2][1][2] = new Sprite(texture[2][1][2]);

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
