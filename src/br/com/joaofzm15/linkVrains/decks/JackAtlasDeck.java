package br.com.joaofzm15.linkVrains.decks;

import java.util.Collections;

import br.com.joaofzm15.linkVrains.cards.Card;
import br.com.joaofzm15.linkVrains.cards.ExtraMonsterCard;
import br.com.joaofzm15.linkVrains.cards.MonsterCard;
import br.com.joaofzm15.linkVrains.cards.SpellCard;
import br.com.joaofzm15.linkVrains.cards.TrapCard;

public class JackAtlasDeck extends Deck {
	

//	private  ImageIcon CrimsonResonatorImageIcon = new ImageIcon(getClass().getClassLoader().getResource("cards/1.jpg"));
//	private  ImageIcon RedResonatorImageIcon = new ImageIcon(getClass().getClassLoader().getResource("cards/4.jpg"));
//	private  ImageIcon RedRisingDragonImageIcon = new ImageIcon(getClass().getClassLoader().getResource("cards/10.jpg"));
//
//	public ImageIcon getCrimsonResonatorImageIcon() {
//		return CrimsonResonatorImageIcon;
//	}
//
//	public ImageIcon getRedResonatorImageIcon() {
//		return RedResonatorImageIcon;
//	}
//
//	public ImageIcon getRedRisingDragonImageIcon() {
//		return RedRisingDragonImageIcon;
//	}

	public JackAtlasDeck() {
		Card crimsomResonator1 = new MonsterCard(this, "1", 800, 300, 2, "fiend", "dark", 1);
		Card crimsomResonator2 = new MonsterCard(this, "1", 800, 300, 2, "fiend", "dark", 1);
		Card crimsomResonator3 = new MonsterCard(this, "1", 800, 300, 2, "fiend", "dark", 1);
		Card resonatorCall1 = new SpellCard(this, "2");
		Card resonatorCall2 = new SpellCard(this, "2");
		Card resonatorCall3 = new SpellCard(this, "2");
		Card WanderingKingWildwing1 = new MonsterCard(this, "3", 1700, 1300, 4, "fiend", "dark", 0);
		Card WanderingKingWildwing2 = new MonsterCard(this, "3", 1700, 1300, 4, "fiend", "dark", 0);
		Card WanderingKingWildwing3 = new MonsterCard(this, "3", 1700, 1300, 4, "fiend", "dark", 0);
		Card redResonator1 = new MonsterCard(this, "4", 600, 200, 2, "fiend", "dark", 1);
		Card redResonator2 = new MonsterCard(this, "4", 600, 200, 2, "fiend", "dark", 1);
		Card redResonator3 = new MonsterCard(this, "4", 600, 200, 2, "fiend", "dark", 1);
		Card solemnScolding1 = new TrapCard(this, "5");
		Card solemnScolding2 = new TrapCard(this, "5");
		Card solemnScolding3 = new TrapCard(this, "5");
		Card heyTrunade1 = new SpellCard(this, "6");
		Card heyTrunade2 = new SpellCard(this, "6");
		Card heyTrunade3 = new SpellCard(this, "6");
		Card lunaTheDarkSpirit1 = new MonsterCard(this, "7", 1600, 1200, 4, "fiend", "dark", 0);
		Card lunaTheDarkSpirit2 = new MonsterCard(this, "7", 1600, 1200, 4, "fiend", "dark", 0);
		Collections.shuffle(this.getDeckList());
		// -----------------Extra deck ------------------------------------
		Card redDragonArchfiend = new ExtraMonsterCard(this, "8", 3000, 2000, 8, "dragon", "dark", 0, "synchro");
		Card redRisingDragon1 = new ExtraMonsterCard(this, "9", 2100, 1600, 6, "dragon", "dark", 0, "synchro");
		Card redRisingDragon2 = new ExtraMonsterCard(this, "9", 2100, 1600, 6, "dragon", "dark", 0, "synchro");
		Card redRisingDragon3 = new ExtraMonsterCard(this, "9", 2100, 1600, 6, "dragon", "dark", 0, "synchro");
		Card hotRedDragonArchfiendBane = new ExtraMonsterCard(this, "10", 3500, 3000, 10, "dragon", "dark", 0, "synchro");
		Card redNovaDragon = new ExtraMonsterCard(this, "11", 3500, 3000, 12, "dragon", "dark", 0, "synchro");
	}

	
	
	

}
