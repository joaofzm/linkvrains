package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class PlayerMonsterFieldButton extends FieldButton {

	JButton powerButton;
	public JButton getPowerButton() {
		return powerButton;
	}

	private AttackButton attackButton;
	public AttackButton getAttackButton() {
		return attackButton;
	}

	private boolean attackedThisTurn;

	public boolean hasAttackedThisTurn() {
		return attackedThisTurn;
	}

	public void setAttackedThisTurn(boolean attackedThisTurn) {
		this.attackedThisTurn = attackedThisTurn;
	}


	private int power;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
		powerButton.setText(String.valueOf(power));
	}

	public PlayerMonsterFieldButton(DuelFrame duelFrame, int xPos, int yPos) {
		super(duelFrame, xPos, yPos);
		this.button.setLayout(new GridLayout(4, 0));
		this.attackButton = new AttackButton(this);

		powerButton = new JButton();
		powerButton.setBackground(Color.red);
		powerButton.setBounds(0, 0, 25, 25);
		powerButton.setEnabled(false);
		powerButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 250)));
		powerButton.setFont(new Font("Impact", Font.PLAIN, 22));
		powerButton.setForeground(Color.red);
		powerButton.setVisible(true);
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getButton()) {
			this.getDuelFrame().getPlayerMonsterZone1().removeAttackButton();
			this.getDuelFrame().getPlayerMonsterZone2().removeAttackButton();
			this.getDuelFrame().getPlayerMonsterZone3().removeAttackButton();
			this.getDuelFrame().getPlayerMonsterZone1().getButton().requestFocus();
			this.getDuelFrame().getPlayerMonsterZone2().getButton().requestFocus();
			this.getDuelFrame().getPlayerMonsterZone3().getButton().requestFocus();

			if (this.isOccupied() && !this.attackedThisTurn) {
				this.getButton().add(attackButton.getButton());
			}

			new Thread(new FixButtonLayoutThread(this.getDuelFrame())).start();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	public void removeAttackButton() {
		this.getButton().remove(attackButton.getButton());
	}

}
