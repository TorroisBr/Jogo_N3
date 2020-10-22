package com.mygdx.game.desktop;

//import com.badlogic.gdx.backends.lwjgl.Lwjglpplication;
//import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import com.mygdx.game.MyGdxGame2;

public class DesktopLauncher {
	public static void main (String[] arg) {
		int telaLarg=1280,telaAlt=720;
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(telaLarg,telaAlt);
		config.setResizable(false);
		config.useVsync(true);
		new Lwjgl3Application(new MyGdxGame2(), config);
	}
}
