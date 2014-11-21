import java.lang.StringBuilder;
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

    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	w.addWordH("hello",3,5);
	w.addWordH("look",3,8);
	w.addWordH("look",3,5);
	w.addWordH("look",2,5);
	w.addWordH("hello",100,5);
	w.addWordH("hello",30,555);
	w.addWordV("hi",2,4);
				
	System.out.println(w);
    }
}
