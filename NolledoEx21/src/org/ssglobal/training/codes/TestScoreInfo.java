package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.List;

public class TestScoreInfo {

	public static void main(String[] args) {

		Score scores = new Score();

		List<ScoreInfo> scoreData = new ArrayList<>();
		
		scoreData.add(new ScoreInfo("Smith", "John", 70));
		scoreData.add(new ScoreInfo("Doe", "Mary", 85));
		scoreData.add(new ScoreInfo("Page", "Alice", 82));
		scoreData.add(new ScoreInfo("Cooper", "Jill", 97));
		scoreData.add(new ScoreInfo("Flintstone", "Fred", 66));
		scoreData.add(new ScoreInfo("Rubble", "Barney", 80));
		scoreData.add(new ScoreInfo("Smith", "Judy", 48));
		scoreData.add(new ScoreInfo("Dean", "James", 90));
		scoreData.add(new ScoreInfo("Russ", "Joe", 55));
		scoreData.add(new ScoreInfo("Wolfe", "Bill", 73));
		scoreData.add(new ScoreInfo("Dart", "Mary", 54));
		scoreData.add(new ScoreInfo("Rogers", "Chris", 78));
		scoreData.add(new ScoreInfo("Toole", "Pat", 51));
		scoreData.add(new ScoreInfo("Khan", "Omar", 93));
		scoreData.add(new ScoreInfo("Smith", "Ann", 95));

		System.out.println(scores.getNumScores(scoreData));
		System.out.println(scores.getAverage(scoreData));
		System.out.println(scores.getNumberAListers(scoreData));
		System.out.println(scores.getFailingStudentList(scoreData));
		scores.printPassingStudents(scoreData);
		scores.displayAllStudents(scoreData);
		System.out.println(scores.getStudentRecords(scoreData));

	}

}
