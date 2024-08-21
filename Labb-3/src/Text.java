import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

public class Text {
	public static int life;
	public static int fontSize;

	public static void lives(Graphics2D graphics) {
		String text;
		Font Arcade = null;

		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Arcade = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("/resources/ARCADE.TTF"));
			ge.registerFont(Arcade);
		} catch (IOException | FontFormatException e) {

		}

		fontSize = 30;
		text = "Lives left: ";
		graphics.setColor(Color.red);
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, fontSize - 10));
		if (life == 3) {
			graphics.drawString("❤️❤️❤️", 700, fontSize + 20);
		} else if (life == 2) {
			graphics.drawString("❤️❤️", 700, fontSize + 20);
		} else if (life == 1) {
			graphics.drawString("❤️", 700, fontSize + 20);
		} else {
			// Arcade.deriveFont(30f);
			graphics.setFont(Arcade);
			// graphics.setFont(new Font("ARCADE", Font.BOLD, fontSize));
			graphics.drawString("GAME OVER", 300, fontSize + 200);
		}
		graphics.setFont(new Font("ARCADE", Font.BOLD, fontSize));
		if (life > 0) {
			graphics.drawString(text, 700, fontSize);
		} else {
			graphics.drawString(text, 800, 800);
		}

		if (Game.totalBricks <= 0) {
			graphics.setFont(new Font("TimesRoman", Font.BOLD, fontSize + 10));
			graphics.setColor(Color.YELLOW);
			graphics.drawString("VICTORY!", 300, Text.fontSize + 200);
		}
		/// resources/Fonts/ARCADE.TTF
	}

	public static int score;

	public static void currentScore(Graphics2D graphics) {
		String text = "Score:";
		int fontSize = 30;
		graphics.setFont(new Font("ARCADE", Font.BOLD, fontSize));
		graphics.setColor(Color.blue);
		if (life > 0) {
			graphics.drawString(text, 20, fontSize);
			graphics.drawString("" + score, 20, fontSize * 2);
		} else {
			graphics.drawString(text, 300, fontSize + 290);
			graphics.drawString("" + score, 300, fontSize + 320);
		}
		if (Game.totalBricks <= 0) {
			graphics.drawString(text, 300, fontSize + 290);
			graphics.drawString("" + score, 300, fontSize + 320);
		}
	}

	public static int Highscore;

	public static void highScore(Graphics2D graphics) {
		String text = "Highscore:";
		int fontSize = 30;
		graphics.setFont(new Font("ARCADE", Font.BOLD, fontSize));
		graphics.setColor(Color.blue);
		if (life > 0) {
			graphics.drawString(text, 300, fontSize);
			graphics.drawString("" + Highscore, 300, fontSize * 2);

		} else {
			graphics.drawString(text, 300, fontSize + 230);
			graphics.drawString("" + Highscore, 300, fontSize + 260);
		}
		if (Game.totalBricks <= 0) {
			graphics.drawString(text, 300, fontSize + 230);
			graphics.drawString("" + Highscore, 300, fontSize + 260);
		}

		if (score > Highscore) {
			HighScore.HScore();
		}
	}
}
