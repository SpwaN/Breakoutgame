import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Game {
	public static Ball ball;
	public static Bat bat;
	public static RectGrid rgrid;
	public static ScorePanel s;
	public static int totalBricks = 21;
	public static int games = 0;
	int d = 0;

	public Game(GameBoard board) {
		ball = new Ball(Constant.SPAWNX, Constant.SPAWNY, Constant.BALL_WIDTH, Constant.BALL_HEIGHT);
		bat = new Bat(400, 500, Constant.BAT_WIDTH, Constant.BAT_HEIGHT, Color.white);
		rgrid = new RectGrid(3, 7);
		Text.life = 3;
		HighScore.HScore();
	}

	public void update(Keyboard keyboard) {
		if (totalBricks == 0) {
			for (d = 0; d < 1; d++) {
				if (games == 0) {
					s = new ScorePanel();
					games++;
				}
				s.setVisible(true);
			}
		}
		if (Text.life >= 1 && totalBricks > 0) {
			boolean gamePaused = false;
			if (keyboard.isKeyDown(Key.Space))
				totalBricks = 1;
			if (keyboard.isKeyDown(Key.P))
				gamePaused = true;

			if (gamePaused == true) {
				while (true) {
					System.out.println("Game paused.");
					if (keyboard.isKeyDown(Key.P)) {
						gamePaused = false;
						break;
					}
				}
			} else if (gamePaused == false) {
				ball.update(keyboard);
				bat.update(keyboard);
				rgrid.update(keyboard);

				if (new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight())
						.intersects(new Rectangle(bat.getX(), bat.getY(), 100, 8))) {
					ball.movey = -ball.movey;
				}

				Collision: for (int i = 0; i < rgrid.grid.length; i++) {
					for (int j = 0; j < rgrid.grid[0].length; j++) {
						if (rgrid.grid[i][j] > 0) {
							int brickX = j * rgrid.width + 80;
							int brickY = i * rgrid.height + 80;
							int brickWidth = rgrid.width;
							int brickHeight = rgrid.height;

							Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
							Rectangle ballRect = new Rectangle(ball.getX(), ball.getY(), 20, 20);
							Rectangle batRect = new Rectangle(bat.getX(), bat.getY(), bat.getWidth(), bat.getHeight());
							Rectangle brickRect = rect;

							if (i == 0) {
								if (ballRect.intersects(brickRect)) {

									rgrid.setRectLife(rgrid.grid[i][j] - 1, i, j);

									if (rgrid.grid[i][j] >= 1) {
										Text.score = Text.score + 1;
									} else {
										Text.score = Text.score + 5;
										totalBricks--;
									}

									if (ball.getX() + 19 <= brickRect.x
											|| ball.getX() + 1 >= brickRect.x + brickRect.width) {
										ball.movex = -ball.movex;
									} else {
										ball.movey = -ball.movey;
									}

									if (ballRect.intersects(batRect)) {
										ball.movey = -ball.movey;
									}

									break Collision;
								}
							} else if (i == 1) {
								if (ballRect.intersects(brickRect)) {

									rgrid.setRectLife(rgrid.grid[i][j] - 1, i, j);

									if (rgrid.grid[i][j] >= 1) {
										Text.score = Text.score + 1;
									} else {
										Text.score = Text.score + 3;
										totalBricks--;
									}

									if (ball.getX() + 19 <= brickRect.x
											|| ball.getX() + 1 >= brickRect.x + brickRect.width) {
										ball.movex = -ball.movex;
									} else {
										ball.movey = -ball.movey;
									}

									if (ballRect.intersects(batRect)) {
										ball.movey = -ball.movey;
									}

									break Collision;
								}
							} else {
								if (ballRect.intersects(brickRect)) {

									rgrid.setRectLife(0, i, j);
									totalBricks--;

									Text.score = Text.score + 1;

									if (ball.getX() + 19 <= brickRect.x
											|| ball.getX() + 1 >= brickRect.x + brickRect.width) {
										ball.movex = -ball.movex;
									} else {
										ball.movey = -ball.movey;
									}

									if (ballRect.intersects(batRect)) {
										ball.movey = -ball.movey;
									}

									break Collision;
								}
							}
						}
					}
				}
				if (games == 1 && (Text.life == 0 || totalBricks == 0)) {
					s.InsertName();
				}
			}
		}
	}

	public void draw(Graphics2D graphics) {
		if (Text.life >= 1 && totalBricks > 0) {
			ball.draw(graphics);
			bat.draw(graphics);
			rgrid.draw(graphics);
		}

		Text.lives(graphics);
		Text.currentScore(graphics);
		Text.highScore(graphics);
	}
}
