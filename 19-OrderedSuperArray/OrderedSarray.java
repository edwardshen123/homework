public class OrderedSarray extends Sarray {
    public boolean add(String item) {
	int index = 0;
	while (!(get(index) == null) && item.compareTo(get(index)) > 0) {
	    index++;
	}
	System.out.println(index);
	return super.add(index, item);
    }
    public boolean add(int index, String item) {
	return add(item);
    }
    /*
      Code breaks add method: throws ArrayIndexOutOfBoundsException
      The super.add(index, item) calls upon the set method not in superclass but subclass
    */
    /*
    public void set(int index, String item) {
	remove(index);
	add(item);
    }
    */

    public static void main(String[] args) {
	OrderedSarray list = new OrderedSarray();
	try {
	    System.out.println(list.add("hi"));
	    System.out.println(list.add("there"));
	    System.out.println(list.add("world"));
	    System.out.println(list.size());
	    System.out.println(list.get(2));
	} catch (Exception e) {
	    System.out.println(e);
	}
    }
}
