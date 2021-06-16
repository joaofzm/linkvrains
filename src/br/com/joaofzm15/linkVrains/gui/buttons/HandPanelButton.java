package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.cards.Card;

public class HandPanelButton implements ActionListener, MouseListener {

	private HandPanel handPanel;
	public HandPanel getHandPanel() {
		return handPanel;
	}

	private JButton button;
	public JButton getButton() {
		return button;
	}
	
	private ImageIcon currentCardBigCard;

	public ImageIcon getImageIconFromCard(Card card) {
		ImageIcon temporaryImageIcon = new ImageIcon(
				getClass().getClassLoader().getResource("cards/" + card.getIconCode() + ".jpg"));
		return temporaryImageIcon;
	}

	public void setIcons(ImageIcon imageIcon) {
		Image temporaryOriginalImage = imageIcon.getImage();
		Image temporaryBigImage = temporaryOriginalImage.getScaledInstance((int) 271, (int) 395,java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedBigImageIcon = new ImageIcon(temporaryBigImage);
		this.currentCardBigCard = resizedBigImageIcon;
		
		Image temporaryMiniImage = temporaryOriginalImage.getScaledInstance((int) 77.6, (int) 113.4,java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedMiniImageIcon = new ImageIcon(temporaryMiniImage);
		this.getButton().setIcon(resizedMiniImageIcon);
	}

	public HandPanelButton(HandPanel handPanel) {
		this.handPanel = handPanel;
		this.button = new JButton();
		this.button.setBorder(null);
		this.button.setBackground(null);
		this.button.addActionListener(this);
		this.button.addMouseListener(this);
		this.getHandPanel().getPanel().add(this.button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getButton()) {
			System.out.println("Botão clickado");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.currentCardBigCard != null) {
			this.getHandPanel().getDuelFrame().getCardInfo().setIcon(this.currentCardBigCard);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
