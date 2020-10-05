package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.cidade.Casa;
import com.mygdx.game.cidade.Fundo;
import com.mygdx.game.player.Player;

public class MyGdxGame2 extends ApplicationAdapter {
	SpriteBatch batch;
	int fundoatual;
	Casa npcCasa=new Casa();
	Player jogador=new Player();
	Fundo fundo=new Fundo();
	private OrthographicCamera camera;
	private Viewport gameport;


	@Override
	public void create () {
		camera = new OrthographicCamera();
		gameport=new StretchViewport(1280,720,camera);

		batch = new SpriteBatch();

		jogador.tPlayer = new Texture("player.png");
		fundo.tFundo = new Texture("MapaNovo.png");
		jogador.sPlayer = new Sprite(jogador.tPlayer);
		fundo.sFundo = new Sprite(fundo.tFundo);



		jogador.x=(1280/2);
		jogador.y=(720/2);
		construircasa();
	}

	@Override
	public void render () {

//Camera
		if (jogador.x>1100){
			jogador.x+=(-9);
			fundo.x+=(-25);
			npcCasa.x+=(-25);
		}
		if (jogador.x<100){
			jogador.x+=(+9);
			fundo.x+=(+25);
			npcCasa.x+=(+25);
		}
		if (jogador.y>500){
			jogador.y+=(-9);
			fundo.y+=(-25);
			npcCasa.y+=(-25);
		}
		if (jogador.y<100){
			jogador.y+=(+9);
			fundo.y+=(+25);
			npcCasa.y+=(+25);
		}
//Movimento Player-----------------------------------
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			jogador.x+=(-1f*8);
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			jogador.x+=(1f*8);
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			jogador.y+=(1f*8);
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			jogador.y+=(-1f*8);




		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(fundo.sFundo, fundo.x, fundo.y);
		desenharcasa();
		batch.draw(jogador.sPlayer, jogador.x, jogador.y);

		batch.end();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		jogador.tPlayer.dispose();
		fundo.tFundo.dispose();

	}

	public void construircasa(){
		npcCasa.tCasa=new Texture("Casa_do_Personagem_principal.png");
		npcCasa.sCasa=new Sprite(npcCasa.tCasa);
		npcCasa.sCasa.translate(npcCasa.x=1280/2, npcCasa.y=720/2);

	}

	public void escolheMundo(){

	}
	public void desenharcasa(){
		batch.draw(npcCasa.sCasa, npcCasa.x,npcCasa.y);
	}
}
