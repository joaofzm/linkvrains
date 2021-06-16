package br.com.joaofzm15.linkVrains.cards;

import br.com.joaofzm15.linkVrains.decks.Deck;

public class MonsterCard extends Card {
	private int atk;
	private int def;
	private int level;
	private String type;
	private String attribute;
	private boolean tuner = false;

	public MonsterCard(Deck deck,String iconCode, int atk, int def, int level, String type, String attribute, int tuner) {
		super(deck, iconCode);
		this.atk = atk;
		this.def = def;
		this.level = level;
		this.type = type;
		this.attribute = attribute;
		if (tuner == 1) {
			this.tuner = true;
		}
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public boolean isTuner() {
		return tuner;
	}

	public void setTuner(boolean tuner) {
		this.tuner = tuner;
	}
}
