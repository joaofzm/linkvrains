package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.AttackAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class AttackTargetButton implements ActionListener, MouseListener {
	
	public static PlayerMonsterFieldButton playerMonsterButtonThatClickedTheAttackButton;

	OpponentMonsterFieldButton monsterFieldButton;
	public OpponentMonsterFieldButton getMonsterFieldButton() {
		return monsterFieldButton;
	}

	protected JButton button;

	public JButton getButton() {
		return button;
	}

	public AttackTargetButton(OpponentMonsterFieldButton monsterFieldButton) {
		this.monsterFieldButton = monsterFieldButton;
		this.button = new JButton();
		this.button.setBounds(1, 1, 50, 15);
		this.button.setText("Target");
		this.button.setBorder(BorderFactory.createLineBorder(Color.blue));
		this.button.setForeground(Color.blue);
		this.button.setFocusable(false);
		this.button.setBackground(new Color(255, 104, 0));
		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.getMonsterFieldButton() == this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1()) {
			new Thread(new AttackAnimation(this.getMonsterFieldButton().getDuelFrame(),	playerMonsterButtonThatClickedTheAttackButton.getButton(), 1)).start();
			new Thread() {
				public void run() {
					try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
					
					if (playerMonsterButtonThatClickedTheAttackButton.getPower() > getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().getPower()) {
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().setOccupied(false);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().getButton().setIcon(null);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().removePowerButton();
					} else if (playerMonsterButtonThatClickedTheAttackButton.getPower() < getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().getPower()) {
						playerMonsterButtonThatClickedTheAttackButton.setOccupied(false);
						playerMonsterButtonThatClickedTheAttackButton.getButton().setIcon(null);
						playerMonsterButtonThatClickedTheAttackButton.removePowerButton();
					} else {
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().setOccupied(false);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().getButton().setIcon(null);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().removePowerButton();
						playerMonsterButtonThatClickedTheAttackButton.setOccupied(false);
						playerMonsterButtonThatClickedTheAttackButton.getButton().setIcon(null);
						playerMonsterButtonThatClickedTheAttackButton.removePowerButton();
					}
				}
			}.start();

			
			
		} else if (this.getMonsterFieldButton() == this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2()) {
			new Thread(new AttackAnimation(this.getMonsterFieldButton().getDuelFrame(),	playerMonsterButtonThatClickedTheAttackButton.getButton(), 2)).start();
			new Thread() {
				public void run() {
					try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
					
					if (playerMonsterButtonThatClickedTheAttackButton.getPower() > getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().getPower()) {
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().setOccupied(false);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().getButton().setIcon(null);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().removePowerButton();
					} else if (playerMonsterButtonThatClickedTheAttackButton.getPower() < getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().getPower()) {
						playerMonsterButtonThatClickedTheAttackButton.setOccupied(false);
						playerMonsterButtonThatClickedTheAttackButton.getButton().setIcon(null);
						playerMonsterButtonThatClickedTheAttackButton.removePowerButton();
					} else {
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().setOccupied(false);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().getButton().setIcon(null);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().removePowerButton();
						playerMonsterButtonThatClickedTheAttackButton.setOccupied(false);
						playerMonsterButtonThatClickedTheAttackButton.getButton().setIcon(null);
						playerMonsterButtonThatClickedTheAttackButton.removePowerButton();
					}
				}
			}.start();

		} else if (this.getMonsterFieldButton() == this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3()) {
			new Thread() {
				public void run() {
					try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
					
					if (playerMonsterButtonThatClickedTheAttackButton.getPower() > getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().getPower()) {
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().setOccupied(false);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().getButton().setIcon(null);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().removePowerButton();
					} else if (playerMonsterButtonThatClickedTheAttackButton.getPower() < getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().getPower()) {
						playerMonsterButtonThatClickedTheAttackButton.setOccupied(false);
						playerMonsterButtonThatClickedTheAttackButton.getButton().setIcon(null);
						playerMonsterButtonThatClickedTheAttackButton.removePowerButton();
					} else {
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().setOccupied(false);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().getButton().setIcon(null);
						getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().removePowerButton();
						playerMonsterButtonThatClickedTheAttackButton.setOccupied(false);
						playerMonsterButtonThatClickedTheAttackButton.getButton().setIcon(null);
						playerMonsterButtonThatClickedTheAttackButton.removePowerButton();
					}
				}
			}.start();
			
			new Thread(new AttackAnimation(this.getMonsterFieldButton().getDuelFrame(),	playerMonsterButtonThatClickedTheAttackButton.getButton(), 3)).start();
			
		}

		playerMonsterButtonThatClickedTheAttackButton.setAttackedThisTurn(true);

		this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone1().removeAttackButton();
		this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone2().removeAttackButton();
		this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone3().removeAttackButton();
		this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().removeAttackTargetButton();
		this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().removeAttackTargetButton();
		this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().removeAttackTargetButton();

		new Thread(new FixButtonLayoutThread(this.getMonsterFieldButton().getDuelFrame())).start();

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
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
