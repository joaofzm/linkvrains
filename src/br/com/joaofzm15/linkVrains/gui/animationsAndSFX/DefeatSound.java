package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

public class DefeatSound implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "/sound effects/defeat.wav";


	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
	}

}
