package Alogrithms.etc;


import java.util.ArrayList;
import java.util.List;

public class backtrack {

	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		backtracking(nums, ret, tmp);
		
		return ret;
	}
	// ������� �� Ž��
	public void backtracking(int[] nums, List<List<Integer>> ret, List<Integer> tmp) {
		//base case
		if(tmp.size() == nums.length) {
			System.out.print("backtracking base case log1 : " );
			for(int i:tmp) {
				System.out.print(i + " ");
			}
			System.out.println();
			ret.add(new ArrayList<Integer>(tmp));
			return;
		}
		//recursion
		for(int num:nums) {
			if(tmp.contains(num)) {
				System.out.println("backtracking recursion log4 : " + num);
				continue; // tmp�ȿ� ���� ���� ������(�ߺ� ����)
			}
			System.out.println("backtracking recursion log1 : " + num);
			tmp.add(num); // ���°� ����
			backtracking(nums, ret, tmp);
			System.out.print("backtracking recursion log2 : " );
			for(int i:tmp) {
				System.out.print(i + " ");
			}
			System.out.println();
			tmp.remove(tmp.size()-1); // ���� ����(�� ���� ��)
			System.out.print("backtracking recursion log3 : " );
			for(int i:tmp) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,3};
		backtrack bt = new backtrack();
		List<List<Integer>>	rets = bt.permute(nums);
		
		for(List<Integer> ret:rets) {
			for(int i:ret) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		

				

	}

}
