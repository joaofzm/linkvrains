package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.cards.Card;
import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public abstract class FieldButton implements ActionListener, MouseListener {

	private DuelFrame duelFrame;
	public DuelFrame getDuelFrame() {
		return duelFrame;
	}

	private JButton button;
	public JButton getButton() {
		return button;
	}

	private ImageIcon currentCardBigCard;
	public ImageIcon getCurrentCardBigCard() {
		return currentCardBigCard;
	}
	public void setCurrentCardBigCard(ImageIcon currentCardBigCard) {
		this.currentCardBigCard = currentCardBigCard;
	}


	boolean occupied;

	public ImageIcon getImageIconFromCard(Card card) {
		ImageIcon temporaryImageIcon = new ImageIcon(getClass().getClassLoader().getResource("cards/"+card.getIconCode()+".jpg"));
		return temporaryImageIcon;
	}

	public void setIcons(ImageIcon imageIcon) {
		Image temporaryOriginalImage = imageIcon.getImage();
		Image temporaryBigImage = temporaryOriginalImage.getScaledInstance((int) 271, (int) 395,java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedBigImageIcon = new ImageIcon(temporaryBigImage);
		this.setCurrentCardBigCard(resizedBigImageIcon);
		
		Image temporaryMiniImage = temporaryOriginalImage.getScaledInstance((int) 77.6, (int) 113.4,java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedMiniImageIcon = new ImageIcon(temporaryMiniImage);
		this.getButton().setIcon(resizedMiniImageIcon);
	}

	public FieldButton(DuelFrame duelFrame, int xPos, int yPos) {
		this.button = new JButton();
		this.duelFrame = duelFrame;
		this.button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
		this.button.setBackground(Color.black);
		this.button.setBorder(BorderFactory.createLineBorder(Color.white));
		this.button.addActionListener(this);
		this.button.addMouseListener(this);
		this.button.setVisible(true);
		this.duelFrame.getFrame().add(button);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.getCurrentCardBigCard() != null) {
			this.getDuelFrame().getCardInfo().setIcon(this.getCurrentCardBigCard());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

