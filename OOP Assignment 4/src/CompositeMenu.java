/**
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 */
public class CompositeMenu extends Menu {
	private String parent;
	private List<Menu> menulist = new ArrayList<Menu>();
	private String menuName;
	
	/*
	 * This function used to display the menu list and ask for the choice 
	 */
	@Override
	public void actionPerformed(Scanner sc) {
		System.out.println(parent);
		System.out.println("");
		int i = 1;
		for (Menu menu : menulist) {
			System.out.println(i + " : " + menu.getMenuName());
			i++;
		}
		
		System.out.println("Enter your Choice");
		int choice = sc.nextInt();
		sc.nextLine();
		menulist.get(choice-1).actionPerformed(sc);
	}

	/**
	 * This function used to generate the menulist and sub menu list.
	 * @param sc is scanner type object for getting input
	 */
	public void generateList(Scanner sc) {
		int no_items = 0;
		try {
			System.out.println("Enter The no of items for "+getMenuName()+" menu");
			no_items = sc.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.nextLine();
		}
		for (int i = 0; i < no_items; i++) {
			System.out.println("Enter item for "+ getMenuName() + " menu");
			String name = sc.nextLine();
			System.out.println("It is a Composite Menu ?(Y/N)");
			String ans = sc.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				CompositeMenu menu = new CompositeMenu();
				menu.setMenuName(name);
				menu.setParent(this.getMenuName());
				menu.generateList(sc);
				menulist.add(menu);
			} else if(ans.equalsIgnoreCase("n")) {
				LeafMenu menu = new LeafMenu();
				menu.setMenuName(name);
				menu.setParent(this.menuName);
				menulist.add(menu);
			}
			
		}
	}
	
	@Override
	public String getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void setParent(String parentName) {
		// TODO Auto-generated method stub
		this.parent = parentName;
	}

	@Override
	public void setMenuName(String name) {
		// TODO Auto-generated method stub
		this.menuName = name;
	}

	@Override
	public String getMenuName() {
		// TODO Auto-generated method stub
		return menuName;
	}
}
