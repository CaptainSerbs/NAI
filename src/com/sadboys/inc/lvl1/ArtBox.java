package com.sadboys.inc.lvl1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sadboys.inc.Menu;

public class ArtBox {

	private int x;
	private int y;
	private BufferedImage image;

	public ArtBox() {

		initArt();
	}

	private void initArt() {
		try {
			image = ImageIO.read(Menu.class.getResource("/images/artst.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		x = -2;
		y = -27;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
