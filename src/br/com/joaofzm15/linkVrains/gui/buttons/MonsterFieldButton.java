package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.event.ActionEvent;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class MonsterFieldButton extends FieldButton {

	private int atk;
	private int def;

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void switchXandY() {
		this.getButton().setSize((int) 113.4, (int) 77.76);
	}

	public MonsterFieldButton(DuelFrame duelFrame, int xPos, int yPos) {
		super(duelFrame, xPos, yPos);
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getButton()) {
			System.out.println("Botão clickado");
		}
	}



}
