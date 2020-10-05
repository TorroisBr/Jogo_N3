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
    int fundoatual = 1;
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

		if (jogador.x>1200){
			fundoatual = 2;
			jogador.x =(40);
		}
		if (jogador.x<30){
			fundoatual = 1;
			jogador.x = (1170);
		}
////Camera
//		if (jogador.x>1100){
//			jogador.x+=(-9);
//			fundo.x+=(-25);
//			npcCasa.x+=(-25);
//		}
//		if (jogador.x<100){
//			jogador.x+=(+9);
//			fundo.x+=(+25);
//			npcCasa.x+=(+25);
//		}
//		if (jogador.y>500){
//			jogador.y+=(-9);
//			fundo.y+=(-25);
//			npcCasa.y+=(-25);
//		}
//		if (jogador.y<100){
//			jogador.y+=(+9);
//			fundo.y+=(+25);
//			npcCasa.y+=(+25);
//		}
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
            case 1:
                batch.draw(sb1, sb1.getX(), sb1.getY());
                break;
			case 2:
				batch.draw(sb2, sb2.getX(), sb2.getY());
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
//	public void construircasa(){
//		npcCasa.tCasa=new Texture("Casa_do_Personagem_principal.png");
//		npcCasa.sCasa=new Sprite(npcCasa.tCasa);
//		npcCasa.sCasa.translate(npcCasa.x=1280/2, npcCasa.y=720/2);
//
//	}
//
//	public void escolheMundo(){
//
//	}
//	public void desenharcasa(){
//		batch.draw(npcCasa.sCasa, npcCasa.x,npcCasa.y);
//	}
//}
