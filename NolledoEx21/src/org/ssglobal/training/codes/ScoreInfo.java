package org.ssglobal.training.codes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreInfo {

	private String firstName;
	private String lastName;
	private int score;

	public ScoreInfo(String lName, String fName, int s) {
		firstName = fName;
		lastName = lName;
		score = s;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return String.join(" ", firstName, lastName, String.valueOf(score));
	}

}

class Score {

	public long getNumScores(ScoreInfo[] scoreData) {
		return Arrays.stream(scoreData).parallel().count();
	}

	public double getAverage(ScoreInfo[] scoreData) {
		int total = Arrays.stream(scoreData).parallel().mapToInt(s -> s.getScore()).sum();
		return (double) total / getNumScores(scoreData);
	}

	public long getNumberAListers(ScoreInfo[] scoreData) {
		return Arrays.stream(scoreData).parallel().filter(s -> s.getScore() >= 90).count();
	}

	public List<String> getFailingStudentList(ScoreInfo[] scoreData) {
		return Arrays.stream(scoreData).filter(s -> (s.getScore() < 70))
				.map(s -> (s.getFirstName() + " " + s.getLastName())).collect(Collectors.toList());
	}

	public void printPassingStudents(ScoreInfo[] scoreData) {
		System.out.println("Passing students: ");
		Arrays.stream(scoreData).filter(s -> (s.getScore() >= 70)).map(s -> (s.getFirstName() + " " + s.getLastName()))
		.collect(Collectors.toList()).stream().forEach(System.out::println);
		System.out.println();
	}

	public void displayAllStudents(ScoreInfo[] scoreData) {
		System.out.println("Students:");
		Arrays.stream(scoreData).sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
		.forEach(s -> System.out.printf("  %s, %s: %d%n", s.getLastName(), s.getFirstName(), s.getScore()));
		System.out.println();
	}

	public List<String> getStudentRecords(ScoreInfo[] scoreData) {
		return Arrays.stream(scoreData).sorted((s1, s2) -> s1.getScore() - s2.getScore())
				.map(s -> (s.getFirstName() + " " + s.getLastName()) + " " + s.getScore()).collect(Collectors.toList());
	}
}

