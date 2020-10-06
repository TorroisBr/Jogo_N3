package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.cidade.Casa;
import com.mygdx.game.player.Player;

public class MyGdxGame2 extends ApplicationAdapter {
    SpriteBatch batch;
    int fundoatual = 4;
    Casa npcCasa = new Casa();
    Player jogador = new Player();
    Sprite sa2, sa3, sb1, sb2, sb3, sc2;
    Texture ta2, ta3, tb1, tb2, tb3, tc2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        jogador.tPlayer = new Texture("player.png");
        ta2 = new Texture("A2.png");
        sa2 = new Sprite(ta2);
        ta3 = new Texture("A3.png");
        sa3 = new Sprite(ta3);
        tb1 = new Texture("B1.png");
        sb1 = new Sprite(tb1);
        tb2 = new Texture("B2.png");
        sb2 = new Sprite(tb2);
        tb3 = new Texture("B3.png");
        sb3 = new Sprite(tb3);
        tc2 = new Texture("C2.png");
        sc2 = new Sprite(tc2);

        jogador.sPlayer = new Sprite(jogador.tPlayer);

        jogador.x = (1280 / 2);
        jogador.y = (720 / 2);
    }

    @Override
    public void render() {
        if (fundoatual == 2) {
            if (jogador.y < 40) {
                fundoatual = 5;
                jogador.y = (690);
            }
        }
        if (fundoatual == 3) {
            if (jogador.y < 40) {
                fundoatual = 6;
                jogador.y = (690);
            }
        }
        if (fundoatual == 4) {
            if (jogador.x > 1200) {
                fundoatual = 5;
                jogador.x = (40);
            }
        }
        if (fundoatual == 5) {
            if (jogador.x < 30) {
                fundoatual = 4;
                jogador.x = (1170);
            }
            if (jogador.y > 700) {
                fundoatual = 2;
                jogador.y = (40);
            }
            if (jogador.y < 30) {
                fundoatual = 8;
                jogador.y = 690;
            }
            if (jogador.x > 1200) {
                fundoatual = 6;
                jogador.x = 40;
            }
        }
        if (fundoatual == 6) {
            if (jogador.x < 30) {
                fundoatual = 5;
                jogador.x = 1170;
            }
            if (jogador.y > 700){
                fundoatual = 3;
                jogador.y = 40;
            }
        }
        if (fundoatual == 8) {
            if (jogador.y > 700) {
                fundoatual = 5;
                jogador.y = 40;
            }
        }

//Movimento Player-----------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            jogador.x += (-1f * 8);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            jogador.x += (1f * 8);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            jogador.y += (1f * 8);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            jogador.y += (-1f * 8);


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        switch (fundoatual) {
            case 2:
                batch.draw(sa2, sa2.getX(), sa2.getY());
                break;
            case 3:
                batch.draw(sa3, sa3.getX(), sa3.getY());
                break;
            case 4:
                batch.draw(sb1, sb1.getX(), sb1.getY());
                break;
            case 5:
                batch.draw(sb2, sb2.getX(), sb2.getY());
                break;
            case 6:
                batch.draw(sb3, sb3.getX(), sb3.getY());
                break;
            case 8:
                batch.draw(sc2, sc2.getX(), sc2.getY());
                break;


        }

        batch.draw(jogador.sPlayer, jogador.x, jogador.y);
        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
        jogador.tPlayer.dispose();
        ta2.dispose();
        ta3.dispose();
        tb1.dispose();
        tb2.dispose();
        tb3.dispose();
        tc2.dispose();
    }
}

