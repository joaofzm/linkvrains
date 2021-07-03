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

import br.com.joaofzm15.linkVrains.ai.AiActions;
import br.com.joaofzm15.linkVrains.ai.AiTurns;
import br.com.joaofzm15.linkVrains.decks.OpponentDeck;
import br.com.joaofzm15.linkVrains.decks.PlayerDeck;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.ClickSound;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.DefeatSound;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.RoundPassTextAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.VictorySound;
import br.com.joaofzm15.linkVrains.gui.attackArrows.Arrow;
import br.com.joaofzm15.linkVrains.gui.buttons.HandPanel;
import br.com.joaofzm15.linkVrains.gui.buttons.MiscFieldButton;
import br.com.joaofzm15.linkVrains.gui.buttons.OpponentMonsterFieldButton;
import br.com.joaofzm15.linkVrains.gui.buttons.PlayerMonsterFieldButton;
import br.com.joaofzm15.linkVrains.gui.imageIcons.GeneralIcons;

public class DuelFrame extends JFrame implements ActionListener {
	
	private JButton returnToMenuButton;

	public JButton getReturnToMenuButton() {
		return returnToMenuButton;
	}

	private boolean playerAlive = true;
	public boolean isPlayerAlive() {
		return playerAlive;
	}
	public void setPlayerAlive(boolean playerAlive) {
		this.playerAlive = playerAlive;
	}

	private AiActions aiActions;

	public AiActions getAiActions() {
		return aiActions;
	}

	private AiTurns aiTurns;

	public AiTurns getAiTurns() {
		return aiTurns;
	}

	private GeneralIcons generalIcons = new GeneralIcons();

	private PlayerEnablerDisabler playerEnablerDisabler = new PlayerEnablerDisabler(this);

	public PlayerEnablerDisabler getPlayerEnablerDisabler() {
		return playerEnablerDisabler;
	}

	private boolean sunIsPlacedOnTheField;
	public boolean isSunPlacedOnTheField() {
		return sunIsPlacedOnTheField;
	}
	public void setSunIsPlacedOnTheField(boolean sunIsPlacedOnTheField) {
		this.sunIsPlacedOnTheField = sunIsPlacedOnTheField;
	}
	
	private boolean manualTuneIsPlacedOnTheField;
	public boolean isManualTunePlacedOnTheField() {
		return manualTuneIsPlacedOnTheField;
	}
	public void setManualTuneIsPlacedOnTheField(boolean manualTuneIsPlacedOnTheField) {
		this.manualTuneIsPlacedOnTheField = manualTuneIsPlacedOnTheField;
	}

	private int glassesActivatedThisTurn;
	public int isGlassesActivatedThisTurn() {
		return glassesActivatedThisTurn;
	}
	public void add1ToGlassesActivatedThisTurn() {
		glassesActivatedThisTurn++;
	}
	
	private int microphoneActivatedThisTurn;

	public int isMicrophonesActivatedThisTurn() {
		return microphoneActivatedThisTurn;
	}

	public void add1ToMicrophonesActivatedThisTurn() {
		microphoneActivatedThisTurn++;
	}
	

	public GeneralIcons getGeneralIcons() {
		return generalIcons;
	}

	private OpponentDeck opponentDeck;
	public OpponentDeck getOpponentDeck() {
		return opponentDeck;
	}

	private PlayerDeck playerDeck;
	public PlayerDeck getPlayerDeck() {
		return playerDeck;
	}


	private JLabel warningsLabel;

	public JLabel getWarningsLabel() {
		return warningsLabel;
	}

//=========================================================================
	private int currentRound = 1;

	public int getCurrentRound() {
		return currentRound;
	}

	private JLabel roundLabel;

	public JLabel getRoundLabel() {
		return roundLabel;
	}

	private int playerHp = 10000;
	public int getPlayerHp() {
		return playerHp;
	}

	public void setPlayerHp(int playerHp) {
		this.playerHp = playerHp;
		this.playerHpButton.setText(String.valueOf(this.playerHp));

	}
	
	private int opponentHp = 10000;
	public int getOpponentHp() {
		return opponentHp;
	}
	public void setOpponentHp(int opponentHp) {
		this.opponentHp = opponentHp;
		this.opponentHpButton.setText(String.valueOf(this.opponentHp));
	}
	
