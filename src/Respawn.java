import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Respawn extends JButton {
	int x;
	int y;
	int width;
	int height;
	Respawn() {
		x = 500;
		y = 750;
		width = 200;
		height = 40;
	}
void draw(Graphics g ) {
	g.fillRect(x, y, width, height);
	g.setColor(Color.YELLOW);
	g.drawString("Respawn", 550, 770);
}
}
