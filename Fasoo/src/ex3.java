
public class ex3 {
	private static int[] parent;
	
	public int find(int x) {
		if(parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
		
	}
	
	public void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if (a != b) { 
			parent[b] = a;	// y가 x보다 크면
			// 더 작은 값으로 넣어 줄 때 다음과 같이도 표현가능
//			if(x < y)
//				parent[b] = a;
//			else
//				parent[a] = b;
//			
		}
		
		
	}
	
	// 같은 부모를 갖는지 확인
	public boolean isSameParent(int x, int y) {
		int a = find(x);
		int b = find(y);
		if(a == b)
			return true;
		else
			return false;
	}
	
	
	public boolean solution(int[] serialization) {
		boolean answer = true;
		boolean flag = true; // 방향
		int nodeCount = 1; // -1개수 파악
		for(int i = 0; i < serialization.length;i++) {
			if(serialization[i] != -1) {
				nodeCount++;
				System.out.println("+ : " + nodeCount);
			}
			else {
				nodeCount--;
				System.out.println("- : " + nodeCount);
				flag = false;
			}
			if(nodeCount < 0) {
				answer = false;
				break;
			}
		}
	
        
        
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ex3 ex = new ex3();
		int data[] = {1, -1, 2, -1, -1, 3, -1, -1};

		boolean answer =ex.solution(data);
		System.out.println(answer);
	}

}
