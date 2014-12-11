public class Searching {

    private static Comparable[] a;
    private int last;
    
    public Searching(int numElements) {
	a = new Comparable[numElements];
	last = 0;
    }
    
    public void addItem(Comparable b) {
	a[last] = b;
	last++;
    }

    public static Comparable iSearch(Comparable item) {
	for (int counter=0; counter<a.length; counter++) {
	    if (a[counter].compareTo(item) == 0) {
		return item;
	    }
	}
	return null;
    }
    //Can pass an array of objects that implements comparable
    public static Comparable bSearch(Comparable item) {
	int low = 0;
	int high = a.length;
	int mid = (low + high)/2;
	while (a[mid].compareTo(item)!=0 && high!=low) {
	    if (item.compareTo(a[mid])>0) {
		low = mid + 1;
	    } else {
		high = mid;
	    }
	    mid = (low + high)/2;
	}
	if (a[mid].compareTo(item) == 0) {
	    return item;
	} else {
	    return null;
	}
    }
    public static Comparable rbSearch(Comparable item) {
	int low = 0;
	int high = a.length;
	return rbSearch(item, low, high);
    }
    public static Comparable rbSearch(Comparable item, int low, int high) {
	int mid = (low + high)/2;
	if (low == high) {
	    return null;
	}
	if (item.compareTo(a[mid]) > 0) {
	    low = mid + 1;
	    rbSearch(item, low, high);
	} else if (item.compareTo(a[mid]) < 0) {
	    high = mid;
	    rbSearch(item, low, high);
	} else {
	    return item;
	}
    }

    public static void main(String[] args) {
    }
}
