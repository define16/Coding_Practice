package Tree;

/**
 * @author define16
 * 
 * ���μ� ����
 *	Union(x,y)�� �ϸ� x�� �ڽ����� y�� ����
 *	Find(x)�� �ϸ� x�� ������ Ʈ���� ��Ʈ ��ȣ�� �����ִ� ����
 *
 */
public class UnionFind {
	private static int[] parent;

	public UnionFind(int size) {
		parent = new int[size];
	}
	
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionFind unionfind = new UnionFind(10);


		
		for (int i=0; i<10; i++)
			parent[i] = i;
		
		unionfind.union(1, 3);
		unionfind.union(1, 2);
		unionfind.union(5, 4);
		unionfind.union(2, 4);
		unionfind.union(7, 8);
		
		System.out.println("1�� 4�� ���� �Ǿ��ֳ���? " + unionfind.isSameParent(1, 4));
		System.out.println("1�� 8�� ���� �Ǿ��ֳ���? " + unionfind.isSameParent(1, 8));
		
	}

}
