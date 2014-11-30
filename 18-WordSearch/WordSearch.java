//Add code for must overlap
import java.util.Random;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
/**
 * Creates a word search puzzle
 *
 */
public class WordSearch{

    private char[][] board;
    private Random r = new Random();
    private ArrayList<String> key = new ArrayList<String>();
    private ArrayList<String> wordList = new ArrayList<String>();
    private int boardCol;
    private int boardRow;
    
    public WordSearch(int r, int c){
	board = new char[r][c];
	boardRow = r;
	boardCol = c;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j]='.';
	    }
	}
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("words.txt"));
	} catch (Exception e) {
	    System.out.println("Cannot open words file");
	    System.exit(0);
	}
	while (sc.hasNext()) {
	    String word = sc.next();
	    if (word.length() > 1) {
		wordList.add(word);
	    }
	}
    }
    public WordSearch(){
	this(30,30);
    }

    public String toString(){
	String s = "";

	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		s = s + board[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }
		
    public boolean addWordHelper(String w,int row, int col,int deltaRow, int deltaCol){
	int r = row, c = col;
				
	for (int i=0;i<w.length();i++){
	    try {
		if (board[r][c]!='.' && board[r][c]!=w.charAt(i)){
		    return false;
		}
	    } catch ( Exception e){
		return false;
	    }
	    r = r + deltaRow;
	    c = c + deltaCol;
	}

	r = row;
	c = col;

	for (int i=0;i<w.length();i++){
	    board[r][c] = w.charAt(i);
	    r = r + deltaRow;
	    c=c+deltaCol;
	}
	return true;
    }

    
    public boolean addWord(String w) {
	int row = r.nextInt(board.length);
	int col = r.nextInt(board[0].length);
	int deltaRow = -1 + r.nextInt(3);
	int deltaCol = -1 + r.nextInt(3);
	if (deltaRow == deltaCol && deltaCol == 0)
	    return false;
	return addWordHelper(w,row,col,deltaRow,deltaCol);
    }

    public void addFiller() {
	for (int row=0;row<boardRow;row++) {
	    for (int col=0;col<boardCol;col++) {
		if (board[row][col] == '.') {
		    String alphabet = "abcdefghijklmnopqrstuvwxyz";
		    char filler = alphabet.charAt(r.nextInt(26));
		    board[row][col] = filler;
		}
	    }
	}
    }

    public void constructSolution() {
	PrintWriter pw = null;
	try {
	    pw = new PrintWriter(new File("solution.txt"));
	} catch (Exception e) {
	    System.out.println("Can't open file");
	    System.exit(0);
	}
	int size = wordList.size();
	int c = 0;
	while (c < 20) {
	    String word = wordList.get(r.nextInt(size));
	    if (addWord(word)) {
		key.add(word);
		c++;
	    }
	}
	pw.write(toString());
	pw.close();
    }
    
    public void constructPuzzle() {
	PrintWriter pw = null;
	try {
	    pw = new PrintWriter(new File("puzzle.txt"));
	} catch (Exception e) {
	    System.out.println("Cannot write to file");
	    System.exit(0);
	}
	addFiller();
	String write = toString();
	for (int i = 0; i < key.size() + 1; i++) {
	    if (i == 0) {
		write+="Word Bank:\n";
	    } else {
		write+=key.get(i-1) + "  ";
		if (i%5==0) {
		    write+="\n";
		}
	    }
	}
	pw.write(write);
	pw.close();
    }

    public static void main(String[] args) {
	WordSearch w = new WordSearch(20,20);
	w.constructSolution();
	w.constructPuzzle();
    }
}
