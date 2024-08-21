import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighScore extends Text {
	public static void HScore() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("resources/highscore.txt"));
			String line = reader.readLine();
			while (line != null) // read the score file line by line
			{
				try {
					int score = Integer.parseInt(line.trim()); // parse each line as an int
					if (score > Highscore) // and keep track of the largest
					{
						Highscore = score;
					}
				} catch (NumberFormatException e1) {
					// ignore invalid scores
					// System.err.println("ignoring invalid score: " + line);
				}
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException ex) {
			System.err.println("ERROR reading scores from file");
		}
		// display the high score
		if (score > Highscore) {
			System.out.println("You now have the new high score! The previous high score was " + Highscore);
		} else if (score == Highscore) {
			System.out.println("You tied the high score!");

		} else {
			System.out.println("The all time high score was " + Highscore);
		}

		// append the last score to the end of the file
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("resources/highscore.txt", true));
			output.newLine();
			output.append("" + score);
			output.close();

		} catch (IOException ex1) {
			System.out.printf("ERROR writing score to file: %s\n", ex1);
		}
	}
}
