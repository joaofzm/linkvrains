package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.DirectAttackAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class AttackButton implements ActionListener, MouseListener {

	PlayerMonsterFieldButton monsterFieldButton;

	public PlayerMonsterFieldButton getMonsterFieldButton() {
		return monsterFieldButton;
	}

	protected JButton button;

	public JButton getButton() {
		return button;
	}

	public AttackButton(PlayerMonsterFieldButton monsterFieldButton) {
		this.monsterFieldButton = monsterFieldButton;
		this.button = new JButton();
		this.button.setBounds(1, 1, 50, 15);
		this.button.setText("Attack");
		this.button.setBorder(BorderFactory.createLineBorder(Color.blue));
		this.button.setForeground(Color.blue);
		this.button.setFocusable(false);
		this.button.setBackground(new Color(255, 104, 0));
		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().isOccupied()
				|| this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().isOccupied()
				|| this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().isOccupied()) {
			
				
			if (this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().isOccupied()) {
				this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().getButton().add(this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().getAttacTargetkButton().getButton());
			}
			
			if (this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().isOccupied()) {
				this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().getButton().add(this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().getAttacTargetkButton().getButton());
			}
			
			if (this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().isOccupied()) {
				this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().getButton().add(this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().getAttacTargetkButton().getButton());
			}
			
	
			if (this.getMonsterFieldButton() == this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone1()) {
				AttackTargetButton.playerMonsterButtonThatClickedTheAttackButton = this.getMonsterFieldButton()
						.getDuelFrame().getPlayerMonsterZone1();
				
			} else if (this.getMonsterFieldButton() == this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone2()) {
				AttackTargetButton.playerMonsterButtonThatClickedTheAttackButton = this.getMonsterFieldButton()
						.getDuelFrame().getPlayerMonsterZone2();
				
			} else if (this.getMonsterFieldButton() == this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone3()) {
				AttackTargetButton.playerMonsterButtonThatClickedTheAttackButton = this.getMonsterFieldButton()
						.getDuelFrame().getPlayerMonsterZone3();
			}
			
			this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().getButton().requestFocus();
			this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().getButton().requestFocus();
			this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().getButton().requestFocus();
			new Thread(new FixButtonLayoutThread(this.getMonsterFieldButton().getDuelFrame())).start();

		} else {
			
			this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone1().removeAttackButton();
			this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone2().removeAttackButton();
			this.getMonsterFieldButton().getDuelFrame().getPlayerMonsterZone3().removeAttackButton();
			this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone1().removeAttackTargetButton();
			this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone2().removeAttackTargetButton();
			this.getMonsterFieldButton().getDuelFrame().getOpponentMonsterZone3().removeAttackTargetButton();

			this.getMonsterFieldButton().setAttackedThisTurn(true);

			new Thread(new FixButtonLayoutThread(this.getMonsterFieldButton().getDuelFrame())).start();
			
			new Thread(new DirectAttackAnimation(this.getMonsterFieldButton().getDuelFrame(), this.getMonsterFieldButton().getButton())).start();

			// Damage Calculation
			new Thread() {
				public void run() {
					try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
					getMonsterFieldButton().getDuelFrame().setOpponentHp(getMonsterFieldButton().getDuelFrame().getOpponentHp()-getMonsterFieldButton().getPower());
				}
			}.start();

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
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
