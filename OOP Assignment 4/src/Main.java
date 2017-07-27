import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompositeMenu menu = new CompositeMenu();
		Scanner sc = new Scanner(System.in);
		menu.setMenuName("Main");
		menu.setParent(""); // Setting there is no parent for main menu
		menu.generateList(sc); // generating list for main menu
		menu.actionPerformed(sc); // perform print and action accordingly
		sc.close();
	}

}
