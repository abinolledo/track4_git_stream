package org.ssglobal.training.codes;

public class TestScore {

	public static void main(String[] args) {

		Score scores = new Score();

		ScoreInfo[] scoreData = new ScoreInfo[] { new ScoreInfo("Smith", "John", 70), new ScoreInfo("Doe", "Mary", 85),
				new ScoreInfo("Page", "Alice", 82), new ScoreInfo("Cooper", "Jill", 97),
				new ScoreInfo("Flintstone", "Fred", 66), new ScoreInfo("Rubble", "Barney", 80),
				new ScoreInfo("Smith", "Judy", 48), new ScoreInfo("Dean", "James", 90),
				new ScoreInfo("Russ", "Joe", 55), new ScoreInfo("Wolfe", "Bill", 73), new ScoreInfo("Dart", "Mary", 54),
				new ScoreInfo("Rogers", "Chris", 78), new ScoreInfo("Toole", "Pat", 51),
				new ScoreInfo("Khan", "Omar", 93), new ScoreInfo("Smith", "Ann", 95), };

		System.out.println(scores.getNumScores(scoreData));
		System.out.println(scores.getAverage(scoreData));
		System.out.println(scores.getNumberAListers(scoreData));
		System.out.println(scores.getFailingStudentList(scoreData));
		scores.printPassingStudents(scoreData);
		scores.displayAllStudents(scoreData);
		System.out.println(scores.getStudentRecords(scoreData));

	}

}
