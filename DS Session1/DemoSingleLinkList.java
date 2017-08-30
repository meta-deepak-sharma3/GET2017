package assignment1;

import java.util.Scanner;

public class DemoSingleLinkList {
	public static void main(String ar[]) {
		SingleLinkedList<Integer> ll = new SingleLinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(20);
		al.add(21);
		al.add(0, 22);
		System.out.println(al.size());
		al.add(23);
		al.add(3,26);
		System.out.println(al.size());
		al.remove(1);
		int j =al.removeByValue(23);
		System.out.println(al.size()+"  "+j);
		al.printArrayList();
		Scanner scan = new Scanner(System.in);
		/* Creating object of class nextedList */
		char ch;
		/* Perform list operations */
		do {
			System.out.println("\nSingly nexted List Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. insert at position");
			System.out.println("3. delete by value");
			System.out.println("4. delete by position");
			System.out.println("5. retrieve by index");
			System.out.println("6. Reverse");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				ll.add(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to insert");
				int number = scan.nextInt();
				System.out.println("Enter position");
				int position = scan.nextInt();
				ll.add(position-1, number);
				break;
			case 3:
				System.out.println("Enter Value");
				int p = scan.nextInt();
				ll.removeByValue(p);
				break;
			case 4:
				System.out.println("Enter position");
				int index = scan.nextInt();
				ll.remove(index);
				break;
			case 5:
				System.out.println("Enter position");
				int index1 = scan.nextInt();
				System.out.println(ll.getElement(index1));
				break;
			case 6:
				ll.reverse();
				break;

			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		ll.printLinkedList();
		scan.close();

	}
}
