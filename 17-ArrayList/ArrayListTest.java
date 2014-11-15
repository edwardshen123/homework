import java.util.ArrayList;
import java.util.Random;
public class ArrayListTest {
    public void removeAdj(ArrayList al) {
	for (int c = 0; c < al.size(); c++) {
	    while (c < al.size() - 1 && al.get(c) == al.get(c + 1)) {
		al.remove(c + 1);
	    }
	}
    }
    public static void main(String[] args) {
	ArrayListTest test = new ArrayListTest();
	ArrayList<Integer> al = new ArrayList<Integer>();
	System.out.println(al.size());
	Random rand = new Random();
	for (int c = 0; c < 20; c++) {
	    al.add(rand.nextInt(10));
	}
	System.out.println(al);
	test.removeAdj(al);
	System.out.println(al);
    }
}
