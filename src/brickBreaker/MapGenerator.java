package brickBreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	public int[][] map;
	public int brickWidth;  // gjerësia e tullës
	public int brickHeight; // lartësia e tullës
	public int color;
	public int row;
	public int col;
	
	public MapGenerator (int row, int col, int color) {
		
		this.map = new int[row][col];
		this.row = row;
		this.col = col;
		this.color = color;
		
		// Përcaktojmë gjerësinë dhe gjatësinë e tullës
		this.brickWidth = 540/col;
		this.brickHeight = 150/row;
	}
	
	public void draw (Graphics2D g) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if (color==1) {
					// Vizatojmë tullat me rradhë që "përmbajnë" 1-sha
					if (map[i][j] == 1) {
						g.setColor(Color.WHITE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I bëjmë tullat të dallueshme nga njëra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
				}
				else if (color == 2) {
					// Vizatojmë tullat me rradhë që "përmbajnë" 2-sha
					if (map[i][j] == 2) {
						g.setColor(Color.CYAN);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I bëjmë tullat të dallueshme nga njëra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
					// Vizatojmë tullat me rradhë që "përmbajnë" 1-sha
					else if (map[i][j] == 1) {
						g.setColor(Color.WHITE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I bëjmë tullat të dallueshme nga njëra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
				}
				else if (color == 3) {
					// Vizatojmë tullat me rradhë që "përmbajnë" 3-sha
					if (map[i][j] == 3) {
						g.setColor(Color.BLUE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I bëjmë tullat të dallueshme nga njëra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
					// Vizatojmë tullat me rradhë që "përmbajnë" 2-sha
					else if (map[i][j] == 2) {
						g.setColor(Color.CYAN);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I bëjmë tullat të dallueshme nga njëra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
					// Vizatojmë tullat me rradhë që "përmbajnë" 1-sha
					else if (map[i][j] == 1) {
						g.setColor(Color.WHITE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I bëjmë tullat të dallueshme nga njëra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
				}
			}
		}
	}
	
	public void setBrickValue (int value, int row, int col) {
		this.map[row][col] = value;
	}
	
	public void fillBrickValues () {
		// E mbushim tabelën me numra nga 1 - 3
		// 3,2,1 nënkupton që topi nuk e ka prekur tullën
		// Në momentin që tulla preket nga topi e bëjmë 0.
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				this.map[i][j] = color;
			}
		}
	}
	
	public void updateBrickValues (int[][] map, int[][] updateMap) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
			    map[i][j] = updateMap[i][j];
			}
		}
	}
	
	public void saveBrickValues (int[][] map, int[][] updateMap) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
			    updateMap[i][j] = map[i][j];
			}
		}
	}
}
