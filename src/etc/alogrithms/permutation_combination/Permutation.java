package etc.permutation_combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
/**
 * 
 * 순열 구하기
 * 
 * 재귀함수로 구현
 * @author define16
 *
 */
public class Permutation {
	private static ArrayList<String> list = new ArrayList<String>();
	
	/**
	 * @param data 순열 List
	 * @param index 순열 List의 크기
	 * @param size 원하는 조합의 크기
	 */
	public void perm(String[] data, int index, int size) {
		String tmp = "";
		if (index == size) {
			for(int i=0; i<size; i++) {
				tmp += data[i] + " ";
			}
			list.add(tmp.trim());
		}else {
			for(int i = index; i < data.length; i++) {
				String temp = data[index];
				data[index] = data[i];
				data[i] = temp;
				
				perm(data, index+1, size);
				
				temp = data[i];
				data[i]= data[index];
				data[index]= temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Permutation p = new Permutation();

		String data[] = {"A", "B", "C", "D"};
		int index = 0;
		int size = 4;
		
		p.perm(data, index, size);
		
		HashSet<String> check = new HashSet<String>(); // 중복확인용 Test
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			check.add(list.get(i)); // 중복확인용 Test
		}
	
		System.out.println("총 갯수 : " + list.size() + ", " + check.size());
	}

}
