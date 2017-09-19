package com.sadboys.inc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.sadboys.inc.database.Datastorage;
import com.sadboys.inc.database.Playerlogin;

public class Menu extends JPanel {
	private static final long serialVersionUID = 1L;
	private Font sansfont = new Font("Comic Sans MS", Font.BOLD, 18);
	private Font sansfont2 = new Font("Comic Sans MS", Font.BOLD, 28);
	private JTextField email = new JTextField(50);
	private JPasswordField pass = new JPasswordField(20);
	private JButton log = new JButton("Login");
	private JButton reg = new JButton("Register");
	private JButton start = new JButton("Start");
	private JButton leader = new JButton("Leaderboards");
	private JButton quit = new JButton("Quit");
	private JButton resume = new JButton("Resume");
	private JButton restart = new JButton("Restart");
	private JButton menu = new JButton("Main menu");
	private JButton back = new JButton("Back");
	private JButton logout = new JButton("Log out");
	private JButton X = new JButton("X");
	private BufferedImage login;
	private BufferedImage main;
	private BufferedImage pause;
	private BufferedImage lead;
	private JList playerscore;
	private JList topuser;
	private JList topscore;
	private JScrollPane userscroll;
	private JScrollPane scorescroll;
	private JScrollPane playerscroll;
	private int menuswitch = 1;
	private int red = 10;
	private int green = 10;
	private int blue = 10;
	private int fade = 0;
	private int opacity;
	private int timer = 0;
	private boolean trufade;
	private boolean blink = false;
	private boolean list = false;
	private String error = "False email or password";
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private String loggeduser;
	private Datastorage dataregister = new Datastorage();
	private String password;
	private Playerlogin loggedPlayer;

