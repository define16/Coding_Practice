package SamsungSWPratices.Chapter01;

public class Node {
    private int data;
    private Node left;
    private Node right;
  
    public int getData() {
    	return data;
    }
    
    public void setData(int data) {
    	this.data = data;
    }
    
    // 왼쪽 값
    public Node getLeft() {
    	return left;
    }
    public void setLeft(Node left) {
    	this.left = left;
    }
    
    // 오른쪽 값
    public Node getRight() {
    	return right;
    }
    
    public void setRight(Node right) {
    	this.right = right;
    }
}
