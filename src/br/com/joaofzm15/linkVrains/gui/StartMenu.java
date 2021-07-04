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

public class StartMenu extends JFrame implements ActionListener {
	
	private JFrame frame;
	private JButton startButton;
	private JButton optionsButton;
	private JLabel loading;
	private JButton exitButton;

	public StartMenu() {

		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("window backgrounds/mainMenuBackground.jpg"))));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		ImageIcon windowIcon = new ImageIcon(getClass().getClassLoader().getResource("window icon/windowIcon.jpg"));
		frame.setIconImage(windowIcon.getImage());
		frame.setTitle("Link Vrains");
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);

		/*
		 * The loading label is used to sign the user the game is loading after you
		 * click play, since it'll take a few seconds for the duel frame to fully load
		 * and pop on screen. It's invisible by default, and will be set to visible once
		 * the user clicks the "startButton".
		 */
		loading = new JLabel();
		loading.setBounds(540, 320, 300, 100);
		loading.setFont(new Font("Impact", Font.PLAIN, 45));
		loading.setForeground(Color.white);
		loading.setText("Loading....");
		loading.setBackground(Color.BLACK);
		loading.setVisible(false);
		frame.add(loading);

		startButton = new JButton();
		startButton.setBounds(505, 430, 250, 50);
		startButton.addActionListener(this);
		startButton.setText("P L A Y");
		startButton.setFont(new Font("Impact",Font.BOLD, 22));
		startButton.setForeground(Color.white);
		startButton.setBackground(new Color(255, 105, 0));
		startButton.setBorder(BorderFactory.createLineBorder(Color.white));
		startButton.setFocusable(false);
		frame.add(startButton);
		
		optionsButton = new JButton();
		optionsButton.setBounds(530, 530, 200, 50);
		optionsButton.addActionListener(this);
		optionsButton.setText("O P T I O N S");
		optionsButton.setFont(new Font("Impact",Font.BOLD, 22));
		optionsButton.setForeground(Color.white);
		optionsButton.setBackground(new Color(255, 175, 0));
		optionsButton.setBorder(BorderFactory.createLineBorder(Color.white));
		optionsButton.setFocusable(false);
		frame.add(optionsButton);

		exitButton = new JButton();
		exitButton.setBounds(555, 630, 150, 50);
		exitButton.addActionListener(this);
		exitButton.setText("E X I T");
		exitButton.setFont(new Font("Impact",Font.BOLD, 22));
		exitButton.setForeground(Color.white);
		exitButton.setBackground(new Color(255, 105, 0));
		exitButton.setBorder(BorderFactory.createLineBorder(Color.white));
		exitButton.setFocusable(false);
		frame.add(exitButton);

		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new Thread(new ClickSound()).start();

		/*
		 * The game has to load on a separate thread, otherwise the StartMenu frame
		 * would freeze and the LOADING message wouldn't appear on screen while the game
		 * is loading.
		 */
		if (e.getSource() == startButton) {
			loading.setVisible(true);
			startButton.setEnabled(false);
			optionsButton.setEnabled(false);
			exitButton.setEnabled(false);
			new Thread() {
				public void run() {
					new DuelFrame();
					frame.dispose();
				}
			}.start();
		}

		if (e.getSource() == optionsButton) {
			frame.dispose();
			new OptionsMenu();
		}

		if (e.getSource() == exitButton) {
			try {Thread.sleep(900);} catch (InterruptedException e1) {e1.printStackTrace();}
			System.exit(0);
		}		

	}
	
}



