package PermutationAndCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
/**
 * 
 * ���� ���ϱ�
 * 
 * ����Լ��� ����
 * @author define16
 *
 */
public class Permutation {
	private static ArrayList<String> list = new ArrayList<String>();
	
	/**
	 * @param data ���� List
	 * @param index ���� List�� ũ��
	 * @param size ���ϴ� ������ ũ��
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

		String data[] = {"A", "B", "C", "D", "E"};
		int index = 0;
		int size = 3;
		
		p.perm(data, index, size);
		
		HashSet<String> check = new HashSet<String>(); // �ߺ�Ȯ�ο� Test
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			check.add(list.get(i)); // �ߺ�Ȯ�ο� Test
		}
	
		System.out.println("�� ���� : " + list.size() + ", " + check.size());
	}

}
