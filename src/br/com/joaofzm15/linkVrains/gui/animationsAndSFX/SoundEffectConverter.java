package br.com.joaofzm15.linkVrains.gui.animationsAndSFX;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundEffectConverter {
	/*
	 * This class is responsible for converting a audio file path String into the
	 * actual file and getting it ready to play. All the animation threads that use
	 * any kind of sound will instantiate this class.
	 */
	private Clip clip;

	public void setFile(String soundFileName) {
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(getClass().getResource(soundFileName));
			clip = AudioSystem.getClip();
			clip.open(sound);
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-15);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
			clip.start();
	}

	public void stop() {
		clip.stop();
	}
}
