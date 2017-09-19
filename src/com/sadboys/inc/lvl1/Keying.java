package com.sadboys.inc.lvl1;

import javax.swing.*;

import com.sadboys.inc.Display;
import com.sadboys.inc.Music;
import com.sadboys.inc.characters.*;
import com.sadboys.inc.database.Datastorage;
import com.sadboys.inc.database.Score;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Keying extends JPanel {
	private static final long serialVersionUID = 1L;

	public static Smiley smiley = new Smiley();
	public static Mugambe mugambe = new Mugambe();
	public static Adru adru = new Adru();
	public static MrMustache mrm = new MrMustache();
	public static SlimG slim = new SlimG();
	public static Scoresystem score = new Scoresystem();
	public static ArtBox art = new ArtBox();
	public static Leveldesign lvl = new Leveldesign();
	public static Collision col = new Collision();
	public static Music music = new Music();
	private Datastorage dataregister=new Datastorage();
	public Ellipse2D.Double scorecol;
	private int alignment = 35;
	private boolean Rpressed;
	private boolean Lpressed;

	public Keying(Display f) {

		/* Key binders */
		f.gp.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (f.inGame()) {
					music.setVolume();
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						Rpressed = true;
					}
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						Lpressed = true;
					}
					for (int i = 0; i < lvl.getLevel().size() - 3; i++) {
						if (CheckJ(e, lvl.getLevel().get(i), col.getSmileyC())) {
							smiley.Jtrue();
							Music.Soundeffects(1);
							smiley.setOnce();
							break;
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						smiley.Jfalse();
					}
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
						f.Switch(0);
					}
				}
			}
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					Rpressed = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					Lpressed = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					smiley.setOnceback();
				}
			}

		});
	}

	/*
	 * Painter for game models. If statements limit the ones that need to spawn later
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		AffineTransform old = g2d.getTransform();
		g2d.rotate(Math.toRadians(smiley.Rotation()), smiley.getX() + 15, smiley.getY() + 15);
		g2d.drawImage(smiley.getImage(), (int) smiley.getX(), (int) smiley.getY(), this);
		g2d.setTransform(old);

		Toolkit.getDefaultToolkit().sync();

		this.setBackground(new Color(score.getRed2(), score.getGreen2(), score.getBlue2(), 255));
		g.setColor(new Color(0, 0, 0, 0));

		for (int i = 0; i < col.getCollision().size(); i++) {
			g.fillRect(col.getCollision().get(i).x, col.getCollision().get(i).y, col.getCollision().get(i).width,
					col.getCollision().get(i).height);
		}

		g.fillRect(col.getMugambeC().x = (int) mugambe.getX() + 3, col.getMugambeC().y = (int) mugambe.getY() + 3,
				col.getMugambeC().width, col.getMugambeC().height);

		if (score.getScore() >= 10) {
			g.fillRect(col.getAdruC().x = (int) adru.getX() + 3, col.getAdruC().y = (int) adru.getY() + 3,
					col.getAdruC().width, col.getAdruC().height);
		}

		g.fillRect(col.getSmileyC().x = (int) smiley.getX() - 1, col.getSmileyC().y = (int) smiley.getY(),
				col.getSmileyC().width, col.getSmileyC().height);
		g.fillRect(col.getJumpC().x = (int) smiley.getX() + 1, col.getJumpC().y = (int) smiley.getY(),
				col.getJumpC().width, col.getJumpC().height);
		g.setColor(new Color(score.getRed(), score.getGreen(), score.getBlue(), 255));

		for (int i = 0; i < lvl.getLevel().size(); i++) {
			g.fillRect(lvl.getLevel().get(i).x, lvl.getLevel().get(i).y, lvl.getLevel().get(i).width,
					lvl.getLevel().get(i).height);
		}

		g2d.drawImage(art.getImage(), art.getX(), art.getY(), this);
		g2d.drawImage(mugambe.getImage(), (int) mugambe.getX(), (int) mugambe.getY(), this);

		if (score.getScore() >= 10) {
			g2d.drawImage(adru.getImage(), (int) adru.getX(), (int) adru.getY(), this);
		}

		g2d.drawImage(score.getImage(), score.getSX(), score.getSY(), this);
		scorecol = new Ellipse2D.Double(score.getSX() + 0.5, score.getSY() + 0.5, 18, 18);
		g2d.fill(scorecol);

		if (score.getScore() >= 20) {
			g2d.drawImage(slim.getImage(), (int) slim.getX(), (int) slim.getY(), this);
		}
		if (score.getScore() >= 21) {
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(slim.getBullet().x, slim.getBullet().y, slim.getBullet().width, slim.getBullet().height);
		}
		if (slim.Firerate()) {
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(slim.getBullet2().x, slim.getBullet2().y, slim.getBullet2().width, slim.getBullet2().height);
		}
		if (score.getScore() >= 30) {
			g2d.drawImage(mrm.getImage(), (int) mrm.getX(), (int) mrm.getY(), this);
		}
		if (score.getScore() >= 31) {
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(mrm.getBlast().x, mrm.getBlast().y, mrm.getBlast().width, mrm.getBlast().height);
		}
		if (mrm.Firerate()) {
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(mrm.getBlast2().x, mrm.getBlast2().y, mrm.getBlast2().width, mrm.getBlast2().height);
		}

		g.setColor(new Color(255, 255, 255, 255));
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g.drawString("Score:", 13, 25);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		g.drawString("" + score.getScore(), alignment, 60);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g.drawString("Pause: Esc", 773, 25);
		/* 
		 * Checks game mechanics while painting 
		 */
		Adruproperties();
		Mrmproperties();
		Slimproperties();
		Mugambeproperties();
		Smileyproperties();
		Scoreproperties();
		
		repaint();
	}
	
	/*
	 * Jump limitations
	 */
	private boolean CheckJ(KeyEvent e, Rectangle plat, Rectangle col) {
		return e.getKeyCode() == KeyEvent.VK_UP && smiley.getOnce() != 1 && plat.intersects(col);
	}

	/*
	 * Player movement limitations and mechanics
	 */
	private void Smileyproperties() {
		for (int i = 0; i < lvl.getLevel().size() - 3; i++) {
			if (!smiley.Jumping() && !lvl.getLevel().get(i).intersects(col.getSmileyC())) {
				smiley.Gtrue();
			} else {
				smiley.Gfalse();
				break;
			}
		}
		if (smiley.Gravity()) {
			smiley.GravityOn();
		}
		for (int i = 0; i < col.getCollision().size(); i++) {
			if (Rpressed && !col.getCollision().get(i).intersects(col.getSmileyC())
					&& !lvl.getLevel().get(10).intersects(col.getSmileyC())) {
				smiley.Rtrue();
			} else if (Rpressed && col.getCollision().get(i).intersects(col.getSmileyC())
					&& lvl.getLevel().get(i).intersects(col.getSmileyC())) {
				smiley.doJump();
			} else {
				smiley.Rfalse();
				break;
			}
		}
		if (smiley.Right()) {
			smiley.goRight();
		}
		for (int i = 0; i < col.getCollision().size(); i++) {
			if (Lpressed && !col.getCollision().get(i).intersects(col.getSmileyC())
					&& !lvl.getLevel().get(12).intersects(col.getSmileyC())) {
				smiley.Ltrue();
			} else if (Lpressed && col.getCollision().get(i).intersects(col.getSmileyC())
					&& lvl.getLevel().get(i).intersects(col.getSmileyC())) {
				smiley.doJump();
			} else {
				smiley.Lfalse();
				break;
			}
		}
		if (smiley.Left()) {
			smiley.goLeft();
		}
		if (smiley.Jumping()) {
			if (smiley.Rotation() >= -360) {
				smiley.doJump();
				smiley.doFlip();
			} else {
				smiley.Jfalse();
			}
		}
		if (!smiley.Jumping()) {
			smiley.Steady();
		}
		for (int i = 0; i < col.getCollision().size(); i++) {
			if (smiley.Jumping() && col.getCollision().get(i).intersects(col.getSmileyC())
					&& col.getCollision().get(i).intersects(col.getJumpC())
					|| smiley.Jumping() && lvl.getLevel().get(11).intersects(col.getSmileyC())
							&& lvl.getLevel().get(11).intersects(col.getJumpC())) {
				smiley.Jfalse();
				break;
			}
		}
	}

	/*
	 * Mugambe's mechanics (first enemy)
	 */
	private void Mugambeproperties() {
		if (mugambe.getX() > smiley.getX()) {
			mugambe.Left();
		}
		if (mugambe.getX() < smiley.getX()) {
			mugambe.Right();
		}
		if (mugambe.getY() > smiley.getY()) {
			mugambe.Up();
		}
		if (mugambe.getY() < smiley.getY()) {
			mugambe.Down();
		}
		if (col.getMugambeC().intersects(col.getSmileyC())) {
			Music.Soundeffects(2);
			deathReset();
		}
	}

	/*
	 * Adru's mechanics (second enemy)
	 */
	private void Adruproperties() {
		if (score.getScore() >= 10) {
			adru.Check();
			if (adru.Up()) {
				adru.goUp();
			}
			if (adru.Down()) {
				adru.goDown();
			}
			if (adru.Left()) {
				adru.goLeft();
			}
			if (adru.Right()) {
				adru.goRight();
			}
			if (col.getAdruC().intersects(col.getSmileyC())) {
				Music.Soundeffects(2);
				deathReset();
			}
		}
	}

	/*
	 * SlimG's mechanics (third enemy)
	 */
	private void Slimproperties() {
		if (score.getScore() >= 20) {
			slim.Check();
			if (score.getScore() >= 21) {
				slim.Shoot();
			}
			if (score.getScore() >= 40) {
				slim.Shoot2(true);
			}
			if (slim.Up()) {
				slim.goUp();
			}
			if (slim.Down()) {
				slim.goDown();
			}
			if (slim.Pew()) {
				Music.Soundeffects(3);
			}
			if (slim.Pew2()) {
				Music.Soundeffects(3);
			}
			if (slim.getBullet().intersects(col.getSmileyC())) {
				Music.Soundeffects(2);
				deathReset();
			}
			if (slim.getBullet2().intersects(col.getSmileyC())) {
				Music.Soundeffects(2);
				deathReset();
			}
		}
	}

	/*
	 * MrMustache's mechanics (fourth enemy)
	 */
	private void Mrmproperties() {
		if (score.getScore() >= 30) {
			mrm.Check();
			if (score.getScore() >= 31) {
				mrm.Shoot();
			}
			if (score.getScore() >= 50) {
				mrm.Shoot2(true);
			}
			if (mrm.Up()) {
				mrm.goUp();
			}
			if (mrm.Down()) {
				mrm.goDown();
			}
			if (mrm.Boom()) {
				Music.Soundeffects(4);
			}
			if (mrm.Boom2()) {
				Music.Soundeffects(4);
			}
			if (mrm.getBlast().intersects(col.getSmileyC())) {
				Music.Soundeffects(2);
				deathReset();
			}
			if (mrm.getBlast2().intersects(col.getSmileyC())) {
				Music.Soundeffects(2);
				deathReset();
			}
		}
	}

	/*
	 * Score mechanics
	 */
	private void Scoreproperties() {
		if (scorecol.intersects(col.getSmileyC())) {
			Music.Soundeffects(5);
			score.randomize();
			score.relocateXY();
			score.setScore();
			score.ColorR();
			if (score.getScore() >= 10 && score.getScore() < 100) {
				alignment = 29;
			} else if (score.getScore() >= 100 && score.getScore() <= 1000) {
				alignment = 23;
			} else if (score.getScore() >= 1000) {
				alignment = 17;
			}
			if (score.getScore() >= 10) {
				score.ColorR2();
			}
		}
	}

	/*
	 * Resets the needed values when you die so the game can start over
	 */
	public void deathReset() {
		dataregister.addScore(new Score(1, score.getScore(), 0));
		score.setHighscore();
		smiley.reset();
		mugambe.reset();
		score.reset();
		adru.reset();
		mrm.reset();
		slim.reset();
	}
	public void restartReset() {
		score.setHighscore();
		smiley.reset();
		mugambe.reset();
		score.reset();
		adru.reset();
		mrm.reset();
		slim.reset();
	}
}