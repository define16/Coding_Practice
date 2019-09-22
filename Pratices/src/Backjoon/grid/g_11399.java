package Backjoon.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 백준알고리즘, 11399번 ATM  <br>
 * https://www.acmicpc.net/problem/11399
 * @author define16
 *
 */
public class g_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int people = Integer.parseInt(bf.readLine().trim());
		String times_string[] = bf.readLine().trim().split(" ");
		int times[] = new int[people];
		/**
		 * TIP : 문자열의 정렬과 정수형의 정렬은 다르다.
		 */
		for (int i = 0; i < people; i++) {
			times[i] = Integer.parseInt(times_string[i]);
		}
		int totalTime = 0;
		
		Arrays.sort(times); // 낮은 시간부터 정렬
		
		for(int i = 0; i < people; i++) {
			int tmp = 0;
			System.out.println("i : " + i);
			for(int j = 0; j <= i; j++) { // 각 손님의 대기 시간을 계산 
				System.out.print(times[j] + " ");
				tmp += times[j];
			}
			System.out.println();
			totalTime += tmp; // 총 대기 시간 계산
			System.out.println("tmp : " + tmp + ", totalTIme : " + totalTime);
		}
		
		System.out.println(totalTime);
		
//		otherEx();
	}
	
	public static void otherEx() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int people = Integer.parseInt(bf.readLine().trim());
		String times_string[] = bf.readLine().trim().split(" ");
		int times[] = new int[people+1]; // 중첩으로 더하기 위해서 첫번째 자리는 사용하지 않는다.
		times[0] = 0;
		int totalTime = 0;
		for (int i = 1; i < people+1; i++) {
			times[i] = Integer.parseInt(times_string[i-1]);
		}
		
		Arrays.sort(times); // 낮은 시간부터 정렬
		
		for (int i = 1; i < people+1; i++) {
			times[i] = times[i-1] + times[i];
			totalTime += times[i];
		}
		
		System.out.println(totalTime);
	}

}
