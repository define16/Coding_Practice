package SCPC_2018;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = new int[200000];
		int a;
		Random r = new Random(); // 객체생성
		try {
			File file = new File("w.txt");
			BufferedWriter bff = new BufferedWriter(new FileWriter(file));

			for (int i = 0; i < 200000; i++) {
				a = r.nextInt(1000000000) + 1;
				
				bff.write(a + " ");
				 // a에 저장된 값을 화면에 출력

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
