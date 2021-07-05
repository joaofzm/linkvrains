package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import java.awt.Font;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class RoundPassTextAnimation implements Runnable {

	private DuelFrame duelFrame;

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "/sound effects/nextRound.wav";

	public RoundPassTextAnimation(DuelFrame duelFrame) {
		this.duelFrame = duelFrame;
	}

	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
		this.duelFrame.getWarningsLabel().setFont(new Font("Impact", Font.PLAIN, 50));
		this.duelFrame.getWarningsLabel().setText("             ROUND: " + this.duelFrame.getCurrentRound());
		duelFrame.getWarningsLabel().setVisible(true);
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		duelFrame.getWarningsLabel().setVisible(false);

	}

}
