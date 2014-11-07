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
    public int find(int value, int[] array) {
	int index = -1;
	for (int c = 0; c < array.length; c++) {
	    if (array[c] == value) {
		index = c;
		break;
	    }
	}
	return index;
    }
    public int maxVal(int[] array) {
	int max = -1;
	for (int c = 0; c < array.length; c++) {
	    if (array[c] > max) {
		max = array[c];
	    }
	}
	return max;
    }
    public int freq(int i, int[] a) {
	int ref = a[i];
	int result = 0;
	for (int c = 0; c < a.length; c++) {
	    if (a[i] == a[c]) {
		result++;
	    }
	}
	return result;
    }
    public int mode(int[] A) {
	int[] freq = new int[A.length];
	for (int i = 0; i < A.length; i++) {
	    freq[i] = freq(i, A);
	}
	int modePos = 0;
	int temp = 0;
	for (int c = 0; c < freq.length; c++) {
	    if (freq[c] > temp) {
		temp = freq[c];
		modePos = c;
	    }
	}
	return A[modePos];
    }
    public int improvMode(int[] A) {
	int[] bucket = new int[maxVal(A) + 1];
	for (int c = 0; c < A.length; c++) {
	    bucket[A[c]]++;
	}
	return A[find(maxVal(bucket), bucket)];
    }

    public static void main(String[] args) {
	Arraystuff s = new Arraystuff();
	Random randInt = new Random();
	int[] ran = new int[100];
	for (int i = 0; i < 100; i++) {
	    ran[i] = randInt.nextInt(20);
	}
	System.out.println(s.improvMode(ran));
    }
}
