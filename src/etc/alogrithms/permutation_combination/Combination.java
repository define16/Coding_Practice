package etc.permutation_combination;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {

	private static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Combination ex = new Combination();
        int[] arr = { 1, 2, 3, 4 }; // 집합
        int n = arr.length; // arr의 크기
        int r = 14; // 부분집합의 크기
        int[] combArr = new int[n]; // 조합으로 뽑고 
 
        ex.doCombination(combArr, n, r, 0, 0, arr);
        System.out.println("===" + " 크기(이상계수) : " + list.size() + " ===");
        for(String s : list) {
        	System.out.println(s);
        }
    }
 
	/**
	 * 
	 * @param combArr 부분 집합으로 뽑은 원소의 index
	 * @param n arr의 크기
	 * @param r 부분 집합의 크기
	 * @param index arr의 크기만큼 반복
	 * @param target 뽑은 arr의 원소의 index
	 * @param arr 집합
	 * 
	 * 조합을 뽑을 때 중복이 없는 경우
	 */
    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        System.out.println("=> "+n+" "+r+" "+index+" "+target);
        // r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
        if(r == 0){
            System.out.println(Arrays.toString(combArr));
            String tmp = "";
            for(int i=0; i<index; i++) {
            	System.out.print(arr[combArr[i]] + " ");
            	tmp += String.valueOf(arr[combArr[i]]);
            	if(i != index - 1) {
            		tmp += ",";
            	}          	
            }
            list.add(tmp);
            System.out.println();
         
        //끝까지 다 검사한 경우..1개를 뽑은 상태여도 실패한 경우임 무조건 return 으로 종료
        }else if(target == n){ 
            return;
        }else{
            combArr[index] = target; // 뽑은 원소의 index를 저장
            // (i) 뽑는 경우 
            // 뽑으니까, r-1
            // 뽑았으니 다음 index + 1 해줘야 함
            doCombination(combArr, n, r-1, index+1, target+1, arr);
             
            //(ii) 안 뽑는경우
            // 안뽑으니까 그대로 r
            // 안뽑았으니, index는 그대로!
            doCombination(combArr, n, r, index, target+1, arr); 
        }
	}

}
