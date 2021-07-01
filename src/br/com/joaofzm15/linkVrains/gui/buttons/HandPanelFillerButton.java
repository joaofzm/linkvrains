package br.com.joaofzm15.linkVrains.gui.buttons;

import javax.swing.JButton;

public class HandPanelFillerButton {

	/*
	 * Used by the the HandPanel to fill the panel and make it always have at least
	 * 5 buttons (or none).
	 * 
	 * For more details check the "fillHand" comments. (from the HandPanel class).
	 */

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
