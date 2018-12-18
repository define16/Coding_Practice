package PermutationAndCombination;

import java.util.Collections;

public class Permutation {

	
	public void perm(String[] data, int index) {
		if (index == data.length-1) {
			for(int i=0; i<data.length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}else {
			for(int i = index; i < data.length; i++) {
				String temp = data[index];
				data[i]= data[index];
				data[index]= data[i];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
