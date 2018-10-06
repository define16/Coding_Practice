package SamsungSWPratices.Chapter01;

public class BinaryTreeSearch {
	static boolean isFind;

	// 전위식 순회
	public void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " ");
	    preOrder(root.getLeft());
	    preOrder(root.getRight());

	}
	// 중위식 순회
	public void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.getLeft());
	    System.out.print(root.getData() + " ");
	    inOrder(root.getRight());
	}

	// 후위식 순회
	public void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.getLeft());
	    postOrder(root.getRight());
	    System.out.print(root.getData() + " ");

	}
	
	// 찾는 원소의 인덱스를 반환하는 함수
	public int search(Node node, int findNum , int idx) {
		if (node == null)
			return idx;
		idx++;
		if(node.getData() == findNum) {
			isFind = true;
			return idx;
		}		
		if(!isFind) {
			idx = search(node.getLeft(),findNum ,idx);
		    System.out.print(node.getData() + " ");
		    idx = search(node.getRight(),findNum ,idx);
		}
		return idx;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 30;
		int[] input = {1,3,7,8,11,12,15,17,20,25,27,38,41,45,48,50,52,55,57,60,64,68,70,72,74,76,78,81,83,97};
		int findNumber = 50;
		int answer = 0;
		isFind = false;
		
		Node tree = new Node();
		BinaryTreeSearch binaryTreeSearch = new BinaryTreeSearch();
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.addNode(input[(size/2)-1]);
		for(int i = 0; i < size; i++) {
			if((size/2)-1 == i) {
				continue;
			}
			binaryTree.addNode(input[i]);
		}
		tree = binaryTree.getBinaryTree();
//		binaryTreeSearch.inOrder(tree);
		answer = binaryTreeSearch.search(tree, findNumber, 0);
		
		System.out.println("answer : " + answer);
	}

}
