package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.event.ActionEvent;

import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.ActivateAnimation;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;

public class ActivateButton extends ActionButton {

	public ActivateButton(HandPanelButton handPanelButton) {
		super(handPanelButton);
		this.getButton().setText("Activate");
	}

	public void glasses() {
		this.getHandPanelButton().getHandPanel().getDuelFrame().add1ToGlassesActivatedThisTurn();

		this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().getPower()+1000);
		this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().getPower()+1000);
		this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().setPower(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().getPower()+1000);
	}


	public void tears() {

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.getHandPanelButton().getHandPanel().getDuelFrame().getActivatedCardLabel().setIcon(this.getHandPanelButton().getCurrentCardBigCard());
		new Thread(new ActivateAnimation(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
		this.getHandPanelButton().getHandPanel().getPanel().remove(this.getHandPanelButton().getButton());
		this.getHandPanelButton().getHandPanel().remove1FromCardsInHand();
		this.getHandPanelButton().getHandPanel().fillHand();

		if (this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getGlasses1()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getGlasses2()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getGlasses3()) {
			this.glasses();
		}
		
		if (this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getTears1()
				|| this.getHandPanelButton().getCard() == this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerDeck().getTears1()) {
			this.tears();
		}

		new Thread(new FixButtonLayoutThread(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
	}
	
	
	

}
