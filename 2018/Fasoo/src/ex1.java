
public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex1 ex = new ex1();
		int data[] = {0,1,1,0,0};
		int answer =ex.solution(data);
		System.out.println(answer);
	}
// 0�� ���, 1�� ������
	  public int solution(int[] fence) {
	      int answer = 0;
	      int count[] = {0,0};

	      // ù��° ��Ÿ���� ���
	      for(int i=0;i<2; i++) {
		    int []flag = new int[fence.length]; //ĥ�ϸ� 1 ĥ���� ������ 0
    		if(fence[0] != i) {
    			count[i]++;
    			flag[0] = 1;
    		}
	    	  
    		for(int j = 1; j < fence.length; j++) {
    			int temp = fence[j-1];
    			
    			// ���� ĥ������
    			if(flag[j-1] == 1 && fence[j-1] == 0) {
    				temp += 1;
			    	if(temp == fence[j]) {
			    		flag[j] = 1;
			    		count[i]++;
			    	}
    			}
    			else if(flag[j-1] == 1 && fence[j-1] == 1) {
    				temp -= 1;
			    	if(temp == fence[j]) {
			    		flag[j] = 1;
			    		count[i]++;
			    	}
    			}
    			// ĥ�� ���� ������
    			else {
			    	if(temp == fence[j]) {
			    		flag[j] = 1;
			    		count[i]++;
			    	}
    			}
		    		  
		    }
	      }
	      
	      if(count[0] <= count[1]) {
	    	  answer = count[0];
	      }else {
	    	  answer = count[1];
	      }

	      
	      return answer;
	  }
	  
}