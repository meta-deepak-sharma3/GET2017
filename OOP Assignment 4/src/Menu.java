/**
 * 
 * 
 *
 */
public abstract class Menu implements ActionMenu {
	/**
	 * This method is used to set menu names.
	 * @param name is the name of that menu.
	 */
	public abstract void setMenuName(String name);
	
	/**
	 * @return menu name which menu is called
	 */
	public abstract String getMenuName();
	/**
	 * This function is used to get parent name of that menu
	 * @return parent name
	 */
	public abstract String getParent();
	
	/**
	 * This function is used to set the parent name of that menu
	 * @param parentName
	 */
	public abstract void setParent(String parentName);
}