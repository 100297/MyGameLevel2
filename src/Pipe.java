import java.awt.Color; import java.awt.Graphics;

public class Pipe extends GameObject{
	int position;
	public Pipe() {
	x= 1000;
	y= 900;
	width = 150;
	height = 500;
}
	
	void update(){
		super.update();
	}
	void draw( Graphics g){
		g.fillRect(x, y, width, height);
	}
}
