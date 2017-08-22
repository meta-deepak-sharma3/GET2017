package assignment1;

public class SingleLinkedList<E> implements List<E> {

	Node<E> first; // this is head of the link list
	Node<E> last; // this is the last pointer to link lists

	// It add the element into link list  at last position
	@Override
	public boolean add(E element) {
		try {
			Node<E> node = new Node<E>();
			node.setElement(element);
			node.setNext(null);
			if (isEmpty()) {
				first = node;
			} else {
				last.setNext(node);
			}
			last = node;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// It add the element into link list by index position 
	@Override
	public boolean add(int index, E element) {
		if (index > size()) {
			throw new IllegalArgumentException();
		}
		try {
			Node<E> node = new Node<E>();
			node.setElement(element);
			if (index == 0) {
				add(element);
			} else if (index == size()) {
				last.setNext(node);
				last = node;
				node.setNext(null);
				return true;
			}
			int counter = 0;
			Node<E> temp = first;
			while (counter < index - 1 && temp.getNext() != null) {
				temp = temp.getNext();
				counter++;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// It clears all the link list
	@Override
	public void clear() {
		Node<E> temp = first;
		Node<E> temp1;
		while (temp != last) {
			temp1 = temp;
			temp.setElement(null);
			temp = temp.getNext();
			temp1.setNext(null);
		}
		temp.setElement(null);
		temp.setNext(null);
		first = null;
		last = null;
	}

	// it checks that link list contains that value or not
	@Override
	public boolean contains(E o) {
		Node<E> node = new Node<E>();
		node.setElement(o);
		Node<E> temp = first;
		while (temp != null) {
			if (temp.getElement() == node.getElement()) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	// it check whether the list is empty or not
	@Override
	public boolean isEmpty() {
		if (first == null) {
			return true;
		}
		return false;
	}

	// It remove the element by its index position
	@Override
	public E remove(int index) {
		E temp = null;
		Node<E> node = first, temp1;
		if (index == 0) {
			temp = node.getElement();
			first = node.getNext();
		} else {
			int counter = 0;
			while (node.getNext() != null && counter < index - 1) {
				counter++;
				node = node.getNext();
			}
			if (index == size() - 1) {
				last = node;
			}
			temp1 = node.getNext();
			temp = temp1.getElement();
			node.setNext(temp1.getNext());
			temp1 = null;

		}
		return temp;
	}

	// This return the size of link list
	@Override
	public int size() {
		int counter = 0;
		Node<E> node = first;
		while (node != null) {
			node = node.getNext();
			counter++;
		}
		return counter;
	}

	// This function return the link list in object array
	@Override
	public Object[] toArray() {
		Object[] array = new Object[this.size()];
		Node<E> node = first;
		int index = 0;
		while (node != null) {
			array[index] = node.getElement();
			node = node.getNext();
		}
		return array;
	}

	// It Print the whole link list
	public void printLinkedList() {
		Node<E> node = first;
		while (node != null) {
			System.out.println(node.getElement());
			node = node.getNext();
		}
	}

	// It remove the element according to first element matches the value and
	// return the index position
	@Override
	public int removeByValue(E value) {
		int index = 0;
		Node<E> node = first, prv = first;
		while (node != null) {
			if (node.getElement() == value) {
				if (index == 0) {
					first = first.getNext();
				} else if (index == size() - 1) {
					last = prv;
					prv.setNext(null);
				} else {
					prv.setNext(node.getNext());
				}
				node = null;
				break;
			}
			prv = node;
			index++;
			node = node.getNext();
		}
		if (index > size()) {
			throw new IllegalArgumentException();
		}
		return index;
	}

	// This function reverse the link list
	@Override
	public void reverse() {
		Node<E> prv, curr, next;
		prv = null;
		curr = first;
		last = first;
		next = first.getNext();
		while (curr.getNext() != null) {
			curr.setNext(prv);
			prv = curr;
			curr = next;
			next = next.getNext();
		}
		curr.setNext(prv);
		first = curr;
	}

	// This function return the element according to its index
	@Override
	public E getElement(int index) {
		if (index > size()) {
			throw new IllegalArgumentException();
		}
		Node<E> node = first;
		int counter = 0;
		E value;
		while (node.getNext() != null && counter < index) {
			node = node.getNext();
			counter++;
		}
		value = node.getElement();
		return value;
	}

	// It uses merge sort to sort two link list
	public boolean sort() {
		first = MergeSort(first);
		return true;
	}

	// It divides the link list into sub link list
	public Node<E> MergeSort(Node<E> headOriginal) {
		if (headOriginal == null || headOriginal.getNext() == null)
			return headOriginal;
		Node<E> a = headOriginal;
		Node<E> b = headOriginal.getNext();
		while ((b != null) && (b.getNext() != null)) {
			headOriginal = headOriginal.getNext();
			b = (b.getNext()).getNext();
		}
		b = headOriginal.getNext();
		headOriginal.setNext(null);
		return merge(MergeSort(a), MergeSort(b));
	}

	// it merge the two link list in sorted manner
	public Node<E> merge(Node<E> a, Node<E> b) {
		Node<E> temp = new Node<E>();
		Node<E> head = temp;
		Node<E> c = head;
		while ((a != null) && (b != null)) {
			if (a.getElement().toString().compareTo(b.getElement().toString()) <= 0) {
				c.setNext(a);
				c = a;
				a = a.getNext();
			} else {
				c.setNext(b);
				c = b;
				b = b.getNext();
			}
		}
		c.setNext((a == null) ? b : a);
		return head.getNext();
	}

	// It Join two link list
	public void joinTwoList(SingleLinkedList<E> list2) {
		this.last.setNext(list2.first);
		last = list2.last;
	}
}