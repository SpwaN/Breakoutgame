import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class RectGrid {
	public int grid[][];
	public int x, y, width, height, j, life;

	public RectGrid(int row, int collumn) {
		grid = new int[row][collumn];
		for (int i = 0; i < grid.length; i++) {
			for (j = 0; j < grid[0].length; j++) {
				if (i == 0) {
					grid[i][j] = 3;
				} else if (i == 1) {
					grid[i][j] = 2/* RandNum */;
				} else {
					grid[i][j] = 1/* RandNum */;
				}
			}
		}
		width = 540 / collumn;
		height = 140 / row;

	}

	public void update(Keyboard keyboard) {

	}

	public void draw(Graphics2D graphics) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > 0) {
					// Box
					graphics.setColor(Color.WHITE);
					graphics.fillRect(j * width + 80, i * height + 80, width, height);
					// Border
					graphics.setStroke(new BasicStroke(5));
					graphics.setColor(Color.BLACK);
					graphics.drawRect(j * width + 80, i * height + 80, width, height);
					if (i == 0) { // Rad 1
						// Box
						graphics.setColor(Color.BLUE);
						graphics.fillRect(j * width + 80, i * height + 80, width, height);
						if (grid[i][j] == 3) {
							// Border
							graphics.setStroke(new BasicStroke(3.0f));
							graphics.setColor(Color.BLACK);
							graphics.drawRect(j * width + 80, i * height + 80, width, height);
						} else if (grid[i][j] == 2) {
							// Box
							graphics.setColor(Color.YELLOW);
							graphics.fillRect(j * width + 80, i * height + 80, width, height);
							// Border
							graphics.setStroke(new BasicStroke(3.0f));
							graphics.setColor(Color.BLACK);
							graphics.drawRect(j * width + 80, i * height + 80, width, height);
						} else {
							// Box
							graphics.setColor(Color.WHITE);
							graphics.fillRect(j * width + 80, i * height + 80, width, height);
							// Border
							graphics.setStroke(new BasicStroke(3.0f));
							graphics.setColor(Color.YELLOW);
							graphics.drawRect(j * width + 80, i * height + 80, width, height);
						}

					} else if (i == 1) { // Rad 2
						// Box
						graphics.setColor(Color.YELLOW);
						graphics.fillRect(j * width + 80, i * height + 80, width, height);
						if (grid[i][j] == 1) {
							// Box
							graphics.setColor(Color.WHITE);
							graphics.fillRect(j * width + 80, i * height + 80, width, height);
							// Border
							graphics.setStroke(new BasicStroke(3.0f));
							graphics.setColor(Color.RED);
							graphics.drawRect(j * width + 80, i * height + 80, width, height);
						} else {
							// Border
							graphics.setStroke(new BasicStroke(3.0f));
							graphics.setColor(Color.BLACK);
							graphics.drawRect(j * width + 80, i * height + 80, width, height);
						}

					} else { // Rad 3
						// Box
						graphics.setColor(Color.WHITE);
						graphics.fillRect(j * width + 80, i * height + 80, width, height);
						// Border
						graphics.setStroke(new BasicStroke(3.0f));
						graphics.setColor(Color.BLACK);
						graphics.drawRect(j * width + 80, i * height + 80, width, height);
					}

				}
			}
		}
	}

	public void setRectLife(int life, int row, int collumn) {
		grid[row][collumn] = life;
	}

}
