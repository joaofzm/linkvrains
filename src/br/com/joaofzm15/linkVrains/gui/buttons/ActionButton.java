package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public abstract class ActionButton implements ActionListener {

	HandPanelButton handPanelButton;

	public HandPanelButton getHandPanelButton() {
		return handPanelButton;
	}

	protected JButton button;

	public JButton getButton() {
		return button;
	}

	public ActionButton(HandPanelButton handPanelButton) {
		this.handPanelButton = handPanelButton;
		this.button = new JButton();
		this.button.setBounds(1, 1, 50, 15);
		this.button.setBorder(BorderFactory.createLineBorder(Color.blue));
		this.button.setForeground(Color.blue);
		this.button.setFocusable(false);
		this.button.setBackground(new Color(255, 104, 0));
		this.button.addActionListener(this);
	}


}
