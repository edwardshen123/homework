public class OrderedSarray extends Sarray {
    public boolean add(String item) {
	int index = 0;
	while (!get(index).equals(null) && item.compareTo(get(index)) < 0) {
	    index++;
	}
	if (index + 1 == size()) {
	    return super.add(item);
	} else {
	    return super.add(index + 1, item);
	}
    }

    public static void main(String[] args) {
	OrderedSarray list = new OrderedSarray();
	try {
	System.out.println(list.add("hi"));
	System.out.println(true);
	System.out.println(list.add("there"));
	System.out.println(true);
	System.out.println(list.add("world"));
	System.out.println(true);
	System.out.println(list.size());
	System.out.println(true);
	System.out.println(list.get(0));
	System.out.println(true);
	System.out.println(list.get(1));
	System.out.println(true);
	System.out.println(list.get(2));
	System.out.println(true);
	} catch (Exception e) {
	    System.out.println(e);
	}
    }
}
