package br.com.joaofzm15.linkVrains.cards;

import br.com.joaofzm15.linkVrains.decks.Deck;

public class MonsterCard extends Card {
	private int power;
	private int cost;

	public MonsterCard(Deck deck, String iconCode, int power, int cost) {
		super(deck, iconCode);
		this.power = power;
		this.cost = cost;
	}

	public int getPower() {
		return power;
	}

	public int getCost() {
		return cost;
	}

}
