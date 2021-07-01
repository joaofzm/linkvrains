package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.attackArrows.Arrow;

public class OpponentAttackAnimation implements Runnable {

	private DuelFrame duelFrame;
	private JButton button;
	int attackingButton;
	private String soundLocation;
	private String soundLocation2;
	private int target;
	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();

	int xPos = 0;
	int yPos = 0;
	int xPosMovement = 0;

	public OpponentAttackAnimation(DuelFrame df, JButton button, int target) {
		this.duelFrame = df;
		this.button = button;
		this.target = target;
		soundLocation = "resources/sound effects/attack.wav";
		soundLocation2 = "resources/sound effects/impact.wav";
	}

	public Arrow returnArrowByButtonAndTarget() {
		if (this.button == this.duelFrame.getOpponentMonsterZone1().getButton()) {
			if (target == 1) {
				return duelFrame.getArrowOpponent11();
			} else if (target == 2) {
				return duelFrame.getArrowOpponent12();
			} else if (target == 3) {
				return duelFrame.getArrowOpponent13();
			}

		} else if (this.button == this.duelFrame.getOpponentMonsterZone2().getButton()) {
			if (target == 1) {
				return duelFrame.getArrowOpponent21();
			} else if (target == 2) {
				return duelFrame.getArrowOpponent22();
			} else if (target == 3) {
				return duelFrame.getArrowOpponent23();
			}

		} else if (this.button == this.duelFrame.getOpponentMonsterZone3().getButton()) {
			if (target == 1) {
				return duelFrame.getArrowOpponent31();
			} else if (target == 2) {
				return duelFrame.getArrowOpponent32();
			} else if (target == 3) {
				return duelFrame.getArrowOpponent33();
			}
		}
		return null;
	}


	public void setXPosOnForwardMovement(int attackingButton, int target) {
		if (attackingButton == 1) {
			if (target == 1) {
				xPos -= (int) 3.78;
			} else if (target == 2) {
				xPos -= (int) 1.89;
			} else if (target == 3) {
				// No change
			}

		} else if (attackingButton == 2) {
			if (target == 1) {
				xPos -= (int) 1.89;
			} else if (target == 2) {
				// No change
			} else if (target == 3) {
				xPos += (int) 1.89;
			}

		} else if (attackingButton == 3) {
			if (target == 1) {
				// No change
			} else if (target == 2) {
				xPos += (int) 1.89;
			} else if (target == 3) {
				xPos += (int) 3.78;
			}
		}
	}

	public void setXPosOnBackwardsMovement() {
		if (attackingButton == 1) {
			if (target == 1) {
				xPos += (int) 3.78;
			} else if (target == 2) {
				xPos += (int) 1.89;
			} else if (target == 3) {
				// No change
			}

		} else if (attackingButton == 2) {
			if (target == 1) {
				xPos += (int) 1.89;
			} else if (target == 2) {
				// No change
			} else if (target == 3) {
				xPos -= (int) 1.89;
			}

		} else if (attackingButton == 3) {
			if (target == 1) {
				// No change
			} else if (target == 2) {
				xPos -= (int) 1.89;
			} else if (target == 3) {
				xPos -= (int) 3.78;
			}
		}
	}


	@Override
	public void run() {
		Arrow arrowReference = returnArrowByButtonAndTarget();
		arrowReference.getArrowLabel().setVisible(true);
		soundEffectConverter.setFile(soundLocation);
		soundEffectConverter.play();
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		arrowReference.getArrowLabel().setVisible(false);
		
		if (this.button == this.duelFrame.getOpponentMonsterZone1().getButton()) {
			xPos = this.button.getX();
			yPos = this.button.getY();
		} else if (this.button == this.duelFrame.getOpponentMonsterZone2().getButton()) {
			xPos = this.button.getX();
			yPos = this.button.getY();
		} else if (this.button == this.duelFrame.getOpponentMonsterZone3().getButton()) {
			xPos = this.button.getX();
			yPos = this.button.getY();
		}
		
		// --------------------------------------------------------------------------------------

		//Impulse
		for (int i = 0; i < 10; i++) {
			if (this.button == this.duelFrame.getOpponentMonsterZone1().getButton()) {
				attackingButton = 1;
			} else if (this.button == this.duelFrame.getOpponentMonsterZone2().getButton()) {
				attackingButton = 2;
			} else if (this.button == this.duelFrame.getOpponentMonsterZone3().getButton()) {
				attackingButton = 3;
			}
			yPos -= (int) 3;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(15);} catch (InterruptedException e) {e.printStackTrace();}
		}
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}

		// Forward
		for (int i = 0; i < 60; i++) {
			setXPosOnForwardMovement(attackingButton, target);
			yPos += (int) 5;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		if (target == 1) {
			this.duelFrame.getLabelTesteFire().setBounds((int) 683.2, (int) -51.6, (int) 1000, (int) 1130.4);
		} else if (target == 2) {
			this.duelFrame.getLabelTesteFire().setBounds((int) 796.6, (int) -51.6, (int) 1000, (int) 1130.4);
		} else if (target == 3) {
			this.duelFrame.getLabelTesteFire().setBounds((int) 910, (int) -51.6, (int) 1000, (int) 1130.4);
		}

		soundEffectConverter.setFile(soundLocation2);
		soundEffectConverter.play();
		duelFrame.getLabelTesteFire().setVisible(true);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		yPos += 30; // Cancel Recoil
		duelFrame.getLabelTesteFire().setVisible(false);

		// Back
		for (int i = 0; i < 60; i++) {
			setXPosOnBackwardsMovement();
			yPos -= (int) 5;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		}

		// ------------------------------------------------------------------------------------



	}



}
