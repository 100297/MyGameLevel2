import java.awt.Color;
import java.awt.Graphics;

public class Bat extends GameObject {
	int speed;
	public int MoveX = 100;
	public int MoveY = 100;

	public Bat() {
		super();
		x = 100;
		y = 100;
		width = 50;
		height = 50;
		speed = 5;

	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		if (x != MoveX || y != MoveY) {
			if (x < MoveX) {
				x++;
			} else {
				x--;
			}
			if (y < MoveY) {
				y++;
			} else {
				y--;
			}

		}
	}
}
