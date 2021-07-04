package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.attackArrows.Arrow;

public class AttackAnimation implements Runnable {

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

	public AttackAnimation(DuelFrame df, JButton button, int target) {
		this.duelFrame = df;
		this.button = button;
		this.target = target;
		soundLocation = "resources/sound effects/attack.wav";
		soundLocation2 = "resources/sound effects/impact.wav";
	}

	public Arrow returnArrowByButtonAndTarget() {
		if (this.button == this.duelFrame.getPlayerMonsterZone1().getButton()) {
			if (target == 1) {
				return duelFrame.getArrowPlayer11();
			} else if (target == 2) {
				return duelFrame.getArrowPlayer12();
			} else if (target == 3) {
				return duelFrame.getArrowPlayer13();
			}

		} else if (this.button == this.duelFrame.getPlayerMonsterZone2().getButton()) {
			if (target == 1) {
				return duelFrame.getArrowPlayer21();
			} else if (target == 2) {
				return duelFrame.getArrowPlayer22();
			} else if (target == 3) {
				return duelFrame.getArrowPlayer23();
			}

		} else if (this.button == this.duelFrame.getPlayerMonsterZone3().getButton()) {
			if (target == 1) {
				return duelFrame.getArrowPlayer31();
			} else if (target == 2) {
				return duelFrame.getArrowPlayer32();
			} else if (target == 3) {
				return duelFrame.getArrowPlayer33();
			}
		}
		return null;
	}


	public void setXPosOnForwardMovement(int attackingButton, int target) {
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

	public void setXPosOnBackwardsMovement() {
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


	@Override
	public void run() {
		duelFrame.getPlayerEnablerDisabler().disablePlayer();

		Arrow arrowReference = returnArrowByButtonAndTarget();
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
			setXPosOnForwardMovement(attackingButton, target);
			yPos -= (int) 5;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		if (target == 1) {
			this.duelFrame.getImpactExplosionlabel().setBounds((int) 910, (int) -345, (int) 1000, (int) 1130.4);
		} else if (target == 2) {
			this.duelFrame.getImpactExplosionlabel().setBounds((int) 796.6, (int) -345, (int) 1000, (int) 1130.4);
		} else if (target == 3) {
			this.duelFrame.getImpactExplosionlabel().setBounds((int) 683.2, (int) -345, (int) 1000, (int) 1130.4);
		}

		soundEffectConverter.setFile(soundLocation2);
		soundEffectConverter.play();
		duelFrame.getImpactExplosionlabel().setVisible(true);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		yPos -= 30; // Cancel Recoil
		duelFrame.getImpactExplosionlabel().setVisible(false);

		// Back
		for (int i = 0; i < 60; i++) {
			setXPosOnBackwardsMovement();
			yPos += (int) 5;
			button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		}

		duelFrame.getPlayerEnablerDisabler().enablePlayer();

		// ------------------------------------------------------------------------------------



	}



}