	private int playerMana = 1;
	public int getPlayerMana() {
		return playerMana;
	}

	public void setPlayerMana(int playerMana) {
		this.playerMana = playerMana;
		this.playerManaButton.setText(String.valueOf(this.playerMana));
	}
	

	private int opponentMana = 1;
	public int getOpponentMana() {
		return opponentMana;
	}
	public void setOpponentMana(int opponentMana) {
		this.opponentMana = opponentMana;
		this.opponentManaButton.setText(String.valueOf(this.opponentMana));
	}
	
	private JButton playerHpButton;

	public JButton getPlayerHpLabel() {
		return playerHpButton;
	}

	private JButton playerManaButton;

	public JButton getPlayerManaButton() {
		return playerManaButton;
	}

	private JButton opponentHpButton;

	public JButton getOpponentHpButton() {
		return opponentHpButton;
	}

	private JButton opponentManaButton;

	public JButton getOpponentMapaButton() {
		return opponentManaButton;
	}
//=========================================================================

	private JFrame frame = new JFrame();
	public JFrame getFrame() {
		return frame;
	}

	private JLabel drawCardAnimationLabel = new JLabel();

	public JLabel getDrawCardAnimationLabel() {
		return drawCardAnimationLabel;
	}

	private JLabel youWinLabel;

	public JLabel getYouWinLabel() {
		return youWinLabel;
	}

	private JLabel youLoseLabel;

	public JLabel getYouLoseLabel() {
		return youLoseLabel;
	}

	private Arrow ArrowPlayer10;
	private Arrow ArrowPlayer11;
	private Arrow ArrowPlayer12;
	private Arrow ArrowPlayer13;
	private Arrow ArrowPlayer20;
	private Arrow ArrowPlayer21;
	private Arrow ArrowPlayer22;
	private Arrow ArrowPlayer23;
	private Arrow ArrowPlayer30;
	private Arrow ArrowPlayer31;
	private Arrow ArrowPlayer32;
	private Arrow ArrowPlayer33;

	public Arrow getArrowPlayer10() {
		return ArrowPlayer10;
	}

	public Arrow getArrowPlayer11() {
		return ArrowPlayer11;
	}

	public Arrow getArrowPlayer12() {
		return ArrowPlayer12;
	}

	public Arrow getArrowPlayer13() {
		return ArrowPlayer13;
	}

	public Arrow getArrowPlayer20() {
		return ArrowPlayer20;
	}

	public Arrow getArrowPlayer21() {
		return ArrowPlayer21;
	}

	public Arrow getArrowPlayer22() {
		return ArrowPlayer22;
	}

	public Arrow getArrowPlayer23() {
		return ArrowPlayer23;
	}

	public Arrow getArrowPlayer30() {
		return ArrowPlayer30;
	}

	public Arrow getArrowPlayer31() {
		return ArrowPlayer31;
	}

	public Arrow getArrowPlayer32() {
		return ArrowPlayer32;
	}

	public Arrow getArrowPlayer33() {
		return ArrowPlayer33;
	}

	private Arrow ArrowOpponent10;
	private Arrow ArrowOpponent11;
	private Arrow ArrowOpponent12;
	private Arrow ArrowOpponent13;
	private Arrow ArrowOpponent20;
	private Arrow ArrowOpponent21;
	private Arrow ArrowOpponent22;
	private Arrow ArrowOpponent23;
	private Arrow ArrowOpponent30;
	private Arrow ArrowOpponent31;
	private Arrow ArrowOpponent32;
	private Arrow ArrowOpponent33;

	public Arrow getArrowOpponent10() {
		return ArrowOpponent10;
	}

	public Arrow getArrowOpponent11() {
		return ArrowOpponent11;
	}

	public Arrow getArrowOpponent12() {
		return ArrowOpponent12;
	}

	public Arrow getArrowOpponent13() {
		return ArrowOpponent13;
	}

	public Arrow getArrowOpponent20() {
		return ArrowOpponent20;
	}

	public Arrow getArrowOpponent21() {
		return ArrowOpponent21;
	}

	public Arrow getArrowOpponent22() {
		return ArrowOpponent22;
	}

	public Arrow getArrowOpponent23() {
		return ArrowOpponent23;
	}

