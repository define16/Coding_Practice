package Grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 백준알고리즘, 5585번, 거스름돈 <br>
 * https://www.acmicpc.net/problem/5585
 * @author define16
 *
 */
public class G_5585 {
	// Class 이름을 Main 이라 정의해야함
	// public class Main 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int money = Integer.parseInt(bf.readLine().trim());
		int change = 1000 - money;
		int count = 0;
		int coins[] = { 500, 100, 50, 10, 5, 1 };

		for (int i = 0; i < coins.length; i++) {
			count += (change / coins[i]);
			change %= coins[i];
		}
		System.out.println(count);
	}

	public static void runtimeError() {
		Scanner scan = new Scanner(System.in);

		int money = scan.nextInt();

		int change = 1000 - money;
		int count = 0;

		int coins[] = { 500, 100, 50, 10, 5, 1 };

		for (int coin : coins) {
			while (change >= coin) {
				change -= coin;
				count++;
			}
		}
		System.out.println(count);
	}

}
