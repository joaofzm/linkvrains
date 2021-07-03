package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

public class VictorySound implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "resources/sound effects/victory.wav";


	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
	}

}
