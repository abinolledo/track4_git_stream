package org.ssglobal.training.codes;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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

	public int getNumScores(List<ScoreInfo> scoreData) {
		return scoreData.size();
	}

	public double getAverage(List<ScoreInfo> scoreData) {
		Function<ScoreInfo, Integer> mapScores = (s)->{
			return s.getScore();
		};
		int total = scoreData.stream().map(mapScores).mapToInt(Integer::intValue).sum();
		return (double) scoreData.stream().map(mapScores).mapToInt(Integer::intValue).average().orElse(total);
	}

	public long getNumberAListers(List<ScoreInfo> scoreData) {
		Predicate<ScoreInfo> filterAListers = (s)->{
			if (s.getScore() >= 90) {
				return true;
			}return false;
		};
		return scoreData.stream().filter(filterAListers).count();
	}

	public List<String> getFailingStudentList(List<ScoreInfo> scoreData) {
		Comparator<ScoreInfo> sorter = (o1, o2)->{
			if(o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			}else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0) {
				return -2;
			}else {
			return 0;
			}
		};
		
		Predicate<ScoreInfo> filterFailingStudents = (s)->{
			if (s.getScore() < 70) {
				return true;
			}return false;
		};
		Function<ScoreInfo, String> mapNames = (s)->{
			return String.join(" ", s.getFirstName(), s.getLastName());
		};
		return scoreData.stream().sorted(sorter).filter(filterFailingStudents).map(mapNames).collect(Collectors.toList());
	}

	public void printPassingStudents(List<ScoreInfo> scoreData) {
		Comparator<ScoreInfo> sorter = (o1, o2)->{
			if(o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			}else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0) {
				return -2;
			}else {
			return 0;
			}
		};
		
		Predicate<ScoreInfo> filterPassingStudents = (s)->{
			if (s.getScore() >= 70) {
				return true;
			}return false;
		};
		Function<ScoreInfo, String> mapNames = (s)->{
			return String.join(" ", s.getFirstName(), s.getLastName());
		};
		List<String> passingStudents = scoreData.stream().sorted(sorter).filter(filterPassingStudents).map(mapNames).collect(Collectors.toList());
		System.out.println(passingStudents);
	}

	public void displayAllStudents(List<ScoreInfo> scoreData) {
		Comparator<ScoreInfo> sorter = (o1, o2)->{
			if(o1.getLastName().compareTo(o2.getLastName()) > 0) {
				return 2;
			}else if (o1.getLastName().compareTo(o2.getLastName()) < 0) {
				return -2;
			}else {
			return 0;
			}
		};
		
		Function<ScoreInfo, String> mapNames = (s)->{
			return String.join(" ", s.getFirstName(), s.getLastName(), String.valueOf(s.getScore()));
		};
		List<String> passingStudents = scoreData.stream().sorted(sorter).map(mapNames).collect(Collectors.toList());
		System.out.println(passingStudents);
	}

	public List<String> getStudentRecords(List<ScoreInfo> scoreData) {
		Comparator<ScoreInfo> sorter = (o1, o2)->{
			if(o1.getScore() > o2.getScore()) {
				return 2;
			}else if (o1.getScore() < o2.getScore()) {
				return -2;
			}else {
			return 0;
			}
		};
		
		Function<ScoreInfo, String> mapNames = (s)->{
			return String.join(" ", s.getFirstName(), s.getLastName(), String.valueOf(s.getScore()));
		};
		return scoreData.stream().sorted(sorter).map(mapNames).collect(Collectors.toList());
	}
}

