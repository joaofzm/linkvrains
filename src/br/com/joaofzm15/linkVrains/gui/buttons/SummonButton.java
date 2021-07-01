package br.com.joaofzm15.linkVrains.gui.buttons;

import java.awt.event.ActionEvent;

import br.com.joaofzm15.linkVrains.cards.MonsterCard;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.AllZonesOccupiedWarning;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.FixButtonLayoutThread;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.InsufficientManaWarning;
import br.com.joaofzm15.linkVrains.gui.animationsAndSFX.SummonAnimation;

public class SummonButton extends ActionButton {

	public SummonButton(HandPanelButton handPanelButton) {
		super(handPanelButton);
		this.getButton().setText("Summon");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MonsterCard handPanelMonsterCardReference = (MonsterCard) this.getHandPanelButton().getCard();
		if (handPanelMonsterCardReference.getCost() <= this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMana()) {
			if(!this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().isOccupied()) {
				new Thread(new SummonAnimation(this.getHandPanelButton().getHandPanel().getDuelFrame(), (int) 926.6, 450)).start();
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().setIcons(this.getHandPanelButton().getCurrentCardBigCard());
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().setOccupied(true);
				
				this.getHandPanelButton().getHandPanel().getPanel().remove(this.getHandPanelButton().getButton());
				this.getHandPanelButton().getHandPanel().remove1FromCardsInHand();
				this.getHandPanelButton().getHandPanel().fillHand();
			
				if (this.getHandPanelButton().getHandPanel().getDuelFrame().isSunPlacedOnTheField()) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().setPower(this.getHandPanelButton().getPower() + 1000);
				} else {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().setPower(this.getHandPanelButton().getPower());
				}
				
				this.getHandPanelButton().getHandPanel().getDuelFrame().setPlayerMana(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMana()- handPanelMonsterCardReference.getCost());
				
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().getPowerButton().setText(String.valueOf(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().getPower()));
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().getButton().add(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone2().getPowerButton());
			
				
				new Thread(new FixButtonLayoutThread(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();

			} else if(!this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().isOccupied()) {
				new Thread(new SummonAnimation(this.getHandPanelButton().getHandPanel().getDuelFrame(), (int) 813.2, 450)).start();
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().setIcons(this.getHandPanelButton().getCurrentCardBigCard());
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().setOccupied(true);
				
				this.getHandPanelButton().getHandPanel().getPanel().remove(this.getHandPanelButton().getButton());
				this.getHandPanelButton().getHandPanel().remove1FromCardsInHand();
				this.getHandPanelButton().getHandPanel().fillHand();
				
				if (this.getHandPanelButton().getHandPanel().getDuelFrame().isSunPlacedOnTheField()) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().setPower(this.getHandPanelButton().getPower() + 1000);
				} else {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().setPower(this.getHandPanelButton().getPower());
				}
				
				this.getHandPanelButton().getHandPanel().getDuelFrame()	.setPlayerMana(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMana()- handPanelMonsterCardReference.getCost());
		
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().getPowerButton()
						.setText(String.valueOf(this.getHandPanelButton().getHandPanel().getDuelFrame()
								.getPlayerMonsterZone1().getPower()));
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().getButton().add(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone1().getPowerButton());

				new Thread(new FixButtonLayoutThread(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
				

			} else if(!this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().isOccupied()) {
				new Thread(new SummonAnimation(this.getHandPanelButton().getHandPanel().getDuelFrame(), 1040, 450)).start();
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().setIcons(this.getHandPanelButton().getCurrentCardBigCard());
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().setOccupied(true);
				
				this.getHandPanelButton().getHandPanel().getPanel().remove(this.getHandPanelButton().getButton());
				this.getHandPanelButton().getHandPanel().remove1FromCardsInHand();
				this.getHandPanelButton().getHandPanel().fillHand();
				
				if (this.getHandPanelButton().getHandPanel().getDuelFrame().isSunPlacedOnTheField()) {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().setPower(this.getHandPanelButton().getPower() + 1000);
				} else {
					this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().setPower(this.getHandPanelButton().getPower());
				}	
				
				this.getHandPanelButton().getHandPanel().getDuelFrame().setPlayerMana(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMana()- handPanelMonsterCardReference.getCost());

				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().getPowerButton()
						.setText(String.valueOf(this.getHandPanelButton().getHandPanel().getDuelFrame()
								.getPlayerMonsterZone3().getPower()));
				this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().getButton().add(this.getHandPanelButton().getHandPanel().getDuelFrame().getPlayerMonsterZone3().getPowerButton());

				new Thread(new FixButtonLayoutThread(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
		
			} else {
				new Thread(new AllZonesOccupiedWarning(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
			}
		
		} else {
			new Thread(new InsufficientManaWarning(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
		}



		new Thread(new FixButtonLayoutThread(this.getHandPanelButton().getHandPanel().getDuelFrame())).start();
	}

}
