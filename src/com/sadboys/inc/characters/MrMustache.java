package com.sadboys.inc.characters;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sadboys.inc.Menu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MrMustache {

	private double x;
	private double y;
	private double distance;
	private double blasttravel;
	private double blasttravel2;
	private boolean firerate;
	private boolean up;
	private boolean down;
	private boolean boom;
	private boolean boom2;
	private BufferedImage mrmustache;
	private Rectangle blast;
	private Rectangle blast2;

	public MrMustache() {

		initMrMustache();

	}

	private void initMrMustache() {
		try {
			mrmustache = ImageIO.read(Menu.class.getResource("/images/MrMoustache.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		x = 840;
		y = 485;
		distance = 0;
		blasttravel = 0;
		blasttravel2 = 0;
		firerate = false;
		up = false;
		down = false;
		boom = false;
		blast = new Rectangle(845, 300, 8, 100);
		blast2 = new Rectangle(845, 300, 8, 100);

	}

	/* Enemy movement value changes */

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Image getImage() {
		return mrmustache;
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
		if(distance==0){
			Utrue();
		}else if(distance==157.5){
			Ufalse();
			Dtrue();
		}else if(distance==315){
			Ufalse();
			x = 840;
			y = 485;
			distance = 0;
			up = false;
			down = false;
		}
	}
	public void Shoot() {
		blast.x--;
		blasttravel++;
		if(blasttravel<=1){
			blast.y=(int)y+10;
			boom = true;
		}else{
			boom = false;
		}
		if(blasttravel==1500){
			resetBlast();
		}
		
	}
	public void Shoot2(boolean rip) {
		if (blasttravel == 750 && rip){
			firerate = true;
		}
		if (firerate){
			blast2.x--;
			blasttravel2++;
			if(blasttravel2<=1){
				blast2.y=(int)y+10;
				boom2 = true;
			}else{
				boom2 = false;
			}
			if(blasttravel2==1500){
				resetBlast2();
			}
		}
		
	}
	
	public Rectangle getBlast() {
		return blast;
	}
	public Rectangle getBlast2() {
		return blast2;
	}
	public boolean Boom(){
		return boom;
	}
	public boolean Boom2(){
		return boom2;
	}
	public boolean Firerate(){
		return firerate;
	}
	public void resetBlast(){
		blasttravel = 0;
		blast.x = 845;
		blast.y=(int)y+10;
		
	}
	public void resetBlast2(){
		blasttravel2 = 0;
		blast2.x = 845;
		blast2.y=(int)y+10;
		
	}
	public void reset() {
		x = 840;
		y = 485;
		blasttravel = 0;
		blasttravel2 = 0;
		distance = 0;
		firerate = false;
		up = false;
		down = false;
		blast = new Rectangle(845, 300, 8, 100);
		blast2 = new Rectangle(845, 300, 8, 100);
		
	}

}