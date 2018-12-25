package SCPC_2018;
/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.io.FileInputStream;

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */

public class ex1_1 {

	static int Answer;

	public static void main(String args[]) throws Exception {
		/*
		 * The method below means that the program will read from input.txt, instead of
		 * standard(keyboard) input. To test your program, you may save input data in
		 * input.txt file, and call below method to read from the file when using
		 * nextInt() method. You may remove the comment symbols(//) in the below
		 * statement and use it. But before submission, you must remove the freopen
		 * function or rewrite comment symbols(//).
		 */

		/*
		 * Make new scanner from standard input System.in, and read data.
		 */
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("D:\\Download\\Crome\\sample_input1.txt"));

		int T = sc.nextInt();

		int A[], BUS[];

		int K = 0;
		int index = 0, bus_index = 0;
		int gap = 0,pivot = 0;
		int temp1 = 0;
		boolean flag = true;

		for (int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * Implement your algorithm here. The answer to the case will be stored in
			 * variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			bus_index = 0;
			index = sc.nextInt();
			K = sc.nextInt();
			A = new int[index];
			BUS = new int[index];
			for (int i = 0; i < index; i++) {
				A[i] = sc.nextInt();
			}

			if (index < 2) {
				Answer++;
			} else if (index == 2) {
				gap = A[1] - A[0];

				if (gap <= K) {
					Answer = 2;
				} else {
					Answer = 1;
				}
			} else {
				// for (int i = 0; i < index - 1; i++) {
				// for (int j = i + 1; j < index; j++) {
				// if (A[i] > A[j]) {
				// temp1 = A[i];
				// A[i] = A[j];
				// A[j] = temp1;
				// }
				// }
				// }

				A = heap(A, index);
				for (int i = index - 1; i > 0; i--) {
					int temp = A[0];
					A[0] = A[i];
					A[i] = temp;

					heap(A, i);
				}
				
				for(int i=0; i<index-1; i++) {
					pivot = A[i];
					for(int j=i+1;j<index;j++ ) {
						
						
					}
					
				}

			}
			// Print the answer to standard output(screen).
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);

		}

	}

	public static int[] heap(int[] data, int number) {
		for (int i = 1; i < number; i++) {
			int child = i;
			while (child > 0) {
				int parent = (child - 1) / 2;
				if (data[child] > data[parent]) {
					int temp = data[parent];
					data[parent] = data[child];
					data[child] = temp;
				}
				child = parent;
			}
		}
		return data;
	}

}
