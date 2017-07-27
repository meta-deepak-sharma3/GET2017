import java.util.Scanner;

public class LeafMenu extends Menu {
	private String parent;
	private String menuName;
	
	// This is leaf menu not having list so it simply perform an action
	@Override
	public void actionPerformed(Scanner sc){
		System.out.println(parent + "->" + menuName);
		if(this.menuName.equals("Transpose")){
			Transpose.transpose(sc);
		}else if(this.menuName.equals("AddElements")){
			AddElements.addElements(sc);
		}else if(this.menuName.equals("Multiply")){
			Multiply.multiply(sc);
		}else if(this.menuName.equals("Close")){
			System.out.println("Exit");
		}
		
	}

	@Override
	public void setMenuName(String name) {
		// TODO Auto-generated method stub
		this.menuName = name;
	}

	@Override
	public String getMenuName() {
		// TODO Auto-generated method stub
		return this.menuName;
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
}
