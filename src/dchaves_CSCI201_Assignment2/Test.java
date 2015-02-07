package dchaves_CSCI201_Assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	private static String fileName = new String();
	private static Scanner s = new Scanner (System.in);
	public static void main(String [] args){
		ReadFile rf = new ReadFile();
		System.out.print("Which file? ");
        //fileName = s.next();
        try {
			rf.readFile("input.txt");
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
	}
}
