import java.awt.Color; 
import java.awt.Graphics;
import java.util.Random;

public class Pipe extends GameObject{
	int position;
	int speed = 16;
	public Pipe() {
	Random rana = new Random();
		y= rana.nextInt(650);
	x= 1050;
	width = 100;
	height = 350;

	}
	
	void update(){
		
		super.update();
		 x -=speed/2;
		
		 
		 if(x + 100 <= 0) {
			 x = 1000;
			 Random ran = new Random();
	 y = ran.nextInt(650);
		 speed+= 1;
		 System.out.println(speed + "");
		 }
		 collisionBox.setBounds(x, y, width, height);
	}
	void draw( Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		
		 g.setColor(Color.RED);
			g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
}
