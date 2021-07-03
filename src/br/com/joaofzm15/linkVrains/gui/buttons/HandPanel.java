package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import br.com.joaofzm15.linkVrains.cards.Card;
import br.com.joaofzm15.linkVrains.cards.MonsterCard;
import br.com.joaofzm15.linkVrains.cards.SpellCard;
import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.DrawCardAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.OpponentDrawCardAnimation;

public class HandPanel {
	
	private ArrayList<HandPanelButton> buttonList = new ArrayList<HandPanelButton>();

	public ArrayList<HandPanelButton> getButtonList() {
		return buttonList;
	}

	/*
	 * Initiate at the default value (0), and is responsible for the index of the
	 * card to be draw from the Deck ArrayList.
	 * 
	 * Every time a card is draw it's increased by 0, and once it reaches 20 the
	 * draw method won't initiate anymore.
	 */
	int nextCardIndex;

	private DuelFrame duelFrame;
	public DuelFrame getDuelFrame() {
		return duelFrame;
	}

	/*
	 * This class is responsible for the JPanel where the cards in hand will show,
	 * but it's not a JPanel itself, it contains a JPanel as well as other
	 * properties. In order to access the panel you must use "handPanel.getPanel()".
	 */
	private JPanel panel;
	public JPanel getPanel() {
		return panel;
	}


	/*
	 * The integer cards in hand is used to track how many buttons (representing
	 * cards) are in the panel.
	 * 
	 * Since the panel uses a GridLayout, in order to fit all cards, it's necessary
	 * to make the panel always act as if it contains at least five buttons at all
	 * times, otherwise the cards would become larger that it's ImageIcon.
	 * 
	 * Thus the filler buttons are added to the frame if the player has less that
	 * five cards in hand so there are always at least five buttons on the panel.
	 * The method "fillHand" is responsible for adding and removing the filler
	 * buttons whenever it's needed.
	 */
	int cardsInHand;

	public int getCardsInHand() {
		return cardsInHand;
	}

	public void remove1FromCardsInHand() {
		cardsInHand--;
	}

	HandPanelFillerButton fillerButton1;
	HandPanelFillerButton fillerButton2;
	HandPanelFillerButton fillerButton3;
	HandPanelFillerButton fillerButton4;


	/*
	 * This reference is used only so this class can be passed as a parameter to
	 * it's own Timer. The word "this" won't work in that scope as this becomes the
	 * Timer itself, and this way to reference this class is needed.
	 */
	HandPanel thisHandPanelReference;

	/*
	 * The Timer is used to delay some actions so they sync with the animations
	 * properly.
	 */
	Timer timer;
	TimerTask timerTask;

	public HandPanel(DuelFrame duelFrame, int xPos, int yPos, int xSize, int ySize) {
		this.panel = new JPanel();
		this.duelFrame = duelFrame;
		this.panel.setBounds(xPos, yPos, (int) xSize, (int) ySize);
		this.panel.setBackground(Color.black);
		this.panel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		this.panel.setLayout(new GridLayout(1, 0));
		this.duelFrame.getFrame().add(panel);
		fillerButton1 = new HandPanelFillerButton(this);
		fillerButton2 = new HandPanelFillerButton(this);
		fillerButton3 = new HandPanelFillerButton(this);
		fillerButton4 = new HandPanelFillerButton(this);
		timer = new Timer();
		thisHandPanelReference = this;
	}

	/*
	 * For more info on this method check the filler buttons declaration above.
	 */
	public void fillHand() {
		getPanel().remove(fillerButton1.getButton());
		getPanel().remove(fillerButton2.getButton());
		getPanel().remove(fillerButton3.getButton());
		getPanel().remove(fillerButton4.getButton());
		if (getCardsInHand() == 0 || getCardsInHand() == 1) {
			getPanel().add(fillerButton1.getButton());
			getPanel().add(fillerButton2.getButton());
			getPanel().add(fillerButton3.getButton());
			getPanel().add(fillerButton4.getButton());
		} else if (getCardsInHand() == 2) {
			getPanel().add(fillerButton1.getButton());
			getPanel().add(fillerButton2.getButton());
			getPanel().add(fillerButton3.getButton());
		} else if (getCardsInHand() == 3) {
			getPanel().add(fillerButton1.getButton());
			getPanel().add(fillerButton2.getButton());
		} else if (getCardsInHand() == 4) {
			getPanel().add(fillerButton1.getButton());
		}

	}

