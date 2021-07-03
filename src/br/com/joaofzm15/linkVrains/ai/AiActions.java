package br.com.joaofzm15.linkVrains.ai;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import br.com.joaofzm15.linkVrains.cards.MonsterCard;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.ActivateAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.AllZonesOccupiedWarning;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.OpponentAttackAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.OpponentDirectAttackAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.SummonAnimation;
import br.com.joaofzm15.linkVrains.gui.buttons.HandPanelButton;
import br.com.joaofzm15.linkVrains.gui.buttons.OpponentMonsterFieldButton;
import br.com.joaofzm15.linkVrains.gui.buttons.PlayerMonsterFieldButton;

public class AiActions {

	public void attack(PlayerMonsterFieldButton pmfb, OpponentMonsterFieldButton omfb) {
		int target;
		if (pmfb == pmfb.getDuelFrame().getPlayerMonsterZone1()) {
			target = 1;
		} else if (pmfb == pmfb.getDuelFrame().getPlayerMonsterZone2()) {
			target = 2;
		} else {
			target = 3;
		}
		new Thread(new OpponentAttackAnimation(pmfb.getDuelFrame(), omfb.getButton(), target)).start();
		new Thread() {
			public void run() {
				try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
				
				if (pmfb.getPower() > omfb.getPower()) {
					omfb.setOccupied(false);
					omfb.getButton().setIcon(null);
					omfb.removePowerButton();
				} else if (pmfb.getPower() < omfb.getPower()) {
					pmfb.setOccupied(false);
					pmfb.getButton().setIcon(null);
					pmfb.removePowerButton();
				} else {
					omfb.setOccupied(false);
					omfb.getButton().setIcon(null);
					omfb.removePowerButton();
					pmfb.setOccupied(false);
					pmfb.getButton().setIcon(null);
					pmfb.removePowerButton();
				}
			}
		}.start();
	}

	public void directAttack( OpponentMonsterFieldButton omfb) {
		new Thread(new OpponentDirectAttackAnimation(omfb.getDuelFrame(), omfb.getButton())).start();
		
		new Thread() {
			public void run() {
				try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
				omfb.getDuelFrame().setPlayerHp(omfb.getDuelFrame().getPlayerHp() - omfb.getPower());
				if (omfb.getDuelFrame().getPlayerHp() < 0) {
					omfb.getDuelFrame().setPlayerHp(0);
				}
			}
		}.start();

	}

	// ==========================================

	public void microphone(HandPanelButton handPanelButton) {
		handPanelButton.getHandPanel().getDuelFrame().add1ToMicrophonesActivatedThisTurn();
		
		handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().setPower(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().getPower()+1000);
		handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().setPower(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().getPower()+1000);
		handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().setPower(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().getPower()+1000);
	}
	
	public void headphone(HandPanelButton handPanelButton) {
		if (handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().isOccupied()
				|| handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().isOccupied()
				|| handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().isOccupied()) {

			// Creating this booleans make the code easier to read, although it's useless.
			boolean oneOccupied = false;
			boolean twoOccupied = false;
			boolean threeOccupied = false;
			if (handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().isOccupied()) {
				oneOccupied = true;
			}
			if (handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().isOccupied()) {
				twoOccupied = true;
			}
			if (handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().isOccupied()) {
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
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().setOccupied(false);
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().getButton().setIcon(null);
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().removePowerButton();

			} else if (oneOccupied && twoOccupied && !threeOccupied) {
				// Destroy one or two
				if (randomNumber == 1) {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().removePowerButton();
				} else {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().removePowerButton();
				}
		
			} else if (oneOccupied && !twoOccupied && threeOccupied) {
				// Destroy one or three
				if (randomNumber == 1) {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().removePowerButton();
				} else {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().removePowerButton();
				}

			} else if (!oneOccupied && twoOccupied && !threeOccupied) {
				// Destroy two
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().setOccupied(false);
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().getButton().setIcon(null);
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().removePowerButton();

			} else if (!oneOccupied && twoOccupied && threeOccupied) {
				// Destroy two or three
				if (randomNumber == 1) {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().removePowerButton();
				} else {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().removePowerButton();
				}

			} else if (!oneOccupied && !twoOccupied && threeOccupied) {
				// Destroy three
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().setOccupied(false);
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().getButton().setIcon(null);
				handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().removePowerButton();
			}

			else if (oneOccupied && twoOccupied && threeOccupied) {
				// Destroy one two or three
				if (randomNumber == 1) {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().removePowerButton();
				} else if (randomNumber == 2) {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().removePowerButton();
				} else {
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().setOccupied(false);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().getButton().setIcon(null);
					handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().removePowerButton();
				}
			}
		}
	}
	
