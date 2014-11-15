import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class alDriver {

    private Random rand = new Random();
    
    public void randomize(ArrayList<Integer> n) {
	//Time & Space Efficient (ArrayList)
	int size = n.size() - 1;
	for (int c = 0; c < n.size(); c++) {
	    n.add(n.remove(rand.nextInt(size)));
	}
    }
    public void randomize(int[] n, char type) {
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
	
	int[] arry = new int[Integer.parseInt(args[0])];
	ArrayList<Integer> arryList = new ArrayList<Integer>();
	for (int c = 0; c < arry.length; c++) {
	    arry[c] = c;
	    arryList.add(c);
	}
	controller.randomize(arryList);
	//System.out.println(arryList);
    }
}
