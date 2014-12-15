import java.util.Random;
import java.util.Arrays;

public class Interval implements Comparable {

    //Interface: a specification that lists method much like abstract class & methods
    /*
      public interface Name {
        method signature is placed here:
        pub/priv return-type methodName(para);
      }
     */

    /* Built-in Comparable interface
    interface Comparable{
	public int compareTo(object other);
    }
    */
    // A class that implements an interface must define all the methods in the interface. You can only extend 1 class but can implement multiple interfaces
    
    //Static does not belong to an instance but the class (Math.sqrt: sqrt is a static method of the math class, thus no need for a new instance of Math)
    //Static variables is shared among the instances of the class, thus incrementing the variable in one instance will have it increment in all instances
    
    private int low,high;
    private Random rand;

    public Interval(int l, int h) {
	low = l;
	high = h;
    }

    public Interval() {
	rand = new Random();
	int l = rand.nextInt(100);
	int h = l + 1 + rand.nextInt(100);
	low = l;
	high = h;
    }
    public int getLow() {
	return low;
    }
    public int getHigh() {
	return high;
    }
    //add compareTo method
    public int compareTo(Object other) {
	//cast other to the appropriate type and store in a local variable for convenience
	Interval ot = (Interval)other;
	if (low == ot.getLow()) {
	    return high - ot.getHigh();
	} else {
	    return low - ot.getLow();
	}
    }
    public String toString() {
	return "[" + low + "," + high + "]";
    }

    public static void main(String[] args) {
	Interval[] interArry = new Interval[10];
	for (int i=0; i<interArry.length; i++) {
	    interArry[i] = new Interval();
	}
	System.out.println(interArry[1].compareTo(interArry[2]));
	System.out.println(Arrays.toString(interArry));
    }
}
