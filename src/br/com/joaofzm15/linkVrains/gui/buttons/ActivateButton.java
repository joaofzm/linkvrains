package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.event.ActionEvent;
import java.util.Random;

import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.ActivateAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class ActivateButton extends ActionButton {

	public ActivateButton(HandPanelButton handPanelButton) {
		super(handPanelButton);
		this.getButton().setText("Activate");
	}

	public void glasses() {
		this.getHandPanelButton().getHandPanel().getDuelFrame().add1ToGlassesActivatedThisTurn();

		this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().getPower()+1000);
		this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().getPower()+1000);
		this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().getPower()+1000);
	}


	public void tears() {
		if (this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().isOccupied()
				|| this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().isOccupied()
				|| this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().isOccupied()) {

			// Creating this booleans make the code easier to read, although it's useless.
			boolean oneOccupied = false;
			boolean twoOccupied = false;
			boolean threeOccupied = false;
			if (this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().isOccupied()) {
				oneOccupied = true;
			}
			if (this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().isOccupied()) {
				twoOccupied = true;
			}
			if (this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().isOccupied()) {
				threeOccupied = true;
			}
			
			int totalPossibilities = 0;
			if (oneOccupied) {
				totalPossibilities++;
			}
			if (twoOccupied) {
				totalPossibilities++;
			}
			if (threeOccupied) {
				totalPossibilities++;
			}

			Random random = new Random();
			int randomNumber = 0;
			if (totalPossibilities == 2) {
				randomNumber = random.nextInt((2 - 1) + 1) + 1;
			} else if (totalPossibilities == 3) {
				randomNumber = random.nextInt(3 - 1 + 1) + 1;
			}

			// ===========================================================================

			if (oneOccupied && !twoOccupied && !threeOccupied) {
				// Destroy one
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().setOccupied(false);
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().getButton().setIcon(null);
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().removePowerButton();
			
			} else if (oneOccupied && twoOccupied && !threeOccupied) {
				// Destroy one or two
				if (randomNumber==1) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().removePowerButton();
				} else {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().removePowerButton();
				}
		
			} else if (oneOccupied && !twoOccupied && threeOccupied) {
				// Destroy one or three
				if (randomNumber==1) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().removePowerButton();
				} else {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().removePowerButton();
				}
			
			} else if (!oneOccupied && twoOccupied && !threeOccupied) {
				// Destroy two
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().setOccupied(false);
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().getButton().setIcon(null);
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().removePowerButton();
			
			} else if (!oneOccupied && twoOccupied && threeOccupied) {
				// Destroy two or three
				if (randomNumber==1) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().removePowerButton();
				} else {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().removePowerButton();
				}
			
			} else if (!oneOccupied && !twoOccupied && threeOccupied) {
				// Destroy three
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().setOccupied(false);
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().getButton().setIcon(null);
				this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().removePowerButton();
			}

			else if (oneOccupied && twoOccupied && threeOccupied) {
				// Destroy one two or three
				if (randomNumber==1) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().removePowerButton();
				} else if (randomNumber==2) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().removePowerButton();
				} else {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().setOccupied(false);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().getButton().setIcon(null);
					this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().removePowerButton();
				}
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.getHandPanelButton().getHandPanel().getDuelFrame().getActivatedCardLabel().setIcon(this.getHandPanelButton().getCurrentCardBigCard());
		new Thread(new ActivateAnimation(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
		this.getHandPanelButton().getHandPanel().getPanel().remove(this.getHandPanelButton().getButton());
		this.getHandPanelButton().getHandPanel().remove1FromCardsInHand();
		this.getHandPanelButton().getHandPanel().fillHand();

		if (this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getGlasses1()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getGlasses2()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getGlasses3()) {
			this.glasses();
		}
		
		if (this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getTears1()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getTears2()) {
			this.tears();
		}

		new Thread(new FixButtonLayoutThread(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
	}
	
	
	

}
