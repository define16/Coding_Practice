package DataStuctures;
/**
 * 
 * @author define16
 * 
 * 1. Node를 구현
 * 2. addFirst, addLast, add(중간) 구현
 * 3. toString(출력) 구현
 * 4. removeFirst, removeLast, remove(중간) 구현
 * 5. size(크기 출력)
 * 6. get(엘리먼트 출력) 구현
 * 7. indexOf(탐색) 구현
 * 
 */

public class LinkedList {
	private Node head; // 맨 앞 노드
	private Node tail; // 맨 뒤 노드
	private int size = 0; // 크기
	
	// 노드
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
	
	//핵심1
	public void addFirst(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		head = newNode;
		head.link = temp;
		size++;
		
		// head와 tail을 연결하는 부분
		if(head.link == null) {
			tail = head;
		}
	}
	//핵심2
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
	
	// index 번째 노드 출력
	Node node(int index) {
		Node temp = head;
		for(int i=0; i < index; i++) {
			temp = temp.link;
		}
		
		return temp;
	}
	
	// 중간에 삽입
	public void add(int index, int data) {
		if(index == 0) {
			addFirst(data);
		}else {
			Node temp1 = node(index-2); // index-1번째 노드를 불러온다.
			Node temp2 = temp1.link; // index번째 노드 불러온다.
			
			Node newNode = new Node(data);
			temp1.link = newNode;
			newNode.link = temp2;
			size++;
		}
	}
	
	public void removeFirst() {
		if(size == 0) {
			System.out.println("원소가 없습니다.");
		}else {
			head = head.link;
			size--;
		}
	}
	
	public void removeLast() {
		if(size == 0) {
			System.out.println("원소가 없습니다.");
		}else if(size == 1) {
			removeFirst();
		}else {
			tail = null;
			size--;
		}
	}
	
	public void remove(int index) {
		if(size == 0) {
			System.out.println("원소가 없습니다.");
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
