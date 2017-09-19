package com.sadboys.inc.characters;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sadboys.inc.Menu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Adru {

	private double x;
	private double y;
	private double distance;
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	private BufferedImage adru;

	public Adru() {

		initAdru();

	}

	private void initAdru() {
		try {
			adru = ImageIO.read(Menu.class.getResource("/images/adru.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		x = 750;
		y = 585;
		distance = 0;
		right = false;
		left = false;
		up = false;
		down = false;

	}

	/* Enemy movement value changes */

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Image getImage() {
		return adru;
	}

	public double goDown() {
		y += 1;
		distance += 0.5;
		return y;
	}

	public double goUp() {
		y -= 1;
		distance += 0.5;
		return y;
	}

	public double goRight() {
		x += 1;
		distance += 0.5;
		return x;
	}

	public double goLeft() {
		x -= 1;
		distance += 0.5;
		return x;
	}

	public boolean Left() {
		return left;
	}

	public boolean Right() {
		return right;
	}

	public boolean Up() {
		return up;
	}

	public boolean Down() {
		return down;
	}

	public boolean Ltrue() {
		left = true;
		return left;
	}

	public boolean Rtrue() {
		right = true;
		return right;
	}

	public boolean Utrue() {
		up = true;
		return up;
	}

	public boolean Dtrue() {
		down = true;
		return down;
	}

	public boolean Lfalse() {
		left = false;
		return left;
	}

	public boolean Rfalse() {
		right = false;
		return right;
	}

	public boolean Ufalse() {
		up = false;
		return up;
	}

	public boolean Dfalse() {
		down = false;
		return down;
	}

	public void Check() {
		if (distance == 0) {
			Ltrue();
		} else if (distance == 300) {
			Lfalse();
			Utrue();
		} else if (distance == 557.5) {
			Ufalse();
			Rtrue();
		} else if (distance == 857.5) {
			Rfalse();
			Dtrue();
		} else if (distance == 882.5) {
			Dfalse();
			Ltrue();
		} else if (distance == 1152.5) {
			Lfalse();
			Dtrue();
		} else if (distance == 1202.5) {
			Dfalse();
			Rtrue();
		} else if (distance == 1462.5) {
			Rfalse();
			Dtrue();
		} else if (distance == 1512.5) {
			Dfalse();
			Ltrue();
		} else if (distance == 1627.5) {
			Lfalse();
			Dtrue();
		} else if (distance == 1667.5) {
			Dfalse();
			Ltrue();
		} else if (distance == 1807.5) {
			Lfalse();
			Dtrue();
		} else if (distance == 1857.5) {
			Dfalse();
			Rtrue();
		} else if (distance == 2123.5) {
			Rfalse();
			Dtrue();
		} else if (distance == 2165.5) {
			Dfalse();
			reset();
		}

	}

	public void reset() {
		x = 750;
		y = 585;
		distance = 0;
		right = false;
		left = false;
		up = false;
		down = false;
	}

}