	/*
	 * The timer delays the card visually appearing at the screen, so it sync
	 * visually with the draw animation properly.
	 */
	public void drawCard() {
		if (nextCardIndex < 20) {
			new Thread(new DrawCardAnimation(this.duelFrame)).start();
			Card tempCard = thisHandPanelReference.duelFrame.getPlayerDeck().getDeckArrayList().get(nextCardIndex);
			nextCardIndex++;
			cardsInHand = getCardsInHand() + 1;
			if (nextCardIndex >= 20) {
				this.duelFrame.getPlayerDeckButton().getButton().setIcon(null);
				this.duelFrame.getPlayerDeckButton().setCurrentCardBigCard(null);
			}
			timerTask = new TimerTask() {
				@Override
				public void run() {
					HandPanelButton handButtonOfNewDrawCard = new HandPanelButton(thisHandPanelReference);
					handButtonOfNewDrawCard.setCard(tempCard);
					if (tempCard.getClass() == MonsterCard.class) {
						MonsterCard tempMonsterCard = (MonsterCard) tempCard;
						handButtonOfNewDrawCard.setPower(tempMonsterCard.getPower());
					} else if (tempCard.getClass() == SpellCard.class) {
						handButtonOfNewDrawCard.setPower(50000);
					} else {
						handButtonOfNewDrawCard.setPower(100000);
					}
					fillHand();
					handButtonOfNewDrawCard.setIcons(handButtonOfNewDrawCard.getImageIconFromCard(tempCard));
				};
			};
			timer.schedule(timerTask, 250);
		}
	}

	public void drawCardOpponent() {
		if (nextCardIndex < 20) {
			new Thread(new OpponentDrawCardAnimation(this.duelFrame)).start();
			Card tempCard = thisHandPanelReference.duelFrame.getOpponentDeck().getDeckArrayList().get(nextCardIndex);
			nextCardIndex++;
			cardsInHand = getCardsInHand() + 1;
			if (nextCardIndex >= 20) {
				this.duelFrame.getOpponentDeckButton().getButton().setIcon(null);
				this.duelFrame.getOpponentDeckButton().setCurrentCardBigCard(null);
			}
			timerTask = new TimerTask() {
				@Override
				public void run() {
					HandPanelButton handButtonOfNewDrawCard = new HandPanelButton(thisHandPanelReference);
					handButtonOfNewDrawCard.setCard(tempCard);
					if (tempCard.getClass() == MonsterCard.class) {
						MonsterCard tempMonsterCard = (MonsterCard) tempCard;
						handButtonOfNewDrawCard.setPower(tempMonsterCard.getPower());
					} else if (tempCard.getClass() == SpellCard.class) {
						handButtonOfNewDrawCard.setPower(50000);
					} else {
						handButtonOfNewDrawCard.setPower(100000);
					}
					fillHand();
					handButtonOfNewDrawCard.setIcons(handButtonOfNewDrawCard.getImageIconFromCard(tempCard));
					handButtonOfNewDrawCard.getButton().setIcon(getDuelFrame().getGeneralIcons().getMiniCoverImageIcon());
					handButtonOfNewDrawCard.getButton().setDisabledIcon(getDuelFrame().getGeneralIcons().getMiniCoverImageIcon());
					handButtonOfNewDrawCard.setCurrentCardBigCard(getDuelFrame().getGeneralIcons().getBigCoverImageIcon());
					handButtonOfNewDrawCard.getButton().setEnabled(false);
				};
			};
			timer.schedule(timerTask, 250);
		}
	}

	/*
	 * Initiate multiple instances of the draw method one after the other.
	 * 
	 * The whole method runs in a separate Thread so it can be put to sleep without
	 * stopping the whole application. Each draw method also runs in a nested
	 * separate Thread.
	 * 
	 * The loops sleeps for 600 milliseconds at the end of every loop to wait for
	 * the draw card animation to be done.
	 */
	public void multipleDraws(int numberOfCards) {
		new Thread() {
			public void run() {
				for (int i = 0; i < numberOfCards; i++) {
					new Thread() {
						public void run() {
							drawCard();
						}
					}.start();
					try {Thread.sleep(600);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}.start();

	}
	
	public void multipleDrawsOpponent(int numberOfCards) {
		new Thread() {
			public void run() {
				for (int i = 0; i < numberOfCards; i++) {
					new Thread() {
						public void run() {
							drawCardOpponent();
						}
					}.start();
					try {Thread.sleep(600);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}.start();

	}


}
