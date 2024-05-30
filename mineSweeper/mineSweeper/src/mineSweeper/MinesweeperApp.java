package mineSweeper;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MinesweeperApp extends JFrame {

	protected JPanel contentPane;
	protected static JPanel grid = new JPanel();
	protected static JButton[] tiles = new JButton[81];
	protected static JPanel winLossRatio = new JPanel();
	protected static JLabel winLbl = new JLabel();
	protected static JLabel lossLbl = new JLabel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinesweeperApp frame = new MinesweeperApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public MinesweeperApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 800, 850);
		setResizable(false );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		grid.setLayout(new GridLayout(9,9,3,3));
		grid.setBackground(Color.DARK_GRAY);
		contentPane.add(grid, BorderLayout.CENTER);

		winLossRatio.setLayout(new FlowLayout());
		winLossRatio.setBackground(Color.DARK_GRAY);

		contentPane.add(winLossRatio, BorderLayout.SOUTH);

		scoreRead.score();
		winLbl.setForeground(Color.LIGHT_GRAY);
		winLbl.setFont(new Font("LLPixel", Font.PLAIN, 35));
		winLbl.setBorder(new EmptyBorder(0, 20, 0, 20));
		winLbl.setForeground(Color.ORANGE);
		lossLbl.setForeground(Color.LIGHT_GRAY);
		lossLbl.setFont(new Font("LLPixel", Font.PLAIN, 35));
		lossLbl.setForeground(Color.ORANGE);
		winLossRatio.add(winLbl);
		winLossRatio.add(lossLbl);

		for(int i = 0; i < 81; i++) {
			tiles[i] = new JButton();
			tiles[i].setBackground(Color.LIGHT_GRAY);
			tiles[i].setFont(new Font("LLPixel", Font.PLAIN, 18));
			grid.add(tiles[i]);
		}

		Mines.assignMines();
		Mines.checkTiles();
		ClickLogic.clickLogic();
	}



}
