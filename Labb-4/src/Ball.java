import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Sprite {
	int movex;
	int movey;

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		movex = 4;
		movey = 4;
	}

	private void bounce() {
		if (getX() + 38 > 800) {
			movex = -movex;
		}

		if (getX() == 0) {
			movex = -movex;
		}

		if (getY() == 60) {
			movey = -movey;
		}

	}

	@Override
	public void update(Keyboard keyboard) {
		setX(getX() + movex);
		setY(getY() + movey);
		bounce();

		if (getY() + 60 >= Constant.WINDOW_HEIGHT) {
			if (Text.life > 0) {
				setX(Constant.SPAWNX);
				setY(Constant.SPAWNY);
				Text.life = Text.life - 1;
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.red);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
