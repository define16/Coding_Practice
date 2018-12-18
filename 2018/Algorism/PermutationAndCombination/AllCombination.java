package PermutationAndCombination;

import java.util.HashSet;
import java.util.Set;

public class AllCombination {

	private Set<String> answer;
	
	public AllCombination() {
		answer = new HashSet<>();
	}
	
	
	public void pick(String[] data, int topick, int index, int end) {
		for(int i = 0; i < topick;i++) {
			if(index == end) {
				continue;
				
			}else if(index <= end) {

				
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllCombination ac = new AllCombination();

		String[] data = {"1","2","3"};
		ac.pick(data, 1 ,0, data.length);
//		for(int i = 0; i < data.length; i++) {
//			ac.pick(data, i);
//		}
		
	}

}
