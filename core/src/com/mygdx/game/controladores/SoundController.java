package com.mygdx.game.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundController {
    private Music musica;

    private Sound selecao,
                  selecao2;

    public SoundController()
    {
        //Carrega os efeitos sonoros e a musica
        musica = Gdx.audio.newMusic(Gdx.files.internal("musicas/gangstas-paradise-but-only-the-choir-bit-along-with-beats.mp3"));

        selecao = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/ONPARE4_00003.wav"));
        selecao2 = Gdx.audio.newSound(Gdx.files.internal("efeitos_sonoros/ONPARE4_00004.wav"));
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

                //Coloca a musica em looping e a inicia.
                musica.setLooping(true);
                musica.play();
                break;

            case 1:
                //Para a musica caso esteja sendo tocada
                if (musica.isPlaying())
                {
                    musica.stop();
                }

                //Carrega a musica
                musica = Gdx.audio.newMusic(Gdx.files.internal("musicas/PanificadoraAlfa-RemixbyAtilaKw.mp3"));

                //Coloca a musica em looping e a inicia.
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
                //Toca o som
                selecao2.play();
                break;
        }
    }
}
