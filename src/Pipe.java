import java.awt.Color; 
import java.awt.Graphics;

public class Pipe extends GameObject{
	int position;
	public Pipe() {
	x= 900;
	y= 620;
	width = 100;
	height = 350;
}
	
	void update(){
		super.update();
	}
	void draw( Graphics g){
		g.fillRect(x, y, width, height);
		 x -=6;
	}
}
