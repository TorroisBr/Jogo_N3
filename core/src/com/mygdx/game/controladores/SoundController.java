package com.mygdx.game.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundController {
    private Music musica;

    private Sound selecao,
                  selecao2,
                  confirmar,
                  voltar,
                  espadada1,
                  espadada2,
                  espadada3,
                  severinoDano,
                  iniciarMissao,
                  blublublu1,
                  blublublu2,
                  blublublu3,
                  blublublu4,
                  blublublu5,
                  blublublu6,
                  inimigoDano,
                  inimigoMorre,
                  espadada4,
                  severinoMorre;

    public SoundController()
    {
        //Carrega os efeitos sonoros e a musica
        musica = Gdx.audio.newMusic(Gdx.files.internal("musicas/gangstas-paradise-but-only-the-choir-bit-along-with-beats.mp3"));

        selecao = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/ONPARE4_00003.wav"));
        selecao2 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/ONPARE4_00004.wav"));
        confirmar = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/PL00_U_00042.wav"));
        voltar = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/PL01_U_00036.wav"));
        espadada1 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/fighterSword1.wav"));
        espadada2 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/fighterSword2.wav"));
        espadada3 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/goldenSword.wav"));
        severinoDano = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/linkHurt.wav"));
        iniciarMissao = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/ST0D_0Z_00001.wav"));
        blublublu1 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/blublublu1.wav"));
        blublublu2 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/blublublu2.wav"));
        blublublu3 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/blublublu3.wav"));
        blublublu4 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/blublublu4.wav"));
        blublublu5 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/blublublu5.wav"));
        blublublu6 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/blublublu6.wav"));
        inimigoDano = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/enemyHit.wav"));
        inimigoMorre = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/enemyDies.wav"));
        espadada4 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/masterSword.wav"));
        severinoMorre = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/PL01_U_00040.wav"));
    }

    public void tocarMusica(int som)
    {
        switch (som)
        {
            case -1:
                //Para a musica
                musica.stop();
                break;

            case 0:
                //Para a musica caso esteja sendo tocada
                if (musica.isPlaying())
                {
                    musica.stop();
                }

                //Carrega a musica
                musica = Gdx.audio.newMusic(Gdx.files.internal("musicas/gangstas-paradise-but-only-the-choir-bit-along-with-beats.mp3"));

                //Muda o volume da musica
                musica.setVolume(0.25f);

                //Coloca a musica em looping e a inicia.
                musica.setLooping(true);
                musica.play();
                break;

            case 1:
                if (musica.isPlaying())
                {
                    musica.stop();
                }

                musica = Gdx.audio.newMusic(Gdx.files.internal("musicas/PanificadoraAlfa-RemixbyAtilaKw.mp3"));

                musica.setVolume(0.25f);

                musica.setLooping(true);
                musica.play();
                break;

            case 2:
                if (musica.isPlaying())
                {
                    musica.stop();
                }

                musica = Gdx.audio.newMusic(Gdx.files.internal("musicas/AnotherCastle.mp3"));

                musica.setVolume(0.5f);

                musica.setLooping(true);
                musica.play();
                break;
        }
    }

    public void tocarSom(int som)
    {
        switch (som)
        {
            case 0:
                //Toca o som
                selecao.play();
                break;

            case 1:
                selecao2.play();
                break;

            case 2:
                confirmar.play();
                break;

            case 3:
                voltar.play();
                break;

            case 4:
                espadada1.play();
                break;

            case 5:
                espadada2.play();
                break;

            case 6:
                espadada3.play();
                break;

            case 7:
                severinoDano.play();
                break;

            case 8:
                iniciarMissao.play();
                break;

            case 9:
                blublublu1.play();
                break;

            case 10:
                blublublu2.play();
                break;

            case 11:
                blublublu3.play();
                break;

            case 12:
                blublublu4.play();
                break;

            case 13:
                blublublu5.play();
                break;

            case 14:
                blublublu6.play();
                break;

            case 15:
                inimigoDano.play();
                break;

            case 16:
                inimigoMorre.play();
                break;

            case 17:
                espadada4.play();
                break;

            case 18:
                severinoMorre.play();
                break;
        }
    }
}
