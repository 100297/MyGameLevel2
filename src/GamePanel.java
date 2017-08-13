import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	Bat play;
	Timer time;
	Pipe pipe;
	Pipe pipe2;
	Pipe pipe3;
	Pipe pipe4;
	Coin coin;
	int coinSpawn;
	Respawn Respawn;
	public Boolean isDead;
	Boolean Pipe2Spawned;
	ArrayList<Coin> CoinobjectList = new ArrayList<Coin>();
	ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	public static BufferedImage CoinImg;

	public GamePanel() {
		play = new Bat();
		time = new Timer(1000 / 60, this);
				pipe = new Pipe();
		coinSpawn = 0;
		pipe2 = new Pipe();
		objectList.add(play);
		objectList.add(pipe);

		try {
			CoinImg = ImageIO.read(this.getClass().getResourceAsStream("ZachCoin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void startGame() {
		
		time.start();
		isDead = false;
		Pipe2Spawned = false;
		CoinobjectList.add(new Coin());
	}

	void startGame2() {
		time.start();
		isDead = false;

	}

	void drawGamePanel() {

	}

	void updateGamePanel() {

	}

	public void paintComponent(Graphics g) {
		// play.draw(g);
		
			for (Coin c  :  CoinobjectList) {			
				if(c!=null) {
					c.draw(g);
				}
			
			}
		


		if (coinSpawn % 180 == 0) {
			CoinobjectList.add(new Coin());
		}

		g.drawString("" + play.score, 500, 300);
		if (isDead == false) {
			for (int i = 0; i < objectList.size(); i++) {
				GameObject o = objectList.get(i);
				o.draw(g);
			}

		} else {
			g.drawString("You have lost", 500, 450);
			Respawn Respawn = new Respawn();
			Respawn.draw(g);
		}
		if (play.collisionBox.intersects(pipe2.collisionBox)) {
			isDead = true;

		}
		if (play.collisionBox.intersects(pipe.collisionBox)) {
			isDead = true;

		}
		coinSpawn += 1;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		update();
		repaint();
		if (coinSpawn % 180 == 0) {
			CoinobjectList.add(new Coin());
		}
	
			for (Coin c : CoinobjectList) {
			
				if (coin != null && play.collisionBox.intersects(c.collisionBox)) {
					System.out.println("Collided");
					play.score += 3000;
					CoinobjectList.remove(c);
				}

			}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		play.MoveX = e.getX();
		play.MoveY = e.getY();
		System.out.println("done");

		if (isDead) {
			Respawn();

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {		

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void Respawn() {
		play.x += 220;
		play.score = 0;
		isDead = false;

	}

	public void update() {
		if (isDead == false) {
			for(Coin c : CoinobjectList){
				if(c!=null) {
					c.update();	
				}
				
			}
			for (int i = 0; i < objectList.size(); i++) {
				GameObject o = objectList.get(i);
				o.update();
			}

		}

		if (pipe.x <= 500 && Pipe2Spawned == false) {
			objectList.add(pipe2);
			Pipe2Spawned = true;
		}

	}
}
