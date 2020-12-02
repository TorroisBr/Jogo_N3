package com.mygdx.game.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import static com.mygdx.game.MyGdxGame2.*;


public class PontosController {
    public static int totalInimigosMortos;
    public static int ladraoMortos;
    public static int slimeMortos;
    public static int inimigosMortos;
    public static int quantidadeHits;
    public static int hitsAcertado;
    public static int trocasSalas;
    public static int pontosVida;
    public static int pontoVidaExtra = 0;
    public static int pontoExtras;
    public static int total = 0;
    public static float tempoPontuacao = 0;
    public static float tempoPontuacao2 = 0;
    public static int pontuacaoX = 50;
    public static int pontuacaoY = 550;
    public static int sonsTocados = 0;


    public static BitmapFont font;

    public static void exibir() {

        //Definir os pontos
        if(tempoPontuacao == 0)
        {
            inimigosMortos = slimeMortos + ladraoMortos;
            pontosVida = jogador.vida * 10;

            if(jogador.vida >= 12)
            {
                pontoVidaExtra = 120;
            }
            else
            {
                pontoVidaExtra = 0;
            }
            total = (slimeMortos * 10) + (ladraoMortos * 15) + (trocasSalas * -2) + pontoExtras + pontosVida + pontoVidaExtra;
            if(total < 0)
            {
                total = 0;
            }
        }

        //Controlar os marcadores de tempo
        if(tempoPontuacao < 6)
        {
            tempoPontuacao += Gdx.graphics.getDeltaTime();
        }
        else
        {
            tempoPontuacao2 += Gdx.graphics.getDeltaTime();
            if(tempoPontuacao2 > 1.5)
            {
                tempoPontuacao2 = 0;
            }
        }

        //Exibir os textos e tocar sons

        //Define a cor da fonte de texto
        font.setColor(1, 1, 1, 1);

        font.draw(batch, "Pontuação", pontuacaoX, pontuacaoY + 50);

        if(jogador.vida > 0)
        {
            font.draw(batch, "Voce pegou o ovo do dragão e completou o jogo." +
                               "\nParabéns!", pontuacaoX, pontuacaoY + 125);
        }
        else
        {
            font.draw(batch, "Voce morreu, que pena." +
                               "\nTente novamente!", pontuacaoX, pontuacaoY + 125);
        }

        if(tempoPontuacao >= 1.5)
        {
            if(sonsTocados == 0)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            font.draw(batch, "Pontos por gosmas derrotadas: " + slimeMortos * 10, pontuacaoX, pontuacaoY);
        }
        if(tempoPontuacao >= 2)
        {
            if(sonsTocados == 1)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            font.draw(batch, "Pontos por ladrões derrotados: " + ladraoMortos * 15, pontuacaoX, pontuacaoY - 25);
        }
        if(tempoPontuacao >= 2.5)
        {
            if(sonsTocados == 2)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            font.draw(batch, "Total de inimigos  derrotados: " + inimigosMortos, pontuacaoX, pontuacaoY - 50);
        }

        if(tempoPontuacao >= 3)
        {
            if(sonsTocados == 3)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            if(quantidadeHits > 0)
            {
                font.draw(batch, "Porcentagem de acerto de ataques: " + ((hitsAcertado * 100) / quantidadeHits) + "%", pontuacaoX, pontuacaoY - 100);
            }
            else
            {
                font.draw(batch, "Porcentagem de acerto de ataques: 0%", pontuacaoX, pontuacaoY - 100);
            }
        }

        if(tempoPontuacao >= 3.5)
        {
            if(sonsTocados == 4)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            font.draw(batch, "Pontos perdidos por viagens entre salas: " + trocasSalas * -2, pontuacaoX, pontuacaoY - 150);
        }

        if(tempoPontuacao >= 4)
        {
            if(sonsTocados == 5)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            font.draw(batch, "Pontos extras: " + pontoExtras, pontuacaoX, pontuacaoY - 200);
        }

        if(tempoPontuacao >= 4.5)
        {
            if(sonsTocados == 6)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            font.draw(batch, "Pontos de vida: " + jogador.vida + " x 100 = " + pontosVida, pontuacaoX, pontuacaoY - 250);
        }

        if(tempoPontuacao >= 5)
        {
            if (jogador.vida == 12) {
                if(sonsTocados == 7)
                {
                    soundController.tocarSom(20);
                    sonsTocados ++;
                }

                font.setColor(1, 1, 0, 1);
            }
            else
            {
                if(sonsTocados == 7)
                {
                    soundController.tocarSom(7);
                    sonsTocados ++;
                }

                font.setColor(1, 0, 0, 1);
            }
            font.draw(batch, "Bônus de vida máxima: " + pontoVidaExtra, pontuacaoX, pontuacaoY - 275);
            font.setColor(1, 1, 1, 1);
        }

        if(tempoPontuacao >= 5.5)
        {
            if(sonsTocados == 8)
            {
                soundController.tocarSom(19);
                sonsTocados ++;
            }

            font.draw(batch, "Tempo de jogo: " + (int) tempoJogando + "s", pontuacaoX, pontuacaoY - 325);
        }

        if(tempoPontuacao >= 6)
        {
            if(sonsTocados == 9)
            {
                soundController.tocarSom(20);
                sonsTocados ++;
            }

            font.draw(batch, "Pontuação total: " + total, pontuacaoX, pontuacaoY - 375);
        }

        if(tempoPontuacao2 > 0.5)
        {
            font.draw(batch, "Aperte espaço para continuar", pontuacaoX, pontuacaoY - 425);
        }
    }


    public static void criarFonte() {
        font = new BitmapFont();
    }
}
