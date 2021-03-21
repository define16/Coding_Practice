package samsung.swpratice.Chapter01;

import java.util.HashMap;

public class SelectSort {

	public void swap(int a, int b) {
		//비트연산자XOR로 swap 하기. 단 a와 b가 같을때는 0이 나온다. ^연산의 특징
		a = a^b;
		b = a^b;
		a = a^b;
	}
	
	public int[] sort(int[] input) {
		int min;
		for(int i = 0; i<input.length-1;i++) {
			min = i;
			for(int j = i+1; j < input.length; j++) {
				if(input[min] > input[j]) {
					min = j;
				}
			}
			
			if(input[i] != input[min]) {
				input[i] = input[min]^input[i];
				input[min] = input[min]^input[i];
				input[i] = input[min]^input[i];
			}
			
		}
				
		return input;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {41, 31, 48, 97, 9, 65, 27,29, 13, 15};
		int[] input2 = {41, 31, 48, 97, 9, 65, 27,29, 13, 15};
		String[] grade = {"F","D","D+" ,"C","C+","B","B+","A","A+","A+"};
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		SelectSort selectSort = new SelectSort();
		
		input = selectSort.sort(input); // 선택정렬
		
		for(int i = 0; i<input.length;i++) {
			System.out.print(input[i] + " ");
			map.put(input[i], grade[i]);
		}
		System.out.println();

		for(int i = 0; i<input.length;i++) {

			for(int o: map.keySet()) {
				if(input2[i] == o) {
					System.out.print(map.get(o) + " ");
				}
			}

		}
				
		
	}

}
