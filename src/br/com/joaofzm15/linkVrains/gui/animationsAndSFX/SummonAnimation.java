package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class SummonAnimation implements Runnable {

	DuelFrame duelFrame;

	public DuelFrame getDuelFrame() {
		return duelFrame;
	}

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "/sound effects/summon.wav";

	public SummonAnimation(DuelFrame duelFrame, int xPos, int yPos) {
		this.duelFrame = duelFrame;
		duelFrame.getSummonAnimationLabel().setBounds((int) xPos, (int) yPos, (int) 77, (int) 113);
	}

	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
		getDuelFrame().getSummonAnimationLabel().setVisible(true);
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		getDuelFrame().getSummonAnimationLabel().setVisible(false);
	}



}
