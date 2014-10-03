
public class Driver {
    public static void  main(String[] args){
	Shapes s =  new Shapes();
	System.out.println(s.box(5,4));
	System.out.println(s.box(4,5));
	System.out.println(s.tri1(4));
	System.out.println(s.tri2(4));
	System.out.println(s.tri3(4));
	System.out.println(s.tri4(4));
	System.out.println(s.diamond(5));
	System.out.println(s.diamond(4));
	System.out.println(s.frame(5,4));
    }
}
