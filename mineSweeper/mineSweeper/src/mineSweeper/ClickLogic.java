package mineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClickLogic extends Mines{
	private static int flag = 0;
	private static int xflag = 0;

    private static boolean checkLeft = false;
    private static boolean checkRight = false;
    
    private static ImageIcon flagIcon = new ImageIcon("Assets/photos/Minesweeper_flag.png");
    private static ImageIcon mineIcon = new ImageIcon("Assets/photos/Minesweeper mine.png");

    private static Image flagImage = flagIcon.getImage();
    private static Image newFlag = flagImage.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
    
    private static Image mineImage = mineIcon.getImage();
    private static Image newMine = mineImage.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
    
    private static boolean[] isFlagged = new boolean[81];
    private static boolean[] isRevealed = new boolean[81];
    protected static int wins = scoreRead.win;
    protected static int losses = scoreRead.loss;
    protected static void clickLogic(){
        int i = 0;
        //System.out.println("Wins " +  wins);
        for (JButton t:
             tiles) {
            int finalI = i;
        	

        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                if (arg0.getButton() == MouseEvent.BUTTON1 && !t.getText().contentEquals(".")){
                    if(borders.contains(tiles[finalI])){
                        System.out.println(tileValue[finalI]);
                        t.setText("" + tileValue[finalI]);
                        if(mines.contains(t)){
                            t.setText("");
                            mineIcon = new ImageIcon(newMine);
                            t.setIcon(mineIcon);
                            
                        }
                    }
                    t.setBackground(Color.GRAY);
                    if(mines.contains(t)){
                        t.setBackground(Color.RED);
                        losses++;
                        scoreWrite.write();
                        lossLbl.setText("Losses: " + losses);
                        
                    
                    }else{
                        checker(finalI);
                    }
                } else if (arg0.getButton() == MouseEvent.BUTTON3 && !t.getBackground().equals(Color.GRAY)){
                    if(!t.getText().contentEquals(".") && !mines.contains(t)){
                    	flagIcon = new ImageIcon(newFlag);
                    	t.setIcon(flagIcon);
                        t.setText(".");
                    	t.setFont(new Font("Arial", Font.PLAIN, 0));
                        xflag++;

                     }else if(t.getText().contentEquals(".") && !mines.contains(t)){ 
                    	 t.setIcon(null); 
                    	 t.setText("");
                         xflag--;
                    	 }
                    
                     if(mines.contains(t) && !t.getText().contentEquals(".")){
                    	flag++;
                    	flagIcon = new ImageIcon(newFlag);
                    	t.setIcon(flagIcon);
                        t.setText(".");
                    	t.setFont(new Font("Arial", Font.PLAIN, 0));
                     }
                     	
                     	else if(mines.contains(t) && t.getText().contentEquals(".")) {
                     		t.setIcon(null); 
                     		t.setText(""); 
                     		flag--;

                         }
                     	
             		if((flag - xflag )== numOfMines) {
             		t.setIcon(null);
             		t.setText("Win!"); 
             		t.setFont(new Font("llpixel", Font.PLAIN, 18));
                 	t.setBackground(Color.GREEN);
                 	
                    wins++;
                    scoreWrite.write();
                    winLbl.setText("Wins: " + wins);
                 	
                   	}                    
                }                          
            } 
        });
        i++;            
    }
}

    private static void checker(int i) {
        int i2 = i;

        for (int j = 0; j < 8; j++) {
            if((i2 >= 9 && j == 1) || (i2 >= 1 && j == 3) || (i2 <= 79 && j == 4) || (i2 <= 68 && j == 6)) {
                if(isConnected.contains(tiles[i2+adjacentCoords[j]])  && !(mines.contains(tiles[i2 + adjacentCoords[j]]))){
                    tiles[i2+adjacentCoords[j]].setBackground(Color.GRAY);
                    isRevealed[i2 + adjacentCoords[j]] = true;
                    if(tileValue[i2 + adjacentCoords[j]] > 0 && isFlagged[i2 + adjacentCoords[j]] == false){
                        tiles[i2 + adjacentCoords[j]].setText("" + tileValue[i2 + adjacentCoords[j]]);
                    }
                    i2 = i + adjacentCoords[j];
                }
            }
        }
    }
}

