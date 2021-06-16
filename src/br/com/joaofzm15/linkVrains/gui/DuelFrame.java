package br.com.joaofzm15.linkVrains.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.joaofzm15.linkVrains.decks.Deck;
import br.com.joaofzm15.linkVrains.decks.JackAtlasDeck;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.AttackAnimationTest;
import br.com.joaofzm15.linkVrains.gui.buttons.HandPanel;
import br.com.joaofzm15.linkVrains.gui.buttons.MiscFieldButton;
import br.com.joaofzm15.linkVrains.gui.buttons.MonsterFieldButton;
import br.com.joaofzm15.linkVrains.gui.buttons.SpellTrapFieldButton;
import br.com.joaofzm15.linkVrains.gui.imageIcons.GeneralIcons;

public class DuelFrame extends JFrame implements ActionListener {


	private GeneralIcons generalIcons = new GeneralIcons();

	public GeneralIcons getGeneralIcons() {
		return generalIcons;
	}

	private Deck playerDeck;
	public Deck getPlayerDeck() {
		return playerDeck;
	}


	private JFrame frame = new JFrame();

	public JFrame getFrame() {
		return frame;
	}

	private JLabel drawCardAnimationLabel = new JLabel();

	public JLabel getDrawCardAnimationLabel() {
		return drawCardAnimationLabel;
	}

	JLabel attackArrow;

	public JLabel getAttackArrow() {
		return attackArrow;
	}

	HandPanel playerHandPanel;

	HandPanel opponentHandPanel;

	JLabel cardInfo;

	public JLabel getCardInfo() {
		return cardInfo;
	}

	// ================================Test Buttons
	JButton buttonTest2;
	JButton buttonTest3;

	public JLabel labelTesteFire;
	// ================================Test Buttons

	public MonsterFieldButton playerMonsterZone1;
	public MonsterFieldButton playerMonsterZone2;
	public MonsterFieldButton playerMonsterZone3;
	public SpellTrapFieldButton playerSpellZone1;
	public SpellTrapFieldButton playerSpellZone2;
	public SpellTrapFieldButton playerSpellZone3;
	MiscFieldButton playerDeckButton;
	MiscFieldButton playerGy;
	MiscFieldButton playerBanished;
	MiscFieldButton playerExtraDeck;
	MiscFieldButton playerField;

	public MiscFieldButton getPlayerDeckButton() {
		return playerDeckButton;
	}

	public DuelFrame() {
		
		JackAtlasDeck jackAtlasDeck = new JackAtlasDeck();
		playerDeck = jackAtlasDeck;

		frame.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("window backgrounds/boardBackground.jpg"))));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		ImageIcon yusaku = new ImageIcon(StartMenu.class.getResource("yuseiIcon.jpg"));
		frame.setIconImage(yusaku.getImage());
		frame.setTitle("Link Vrains");
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		
		// ================================Test Buttons
		buttonTest2 = new JButton();
		buttonTest2.setBorder(null);
		buttonTest2.addActionListener(this);
		buttonTest2.setBackground(null);
		buttonTest2.setText("Attack");
		buttonTest2.setBounds(500, 500, 100, 100);
		frame.add(buttonTest2);

		buttonTest3 = new JButton();
		buttonTest3.setBorder(null);
		buttonTest3.addActionListener(this);
		buttonTest3.setBackground(null);
		buttonTest3.setText("Draw");
		buttonTest3.setBounds(300, 500, 100, 100);
		frame.add(buttonTest3);
		
		labelTesteFire = new JLabel();
		labelTesteFire.setBounds((int) 910, (int) -390, (int) 1000, (int) 1130.4);
		ImageIcon fire = new ImageIcon(StartMenu.class.getResource("fire.gif"));
		labelTesteFire.setIcon(fire);
		labelTesteFire.setVisible(false);
		frame.add(labelTesteFire);
		// ================================Test Buttons

		//Used solely for the draw card animation.
		drawCardAnimationLabel.setVisible(true);
		frame.add(drawCardAnimationLabel);

		cardInfo = new JLabel();
		cardInfo.setBounds(10, 10, 271, 395);
		cardInfo.setBackground(Color.black);
		cardInfo.setBorder(BorderFactory.createLineBorder(Color.white));
		cardInfo.setIcon(generalIcons.getBigCoverImageIcon());
		frame.add(cardInfo);
		
		attackArrow = new JLabel();
		attackArrow.setBounds(0, 0, 1280, 720);
		ImageIcon arrowImage = new ImageIcon(StartMenu.class.getResource("testeSeta.png"));
		attackArrow.setIcon(arrowImage);
		attackArrow.setVisible(false);
		frame.add(attackArrow);

		//player
		// Hand Panel
		playerHandPanel = new HandPanel(this, 760, 600, 410, (int) 113.4);

		// monster zones
		// 1
		playerMonsterZone1 = new MonsterFieldButton(this, (int) 813.2, 350);
		MonsterFieldButton playerMonsterZone1Defense = new MonsterFieldButton(this, (int) 795.38, (int) 367.82);
		playerMonsterZone1Defense.switchXandY();
		playerMonsterZone1Defense.getButton().setVisible(false);

		// 2
		playerMonsterZone2 = new MonsterFieldButton(this, (int) 926.6, 350);
		MonsterFieldButton playerMonsterZone2Defense = new MonsterFieldButton(this, (int) 908.78, (int) 367.82);
		playerMonsterZone2Defense.switchXandY();
		playerMonsterZone2Defense.getButton().setVisible(false);
