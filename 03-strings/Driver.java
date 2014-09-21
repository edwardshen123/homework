public class Driver {
    public static void main(String[] args) {
	String fullName="mike zamansky";
	int locationSpace = fullName.indexOf(" ");
	String firstName=fullName.substring(0, locationSpace);
	int nameLength = fullName.length();
	String lastName = fullName.substring(locationSpace + 1, nameLength);
    }
}
