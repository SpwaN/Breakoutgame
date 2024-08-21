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
			while (line != null) {
				try {
					int score = Integer.parseInt(line.trim());
					if (score > Highscore) {
						Highscore = score;
					}
				} catch (NumberFormatException e1) {
				}
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException ex) {
			System.err.println("ERROR reading scores from file");
		}

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
