import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class alDriver {

    private Random rand = new Random();
    
    //Takes Longer than array
    public void randomize(ArrayList<Integer> n) {
	//Time & Space Efficient (ArrayList)
	int size = n.size() - 1;
	int temp;
	int loc;
	for (int c = 0; c < n.size(); c++) {
	    loc = rand.nextInt(size);
	    temp = n.get(loc);
	    n.set(loc, n.get(c));
	    n.set(c, temp);
	}
    }

    //Faster than arrayList
    public void randomize(int[] n) {
	//Time & Space Efficient (Array)
	int temp;
	int loc;
	int last = n.length - 1;
	for (int c = 0; c < n.length; c++) {
	    loc = rand.nextInt(n.length - 1);
	    temp = n[loc];
	    n[loc] = n[last];
	    n[last] = temp;
	}
    }

    public static void main(String[] args) {
	alDriver controller = new alDriver();
	
	//int[] arry = new int[Integer.parseInt(args[0])];
	ArrayList<Integer> arryList = new ArrayList<Integer>();
	for (int c = 0; c < Integer.parseInt(args[0]); c++) {
	    //arry[c] = c;
	    arryList.add(c);
	}
	controller.randomize(arryList);
	//System.out.println(arryList);
	//controller.randomize(arry);
	//System.out.println(Arrays.toString(arry));
    }
}
