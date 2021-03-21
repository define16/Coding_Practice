package backjoon.Grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 백준알고리즘, 1969번, DNA <br>
 * https://www.acmicpc.net/problem/1969
 * @author define16
 *
 */
public class G_1969 {
	// public class Main
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String info[] = bf.readLine().split(" ");
		int dna_cnt = Integer.parseInt(info[0].trim());
		int dna_length = Integer.parseInt(info[1].trim());

		String dnas[] = new String[dna_cnt];
		HashMap<Character, Integer> nucleotides;
		int dnas_int[][] = new int[dna_cnt][dna_length];
		String small_DNA = "";
		int distance = 0;

		for (int i = 0; i < dna_cnt; i++) {
			dnas[i] = bf.readLine().trim();
		}

		for (int i = 0; i < dna_length; i++) {
			nucleotides = new HashMap<Character, Integer>();
			char key, tmp = 0;
			// 각 DNA끼리 비교
			for (int j = 0; j < dna_cnt; j++) {
				key = dnas[j].charAt(i);
				if (!nucleotides.containsKey(key)) { // 첫 뉴클레오티디면
					nucleotides.put(key, 1);
				} else {
					nucleotides.put(key, nucleotides.get(key) + 1);
				}
			}

			int max = 0; // 최적의 뉴클레오티드 찾을때
			System.out.println(i);

			// Hamming Distance의 합이 가장 작은 DNA
			for (int j = 0; j < dna_cnt; j++) {
				key = dnas[j].charAt(i);

				if (nucleotides.containsKey(key)) {
					dnas_int[j][i] = nucleotides.get(key);
				}

				if (max < dnas_int[j][i]) {
					tmp = key; // Hamming Distance의 합이 가장 작은 DNA 구하기 위해 사용
					max = dnas_int[j][i];
				} else if (max == dnas_int[j][i] && tmp > key) { // 같은 뉴클레오티드일 경우 알파벳 순서로 정해짐
					tmp = key;
				}

				System.out.format("key : %s, dnas_int[j][i] : %d, tmp : %c, distance : %d\n", key, dnas_int[j][i], tmp,
						distance);

			}
			small_DNA += String.valueOf(tmp);

			// Hamming Distance의 합
			for (char c : nucleotides.keySet()) {
				if (c != tmp) {
					distance += nucleotides.get(c);
				}
			}

		}

		System.out.println(small_DNA);
		System.out.println(distance);

	}

}
