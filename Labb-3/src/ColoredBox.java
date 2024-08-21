import java.awt.Color;
import java.awt.Graphics2D;

public class ColoredBox extends Sprite {
	private Color color;
	static private Ball ball = new Ball(Constant.SPAWNX, Constant.SPAWNY, Constant.BALL_WIDTH, Constant.BALL_HEIGHT);

	public ColoredBox(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.color = color;
	}

	@Override
	public void update(Keyboard keyboard) {
		collisionBox();
	}

	public boolean collisionBox() {
		for (int i = 0; i < 9; i++) {
			if (ball.getX() > getX() && ball.getX() < getX() + getWidth() && ball.getY() > getY()
					&& ball.getY() < getY() + getHeight()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(color);
		graphics.drawRect(getX(), getY(), getWidth(), getHeight());
	}

}
