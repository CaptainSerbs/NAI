package com.sadboys.inc.characters;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sadboys.inc.Menu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SlimG {

	private double x;
	private double y;
	private double distance;
	private double bullettravel;
	private double bullettravel2;
	private boolean firerate;
	private boolean up;
	private boolean down;
	private boolean pew;
	private boolean pew2;
	private BufferedImage slim;
	private Rectangle bullet;
	private Rectangle bullet2;

	public SlimG() {

		initSlimG();

	}

	private void initSlimG() {
		try {
			slim = ImageIO.read(Menu.class.getResource("/images/SlimG.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		x = 40;
		y = 585;
		distance = 0;
		bullettravel = 0;
		bullettravel2 = 0;
		firerate = false;
		up = false;
		down = false;
		pew = false;
		pew2 = false;
		bullet = new Rectangle(45, 300, 35, 8);
		bullet2 = new Rectangle(45, 300, 35, 8);
		
	}

	/* Enemy movement and x,y value changes */

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Image getImage() {
		return slim;
	}

	public double goDown() {
		y += 0.5;
		distance += 0.25;
		return y;
	}

	public double goUp() {
		y -= 0.5;
		distance += 0.25;
		return y;
	}

	public boolean Up() {
		return up;
	}

	public boolean Down() {
		return down;
	}

	public boolean Utrue() {
		up = true;
		return up;
	}

	public boolean Dtrue() {
		down = true;
		return down;
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
			Utrue();
		} else if (distance == 257.5) {
			Ufalse();
			Dtrue();
		} else if (distance == 515) {
			Ufalse();
			x = 40;
			y = 585;
			distance = 0;
			up = false;
			down = false;
		}
	}

	public void Shoot() {
		bullet.x++;
		bullettravel++;
		if (bullettravel <= 1) {
			bullet.y = (int) y + 10;
			pew = true;
		}else{
			pew = false ;
		}
		if (bullettravel == 1000) {
			resetBullet();
		}
	}

	
	public void Shoot2(boolean rip) {
		if (bullettravel == 500 && rip){
			firerate = true;
		}
		if (firerate){
			bullet2.x++;
			bullettravel2++;
			if (bullettravel2 <= 1) {
				bullet2.y = (int) y + 10;
				pew2 = true;
			}else{
				pew2 = false ;
			}
			if (bullettravel2 == 1000) {
				resetBullet2();
			}
		}
	}


	public Rectangle getBullet() {
		return bullet;
	}
	public Rectangle getBullet2() {
		return bullet2;
	}
	public boolean Pew() {
		return pew;
	}
	public boolean Pew2() {
		return pew2;
	}
	public boolean Firerate() {
		return firerate;
	}

	public void resetBullet() {
		bullettravel = 0;
		bullet.x = 40;
		bullet.y = (int) y + 10;
		
	}
	
	public void resetBullet2() {
		bullettravel2 = 0;
		bullet2.x = 40;
		bullet2.y = (int) y + 10;
		
	}

	public void reset() {
		x = 40;
		y = 585;
		distance = 0;
		up = false;
		down = false;
		firerate = false;
		bullettravel = 0;
		bullettravel2 = 0;
		bullet = new Rectangle(45, 300, 35, 8);
		bullet2 = new Rectangle(45, 300, 35, 8);

	}

}