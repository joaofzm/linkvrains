package br.com.joaofzm15.linkVrains.gui;

public class PlayerEnablerDisabler {

	DuelFrame duelFrame;

	public PlayerEnablerDisabler(DuelFrame duelFrame) {
		this.duelFrame = duelFrame;
	}

	public void enablePlayer() {
		this.duelFrame.getPassRoundButton().setEnabled(true);
		for (int i = 0; i < duelFrame.getPlayerHandPanel().getButtonList().size(); i++) {
			duelFrame.getPlayerHandPanel().getButtonList().get(i).getButton().setEnabled(true);
		}
		duelFrame.getPlayerMonsterZone1().getButton().setEnabled(true);
		duelFrame.getPlayerMonsterZone2().getButton().setEnabled(true);
		duelFrame.getPlayerMonsterZone3().getButton().setEnabled(true);
	}

	public void disablePlayer() {
		this.duelFrame.getPassRoundButton().setEnabled(false);
		for (int i = 0; i < duelFrame.getPlayerHandPanel().getButtonList().size(); i++) {
			duelFrame.getPlayerHandPanel().getButtonList().get(i).getButton().setEnabled(false);
			duelFrame.getPlayerHandPanel().getButtonList().get(i).removeSummonAndSetButtons();
		}
		duelFrame.getPlayerMonsterZone1().getButton().setEnabled(false);
		duelFrame.getPlayerMonsterZone2().getButton().setEnabled(false);
		duelFrame.getPlayerMonsterZone3().getButton().setEnabled(false);

		duelFrame.getPlayerMonsterZone1().removeAttackButton();
		duelFrame.getPlayerMonsterZone2().removeAttackButton();
		duelFrame.getPlayerMonsterZone3().removeAttackButton();
		duelFrame.getPlayerMonsterZone1().getButton().requestFocus();
		duelFrame.getPlayerMonsterZone2().getButton().requestFocus();
		duelFrame.getPlayerMonsterZone3().getButton().requestFocus();
	}
}
