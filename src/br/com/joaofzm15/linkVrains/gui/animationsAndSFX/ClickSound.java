package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

public class ClickSound implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "/sound effects/clickSound.wav";


	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
	}

}
