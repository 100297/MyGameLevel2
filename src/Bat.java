import java.awt.Color;
import java.awt.Graphics;

public class Bat extends GameObject {
	boolean isdead = false;
	int speed;
	public int MoveX = 100;
	public int MoveY = 100;
	public int score;
	
	public Bat() {
		super();
		x = 100;
		y = 100;
		width = 100;
		height = 50;
		speed = 23;
		score = 0;
		
	}

	void update() {
		super.update();
		if (x != MoveX || y != MoveY) {
			if (x < MoveX && Math.abs(MoveX - x) >= speed) {
				x += speed;
			} else if (Math.abs(MoveX - x) >= speed) {
				x -= speed;
			}
			if (y < MoveY && MoveY - y >= Math.abs(speed)) {
				y += speed;

			} else if (Math.abs(MoveY - y) >= speed) {
				y -= speed;
			}
		score++;
		}

	
	
	}

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(GamePanel.BatImg,x, y, width, height, null); 
		
	
	}

}
