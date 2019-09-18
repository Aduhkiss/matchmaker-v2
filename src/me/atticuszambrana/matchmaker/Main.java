package me.atticuszambrana.matchmaker;

public class Main {
	
	static Matchmaker mm;
	
	public static void main(String[] args) {
		mm = new Matchmaker();
	}
	
	public static Matchmaker getMatchmaker() {
		return mm;
	}
}
