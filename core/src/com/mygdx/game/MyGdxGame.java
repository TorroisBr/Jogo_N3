//package com.mygdx.game;
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
//public class MyGdxGame21 extends ApplicationAdapter {
//	int fundoatual = 1;
//	SpriteBatch batch;
//	Texture imgplayer, fundo,fundo2;
//	Sprite player,cidade,cidade2;
//
//	@Override
//	public void create () {
//		batch = new SpriteBatch();
//		imgplayer = new Texture("player.png");
//		fundo = new Texture("B1.png");
//		fundo2 = new Texture("B2.png");
//		player = new Sprite(imgplayer);
//		cidade = new Sprite(fundo);
//		cidade2 = new Sprite(fundo2);
//		player.translateX(1280/2);
//		player.translateY(720/2);
//	}
//
//	@Override
//	public void render () {
//
//		if (player.getX()>1200){
//			fundoatual = 2;
//			player.setX(40);
//		}
//		if (player.getX()<30){
//			fundoatual = 1;
//			player.setX(1170);
//		}
////		if (player.getX()<100){
////			player.translateX(+9);
////			cidade.translateX(+25);
////		}
////		if (player.getY()>500){
////			player.translateY(-9);
////			cidade.translateY(-25);
////		}
////		if (player.getY()<100){
////			player.translateY(+9);
////			cidade.translateY(+25);
////		}
//
//		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
//			player.translateX(-1f*8);
//		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
//			player.translateX(1f*8);
//		if(Gdx.input.isKeyPressed(Input.Keys.UP))
//			player.translateY(1f*8);
//		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
//			player.translateY(-1f*8);
//
//		System.out.println(player.getX());
//
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		if (fundoatual == 1){
//			batch.draw(cidade, cidade.getX(), cidade.getY());}
//		else
//			batch.draw(cidade2, cidade2.getX(), cidade2.getY());
//		batch.draw(player, player.getX(), player.getY());
//		batch.end();
//
//	}
//
//
//	@Override
//	public void dispose () {
//		batch.dispose();
//		imgplayer.dispose();
//		fundo.dispose();
//		fundo2.dispose();
//	}
//}
