package DataStuctures;

/**
 * 
 * @author define16
 *
 * 1. empty(), full()
 * 2. insert(), remove()
 * 3. peek() (맨앞 데이터 조회)
 * 4. toString() (큐 리스트 내용 확인)
 */

public class ArrayCircularQueue {
	private int front;
	private int rear;
	private int maxSize;
	private int[] arrayQueue;
	private boolean isEmpty = true;
	
	public ArrayCircularQueue(int maxSize) {
		this.maxSize = maxSize;
		this.front = 0;
		this.rear = 0;
		arrayQueue = new int[maxSize];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayCircularQueue acq = new ArrayCircularQueue(10);
		acq.insert(10);
		acq.insert(20);
		acq.insert(30);
		acq.insert(40);
		acq.insert(50);
		acq.insert(60);
		System.out.println("1 : " + acq.toString());
		acq.remove();
		acq.remove();
		acq.insert(70);
		acq.insert(80);
		acq.insert(90);
		System.out.println("2 : " + acq.toString());
		acq.remove();
		acq.remove();
		acq.insert(100);
		acq.insert(110);
		acq.insert(120);
		System.out.println("3 : " + acq.toString());
		acq.remove();
		acq.remove();
		acq.insert(130);
		acq.insert(140);
		acq.insert(150);
		acq.insert(160);
		System.out.println("4 : " + acq.toString());
		acq.insert(170);
		acq.insert(180);
		acq.insert(190);
		acq.insert(200);
		System.out.println("5 : " + acq.toString());
		
		
	}
	
	public boolean empty() {
		if(isEmpty && (front == rear)) {
			return true;
		}else {
			return false;
		}

	}

	public boolean full() {
		if((isEmpty == false)  && (front == rear)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void insert(int data) {
		if(full()) {
			System.out.println("가득차있다.");
			maxSize += 10;
			int[] temp = new int[maxSize];
			for(int i = 0; i < arrayQueue.length; i++) {
				if((i + front) < arrayQueue.length) {
					temp[i] = arrayQueue[i + front];
				}else {
					temp[i] = arrayQueue[(i + front) - arrayQueue.length];
				}
			}
			arrayQueue = temp;
		}
		
		arrayQueue[rear] = data;
		rear++;
		
		if(rear == maxSize) {
			rear = 0;
		}
		isEmpty = false;
	}
	
	public void remove() {
		if(empty()) {
			System.out.println("비어있습니다.");
		}
		arrayQueue[front] = 0;
		front++;
		
		if(front == maxSize-1) {
			front = 0;
		}
		isEmpty = true;
	}
	
	public String toString() {
		String msg = "";

		for(int i = 0; i < maxSize; i++) {
//			if(i == maxSize-1) {
//				int j = maxSize - front -1;
//				System.out.println(j);
//				msg += arrayQueue[j] + " ";
//			}else {
//				msg += arrayQueue[i] + " ";
//			}
			msg += arrayQueue[i] + " ";
		}
		
		return msg;
	}	
	
}
