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
public class ArrayQueue {
	private int front;
	private int rear;
	private int maxSize;
	private int[] arrayQueue;
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		this.front = 0;
		this.rear = 0;
		arrayQueue = new int[maxSize];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue aq = new ArrayQueue(10);
		aq.remove();
		aq.insert(10);
		aq.insert(20);
		aq.insert(30);
		aq.insert(40);
		aq.remove();
		aq.insert(50);
		aq.insert(60);
		System.out.println(aq.toString());
		aq.insert(70);
		aq.insert(80);
		aq.insert(90);
		aq.insert(100);
		aq.insert(110);
		aq.insert(120);
		System.out.println(aq.toString());
		aq.remove();
		aq.remove();
		
		System.out.println(aq.toString());
		System.out.println(aq.peek());
		System.out.println(aq.indexOf(90));
		System.out.println(aq.indexOf(120));
	}
	
	public boolean empty() {
		if(front == rear) return true;
		return false;
	}
	
	public boolean full() {
		if((maxSize-1) == rear) return true;
		return false;
	}
	
	public void insert(int data) {
		if(full()) {
			System.out.println("가득찼습니다.");
			maxSize += 10;
			int[] temp = new int[maxSize];
	
			for(int i = front; i < arrayQueue.length;i++) {
				temp[i] = arrayQueue[i];
			}
			arrayQueue = temp;
		}
		arrayQueue[rear] = data;
		rear++;
	}
	
	public void remove() {
		if(empty()) {
			System.out.println("비어 있습니다.");
		}else {
			arrayQueue[front] = 0;
			front++;
		}
	}
	
	public int peek() {
		return arrayQueue[front];
	}
	
	public int indexOf(int data) {
		int index = 0;
		for(int i = front; i < rear; i++) {
			if(arrayQueue[i] == data)
				return i;
		}
		
		return rear-1;
	}
	
	public String toString() {
		String msg = "";

		for(int i = front; i < rear; i++) {
			msg += arrayQueue[i] + " ";
		}
		
		return msg;
	}

}
