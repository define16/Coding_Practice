package Backjoon.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 미완성
 * 백준알고리즘, 2200번, 계산기
 * https://www.acmicpc.net/problem/2200
 * @author define16
 *
 */
public class g_2200 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int polynomial = Integer.parseInt(bf.readLine().trim());
		String num_string[] = bf.readLine().trim().split(" ");
		int operator = 0; //연산자
		int number = 0; // 숫자
		int sum = 0;
		
		// 연산자 개수 계산
		// 만약 최고차항이 3이고, 계수들이 1 1 1 1 일 경우,
		// =X*X*X +X*X +X +C
		// 위와 같은 방법으로 구한다.
		for(int i = 0; i < num_string.length - 1; i++) {
			if(Integer.parseInt(num_string[i]) > 0 ) { // 0보다 크면 
				operator = polynomial - i;
				number = num_string[i].length() * operator; // 만약 2자리수 이상의 값이 들어갈 경우
				System.out.println(number + " = " +  num_string[i].length() +" * " + operator);
				sum += operator + number;
				System.out.println(sum);
			}
		}
		if (Integer.parseInt(num_string[num_string.length - 1]) > 0 ) {
			operator = 1;
			number = num_string[num_string.length - 1].length();
			System.out.println(number + " " + operator);
			sum += operator + number;
		}	

		System.out.println(sum);		
		
	}

}
