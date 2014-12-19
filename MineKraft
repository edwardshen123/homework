import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mineGui extends JFrame {
    
    private Container window;
    private JPanel canvas;
    private JButton gameStart;
    private JCheckBox config;
    private JLabel title;

    private class Action implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    System.out.println(event);
	}
    }
    
    private class Key implements KeyListener {
	public void keyPressed(KeyEvent event) {
	    switch (event.getSource()):
		case
	}
	public void keyReleased(KeyEvent event) {
	}
	public void keyTyped(KeyEvent event) {
	}
    }

    public mineGui() {
	//basic setup
	setTitle("MineKraft");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	setSize(screenSize.width/2, screenSize.height/2);
	setLocation(screenSize.width/4, screenSize.height/4);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	//drawing
	window = getContentPane();
	window.setLayout(new GridLayout(2, 1));
	title = new JLabel("MineKraft");
	window.add(title);
	gameStart = new JButton("Start New Game");
	gameStart.addActionListener(new Action());
	window.add(gameStart);
    }

    //Test Run
    
    public static void main(String[] args) {
	mineGui mG = new mineGui();
	mG.setVisible(true);
    }
    
}
