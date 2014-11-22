import java.lang.StringBuilder;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
/**
 * Creates a word search puzzle
 *
 */
public class WordSearch{

    private char[][] board;
    private int boardRow;
    private int boardCol;
    private Random randInt = new Random();

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

    public boolean addWordH(String w,int row, int col){
	int len = w.length();
	if (col+len<boardCol && col>=0 && row<boardRow && row>=0) {
	    int r = row, c = col;
	    boolean canAdd = true;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r][c+counter];
		if (item != '.' && item != w.charAt(counter)) {
		    canAdd = false;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++){
		    board[r][c+i] = w.charAt(i);
		}
	    }
	    return canAdd;
	} else {
	    return false;
	}
    }

    public boolean addWordHR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	return (addWordH(reverse, row, col));
    }

    public boolean addWordV(String w, int row, int col) {
	int len = w.length();
	if (row+len<boardRow && row>=0 && col<boardCol && col>=0) {
	    int r = row, c = col;
	    boolean canAdd = true;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r+counter][c];
		if (item != '.' && item != w.charAt(counter)) {
		    canAdd = false;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++) {
		    board[r+i][c] = w.charAt(i);
		}
	    }
	    return canAdd;
	} else {
	    return false;
	}
    }

    public boolean addWordVR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	return (addWordV(reverse, row, col));
    }

    public boolean addWordDRD(String w, int row, int col) {
        int len = w.length();
	if (row+len<boardRow && row>=0 && col+len<boardCol && col>=0) {
	    int r = row, c = col;
	    boolean canAdd = true;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r+counter][c+counter];
		if (item != '.' && item != w.charAt(counter)) {
		    canAdd = false;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++) {
		    board[r+i][c+i] = w.charAt(i);
		}
	    }
	    return canAdd;
	} else {
	    return false;
	}
    }

    public boolean addWordDRR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	return (addWordDRD(reverse, row, col));
    }

    public boolean addWordDLD(String w, int row, int col) {
	int len = w.length();
	if (row+len<boardRow && row>=0 && col-len<boardCol && col>=0) {
	    int r = row, c = col;
	    boolean canAdd = true;
	    for (int counter=0; counter<len; counter++) {
		char item = board[r+counter][c-counter];
		if (item != '.' && item != w.charAt(counter)) {
		    canAdd = false;
		    break;
		}
	    }
	    if (canAdd) {
		for (int i=0;i<len;i++) {
		    board[r+i][c-i] = w.charAt(i);
		}
	    }
	    return canAdd;
	} else {
	    return false;
	}
    }

    public boolean addWordDLR(String w, int row, int col) {
	String reverse = new StringBuilder(w).reverse().toString();
	return (addWordDLD(reverse, row, col));
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
	    int caseNum = randInt.nextInt(7);
	    String word = sc.next();
	    int wordLen = word.length();
	    boolean added = false;
	    switch (caseNum) {
	    case 0:
		while (!added) {
		    added = addWordH(word, randInt.nextInt(boardRow), randInt.nextInt(boardCol-wordLen));
		}
		break;
	    case 1:
		while (!added) {
		    added = addWordHR(word, randInt.nextInt(boardRow), randInt.nextInt(boardCol-wordLen));
		}
		break;
	    case 2:
		while (!added) {
		    added = addWordV(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol));
		}
		break;
	    case 3:
		while (!added) {
		    added = addWordVR(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol));
		}
		break;
	    case 4:
		while (!added) {
		    added = addWordDRD(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen));
		}
		break;
	    case 5:
		while (!added) {
		    added = addWordDLD(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen) + wordLen);
		}
		break;
	    case 6:
		while (!added) {
		    added = addWordDRR(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen));
		}
		break;
	    case 7:
		while (!added) {
		    added = addWordDLR(word, randInt.nextInt(boardRow-wordLen), randInt.nextInt(boardCol-wordLen) + wordLen);
		}
		break;
	    default:
	    }
	}
    }
	
    public void addFiller() {
	for (int r=0;r<boardRow;r++) {
	    for (int c=0;c<boardCol;c++) {
		if (board[r][c] == '.') {
		    String alphabet = "abcdefghijklmnopqrstuvwxyz";
		    char filler = alphabet.charAt(randInt.nextInt(26));
		    board[r][c] = filler;
		}
	    }
	}
    }
}
