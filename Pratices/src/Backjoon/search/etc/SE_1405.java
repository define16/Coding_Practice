package Backjoon.search.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 
public class SE_1405 {
	final char[] direction = { 'N', 'S', 'E', 'W' };
//	final int[][] direction = { {0,1}, {0,-1}, {-1,0}, {1,0} };
	HashMap<String, Double> courses = new HashMap<String, Double>();
	boolean[][] visited;
	int N;
	double east;
	double west;
	double south;
	double north;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		SE_1405 ex = new SE_1405();
		double answer = 0.0;

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String[] directions = bf.readLine().trim().split(" ");
		ex.N = Integer.parseInt(directions[0]);
		ex.east = Double.parseDouble(directions[1]) * 0.01;
		ex.west = Double.parseDouble(directions[2]) * 0.01;
		ex.south = Double.parseDouble(directions[3]) * 0.01;
		ex.north = Double.parseDouble(directions[4]) * 0.01;
		
		ex.visited = new boolean[ex.N][ex.N];

		double probability = 1.0;
		int latitude = -100;
		int longitude = -100;

		ex.makeCourses(0, "", probability, latitude, longitude);

		for (Map.Entry<String, Double> m : ex.courses.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
			answer += m.getValue();
		}

		System.out.format("%.9f", answer);

	}
	
	public void makeCourses(int idx, int x, int y,double probability) {
		if (N > idx) {
			visited[y][x] = true;
			
			for(int i = 0; i < 4; i++) {
//				int nextX = x + direction[i][0];
//				int nextY = y + direction[i][1];
//				if (!visited[nextX][nextY]) {
//					idx++;
//					makeCourses(idx, nextX, nextY);
				}
			}
		}
	}

	public void makeCourses(int idx, String course, double probability, int latitude, int longitude) {
		double probability_now = probability;
		int latitude_now = latitude;
		int longitude_now = longitude;
		System.out.println(idx);
		if (N > idx) {
			for (char d : direction) {
				if (course.length() > idx) {
					course = course.substring(0, idx);
					probability = probability_now;
					latitude = latitude_now == 0 ? -100 : latitude_now; // 0이면 -100 삽입
					longitude = longitude_now == 0 ? -100 : longitude_now;
				}
				// 각 방향마다 확률과 다시 온 곳인지 체크
				switch (d) {
				case 'N':
					// 이미 방문한 곳
					if (course.length() > 0 && course.charAt(course.length() - 1) == 'S') {
						continue;
					}
					probability *= north; // 확률 계산
					latitude = latitude == -100 ? 1 : ++latitude; // -100은 최초 진입
					break;
				case 'S':
					if (course.length() > 0 && course.charAt(course.length() - 1) == 'N') {
						continue;
					}
					probability *= south;
					latitude = latitude == -100 ? -1 : --latitude;
					break;
				case 'E':
					if (course.length() > 0 && course.charAt(course.length() - 1) == 'W') {
						continue;
					}
					probability *= east;
					longitude = longitude == -100 ? 1 : ++longitude;
					break;
				case 'W':
					if (course.length() > 0 && course.charAt(course.length() - 1) == 'E') {
						continue;
					}
					probability *= west;
					longitude = longitude == -100 ? -1 : --longitude;
					break;
				}
				course += d;
				// latitude 이나 longitude이 0이면 재방문
				if (latitude == 0 | longitude == 0) {
					continue;
				}
				makeCourses(idx + 1, course, probability, latitude, longitude);
			}
		} else {
			// latitude 이나 longitude이 0이면 재방문
			if (latitude == 0 | longitude == 0) {
				return;
			}
			courses.put(course, probability);
			idx--;

		}
	}

}
