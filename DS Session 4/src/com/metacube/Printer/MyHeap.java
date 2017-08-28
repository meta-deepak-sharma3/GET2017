package com.metacube.Printer;
/**
 *  This class contains heap operations
 * @author Deepak
 *
 */
public class MyHeap {
	private int heapSize;
	private int capacity;
	private Job job[];
	
	public MyHeap(int cap) {
		heapSize = 0;
		capacity = cap + 1;
		job = new Job[cap];
	}
	
	/**
	 * get the index of parent
	 * @param position
	 * @return
	 */
	public int parent(int position) {
		return position-1 / 2;
	}
	
	/**
	 * get the index of left child
	 * @param position
	 * @return
	 */
	public int left(int position) {
		return 2 * position+1;
	}
	
	/**
	 * get right child index
	 * @param position
	 * @return
	 */
	public int right(int position) {
		return (2 * position + 2);
	}
	
	/**
	 * swap the parent node with child.
	 * @param parentIndex
	 * @param childIndex
	 */
	void swap(int parentIndex, int childIndex) {
		Job temp = job[parentIndex];
		job[parentIndex] = job[childIndex];
		job[childIndex] = temp;
	}
	
	/**
	 * This method will insert job in the heap according to its priority
	 * @param name
	 * @param priority
	 */
	void insert(String name, int priority) {
		if (heapSize > capacity) {
			System.out.println("Heap OverFlow");
			return;
		}
		Job newJob = new Job(name, priority);
		if (heapSize == 0) {
			job[++heapSize] = newJob;
		}else {
			job[++heapSize] = newJob;
			int pos = heapSize;
			while (pos != 1	&& job[parent(pos)].getPriority() < job[pos].getPriority()) {
				swap(parent(pos), pos);
				pos = parent(pos);
			}
		}
	}
	
	/**
	 * Switching root node with last node and then removing it 
	 * and performing heapify again
	 * @return Job Object
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
	 * heapify the heap
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
	 * String Equivalent of heap
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = "";
		for (int index = 1; index <= heapSize; index++) {
			result += job[index].getPriority();
		}
		return result;
	}
}
