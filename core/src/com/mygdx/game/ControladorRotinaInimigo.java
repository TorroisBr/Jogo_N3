package com.mygdx.game;

public class ControladorRotinaInimigo {

    //Pega a direção em que o inimigo está se movendo...
    //public int direcaoAntes;

    //E muda para a próxima
    //public int direcaoDepois;


    public void trocarDirecao(/*String inimigo, */int direcaoAntes, int direcaoDepois){
        direcaoAntes = direcaoDepois;
    }
}