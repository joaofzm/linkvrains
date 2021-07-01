package br.com.joaofzm15.linkVrains.cards;

import br.com.joaofzm15.linkVrains.decks.Deck;

public abstract class Card {

	/*
	 * This String is used to concatenate another String and form the file path by
	 * the FieldButton class.
	 * 
	 * All card images are stored in the resources folder, and are named as a
	 * number, (i.e. "3.jpg"). This variable should receive it's respective image
	 * file number as a String (i.e. "3").
	 */
	private String iconCode;

	/*
	 * All cards must be part of a Deck. Deck contain two ArrayList, one to store
	 * the main deck and one to store the extra deck. The constructor requires a
	 * Deck as a parameter, and will automatically verify if the Card is a main deck
	 * card or a extra deck card, and add it for that Deck appropriate ArrayList.
	 */
	private Deck deck;
	public Deck getDeck() {
		return deck;
	}

	public Card(Deck deck, String iconCode) {
		this.deck = deck;
		this.iconCode = iconCode;
		this.getDeck().getDeckArrayList().add(this);

	}

	public String getIconCode() {
		return this.iconCode;
	}

	@Override
	public String toString() {
		return this.iconCode;
	}



}
