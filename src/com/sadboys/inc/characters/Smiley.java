package com.sadboys.inc.characters;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sadboys.inc.Menu;

public class Smiley {

	private double x;
	private double y;
	private double rotation;
	private int jumponce;
	public boolean right;
	public boolean left;
	public boolean jumping;
	public boolean gravity;
	private BufferedImage image;

	public Smiley() {

		initSmiley();
	}

	private void initSmiley() {

		try {
			image = ImageIO.read(Menu.class.getResource("/images/mainchar.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		x = 187;
		y = 200;
		rotation = 0;
		jumponce = 0;
		right = false;
		left = false;
		jumping = false;
	}

	/* Player movement and x,y value changes */
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean Left() {
		return left;
	}

	public boolean Right() {
		return right;
	}

	public boolean Jumping() {
		return jumping;
	}
	public boolean Gravity() {
		return gravity;
	}

	public boolean Ltrue() {
		left = true;
		return left;
	}

	public boolean Rtrue() {
		right = true;
		return right;
	}

	public boolean Jtrue() {
		jumping = true;
		return jumping;
	}
	public boolean Gtrue() {
		gravity = true;
		return gravity;
	}

	public boolean Lfalse() {
		left = false;
		return left;
	}

	public boolean Rfalse() {
		right = false;
		return right;
	}

	public boolean Jfalse() {
		jumping = false;
		return jumping;
	}
	public boolean Gfalse() {
		gravity = false;
		return gravity;
	}

	public Image getImage() {
		return image;
	}

	public double GravityOn() {
		y++;
		return y;
	}

	public double doJump() {
		y--;
		return y;
	}

	public double goRight() {
		x+=1.1;
		return x;
	}

	public double goLeft() {
		x-=1.1;
		return x;
	}

	public int getOnce() {
		return jumponce;
	}

	public int setOnce() {
		jumponce++;
		return jumponce;
	}

	public int setOnceback() {
		jumponce--;
		return jumponce;
	}

	public void doFlip() {
		rotation -= 3;
	}

	public double Rotation() {
		return rotation;
	}

	public void Steady() {
		if (rotation != 0) {
			rotation = 0;
		}
	}

	public void reset() {
		x = 187;
		y = 200;
	}

}