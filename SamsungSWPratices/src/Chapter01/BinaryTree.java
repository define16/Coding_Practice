package Chapter01;

import Chapter01.Node;

public class BinaryTree {

	public Node root;

	public Node getBinaryTree() {
		return root;
	}
	public void addNode(int value) {
		if (root == null) {
			Node node = new Node();
			node.setData(value);
			root = node; // root에 값이 없으면, root에 값을 넣는다.
		} else {
          // root가 존재할 경우, root 변경하기 위한 메소드 호출
			addNode(value, root); 
		}
	}
	public void addNode(int value, Node root) {
		if (value <= root.getData()) {
			if(root.getLeft() == null) {
				Node node = new Node();
				node.setData(value);
				root.setLeft(node);
			}else {
				addNode(value, root.getLeft());
			}
		}else {
			if(root.getRight() == null) {
				Node node = new Node();
				node.setData(value);
				root.setRight(node);
			}
			else{
				addNode(value, root.getRight());
			}

		}

	}

}
