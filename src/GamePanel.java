import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	Bat play;
	Timer time;
	Pipe pipe;
	Pipe pipe2;
	Pipe pipe3;
	Pipe pipe4;
	Respawn Respawn;
	public Boolean isDead;
	Boolean Pipe2Spawned;
	ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	

	public GamePanel() {
		time = new Timer(1000 / 60, this);
		play = new Bat();
		pipe = new Pipe();
		pipe2 = new Pipe();
		objectList.add(play);
		objectList.add(pipe);
		
		
		
	}

	void startGame() {
		time.start();
		isDead = false;
		Pipe2Spawned = false;
	}

	void drawGamePanel() {

	}

	void updateGamePanel() {

	}

	public void paintComponent(Graphics g) {
		// play.draw(g);
		
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		update();
		repaint();
		
		if (play.collisionBox.intersects(pipe.collisionBox) || play.collisionBox.intersects(pipe2.collisionBox)) {
			isDead = true;

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
		if(e.getSource() == Respawn ) {
			isDead = false;
			play.score = 0;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
public void update() {
	if (isDead == false) {
		for (int i = 0; i < objectList.size(); i++) {
			GameObject o = objectList.get(i);
			o.update();
		}

	} 

	if (pipe.x <= 500 && Pipe2Spawned == false) {
		objectList.add(new Pipe());
		Pipe2Spawned = true;
	}
}
}

