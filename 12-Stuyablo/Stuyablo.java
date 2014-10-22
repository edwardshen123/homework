import java.util.Scanner;
import java.util.Arrays;

public class Stuyablo {
    public static void main(String[] args) {
	Scanner user_input = new Scanner(System.in);
	System.out.print("Enter a name: ");
	String name = user_input.next();
	Warrior w1 = new Warrior(name);
	Mob xeno = new Mob();
	while (true) {
	    System.out.println("Moves: ");
	    System.out.println("attack || slash || longSlash");
	    System.out.print("Enter a move: ");
	    String input = user_input.next();
	    String[] inputChecker = {"attack", "slash", "longSlash"};
	    while (!Arrays.asList(inputChecker).contains(input)) {
		System.out.print("This is an invalid move. Enter another move: ");
		input = user_input.next();
	    }
	    System.out.println();
	    if (input.equals("attack")) {
		System.out.println(w1.attack(xeno));
		System.out.println("Xeno health: " + xeno.getHealth());
	    } else if (input.equals("slash")) {
		System.out.println(w1.slash(xeno));
		System.out.println("Xeno health: " + xeno.getHealth());
	    } else if (input.equals("longSlash")) {
		System.out.println(w1.longSlash(xeno));
		System.out.println("Xeno health: " + xeno.getHealth());
	    } else {
	    }
	    System.out.println();
	    if (xeno.getHealth() <= 0) {
		System.out.println("You Win!");
		break;
	    }
	    System.out.println(xeno.attack(w1));
	    System.out.println("Your health: " + w1.getHealth());
	    System.out.println();
	    if (w1.getHealth() <= 0) {
		System.out.println("You Lose :(");
		break;
	    }
	}
    
    }
}
