package br.com.joaofzm15.linkVrains.ai;

import br.com.joaofzm15.linkVrains.gui.DuelFrame;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class AiTurns {
	
	DuelFrame duelFrame;

	public AiTurns(DuelFrame duelFrame) {
		this.duelFrame = duelFrame;
	}

	public void aiTurn2() {
		duelFrame.getPlayerEnablerDisabler().disablePlayer();
		new Thread(new FixButtonLayoutThread(duelFrame)).start();
		new Thread() {
			public void run() {
				/// Turn actions here
				try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
				duelFrame.getPlayerEnablerDisabler().enablePlayer();
				duelFrame.passRound();
			}
		}.start();
		
	}

	public void aiTurn4() {
		System.out.println("Pinto 4");
	}

	public void aiTurn6() {
		System.out.println("Pinto 6");
	}

	public void aiTurn8() {
		System.out.println("Pinto 8");
	}

}
