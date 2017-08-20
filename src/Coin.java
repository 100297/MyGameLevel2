import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Coin extends GameObject{
	int position;
	public Coin() {
		isAlive = true;
		x= 1000;
	Random rana = new Random();
	y= rana.nextInt(650);
	width = 400;
	height = 200;
	collisionBox = new Rectangle(x, y , width/2, height/2);

	}
	
	void update(){
		super.update();
		collisionBox.setBounds(x+width/2-20, y+height/4, width/4+24 , height/2+20);
		
	}
	void draw( Graphics g){
		g.drawImage(GamePanel.CoinImg,x, y, width, height, null); 
		 x -=6;
		//g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		
	}
}                