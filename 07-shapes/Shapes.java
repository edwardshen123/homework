

public class Shapes {

    public String box(int r, int c){
	String s= "";
	int row = 0;
	int col;
	while (row<r){
	    col = c;
	    while (col>0){
		s = s + "*";
		col=col-1;
	    }
	    s=s+"\n";
	    row=row+1;
	}
	return s;
    }

    public String tri1(int h) {
	String output = "";
	for (int y = 0; y < h; y++) {
	    for (int x = 0; x < y + 1; x++) {
		output+="*";
	    }
	    output+="\n";
	}
	return output;
    }

    public String tri2(int h) {
	String output = "";
	for (int y = 0; y < h; y++) {
	    for (int space = 0; space < h - (y + 1); space++) {
		output+=" ";
	    }
	    for (int x = 0; x < y + 1; x++) {
		output+="*";
	    }
	    output+="\n";
	}
	return output;
    }

    public String tri3(int h) {
	String output = "";
	int sideSpaces;
	int starNum = 1;
	for (int heightCounter = 0; heightCounter < h; heightCounter++) {
	    sideSpaces = h - heightCounter - 1;
	    for (int spaceLeft = 0; spaceLeft < sideSpaces; spaceLeft++) {
		output+=" ";
	    }
	    for (int starCounter = 0; starCounter < starNum; starCounter++) {
		output+="*";
	    }
	    starNum+=2;
	    for (int spaceRight = 0; spaceRight < sideSpaces; spaceRight++) {
		output += " ";
	    }
	    output += "\n";
	}
	/*
	  int spaceLeft;
	  int spaceRight;
	  int starCounter;
	  int heightCounter = 0;
	  while (heightCounter < h) {
	    sideSpace = h - heightCounter + 1;
	    spaceLeft = 0;
	    spaceRight = 0;
	    starCounter = 0;
	    while (spaceLeft < sideSpaces) {
	      output += " ";
	      spaceLeft++;
	    }
	    while (starCounter < starNum) {
	      output += "*";
	      starCounter++;
	    }
	    starNum += 2;
	    while (spaceRight < sideSpaces) {
	      output += " ";
	      spaceRight++;
	    }
	    output += "\n";
	    heightCounter++;
	  }
	 */
	return output;
    }

    public String tri4(int h){
	String output = "";
	for (int height = h; height > 0; height--) {
	    for (int spaceLeft = 0; spaceLeft < h-height; spaceLeft++){
		output += " ";
	    }
	    for (int starNum = 0; starNum < height; starNum++) {
		output += "*";
	    }
	    output += "\n";
	}
	/*
	  int height = h;
	  int spaceLeft;
	  int starNum;
	  while (height > 0) {
	    spaceLeft = 0;
	    while (spaceLeft < h - height) {
	      output += " ";
	      spaceLeft++;
	    }
	    starNum = 0;
	    while (starNum < height) {
	      output += "*";
	      starNum++;
	    }
	    output += "\n";
	    height--;
	  }
	 */
	return output;
    }
    
    public String diamond(int h) {
	String output = "";
	output += tri3(h/2 + h%2);
	output = output.substring(0, output.length() - 1);
	int maxStarLength;
	if (h/2 == 1) {
	    maxStarLength = 1;
	}else{
	    maxStarLength = 1 + (h/2 + h%2 - 1)*2;
	}
	String reversedTri = new StringBuilder(tri3(h/2 + h%2)).reverse().toString();
	String reversedNewLine = new StringBuilder("\n").reverse().toString();
	if (h%2 != 0) {
	    reversedTri = reversedTri.substring(maxStarLength + 1);
	}
	output += reversedTri.replace(reversedNewLine, "\n");
	output += "\n";
	return output;
    }
}