	public void manualTune(HandPanelButton handPanelButton) {
		
		if (handPanelButton.getHandPanel().getDuelFrame().isSunPlacedOnTheField()) {
			handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().setPower(handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone1().getPower()-1000);
			handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().setPower(handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone2().getPower()-1000);
			handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().setPower(handPanelButton.getHandPanel().getDuelFrame().getPlayerMonsterZone3().getPower()-1000);
			handPanelButton.getHandPanel().getDuelFrame().setSunIsPlacedOnTheField(false);
		}
		
		if (!handPanelButton.getHandPanel().getDuelFrame().isManualTunePlacedOnTheField()) {
			System.out.println(handPanelButton.getHandPanel().getDuelFrame().isManualTunePlacedOnTheField());
			handPanelButton.getHandPanel().getDuelFrame().setManualTuneIsPlacedOnTheField(true);
			System.out.println(handPanelButton.getHandPanel().getDuelFrame().isManualTunePlacedOnTheField());
			handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().setPower(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().getPower()+1000);
			handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().setPower(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().getPower()+1000);
			handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().setPower(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().getPower()+1000);
		}
	}
	
	public void place(HandPanelButton handPanelButton) {
		ImageIcon temporaryOriginalImageIcon = handPanelButton.getImageIconFromCard(handPanelButton.getCard());
		Image temporaryOriginalImage = temporaryOriginalImageIcon.getImage();
		Image temporaryBigImage = temporaryOriginalImage.getScaledInstance((int) 271, (int) 395, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedBigImageIcon = new ImageIcon(temporaryBigImage);
		
		handPanelButton.getHandPanel().getDuelFrame().getActivatedCardLabel().setIcon(resizedBigImageIcon);
		new Thread(new ActivateAnimation(handPanelButton.getHandPanel().getDuelFrame())).start();
		handPanelButton.getHandPanel().getPanel().remove(handPanelButton.getButton());
		handPanelButton.getHandPanel().getButtonList().remove(handPanelButton);
		handPanelButton.getHandPanel().remove1FromCardsInHand();
		handPanelButton.getHandPanel().fillHand();
		handPanelButton.getHandPanel().getDuelFrame().getFieldButton().setIcons(handPanelButton.getImageIconFromCard(handPanelButton.getCard()));
		
		if (handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getManualTune1()
				|| handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getManualTune2()
				|| handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getManualTune3()) {
			this.manualTune(handPanelButton);
		}
		
		new Thread(new FixButtonLayoutThread(handPanelButton.getHandPanel().getDuelFrame())).start();
	}

	public boolean summon(HandPanelButton handPanelButton) {
		
		MonsterCard handPanelMonsterCardReference = (MonsterCard) handPanelButton.getCard();
		if (handPanelMonsterCardReference.getCost() <= handPanelButton.getHandPanel().getDuelFrame().getOpponentMana()) {
			if(!handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().isOccupied()) {
				new Thread(new SummonAnimation(handPanelButton.getHandPanel().getDuelFrame(), (int) 926.6, (int) 156.6)).start();
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().setIcons(handPanelButton.getImageIconFromCard(handPanelButton.getCard()));
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().setOccupied(true);
				
				handPanelButton.getHandPanel().getPanel().remove(handPanelButton.getButton());
				handPanelButton.getHandPanel().getButtonList().remove(handPanelButton);
				handPanelButton.getHandPanel().remove1FromCardsInHand();
				handPanelButton.getHandPanel().fillHand();
			
				if (handPanelButton.getHandPanel().getDuelFrame().isManualTunePlacedOnTheField()) {
					handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().setPower(handPanelButton.getPower() + 1000);
				} else {
					handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().setPower(handPanelButton.getPower());
				}
				
				handPanelButton.getHandPanel().getDuelFrame().setOpponentMana(handPanelButton.getHandPanel().getDuelFrame().getOpponentMana()- handPanelMonsterCardReference.getCost());
				
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().getPowerButton().setText(String.valueOf(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().getPower()));
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().getButton().add(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone2().getPowerButton());
			
				new Thread(new FixButtonLayoutThread(handPanelButton.getHandPanel().getDuelFrame())).start();
				return true;

			} else if(!handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().isOccupied()) {
				new Thread(new SummonAnimation(handPanelButton.getHandPanel().getDuelFrame(), (int) 1040, (int) 156.6)).start();
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().setIcons(handPanelButton.getImageIconFromCard(handPanelButton.getCard()));
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().setOccupied(true);
				
				handPanelButton.getHandPanel().getPanel().remove(handPanelButton.getButton());
				handPanelButton.getHandPanel().getButtonList().remove(handPanelButton);
				handPanelButton.getHandPanel().remove1FromCardsInHand();
				handPanelButton.getHandPanel().fillHand();
				
				if (handPanelButton.getHandPanel().getDuelFrame().isManualTunePlacedOnTheField()) {
					handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().setPower(handPanelButton.getPower() + 1000);
				} else {
					handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().setPower(handPanelButton.getPower());
				}
				
				handPanelButton.getHandPanel().getDuelFrame()	.setOpponentMana(handPanelButton.getHandPanel().getDuelFrame().getOpponentMana()- handPanelMonsterCardReference.getCost());
		
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().getPowerButton()
						.setText(String.valueOf(handPanelButton.getHandPanel().getDuelFrame()
								.getOpponentMonsterZone1().getPower()));
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().getButton().add(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone1().getPowerButton());

				new Thread(new FixButtonLayoutThread(handPanelButton.getHandPanel().getDuelFrame())).start();
				return true;

			} else if(!handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().isOccupied()) {
				new Thread(new SummonAnimation(handPanelButton.getHandPanel().getDuelFrame(), (int) 813.2, (int) 156.6)).start();
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().setIcons(handPanelButton.getImageIconFromCard(handPanelButton.getCard()));
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().setOccupied(true);
				
				handPanelButton.getHandPanel().getPanel().remove(handPanelButton.getButton());
				handPanelButton.getHandPanel().getButtonList().remove(handPanelButton);
				handPanelButton.getHandPanel().remove1FromCardsInHand();
				handPanelButton.getHandPanel().fillHand();
				
				if (handPanelButton.getHandPanel().getDuelFrame().isManualTunePlacedOnTheField()) {
					handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().setPower(handPanelButton.getPower() + 1000);
				} else {
					handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().setPower(handPanelButton.getPower());
				}	
				
				handPanelButton.getHandPanel().getDuelFrame().setOpponentMana(handPanelButton.getHandPanel().getDuelFrame().getOpponentMana()- handPanelMonsterCardReference.getCost());

				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().getPowerButton()
						.setText(String.valueOf(handPanelButton.getHandPanel().getDuelFrame()
								.getOpponentMonsterZone3().getPower()));
				handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().getButton().add(handPanelButton.getHandPanel().getDuelFrame().getOpponentMonsterZone3().getPowerButton());

				new Thread(new FixButtonLayoutThread(handPanelButton.getHandPanel().getDuelFrame())).start();
				return true;

			} else {
				new Thread(new AllZonesOccupiedWarning(handPanelButton.getHandPanel().getDuelFrame())).start();
				new Thread(new FixButtonLayoutThread(handPanelButton.getHandPanel().getDuelFrame())).start();
				return false;
			}
		
		} else {
			new Thread(new FixButtonLayoutThread(handPanelButton.getHandPanel().getDuelFrame())).start();
			return false;
		}

	}
	
	public void activate(HandPanelButton handPanelButton) {
		ImageIcon temporaryOriginalImageIcon = handPanelButton.getImageIconFromCard(handPanelButton.getCard());
		Image temporaryOriginalImage = temporaryOriginalImageIcon.getImage();
		Image temporaryBigImage = temporaryOriginalImage.getScaledInstance((int) 271, (int) 395, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedBigImageIcon = new ImageIcon(temporaryBigImage);


		handPanelButton.getHandPanel().getDuelFrame().getActivatedCardLabel().setIcon(resizedBigImageIcon);
		new Thread(new ActivateAnimation(handPanelButton.getHandPanel().getDuelFrame())).start();
		handPanelButton.getHandPanel().getPanel().remove(handPanelButton.getButton());
		handPanelButton.getHandPanel().remove1FromCardsInHand();
		handPanelButton.getHandPanel().getButtonList().remove(handPanelButton);
		handPanelButton.getHandPanel().fillHand();

		if (handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getMicrophone1()
				|| handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getMicrophone2()
				|| handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getMicrophone3()) {
			this.microphone(handPanelButton);
		}
		
		if (handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getHeadphone1()
				|| handPanelButton.getCard() == handPanelButton.getHandPanel().getDuelFrame().getOpponentDeck().getHeadphone2()) {
			this.headphone(handPanelButton);
		}

		new Thread(new FixButtonLayoutThread(handPanelButton.getHandPanel().getDuelFrame())).start();
	}
	
	
	
}
