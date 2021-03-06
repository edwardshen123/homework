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
    public void set(int index, String item) {
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
	String N = a[n];
	for (int i=n; i>0 && N.compareTo(a[i-1]) < 0; i--) {
	    a[i] = a[i-1];
	}
	a[i] = N;
    }
    //Uses insertion sort
    public void iSort() {
	for (int c=0; c<data.length; c++) {
	    shift(c);
	}
    }
}
