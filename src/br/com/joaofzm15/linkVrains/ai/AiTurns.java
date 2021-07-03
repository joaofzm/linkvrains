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
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}

				for (int i = 0; i < duelFrame.getOpponentHandPanel().getButtonList().size(); i++) {
					if (duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() < 50000) {
						boolean sucesfullSummon = duelFrame.getAiActions().summon(duelFrame.getOpponentHandPanel().getButtonList().get(i));
						if (sucesfullSummon) {
							i--;
							try {Thread.sleep(1200);} catch (InterruptedException e) {e.printStackTrace();}
						}
					}
				}

				if (duelFrame.getOpponentMonsterZone1().isOccupied() || duelFrame.getOpponentMonsterZone2().isOccupied()
						|| duelFrame.getOpponentMonsterZone3().isOccupied()) {
					if (duelFrame.getPlayerMonsterZone1().isOccupied() || duelFrame.getPlayerMonsterZone2().isOccupied()
							|| duelFrame.getPlayerMonsterZone3().isOccupied()) {
						for (int i = 0; i < duelFrame.getOpponentHandPanel().getButtonList().size(); i++) {
							if (duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() >= 50000 
									&& duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() < 100000) {
								duelFrame.getAiActions().activate(duelFrame.getOpponentHandPanel().getButtonList().get(i));
								i--;
								try {Thread.sleep(1200);} catch (InterruptedException e) {e.printStackTrace();}
							}
						}
					}
				}
	

				if (duelFrame.getOpponentMonsterZone1().isOccupied() || duelFrame.getOpponentMonsterZone2().isOccupied()
						|| duelFrame.getOpponentMonsterZone3().isOccupied()) {
					for (int i = 0; i < duelFrame.getOpponentHandPanel().getButtonList().size(); i++) {
						if (duelFrame.getOpponentHandPanel().getButtonList().get(i).getPower() >= 100000) {
							duelFrame.getAiActions().place(duelFrame.getOpponentHandPanel().getButtonList().get(i));
							try {Thread.sleep(1200);} catch (InterruptedException e) {e.printStackTrace();}
							break;
						}
					}
				}
				
				//=ATACKS=TO=CARDS================================
				if (duelFrame.getOpponentMonsterZone1().isOccupied()) {
					if (duelFrame.getOpponentMonsterZone1().getPower() > duelFrame.getPlayerMonsterZone1().getPower()
							&& duelFrame.getPlayerMonsterZone1().isOccupied()) {
						duelFrame.getOpponentMonsterZone1().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone1(), duelFrame.getOpponentMonsterZone1());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					
					} else if (duelFrame.getOpponentMonsterZone1().getPower() > duelFrame.getPlayerMonsterZone2().getPower()
							&& duelFrame.getPlayerMonsterZone2().isOccupied()) {
						duelFrame.getOpponentMonsterZone1().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone2(), duelFrame.getOpponentMonsterZone1());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					
					}else if (duelFrame.getOpponentMonsterZone1().getPower() > duelFrame.getPlayerMonsterZone3().getPower()
							&& duelFrame.getPlayerMonsterZone3().isOccupied()) {
						duelFrame.getOpponentMonsterZone1().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone3(), duelFrame.getOpponentMonsterZone1());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					}
				} 
				
				
				if (duelFrame.getOpponentMonsterZone2().isOccupied()) {
					if (duelFrame.getOpponentMonsterZone2().getPower() > duelFrame.getPlayerMonsterZone1().getPower()
							&& duelFrame.getPlayerMonsterZone1().isOccupied()) {
						duelFrame.getOpponentMonsterZone2().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone1(), duelFrame.getOpponentMonsterZone2());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					
					} else if (duelFrame.getOpponentMonsterZone2().getPower() > duelFrame.getPlayerMonsterZone2().getPower()
							&& duelFrame.getPlayerMonsterZone2().isOccupied()) {
						duelFrame.getOpponentMonsterZone2().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone2(), duelFrame.getOpponentMonsterZone2());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					
					}else if (duelFrame.getOpponentMonsterZone2().getPower() > duelFrame.getPlayerMonsterZone3().getPower()
							&& duelFrame.getPlayerMonsterZone3().isOccupied()) {
						duelFrame.getOpponentMonsterZone2().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone3(), duelFrame.getOpponentMonsterZone2());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					}
				} 
				

				
				if (duelFrame.getOpponentMonsterZone3().isOccupied()) {
					if (duelFrame.getOpponentMonsterZone3().getPower() > duelFrame.getPlayerMonsterZone1().getPower()
							&& duelFrame.getPlayerMonsterZone1().isOccupied()) {
						duelFrame.getOpponentMonsterZone3().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone1(), duelFrame.getOpponentMonsterZone3());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					
					} else if (duelFrame.getOpponentMonsterZone3().getPower() > duelFrame.getPlayerMonsterZone2().getPower()
							&& duelFrame.getPlayerMonsterZone2().isOccupied()) {
						duelFrame.getOpponentMonsterZone3().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone2(), duelFrame.getOpponentMonsterZone3());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					
					}else if (duelFrame.getOpponentMonsterZone3().getPower() > duelFrame.getPlayerMonsterZone3().getPower()
							&& duelFrame.getPlayerMonsterZone3().isOccupied()) {
						duelFrame.getOpponentMonsterZone3().setAttackedThisTurn(true);
						duelFrame.getAiActions().attack(duelFrame.getPlayerMonsterZone3(), duelFrame.getOpponentMonsterZone3());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}

					}
				} 
				//=ATACKS=TO=CARDS================================

				//DIRECT ATTACKS
				if (!duelFrame.getPlayerMonsterZone1().isOccupied() 
					&& !duelFrame.getPlayerMonsterZone2().isOccupied() 
					&& !duelFrame.getPlayerMonsterZone1().isOccupied()){
					
					if(duelFrame.getOpponentMonsterZone1().isOccupied() && !duelFrame.getOpponentMonsterZone1().hasAttackedThisTurn() ) {
						duelFrame.getAiActions().directAttack(duelFrame.getOpponentMonsterZone1());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}
						if (duelFrame.getPlayerHp() <= 0) {
							duelFrame.setPlayerAlive(false);
							duelFrame.youLose();
						}

					}
					
					if(duelFrame.getOpponentMonsterZone2().isOccupied()  && !duelFrame.getOpponentMonsterZone2().hasAttackedThisTurn()) {
						duelFrame.getAiActions().directAttack(duelFrame.getOpponentMonsterZone2());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}
						if (duelFrame.getPlayerHp() <= 0) {
							duelFrame.setPlayerAlive(false);
							duelFrame.youLose();
						}
					}
					
					if(duelFrame.getOpponentMonsterZone3().isOccupied() && !duelFrame.getOpponentMonsterZone3().hasAttackedThisTurn()) {
						duelFrame.getAiActions().directAttack(duelFrame.getOpponentMonsterZone3());
						try {Thread.sleep(2500);} catch (InterruptedException e) {e.printStackTrace();}
						if (duelFrame.getPlayerHp() <= 0) {
							duelFrame.setPlayerAlive(false);
							duelFrame.youLose();
						}
					}
				}
				
				
				//DIRECT ATTACKS
				
				
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
				if (duelFrame.isPlayerAlive()) {
					duelFrame.getPlayerEnablerDisabler().enablePlayer();
					duelFrame.passRound();
				}
			}
		}.start();
		

	}

}
