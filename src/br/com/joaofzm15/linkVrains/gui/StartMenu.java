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
		ImageIcon yusaku = new ImageIcon(StartMenu.class.getResource("yuseiIcon.jpg"));
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

		} else if (e.getSource()==optionsButton) {
			frame.dispose();
			new OptionsMenu();


		} else if(e.getSource()==exitButton) {
			try {Thread.sleep(900);} catch (InterruptedException e1) {e1.printStackTrace();}
			System.exit(0);
		}		
	}
	
}



