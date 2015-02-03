package dchaves_CSCI201_Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile {
	private static String [] lines = new String[21];
	private static Users [] users = new Users[10];
	private static Scanner s = new Scanner (System.in);
	private static String fileName = new String();
	private static int numberOfLines, Acount, Bcount, Ccount, Dcount, Xcount;
	private static BufferedReader reader;
	private static FileReader fileReader;
	public static void readFile(String fileName) throws IOException, FileNotFoundException { 
        fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);
        numberOfLines = 0;
        while (true) {
        	if (numberOfLines > 20) break;
            lines[numberOfLines] = reader.readLine();
            if (lines[numberOfLines] == null) break;
            numberOfLines++;
        }
        reader.close();
        fileReader.close();
	}
	
	public static void checkInput() throws BadInputException {
		if (numberOfLines != 21) throw new BadInputException(); //check for number of lines
		if (!lines[0].equalsIgnoreCase("Highscores:")) throw new BadInputException();
		for(int i = 1; i < 11; i++){ //iterate over the lines
			lines[i].replaceAll("\\s+","");
			StringTokenizer tokenizer = new StringTokenizer(lines[i], ".");
			int numberOfTokens = tokenizer.countTokens();
			if(numberOfTokens != 2) throw new BadInputException();
			String [] myInputs = new String[numberOfTokens];
			for(int j = 0; j<numberOfTokens; j++){
				myInputs[j] = tokenizer.nextToken();
			}
			try {
				Integer.parseInt(myInputs[0]);
			} catch(NumberFormatException e) {
				throw new BadInputException();
			}
			StringTokenizer tokenizer2 = new StringTokenizer(myInputs[1], "-");
			int numberOfTokens2 = tokenizer2.countTokens();
			if(numberOfTokens2 > 2) throw new BadInputException();
			String [] myInputs2 = new String[numberOfTokens2];
			for(int j = 0; j<numberOfTokens; j++){
				myInputs2[j] = tokenizer2.nextToken();
			}
			if(numberOfTokens2 < 2) {
				users[i].setName("");
				users[i].setScore(0);
			} else {
				users[i].setName(myInputs2[0]);
				try {
					users[i].setScore(Integer.parseInt(myInputs2[1]));
				} catch(NumberFormatException e) {
					throw new BadInputException();
				}
			}
		} // end of the for loop
		for(int i = 11; i < 21; i++){
			if(lines[i].length() != 10) throw new BadInputException();
			Acount = Bcount = Ccount = Dcount = Xcount = 0;
			for(int j = 0; j < 10; j++){
				char myChar = lines[i].charAt(j);
				if(myChar == 'A') {
					Acount+=1;
				} else if (myChar == 'B') {
					Bcount+=1;
				} else if (myChar == 'C') {
					Ccount+=1;
				} else if (myChar == 'D') {
					Dcount+=1;
				} else {
					Xcount+=1;
				}
			}
		}
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
        try {
        	Integer.parseInt("10");
        } catch (NumberFormatException nfe) {
			System.out.println("pqp!");
		}
	}
}