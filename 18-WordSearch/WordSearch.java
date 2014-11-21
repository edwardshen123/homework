import java.lang.StringBuilder;
import java.util.Random;
/**
 * Creates a word search puzzle
 *
 */
public class WordSearch{

    private char[][] board;
    private int boardRow;
    private int boardCol;

    public WordSearch(int r, int c){
	board = new char[r][c];
	boardRow = r;
	boardCol = c;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j]='.';
	    }
	}			
    }

    public WordSearch(){
	this(20,30);
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

    public void addWordH(String w,int row, int col){
	int len = w.length();
	if (col+len<boardCol && col>=0 && row<boardRow && row>=0) {
	    int r = row, c = col;
	    boolean canAdd = false;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r][c+counter];
		if (item == '.' || item == w.charAt(counter)) {
		    canAdd = true;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++){
		    board[r][c+i] = w.charAt(i);
		}
	    }
	}
    }

    public void addWordHR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	addWordH(reverse, row, col);
    }

    public void addWordV(String w, int row, int col) {
	int len = w.length();
	if (row+len<boardRow && row>=0 && col<boardCol && col>=0) {
	    int r = row, c = col;
	    boolean canAdd = false;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r+counter][c];
		if (item == '.' || item == w.charAt(counter)) {
		    canAdd = true;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++) {
		    board[r+i][c] = w.charAt(i);
		}
	    }
	}
    }

    public void addWordVR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	addWordV(reverse, row, col);
    }

    public void addWordDRD(String w, int row, int col) {
        int len = w.length();
	if (row+len<boardRow && row>=0 && col+len<boardCol && col>=0) {
	    int r = row, c = col;
	    boolean canAdd = false;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r+counter][c+counter];
		if (item == '.' || item == w.charAt(counter)) {
		    canAdd = true;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++) {
		    board[r+i][c+i] = w.charAt(i);
		}
	    }
	}
    }

    public void addWordDRR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	addWordDRD(reverse, row, col);
    }

    public void addWordDLD(String w, int row, int col) {
	int len = w.length();
	if (row+len<boardRow && row>=0 && col-len<boardCol && col>=0) {
	    int r = row, c = col;
	    boolean canAdd = false;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r+counter][c-counter];
		if (item == '.' || item == w.charAt(counter)) {
		    canAdd = true;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++) {
		    board[r+i][c-i] = w.charAt(i);
		}
	    }
	}
    }

    public void addWordDLR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	addWordDLD(reverse, row, col);
    }

    public void addWord() {
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("words.txt"));
	} catch (Exception e) {
	    System.out.println("Can't open file");
	    System.exit(0);
	}
	while (sc.hasNext()) {
	    Random randInt = new Random();
	    int caseNum = randInt.nextInt(7);
	    String word = sc.next();
	    int wordLen = word.length();
	    switch (caseNum) {
	    case 0:
		addWordH(word, randInt.nextInt(boardRow), randInt.nextInt(boardCol-wordLen));
		break;
	    case 1:
		addWordHR(word, randInt.nextInt(boardRow), randInt.nextInt(boardCol-wordLen));
		break;
	    case 2:
		addWordV(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol));
		break;
	    case 3:
		addWordVR(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol));
		break;
	    case 4:
		addWordDRD(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen));
		break;
	    case 5:
		addWordDLD(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen) + wordLen);
		break;
	    case 6:
		addWordDRR(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen));
		break;
	    case 7:
		addWordDLR(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen) + wordLen);
		break;
	    default:
	    }
	}
    }
}
