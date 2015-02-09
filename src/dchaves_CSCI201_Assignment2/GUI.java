package dchaves_CSCI201_Assignment2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users [] users = new Users[10];
	private char [][] myGrid = new char[10][10];
	private String myString = new String("ABCDEFGHIJ ");
	public GUI(char [][] grid, Users [] users){
		super("Battleship");
		for(int i = 0; i<10; i++) {
			this.users[i] = users[i];
			for(int j = 0; j<10; j++) {
				this.myGrid[i][j] = grid[i][j];
			}
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		setSize(600,400);
		setLocation((int)(width/2)-300,(int)(height/2)-200);
		JPanel eastPanel = new JPanel();
		JLabel topLabel = new JLabel("HighScores: ");
		JLabel [] userLabel = new JLabel[15];
		eastPanel.add(topLabel, BorderLayout.NORTH);
		eastPanel.setLayout(new GridLayout(0,1));
		eastPanel.setSize(200, 400);
		for(int i = 0; i < 15; i++) {
			if(i > 9) userLabel[i] = new JLabel("");
			else {
				if(users[i].getScore() == 0) userLabel[i] = new JLabel(i+1 + ". ");
				else userLabel[i] = new JLabel(i+1 + ". " + users[i].getName() + " - " + users[i].getScore() + " ");
			}
			eastPanel.add(userLabel[i]);
		}
		
		JPanel westPanel = new JPanel();
		
		westPanel.setLayout(new GridLayout(11,11));
		westPanel.setSize(400,400);
		JLabel [][] gridLabel = new JLabel[11][11];
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 11; j++){
				if(j == 0 && i == 10) gridLabel[i][j] = new JLabel(" ");
				else if(j == 0) gridLabel[i][j] = new JLabel(" " + myString.charAt(i) + " ");
				else if(i == 10) gridLabel[i][j] = new JLabel(" " + j + " ");
				else gridLabel[i][j] = new JLabel(" ? ? ? ? ");
				westPanel.add(gridLabel[i][j]);
			} //end of the inner for loop
		} // end of the outer for loop
		
		
		add(eastPanel, BorderLayout.EAST);
		add(westPanel, BorderLayout.WEST);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
