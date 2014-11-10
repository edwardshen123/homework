public class Sarray {

    private Object[] data;
    private int last;

    public Sarray() {
	data = new Object[10];
	last = 0;
    }

    public boolean add(int item) {
	if (isArrayOverflow()) {
	    arrayGrowth();
	}
	set(last, item);
	return true;
    }
    public void add(int index, int item) {
	if (isArrayOverflow(index)) {
	    throw new ArrayIndexOutOfBoundException();
	} else {
	    arrayGrowth();
	    for (int location = data.length - 1; location > index; location--) {
		data[location] = data[location - 1];
	    }
	    set(index, item);
	}
    }
    public Object get(int index) {
	if (isArrayOverflow(index)) {
	    throw new ArrayIndexOutOfBoundException();
	} else {
	    return data[index];
	}
    }
    public void String set(int index, int item) {
	if (isArrayOverflow(index)) {
	    throw new ArrayIndexOutOfBoundException();
	} else {
	    data[index] = item;
	    lastShift(index);
	}
    }
    public int size() {
	return data.length;
    }
    public Object remove(int index) {
	if (isArrayOverflow(index)) {
	    throw new ArrayIndexOutOfBoundException();
	} else {
	    Object item = data[index];
	    Object[] temp = new Object[data.length - 1];
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
	Object[] temp = new Object[data.length + 1];
	copy(temp);
	data = temp;
    }
    public void copy(Object[] newArray) {
	for (int c = 0; c < data.length; c++) {
	    newArray[c] = data[c];
	}
    }

    public static void main(String[] args) {
	Sarray list = new Sarray();
	try {
	System.out.println(list.add(1));
	System.out.println(list.add(2));
	System.out.println(list.add(3));
	System.out.println(list.add(11, 4));
	System.out.println(list.set(4, 3));
	System.out.println(list.set(2, 4));
	System.out.println(list.size());
	System.out.println(list.get(2));
	System.out.println(list.get(5));
	System.out.println(list.get(11));
	} catch (ArrayOutOfBoundException e) {
	    System.out.println(e);
	} catch (Exception e) {
	    System.out.println(e);
	}
    }
}
