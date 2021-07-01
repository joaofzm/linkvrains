package br.com.joaofzm15.linkVrains.decks;

import java.util.ArrayList;
import java.util.List;

import br.com.joaofzm15.linkVrains.cards.Card;

public abstract class Deck {

	/*
	 * The Card constructor receives a Deck as a parameter, and automatically adds
	 * the just created Card this class array list.
	 */
	private List<Card> deckArrayList = new ArrayList<Card>();

	public List<Card> getDeckArrayList() {
		return deckArrayList;
	}

}
