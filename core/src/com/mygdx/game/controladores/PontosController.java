package com.mygdx.game.controladores;

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
    private int inimigosPonto;
    public static int pontoExtras;
    public static int total = 0;


    public static BitmapFont font;

    public static void exibir() {
        inimigosMortos = slimeMortos + ladraoMortos;
        pontosVida = jogador.vida * 10;

        font.draw(batch, " Pontos Slimes derrotados: " + slimeMortos * 10, 10, 700);
        font.draw(batch, " Pontos Ladrao derrotados: " + ladraoMortos * 15, 10, 675);
        font.draw(batch, " Total inimigo  derrotado: " + inimigosMortos, 10, 650);
        font.draw(batch, " Vezes que atacou: " + quantidadeHits, 10, 625);
        font.draw(batch, " Acerto no inimigo: " + hitsAcertado, 10, 600);
        font.draw(batch, " Pontos Viagens entre salas: " + trocasSalas * -2, 10, 575);
        font.draw(batch, " Pontos extras: " + pontoExtras, 10, 550);
        font.draw(batch, " Pontos de vida: " + pontosVida, 10, 525);
        if (jogador.vida == 12) {
            pontoVidaExtra = 100;
            font.draw(batch, "  Pontos Bonus por vida maxima: " + pontoVidaExtra, 10, 500);
        }
        font.draw(batch, " Tempo: " + (int) tempoJogando + "s", 10, 475);

        total = (slimeMortos * 10) + (ladraoMortos * 15) + (trocasSalas * -2) + pontoExtras + pontosVida + pontoVidaExtra;
        font.draw(batch, " TOTAL: " + total, 10, 425);
    }


    public static void criarFonte() {
        font = new BitmapFont();

    }
}
