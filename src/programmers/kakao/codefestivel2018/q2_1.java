package programmers.kakao.codefestivel2018;

import java.io.FileInputStream;
import java.util.Scanner;

public class q2_1 {
	public static void main(String args[]) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream(
				"D:\\Programing Folder\\Java\\Competition\\"
				+ "Kakao\\src\\KakaoCodeFestivel_2018\\q2_input.txt"));
		int N, K;
		int data[], data_3[] = null;
		double[] sd = null;
		int index = 0;
		int sum = 0;
		double avg;
		
		N = sc.nextInt();
		K = sc.nextInt();

		data = new int[N];
		data_3 = new int[K];
		sd = new double[N-K+1];

		for (int c = 0; c < N; c++) {
			data[c] = sc.nextInt();
		}

		for (int c = 0; c < N - K + 1; c++) {
			index = 0;
			sum = 0;
			for (int j = c; j < c + K; j++) {
				data_3[index] = data[j];
				index++;
				sum += data[j];
			}
			avg = sum / K;
			
//			sd[c] = standard_deviation(data_3);
		}

		System.out.println(min(sd));
	}

	public static double min(double data[]) {
		double min = data[0];
		for (int c = 1; c < data.length; c++)
			if (data[c] < min) min = data[c];
		return min;
	}

	public static double standard_deviation(int[] data) {
		double sum = 0, avg, dp, sd;
		for (int c = 0; c < data.length; c++) {
			sum += data[c];
		}
		avg = sum / data.length;
		sum = 0;
		for (int c = 0; c < data.length; c++) {
			sum += ((data[c] - avg) * (data[c] - avg));
		}
		dp = sum / data.length;
		sd = Math.sqrt(dp);
		return sd;
	}
}
