package dchaves_CSCI201_Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Scanner;

public class ReadFile {
	private static String [] lines = new String[100];
//	private static Scanner s; 
//	private static String fileName = new String();
	public static void readFile(String fileName) throws IOException, FileNotFoundException{
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        int counter = 0;
        while (true) {
            lines[counter] = reader.readLine();
            if (lines[counter] == null) {
                break;
            }
            counter++;
        }
        reader.close();
        fileReader.close();
	}
	public static void main(String [] args){
		//System.out.print("Which file?");
        //fileName = s.next();
        try {
			readFile("input.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Error reading the file!");
		}
        for(int i = 0; i < 10; i++){
        	System.out.println(lines[i]);
        }
	}
}