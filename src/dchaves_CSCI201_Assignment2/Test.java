package dchaves_CSCI201_Assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	private static String fileName = new String();
	private static Scanner s = new Scanner (System.in);
	private static ReadFile rf;
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
        GUI test = new GUI(rf.returnGrid(), rf.returnUsers());
        int turn = 1;
        String coord = new String();
        while(true) {
        	System.out.print("Turn " + turn + " - Please enter a Coordinate: ");
            coord = s.next();
        }
	}
	public static void checkInput() {
		
	}
}
