import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class alDriver {

    public void randomize(ArrayList<Integer> n, char type, Random r) {
	//Time Efficient (ArrayList)
	if (type == 't') {
	    for (int c = 0; c < n.size(); c++) {
		n.add(r.nextInt(n.size() - c), n.remove(n.size()/2));
	    }
	}
	//Space Efficient (ArrayList)
	if (type == 's') {
	    for (int c = 0; c < n.size(); c++) {
		n.add(r.nextInt(n.size() - c), n.remove(n.size()/2));
	    }
	}
    }
    public void randomize(int[] n, char type) {
	//Time Efficient (Array)
	//Space Efficient (ArrayList)
    }
    public static void main(String[] args) {
	Random rand = new Random();
	alDriver controller = new alDriver();
	
	int[] arry = new int[1000000];
	ArrayList<Integer> arryList = new ArrayList<Integer>();
	for (int c = 0; c < arry.length; c++) {
	    arry[c] = c;
	    arryList.add(c);
	}
	controller.randomize(arryList, 't', rand);
	System.out.println(arryList);
    }
}
