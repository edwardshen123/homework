public class Sarray {

    private Object[] data;
    private int location;

    public Sarray() {
	data = new Object[10];
	location = 0;
    }

    public void addToEnd(int item) {
	if (isArrayOverflow()) {
	    arrayGrowth();
	}
	set(location, item);
    }
    public void addAtLoc(int index, int item) {
    }
    public int get(int index) {
	if (isArrayOverflow(index)) {
	    //returns error
	} else {
	    return data[index];
	}
    }
    public void set(int index, int item) {
	if (isArrayOverflow(index)) {
	    //returns error
	} else {
	    data[index] = item;
	    locationShift(index)
	}
    }
    public int size() {
	return data.length;
    }
    public void remove(int index) {
    }
    public void locationShift(int index) {
	if (index > location) {
	    location = index + 1;
	} else {
	    location++;
	}
    }
    public boolean isArrayOverflow() {
	return (location >= data.length);
    }
    public boolean isArrayOverflow(int index) {
	return (index >= data.length);
    }
    public void arrayGrowth() {
	Object[] temp = new Object[data.length + 1];
	copy(temp);
	data = temp;
    }
    public void copy(Object[] newArray) {
	for (int c = 0; c < data.length; c++) {
	    newArray[c] = data[c];
	}
    }
    public void copy(Object[] newArray, int indexException) {
    }
}
