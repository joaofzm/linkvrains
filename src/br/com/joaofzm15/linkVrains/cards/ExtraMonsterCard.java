package br.com.joaofzm15.linkVrains.cards;

import br.com.joaofzm15.linkVrains.decks.Deck;

public class ExtraMonsterCard extends Card {
	private int power;
	private int level;
	private String attribute;

	public ExtraMonsterCard(Deck deck, String iconCode, int power, int level, String attribute) {
		super(deck, iconCode);
		this.power = power;
		this.level = level;
		this.attribute = attribute;
	}

	public int getAtk() {
		return power;
	}

	public int getLevel() {
		return level;
	}

	public String getAttribute() {
		return attribute;
	}

}
