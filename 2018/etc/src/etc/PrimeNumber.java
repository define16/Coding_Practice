package etc;

import java.util.ArrayList;

public class PrimeNumber {

	private ArrayList primeNum = null;
	
	public ArrayList getPrimeNum() {
		return this.primeNum;
	}
	
	public void find(int N) {
		boolean flag;
		primeNum = new ArrayList<Integer>();
		primeNum.add(2);
		for(int i = 3; i <= N; i++) {
			flag = true;
			for(int j = 0; j < primeNum.size(); j++) {
				if(i % Integer.parseInt(String.valueOf(primeNum.get(j))) == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				primeNum.add(i);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumber pn = new PrimeNumber();
		pn.find(100);
		ArrayList primeNum = pn.getPrimeNum();
		for(int i = 0; i < primeNum.size(); i++) {
			System.out.print(primeNum.get(i) + " ");
		}
		System.out.println();
	}

}
