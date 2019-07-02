package DataStuctures;
/**
 * 
 * @author define16
 * 
 * 1. Node�� ����
 * 2. addFirst, addLast, add(�߰�) ����
 * 3. toString(���) ����
 * 4. removeFirst, removeLast, remove(�߰�) ����
 * 5. size(ũ�� ���)
 * 6. get(������Ʈ ���) ����
 * 7. indexOf(Ž��) ����
 * 
 */

public class LinkedList {
	private Node head; // �� �� ���
	private Node tail; // �� �� ���
	private int size = 0; // ũ��
	
	// ���
	private class Node {
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
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(60);
		ll.addFirst(50);
		System.out.println(ll.toString());
		ll.add(4, 100);
		System.out.println(ll.toString());
		ll.remove(3);
		System.out.println(ll.toString());
		System.out.println(ll.getSize());
		System.out.println(ll.getElement(3));
		System.out.println(ll.indexOf(40));

	}
	
	//�ٽ�1
	public void addFirst(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		head = newNode;
		head.link = temp;
		size++;
		
		// head�� tail�� �����ϴ� �κ�
		if(head.link == null) {
			tail = head;
		}
	}
	//�ٽ�2
	public void addLast(int data) {
		Node newNode = new Node(data);
		if(size == 0) {
			addFirst(data);
		}else {
			tail.link = newNode;
			tail = newNode;
			size++;
		}

	}
	
	// index ��° ��� ���
	Node node(int index) {
		Node temp = head;
		for(int i=0; i < index; i++) {
			temp = temp.link;
		}
		
		return temp;
	}
	
	// �߰��� ����
	public void add(int index, int data) {
		if(index == 0) {
			addFirst(data);
		}else {
			Node temp1 = node(index-2); // index-1��° ��带 �ҷ��´�.
			Node temp2 = temp1.link; // index��° ��� �ҷ��´�.
			
			Node newNode = new Node(data);
			temp1.link = newNode;
			newNode.link = temp2;
			size++;
		}
	}
	
	public void removeFirst() {
		if(size == 0) {
			System.out.println("���Ұ� �����ϴ�.");
		}else {
			head = head.link;
			size--;
		}
	}
	
	public void removeLast() {
		if(size == 0) {
			System.out.println("���Ұ� �����ϴ�.");
		}else if(size == 1) {
			removeFirst();
		}else {
			tail = null;
			size--;
		}
	}
	
	public void remove(int index) {
		if(size == 0) {
			System.out.println("���Ұ� �����ϴ�.");
		}else if(size == 1) {
			removeFirst();
		}else {
			Node temp1 = node(index-2);
			temp1.link = temp1.link.link;
			size--;
		}
	}
	
	public int getSize() {
		return size;		
	}
	
	public int getElement(int index) {
		Node temp = head;
		for(int i =0; i < index-1; i++) {
			temp = temp.link;
		}
		return temp.data;
		
	}
	
	public int indexOf(int data) {
		Node temp = head;
		for(int i = 0; i < size;i++) {
			if(temp.data == data) {
				return i+1;
			}else {
				temp = temp.link;
			}
		}
		return size;
		
	}
	
	public String toString() {
		String msg = "";
		Node temp = head;

		for(int i = 0; i < size; i++) {
			msg += temp.toString() + " ";
			temp = temp.link;
		}
		return msg;
	}
}
