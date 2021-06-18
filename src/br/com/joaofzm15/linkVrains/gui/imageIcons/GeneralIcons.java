package br.com.joaofzm15.linkVrains.gui.imageIcons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GeneralIcons {
	
	private  ImageIcon coverImageIcon = new ImageIcon(getClass().getClassLoader().getResource("general cards/cover.jpg"));
	private ImageIcon miniCoverImageIcon = resizeToMini(coverImageIcon);
	private  ImageIcon bigCoverImageIcon = resizeToBig(coverImageIcon);
	
	private  ImageIcon extraCoverImageIcon = new ImageIcon(getClass().getClassLoader().getResource("general cards/extracover.jpg"));
	private ImageIcon miniExtraCoverImageIcon = resizeToMini(extraCoverImageIcon);
	private  ImageIcon bigExtraCoverImageIcon = resizeToBig(extraCoverImageIcon);

	public ImageIcon getCoverImageIcon() {
		return coverImageIcon;
	}

	public ImageIcon getMiniCoverImageIcon() {
		return miniCoverImageIcon;
	}

	public ImageIcon getBigCoverImageIcon() {
		return bigCoverImageIcon;
	}

	public ImageIcon getExtraCoverImageIcon() {
		return extraCoverImageIcon;
	}

	public ImageIcon getMiniExtraCoverImageIcon() {
		return miniExtraCoverImageIcon;
	}

	public ImageIcon getBigExtraCoverImageIcon() {
		return bigExtraCoverImageIcon;
	}
	public ImageIcon resizeToMini(ImageIcon original) {
		Image temporaryOriginalImage = original.getImage(); //Transforms original ImageIcon to Image.
		Image temporaryMiniImage = temporaryOriginalImage.getScaledInstance((int) 77.6, (int) 113.4, java.awt.Image.SCALE_SMOOTH); //Resize converted image to preferred size.
		ImageIcon resizedMiniImageIcon = new ImageIcon(temporaryMiniImage);
		return resizedMiniImageIcon;
	}
	
	public ImageIcon resizeToBig(ImageIcon original) {
		Image temporaryOriginalImage = original.getImage(); //Transforms original ImageIcon to Image.
		Image temporaryBigImage = temporaryOriginalImage.getScaledInstance((int) 271, (int) 395, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedBigImageIcon = new ImageIcon(temporaryBigImage);
		return resizedBigImageIcon;
	}


}
