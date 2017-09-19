package com.sadboys.inc.lvl1;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Leveldesign {

	private Rectangle lvlrightside = new Rectangle(795, 30, 25, 600);
	private Rectangle lvltop = new Rectangle(85, 30, 735, 25);
	private Rectangle lvlleftside = new Rectangle(85, 30, 25, 600);
	private Rectangle lvlbottom = new Rectangle(85, 620, 735, 25);
	private Rectangle lowleftplat = new Rectangle(85, 550, 250, 25);
	private Rectangle lowmidplat = new Rectangle(300, 450, 230, 25);
	private Rectangle lowrightplat = new Rectangle(736, 550, 60, 25);
	private Rectangle midmidplat = new Rectangle(330, 280, 180, 25);
	private Rectangle midrightplat = new Rectangle(610, 360, 190, 25);
	private Rectangle midleftplat = new Rectangle(186, 360, 40, 25);
	private Rectangle upleftplat = new Rectangle(109, 170, 190, 25);
	private Rectangle uprightplat = new Rectangle(398, 170, 365, 25);
	private Rectangle sereplat = new Rectangle(736, 450, 60, 25);
	private ArrayList<Rectangle> platforms = new ArrayList<Rectangle>();

	public Leveldesign() {

		initLvl();
	}

	private void initLvl() {
		
		platforms.add(lvlbottom);
		platforms.add(lowleftplat);
		platforms.add(lowmidplat);
		platforms.add(lowrightplat);
		platforms.add(midmidplat);
		platforms.add(midrightplat);
		platforms.add(midleftplat);
		platforms.add(upleftplat);
		platforms.add(uprightplat);
		platforms.add(sereplat);
		platforms.add(lvlrightside);
		platforms.add(lvltop);
		platforms.add(lvlleftside);
	}

	public ArrayList<Rectangle> getLevel(){
		return platforms;
	}
}
