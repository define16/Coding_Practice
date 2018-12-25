package etc;

class AAA{
	public int num = 2;
	
	public void stringPrint() {
		System.out.println("AAA");
	}
	public void loadMethod() {
		System.out.println("void loadMethod");
	}
}


class BBB extends AAA{
	public int num = 3;
	
	public void stringPrint() {
		System.out.println("BBB");
	}
	public void loadMethod(int i) {
		System.out.println("int1 loadMethod");
	}
}



class CCC extends BBB {
	public int num = 4;
	
	public void stringPrint() {
		System.out.println("CCC");
	}
	public void loadMethod(int i) {
		System.out.println("int2 loadMethod");
	}
	public void loadMethod(double i) {
		System.out.println("double loadMethod");
	}
}


public class extends_ex1 {

	public static void main(String []args) {
		
		CCC ref1 = new CCC();
		BBB ref2 = ref1;
		AAA ref3 = ref1;
		
		// 변수는 참조 된 객체의 값을 따라간다. 마지막으로 상속된 클래스의 변수 X
		System.out.println("CCC ref1 : " + ref1.num); // CCC
		System.out.println("BBB ref1 : " + ref2.num); // BBB
		System.out.println("AAA ref1 : " + ref3.num); // AAA
		
		// 마지막으로 오버라이딩 된 값을 출력한다.
		ref1.stringPrint(); 
		ref2.stringPrint();
		ref3.stringPrint();
		
		// 상속된 메소드는 매개변수 형태가 맞는 메소드를 출력한다.
		// 만약 매개변수가 같은 함수가 상속된 클래스에 있다면 그 클래스 안에 있는 메소드를 출력한다.
		ref1.loadMethod();
		ref1.loadMethod(1);
		ref1.loadMethod(1.2);
	}
}
