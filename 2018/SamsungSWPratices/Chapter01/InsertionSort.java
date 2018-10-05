package SamsungSWPratices.Chapter01;

public class InsertionSort {

	public int[] sort(int[] input) {
		int key = 0;

		for(int i = 1; i <input.length; i++) {
			key = input[i];

			int j=i-1;
			while(j >= 0 && key < input[j]) {
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key;
//			System.out.println();
//			for(int k = 0; k <input.length; k++) {
//				System.out.print(input[k] + " ");
//			}
//			System.out.println();
		}
		return input;
	}


	public static void main(String[] args) {
		int[] input = {35, 9, 8, 18, 98, 31, 58, 17, 76, 45};
		int my_num = 31;
		InsertionSort insertionSort = new InsertionSort();

		input = insertionSort.sort(input);

		System.out.println("-----Á¤´ä-----");
		for(int i = 0; i <input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		for(int i = 0; i <input.length; i++) {
			if(my_num == input[i])
				System.out.println(i+1);
		}

	}

}
