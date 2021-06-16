package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.event.ActionEvent;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class SpellTrapFieldButton extends FieldButton {


	public SpellTrapFieldButton(DuelFrame duelFrame, int xPos, int yPos) {
		super(duelFrame, xPos, yPos);
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getButton()) {
		}
	}

}
