package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import java.awt.Font;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class AllZonesOccupiedWarning implements Runnable {

	private DuelFrame duelFrame;

	public AllZonesOccupiedWarning(DuelFrame duelFrame) {
		this.duelFrame = duelFrame;
	}

	@Override
	public void run() {
		new Thread(new ErrorSound()).start();
		this.duelFrame.getWarningsLabel().setFont(new Font("Impact", Font.PLAIN, 30));
		this.duelFrame.getWarningsLabel().setText("All monster zones are occupied!");
		duelFrame.getWarningsLabel().setVisible(true);
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		duelFrame.getWarningsLabel().setVisible(false);

	}

}
