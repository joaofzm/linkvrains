package br.com.joaofzm15.linkVrains.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.ClickSound;

public class OptionsMenu extends JFrame implements ActionListener {
	
	private JFrame frame;
	private JLabel loading;
	private JButton returnButton;

	public OptionsMenu() {

		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("window backgrounds/optionsBackground.jpg"))));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		ImageIcon yusaku = new ImageIcon(OptionsMenu.class.getResource("yuseiIcon.jpg"));
		frame.setIconImage(yusaku.getImage());
		frame.setTitle("Link Vrains");
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);

		loading = new JLabel();
		loading.setBounds(540, 310, 300, 100);
		loading.setFont(new Font("Arial", Font.PLAIN, 45));
		loading.setForeground(Color.white);
		loading.setText("Loading....");
		loading.setBackground(Color.BLACK);
		loading.setVisible(false);
		frame.add(loading);

		returnButton = new JButton();
		returnButton.setBounds(555, 630, 150, 50);
		returnButton.addActionListener(this);
		returnButton.setText("R E T U R N");
		returnButton.setFont(new Font("Impact", Font.BOLD, 22));
		returnButton.setForeground(Color.white);
		returnButton.setBackground(new Color(255, 105, 0));
		returnButton.setBorder(BorderFactory.createLineBorder(Color.white));
		returnButton.setFocusable(false);
		frame.add(returnButton);

		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new Thread(new ClickSound()).start();

		if (e.getSource() == returnButton) {
			frame.dispose();
			new StartMenu();
		}		
	}
	
}



