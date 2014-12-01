public class Sarray {

    private String[] data;
    private int last;

    public Sarray() {
	data = new String[10];
	last = 0;
    }

    public boolean add(String item) {
	if (isArrayOverflow()) {
	    arrayGrowth(1);
	}
	set(last, item);
	return true;
    }
    public boolean add(int index, String item) {
	if (isArrayOverflow(index)) {
	    return false;
	} else if (!(data[data.length - 1] == null)) {
	    arrayGrowth(1);
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
    public void arrayGrowth(int inc) {
	String[] temp = new String[data.length + inc];
	copy(temp);
	data = temp;
    }
    public void copy(String[] newArray) {
	for (int c = 0; c < data.length; c++) {
	    newArray[c] = data[c];
	}
    }
}
