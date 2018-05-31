package leetcode;

public class Node {
	int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
    
    public static void main(String[] args) {
		Node n0 = new Node(2);
		Node n1 = new Node(6);
		Node n2 = new Node(3);
		Node n3 = new Node(7);
		Node n4 = new Node(1);
		Node n5 = new Node(9);

	}
}
