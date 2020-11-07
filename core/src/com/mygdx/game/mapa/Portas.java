package com.mygdx.game.mapa;
import static com.mygdx.game.MyGdxGame2.fundoatual;
import com.badlogic.gdx.math.Rectangle;
import static   com.mygdx.game.CameraView.*;
import static   com.mygdx.game.MyGdxGame2.jogador;
import static com.mygdx.game.CameraView.escolherDefinirLimites;

//OBJETO DE PORTA PARA TROCAR O MAPA

public class Portas {
    public Rectangle colisao;
    int novoMapaAtual,novoX,novoY;
    public Portas(int x,int y, int larg, int alt,int novoMapaAtual,int novoX,int novoY) {
        colisao=new Rectangle(x,y,larg,alt);
        this.novoMapaAtual=novoMapaAtual;
        this.novoX=novoX;
        this.novoY=novoY;
    }
    //CONFERE COLISÂO PLAYER COM A PORTA

    public void conferindoInteracao(Rectangle rectangle){
        if(colisao.overlaps(rectangle)){
            trocarMapa();
        }
    }

    //INFORMA QUAL MAPA X,Y ATUALIZA HITBOX E CHAMA O METODO PARA TRAVAR A CAMERA COM O NOVO MAPA
    public void trocarMapa(){
        fundoatual=novoMapaAtual;
        jogador.x=novoX;
        jogador.y=novoY;
        jogador.AtualizaRetangulos();
        escolherDefinirLimites(novoMapaAtual);

    }



}
