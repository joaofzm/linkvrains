package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public abstract class FieldButton extends CardButton implements ActionListener, MouseListener {

	/*
	 * All the slots that make the field are instances of this class.
	 * 
	 * While this class is called FieldButton, it's not a button and only contains a
	 * button, as well as other properties. The button must be accessed with
	 * "fieldButton.getButton()".
	 */

	/*
	 * The buttons must be part of a duelFrame, and one is required as a parameter
	 * in the constructor.
	 */
	private DuelFrame duelFrame;
	public DuelFrame getDuelFrame() {
		return duelFrame;
	}

	private boolean occupied;
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	/*
	 * The constructor will automatically add the button to the DueLFrame passed as
	 * a parameter.
	 */
	public FieldButton(DuelFrame duelFrame, int xPos, int yPos) {
		super();
		this.duelFrame = duelFrame;
		this.button.setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
		this.button.setBackground(Color.black);
		this.button.setBorder(BorderFactory.createLineBorder(Color.white));
		this.button.addActionListener(this);
		this.button.addMouseListener(this);
		this.button.setVisible(true);
		this.duelFrame.getFrame().add(button);
	}

	
	
	/*
	 * As the mouse enters the button, the big card stored in this class will update
	 * the icon of the cardInfo label(from DuelFrame).
	 */
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

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}

