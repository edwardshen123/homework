public class OrderedSarray extends Sarray {
    public boolean add(String item) {
	int index = 0;
	while (!(get(index) == null) && item.compareTo(get(index)) > 0) {
	    index++;
	}
	return super.add(index, item);
    }
    public boolean add(int index, String item) {
	return add(item);
    }
    public void set(int index, String item) {
	remove(index);
	add(item);
    }

    public static void main(String[] args) {
	OrderedSarray list = new OrderedSarray();
	try {
	System.out.println(list.add("hi"));
	System.out.println(list.add("there"));
	System.out.println(list.add("world"));
	System.out.println(list.size());
	System.out.println(list.get(3));
	} catch (Exception e) {
	    System.out.println(e);
	}
    }
}
