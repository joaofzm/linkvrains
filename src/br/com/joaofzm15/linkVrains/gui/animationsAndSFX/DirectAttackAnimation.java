package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.attackArrows.Arrow;

public class DirectAttackAnimation implements Runnable {

	private DuelFrame duelFrame;
	private JButton button;
	int attackingButton;
	private String soundLocation;
	private String soundLocation2;
	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();

	int xPos = 0;
	int yPos = 0;
	int xPosMovement = 0;

	public DirectAttackAnimation(DuelFrame df, JButton button) {
		this.duelFrame = df;
		this.button = button;
		soundLocation = "resources/sound effects/attack.wav";
		soundLocation2 = "resources/sound effects/impact.wav";
	}

	public Arrow returnArrowByButton() {
		if (this.button == this.duelFrame.getPlayerMonsterZone1().getButton()) {
			return duelFrame.getArrowPlayer10();

		} else if (this.button == this.duelFrame.getPlayerMonsterZone2().getButton()) {
			return duelFrame.getArrowPlayer20();

		} else if (this.button == this.duelFrame.getPlayerMonsterZone3().getButton()) {
			return duelFrame.getArrowPlayer30();
		}
		return null;
	}



	@Override
	public void run() {
		Arrow arrowReference = returnArrowByButton();
		arrowReference.getArrowLabel().setVisible(true);
		soundEffectConverter.setFile(soundLocation);
		soundEffectConverter.play();
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		arrowReference.getArrowLabel().setVisible(false);
		
		if (this.button == this.duelFrame.getPlayerMonsterZone1().getButton()) {
			xPos = this.button.getX();
			yPos = this.button.getY();
		} else if (this.button == this.duelFrame.getPlayerMonsterZone2().getButton()) {
			xPos = this.button.getX();
			yPos = this.button.getY();
		} else if (this.button == this.duelFrame.getPlayerMonsterZone3().getButton()) {
			xPos = this.button.getX();
			yPos = this.button.getY();
		}
		
		// --------------------------------------------------------------------------------------

		//Impulse
		for (int i = 0; i < 10; i++) {
			if (this.button == this.duelFrame.getPlayerMonsterZone1().getButton()) {
				attackingButton = 1;
			} else if (this.button == this.duelFrame.getPlayerMonsterZone2().getButton()) {
				attackingButton = 2;
			} else if (this.button == this.duelFrame.getPlayerMonsterZone3().getButton()) {
				attackingButton = 3;
			}
			yPos += (int) 3;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(15);} catch (InterruptedException e) {e.printStackTrace();}
		}
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}

		// Forward
		for (int i = 0; i < 60; i++) {
			yPos -= (int) 9;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		if (this.button == duelFrame.getPlayerMonsterZone1().getButton()) {
			this.duelFrame.getLabelTesteFire().setBounds((int) 683.2, (int) -565, (int) 1000, (int) 1130.4);

		} else if (this.button == duelFrame.getPlayerMonsterZone2().getButton()) {
			this.duelFrame.getLabelTesteFire().setBounds((int) 796.6, (int) -565, (int) 1000, (int) 1130.4);

		} else if (this.button == duelFrame.getPlayerMonsterZone3().getButton()) {
			this.duelFrame.getLabelTesteFire().setBounds((int) 910, (int) -565, (int) 1000, (int) 1130.4);
		}

		soundEffectConverter.setFile(soundLocation2);
		soundEffectConverter.play();
		duelFrame.getLabelTesteFire().setVisible(true);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		yPos -= 30; // Cancel Recoil
		duelFrame.getLabelTesteFire().setVisible(false);

		// Back
		for (int i = 0; i < 60; i++) {
			yPos += (int) 9;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		}


		// ------------------------------------------------------------------------------------



	}



}
