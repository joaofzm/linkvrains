package br.com.joaofzm15.linkVrains.gui.buttons;

import javax.swing.JButton;

public class HandPanelFillerButton {

	private HandPanel handPanel;
	public HandPanel getHandPanel() {
		return handPanel;
	}

	private JButton button;
	public JButton getButton() {
		return button;
	}

	public HandPanelFillerButton(HandPanel handPanel) {
		this.handPanel = handPanel;
		this.button = new JButton();
		this.button.setBorder(null);
		this.button.setBackground(null);
		this.button.setEnabled(false);
		this.getHandPanel().getPanel().add(button);
	}

}
