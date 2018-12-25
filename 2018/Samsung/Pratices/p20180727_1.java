package Pratices;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
/***
 * 
 * @author Junhyeong Cho
 * Á¡¼ö : 100
 *
 */

public class p20180727_1 {
	static int Answer;
	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("D:\\Download\\Crome\\SampleInput.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int temp = 0;
			int size = sc.nextInt();
			int A[] = new int[size];
			for(int i=0;i<size;i++) {
				A[i] = sc.nextInt();
			}
			Arrays.sort(A);
			for(int i=0;i<size;i++) {
				if(i % 2 == 0) {
					temp += A[i];
				}else {
					temp -= A[i];
				}
			}
			Answer = temp;
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
