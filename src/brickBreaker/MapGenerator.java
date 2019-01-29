package brickBreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	public int[][] map;
	public int brickWidth;  // gjer�sia e tull�s
	public int brickHeight; // lart�sia e tull�s
	public int color;
	public int row;
	public int col;
	
	public MapGenerator (int row, int col, int color) {
		
		this.map = new int[row][col];
		this.row = row;
		this.col = col;
		this.color = color;
		
		// P�rcaktojm� gjer�sin� dhe gjat�sin� e tull�s
		this.brickWidth = 540/col;
		this.brickHeight = 150/row;
	}
	
	public void draw (Graphics2D g) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if (color==1) {
					// Vizatojm� tullat me rradh� q� "p�rmbajn�" 1-sha
					if (map[i][j] == 1) {
						g.setColor(Color.WHITE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I b�jm� tullat t� dallueshme nga nj�ra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
				}
				else if (color == 2) {
					// Vizatojm� tullat me rradh� q� "p�rmbajn�" 2-sha
					if (map[i][j] == 2) {
						g.setColor(Color.CYAN);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I b�jm� tullat t� dallueshme nga nj�ra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
					// Vizatojm� tullat me rradh� q� "p�rmbajn�" 1-sha
					else if (map[i][j] == 1) {
						g.setColor(Color.WHITE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I b�jm� tullat t� dallueshme nga nj�ra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
				}
				else if (color == 3) {
					// Vizatojm� tullat me rradh� q� "p�rmbajn�" 3-sha
					if (map[i][j] == 3) {
						g.setColor(Color.BLUE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I b�jm� tullat t� dallueshme nga nj�ra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
					// Vizatojm� tullat me rradh� q� "p�rmbajn�" 2-sha
					else if (map[i][j] == 2) {
						g.setColor(Color.CYAN);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I b�jm� tullat t� dallueshme nga nj�ra-tjetra duke vizatuar bordera
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					}
					// Vizatojm� tullat me rradh� q� "p�rmbajn�" 1-sha
					else if (map[i][j] == 1) {
						g.setColor(Color.WHITE);
						g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
						
						// I b�jm� tullat t� dallueshme nga nj�ra-tjetra duke vizatuar bordera
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
		// E mbushim tabel�n me numra nga 1 - 3
		// 3,2,1 n�nkupton q� topi nuk e ka prekur tull�n
		// N� momentin q� tulla preket nga topi e b�jm� 0.
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
