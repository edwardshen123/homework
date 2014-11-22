import java.io.PrintWriter;
import java.io.File;

public class Run {
    public static void main(String[] args) {
	WordSearch ws = new WordSearch();
	PrintWriter solution = null;
	PrintWriter puzzle = null;
	File s = null;
	File p = null;
	try {
	    s = new File("solution.txt");
	    p = new File("puzzle.txt");
	    System.out.println("1");
	    solution = new PrintWriter(s);
	    System.out.println("2");
	    puzzle = new PrintWriter(p);
	    System.out.println("3");
	} catch (Exception e) {
	    System.out.println("Cannot write to files");
	    System.exit(0);
	}
	ws.addWord();
	solution.write(ws.toString());
	System.out.println("Solution written");
	ws.addFiller();
	puzzle.write(ws.toString());
	System.out.println("Puzzle written");
	solution.close();
	puzzle.close();
    }
}