	public Arrow getArrowOpponent30() {
		return ArrowOpponent30;
	}

	public Arrow getArrowOpponent31() {
		return ArrowOpponent31;
	}

	public Arrow getArrowOpponent32() {
		return ArrowOpponent32;
	}

	public Arrow getArrowOpponent33() {
		return ArrowOpponent33;
	}

	private HandPanel playerHandPanel;
	public HandPanel getPlayerHandPanel() {
		return playerHandPanel;
	}

	private HandPanel opponentHandPanel;
	public HandPanel getOpponentHandPanel() {
		return opponentHandPanel;
	}


	private JLabel cardInfo;

	public JLabel getCardInfo() {
		return cardInfo;
	}

	JLabel activatedCardLabel;

	public JLabel getActivatedCardLabel() {
		return activatedCardLabel;
	}

	// ================================Test Buttons
//	JButton buttonTest2;
//	JButton buttonTest3;
//	JButton buttonTest4;

	public JLabel labelTesteFire;

	public JLabel getLabelTesteFire() {
		return labelTesteFire;
	}
	public JLabel bloom;

	public JLabel getBloom() {
		return bloom;
	}
	// ================================Test Buttons

	JButton passRoundButton;
	public JButton getPassRoundButton() {
		return passRoundButton;
	}

	PlayerMonsterFieldButton playerMonsterZone1;
	PlayerMonsterFieldButton playerMonsterZone2;
	PlayerMonsterFieldButton playerMonsterZone3;
	MiscFieldButton playerDeckButton;

	public PlayerMonsterFieldButton getPlayerMonsterZone1() {
		return playerMonsterZone1;
	}

	public PlayerMonsterFieldButton getPlayerMonsterZone2() {
		return playerMonsterZone2;
	}

	public PlayerMonsterFieldButton getPlayerMonsterZone3() {
		return playerMonsterZone3;
	}

	public MiscFieldButton getPlayerDeckButton() {
		return playerDeckButton;
	}

	OpponentMonsterFieldButton opponentMonsterZone1;
	OpponentMonsterFieldButton opponentMonsterZone2;
	OpponentMonsterFieldButton opponentMonsterZone3;
	MiscFieldButton opponentDeckButton;

	public OpponentMonsterFieldButton getOpponentMonsterZone1() {
		return opponentMonsterZone1;
	}

	public OpponentMonsterFieldButton getOpponentMonsterZone2() {
		return opponentMonsterZone2;
	}

	public OpponentMonsterFieldButton getOpponentMonsterZone3() {
		return opponentMonsterZone3;
	}

	public MiscFieldButton getOpponentDeckButton() {
		return opponentDeckButton;
	}

