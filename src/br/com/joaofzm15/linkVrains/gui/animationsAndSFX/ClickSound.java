package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

public class ClickSound implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundLocation = "resources/sound effects/clickSound.wav";

	@Override
	public void run() {
			soundEffectConverter.setFile(soundLocation);
			soundEffectConverter.play();
	}

}
