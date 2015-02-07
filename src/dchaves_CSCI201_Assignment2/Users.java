package dchaves_CSCI201_Assignment2;

public class Users {
	private String name;
	private int score;
	Users( ) {
		
		
	}
	Users(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
