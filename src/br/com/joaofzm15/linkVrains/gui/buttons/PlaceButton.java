package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.event.ActionEvent;

import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.ActivateAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class PlaceButton extends ActionButton {

	public PlaceButton(HandPanelButton handPanelButton) {
		super(handPanelButton);
		this.getButton().setText("Place");
	}
	
	public void sun() {
		
		if (this.getHandPanelButton().getHandPanel().getDuelFrame().isManualTunePlacedOnTheField()) {
			this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone1().getPower()-1000);
			this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone2().getPower()-1000);
			this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getOpponentMonsterZone3().getPower()-1000);
			this.getHandPanelButton().getHandPanel().getDuelFrame().setManualTuneIsPlacedOnTheField(false);
		}
		
		if (!this.getHandPanelButton().getHandPanel().getDuelFrame().isSunPlacedOnTheField()) {

			this.getHandPanelButton().getHandPanel().getDuelFrame().setSunIsPlacedOnTheField(true);
	
			this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().getPower()+1000);
			this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().getPower()+1000);
			this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().getPower()+1000);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.getHandPanelButton().getHandPanel().getDuelFrame().getActivatedCardLabel().setIcon(this.getHandPanelButton().getCurrentCardBigCard());
		new Thread(new ActivateAnimation(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
		this.getHandPanelButton().getHandPanel().getPanel().remove(this.getHandPanelButton().getButton());
		this.getHandPanelButton().getHandPanel().remove1FromCardsInHand();
		this.getHandPanelButton().getHandPanel().fillHand();
		this.getHandPanelButton().getHandPanel().getDuelFrame().getFieldButton().setIcons(this.getHandPanelButton().currentCardBigCard);
		
		if (this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getSun1()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getSun2()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getSun3()) {
			this.sun();
		}
		
		new Thread(new FixButtonLayoutThread(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
	}

}
