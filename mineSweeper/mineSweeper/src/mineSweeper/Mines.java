package mineSweeper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Mines extends MinesweeperApp{
	protected static ArrayList<JButton> mines = new ArrayList<>();
	protected static ArrayList<JButton> borders = new ArrayList<>();
	protected static ArrayList<JButton> empties = new ArrayList<>();
	protected static int numOfMines = 10;
	private static Random rand = new Random();
	private static int coord = 0;
	private static int tileCount = 0;
	protected static int[] tileValue = new int[81];

	protected static ArrayList<JButton> isConnected = new ArrayList();

	static int[] adjacentCoords = {-10, -9, -8, -1, 1, 8, 9, 10};
	protected static ArrayList<JButton> wall = new ArrayList<>();

	protected Mines(){

	}

	protected static void assignMines() {

		for(int i = 0; i < numOfMines; i++) {
			coord = rand.nextInt(81);
			if(!(mines.contains(tiles[coord]))) {
				mines.add(tiles[coord]);
				//tiles[coord].setBackground(Color.ORANGE);
			}else{
				i -= 1;
			}

		}
	}
	
	protected static void checkTiles() {
		for (int i = 0; i < 81; i++) {
			for (int j = 0; j < 8; j++) {
				if((i >= 10 && j == 0) || (i >= 9 && j == 1) || (i >= 8 && j == 2) || (i >= 1 && j == 3) || (i <= 79 && j == 4) || (i <= 69 && j == 5) || (i <= 68 && j == 6) || (i <= 67 && j == 7)) {
					if (mines.contains(tiles[i + adjacentCoords[j]]) && !(mines.contains(i))) {
						tileCount++;
						borders.add(tiles[i]);
					}else if(!(mines.contains(tiles[i + adjacentCoords[j]])) && !(mines.contains(i)) && (j == 1 || j == 3 || j == 4 || j == 6)){
						isConnected.add(tiles[i + adjacentCoords[j]]);
						isConnected.add(tiles[i]);
					}
				}
			}
			if(!(mines.contains(tiles[i])) && tileCount > 0){
				tileValue[i] = tileCount;
				borders.add(tiles[i]);
			} else if (!(mines.contains(tiles[i])) && tileCount == 0) {
				empties.add(tiles[i]);
			}
			tileCount = 0;
		}
	}
}
