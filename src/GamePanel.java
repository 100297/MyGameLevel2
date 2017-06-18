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
	ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	public GamePanel() {
		time = new Timer(1000 / 60, this);
		play = new Bat();
		objectList.add(play);
	}

	void startGame() {
		time.start();
		objectList.add(Pipe());
	}

	void drawGamePanel() {

	}

	void updateGamePanel() {

	}

	public void paintComponent(Graphics g) {
	//	play.draw(g);
for(int i=0; i< objectList.size(); i++){
	GameObject o = objectList.get(i);
	o.draw(g);

}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();

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
}
