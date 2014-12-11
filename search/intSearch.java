public class intSearch {
    //Can pass an array of objects that implements comparable
    public static void bSearch(Comparable[] c, Comparable object) {
	int low = 0;
	int high = c.length;
	int mid = (low + high)/2;
	while (c[mid] != object && high-low != 1) {
	    if (object.compareTo(c[mid])>0) {
		low = mid + 1;
	    } else {
		high = mid;
	    }
	}
    }
}
