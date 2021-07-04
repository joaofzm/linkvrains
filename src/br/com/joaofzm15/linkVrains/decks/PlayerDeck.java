package br.com.joaofzm15.linkVrains.decks;

import java.util.Collections;

import br.com.joaofzm15.linkVrains.cards.Card;
import br.com.joaofzm15.linkVrains.cards.FieldCard;
import br.com.joaofzm15.linkVrains.cards.MonsterCard;
import br.com.joaofzm15.linkVrains.cards.SpellCard;

public class PlayerDeck extends Deck {
	
	Card iris1;
	Card iris2;
	Card iris3;
	Card fovea1;
	Card fovea2;
	Card fovea3;
	Card sclera1;
	Card sclera2;
	Card sclera3;
	Card retina1;
	Card retina2;
	Card retina3;
	Card tears1;
	public Card getTears1() {
		return tears1;
	}
	Card tears2;
	public Card getTears2() {
		return tears2;
	}
	Card glasses1;
	public Card getGlasses1() {
		return glasses1;
	}
	Card glasses2;
	public Card getGlasses2() {
		return glasses2;
	}
	Card glasses3;
	public Card getGlasses3() {
		return glasses3;
	}
	Card sun1;
	public Card getSun1() {
		return sun1;
	}
	Card sun2;
	public Card getSun2() {
		return sun2;
	}
	Card sun3;
	public Card getSun3() {
		return sun3;
	}

	public PlayerDeck() {
		// -----------------Main deck ------------------------------------
		iris1 = new MonsterCard(this, "1", 1000, 1);
		iris2 = new MonsterCard(this, "1", 1000, 1);
		iris3 = new MonsterCard(this, "1", 1000, 1);
		fovea1 = new MonsterCard(this, "2", 1500, 2);
		fovea2 = new MonsterCard(this, "2", 1500, 2);
		fovea3 = new MonsterCard(this, "2", 1500, 2);
		sclera1 = new MonsterCard(this, "3", 2500, 4);
		sclera2 = new MonsterCard(this, "3", 2500, 4);
		sclera3 = new MonsterCard(this, "3", 2500, 4);
		retina1 = new MonsterCard(this, "4", 5000, 8);
		retina2 = new MonsterCard(this, "4", 5000, 8);
		retina3 = new MonsterCard(this, "4", 5000, 8);
		tears1 = new SpellCard(this, "5");
		tears2 = new SpellCard(this, "5");
		glasses1 = new SpellCard(this, "6");
		glasses2 = new SpellCard(this, "6");
		glasses3 = new SpellCard(this, "6");
		sun1 = new FieldCard(this, "7");
		sun2 = new FieldCard(this, "7");
		sun3 = new FieldCard(this, "7");
		Collections.shuffle(this.getDeckArrayList());
	}
}
