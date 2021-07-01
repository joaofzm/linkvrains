package br.com.joaofzm15.linkVrains.gui.attackArrows;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class Arrow {

	DuelFrame duelFrame;

	public DuelFrame getDuelFrame() {
		return duelFrame;
	}

	JLabel arrowLabel;
	public JLabel getArrowLabel() {
		return arrowLabel;
	}

	public Arrow(DuelFrame duelFrame, String path) {
		this.duelFrame = duelFrame;
		arrowLabel = new JLabel();
		arrowLabel.setBounds(0, 0, 1280, 720);
		ImageIcon arrowImage = new ImageIcon(path);
		arrowLabel.setIcon(arrowImage);
		arrowLabel.setVisible(false);
		duelFrame.getFrame().add(arrowLabel);
	}

}
