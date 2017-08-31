package com.metacube.Printer;

/**
 * The Heap class containing all the operations of heap.
 * @author Deepak
 *
 */
public class MyHeap {
	int heapSize;
	int capacity;
	Job job[];
	
	/**
	 * Parameterized Constructor.
	 * @param cap
	 */
	MyHeap(int cap) {
		heapSize = 0;
		capacity = cap + 1;
		job = new Job[capacity];
	}
	
	/**
	 * get parent for the array
	 * element 
	 * @param position
	 * @return
	 */
	int parent(int position) {
		return position / 2;
	}
	
	/**
	 * get left child for the array
	 * element
	 * @param position
	 * @return
	 */
	int left(int position) {
		return 2 * position;
	}
	
	/**
	 * get right child index 
	 * for the array element
	 * @param position
	 * @return
	 */
	int right(int position) {
		return (2 * position + 1);
	}
	
	/**
	 * swap the parentIndex element 
	 * with childIndex element.
	 * @param parentIndex
	 * @param childIndex
	 */
	void swap(int parentIndex, int childIndex) {
		Job temp = job[parentIndex];
		job[parentIndex] = job[childIndex];
		job[childIndex] = temp;
	}
	
	/**
	 * insert the priority based 
	 * job in the heap
	 */
	boolean insert(String name, int priority) {
		if (heapSize >= capacity) {
			System.out.println("Heap OverFlow");
			return false;
		}
		Job newJob = new Job(name, priority);
		if (heapSize == 0) {
			job[++heapSize] = newJob;
			return true;
		}
		else if (++heapSize != capacity) {
			job[heapSize] = newJob;
			int pos = heapSize;
			while (pos != 1	&& job[parent(pos)].getPriority() < job[pos].getPriority()) {
				swap(parent(pos), pos);
				pos = parent(pos);
			}
			return true;
		}
		else {		
			System.out.println("Heap OverFlow *******");
			return false;
		}
	}
	
	/**
	 * Switching root node with last node and then removing it 
	 * and performing heapify again
	 */
	public Job remove() {
		if (heapSize == 0) {
			System.out.println("Empty Heap");
			return null;
		}
		if (heapSize == 1) {
			Job temp = job[heapSize];
			heapSize--;
			return temp;
		}
		Job lastNode = job[heapSize];
		Job firstNode = job[1];
		job[1] = lastNode;
		heapSize--;
		int index = 1;
		while (index <= heapSize / 2) {
			heapify(index);
			index++;
		}
		return firstNode;
	}
	
	/** 
	 * heapify the heap.
	 * @param index
	 */
	void heapify(int index) {
		int left = left(index);
		int right = right(index);
		int larger = index;
		if (left <= heapSize && job[index].getPriority() < job[left].getPriority()) {
			larger = left;
		}
		if (right <= heapSize && job[larger].getPriority() < job[right].getPriority()) {
			larger = right;
		}
		swap(index, larger);
	}
	
	/**
	 * method to return String format for
	 * the object.
	 */
	public String toString() {
		String result = "";
		for (int index = 1; index <= heapSize; index++) {
			result += job[index].getPriority();
		}
		return result;
	}
}
