package Assignment2;

/*
 * Implementing Queue from arrays
 * 
 */
public class Queue<E> {
	private static int DEFAULT_SIZE = 10;
	private Object[] queue;
	private int front;
	private int rear;
	
	public Queue() {
		queue = new Object[DEFAULT_SIZE];
		front = -1;
		rear = -1;
	}
	
	/*
	 * insert element at the rear of the queue.
	 */
	public void enqueue(E element) {
		
		if(rear >=queue.length) {
			increaseCapacity();
		}
		
		if(rear < 0 && front <0) {
			rear = 0;
			front = 0;
		}
		queue[rear++] = element;
	}
	
	private void increaseCapacity() {
		// TODO Auto-generated method stub
		Object[] newQueue = new Object[queue.length*2+1];
		System.arraycopy(queue, 0, newQueue, 0, rear);
		queue = newQueue;
	}

	/*
	 * Delete from front of the queue.
	 */
	@SuppressWarnings("unchecked")
	public E dequeue(){
		if(rear < 0 && front < 0) {
			System.out.println("Empty Queue......");
			System.exit(0);
		}
		E element = (E) queue[front];
		
		for(int i=0;i<rear-1;i++) {
			queue[i] = queue[i+1];
		}
		queue[rear-1] = null;
		rear--;
		return element;
	}
	
	/*
	 * clear all elements of queue and make queue empty.
	 */
	public void makeEmpty() {
		for(int i=front;i<rear;i++) {
			queue[i] = null;
		}
		queue = new Object[DEFAULT_SIZE];
		rear = 0;
	}
	
	/*
	 * get the element from the front only without getting removed it.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public E getFront() {
		if (front<0 && rear<0) {
			System.out.println("Empty Queue");
			System.exit(0);
		}
		
		return (E) queue[front];
	}

	public int size() {
		// TODO Auto-generated method stub
		if(rear < 0 && front < 0)
			return 0;
		return rear;
	}
}
