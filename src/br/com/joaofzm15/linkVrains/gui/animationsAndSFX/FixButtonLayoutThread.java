package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class FixButtonLayoutThread implements Runnable {

	private DuelFrame duelFrame;

	public FixButtonLayoutThread(DuelFrame df) {
		this.duelFrame = df;
	}

	@Override
	public void run() {
		duelFrame.getDrawCardAnimationLabel().setVisible(true);
		duelFrame.getDrawCardAnimationLabel().setVisible(false);
	}
}
