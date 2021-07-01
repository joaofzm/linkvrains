package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.cards.Card;

public abstract class CardButton implements ActionListener, MouseListener {

	protected JButton button;
	public JButton getButton() {
		return button;
	}
	
	/*
	 * This class stores its current Card image in this ImageIcon. This is necessary
	 * as just resizing its icon to a much bigger size to match the "cardInfo" label
	 * from the DuelFrame would result in a blurry image.
	 * 
	 * The "setIcons" method is responsible for both setting the actual button Icon
	 * and this variable.
	 * 
	 * This variable is passed at the "MouseEntered" mouse event (from the
	 * MouseListener interface), and reaches the "cardInfo" label where it's set as
	 * a Icon.
	 */
	protected ImageIcon currentCardBigCard;

	public ImageIcon getCurrentCardBigCard() {
		return currentCardBigCard;
	}
	public void setCurrentCardBigCard(ImageIcon currentCardBigCard) {
		this.currentCardBigCard = currentCardBigCard;
	}
	

	public CardButton() {
		this.button = new JButton();
	}


	public ImageIcon getImageIconFromCard(Card card) {
		ImageIcon temporaryImageIcon = new ImageIcon(getClass().getClassLoader().getResource("cards/"+card.getIconCode()+".jpg"));
		return temporaryImageIcon;
	}

	/*
	 * Sets both this class's button icon, and the currentCardBigCard that stores a
	 * bigger version of that same icon.
	 */
	public void setIcons(ImageIcon imageIcon) {
		Image temporaryOriginalImage = imageIcon.getImage();

		Image temporaryBigImage = temporaryOriginalImage.getScaledInstance((int) 271, (int) 395, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedBigImageIcon = new ImageIcon(temporaryBigImage);
		this.setCurrentCardBigCard(resizedBigImageIcon);

		Image temporaryMiniImage = temporaryOriginalImage.getScaledInstance((int) 77.6, (int) 113.4, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedMiniImageIcon = new ImageIcon(temporaryMiniImage);
		this.getButton().setIcon(resizedMiniImageIcon);
		this.getButton().setDisabledIcon(resizedMiniImageIcon);
	}

}
