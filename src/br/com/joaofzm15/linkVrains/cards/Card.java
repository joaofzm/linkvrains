package br.com.joaofzm15.linkVrains.cards;

import br.com.joaofzm15.linkVrains.decks.Deck;

public abstract class Card {

	private String iconCode;

	private Deck deck;

	public Card(Deck deck, String iconCode) {
		this.deck = deck;
		this.iconCode = iconCode;
		if (this.getClass() != ExtraMonsterCard.class) {
			this.deck.getDeckList().add(this);
		} else {
			this.deck.getExtraDeckList().add(this);
		}
	}

	public String getIconCode() {
		return this.iconCode;
	}

	@Override
	public String toString() {
		return this.iconCode;
	}

}
