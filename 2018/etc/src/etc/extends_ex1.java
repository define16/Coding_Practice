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
		
		// ������ ���� �� ��ü�� ���� ���󰣴�. ���������� ��ӵ� Ŭ������ ���� X
		System.out.println("CCC ref1 : " + ref1.num); // CCC
		System.out.println("BBB ref1 : " + ref2.num); // BBB
		System.out.println("AAA ref1 : " + ref3.num); // AAA
		
		// ���������� �������̵� �� ���� ����Ѵ�.
		ref1.stringPrint(); 
		ref2.stringPrint();
		ref3.stringPrint();
		
		// ��ӵ� �޼ҵ�� �Ű����� ���°� �´� �޼ҵ带 ����Ѵ�.
		// ���� �Ű������� ���� �Լ��� ��ӵ� Ŭ������ �ִٸ� �� Ŭ���� �ȿ� �ִ� �޼ҵ带 ����Ѵ�.
		ref1.loadMethod();
		ref1.loadMethod(1);
		ref1.loadMethod(1.2);
	}
}
