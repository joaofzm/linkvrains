package br.com.joaofzm15.linkVrains.ai;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class AiTurns {
	
	DuelFrame duelFrame;

	public AiTurns(DuelFrame duelFrame) {
		this.duelFrame = duelFrame;
	}

	public void aiTurn() {
		duelFrame.getPlayerEnablerDisabler().disablePlayer();
		new Thread(new FixButtonLayoutThread(duelFrame)).start();
		new Thread() {
			public void run() {

				for (int i = 0; i < duelFrame.getOpponentHandPanel().getButtonList().size(); i++) {
					if (duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() < 50000) {
						boolean sucesfullSummon = duelFrame.getAiActions().summon(duelFrame.getOpponentHandPanel().getButtonList().get(i));
						if (sucesfullSummon) {
							i--;
							try {Thread.sleep(1200);} catch (InterruptedException e) {e.printStackTrace();}
						}
					}
				}

				for (int i = 0; i < duelFrame.getOpponentHandPanel().getButtonList().size(); i++) {
					if (duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() >= 50000 && duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() < 100000) {
						duelFrame.getAiActions().activate(duelFrame.getOpponentHandPanel().getButtonList().get(i));
						i--;
						try {Thread.sleep(1200);} catch (InterruptedException e) {e.printStackTrace();}
					}
				}

				for (int i = 0; i < duelFrame.getOpponentHandPanel().getButtonList().size(); i++) {
					if (duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() >= 100000) {
						duelFrame.getAiActions().place(duelFrame.getOpponentHandPanel().getButtonList().get(i));
						try {Thread.sleep(1200);} catch (InterruptedException e) {e.printStackTrace();}
						break;
					}
				}

				// Attacks
				try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
				duelFrame.getPlayerEnablerDisabler().enablePlayer();
				duelFrame.passRound();
			}
		}.start();
		

	}

}