//		playerMonsterZone2.setIcons(playerMonsterZone1.getImageIconFromCard(getPlayerDeck().getDeckList().get(7)));
		// 3
		playerMonsterZone3 = new MonsterFieldButton(this, (int) 1040, 350);
		MonsterFieldButton playerMonsterZone3Defense = new MonsterFieldButton(this, (int) 1022.18, (int) 367.82);
		playerMonsterZone3Defense.switchXandY();
		playerMonsterZone3Defense.getButton().setVisible(false);
		// spell zones
		// 1
		playerSpellZone1 = new SpellTrapFieldButton(this, (int) 813.2, 480);
		// 2
		playerSpellZone2 = new SpellTrapFieldButton(this, (int) 926.6, 480);
		// 3
		playerSpellZone3 = new SpellTrapFieldButton(this, (int) 1040, 480);
		// other zones
		// Deck
		playerDeckButton = new MiscFieldButton(this, (int) 1180, 580);
		getPlayerDeckButton().setIcons(generalIcons.getCoverImageIcon());
		// GY
		playerGy = new MiscFieldButton(this, (int) 1180, 450);
		// Banished
		playerBanished = new MiscFieldButton(this, (int) 1180, 320);
		// ExtraDeck
		playerExtraDeck = new MiscFieldButton(this, (int) 673.2, 580);
		playerExtraDeck.setIcons(generalIcons.getCoverImageIcon());
		// Field
		playerField = new MiscFieldButton(this, (int) 673.2, 450);

		// opponent
		// Hand Panel
		opponentHandPanel = new HandPanel(this, 760, (int) 7.6, 410, (int) 75.4);
		// monster zones
		// 1
		MonsterFieldButton opponentMonsterZone1 = new MonsterFieldButton(this, (int) 1040, (int) 220.8);
		opponentMonsterZone1.getButton().setBackground(Color.yellow);
		// 2
		MonsterFieldButton opponentMonsterZone2 = new MonsterFieldButton(this, (int) 926.6, (int) 220.8);
		opponentMonsterZone2.getButton().setBackground(Color.yellow);
		// 3
		MonsterFieldButton opponentMonsterZone3 = new MonsterFieldButton(this, (int) 813.2, (int) 220.8);
		opponentMonsterZone3.getButton().setBackground(Color.yellow);
		// spell zones
		// 1
		SpellTrapFieldButton opponentSpellZone1 = new SpellTrapFieldButton(this, (int) 1040, (int) 90.8);
		opponentSpellZone1.getButton().setBackground(Color.yellow);
		// 2
		SpellTrapFieldButton opponentSpellZone2 = new SpellTrapFieldButton(this, (int) 926.6, (int) 90.8);
		opponentSpellZone2.getButton().setBackground(Color.yellow);
		// 3
		SpellTrapFieldButton opponentSpellZone3 = new SpellTrapFieldButton(this, (int) 813.2, (int) 90.8);
		opponentSpellZone3.getButton().setBackground(Color.yellow);
		// other zones
		// Deck
		MiscFieldButton opponentDeck = new MiscFieldButton(this, (int) 673.2, (int) 26.6);
		opponentDeck.getButton().setBackground(Color.yellow);
		opponentDeck.setIcons(generalIcons.getCoverImageIcon());
		// GY
		MiscFieldButton opponentGy = new MiscFieldButton(this, (int) 673.2, (int) 156.6);
		opponentGy.getButton().setBackground(Color.yellow);
		// Banished
		MiscFieldButton opponentBanished = new MiscFieldButton(this, (int) 673.2, (int) 286.6);
		opponentBanished.getButton().setBackground(Color.yellow);
		// ExtraDeck
		MiscFieldButton opponentExtraDeck = new MiscFieldButton(this, (int) 1180, (int) 26.6);
		opponentExtraDeck.setIcons(generalIcons.getCoverImageIcon());
		opponentExtraDeck.getButton().setBackground(Color.yellow);
		// Field
		MiscFieldButton opponentField = new MiscFieldButton(this, (int) 1180, (int) 156.6);
		opponentField.getButton().setBackground(Color.yellow);


		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonTest3) {
			playerHandPanel.drawCard();
		}	
		if (e.getSource() == buttonTest2) {
			new Thread(new AttackAnimationTest(this)).start();
			try {Thread.sleep(100);} catch (InterruptedException ex) {ex.printStackTrace();}
		}	
	}


}