	MiscFieldButton fieldButton;
	public MiscFieldButton getFieldButton() {
		return fieldButton;
	}
	public DuelFrame() {

		aiActions = new AiActions();
		aiTurns = new AiTurns(this);

		playerDeck = new PlayerDeck();
		opponentDeck = new OpponentDeck();

		frame.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("window backgrounds/boardBackground.jpg"))));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		ImageIcon yusaku = new ImageIcon(StartMenu.class.getResource("yuseiIcon.jpg"));
		frame.setIconImage(yusaku.getImage());
		frame.setTitle("Link Vrains");
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		
		returnToMenuButton = new JButton();
		returnToMenuButton.setBounds(225, 630, 150, 50);
		returnToMenuButton.addActionListener(this);
		returnToMenuButton.setText("MAIN MENU");
		returnToMenuButton.setFont(new Font("Impact", Font.BOLD, 22));
		returnToMenuButton.setForeground(Color.white);
		returnToMenuButton.setBackground(new Color(255, 105, 0));
		returnToMenuButton.setBorder(BorderFactory.createLineBorder(Color.white));
		returnToMenuButton.setFocusable(false);
		frame.add(returnToMenuButton);

		// ======================Win / Lose

		youWinLabel = new JLabel();
		youWinLabel.setBounds(0, 0, 1280, 720);
		ImageIcon winMessageGif = new ImageIcon("resources/messages/youWin.gif");
		youWinLabel.setIcon(winMessageGif);
		youWinLabel.setVisible(false);
		frame.add(youWinLabel);

		youLoseLabel = new JLabel();
		youLoseLabel.setBounds(0, 0, 1280, 720);
		ImageIcon LoseMessageGif = new ImageIcon("resources/messages/youLose.gif");
		youLoseLabel.setIcon(LoseMessageGif);
		youLoseLabel.setVisible(false);
		frame.add(youLoseLabel);

		// ======================Win / Lose

		// ========================= Round ==============================
		roundLabel = new JLabel();
		roundLabel.setFont(new Font("Impact", Font.PLAIN, 23));
		roundLabel.setText(String.valueOf("Round: " + currentRound));
		roundLabel.setForeground(Color.yellow);
		roundLabel.setBounds(806, 330, 100, 50);
		roundLabel.setVisible(true);
		frame.add(roundLabel);

		passRoundButton = new JButton();
		passRoundButton.setBorder(null);
		passRoundButton.addActionListener(this);
		passRoundButton.setBackground(null);
		passRoundButton.setText("END ROUND");
		passRoundButton.setFocusable(false);
		passRoundButton.setForeground(Color.yellow);
		passRoundButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
		passRoundButton.setBackground(Color.black);
		passRoundButton.setBounds(1026, 330, 75, 50);
		frame.add(passRoundButton);

		// ========================= Round ==============================

		// ========================= HP and MANA BARS ==============================
		playerHpButton = new JButton();
		playerHpButton.setFont(new Font("Impact", Font.PLAIN, 17));
		playerHpButton.setText(String.valueOf(playerHp));
		playerHpButton.setForeground(Color.white);
		playerHpButton.setBackground(Color.red);
		playerHpButton.setFocusable(false);
		playerHpButton.setBounds((int) 673.2, 655, (int) 77.76, 50);
		playerHpButton.setVisible(true);
		frame.add(playerHpButton);

		playerManaButton = new JButton();
		playerManaButton.setFont(new Font("Impact", Font.PLAIN, 25));
		playerManaButton.setText(String.valueOf(playerMana));
		playerManaButton.setForeground(Color.white);
		playerManaButton.setFocusable(false);
		playerManaButton.setBackground(new Color(15, 60, 255));
		playerManaButton.setBounds(1180, 655, (int) 77.76, 50);
		playerManaButton.setVisible(true);
		frame.add(playerManaButton);

		opponentHpButton = new JButton();
		opponentHpButton.setFont(new Font("Impact", Font.PLAIN, 17));
		opponentHpButton.setText(String.valueOf(opponentHp));
		opponentHpButton.setForeground(Color.white);
		opponentHpButton.setBackground(Color.red);
		opponentHpButton.setFocusable(false);
		opponentHpButton.setBounds(1180, 15, (int) 77.76, 50);
		opponentHpButton.setVisible(true);
		frame.add(opponentHpButton);

		opponentManaButton = new JButton();
		opponentManaButton.setFont(new Font("Impact", Font.PLAIN, 25));
		opponentManaButton.setText(String.valueOf(opponentMana));
		opponentManaButton.setForeground(Color.white);
		opponentManaButton.setFocusable(false);
		opponentManaButton.setBackground(new Color(15, 60, 255));
		opponentManaButton.setBounds((int) 673.2, 15, (int) 77.76, 50);
		opponentManaButton.setVisible(true);
		frame.add(opponentManaButton);
		// ========================= HP and MANA BARS ==============================


		// ========================Attack Arrows====================================
		ArrowPlayer10 = new Arrow(this, "resources/arrows/1-0.png");
		ArrowPlayer11 = new Arrow(this, "resources/arrows/1-1.png");
		ArrowPlayer12 = new Arrow(this, "resources/arrows/1-2.png");
		ArrowPlayer13 = new Arrow(this, "resources/arrows/1-3.png");
		ArrowPlayer20 = new Arrow(this, "resources/arrows/2-0.png");
		ArrowPlayer21 = new Arrow(this, "resources/arrows/2-1.png");
		ArrowPlayer22 = new Arrow(this, "resources/arrows/2-2.png");
		ArrowPlayer23 = new Arrow(this, "resources/arrows/2-3.png");
		ArrowPlayer30 = new Arrow(this, "resources/arrows/3-0.png");
		ArrowPlayer31 = new Arrow(this, "resources/arrows/3-1.png");
		ArrowPlayer32 = new Arrow(this, "resources/arrows/3-2.png");
		ArrowPlayer33 = new Arrow(this, "resources/arrows/3-3.png");

		ArrowOpponent10 = new Arrow(this, "resources/arrows/f1-0.png");
		ArrowOpponent11 = new Arrow(this, "resources/arrows/f1-1.png");
		ArrowOpponent12 = new Arrow(this, "resources/arrows/f1-2.png");
		ArrowOpponent13 = new Arrow(this, "resources/arrows/f1-3.png");
		ArrowOpponent20 = new Arrow(this, "resources/arrows/f2-0.png");
		ArrowOpponent21 = new Arrow(this, "resources/arrows/f2-1.png");
		ArrowOpponent22 = new Arrow(this, "resources/arrows/f2-2.png");
		ArrowOpponent23 = new Arrow(this, "resources/arrows/f2-3.png");
		ArrowOpponent30 = new Arrow(this, "resources/arrows/f3-0.png");
		ArrowOpponent31 = new Arrow(this, "resources/arrows/f3-1.png");
		ArrowOpponent32 = new Arrow(this, "resources/arrows/f3-2.png");
		ArrowOpponent33 = new Arrow(this, "resources/arrows/f3-3.png");
		// ========================Attack Arrows====================================



		labelTesteFire = new JLabel();
		getLabelTesteFire().setBounds((int) 910, (int) -345, (int) 1000, (int) 1130.4);
		ImageIcon fire = new ImageIcon(StartMenu.class.getResource("fire.gif"));
		getLabelTesteFire().setIcon(fire);
		getLabelTesteFire().setVisible(false);
		frame.add(getLabelTesteFire());

		bloom = new JLabel();
		getBloom().setBounds((int) 813, (int) 350, (int) 77, (int) 113);
		ImageIcon bloomIcon = new ImageIcon(StartMenu.class.getResource("bloom.gif"));
		getBloom().setIcon(bloomIcon);
		getBloom().setVisible(false);
		frame.add(getBloom());

		//Used solely for the draw card animation.
		drawCardAnimationLabel.setVisible(false);
		frame.add(drawCardAnimationLabel);



		// warning label----------------------------------------
		warningsLabel = new JLabel();
		warningsLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		warningsLabel.setBounds(400, 300, 800, 100);
		warningsLabel.setForeground(Color.white);
		warningsLabel.setVisible(false);
		frame.add(warningsLabel);
		// warning label----------------------------------------

		cardInfo = new JLabel();
		cardInfo.setBounds(162, 50, 271, 395);
		cardInfo.setBackground(Color.black);
		cardInfo.setIcon(generalIcons.getBigCoverImageIcon());
		frame.add(cardInfo);
		
		activatedCardLabel = new JLabel();
		activatedCardLabel.setBounds(830, 163, 271, 395);
		activatedCardLabel.setBackground(Color.black);
		activatedCardLabel.setIcon(generalIcons.getBigCoverImageIcon());
		activatedCardLabel.setVisible(false);
		frame.add(activatedCardLabel);

		// player
		// Hand Panel
		playerHandPanel = new HandPanel(this, 760, 600, 410, (int) 113.4);
		// monster zones
		// 1
		playerMonsterZone1 = new PlayerMonsterFieldButton(this, (int) 813.2, 450);
		// 2
		playerMonsterZone2 = new PlayerMonsterFieldButton(this, (int) 926.6, 450);
		// 3
		playerMonsterZone3 = new PlayerMonsterFieldButton(this, (int) 1040, 450);
		// other zones
		// Deck
		playerDeckButton = new MiscFieldButton(this, (int) 1180, 530);
		getPlayerDeckButton().setIcons(generalIcons.getCoverImageIcon());
		// Field
		fieldButton = new MiscFieldButton(this, (int) 926.2, 303);
		fieldButton.getButton().setBorder(BorderFactory.createLineBorder(new Color(50, 50, 255)));

		// opponent
		// Hand Panel
		opponentHandPanel = new HandPanel(this, 760, (int) 7.6, 410, (int) 113.4);
		opponentHandPanel.getPanel().setBorder(BorderFactory.createLineBorder(new Color(255, 104, 0), 1));

		// monster zones
		// 1
		opponentMonsterZone1 = new OpponentMonsterFieldButton(this, (int) 1040, (int) 156.6);
		opponentMonsterZone1.getButton().setBackground(Color.black);
		opponentMonsterZone1.getButton().setBorder(BorderFactory.createLineBorder(new Color(255, 104, 0)));

