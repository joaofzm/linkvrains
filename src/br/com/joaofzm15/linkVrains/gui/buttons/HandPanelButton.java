package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.com.joaofzm15.linkVrains.cards.Card;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class HandPanelButton extends CardButton implements ActionListener, MouseListener {

	private SummonButton summonButton;
	private ActivateButton activateButton;
	private PlaceButton placeButton;
	
	private Card card;
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}

	private int power;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	/*
	 * All the cards on hand are represented by this class button.
	 * 
	 * While this class is called HandPanelButton, it's not a button and only
	 * contains a button, as well as other properties. The button must be accessed
	 * with "fieldButton.getButton()".
	 * 
	 * The buttons must be part of a HandPanel, and one is required as a parameter
	 * in the constructor.
	 */

	private HandPanel handPanel;
	public HandPanel getHandPanel() {
		return handPanel;
	}


	/*
	 * The constructor will automatically add the button to the HandPanel passed as
	 * a parameter.
	 */
	public HandPanelButton(HandPanel handPanel) {
		super();
		this.handPanel = handPanel;
		this.button.setLayout(new GridLayout(4, 0));
		this.button.setBorder(null);
		this.button.setBackground(null);
		this.button.addActionListener(this);
		this.button.addMouseListener(this);
		this.getHandPanel().getPanel().add(this.button);

		this.summonButton = new SummonButton(this);
		this.activateButton = new ActivateButton(this);
		this.placeButton = new PlaceButton(this);

		handPanel.getButtonList().add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < handPanel.getButtonList().size(); i++) {
			handPanel.getButtonList().get(i).removeSummonAndSetButtons();
			handPanel.getButtonList().get(i).removeSummonAndSetButtons();
			handPanel.getButtonList().get(i).getButton().requestFocus();
		}
		if (this.getPower() >= 0 && this.getPower() < 50000) {
			this.getButton().add(summonButton.getButton());
		} else if (this.getPower() < 100000) {
			this.getButton().add(activateButton.getButton());
		} else {
			this.getButton().add(placeButton.getButton());
		}
		new Thread(new FixButtonLayoutThread(this.getHandPanel().getDuelFrame())).start();

	}

	/*
	 * As the mouse enters the button, the big card stored in this class will update
	 * the icon of the cardInfo label(from DuelFrame).
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.currentCardBigCard != null) {
			this.getHandPanel().getDuelFrame().getCardInfo().setIcon(this.getCurrentCardBigCard());
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	public void removeSummonAndSetButtons() {
		this.getButton().remove(summonButton.getButton());
		this.getButton().remove(activateButton.getButton());
		this.getButton().remove(placeButton.getButton());
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
