import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bat {
	int movex;
	int movey;
	int x;
	int y;
	int width;
	int height;
	private Color color;

	public Bat(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void update(Keyboard keyboard) {

		if (keyboard.isKeyDown(Key.Right) && getX() < 800 - 115) {
			setX(getX() + 5);
		}

		if (keyboard.isKeyDown(Key.Left) && getX() > 0) {
			setX(getX() - 5);
		}

	}

	public Rectangle getBorder() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		graphics.setColor(Color.blue);
		graphics.drawLine(0, 65, 800, 65);

	}

}
