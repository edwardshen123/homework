import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener /*KeyListener*/ {
    //Action, Key, Mouse and Timer Events | Mouse Motion Listener
    private Container pane;
    private JButton b1, b2, labeler;
    private JLabel l;
    private JTextArea text;
    private JPanel canvas;
    private JCheckBox box;
    private int x = 10;
    private int y = 10;

    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.red);
	    g.fillOval(x, y, 30, 30);
	}
	
    } 
    //A class within a class (inner class)
    private class Key implements KeyListener {
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
	    //System.out.println(e);
	    
	}
    }
    public Gui() {
	setTitle("My First Gui");
	setSize(600, 400);
	setLocation(100, 100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	//sets layout for the entire window pane
	//pane.setLayout(new GridLayout(3, 3));
	pane.setLayout(new FlowLayout());
	l = new JLabel("Label");
	pane.add(l);
	b1 = new JButton("button");
	b1.addActionListener(this);
	pane.add(b1);
	text = new JTextArea();
	text.setColumns(10);
	text.setBorder(BorderFactory.createLineBorder(Color.red, 2));
	pane.add(text);
	b2 = new JButton("Buton");
	b2.addActionListener(this);
	pane.add(b2);
	labeler = new JButton("Labeler");
	labeler.addActionListener(this);
	pane.add(labeler);
	box = new JCheckBox();
	pane.add(box);
	JPanel f2 = new JPanel();
	pane.add(f2);
	f2.setLayout(new FlowLayout());
	//Can add stuff to canvas
	f2.add(new JButton("buto"));

	//A new canvas to draw stuff on
	//canvas = new JPanel();
	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(100, 100));
	canvas.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
	pane.add(canvas);
    }
    public void actionPerformed(ActionEvent e) {
	//System.out.println(e);
	if (e.getSource() == b1) {
	    System.out.println("You clicked me");
	    x += 5;
	    y += 5;
	    canvas.update(canvas.getGraphics());
	    System.out.println("You can also get " + text.getText());
	} else if (e.getSource() == b2) {
	    System.out.println("Shutting down");
	    System.exit(0);
	} else if (e.getSource() == labeler) {
	    //l.setText("hi");
	}
    }
    public static void main(String[] args) {
	Gui g = new Gui();
	g.setVisible(true);
    }
}
