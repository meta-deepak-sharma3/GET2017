package assignment1;

public interface List<E> {
	public boolean add(E element);
	public boolean add(int index,E element);
	public void clear();
	public boolean contains(E o);
	public boolean equals(Object o);
	public boolean isEmpty();
	public E remove(int index);
	public int removeByValue(E value);
	public void reverse();
	public int size();
	public Object[] toArray();
	public E getElement(int index);
	
}
