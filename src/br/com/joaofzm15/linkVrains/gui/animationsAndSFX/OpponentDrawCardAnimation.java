package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import java.awt.Color;

import javax.swing.BorderFactory;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class OpponentDrawCardAnimation implements Runnable {

	private DuelFrame duelFrame;
	private String soundPath;
	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();


	public OpponentDrawCardAnimation(DuelFrame df) {
		this.duelFrame = df;
		soundPath = "resources/sound effects/draw.wav";
	}

	@Override
	public void run() {
		int xPos = 693;
		int yPos = 27;
		duelFrame.getDrawCardAnimationLabel().setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
		duelFrame.getDrawCardAnimationLabel().setBorder(BorderFactory.createLineBorder(Color.white));
		duelFrame.getDrawCardAnimationLabel().setIcon(duelFrame.getGeneralIcons().getMiniCoverImageIcon());
		duelFrame.getDrawCardAnimationLabel().setVisible(true);
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
		for (int i = 0; i < 26; i++) {
				try {Thread.sleep(10);} catch (InterruptedException ex) {ex.printStackTrace();}
				xPos += 11;
				yPos -= 1;
				duelFrame.getDrawCardAnimationLabel().setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			}
		duelFrame.getDrawCardAnimationLabel().setVisible(false);
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
