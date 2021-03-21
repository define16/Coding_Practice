package programmers.kakao.codefestivel2018;


import java.io.FileInputStream;
import java.util.Scanner;

public class q1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("D:\\Programing Folder\\Java\\Competition\\Kakao\\src\\KakaoCodeFestivel_2018\\q1_input.txt"));
		int K = sc.nextInt();
		int[] money1 = { 5000000, 3000000, 2000000, 500000, 300000, 100000};
		int[] money2 = { 5120000, 2560000, 1280000, 640000, 320000};
		int[] mymoney = new int[2];
		for(int c = 0; c < K; c++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			

			if(a == 1) 
				mymoney[0] = money1[0];
			else if(a >= 2 && a <= 3)
				mymoney[0] = money1[1];
			else if(a >= 4 && a <= 6)
				mymoney[0] = money1[2];
			else if(a >= 7 && a <= 10)
				mymoney[0] = money1[3];
			else if(a >= 11 && a <= 15)
				mymoney[0] = money1[4];
			else if(a >= 16 && a <= 21)
				mymoney[0] = money1[5];
			else
				mymoney[0] = 0;
			
			if(b == 1) 
				mymoney[1] = money2[0];
			else if(b >= 2 && b <= 3)
				mymoney[1] = money2[1];
			else if(b >= 4 && b <= 7)
				mymoney[1] = money2[2];
			else if(b >= 8 && b <= 15)
				mymoney[1] = money2[3];
			else if(b >= 16 && b <= 31)
				mymoney[1] = money2[4];
			else
				mymoney[1] = 0;
			
			System.out.println(mymoney[0] + mymoney[1]);
			
		}

	}

}
