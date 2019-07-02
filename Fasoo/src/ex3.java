
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
			parent[b] = a;	// y�� x���� ũ��
			// �� ���� ������ �־� �� �� ������ ���̵� ǥ������
//			if(x < y)
//				parent[b] = a;
//			else
//				parent[a] = b;
//			
		}
		
		
	}
	
	// ���� �θ� ������ Ȯ��
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
		boolean flag = true; // ����
		int nodeCount = 1; // -1���� �ľ�
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
