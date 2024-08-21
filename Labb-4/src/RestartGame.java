import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RestartGame extends Game {
	public RestartGame(GameBoard board) {
		super(board);
	}

	@Override
	public void draw(Graphics2D graphics) {
		ball.draw(graphics);
		bat.draw(graphics);
		rgrid.draw(graphics);
	}

	public static void restart() {
		Text.life = 3;
		Text.score = 0;
		Game.totalBricks = 21;
		Game.s.setVisible(false);
		rgrid = new RectGrid(3, 7);

		ball.setX(Constant.SPAWNX);
		ball.setY(Constant.SPAWNY);
		ball.movex = 4;
		ball.movey = 4;

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

							if (ball.getX() + 19 <= brickRect.x || ball.getX() + 1 >= brickRect.x + brickRect.width) {
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

							if (ball.getX() + 19 <= brickRect.x || ball.getX() + 1 >= brickRect.x + brickRect.width) {
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

							if (ball.getX() + 19 <= brickRect.x || ball.getX() + 1 >= brickRect.x + brickRect.width) {
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
	}
}
