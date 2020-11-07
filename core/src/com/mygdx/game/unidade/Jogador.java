package com.mygdx.game.unidade;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Jogador extends Unidade {
    Texture texture[][][];
    Sprite sprite[][][];
    public  Unidade player;









    @Override
    public void iniciar() {
        //INICIALIZANDO OS ARRAYS

        texture=new Texture[4][][];
        texture[0]=new Texture[5][];
        texture[1]=new Texture[5][];
        texture[2]=new Texture[5][];
        texture[3]=new Texture[5][];

        texture[0][0]=new Texture[1];
        texture[0][1]=new Texture[4];
        texture[0][2]=new Texture[3];
        texture[0][3]=new Texture[2];
        texture[0][4]=new Texture[2];

        texture[1][0]=new Texture[1];
        texture[1][1]=new Texture[4];
        texture[1][2]=new Texture[3];
        texture[1][3]=new Texture[2];
        texture[1][4]=new Texture[2];

        texture[2][0]=new Texture[1];
        texture[2][1]=new Texture[4];
        texture[2][2]=new Texture[3];
        texture[2][3]=new Texture[2];
        texture[2][4]=new Texture[2];

        texture[3][0]=new Texture[1];
        texture[3][1]=new Texture[4];
        texture[3][2]=new Texture[3];
        texture[3][3]=new Texture[2];
        texture[3][4]=new Texture[2];
        
        sprite=new Sprite[4][][];
        sprite[0]=new Sprite[5][];
        sprite[1]=new Sprite[5][];
        sprite[2]=new Sprite[5][];
        sprite[3]=new Sprite[5][];


        sprite[0][0]=new Sprite[1];
        sprite[0][1]=new Sprite[4];
        sprite[0][2]=new Sprite[3];
        sprite[0][3]=new Sprite[2];
        sprite[0][4]=new Sprite[2];

        sprite[1][0]=new Sprite[1];
        sprite[1][1]=new Sprite[4];
        sprite[1][2]=new Sprite[3];
        sprite[1][3]=new Sprite[2];
        sprite[1][4]=new Sprite[2];

        sprite[2][0]=new Sprite[1];
        sprite[2][1]=new Sprite[4];
        sprite[2][2]=new Sprite[3];
        sprite[2][3]=new Sprite[2];
        sprite[2][4]=new Sprite[2];

        sprite[3][0]=new Sprite[1];
        sprite[3][1]=new Sprite[4];
        sprite[3][2]=new Sprite[3];
        sprite[3][3]=new Sprite[2];
        sprite[3][4]=new Sprite[2];


        //CARREGANDO AS IMAGENS

        //ANDAR BAIXO

        texture[0][1][0]=new Texture("player/severinoFI.png");
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
