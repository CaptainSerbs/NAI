package com.sadboys.inc.characters;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sadboys.inc.Menu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mugambe {

	private double mugambexx = 600;
	private double mugambeyy = 400;
	private BufferedImage mugambe;

	public Mugambe() {

		initMugambe();

	}

	private void initMugambe() {
		try {
			mugambe = ImageIO.read(Menu.class.getResource("/images/mugambe.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	/* Enemy movement and x,y value changes */
	public double getX() {
		return mugambexx;
	}

	public double getY() {
		return mugambeyy;
	}

	public Image getImage() {
		return mugambe;
	}

	public double Down() {
		mugambeyy += 0.2;
		return mugambeyy;
	}

	public double Up() {
		mugambeyy -= 0.2;
		return mugambeyy;
	}

	public double Right() {
		mugambexx += 0.2;
		return mugambexx;
	}

	public double Left() {
		mugambexx -= 0.2;
		return mugambexx;
	}

	public void reset() {
		mugambexx = 600;
		mugambeyy = 400;
	}

}
