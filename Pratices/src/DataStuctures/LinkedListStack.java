package DataStuctures;

public class LinkedListStack {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		private int data;
		private Node link;
		
		public Node(int data) {
			this.data = data;
			this.link = null;
		}
		
		public void setLink(Node node) {
			link = node;
		}
		
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack lls = new LinkedListStack();
		
		lls.push(10);
		lls.push(20);
		lls.push(30);
		lls.push(40);
		lls.push(50);
		System.out.println(lls.peek());
		System.out.println(lls.toString());
		lls.pop();
		System.out.println(lls.peek());
		System.out.println(lls.toString());
		lls.push(60);
		lls.push(70);
		lls.push(80);
		System.out.println(lls.peek());
		System.out.println(lls.toString());
		lls.pop();
		System.out.println(lls.peek());
		System.out.println(lls.toString());
		lls.push(90);
		lls.push(100);
		System.out.println(lls.peek());		
		System.out.println(lls.toString());
	}
	
	public void push(int data) {
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
	
	Node node(int index) {
		Node temp = head;
		for(int i = 0; i < index; i++)
			temp = temp.link;
		
		return temp;
	}
	
	public void pop() {
		Node temp = node(size-2); // 2칸 앞으로
		tail = temp;
		tail.setLink(null); 
		size--;		
	}
	
	public String toString() {
		Node temp = head;
		String msg = "LinkedList : ";
		for(int i=0; i < size;i++) {
			msg += String.valueOf(temp.data) + " ";
			temp = temp.link;
		}
		
		return msg;
	}
	
	public String peek() {
		Node temp = tail;
//		for(int i = 0; i < size-1; i++)
//			temp = temp.link;
		return temp.toString();
	}
}
