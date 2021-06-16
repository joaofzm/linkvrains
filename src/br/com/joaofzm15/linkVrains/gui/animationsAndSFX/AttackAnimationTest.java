package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;

public class AttackAnimationTest implements Runnable {

	private DuelFrame duelFrame;
	private String soundLocation;
	private String soundLocation2;
	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();


	public AttackAnimationTest(DuelFrame df) {
		this.duelFrame = df;
		soundLocation = "resources/sound effects/attack.wav";
		soundLocation2 = "resources/sound effects/impact.wav";
	}

//	MonsterFieldButton playerMonsterZone2 = new MonsterFieldButton(this, (int) 926.6, 350);
//	MonsterFieldButton opponentMonsterZone1 = new MonsterFieldButton(this, (int) 1040, (int) 220.8);
//	114.4 | 129.2

	@Override
	public void run() {
		this.duelFrame.getAttackArrow().setVisible(true);
		soundEffectConverter.setFile(soundLocation);
		soundEffectConverter.play();
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		this.duelFrame.getAttackArrow().setVisible(false);
		
		int xPos = 926;
		int yPos = 350;
		
		for (int i = 0; i < 10; i++) {
			xPos -= (int) 2.288;
			yPos += (int) 2.584;
			this.duelFrame.playerMonsterZone2.getButton().setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(15);} catch (InterruptedException e) {e.printStackTrace();}
		}

		for (int i = 0; i < 60; i++) {
			xPos += (int) 2.288;
			yPos -= (int) 2.584;
			this.duelFrame.playerMonsterZone2.getButton().setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		}
		soundEffectConverter.setFile(soundLocation2);
		soundEffectConverter.play();
		duelFrame.labelTesteFire.setVisible(true);

		for (int i = 0; i < 50; i++) {
			xPos -= (int) 2.288;
			yPos += (int) 2.584;
			this.duelFrame.playerMonsterZone2.getButton().setBounds(xPos, yPos, (int) 77.76, (int) 113.4);
			try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		}

		duelFrame.labelTesteFire.setVisible(false);


	}



}
