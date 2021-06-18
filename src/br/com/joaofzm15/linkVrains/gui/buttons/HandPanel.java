package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.joaofzm15.linkVrains.cards.Card;
import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.DrawCardAnimation;

public class HandPanel {
	
	int nextCardIndex;

	private DuelFrame duelFrame;
	public DuelFrame getDuelFrame() {
		return duelFrame;
	}

	private JPanel panel;
	public JPanel getPanel() {
		return panel;
	}

	int cardsInHand;

	Timer timer;
	TimerTask timerTask;
	HandPanelFillerButton fillerButton1;
	HandPanelFillerButton fillerButton2;
	HandPanelFillerButton fillerButton3;
	HandPanelFillerButton fillerButton4;

	HandPanel thisHandPanelReference;

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

	public void fillHand() {
		removeButton(fillerButton1.getButton());
		removeButton(fillerButton2.getButton());
		removeButton(fillerButton3.getButton());
		removeButton(fillerButton4.getButton());
		if (cardsInHand == 1) {
			getPanel().add(fillerButton1.getButton());
			getPanel().add(fillerButton2.getButton());
			getPanel().add(fillerButton3.getButton());
			getPanel().add(fillerButton4.getButton());
		} else if (cardsInHand == 2) {
			getPanel().add(fillerButton1.getButton());
			getPanel().add(fillerButton2.getButton());
			getPanel().add(fillerButton3.getButton());
		} else if (cardsInHand == 3) {
			getPanel().add(fillerButton1.getButton());
			getPanel().add(fillerButton2.getButton());
		} else if (cardsInHand == 4) {
			getPanel().add(fillerButton1.getButton());
		}

	}

	public void removeButton(JButton button) {
		this.getPanel().remove(button);
	}

	public void drawCard() {
		if (nextCardIndex < 20) {
			new Thread(new DrawCardAnimation(this.duelFrame)).start();
			Card tempCard = thisHandPanelReference.duelFrame.getPlayerDeck().getDeckList().get(nextCardIndex);
			nextCardIndex++;
			cardsInHand++;
			if (nextCardIndex >= 20) {
				this.duelFrame.getPlayerDeckButton().getButton().setIcon(null);
				this.duelFrame.getPlayerDeckButton().setCurrentCardBigCard(null);
			}

			timerTask = new TimerTask() {
				@Override
				public void run() {
					HandPanelButton handCard = new HandPanelButton(thisHandPanelReference);
					fillHand();
					handCard.setIcons(handCard.getImageIconFromCard(tempCard));
				};
			};

			timer.schedule(timerTask, 250);
		}
	}

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

}
