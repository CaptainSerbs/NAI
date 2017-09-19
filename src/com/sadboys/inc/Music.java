package com.sadboys.inc;

import javax.sound.sampled.*;
import java.io.*;

public class Music {
	public static int sound;
	public static int sfx;
	public static float sfxvolume = -80.0f;

	public static void gibMusic(int sound){

		
		boolean play = true;//2 B used
		while(play == true){
			
			try{
				Clip clip = AudioSystem.getClip();
				if(sound == 0){
					clip.open(AudioSystem.getAudioInputStream(Music.class.getResource("/music/NAI_soundtrack.wav")));
					sound = 1;
				}
				else if(sound == 1){
					clip.open(AudioSystem.getAudioInputStream(Music.class.getResource("/music/NAI_soundtrack.wav")));
					sound = 0;
				}
				FloatControl musicvolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				musicvolume.setValue(-10.0f);
				clip.start();
				Thread.sleep(800);
				clip.addLineListener(new LineListener(){
					@Override
					public void update(LineEvent event){
						if(event.getType() == LineEvent.Type.STOP){
							clip.close();
						}	
					}
				});
				clip.drain();
				
			}
			
			
			catch(Exception e){
			
			e.printStackTrace(System.out);
			}
			
		}
		
	}

	public static void Soundeffects(int sfx){
			
			try{
				Clip jumpclip = AudioSystem.getClip();
				AudioInputStream jump = AudioSystem.getAudioInputStream(Music.class.getResource("/music/Jumpsfx.wav"));
				Clip deathclip = AudioSystem.getClip();
				AudioInputStream death = AudioSystem.getAudioInputStream(Music.class.getResource("/music/Deathsfx.wav"));
				Clip bulletclip = AudioSystem.getClip();
				AudioInputStream bullet = AudioSystem.getAudioInputStream(Music.class.getResource("/music/Bulletsfx.wav"));
				Clip blastclip = AudioSystem.getClip();
				AudioInputStream blast = AudioSystem.getAudioInputStream(Music.class.getResource("/music/Blastsfx.wav"));
				Clip scoreclip = AudioSystem.getClip();
				AudioInputStream score = AudioSystem.getAudioInputStream(Music.class.getResource("/music/Scoresfx.wav"));
				if(sfx == 1){
					jumpclip.open(jump);
					FloatControl jumpvolume = (FloatControl) jumpclip.getControl(FloatControl.Type.MASTER_GAIN);
					jumpvolume.setValue(sfxvolume);
					jumpclip.start();
					jumpclip.addLineListener(new LineListener(){
						@Override
						public void update(LineEvent event){
							if(event.getType() == LineEvent.Type.STOP){
								jumpclip.close();
							}	
						}
					});
					jumpclip.drain();
					sfx = 0;
				}
				if(sfx == 2){
					deathclip.open(death);
					FloatControl deathvolume = (FloatControl) deathclip.getControl(FloatControl.Type.MASTER_GAIN);
					deathvolume.setValue(sfxvolume);
					deathclip.start();
					deathclip.addLineListener(new LineListener(){
						@Override
						public void update(LineEvent event){
							if(event.getType() == LineEvent.Type.STOP){
								deathclip.close();
							}	
						}
					});
					deathclip.drain();
					sfx = 0;
				}
				if(sfx == 3){
					bulletclip.open(bullet);
					FloatControl bulletvolume = (FloatControl) bulletclip.getControl(FloatControl.Type.MASTER_GAIN);
					bulletvolume.setValue(sfxvolume);
					bulletclip.start();
					bulletclip.addLineListener(new LineListener(){
						@Override
						public void update(LineEvent event){
							if(event.getType() == LineEvent.Type.STOP){
								bulletclip.close();
							}	
						}
					});
					bulletclip.drain();
					sfx = 0;

				}
				if(sfx == 4){
					blastclip.open(blast);
					FloatControl blastvolume = (FloatControl) blastclip.getControl(FloatControl.Type.MASTER_GAIN);
					blastvolume.setValue(sfxvolume);
					blastclip.start();
					blastclip.addLineListener(new LineListener(){
						@Override
						public void update(LineEvent event){
							if(event.getType() == LineEvent.Type.STOP){
								blastclip.close();
							}	
						}
					});
					blastclip.drain();
					sfx = 0;
				}
				if(sfx == 5){
					scoreclip.open(score);
					FloatControl scorevolume = (FloatControl) scoreclip.getControl(FloatControl.Type.MASTER_GAIN);
					scorevolume.setValue(sfxvolume);
					scoreclip.start();
					scoreclip.addLineListener(new LineListener(){
						@Override
						public void update(LineEvent event){
							if(event.getType() == LineEvent.Type.STOP){
								scoreclip.close();
							}	
						}
					});
					scoreclip.drain();
					sfx = 0;
				}
			}
			
			
			catch(Exception e){
			
			e.printStackTrace(System.out);
			}
		
	}
	public void setVolume(){
		sfxvolume = -5.0f;
	}
}