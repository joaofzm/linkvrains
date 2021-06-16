package br.com.joaofzm15.linkVrains.decks;

import java.util.ArrayList;
import java.util.List;

import br.com.joaofzm15.linkVrains.cards.Card;

public class Deck {

	private List<Card> deckList = new ArrayList<Card>();

	private List<Card> extraDeckList = new ArrayList<Card>();

	public List<Card> getDeckList() {
		return deckList;
	}

	public List<Card> getExtraDeckList() {
		return extraDeckList;
	}

}
