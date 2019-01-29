package brickBreaker;

import javax.swing.JFrame;

public class Main {
	
	public static void main (String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Brick Breaker - Edison Rexhmati Game");
		frame.setSize(700,600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePlay gameplay = new GamePlay();
		frame.add(gameplay);
		frame.setVisible(true);
	}
}