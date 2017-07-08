import java.awt.Color; 
import java.awt.Graphics;

public class Coin extends GameObject{
	int position;
	public Coin() {
	x= 300;
	y= 200;
	width = 100;
	height = 350;
}
	
	void update(){
		super.update();
	}
	void draw( Graphics g){
		g.fillOval(x, y, width, height);
		 x -=6;
	}
}                