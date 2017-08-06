import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Coin extends GameObject{
	int position;
	public Coin() {

		x= 1000;
	Random rana = new Random();
	y= rana.nextInt(650);
	width = 400;
	height = 200;
	collisionBox = new Rectangle(x, y , width, height);

	}
	
	void update(){
		super.update();
		
	}
	void draw( Graphics g){
		g.drawImage(GamePanel.CoinImg,x, y, width, height, null); 
		 x -=6;
	}
}                