package assignment1;

public class Node<E> {

	private E element;
	private Node<E> next;
	private Node<E> prv;

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node<E> getPrevious() {
		return prv;
	}

	public void setPrevious(Node<E> last) {
		this.prv = last;
	}
	
	public String toString(){
		return element.toString();
	}
}
