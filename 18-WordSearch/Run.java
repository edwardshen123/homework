import java.io.Scanner;

public class Run {
    public static void main(String[] args) {
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("puzzle.txt"));
	} catch (Exception e) {
	    System.out.println("Can't open file");
	    System.exit(0);
	}
	//reading the file and printing out content
	while (sc.hasNext()) {
	    //.next() gets the word (it reads to the next space)
	    String s = sc.next();
	    System.out.println("Word: " + s);
	}
    }
}
