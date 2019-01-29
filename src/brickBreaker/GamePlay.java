package brickBreaker;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GamePlay extends JComponent {
	
	private boolean play = false;
	private int score = 0;
	private int totalBricks;
	
	private int level = 0;
	private boolean levelWon = false;
	private int life = 3;
	private boolean winner = false;
	
	private Timer timer;
	private boolean pause = false;
	
	// Pozicioni i rrëshqitësit
	private int sliderX = 310;
		
	// Pozicioni i topit
	private int ballPosX;
	private int ballPosY;
		
	// Drejtimi i lëvizjes së topit
	private int ballXdir;
	private int ballYdir;
	
	private MapGenerator mapGenerator;
	private int[][] updateMap;
	private int levelTry = 1;
	private int updateTotalBricks;
	
	private URL urlHit = this.getClass().getResource("hit.wav");
	private AudioClip hit = Applet.newAudioClip(urlHit);
	private URL urlHit2 = this.getClass().getResource("hit2.wav");
	private AudioClip hit2 = Applet.newAudioClip(urlHit2);
	private URL urlWin = this.getClass().getResource("win.wav");
	private AudioClip win = Applet.newAudioClip(urlWin);
	private URL urlLose = this.getClass().getResource("lose.wav");
	private AudioClip lose = Applet.newAudioClip(urlLose);
	private URL urlHit3 = this.getClass().getResource("hit3.wav");
	private AudioClip hit3 = Applet.newAudioClip(urlHit3);
	private URL urlStart = this.getClass().getResource("start.wav");
	private AudioClip start = Applet.newAudioClip(urlStart);
	private URL urlLevelWin = this.getClass().getResource("levelWin.wav");
	private AudioClip levelWin = Applet.newAudioClip(urlLevelWin);
	private URL urlTryAgain = this.getClass().getResource("tryAgain.wav");
	private AudioClip tryAgain = Applet.newAudioClip(urlTryAgain);
	
	public GamePlay () {
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Slideri spostohet djathtas
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (totalBricks != 0) {
						// Kur slideri takon borderin e djathtë
						if (sliderX >= 590) {
							sliderX = 590;
						}
						else {
							moveRight();
						}
					}
				}
				
				// Slideri spostohet majtas
		        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        	// Kur slideri takon borderin e majtë
		        	if (totalBricks != 0) {
		        		if (sliderX <= 5) {
							sliderX = 5;
						}
						else {
							moveLeft();
						}
		        	}
				}
		        
		        // Restart-imi i lojës nëpërmjet tastit enter
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	if (!play) {
		        		pause = false;
		        		timer.start();
		        		play = true;
		        		if (level==0) {
		        			level++;
		        		}
		        		else if (levelWon){
		        			level++;
		        		}
		        		ballPosX = (int)(80 + Math.random()*541);
		        		ballPosY = 529;
		        		if (ballPosX <= 310) {
		        			ballXdir = -1;
		        		}
		        		else {
		        			ballXdir = 1;
		        		}
		        		ballYdir = -2;
		        		sliderX = 310;
		        		score = 0;
		        		
		        		if (life == 0) {
		        			level = 1;
		        			life = 3;
		        		}
		        		
		        		if (level==1) {
		        			start.play();
		        			timer.setDelay(5);
		        			if (levelTry == 1) {
		        				totalBricks = 12;
				        		mapGenerator = new MapGenerator(2,6,1);
				        		mapGenerator.fillBrickValues();
		        			}
		        			else {
		        				totalBricks = updateTotalBricks;
		        				mapGenerator = new MapGenerator(2,6,1);
		        				mapGenerator.updateBrickValues(mapGenerator.map, updateMap);
		        			}	        			
		        		}
		        		else if (level==2) {
		        			start.play();
		        			timer.setDelay(5);
		        			if (levelTry == 1) {
		        				totalBricks = 18;
				        		mapGenerator = new MapGenerator(3,6,1);
				        		mapGenerator.fillBrickValues();
		        			}
		        			else {
		        				totalBricks = updateTotalBricks;
		        				mapGenerator = new MapGenerator(3,6,1);
		        				mapGenerator.updateBrickValues(mapGenerator.map, updateMap);
		        			}	     
		        		}
		        		else if (level==3) {
		        			start.play();
		        			timer.setDelay(5);
		        			if (levelTry == 1) {
		        				totalBricks = 21;
				        		mapGenerator = new MapGenerator(3,7,1);
				        		mapGenerator.fillBrickValues();
		        			}
		        			else {
		        				totalBricks = updateTotalBricks;
		        				mapGenerator = new MapGenerator(3,7,1);
		        				mapGenerator.updateBrickValues(mapGenerator.map, updateMap);
		        			}	     		        		
		        		}
		        		else if (level==4) {
		        			start.play();
		        			timer.setDelay(5);
		        			if (levelTry == 1) {
		        				totalBricks = 28;
				        		mapGenerator = new MapGenerator(4,7,2);
				        		mapGenerator.fillBrickValues();
		        			}
		        			else {
		        				totalBricks = updateTotalBricks;
		        				mapGenerator = new MapGenerator(4,7,2);
		        				mapGenerator.updateBrickValues(mapGenerator.map, updateMap);
		        			}	     				        		
		        		}
		        		else if (level==5) {
		        			start.play();
		        			timer.setDelay(5);
		        			if (levelTry == 1) {
		        				totalBricks = 32;
				        		mapGenerator = new MapGenerator(4,8,2);
				        		mapGenerator.fillBrickValues();
		        			}
		        			else {
		        				totalBricks = updateTotalBricks;
		        				mapGenerator = new MapGenerator(4,8,2);
		        				mapGenerator.updateBrickValues(mapGenerator.map, updateMap);
		        			}
		        		}
		        		else if (level==6) {
		        			start.play();
		        			timer.setDelay(5);
		        			if (levelTry == 1) {
		        				totalBricks = 40;
				        		mapGenerator = new MapGenerator(5,8,3);
				        		mapGenerator.fillBrickValues();
		        			}
		        			else {
		        				totalBricks = updateTotalBricks;
		        				mapGenerator = new MapGenerator(5,8,3);
		        				mapGenerator.updateBrickValues(mapGenerator.map, updateMap);
		        			}
		        		}
		        		else if (level==7) {
		        			start.play();
		        			timer.setDelay(5);
		        			if (levelTry == 1) {
		        				totalBricks = 54;
				        		mapGenerator = new MapGenerator(6,9,3);
				        		mapGenerator.fillBrickValues();
		        			}
		        			else {
		        				totalBricks = updateTotalBricks;
		        				mapGenerator = new MapGenerator(6,9,3);
		        				mapGenerator.updateBrickValues(mapGenerator.map, updateMap);
		        			}
		        		}
	                }
		        }
		        
		        // Pausa Menu-ja
		        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		        	if (!pause && play) {
		        		timer.stop();
		        		pause = true;
		        	}
		        	else if (pause) {
		        		timer.start();
		        		pause = false;
		        	}
		        }
		        // Exit - Mbyllja e lojës
		        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		        	System.exit(0);
		        }
			}
		});
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		this.timer = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (play) {
					
					// Fillon lëvizja e topit
					ballPosX = ballPosX + ballXdir;
					ballPosY = ballPosY + ballYdir;
					
					// Kur topi takon anën e majtë, kthen djathtas
					if (ballPosX < 0) {
						hit2.play();
						ballXdir = -ballXdir;
					}
					
					// Kur topi takon pjesën e sipërme, shkon poshtë
					if (ballPosY < 0) {
						hit2.play();
						ballYdir = -ballYdir;
					}
					
					// Kur topi takon anën e djathtë, kthen majtas
					if (ballPosX > 672) {
						hit2.play();
						ballXdir = -ballXdir;
					}
					
					// Kur topi takon rrëshqitësin, shkon lart
					if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(
							new Rectangle(sliderX, 550, 100, 10))) {
						hit2.play();
						ballYdir = -ballYdir;
					}
					
					A: for (int i=0; i<mapGenerator.map.length; i++) {
						for (int j=0; j<mapGenerator.map[0].length; j++) {
							if (mapGenerator.color == 1) {
								if(mapGenerator.map[i][j] == 1) {
									// Përcaktojmë koordinatat e pozicionit dhe gjerësinë e lartësinë e çdo tulle
									int brickX = j * mapGenerator.brickWidth + 80;
									int brickY = i * mapGenerator.brickHeight + 50;
									int brickWidth = mapGenerator.brickWidth;
									int brickHeight = mapGenerator.brickHeight;
									Rectangle brickRect = new Rectangle (brickX, brickY, brickWidth, brickHeight);
									Rectangle ballRect = new Rectangle (ballPosX, ballPosY, 20, 20);
									// Kur topi takon tullën
									if (ballRect.intersects(brickRect)) {
										hit.play();
										mapGenerator.setBrickValue(0, i, j);
										totalBricks--;
										score += 5;
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e majtë ose të djathtë të tullës
										if (ballPosX+19 <= brickRect.x ||
												                ballPosX+1 >= brickRect.x + brickRect.width) {
											ballXdir = -ballXdir;
										}
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e sipërme ose të poshtme të tullës
										else {
											ballYdir = -ballYdir;
										}
										break A;
									}
								}
							}
							else if (mapGenerator.color == 2) {
								if(mapGenerator.map[i][j] == 2) {
									// Përcaktojmë koordinatat e pozicionit dhe gjerësinë e lartësinë e çdo tulle
									int brickX = j * mapGenerator.brickWidth + 80;
									int brickY = i * mapGenerator.brickHeight + 50;
									int brickWidth = mapGenerator.brickWidth;
									int brickHeight = mapGenerator.brickHeight;
									Rectangle brickRect = new Rectangle (brickX, brickY, brickWidth, brickHeight);
									Rectangle ballRect = new Rectangle (ballPosX, ballPosY, 20, 20);
									// Kur topi takon tullën
									if (ballRect.intersects(brickRect)) {
										hit.play();
										mapGenerator.setBrickValue(1, i, j);
										score += 5;
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e majtë ose të djathtë të tullës
										if (ballPosX+19 <= brickRect.x ||
												                ballPosX+1 >= brickRect.x + brickRect.width) {
											ballXdir = -ballXdir;
										}
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e sipërme ose të poshtme të tullës
										else {
											ballYdir = -ballYdir;
										}
										break A;
									}
								}
								else if(mapGenerator.map[i][j] == 1) {
									// Përcaktojmë koordinatat e pozicionit dhe gjerësinë e lartësinë e çdo tulle
									int brickX = j * mapGenerator.brickWidth + 80;
									int brickY = i * mapGenerator.brickHeight + 50;
									int brickWidth = mapGenerator.brickWidth;
									int brickHeight = mapGenerator.brickHeight;
									Rectangle brickRect = new Rectangle (brickX, brickY, brickWidth, brickHeight);
									Rectangle ballRect = new Rectangle (ballPosX, ballPosY, 20, 20);
									// Kur topi takon tullën
									if (ballRect.intersects(brickRect)) {
										hit.play();
										mapGenerator.setBrickValue(0, i, j);
										totalBricks--;
										score += 5;
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e majtë ose të djathtë të tullës
										if (ballPosX+19 <= brickRect.x ||
												                ballPosX+1 >= brickRect.x + brickRect.width) {
											ballXdir = -ballXdir;
										}
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e sipërme ose të poshtme të tullës
										else {
											ballYdir = -ballYdir;
										}
										break A;
									}
								}
							}
							else if (mapGenerator.color == 3) {
								if(mapGenerator.map[i][j] == 3) {
									// Përcaktojmë koordinatat e pozicionit dhe gjerësinë e lartësinë e çdo tulle
									int brickX = j * mapGenerator.brickWidth + 80;
									int brickY = i * mapGenerator.brickHeight + 50;
									int brickWidth = mapGenerator.brickWidth;
									int brickHeight = mapGenerator.brickHeight;
									Rectangle brickRect = new Rectangle (brickX, brickY, brickWidth, brickHeight);
									Rectangle ballRect = new Rectangle (ballPosX, ballPosY, 20, 20);
									// Kur topi takon tullën
									if (ballRect.intersects(brickRect)) {
										hit.play();
										mapGenerator.setBrickValue(2, i, j);
										score += 5;
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e majtë ose të djathtë të tullës
										if (ballPosX+19 <= brickRect.x ||
												                ballPosX+1 >= brickRect.x + brickRect.width) {
											ballXdir = -ballXdir;
										}
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e sipërme ose të poshtme të tullës
										else {
											ballYdir = -ballYdir;
										}
										break A;
									}
								}
								else if(mapGenerator.map[i][j] == 2) {
									// Përcaktojmë koordinatat e pozicionit dhe gjerësinë e lartësinë e çdo tulle
									int brickX = j * mapGenerator.brickWidth + 80;
									int brickY = i * mapGenerator.brickHeight + 50;
									int brickWidth = mapGenerator.brickWidth;
									int brickHeight = mapGenerator.brickHeight;
									Rectangle brickRect = new Rectangle (brickX, brickY, brickWidth, brickHeight);
									Rectangle ballRect = new Rectangle (ballPosX, ballPosY, 20, 20);
									// Kur topi takon tullën
									if (ballRect.intersects(brickRect)) {
										hit.play();
										mapGenerator.setBrickValue(1, i, j);
										score += 5;
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e majtë ose të djathtë të tullës
										if (ballPosX+19 <= brickRect.x ||
												                ballPosX+1 >= brickRect.x + brickRect.width) {
											ballXdir = -ballXdir;
										}
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e sipërme ose të poshtme të tullës
										else {
											ballYdir = -ballYdir;
										}
										break A;
									}
								}
								else if(mapGenerator.map[i][j] == 1) {
									// Përcaktojmë koordinatat e pozicionit dhe gjerësinë e lartësinë e çdo tulle
									int brickX = j * mapGenerator.brickWidth + 80;
									int brickY = i * mapGenerator.brickHeight + 50;
									int brickWidth = mapGenerator.brickWidth;
									int brickHeight = mapGenerator.brickHeight;
									Rectangle brickRect = new Rectangle (brickX, brickY, brickWidth, brickHeight);
									Rectangle ballRect = new Rectangle (ballPosX, ballPosY, 20, 20);
									// Kur topi takon tullën
									if (ballRect.intersects(brickRect)) {
										hit.play();
										mapGenerator.setBrickValue(0, i, j);
										totalBricks--;
										score += 5;
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e majtë ose të djathtë të tullës
										if (ballPosX+19 <= brickRect.x ||
												                ballPosX+1 >= brickRect.x + brickRect.width) {
											ballXdir = -ballXdir;
										}
										// Ndryshimi i drejtimit të topit pas kontaktit me 
										// anën e sipërme ose të poshtme të tullës
										else {
											ballYdir = -ballYdir;
										}
										break A;
									}
								}
							}
						}
					}
			    }
				repaint();
			}
		});
	}
	
	private void moveRight () {
		if (play && !pause) {
			this.sliderX = this.sliderX + 30;
		}
	}
	
    private void moveLeft () {
    	if (play && !pause) {
			this.sliderX = this.sliderX - 30;
    	}
	}
	
	@ Override
	protected void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		// Backgroundi
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		// Borderat - Anët Kufizuese
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);   // Kufizon anën e majtë
		g.fillRect(0, 0, 692, 3);   // Kufizon anën e sipërme
		g.fillRect(691, 0, 3, 592); // Kufizon anën e djathtë
		
		// Slideri -> Rrëshqitësi
		g.setColor(Color.CYAN);
		g.fillRect(sliderX, 550, 100, 10);
	
		// Topi
		if (play) {
			g.setColor(Color.yellow);
			g.fillOval(ballPosX, ballPosY, 20, 20);
		}

		// Try Again
		if (ballPosY > 570 && totalBricks>0 && life>1 && timer.isRunning()) {
			play = false;
			levelWon = false;
			life--;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Try Again!", 295, 235);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL "+level, 290, 290);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 335);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Esc to exit", 260, 363);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			if (sliderX >= 310) {
				g.drawString("Edison Rexhmati Game", 10, 560);
			}
			else {
				g.drawString("Edison Rexhmati Game", 485, 560);
			}
			hit3.play();
			tryAgain.play();
			// Ruajmë vlerat e map-it kur humbasim jetë, në mënyrë që niveli të fillohet ku e lamë
			this.updateMap = new int[mapGenerator.row][mapGenerator.col];
			this.mapGenerator.saveBrickValues(mapGenerator.map, updateMap);
			this.updateTotalBricks = this.totalBricks;
			levelTry++;
			timer.stop();
			
		}
		else if (ballPosY > 570 && totalBricks>0 && life>=1 && !timer.isRunning()) {
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Try Again!", 295, 235);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL "+level, 290, 290);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 335);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Esc to exit", 260, 363);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			if (sliderX >= 310) {
				g.drawString("Edison Rexhmati Game", 10, 560);
			}
			else {
				g.drawString("Edison Rexhmati Game", 485, 560);
			}
		}
		
		// Game Over
		else if (ballPosY > 570 && totalBricks>0 && life==1 && timer.isRunning()) {
			play = false;
			levelWon = false;
			levelTry = 1;
			life--;
			g.setColor(Color.red);
			g.setFont(new Font("", Font.BOLD, 40));
			g.drawString("Game Over! You Lose!", 140, 240);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to restart", 230, 300);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Esc to exit", 260, 330);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			if (sliderX >= 310) {
				g.drawString("Edison Rexhmati Game", 10, 560);
			}
			else {
				g.drawString("Edison Rexhmati Game", 485, 560);
			}
			hit3.play();
			lose.play();
			timer.stop();
		}
		else if (ballPosY > 570 && totalBricks>0 && life==0 && !timer.isRunning()) {
			g.setColor(Color.red);
			g.setFont(new Font("", Font.BOLD, 40));
			g.drawString("Game Over! You Lose!", 140, 240);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to restart", 230, 300);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Esc to exit", 260, 330);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			if (sliderX >= 310) {
				g.drawString("Edison Rexhmati Game", 10, 560);
			}
			else {
				g.drawString("Edison Rexhmati Game", 485, 560);
			}
		}
		
		// Vizatojmë tullat duke thërritur metodën draw që e kemi krijuar tek klasa MapGenerator
		if (level != 0) {
			mapGenerator.draw((Graphics2D) g);
		}
        
		// Shfaqja e jetëve
		if (level!=7 || totalBricks != 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString(""+life, 590, 30);
		}
		
		// BRICK BREAKER - Menu
		if (level==0 && !winner && !timer.isRunning()) {
			this.mapGenerator = new MapGenerator(2,6,1);
			this.mapGenerator.fillBrickValues();
			this.mapGenerator.draw((Graphics2D) g);
			g.setColor(Color.yellow);
			g.setFont(new Font("", Font.BOLD, 40));
			g.drawString("BRICK BREAKER", 185, 260);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL 1", 290, 325);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 240, 380);
			g.setColor(Color.yellow);
			g.drawString("Press Space to pause / resume", 190, 410);
			g.setColor(Color.red);
			g.drawString("Press Esc to exit", 260, 440);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
		}
		// Kur fitohet niveli 1
		else if (level==1 && totalBricks == 0 && timer.isRunning()) {
			ballXdir = 0;
			ballYdir = 6; // Topi niset me shpejtësi për poshtë
			sliderX = 1000; // Heqim slider-in nga frame-i
			if (ballPosY > 570) {
				levelWin.play();
				levelWon = true;
				play = false;
				levelTry = 1;
				this.mapGenerator = new MapGenerator(3,6,1);
				this.mapGenerator.fillBrickValues();
				this.mapGenerator.draw((Graphics2D) g);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Level 1 Completed", 250, 240);
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("LEVEL 2", 290, 300);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Enter to start", 245, 350);
				g.setColor(Color.yellow);
				g.drawString("Press Space to pause / resume", 190, 380);
				g.setColor(Color.red);
				g.drawString("Press Esc to exit", 260, 410);
				g.setColor(Color.gray);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Edison Rexhmati Game", 10, 560);
				g.setColor(Color.CYAN);
				g.fillRect(310, 550, 100, 10);
				timer.stop();
			}
		}
		// Ky algoritëm është bërë për të mos ndryshuar përbërësit e faqes kur lëvizet dritarja
		else if (level==1 && totalBricks == 0 && !timer.isRunning()) {
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Level 1 Completed", 250, 240);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL 2", 290, 300);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 350);
			g.setColor(Color.yellow);
			g.drawString("Press Space to pause / resume", 190, 380);
			g.setColor(Color.red);
			g.drawString("Press Esc to exit", 260, 410);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
			g.setColor(Color.CYAN);
			g.fillRect(310, 550, 100, 10);
		}
		// Kur fitohet niveli 2
		else if (level==2 && totalBricks == 0 && timer.isRunning()) {
			ballXdir = 0;
			ballYdir = 6; // Topi niset me shpejtësi për poshtë
			sliderX = 1000; // Heqim slider-in nga frame-i
			if (ballPosY > 570) {
				levelWin.play();
				levelWon = true;
				play = false;
				levelTry = 1;
				this.mapGenerator = new MapGenerator(3,7,1);
				this.mapGenerator.fillBrickValues();
				this.mapGenerator.draw((Graphics2D) g);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Level 2 Completed", 250, 240);
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("LEVEL 3", 290, 300);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Enter to start", 245, 350);
				g.setColor(Color.yellow);
				g.drawString("Press Space to pause / resume", 190, 380);
				g.setColor(Color.red);
				g.drawString("Press Esc to exit", 260, 410);
				g.setColor(Color.gray);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Edison Rexhmati Game", 10, 560);
				g.setColor(Color.CYAN);
				g.fillRect(310, 550, 100, 10);
				timer.stop();
			}
		}
		else if (level==2 && totalBricks == 0 && !timer.isRunning()) {
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Level 2 Completed", 250, 240);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL 3", 290, 300);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 350);
			g.setColor(Color.yellow);
			g.drawString("Press Space to pause / resume", 190, 380);
			g.setColor(Color.red);
			g.drawString("Press Esc to exit", 260, 410);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
			g.setColor(Color.CYAN);
			g.fillRect(310, 550, 100, 10);
		}
		// Kur fitohet niveli 3
		else if (level==3 && totalBricks == 0 && timer.isRunning()) {
			ballXdir = 0;
			ballYdir = 6; // Topi niset me shpejtësi për poshtë
			sliderX = 1000; // Heqim slider-in nga frame-i
			if (ballPosY > 570) {
				levelWin.play();
				levelWon = true;
				play = false;
				levelTry = 1;
				this.mapGenerator = new MapGenerator(4,7,2);
				this.mapGenerator.fillBrickValues();
				this.mapGenerator.draw((Graphics2D) g);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Level 3 Completed", 250, 240);
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("LEVEL 4", 290, 300);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Enter to start", 245, 350);
				g.setColor(Color.yellow);
				g.drawString("Press Space to pause / resume", 190, 380);
				g.setColor(Color.red);
				g.drawString("Press Esc to exit", 260, 410);
				g.setColor(Color.gray);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Edison Rexhmati Game", 10, 560);
				g.setColor(Color.CYAN);
				g.fillRect(310, 550, 100, 10);
				timer.stop();
			}
		}
		else if (level==3 && totalBricks == 0 && !timer.isRunning()) {
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Level 3 Completed", 250, 240);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL 4", 290, 300);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 350);
			g.setColor(Color.yellow);
			g.drawString("Press Space to pause / resume", 190, 380);
			g.setColor(Color.red);
			g.drawString("Press Esc to exit", 260, 410);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
			g.setColor(Color.CYAN);
			g.fillRect(310, 550, 100, 10);
		}
		// Kur fitohet niveli 4
		else if (level==4 && totalBricks == 0 && timer.isRunning()) {
			ballXdir = 0;
			ballYdir = 5; // Topi niset me shpejtësi për poshtë
			sliderX = 1000; // Heqim slider-in nga frame-i
			if (ballPosY > 570) {
				levelWin.play();
				levelWon = true;
				play = false;
				levelTry = 1;
				this.mapGenerator = new MapGenerator(4,8,2);
				this.mapGenerator.fillBrickValues();
				this.mapGenerator.draw((Graphics2D) g);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Level 4 Completed", 250, 240);
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("LEVEL 5", 290, 300);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Enter to start", 245, 350);
				g.setColor(Color.yellow);
				g.drawString("Press Space to pause / resume", 190, 380);
				g.setColor(Color.red);
				g.drawString("Press Esc to exit", 260, 410);
				g.setColor(Color.gray);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Edison Rexhmati Game", 10, 560);
				g.setColor(Color.CYAN);
				g.fillRect(310, 550, 100, 10);
				timer.stop();
			}
		}
		else if (level==4 && totalBricks == 0 && !timer.isRunning()) {
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Level 4 Completed", 250, 240);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL 5", 290, 300);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 350);
			g.setColor(Color.yellow);
			g.drawString("Press Space to pause / resume", 190, 380);
			g.setColor(Color.red);
			g.drawString("Press Esc to exit", 260, 410);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
			g.setColor(Color.CYAN);
			g.fillRect(310, 550, 100, 10);
		}
		// Kur fitohet niveli 5
		else if (level==5 && totalBricks == 0 && timer.isRunning()) {
			ballXdir = 0;
			ballYdir = 5; // Topi niset me shpejtësi për poshtë
			sliderX = 1000; // Heqim slider-in nga frame-i
			if (ballPosY > 570) {
				levelWin.play();
				levelWon = true;
				play = false;
				levelTry = 1;
				this.mapGenerator = new MapGenerator(5,8,3);
				this.mapGenerator.fillBrickValues();
				this.mapGenerator.draw((Graphics2D) g);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Level 5 Completed", 250, 240);
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("LEVEL 6", 290, 300);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Enter to start", 245, 350);
				g.setColor(Color.yellow);
				g.drawString("Press Space to pause / resume", 190, 380);
				g.setColor(Color.red);
				g.drawString("Press Esc to exit", 260, 410);
				g.setColor(Color.gray);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Edison Rexhmati Game", 10, 560);
				g.setColor(Color.CYAN);
				g.fillRect(310, 550, 100, 10);
				timer.stop();
			}
		}
		else if (level==5 && totalBricks == 0 && !timer.isRunning()) {
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Level 5 Completed", 250, 240);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL 6", 290, 300);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 350);
			g.setColor(Color.yellow);
			g.drawString("Press Space to pause / resume", 190, 380);
			g.setColor(Color.red);
			g.drawString("Press Esc to exit", 260, 410);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
			g.setColor(Color.CYAN);
			g.fillRect(310, 550, 100, 10);
		}
		// Kur fitohet niveli 6
		else if (level==6 && totalBricks == 0 && timer.isRunning()) {
			ballXdir = 0;
			ballYdir = 4; // Topi niset me shpejtësi për poshtë
			sliderX = 1000; // Heqim slider-in nga frame-i
			if (ballPosY > 570) {
				levelWin.play();
				levelWon = true;
				play = false;
				levelTry = 1;
				this.mapGenerator = new MapGenerator(6,9,3);
				this.mapGenerator.fillBrickValues();
				this.mapGenerator.draw((Graphics2D) g);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Level 6 Completed", 250, 240);
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("LEVEL 7", 290, 300);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Enter to start", 245, 350);
				g.setColor(Color.yellow);
				g.drawString("Press Space to pause / resume", 190, 380);
				g.setColor(Color.red);
				g.drawString("Press Esc to exit", 260, 410);
				g.setColor(Color.gray);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Edison Rexhmati Game", 10, 560);
				g.setColor(Color.CYAN);
				g.fillRect(310, 550, 100, 10);
				timer.stop();
			}
		}
		else if (level==6 && totalBricks == 0 && !timer.isRunning()) {
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Level 6 Completed", 250, 240);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("LEVEL 7", 290, 300);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to start", 245, 350);
			g.setColor(Color.yellow);
			g.drawString("Press Space to pause / resume", 190, 380);
			g.setColor(Color.red);
			g.drawString("Press Esc to exit", 260, 410);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
			g.setColor(Color.CYAN);
			g.fillRect(310, 550, 100, 10);
		}
		// Kur fitohet niveli 7, loja fitohet dhe përfundon
		else if (level==7 && totalBricks == 0 && timer.isRunning()){
			ballXdir = 0;
			ballYdir = 4; // Topi niset me shpejtësi për poshtë
			sliderX = 1000; // Heqim slider-in nga frame-i
			if (ballPosY > 570) {
				win.play();
				level = 0;
				play = false;
				levelTry = 1;
				life = 3;
				winner = true;
				g.setColor(Color.yellow);
				g.setFont(new Font("", Font.BOLD, 40));
				g.drawString("BRICK BREAKER", 185, 135);
				g.setColor(Color.green);
				g.setFont(new Font("serif", Font.BOLD, 40));
				g.drawString("Congratulations! You Win!", 110, 250);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Enter to restart", 225, 355);
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 25));
				g.drawString("Press Esc to exit", 250, 385);
				g.setColor(Color.gray);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Edison Rexhmati Game", 10, 560);
				timer.setDelay(5);
				timer.stop();
			}
		}
		else if (level==0 && winner && !timer.isRunning()){
			g.setColor(Color.yellow);
			g.setFont(new Font("", Font.BOLD, 40));
			g.drawString("BRICK BREAKER", 185, 135);
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 40));
			g.drawString("Congratulations! You Win!", 110, 250);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to restart", 225, 355);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Esc to exit", 250, 385);
			g.setColor(Color.gray);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Edison Rexhmati Game", 10, 560);
		}
		
		g.dispose();
	}
}
