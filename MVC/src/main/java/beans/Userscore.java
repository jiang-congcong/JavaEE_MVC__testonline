package beans;

public class Userscore {
	int id;
	String username;
	int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Userscore(int id, String username, int score) {
		
		this.id = id;
		this.username = username;
		this.score = score;
	}
	
    public Userscore() {		
		this.id = 0;
		this.username = "";
		this.score = 0;
	}
	

}
