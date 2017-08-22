import java.awt.Color;
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
	Boolean inTitleScreen;
	int highScore;
	ArrayList<Coin> CoinobjectList = new ArrayList<Coin>();
	ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	public static BufferedImage CoinImg;
	public static BufferedImage BatImg;
	
	public GamePanel() {
		highScore = 0;
		play = new Bat();
		time = new Timer(1000 / 60, this);
		pipe = new Pipe();
		coinSpawn = 0;
		pipe2 = new Pipe();
		objectList.add(play);
		objectList.add(pipe);
		inTitleScreen = true;
		try {
			CoinImg = ImageIO.read(this.getClass().getResourceAsStream("ZachCoin.png"));
			BatImg = ImageIO.read(this.getClass().getResourceAsStream("images.png"));
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

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 900);
		g.setColor(Color.BLACK);
		if (play.score > highScore) {
			highScore = play.score;
		}
		if (inTitleScreen) {
			g.drawString("Use your mouse to control your player, Click to move", 50, 350);
			g.drawRect(50, 500, 200, 50);
			g.drawString("Click to Play", 100, 525);

		} else {
			for (Coin c : CoinobjectList) {
				if (c != null) {
					c.draw(g);
				}

			}

			if (coinSpawn % 180 == 0) {
				CoinobjectList.add(new Coin());
			}

			g.drawString("Score: " + play.score, 500, 300);
			if (isDead) {
				g.drawString("High Score: " + highScore, 500, 120);
			}
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		update();
		repaint();
		if (!inTitleScreen) {
			if (coinSpawn % 180 == 0) {
				CoinobjectList.add(new Coin());
			}
		}
		for (Coin c : CoinobjectList) {

			if (c != null && play.collisionBox.intersects(c.collisionBox)) {
				System.out.println("Collided");
				play.score += 3000;
				c.isAlive = false;
			}

		}
		for (int i = 0; i < CoinobjectList.size(); i++) {
			Coin c = CoinobjectList.get(i);
			if (c != null && c.isAlive == false) {
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
		play.MoveX = e.getX() -40;
		play.MoveY = e.getY() -40;

		if (isDead && e.getX() < 700 && e.getX() > 500 && e.getY() < 950 && e.getY() > 750) {
			System.out.println("Should Respawn");
			Respawn();

		}
		if (e.getX() < 250 && e.getX() > 50 && e.getY() < 550 && e.getY() > 500)
		
		{
			inTitleScreen = false;
			System.out.println("End Title Screen");
			System.out.println(e.getY());
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
		pipe.speed = 16;
		pipe2.speed = 16;
	}

	public void update() {
		if (isDead == false) {
			for (Coin c : CoinobjectList) {
				if (c != null) {
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
