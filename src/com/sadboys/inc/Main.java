package com.sadboys.inc;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main {

	static Music music = new Music();

	public static Display f = new Display();
	public static int w = 900;
	public static int h = 700;
	static Thread musa = new Thread(new musa());


	public static void main(String args[]) {
		musa.start();
		f.setSize(w, h);
		f.setResizable(false);
		f.setUndecorated(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Names are Irrelevant, Colors are not");
		f.setLocationRelativeTo(null);
	}
        
/*
 * This thread runs ingame soundeffects so they are loaded into RAM. When this is done, window will be visible. 
 * So basically a simple "loading screen"
 */
	public static class musa implements Runnable {

		@Override
		public void run() {
			
			for(int i = 0; i <= 5; i++){
			Music.Soundeffects(i);
			}
			f.setVisible(true);
			Music.gibMusic(0);

		}

	}

}
