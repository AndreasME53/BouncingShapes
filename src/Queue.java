/**
 *
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {
	//TODO:  You need some data to store the queue.  Put the attributes here.
	//The head is the front element of the queue
	private QueueElement head;
	//The tail last element of the queue
	private QueueElement tail;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		//TODO: Write the Queue constructor
		this.head = null;
		this.tail = null;
	}

	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		//TODO:  Needs to return true when empty and false otherwise
		return (this.head == null) && (this.tail == null);
	}


	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		if(isEmpty()){
			throw new NoSuchElementException();
		}else{
			return (T) head.getElement();
		}

	}

	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException();
		}else if(head == tail){
			tail = null;
		}else {
			head = head.getNext();
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
		//Enqueue code is needed here
		QueueElement elem = new QueueElement(element, null);
		if(isEmpty()){
			head = elem;
			tail = head;
		}else{
			tail.setNext(elem);
			tail = elem;
		}
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		//Code to print the code is needed here
		if(isEmpty()){
			System.out.println("Empty queue");
		}else {
			QueueElement frontItem = head;
			while(frontItem != null){
				System.out.println(frontItem.getElement());
				frontItem = frontItem.getNext();
			}
		}
	}
}