package backjoon.Grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준알고리즘, 1931번, 회의실배정 <br>
 * https://www.acmicpc.net/problem/1931
 * @author define16
 *
 */
public class G_1931 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		G_1931 g = new G_1931();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int answer = 0;
		int number = Integer.parseInt(bf.readLine().trim());
		String[] tmp;
		int arr[][] = new int[number][2];

		for (int i = 0; i < number; i++) {
			tmp = bf.readLine().trim().split(" ");
			arr[i][0] =  Integer.parseInt(tmp[0]);
			arr[i][1] =  Integer.parseInt(tmp[1]);
		}
		
		// 회의 종료시간을 기준으로 정렬
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		// 첫 회의부터 시작이므로 count = 1
		answer = g.setConferenceTime(arr, 0, 0, 1);
		System.out.println(answer);
	}
	
	public int setConferenceTime(int[][] arr, int startIndex, int nextIndex, int count) {
		// 마지막 index 도달시 return
		if (nextIndex == arr.length-1) {
			return count;
		}
		// 현재 회의 시간 종료이 다음 회의 시작 시간보다 늦으면 다음 회의일정으로 이동
		if(arr[startIndex][1] > arr[nextIndex+1][0]) {
			return setConferenceTime(arr, startIndex ,nextIndex+1, count);
		}
		// 현재 회의 시간 종료 이후, 다음 회의가 있다면 count+1 후 다음 회의일정으로 이동
		else {
			return setConferenceTime(arr, nextIndex+1, nextIndex+1, ++count);
		}
		
	}

}
