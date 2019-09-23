package Backjoon.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 백준알고리즘, 2200번, 계산기
 * https://www.acmicpc.net/problem/2200
 * @author define16
 *
 */
public class g_2200 {

	String answer = "";
	String prefix = "";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int polynomial = Integer.parseInt(bf.readLine().trim());
		String num_string[] = bf.readLine().trim().split(" ");
		int total_count = 0; // 총 개수
		int count = 0; // 0이 아닌 계수의 개수(상수도 포함)
		int length = 0; // 계수의 총 길이
		// 1부터 시작하는 이유는 최대 차수의 계수는 1이므로 인수분해시 없어지기 때문
		for (int i = 1; i < num_string.length; i++) {
			if(Integer.parseInt(num_string[i]) != 0) {
				count++;
				length += num_string[i].length();
			}
		}
		int operator = (polynomial + count) - 1; // 연산자의 개수는 x의 차수 + 계수의 갯수이다.
		// 예 : x+1*x+1*x+1
		
		total_count = polynomial + length + operator + 1; // +1 은 = 연산
		System.out.println(total_count);

	}
	
	// 다른방법으로 구현 중
	// 다이나믹 프로그래밍 - 미완성
	public void otherWay() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int polynomial = Integer.parseInt(bf.readLine().trim());
		String num_string[] = bf.readLine().trim().split(" ");
		int total_count = 0;
		int num[] = new int[polynomial+1];
		for(int i =0; i<=polynomial;i++) {
			num[i] = Integer.parseInt(num_string[i]);
		}
		String mid = factorization(num, polynomial, 0);
		String equation = prefix + mid + "+" + num_string[polynomial] + "=";
		System.out.println(equation);
		
	}
	public  String factorization(int num[], int polynomial, int idx) {
		int tmp_idx = idx;
		if(num[idx] > 0 && idx < polynomial-1 && idx != polynomial/2) {
			answer += factorization(num, polynomial, ++idx);
			if(num[tmp_idx] > 0) {
				answer += "*x+"+num[tmp_idx];
				
			}

		}else if (idx == polynomial/2){ // 가장 처음으로 계산 되어야할 식
			prefix = "x+" + String.valueOf(num[tmp_idx]);
			answer += factorization(num, polynomial, ++idx);
		}else { // x^1 부분
			if(num[tmp_idx] > 0) {
				answer += "*x+"+num[tmp_idx];
			}
		}
		return answer;
	}
	

	


}
