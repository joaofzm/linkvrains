package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import java.awt.Color;

import javax.swing.BorderFactory;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class DrawCardAnimation implements Runnable {

	private DuelFrame duelFrame;
	private String soundLocation;
	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();


	public DrawCardAnimation(DuelFrame df) {
		this.duelFrame = df;
		soundLocation = "resources/sound effects/draw.wav";
	}

	@Override
	public void run() {
		
		int xPos = 1160;
		int yPos = 580;
		duelFrame.getDrawCardAnimationLabel().setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
		duelFrame.getDrawCardAnimationLabel().setBorder(BorderFactory.createLineBorder(Color.white));
		duelFrame.getDrawCardAnimationLabel().setIcon(duelFrame.getGeneralIcons().getMiniCoverImageIcon());
		duelFrame.getDrawCardAnimationLabel().setVisible(true);
		soundEffectConverter.setFile(soundLocation);
		soundEffectConverter.play();
		for (int i = 0; i < 26; i++) {
				try {Thread.sleep(10);} catch (InterruptedException ex) {ex.printStackTrace();}
				xPos -= 11;
				yPos += 1;
				duelFrame.getDrawCardAnimationLabel().setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			}
		duelFrame.getDrawCardAnimationLabel().setVisible(false);


	}



}
