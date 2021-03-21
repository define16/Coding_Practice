package etc.datastuctures;
/**
 * 
 * @author define16
 * 0. 전역 변수 - top, maxSize,stackArray
 * 1. empty(), full()
 * 2. push(), pop()
 * 3. peek()(가장위에 있는 값 반환)
 *
 */
public class ArrayStack {
	private int top = -1;
	private int maxSize = 0;
	private int[] stackArray;

	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new int[maxSize];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack as = new ArrayStack(10);
		as.pop();
		as.push(10);
		as.push(20);
		as.push(30);
		as.push(40);
		as.push(50);
		as.push(60);
		as.push(70);
		as.push(80);
		as.push(90);
		as.push(100);
		as.push(110);
		as.push(120);
		
		System.out.println("pop : " + as.peek());
		as.pop();
		System.out.println("pop : " + as.peek());
		as.pop();
		
		System.out.println("stack List : " + as.toString());
		
	}
	
	public boolean empty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean full() {
		if((maxSize-1) == top) {
			return true;
		}else {
			return false;
		}
	}

	public void push(int data) {
		if(full()) {
			System.out.println("꽉 찼습니다");
			maxSize += 10;
			int[] temp = new int[maxSize];
			for(int i = 0; i < stackArray.length; i++) {
				temp[i] = stackArray[i];
			}
			stackArray = temp;
		}
		top++;
		stackArray[top] = data;
	}
	
	public void pop() {
		if(empty()) {
			System.out.println("비어 있습니다.");
		}else {
			stackArray[top] = 0;
			top--;			
		}
	}
	
	public int peek() {
		int result = stackArray[top];
		return result;	
	}
	
	public String toString() {
		String msg = "";
		
		for(int i = maxSize-1; i > -1; i--) {
			if(stackArray[i] == 0)
				continue;
			msg += stackArray[i] + " ";
		}
		
		return msg;
	}
}
