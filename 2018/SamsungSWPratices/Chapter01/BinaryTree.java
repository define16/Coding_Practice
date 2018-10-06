package SamsungSWPratices.Chapter01;

import SamsungSWPratices.Chapter01.Node;

public class BinaryTree {

	public Node root;

	public Node getBinaryTree() {
		return root;
	}
	public void addNode(int value) {

		if (root == null) {
			Node node = new Node();
			node.setData(value);
			root = node; // root�� ���� ������, root�� ���� �ִ´�.

		} else {
          // root�� ������ ���, root �����ϱ� ���� �޼ҵ� ȣ��
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
