package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

public class ErrorSound implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "resources/sound effects/error.wav";

	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
	}

}
