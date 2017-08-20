import javax.swing.JFrame;

public class mainGame {
	final static int fwidth = 1000;
	final static int fheight = 900;
	JFrame base;
	GamePanel pan;

	public static void main(String[] args) {
		mainGame object = new mainGame();
		object.setupGame();

	}

	void setupGame() {
		
		base = new JFrame();
		pan = new GamePanel();
		base.add(pan);
		base.setSize(fwidth, fheight);
		base.setVisible(true);
		base.setDefaultCloseOperation(2);
		base.addMouseListener(pan);
		pan.startGame();
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
  
