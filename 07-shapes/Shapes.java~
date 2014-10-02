

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
}
