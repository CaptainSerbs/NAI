package com.sadboys.inc.lvl1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sadboys.inc.Menu;

public class Scoresystem {

	private int x;
	private int y;
	private int scorevalue;
	private int currentscore;
	private int highscore;
	private int red;
	private int green;
	private int blue;
	private int red2;
	private int green2;
	private int blue2;
	private BufferedImage image;

	public Scoresystem() {

		initScore();
	}

	private void initScore() {
		try {
			image = ImageIO.read(Menu.class.getResource("/images/palo.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		x = 410;
		y = 420;
		scorevalue = 0;
		currentscore = 0;
		highscore = 0;
		red = 50;
		green = 50;
		blue = 50;
		red2 = 10;
		green2 = 10;
		blue2 = 10;
	}

	/* Player movement and x,y value changes */
	public int getSX() {
		return x;
	}

	public int getSY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	public int getRed2() {
		return red2;
	}

	public int getGreen2() {
		return green2;
	}

	public int getBlue2() {
		return blue2;
	}

	public void ColorR() {
		red = (int) (int) Math.floor(Math.random() * 155 + 100);
		green = (int) (int) Math.floor(Math.random() * 155 + 100);
		blue = (int) (int) Math.floor(Math.random() * 155 + 100);
	}

	public void ColorR2() {
		red2 = (int) (int) Math.floor(Math.random() * 90 + 10);
		green2 = (int) (int) Math.floor(Math.random() * 90 + 10);
		blue2 = (int) (int) Math.floor(Math.random() * 90 + 10);
	}

	public void relocateXY() {
		if (scorevalue == 1) {
			x = 120;
			y = 590;
		} else if (scorevalue == 2) {
			x = 765;
			y = 410;
		} else if (scorevalue == 3) {
			x = 410;
			y = 340;
		} else if (scorevalue == 4) {
			x = 120;
			y = 250;
		} else if (scorevalue == 5) {
			x = 120;
			y = 140;
		} else if (scorevalue == 6) {
			x = 773;
			y = 178;
		}

	}

	public void randomize() {
		if (scorevalue == 0) {
			scorevalue = (int) (int) Math.floor(Math.random() * 6 + 1);
		} else if (scorevalue == 1) {
			scorevalue = (int) (int) Math.floor(Math.random() * 5 + 2);
		} else if (scorevalue == 2) {
			scorevalue = (int) (int) Math.floor(Math.random() * 4 + 3);
		} else if (scorevalue == 3) {
			scorevalue = (int) (int) Math.floor(Math.random() * 3 + 4);
		} else if (scorevalue == 4) {
			scorevalue = (int) (int) Math.floor(Math.random() * 3 + 1);
		} else if (scorevalue == 5) {
			scorevalue = (int) (int) Math.floor(Math.random() * 4 + 1);
		} else if (scorevalue == 6) {
			scorevalue = (int) (int) Math.floor(Math.random() * 5 + 1);
		}
	}

	public int getScore() {
		return currentscore;
	}

	public void setScore() {
		currentscore++;
	}

	public void setHighscore() {
		if (currentscore > highscore) {
			highscore = currentscore;
		}
	}

	public int getHighscore() {
		return highscore;
	}

	public void reset() {
		currentscore = 0;
		scorevalue = 0;
		x = 410;
		y = 420;
		red = 50;
		green = 50;
		blue = 50;
		red2 = 10;
		green2 = 10;
		blue2 = 10;
	}

}