package com.metacube.GuestHouse;

import java.util.Comparator;

public class ArrayList<E> implements List<E> {

	private Object[] Array = null;
	private static int MAX = 5;

	/**
	 * Default Constructor
	 * 
	 */
	public ArrayList() {
		super();
		Array = new Object[MAX];
	}

	/**
	 * To increase the size of an Array
	 */
	private void increaseArraySize() {
		MAX += 2;
		Object[] newArray = new Object[MAX];

		for (int i = 0; i < size(); i++) {
			newArray[i] = this.Array[i];
		}
		this.Array = newArray;
	}

	/**
	 * Merge sort is applied to sort the array
	 * @param low
	 * @param high
	 * @param sortedArray
	 * @param c
	 */
	private void mergeSort(int low, int high, Object[] sortedArray,
			Comparator<E> c) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid, sortedArray, c);
			mergeSort(mid + 1, high, sortedArray, c);
			merge(low, mid, high, sortedArray, c);
		}

	}

	/**
	 * It merge and sort the two arrays and return final sorted array
	 * @param low : lower index
	 * @param mid: middle index
	 * @param high
	 * @param sortedArray: Object[]
	 */
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

	/**
	 * to add an element in array(non-Javadoc)
	 * @see com.metacube.GuestHouse.List#add(java.lang.Object)
	 * @param element
	 */
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

	/**
	 * to add elements at position index(non-Javadoc)
	 * @see com.metacube.GuestHouse.List#add(int, java.lang.Object)
	 * @param index
	 * @param element
	 */
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

	/**
	 *  it clear the all elements of the list(non-Javadoc)
	 * @see com.metacube.GuestHouse.List#clear()
	 */
	@Override
	public void clear() {
		Object[] newArray = new Object[5];
		this.Array = newArray;
	}

	/**
	 * it checks where the object contains in array or not(non-Javadoc)
	 * @see com.metacube.GuestHouse.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E o) {
		for (int i = 0; i < size(); i++) {
			if (o.equals(this.Array[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return that list is empty or not
	 */
	@Override
	public boolean isEmpty() {
		for (int i = 0; i < size(); i++) {
			if (this.Array[i] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Remove the element of location index(non-Javadoc)
	 * @param index
	 * @see com.metacube.GuestHouse.List#remove(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (index > size() || index<0) {
			throw new IndexOutOfBoundsException();
		}
		E removed = (E) this.Array[index];
		for (int i = index; i <= size(); i++) {
			this.Array[i] = this.Array[i + 1];
		}
		this.Array[size()+1] = null;
		return removed;

	}

	/**
	 *  Return the no of elements present in a list(non-Javadoc)
	 * @see com.metacube.GuestHouse.List#size()
	 */
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

	/**
	 * return the object array(non-Javadoc)
	 * @see com.metacube.GuestHouse.List#toArray()
	 */
	@Override
	public Object[] toArray() {
		return this.Array;
	}

	/**
	 * Removing the element by finding its value in array(non-Javadoc)
	 * @param value
	 * @see com.metacube.GuestHouse.List#removeByValue(java.lang.Object)
	 */
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
	
	/**
	 * reverse the array(non-Javadoc)
	 * @see com.metacube.GuestHouse.List#reverse()
	 */
	@Override
	public void reverse() {
		Object[] reverseArray = new Object[size()];
		int index = 0;
		for (int i = size() - 1; i >= 0; i--) {
			reverseArray[index++] = Array[i];
		}
		Array = reverseArray;
	}

	/**
	 * get element by index
	 * @param index
	 * @see com.metacube.GuestHouse.List#getElement(int)
	 * @return E element
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E getElement(int index) {
		return (E) Array[index];
	}

	/**
	 * For sorting the array
	 */
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

	/**
	 *  For printing the whole array
	 */
	@SuppressWarnings("unchecked")
	public void printArrayList() {
		for (int i = 0; i < size(); i++) {
			System.out.println((E) Array[i]);
		}
	}
	
	/**
	 * updating the index value.
	 */
	public void overwriteElement(int index, E element) {
		// TODO Auto-generated method stub
		if(index >= size() || index<0) {
			throw new IllegalArgumentException();
		}
		Array[index] = element;
		
	}
}
