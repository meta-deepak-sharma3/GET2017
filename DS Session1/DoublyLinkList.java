package assignment1;

public class DoublyLinkList<E> implements List<E> {

	private Node<E> first;
	private Node<E> last;
	private int size = 0;

	@Override
	public boolean add(E element) {
		Node<E> node = new Node<E>();
		node.setElement(element);
		if (first == null) {
			first = node;
			last = node;
			node.setNext(null);
			node.setPrevious(null);
		} else {
			node.setPrevious(last);
			last.setNext(node);
			last = node;
			node.setNext(null);
		}
		size++;
		return true;
	}

	@Override
	public boolean add(int index, E element) {
		if (index > size()) {
			throw new IllegalArgumentException("index provided is not right");
		}
		Node<E> temp = first;
		Node<E> node = new Node<E>();
		node.setElement(element);
		int counter;
		if (index == 0) {
			first.setPrevious(node);
			node.setNext(first);
			node.setPrevious(null);
			first = node;
		} else if (index == size()) {
			last.setNext(node);
			node.setPrevious(last);
			node.setNext(null);
			last = node;

		} else if (index < (size() / 2)) {
			counter = 0;
			while (temp != null && counter < index - 1) {
				temp = temp.getNext();
				counter++;
			}
			node.setNext(temp.getNext());
			node.setPrevious(temp);
			temp.getNext().setPrevious(node);
			temp.setNext(node);
		} else {
			counter = size();
			temp = last;
			while (temp != null && counter > index + 1) {
				temp = temp.getPrevious();
				counter--;
			}
			node.setNext(temp);
			node.setPrevious(temp.getPrevious());
			temp.getPrevious().setNext(node);
			temp.setPrevious(node);
		}
		size++;
		return true;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
	}

	@Override
	public boolean contains(E o) {
		Node<E> temp = first, temp1 = last;
		while (temp != null && temp1 != null) {
			if (temp.getElement().equals(o) || temp1.getElement().equals(o)) {
				return true;
			}
			temp = temp.getNext();
			temp1 = temp1.getPrevious();
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (first == null && last == null) {
			return true;
		}
		return false;
	}

	@Override
	public E remove(int index) {
		if (index > size()) {
			throw new IllegalArgumentException("Index is not correct");
		}
		E value;
		Node<E> temp, temp1;
		int counter;
		if (index < size() / 2) {
			temp = first;
			counter = 0;
			if(index == counter){
				first = first.getNext();
				first.setPrevious(null);
				value = temp.getElement();
				temp = null;
				size--;
				return value;
			}
			while (temp != null && counter < index - 1) {
				temp = temp.getNext();
				counter++;
			}
			temp1 = temp.getNext();
			value = temp1.getElement();
			temp.setNext(temp1.getNext());
			temp1.getNext().setPrevious(temp);
			temp1 = null;
		} else {
			temp = last;
			counter = size();
			if(counter == size()){
				last = last.getPrevious();
				last.setNext(null);
				value = temp.getElement();
				temp =null;
				size--;
				return value;
			}
			while (temp != null && counter > index + 1) {
				temp = temp.getPrevious();
				counter--;
			}
			temp1 = temp.getPrevious();
			value = temp1.getElement();
			temp.setPrevious(temp1.getPrevious());
			temp1.getPrevious().setNext(temp);
			temp1 = null;
		}
		size -- ;
		return value;
	}

	@Override
	public int removeByValue(E value) {
		int index=0;
		Node<E> node = first,prv=first;
		while(node!=null){
			if(node.getElement().equals(value)){
				if(index == 0){
					first = first.getNext();
					node = null;
					return index;
				}else if(index == size()){
					last = last.getPrevious();
					last.setNext(null);
					node = null;
					return index;
				}
				break;
			}
			index++;
			prv = node;
			node = node.getNext();
		}
		prv.setNext(node.getNext());
		node.getNext().setPrevious(prv);
		node=null;
		size--;
		return index;
	}

	@Override
	public void reverse() {
		int index =0 ;
		Node<E> temp = first;
		while(first!=null){
			temp=first;
			first = first.getNext();
			temp.setNext(temp.getPrevious());
			temp.setPrevious(first);
			if(index == 0){
				last = temp;
				index++;
			}
		}
		first=temp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		Node<E> node = first;
		int index =0 ;
		while(node!=null){
			array[index++] = node.getElement();
			node=node.getNext();
		}
		return array;
	}

	@Override
	public E getElement(int index) {
		if(index > size()){
			throw new IllegalArgumentException("Index is not proper");
		}
		Node<E> node = first;
		int counter =0;
		while(counter< index){
			node=node.getNext();
			counter++;
		}
		return node.getElement();
	}
}
