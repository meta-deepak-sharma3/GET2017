package assignment1;

import java.util.Comparator;

public class ArrayList<E> implements List<E> {

	private Object[] Array = null;
	private static int MAX = 5;

	// Constructor
	public ArrayList() {
		super();
		Array = new Object[MAX];
	}

	// To increase the size of an Array
	private void increaseArraySize() {
		MAX += 2;
		Object[] newArray = new Object[MAX];

		for (int i = 0; i < size(); i++) {
			newArray[i] = this.Array[i];
		}
		this.Array = newArray;
	}

	// Merge sort is applied to sort the array
	// It divides array into sub arrays
	private void mergeSort(int low, int high, Object[] sortedArray,
			Comparator<E> c) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid, sortedArray, c);
			mergeSort(mid + 1, high, sortedArray, c);
			merge(low, mid, high, sortedArray, c);
		}

	}

	// It merge and sort the two arrays and return final sorted array
	@SuppressWarnings("unchecked")
	private void merge(int low, int mid, int high, Object[] sortedArray,
			Comparator<E> c) {
		for (int i = low; i <= high; i++) {
			sortedArray[i] = Array[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (c.compare((E) sortedArray[j], (E) sortedArray[i]) > 0) {
				Array[k] = sortedArray[i];
				i++;
			} else {
				Array[k] = sortedArray[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			Array[k] = sortedArray[i];
			k++;
			i++;
		}
	}

	// to add an element in array
	@Override
	public boolean add(E element) {
		try {
			if (size() >= MAX / 2 + 1) {
				increaseArraySize();
			}
			this.Array[size()] = element;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// to add elements at position index
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E element) {
		try {
			if (size() >= MAX / 2 + 1) {
				increaseArraySize();
			}
			E temp;
			for (int i = index; i <= size(); i++) {
				temp = (E) this.Array[i];
				this.Array[i] = element;
				element = temp;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// it clear the all elements of the list
	@Override
	public void clear() {
		Object[] newArray = new Object[5];
		this.Array = newArray;
	}

	// it checks where the object contains in array or not
	@Override
	public boolean contains(E o) {
		for (int i = 0; i < size(); i++) {
			if (o.equals(this.Array[i])) {
				return true;
			}
		}
		return false;
	}

	// return that list is empty or not
	@Override
	public boolean isEmpty() {
		for (int i = 0; i < size(); i++) {
			if (this.Array[i] != null) {
				return false;
			}
		}
		return true;
	}

	// Remove the element of location index
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (index > size()) {
			//throw new IllegalArgumentException();
		}
		E removed = (E) this.Array[index];
		for (int i = index; i <= size(); i++) {
			this.Array[i] = this.Array[i + 1];
		}
		return removed;

	}

	// Return the no of elements present in a list
	@Override
	public int size() {
		int i = 0;
		for (i = 0; i < Array.length; i++) {
			if (Array[i] == null) {
				break;
			}
		}
		return i;
	}

	// return the object array
	@Override
	public Object[] toArray() {
		return this.Array;
	}

	// Removing the element by finding its value in array
	@Override
	public int removeByValue(E value) {
		boolean flag = false;
		int index = 0;
		for (int i = 0; i < size(); i++) {
			if (this.Array[i] == value && !flag) {
				index = i;
				flag = true;
			}
			if (flag) {
				this.Array[i] = this.Array[i + 1];
			}
		}
		if(index > size()){
			throw new IllegalArgumentException();
		}
		return index;
	}
	
	// reverse the array
	@Override
	public void reverse() {
		Object[] reverseArray = new Object[size()];
		int index = 0;
		for (int i = size() - 1; i >= 0; i--) {
			reverseArray[index++] = Array[i];
		}
		Array = reverseArray;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElement(int index) {
		return (E) Array[index];
	}

	// For sorting the array
	public void sort() {
		Object[] sortedArray = new Object[size()];
		Comparator<E> c = new Comparator<E>() {
			@Override
			public int compare(E arg0, E arg1) {
				int last = arg0.toString().compareTo(arg1.toString());
				return last;
			}
		};
		mergeSort(0, size() - 1, sortedArray, c);
	}

	// For printing the whole array
	@SuppressWarnings("unchecked")
	public void printArrayList() {
		for (int i = 0; i < size(); i++) {
			System.out.println((E) Array[i]);
		}
	}
}
