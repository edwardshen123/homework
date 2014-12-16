import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame implements ActionListener{

    private Container pane;
    private JButton b1, b2;
    private JLabel l;
    private JTextArea text;
    private JPanel canvas;

    public Gui() {
	setTitle("My First Gui");
	setSize(600, 400);
	setLocation(100, 100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	//sets layout for the entire window pane
	pane.setLayout(new GridLayout(3, 3));
	l = new JLabel("Label");
	pane.add(l);
	b1 = new JButton("button");
	pane.add(b1);
	text = new JTextArea();
	text.setColumns(10);
	text.setBorder(BorderFactory.createLineBorder(Color.red, 2));
	pane.add(text);
	b2 = new JButton("Buton");
	pane.add(b2);
	JPanel f2 = new JPanel();
	pane.add(f2);
	f2.setLayout(new FlowLayout());
	//Can add stuff to canvas
	f2.add(new JButton("buto"));

	//A new canvas to draw stuff on
	canvas = new JPanel();
	canvas.setPreferredSize(new Dimension(100, 100));
	canvas.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
	pane.add(canvas);
    }
    public void ActionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
	Gui g = new Gui();
	g.setVisible(true);
    }
}