//		opponentMonsterZone1.setIcons(this.getOpponentMonsterZone1().getImageIconFromCard(opponentDeck.getDeckArrayList().get(4)));

		// 2
		opponentMonsterZone2 = new OpponentMonsterFieldButton(this, (int) 926.6, (int) 156.6);
		opponentMonsterZone2.getButton().setBackground(Color.black);
		opponentMonsterZone2.getButton().setBorder(BorderFactory.createLineBorder(new Color(255, 104, 0)));

		// 3
		opponentMonsterZone3 = new OpponentMonsterFieldButton(this, (int) 813.2, (int) 156.6);
		opponentMonsterZone3.getButton().setBackground(Color.black);
		opponentMonsterZone3.getButton().setBorder(BorderFactory.createLineBorder(new Color(255, 104, 0)));
		// other zones
		// Deck
		opponentDeckButton = new MiscFieldButton(this, (int) 673.2, (int) 76.6);
		opponentDeckButton.getButton().setBackground(Color.black);
		opponentDeckButton.setIcons(generalIcons.getCoverImageIcon());
		opponentDeckButton.getButton().setBorder(BorderFactory.createLineBorder(new Color(255, 104, 0)));

		frame.pack();
		frame.setVisible(true);


		// starting hand
		new Thread() {
			public void run() {
				playerEnablerDisabler.disablePlayer();
				for (int i =0; i<4; i++) {
					playerHandPanel.drawCard();
					try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
					opponentHandPanel.drawCardOpponent();
					try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
				}
				playerEnablerDisabler.enablePlayer();
			}
		}.start();

	}

	public void passRound() {
		playerMonsterZone1.setAttackedThisTurn(false);
		playerMonsterZone2.setAttackedThisTurn(false);
		playerMonsterZone3.setAttackedThisTurn(false);
		opponentMonsterZone1.setAttackedThisTurn(false);
		opponentMonsterZone2.setAttackedThisTurn(false);
		opponentMonsterZone3.setAttackedThisTurn(false);
		playerMonsterZone1.setPower(playerMonsterZone1.getPower() - (1000 * glassesActivatedThisTurn));
		playerMonsterZone2.setPower(playerMonsterZone2.getPower() - (1000 * glassesActivatedThisTurn));
		playerMonsterZone3.setPower(playerMonsterZone3.getPower() - (1000 * glassesActivatedThisTurn));
		glassesActivatedThisTurn = 0;
		opponentMonsterZone1.setPower(opponentMonsterZone1.getPower() - (1000 * microphoneActivatedThisTurn));
		opponentMonsterZone2.setPower(opponentMonsterZone2.getPower() - (1000 * microphoneActivatedThisTurn));
		opponentMonsterZone3.setPower(opponentMonsterZone3.getPower() - (1000 * microphoneActivatedThisTurn));
		microphoneActivatedThisTurn = 0;

		this.currentRound++;
		this.roundLabel.setText("Round: " + currentRound);
		new Thread(new RoundPassTextAnimation(this)).start();
		this.setPlayerMana(currentRound);
		this.setOpponentMana(currentRound);
		if (currentRound % 2 == 0) {
			opponentHandPanel.drawCardOpponent();
		} else {
			playerHandPanel.drawCard();
		}

		if (currentRound % 2 == 0) {
			aiTurns.aiTurn();
		}

	}

	public void youWin() {
		getYouWinLabel().setVisible(true);
		playerEnablerDisabler.disablePlayer();
		new Thread(new VictorySound()).start();

	}

	public void youLose() {
		getYouLoseLabel().setVisible(true);
		playerEnablerDisabler.disablePlayer();
		new Thread(new DefeatSound()).start();

	}
	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnToMenuButton) {
			new Thread(new ClickSound()).start();
			frame.dispose();
			new StartMenu();
		} else if (e.getSource() == passRoundButton) {
			new Thread(new ClickSound()).start();
			passRound();
		}

	}

}
