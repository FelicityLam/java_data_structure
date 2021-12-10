
public class Query {

	public static int biSearch(int[] a, int length, int key) {
		int low = 1;
		int high = length;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(a[mid] == key)
				return mid;
			else if(a[mid] < key) 
				low = mid + 1;
			else
				high = mid - 1;
		}
		return 0;
	}
	
	/*递归实现二叉排序树的查找*/
	public static class Node{
		public int data;
		
		public Node lchild;
		
		public Node rchild;
	}
	
	public static Node query(Node root, int key) {
		if(root == null)
			return null;
		
		if(root.data == key)
			return root;
		else if(root.data < key)
			return query(root.rchild, key);
		else
			return query(root.lchild, key);
	}
	
	/*非递归实现二叉排序树的查找*/
	public static Node query1(Node root, int key) {
		Node p = root;
		while(p != null) {
			if(key == p.data)
				return p;
			else if(key < p.data)
				p = p.lchild;
			else
				p = p.rchild;
		}
		return null;
	}
	
	/*递归实现二叉排序树的插入*/
	public static void insert(Node root, int key) {
		if(root == null) {
			Node node = new Node();
			node.data = key;
			root = node;
			return;
		}
		
		if(query(root, key) == null)
			return;
	
		if(key > root.data) {
			if(root.rchild == null) {
				Node node = new Node();
				node.data = key;
				root.rchild = node;
				return;
			}
			else
				insert(root.rchild, key);
		}
		else {
			if(root.lchild == null) {
				Node node = new Node();
				node.data = key;
				root.lchild = node;
				return;
			}
			else
				insert(root.lchild, key);
		}
	}
	
	/*递归实现二叉排序树结点的删除*/
	public static void deleteBST(Node root, int key) {
		if(query(root, key) == null)
			return;
		
		if(root.data == key)
			delete(root);
		else if(root.data > key)
			deleteBST(root.lchild, key);
		else
			deleteBST(root.rchild, key);
	}
	
	
}
