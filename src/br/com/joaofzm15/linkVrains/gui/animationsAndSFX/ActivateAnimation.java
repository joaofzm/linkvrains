package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class ActivateAnimation implements Runnable {

	DuelFrame duelFrame;

	public DuelFrame getDuelFrame() {
		return duelFrame;
	}


	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "/sound effects/activate.wav";

	public ActivateAnimation(DuelFrame duelFrame) {
		this.duelFrame = duelFrame;
	}

	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();

		this.getDuelFrame().getRoundLabel().setVisible(false);
		this.getDuelFrame().getPassRoundButton().setVisible(false);
		this.getDuelFrame().getActivatedCardLabel().setVisible(true);
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		this.getDuelFrame().getActivatedCardLabel().setVisible(false);
		this.getDuelFrame().getRoundLabel().setVisible(true);
		this.getDuelFrame().getPassRoundButton().setVisible(true);

	}


}
