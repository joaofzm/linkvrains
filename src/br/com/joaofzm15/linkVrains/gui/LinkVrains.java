package br.com.joaofzm15.linkVrains.gui;

import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.MenuBackgroundMusic;

public class LinkVrains {

	public static void main(String[] args) {
		
		Thread menuBgMusic = new Thread(new MenuBackgroundMusic());
		menuBgMusic.start();

		new StartMenu();


	}


}
