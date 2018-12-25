package Pratices;
import java.io.FileInputStream;
import java.util.Scanner;

public class p20180727_2 {
	static int Answer1, Answer2;

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
		Scanner sc = new Scanner(new FileInputStream("D:\\Download\\Crome\\sample_input.txt"));

		int T = sc.nextInt();
		char vowel[] = {'a', 'e', 'i', 'o', 'u'};

		for(int test_case = 0; test_case < T; test_case++) {
			Answer1 = 0;
			Answer2 = 0;

			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			int index = 0, temp_e = 0 , temp_ans1 = 0,temp_ans2 = 0, temp_length = 1001;
			int size = sc.nextInt();
			boolean flag = true;
			sc.nextLine(); // 개헹문자를 처리해주기 위해서 \n 을 의미
			String spell = sc.nextLine();
			
//			System.out.println(size);
//			System.out.println(spell);
//			
			for(int i = 0; i < size; i++) {
//				System.out.println("index : " + index);
				if(index > 4 ) {
					index = 0;
					for(int j = temp_ans1; j < temp_e;j++) {
						if(spell.charAt(j) == vowel[0]) { 
							temp_ans1 = j+1; 
						}
					}
					if(temp_length > (temp_ans2 - temp_ans1)) {
						temp_length = temp_ans2 - temp_ans1;
						Answer1 = temp_ans1;
						Answer2 = temp_ans2;
						
						System.out.println(Answer1 + " " + Answer2);
					}
					flag = false;
				}else if(spell.charAt(i) == vowel[index]) {
					if(spell.charAt(i) == vowel[0]) { 
						temp_ans1 = i+1;
						temp_e = -1;
					} else if(spell.charAt(i) == vowel[1] && temp_e == -1) {
						temp_e = i+1;
					}
					else if(spell.charAt(i) == vowel[4]) {
						temp_ans2 = i+1;
					} 
					index++;
					System.out.println("a : " + spell.charAt(i));
				}
			}
			
//			System.out.println(temp_e);

			
			if(index < 5 && flag) {
				Answer1 = -1;
				Answer2 = -1;
			}

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer1+ " " + Answer2);
		}
	}

}
