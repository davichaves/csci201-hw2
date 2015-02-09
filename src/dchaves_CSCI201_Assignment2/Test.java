package dchaves_CSCI201_Assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	private static String fileName = new String();
	private static Scanner s = new Scanner (System.in);
	private static char [][] myGrid = new char[10][10];
	private static ReadFile rf;
	private static int line, column;
	private static String coord;
	public static void main(String [] args){
		System.out.print("Which file? ");
        //fileName = s.next();
        try {
        	rf = new ReadFile("input.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		} catch (IOException ioe) {
			System.out.println("Input error!");
		} 
        try {
        	rf.checkInput();
        } catch (BadInputException bie) {
        	System.out.println("Bad Input!");
		}
        myGrid = rf.returnGrid();
        GUI gui = new GUI(rf.returnGrid(), rf.returnUsers());
        int turn = 1;
        coord = new String();
        while(true) {
        	System.out.print("Turn " + turn + " - Please enter a Coordinate: ");
            coord = s.next();
            if(checkInput(coord)){
            	if(myGrid[line][column] == 'F') System.out.println("Already Guessed!");
            	else if(myGrid[line][column] == 'X'){
            		System.out.println("MISS!");
            		gui.updateLabel(line, column, "MISS");
            		myGrid[line][column] = 'F';
            		turn+=1;
            	} else {
            		System.out.println("HIT!");
            		gui.updateLabel(line, column, myGrid[line][column] + " ");
            		myGrid[line][column] = 'F';
            		turn+=1;
            	}
            } else {
            	System.out.println("Bad Input!");
            }
        }
	}
	public static boolean checkInput(String input) {
		String myString = new String("ABCDEFGHIJ");
		if(input.length() != 2) return false;
		else if(!myString.contains("" + input.charAt(0))) return false;
		else {
			int columnInput;
			try {
				columnInput = Integer.parseInt("" + input.charAt(1));
			} catch (NumberFormatException e) {
				return false;
			}
			column = columnInput;
			if(columnInput > 10 || columnInput < 1) {
				return false;
			}
		}
		line = myString.indexOf(input.charAt(0));
		return true;
	}
}
