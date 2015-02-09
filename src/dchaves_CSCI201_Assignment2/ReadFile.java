package dchaves_CSCI201_Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReadFile {
	private static String [] lines = new String[21];
	private static Users [] users = new Users[10];
	private static char [][] myGrid = new char[10][10];
	private static int numberOfLines, Acount, Bcount, Ccount, Dcount, Xcount;
	private static BufferedReader reader;
	private static FileReader fileReader;
	
	public ReadFile(String fileName) throws IOException, FileNotFoundException { 
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
	
	public void checkInput() throws BadInputException {
		if (numberOfLines != 21) throw new BadInputException(); //check for number of lines
		if (!lines[0].equalsIgnoreCase("Highscores:")) throw new BadInputException();
		checkLeaderboard();
		checkGrid();
		checkBoats();
	}
	
	public static void checkLeaderboard() throws BadInputException {
		for(int i = 1; i < 11; i++){ //iterate over the lines
			lines[i] = lines[i].replaceAll(" ","");
			StringTokenizer tokenizer = new StringTokenizer(lines[i], ".");
			int numberOfTokens = tokenizer.countTokens();
			if(numberOfTokens > 2) throw new BadInputException();
			if(numberOfTokens < 1) throw new BadInputException();
			if(numberOfTokens == 2) {
				String [] myInputs = new String[numberOfTokens];
				for(int j = 0; j<numberOfTokens; j++){
					myInputs[j] = tokenizer.nextToken();
				}
				try {
					Integer.parseInt(myInputs[0]);
				} catch(NumberFormatException e) {
					throw new BadInputException();
				}
				if(myInputs[1].equals("")) {
					users[i-1].setName("");
					users[i-1].setScore(0);
				} else {
					StringTokenizer tokenizer2 = new StringTokenizer(myInputs[1], "-");
					int numberOfTokens2 = tokenizer2.countTokens();
					if(numberOfTokens2 > 2) throw new BadInputException();
					String [] myInputs2 = new String[numberOfTokens2];
					for(int j = 0; j<numberOfTokens; j++){
						myInputs2[j] = tokenizer2.nextToken();
					}
					users[i-1] = new Users();
					users[i-1].setName(myInputs2[0]);
					try {
						users[i-1].setScore(Integer.parseInt(myInputs2[1]));
					} catch(NumberFormatException e) {
						throw new BadInputException();
					}
				}
			} else {
				users[i-1] = new Users();
				users[i-1].setName("");
				users[i-1].setScore(0);
			}
		} // end of the first for loop
	}
	
	public static void checkGrid() throws BadInputException {
		Acount = Bcount = Ccount = Dcount = Xcount = 0;
		for(int i = 0; i < 10; i++){
			String line = lines[i+11];
			if(line.length() != 10) throw new BadInputException();
			for(int j = 0; j < 10; j++){
				char myChar = line.charAt(j);
				myGrid[i][j] = myChar;
				if(myChar == 'A') Acount+=1;
				else if (myChar == 'B') Bcount+=1;
				else if (myChar == 'C') Ccount+=1;
				else if (myChar == 'D') Dcount+=1;
				else Xcount+=1;
			} //end of the inner for loop
		} // end of the outer for loop
		if(Acount != 5) throw new BadInputException();
		if(Bcount != 4) throw new BadInputException();
		if(Ccount != 3) throw new BadInputException();
		if(Dcount != 4) throw new BadInputException();
		if(Xcount != 84) throw new BadInputException();
	}
	
	private void checkBoats() throws BadInputException {
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(myGrid[i][j] == 'A') 
					if(checkColumn('A', 5, i, j) && checkLine('A', 5, i, j)) 
						throw new BadInputException();
				if (myGrid[i][j] == 'B')
					if(checkColumn('B', 4, i, j) && checkLine('B', 4, i, j)) 
						throw new BadInputException();
				if (myGrid[i][j] == 'C') 
					if(checkColumn('C', 3, i, j) && checkLine('C', 3, i, j)) 
						throw new BadInputException();
				if (myGrid[i][j] == 'D') 
					if(checkColumn('D', 2, i, j) && checkLine('D', 2, i, j)) 
						throw new BadInputException();
			} //end of the inner for loop
		} // end of the outer for loop
	}
	
	private static boolean checkLine(char myChar, int length, int i, int j){
		for(int k = j; k < length; k++) {
			if(myGrid[i][k] != myChar) return true;
		}
		return false;
	}
	
	private static boolean checkColumn(char myChar, int length, int i, int j){
		for(int k = i; k < length; k++) {
			if(myGrid[k][j] != myChar) return true;
		}
		return false;
	}
	
	public char [][] returnGrid() {
		return myGrid;
	}
	
	public Users [] returnUsers() {
		return users;
	}

	private static void debug(){
		System.out.println("pqp");
	}
}