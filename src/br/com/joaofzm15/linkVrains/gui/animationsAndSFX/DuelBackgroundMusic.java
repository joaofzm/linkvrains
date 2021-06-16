package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

public class DuelBackgroundMusic implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundLocation = "resources/sound effects/duel bgmusic.wav";

	@Override
	public void run() {
		while(true) {
			soundEffectConverter.setFile(soundLocation);
			soundEffectConverter.play();
			try {
				Thread.sleep(180000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
