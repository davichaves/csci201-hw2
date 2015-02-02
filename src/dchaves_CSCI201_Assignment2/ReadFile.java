package dchaves_CSCI201_Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
	private static String [] lines = new String[21];
	private static Scanner s = new Scanner (System.in); 
	private static String fileName = new String();
	private static int numberOfLines;
	private static BufferedReader reader;
	public static void readFile(String fileName) throws IOException, FileNotFoundException { 
        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);
        numberOfLines = 1;
        while (true) {
			if (numberOfLines > 21) break;
            lines[numberOfLines-1] = reader.readLine();
            if (lines[numberOfLines-1] == null) break;
            numberOfLines++;
        }
        reader.close();
        fileReader.close();
	}
	
	public static void checkInput() throws BadInputException {
		if (numberOfLines != 21) throw new BadInputException();
		
	}
	
	public static void main(String [] args){
		System.out.print("Which file? ");
        fileName = s.next();
        try {
			readFile(fileName);
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		} catch (IOException ioe) {
			System.out.println("Input error!");
		} 
        try {
        	checkInput();
        } catch (BadInputException bie) {
        	System.out.println("Bad Input!");
		}
	}
}