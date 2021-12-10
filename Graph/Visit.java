import java.util.*;

public class Visit {

	public static class Node{
		
		public String data;
		
		public Node lchild;
		
		public Node rchild;
		
		public int ltag;
		
		public int rtag;
		
	}
	
	public static void pre_order(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			pre_order(root.lchild);
			pre_order(root.rchild);
		}
	}
	
	public static void in_order(Node root) {
		if(root != null) {
			in_order(root.lchild);
			System.out.print(root.data + " ");
			in_order(root.rchild);
		}
	}
	
	public static void post_order(Node root) {
		if(root != null) {
			post_order(root.lchild);
			post_order(root.rchild);
			System.out.print(root.data + " ");
		}
	}
	
	public static void level_order(Node root) {
		if(root != null) {
			ArrayList<Node> queue = new ArrayList<Node>();
			queue.add(root);
			
			while(queue.isEmpty() == false) {
				Node head = queue.get(0);
				queue.remove(0);
				System.out.print(head.data + " ");
				
				if(head.lchild != null)
					queue.add(head.lchild);
				if(head.rchild != null)
					queue.add(head.rchild);
			}
		}
	}
	
	/*非递归实现中序遍历*/
	public static void inOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		
		while(p != null || stack.isEmpty() == false) {
			if(p != null) {
				stack.push(p);
				p = p.lchild;
			}
			else if(stack.isEmpty() == false) {
				p = stack.pop();
				System.out.print(p.data + " ");
				p = p.rchild;
			}
		}
	}
	
	/*以字符串"AB#C##D##"来表示一棵二叉树*/
	public static Node preCreate(String str) {
		if(str.length() > 0) {
			String s = str.charAt(0) + "";
			str = str.substring(1);
			
			if(s.equals("#")) {
				return null;
			}
			else {
				Node root = new Node();
				root.data = s;
				root.lchild = preCreate(str);
				root.rchild = preCreate(str);
				return root;
				
			}
		}
	}
	
	public static Node createBy(ArrayList<String> pre, ArrayList<String> in) {
		if(pre.size() > 0) {
			String s = pre.get(0);
			pre.remove(0);
			Node root = new Node();
			root.data = s;
			
			int index = in.indexOf(s);
			ArrayList<String> pre1 = new ArrayList<String>();
			ArrayList<String> pre2 = new ArrayList<String>();
			ArrayList<String> in1 = new ArrayList<String>();
			ArrayList<String> in2 = new ArrayList<String>();
			for(int i = 0; i < index; i++) {
				in1.add(in.get(i));
			}
			for(int i = index + 1; i < in.size(); i++) {
				in2.add(in.get(i));
			}
			for(int i = 0; i < in1.size(); i++) {
				pre1.add(pre.get(i));
			}
			for(int i = in1.size(); i < pre.size(); i++) {
				pre2.add(pre.get(i));
			}
			
			root.lchild = createBy(pre1, in1);
			root.rchild = createBy(pre2, in2);
			
			return root;
		}
		
		else {
			return null;
		}
	}
	
	public static int countLeaf(Node root) {
		if(root == null)
			return 0;
		else if(root.lchild == null && root.rchild == null)
			return 1;
		else
			return countLeaf(root.lchild) + countLeaf(root.rchild);
	}
	
	public static int depth(Node root) {
		if(root == null)
			return 0;
		else
			return Math.max(depth(root.lchild), depth(root.rchild)) + 1;
	}
	
	/*中序线索化链表的遍历*/
	public static void clue_in_order(Node root) {
		Node p = root;
		while(p != null) {
			while(p.ltag == 1)	p = p.lchild;
			
			boolean hasRight = false;
			while(p != null && hasRight == false) {
				System.out.print(p.data + " ");
				if(p.rtag == 1)
					hasRight = true;
				p = p.rchild;
			}
		}
	}
	
	/*生成中序线索链表*/
	public static void thread(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		Node pre = null;
		
		while(p != null || stack.isEmpty() == false) {
			if(p != null) {
				stack.push(p);
				p = p.lchild;
			}
			else if(stack.isEmpty() == false) {
				p = stack.pop();
				if(p.lchild == null) {
					p.ltag = 2;
					p.lchild = pre;
				}
				if(pre != null && pre.rchild == null) {
					pre.rtag = 2;
					pre.rchild = p;
				}
				pre = p;
				p = p.rchild;
			}
		}
	}
	
	/*非递归实现中序遍历*/
	public static void InOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		
		while(p != null || stack.isEmpty() == false) {
			if(p != null) {
				stack.push(p);
				p = p.lchild;
			}
			
			else if(stack.isEmpty() == false) {
				p = stack.pop();
				System.out.print(p.data + " ");;
				p = p.rchild;
			}
		}
	}
	
	
}
