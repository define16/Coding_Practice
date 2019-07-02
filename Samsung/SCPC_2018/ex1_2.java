package SCPC_2018;
/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */

public class ex1_2 {

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
		long start = System.currentTimeMillis();

		Scanner sc = new Scanner(new FileInputStream("D:\\Download\\Crome\\sample_input1.txt"));
//		Scanner sc = new Scanner(new FileInputStream("w.txt"));
 
		int T = sc.nextInt();

		int A[], BUS[];

		int K = 0;
		int index = 0, bus_index = 0;
		int gap = 0;
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
//			K = Integer.parseInt(sc.nextInt());
			K = sc.nextInt();
			A = new int[index];
			BUS = new int[index];
			for (int i = 0; i < index; i++) {
				A[i] = sc.nextInt();
			}

			if (index < 2) {
				Answer++;
			}
			else if (index == 2) {
				gap = A[1] - A[0];
				
				if(gap <= K) {
					Answer = 2;
				}else {
					Answer = 1;
				}
			}
			else {
				Arrays.sort(A);
		    }
			
			int check = 0;
			 while(check < index) {
				 bus_index = 0;
				 flag = true;
				for (int i = 0; i < index - 1; i++) {
					if ( A[i] == -1)
						continue;
					if (flag && A[i] != -1) {
						BUS[bus_index] = i;
						bus_index++;
						flag = false;
					}

					for (int j = i + 1; j < index; j++) {
						if (A[j]== -1)
							continue;
						gap = A[j] - A[i]  ;
//						System.out.println(i + ", " + j + ", " + gap);
						if (gap > K) {
							BUS[bus_index] = j;
							bus_index++;
							i = j - 1;

							break;
						}
					}

				}
//				System.out.println("bus_index 전 : " + bus_index);
				if(bus_index==0) {
					bus_index = 1;
				}
//				System.out.println("bus_index 후 : " + bus_index);
//				System.out.print("BUS : ");
//				for (int i = 0; i < bus_index; i++) {
//					System.out.print(BUS[i] + " ");
//				}
//				System.out.println();
//				System.out.print("A : ");
				for (int i = 0; i < bus_index; i++) {
//					System.out.print(A[BUS[i]]+ " ");
					A[BUS[i]] = -1;
				}
//				System.out.println();
				Answer++;
//				System.out.println("버스 : " + Answer);


				check+=bus_index;
//				System.out.println("check : " + check);
			}

			// Print the answer to standard output(screen).
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초");

	}

}
