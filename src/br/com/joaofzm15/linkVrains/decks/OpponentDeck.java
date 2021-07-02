package br.com.joaofzm15.linkVrains.decks;

import br.com.joaofzm15.linkVrains.cards.Card;
import br.com.joaofzm15.linkVrains.cards.FieldCard;
import br.com.joaofzm15.linkVrains.cards.MonsterCard;
import br.com.joaofzm15.linkVrains.cards.SpellCard;

public class OpponentDeck extends Deck {
	
	Card keyboard1;
	Card keyboard2;
	Card keyboard3;
	Card trumpet1;
	Card trumpet2;
	Card trumpet3;
	Card guitar1;
	Card guitar2;
	Card guitar3;
	Card guitarAgain1;
	Card guitarAgain2;
	Card guitarAgain3;
	
	Card headphone1;

	public Card getHeadphone1() {
		return headphone1;
	}

	Card headphone2;

	public Card getHeadphone2() {
		return headphone2;
	}
	
	Card microphone1;
	public Card getMicrophone1() {
		return microphone1;
	}
	Card microphone2;
	public Card getMicrophone2() {
		return microphone2;
	}
	Card microphone3;
	public Card getMicrophone3() {
		return microphone3;
	}
	
	Card manualTune1;
	public Card getManualTune1() {
		return manualTune1;
	}
	Card manualTune2;
	public Card getManualTune2() {
		return manualTune2;
	}
	Card manualTune3;
	public Card getManualTune3() {
		return manualTune3;
	}

	public OpponentDeck() {
		// -----------------Main deck ------------------------------------
		keyboard1 = new MonsterCard(this, "8", 1000, 1);
		keyboard2 = new MonsterCard(this, "8", 1000, 1);
		keyboard3 = new MonsterCard(this, "8", 1000, 1);
		manualTune1 = new FieldCard(this, "14");
		trumpet1 = new MonsterCard(this, "9", 3000, 3);
		trumpet2 = new MonsterCard(this, "9", 3000, 3);
		trumpet3 = new MonsterCard(this, "9", 3000, 3);
		guitar1 = new MonsterCard(this, "10", 5500, 6);
		guitar2 = new MonsterCard(this, "10", 5500, 6);
		guitar3 = new MonsterCard(this, "10", 5500, 6);
		guitarAgain1 = new MonsterCard(this, "11", 9999, 7);
		guitarAgain2 = new MonsterCard(this, "11", 9999, 7);
		guitarAgain3 = new MonsterCard(this, "11", 9999, 7);
		headphone1 = new SpellCard(this, "12");
		headphone2 = new SpellCard(this, "12");
		microphone1 = new SpellCard(this, "13");
		microphone2 = new SpellCard(this, "13");
		microphone3 = new SpellCard(this, "13");
		manualTune2 = new FieldCard(this, "14");
		manualTune3 = new FieldCard(this, "14");
//		Collections.shuffle(this.getDeckArrayList());
	}
}
