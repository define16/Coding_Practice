package Tree;

/**
 * @author define16
 * 
 * 서로소 집합
 *	Union(x,y)를 하면 x에 자식으로 y가 삽입
 *	Find(x)를 하면 x를 포함한 트리의 루트 번호를 돌려주는 구조
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
		
		System.out.println("1과 4는 연결 되어있나요? " + unionfind.isSameParent(1, 4));
		System.out.println("1과 8는 연결 되어있나요? " + unionfind.isSameParent(1, 8));
		
	}

}
