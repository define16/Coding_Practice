package etc.datastuctures;

public class LinkedListQueue {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node{
		private int data;
		private Node link;
		
		public Node(int data) {
			this.data = data;
			this.link = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListQueue llq = new LinkedListQueue();
		
		llq.insert(10);
		llq.insert(20);
		llq.insert(30);
		System.out.println(llq.peek());
		System.out.println(llq.toString());
		llq.remove();
		System.out.println(llq.peek());
		System.out.println(llq.toString());
		llq.insert(40);
		llq.insert(50);
		llq.insert(60);
		llq.insert(70);
		llq.insert(80);
		llq.insert(90);
		System.out.println(llq.peek());
		System.out.println(llq.toString());
		llq.remove();
		llq.remove();
		System.out.println(llq.peek());
		System.out.println(llq.toString());
		
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if(size == 0) {
			head = newNode;
			tail = head;
		}else {
			tail.link = newNode;
			tail = newNode;
		}
		size++;
	}
	
	
	public void remove() {
		Node temp = head;
		head = temp.link;
		size--;
	}
	
	public String peek() {
		return head.toString();
	}
	
	public String toString() {
		String msg = "LinkedList : ";
		Node temp = head;
		for(int i = 0; i < size; i++) {
			msg += temp.toString() + " ";
			temp = temp.link;
		}
		
		return msg;
	}
}
