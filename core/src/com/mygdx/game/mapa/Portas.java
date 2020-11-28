package com.mygdx.game.mapa;
import static com.mygdx.game.MyGdxGame2.fundoatual;
import com.badlogic.gdx.math.Rectangle;
import    com.mygdx.game.unidade.Jogador;
import static com.mygdx.game.CameraView.DefinirLimites;
import static com.mygdx.game.MyGdxGame2.mapas;

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

    public void conferindoInteracao(Jogador jogador){
        if(colisao.overlaps(jogador.hitboxMapa)){
            trocarMapa(jogador);
        }
    }

    //INFORMA QUAL MAPA X,Y ATUALIZA HITBOX E CHAMA O METODO PARA TRAVAR A CAMERA COM O NOVO MAPA
    public void trocarMapa(Jogador jogador){
        fundoatual=novoMapaAtual;

        jogador.x=novoX;
        jogador.y=novoY;
        jogador.AtualizaRetangulos();
//        escolherDefinirLimites(novoMapaAtual);
        DefinirLimites(mapas[fundoatual].spriteLocal, mapas[fundoatual].posicaoSprite);


    }



}
