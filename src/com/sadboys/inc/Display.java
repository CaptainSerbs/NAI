package com.sadboys.inc;

import javax.swing.*;
import com.sadboys.inc.lvl1.*;
import java.awt.*;
import java.net.URI;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;

	public JPanel gp = (JPanel) getGlassPane();
	public Keying k;
	public Menu m;
	private boolean ingame;

	public Display() {
		gp.setVisible(true);
		m = new Menu(this);
		k = new Keying(this);
		ingame = false;

		gp.setLayout(new GridLayout(1, 1, 0, 0));
		gp.setFocusable(true);
		this.setLayout(new GridLayout(1, 1, 0, 0));
		this.add(m);
	}

	public void Switch(int selection) {
		switch (m.MenuSwitch()) {
		case 1:
			switch (selection){
			case 1:
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			            desktop.browse(new URI("http://opiskelu.businesscollege.fi/s1500546/kansio/"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
					break;
			case 2:
				m.Clear();
				m.SwitchMenu(1);	
				m.ButtonSwitch();
				break;
			}
			break;
		case 2:
			switch (selection) {
			case 1:
				ingame = true;
				m.Clear();
				gp.add(k);
				gp.requestFocus();
				gp.updateUI();
				break;
			case 2:
				m.Clear();
				m.SwitchMenu(2);	
				m.ButtonSwitch();
				break;
			case 3:
				System.exit(1);
				break;
			case 4:
				m.Clear();
				m.SwitchMenu(6);
				m.ButtonSwitch();
				break;
			}
			break;
		case 3:
			switch (selection) {
			case 0:
				ingame = false;
				gp.remove(k);
				m.Clear();
				m.SwitchMenu(3);
				m.ButtonSwitch();
				gp.updateUI();
				break;
			case 1:
				m.Clear();
				ingame = true;
				gp.add(k);
				gp.requestFocus();
				gp.updateUI();
				break;
			case 2:
				k.restartReset();
				m.Clear();
				ingame = true;
				gp.add(k);
				gp.requestFocus();
				gp.updateUI();
				break;
			case 3:
				m.Clear();
				m.SwitchMenu(4);
				m.ButtonSwitch();
				k.restartReset();
				break;
			}
		case 4:
			switch (selection){
			case 1:
				m.Clear();
				m.SwitchMenu(5);
				m.ButtonSwitch();
				break;
			}
			break;
		}
	}

	public boolean inGame() {
		return ingame;
	}
}
