package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class OpponentMonsterFieldButton extends FieldButton {

	private AttackTargetButton attackTargetButton;

	public AttackTargetButton getAttacTargetkButton() {
		return attackTargetButton;
	}

	private boolean attackedThisTurn;

	public boolean hasAttackedThisTurn() {
		return attackedThisTurn;
	}

	public void setAttackedThisTurn(boolean attackedThisTurn) {
		this.attackedThisTurn = attackedThisTurn;
	}

	JButton powerButton;

	public JButton getPowerButton() {
		return powerButton;
	}

	private int power;
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

	public OpponentMonsterFieldButton(DuelFrame duelFrame, int xPos, int yPos) {
		super(duelFrame, xPos, yPos);
		this.button.setLayout(new GridLayout(4, 0));
		this.attackTargetButton = new AttackTargetButton(this);

		powerButton = new JButton();
		powerButton.setBackground(Color.red);
		powerButton.setBounds(0, 0, 25, 25);
		powerButton.setEnabled(false);
		powerButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 250)));
		powerButton.setFont(new Font("Impact", Font.PLAIN, 22));
		powerButton.setForeground(Color.red);
		powerButton.setVisible(true);
	}

	public void removeAttackTargetButton() {
		this.getButton().remove(attackTargetButton.getButton());
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getButton()) {

		}
	}

}
