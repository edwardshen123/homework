import java.util.Random;

public class Arraystuff {
    
    private int[] a;
    private Random rnd;

    //Final = can't change value
    public final int final_example = 123;

    public Arraystuff() {
	this(100);
    }
    public Arraystuff(int n) {
	rnd = new Random();
	a = new int[n];
	for (int c = 0; c < n; c++) {
	    a[c] = 75 + rnd.nextInt(c + 1);
	}
    }
    public String toString() {
	String s = "";
	for (int c = 0; c < a.length; c++) {
	    s += a[c] + ", ";
	}
	return s;
    }
    public int find(int value) {
	int index = -1;
	for (int c = 0; c < a.length; c++) {
	    if (a[c] == value) {
		index = c;
		break;
	    }
	}
	return index;
    }
    public int maxVal() {
	int max = -1;
	for (int c = 0; c < a.length; c++) {
	    if (a[c] > max) {
		max = a[c];
	    }
	}
	return max;
    }

    public static void main(String[] args) {
	Arraystuff s = new Arraystuff();
	System.out.println(s);
	System.out.println(s.maxVal());
	System.out.println(s.find(100));
    }
}
