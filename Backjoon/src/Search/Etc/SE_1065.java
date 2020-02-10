package Search.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 알고리즘 문제
 * 탐색 --> 1065번 한수
 * https://www.acmicpc.net/problem/1065
 * @author define16
 * 
 * 한수 : 어떤 양의 정수 X의 자리수가 등차수열을 이룸
 * 한수의 개수를 구하라
 */
public class SE_1065 {

	public static void main(String[] args) {
		SE_1065 ex = new SE_1065();
		int answer = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		
		try {
			int number = Integer.parseInt(bf.readLine().trim());
			int count = 0;
			int hundreds, tens, units;
			
			// 100보다 작은 수는 모두 한수이다.
			if(number < 100) {
				count = number; 
			} else {
				for (int i = 100; i <= number; i++) {
					hundreds = i / 100; // 100의 자리
					tens = (i % 100)/10; // 10의 자리
					units = (i % 100) % 10 ; // 1의 자리
					
					// 100의 자리 10의 자리의 차이와 10의 자리와 1의 자리가 같을 경우 한수
					if ((hundreds - tens) == (tens - units)) {
						count++;
					}
				}
				count += 99; // 100보다 작은 수는 모두 한수이다.
			}
			answer = count;
			System.out.println(answer);
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
