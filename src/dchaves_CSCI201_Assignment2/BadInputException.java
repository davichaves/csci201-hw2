package dchaves_CSCI201_Assignment2;

public class BadInputException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BadInputException (){
		
	}
	public String getMessage(){
		return "Bad input!!!";
	}
}