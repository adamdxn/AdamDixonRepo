package leetcode;

public class BinarySearchTree {

	Node root;
	
	BinarySearchTree(int key){
		this.root = new Node(key);
	}
	
	BinarySearchTree(){
		this.root = null;
	}
	
	void insert(int key){
		root = insertRec(root, key);
	}

	private Node insertRec(Node root, int key) {
		if(root == null){
			return new Node(key);
		}
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);
		
		return root;
	}
	
	public void printInOrder(){
		inOrder(root);
	}
	
	private void inOrder(Node root){
		if(root != null){
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
		}
	}
	
	public Node search(int key){
		return searchHelp(root,key);
	}
	
	private Node searchHelp(Node root, int key){
		if(root == null || root.key == key)
			return root;
		else if (key > root.key)
			return searchHelp(root.right, key);
		else
			return searchHelp(root.left, key);
	}
	
	public void delete(int key){
		root = deleteHelp(root, key);
	}
	
	private Node deleteHelp(Node root, int key){
		if(root == null)
			return root;
		return null;
	}
	
	public int findMin(){
		return findMinHelp(root).key;
	}
	
	public Node findMinHelp(Node root){
		if (root.left == null && root.right == null)
			return root;
		else if (root.left != null)
			return findMinHelp(root.left);
		else
			return findMinHelp(root.right);
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(9);
		bst.insert(0);
		bst.insert(-8);
		bst.insert(60);
		
	}
}
