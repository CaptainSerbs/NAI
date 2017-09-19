package com.sadboys.inc.lvl1;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Collision {
	private Rectangle lowleftcol = new Rectangle(86, 551, 250, 26);
	private Rectangle lowrightcol = new Rectangle(735, 551, 60, 26);
	private Rectangle lowmidcol = new Rectangle(299, 451, 232, 26);
	private Rectangle midleftcol = new Rectangle(185, 361, 42, 26);
	private Rectangle midmidcol = new Rectangle(329, 281, 182, 26);
	private Rectangle midrightcol = new Rectangle(609, 361, 190, 26);
	private Rectangle upleftcol = new Rectangle(110, 171, 190, 26);
	private Rectangle uprightcol = new Rectangle(397, 171, 367, 26);
	private Rectangle serecol = new Rectangle(735, 451, 60, 26);
	private Rectangle mugambecol = new Rectangle(600, 400, 24, 24);
	private Rectangle adrucol = new Rectangle(750, 585, 24, 24);
	private Rectangle smileycol = new Rectangle(187, 200, 32, 30);
	private Rectangle jumpcol = new Rectangle(187, 200, 28, 2);
	private ArrayList<Rectangle> colboxes = new ArrayList<Rectangle>();

	public Collision() {
		initCol();
	}

	private void initCol() {
		colboxes.add(lowleftcol);
		colboxes.add(lowrightcol);
		colboxes.add(lowmidcol);
		colboxes.add(midleftcol);
		colboxes.add(midmidcol);
		colboxes.add(midrightcol);
		colboxes.add(upleftcol);
		colboxes.add(uprightcol);
		colboxes.add(serecol);
	}

	public ArrayList<Rectangle> getCollision() {
		return colboxes;
	}

	public Rectangle getMugambeC() {
		return mugambecol;
	}

	public Rectangle getAdruC() {
		return adrucol;
	}

	public Rectangle getSmileyC() {
		return smileycol;
	}

	public Rectangle getJumpC() {
		return jumpcol;
	}

}