	public Menu(Display f) {
		try {
			login = ImageIO.read(Menu.class.getResource("/images/loginscreen.png"));
			main = ImageIO.read(Menu.class.getResource("/images/startmenu.png"));
			pause = ImageIO.read(Menu.class.getResource("/images/pausmeni.png"));
			lead = ImageIO.read(Menu.class.getResource("/images/lederbord.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// login = loginscreen.getImage();

		buttons.add(log);
		buttons.add(reg);
		buttons.add(start);
		buttons.add(leader);
		buttons.add(quit);
		buttons.add(resume);
		buttons.add(restart);
		buttons.add(menu);
		buttons.add(back);
		buttons.add(logout);
		buttons.add(X);
		this.add(X);
		ButtonSwitch();
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setFont(sansfont2);
			buttons.get(i).setForeground(new Color(0, 0, 0, 255));
			buttons.get(i).setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 255), 3));
			buttons.get(i).addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {

				}

				public void mouseEntered(MouseEvent e) {
					Object source = e.getSource();
					JButton current = (JButton) source;
					current.setBackground(new Color((int) Math.floor(Math.random() * 215 + 40),
							(int) Math.floor(Math.random() * 215 + 40), (int) Math.floor(Math.random() * 215 + 40),
							255));
					Colorize();
				}

				public void mouseExited(MouseEvent e) {
					Object source = e.getSource();
					JButton current = (JButton) source;
					current.setBackground(Color.WHITE);
				}

				public void mousePressed(MouseEvent e) {
					Object source = e.getSource();
					if (source == restart) {
						f.Switch(2);
					} else if (source == X) {
						System.exit(1);
					} else if (source == reg) {
						f.Switch(1);
					} else if (source == quit || source == menu) {
						f.Switch(3);
					} else if (source == start) {
						f.Switch(1);
						menuswitch = 3;
					} else if (source == resume) {
						f.Switch(1);
						menuswitch = 3;
					} else if (source == back) {
						list = false;
						listClear();
						f.Switch(1);
					} else if (source == logout) {
						loggedPlayer = null;
						loggeduser = null;
						email.setText("");
						pass.setText("");
						f.Switch(4);
					} else if (source == leader) {
						playerscore = new JList(dataregister.getPlayerScores().toArray());
						playerscore.setEnabled(false);
						playerscore.setBackground(new Color(0, 0, 0, 255));
						playerscore.setFont(sansfont2);

						playerscroll = new JScrollPane(playerscore);
						playerscroll.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 3));

						topuser = new JList(dataregister.getTopUsers().toArray());
						topuser.setEnabled(false);
						topuser.setBackground(new Color(0, 0, 0, 255));
						topuser.setFont(sansfont2);

						userscroll = new JScrollPane(topuser);
						userscroll.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 3));

						topscore = new JList(dataregister.getTopScores().toArray());
						topscore.setEnabled(false);
						topscore.setBackground(new Color(0, 0, 0, 255));
						topscore.setFont(sansfont2);

						scorescroll = new JScrollPane(topscore);
						scorescroll.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 3));

						list = true;
						f.Switch(2);
					} else if (source == log) {
						try {
							password = String.valueOf(pass.getPassword());
							try {
								MessageDigest md = MessageDigest.getInstance("MD5");
								md.update(password.getBytes());
								byte byteData[] = md.digest();
								StringBuffer sb = new StringBuffer();
								
								for (int i = 0; i < byteData.length; i++) {
									sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
								}
								password = sb.toString();
								
							} catch (Exception F) {

							}
							loggedPlayer = dataregister.logPlayer(password, email.getText());
							
							if (loggedPlayer == null) {
								trufade = true;
								return;
							} else {
								Shortcut.Cut(loggedPlayer.getUserID());
								loggeduser = loggedPlayer.getUsername();
								f.Switch(2);
							}
							
						} catch (NumberFormatException nfe) {

						}
					}
				}

				public void mouseReleased(MouseEvent e) {

				}
			});
		}
	}

	public void paintComponent(Graphics g) {
		email.setBounds(200, 417, 460, 33);
		pass.setBounds(200, 523, 460, 33);
		log.setBounds(428, 607, 193, 61);
		reg.setBounds(226, 607, 193, 61);
		start.setBounds(311, 337, 261, 73);
		leader.setBounds(311, 455, 261, 73);
		quit.setBounds(311, 573, 261, 73);
		resume.setBounds(311, 337, 261, 73);
		restart.setBounds(311, 455, 261, 73);
		menu.setBounds(311, 573, 261, 73);
		back.setBounds(711, 88, 161, 53);
		logout.setBounds(11, 28, 161, 43);
		X.setBounds(850, 0, 50, 35);
		email.setOpaque(false);
		pass.setOpaque(false);
		email.setForeground(new Color(255, 255, 255, 255));
		pass.setForeground(new Color(255, 255, 255, 255));
		email.setHorizontalAlignment(JTextField.CENTER);
		pass.setHorizontalAlignment(JTextField.CENTER);
		email.setFont(sansfont);
		pass.setFont(sansfont);
		if (list) {
			playerscroll.setBounds(61, 168, 243, 493);
			userscroll.setBounds(357, 168, 293, 493);
			scorescroll.setBounds(647, 168, 193, 493);
			playerscore.updateUI();
			playerscroll.updateUI();
			topuser.updateUI();
			userscroll.updateUI();
			topscore.updateUI();
			scorescroll.updateUI();
		}
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Toolkit.getDefaultToolkit().sync();
		this.setBackground(new Color(red, green, blue, 255));
		g.setColor(new Color(255, 255, 255, 255));
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		if (loggeduser == null) {
			g.drawString("Pre alpha early access version", 10, 20);
		} else {
			g.drawString("Pre alpha early access version, logged in user: " + loggeduser, 10, 20);
		}
		g.setColor(new Color(255, 105, 105, fade));
		g.drawString(error, 320, 495);
		Errormessage();
		switch (menuswitch) {
		case 1:
			g2d.drawImage(login, 0, 0, this);
			break;
		case 2:
			g2d.drawImage(main, 0, 0, this);
			break;
		case 3:
			g2d.drawImage(pause, 0, 0, this);
			break;
		case 4:
			g2d.drawImage(lead, 0, 0, this);
			break;
		}

		repaint();
	}

	public void Clear() {
		this.remove(email);
		this.remove(pass);
		for (int i = 0; i < buttons.size() - 1; i++) {
			this.remove(buttons.get(i));
		}
	}

	public void listClear() {
		this.remove(playerscroll);
		this.remove(userscroll);
		this.remove(scorescroll);
	}

	public void ButtonSwitch() {
		switch (menuswitch) {
		case 1:
			this.add(email);
			this.add(pass);
			this.add(log);
			this.add(reg);
			break;
		case 2:
			this.add(start);
			this.add(leader);
			this.add(quit);
			this.add(logout);
			break;
		case 3:
			this.add(resume);
			this.add(restart);
			this.add(menu);
			break;
		case 4:
			this.add(back);
			this.add(playerscroll);
			this.add(userscroll);
			this.add(scorescroll);
			break;
		}
	}

	public int MenuSwitch() {
		return menuswitch;
	}

	public void SwitchMenu(int scenario) {
		switch (scenario) {
		case 1:
			menuswitch = 2;
			break;
		case 2:
			menuswitch = 4;
			break;
		case 3:
			menuswitch = 3;
			break;
		case 4:
			menuswitch = 2;
			break;
		case 5:
			menuswitch = 2;
			break;
		case 6:
			menuswitch = 1;
			break;
		}
	}

	private void Colorize() {
		red = (int) (int) Math.floor(Math.random() * 90 + 0);
		green = (int) (int) Math.floor(Math.random() * 90 + 0);
		blue = (int) (int) Math.floor(Math.random() * 90 + 0);
	}

	private void Errormessage() {
		if (trufade && timer < 765) {
			timer++;
			if (!blink && opacity < 254) {
				opacity += 2;
				fade = opacity;
			} else {
				blink = true;
			}
			if (blink && opacity > 0) {
				opacity -= 2;
				fade = opacity;
			} else {
				blink = false;
			}
		} else {
			trufade = false;
			timer = 0;
			opacity = 0;
			blink = false;
			fade = 0;
		}
	}
}
