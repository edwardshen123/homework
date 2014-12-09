import java.util.Arrays;
public class Sarray {

    private String[] data;
    private int last;

    public Sarray() {
	data = new String[10];
	last = 0;
    }

    public boolean add(String item) {
	if (isArrayOverflow()) {
	    arrayGrowth();
	}
	set(last, item);
	return true;
    }
    public boolean add(int index, String item) {
	if (isArrayOverflow(index)) {
	    return false;
	}
	if (!(get(data.length-1) == null)) {
	    arrayGrowth();
	}
	for (int location = data.length - 1; location > index; location--) {
	    data[location] = data[location - 1];
	}
	set(index, item);
	return true;
    }
    public String get(int index) {
	if (isArrayOverflow(index)) {
	    throw new ArrayIndexOutOfBoundsException();
	} else {
	    return data[index];
	}
    }
    private void set(int index, String item) {
	if (isArrayOverflow(index)) {
	    throw new ArrayIndexOutOfBoundsException();
	} else {
	    data[index] = item;
	    lastShift(index);
	}
    }
    public int size() {
	return data.length;
    }
    public String remove(int index) {
	if (isArrayOverflow(index)) {
	    throw new ArrayIndexOutOfBoundsException();
	} else {
	    String item = data[index];
	    String[] temp = new String[data.length - 1];
	    int dataCounter = 0;
	    for (int counter = 0; counter < temp.length; counter++) {
		if (counter == index) {
		    dataCounter++;
		}
		temp[counter] = data[dataCounter];
		dataCounter++;
	    }
	    data = temp;
	    last--;
	    return item;
	}
    }
    public void lastShift(int index) {
	if (index > last) {
	    last = index + 1;
	} else {
	    last++;
	}
    }
    public boolean isArrayOverflow() {
	return (last >= data.length);
    }
    public boolean isArrayOverflow(int index) {
	return (index >= data.length || index < 0);
    }
    public void arrayGrowth() {
	String[] temp = new String[data.length + 1];
	copy(temp);
	data = temp;
    }
    public void copy(String[] newArray) {
	for (int c = 0; c < data.length; c++) {
	    newArray[c] = data[c];
	}
    }
    public void shift(int n) {
	String N = data[n];
	int i;
	for (i=n; i>0 && N.compareTo(data[i-1]) < 0; i--) {
	    data[i] = data[i-1];
	}
	data[i] = N;
    }
    //Uses insertion sort
    public void iSort() {
	for (int c=0; c<data.length; c++) {
	    shift(c);
	}
    }
    //Uses selection sort
    public void sSort() {
	for (int i=0; i<data.length; i++) {
	    int minIndex=i;
	    for (int c=i+1; c<data.length; c++) {
		String minVal = data[minIndex];
		if (minVal.compareTo(data[c])>0) {
		    minIndex=c;
		}
	    }
	    String temp = data[i];
	    data[i] = data[minIndex];
	    data[minIndex] = temp;
	}
    }
    //Uses bubble sort
    public void bSort() {
	for (int i=0; i<data.length;i++) {
	    for (int i2=0; i2<data.length-1;i2++) {
		if (data[i2].compareTo(data[i2+1])>0) {
		    String temp = data[i2];
		    data[i2] = data[i2+1];
		    data[i2+1] = temp;
		}
	    }
	}
    }
    public void builtIn() {
	Arrays.sort(data);
    }
    public String toString() {
	return Arrays.toString(data);
    }
    public static void main(String[] args) {
	Sarray s = new Sarray();
	/*
	s.add("me");s.add("zen");s.add("hen");s.add("meh");s.add("hey");s.add("why");s.add("lel");s.add("try");s.add("plox");s.add("eeee");s.add("clk");
	*/
	//Selection Sort: 0.067s (n^2 + n)/2
	//Insertion Sort: 0.069s ~n^2
	//Bubble Sort: 0.068s
	//Built-In Sort: 0.061s
	/*
	s.add("ame");s.add("compare");s.add("exist");s.add("free");s.add("grep");s.add("have");s.add("jim");s.add("kimchi");s.add("lots");s.add("of");
	*/
	//Selection: 0.067s
	//Insertion: 0.063s
	//Bubble: 0.067s
	//Built-In Sort: 0.065s
	/*
        s.add("jim");s.add("compare");s.add("exist");s.add("free");s.add("grep");s.add("have");s.add("ame");s.add("kimchi");s.add("lots");s.add("of");
	*/
	//Selection: 0.064s
	//Insertion: 0.065s
	//Bubble: 0.063s
	//Built-In Sort: 0.098s
	/*
	s.add("ame");s.add("compare");s.add("exist");s.add("free");s.add("grep");s.add("jim");s.add("have");s.add("kimchi");s.add("lots");s.add("of");
	*/
	//Selection: 0.065s
	//Insertion: 0.065s
	//Bubble: 0.066s
	//Built-In Sort:
	/*
	s.add("ame");s.add("compare");s.add("lots");s.add("free");s.add("grep");s.add("kimchi");s.add("exist");s.add("have");s.add("jim");s.add("of");
	*/
	//Selection: 0.065s
	//Insertion: 0.067s
	//Bubble: 0.066s
	//Built-In Sort:
	s.builtIn();
    }
}
