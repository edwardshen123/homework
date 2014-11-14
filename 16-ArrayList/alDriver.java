import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class alDriver {

    private Random rand = new Random();
    
    public void randomize(ArrayList<Integer> n) {
	int loc = n.size()/2;
	//Time & Space Efficient (ArrayList)
	for (int c = 0; c < n.size(); c++) {
	    int next = rand.nextInt(n.size());
	    if (next == loc && n.size != 1) {
		n.add(next - 1, n.remove(loc));
	    } else {
		n.add(next, n.remove(loc));
	    }
	}
    }
    public void randomize(int[] n, char type) {
	//Time Efficient (Array)
	if (type == 't') {
	    for (int counter = 0; counter < n.length/2; counter++) {
		int locONE = rand.nextInt(n.length);
		int locTWO = rand.nextInt(n.length);
		if (locONE == locTWO) {
		    if (locONE == 0) {
			locONE++;
		    } else {
			locONE--;
		    }
		}
		int valONE = n[locONE];
		int valTWO = n[locTWO];
		n[locONE] = valTWO;
		n[locTWO] = valONE;
	    }
	}
	//Space Efficient (Array)
	if (type == 's') {
	    
	}
    }
    public static void main(String[] args) {
	alDriver controller = new alDriver();
	
	int[] arry = new int[10];
	ArrayList<Integer> arryList = new ArrayList<Integer>();
	for (int c = 0; c < arry.length; c++) {
	    arry[c] = c;
	    arryList.add(c);
	}
	controller.randomize(arryList, 't', rand);
	System.out.println(arryList);
    }
}
