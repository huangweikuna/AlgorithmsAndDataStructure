package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//为了实现结点的可比性   需要继承Comparable<E>
//在比较的时候调用 B.compareTo(A)  
//返回结果
//     >0 ---------> B > A     
//     =0 ---------> B = A  
//     >0 ---------> B < A  
public class BST<E extends Comparable<E>> {
	private class Node {
		public E e;
		public Node left, right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	public Node root;
	public int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		root = add(root, e);
	}

	private Node add(Node node, E e) {
		if (size == 0) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(e) < 0) {
			node.left = add(node.left, e);
		} else if (e.compareTo(e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}

	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(Node node, E e) {
		if (size == 0)
			return false;
		if (e.compareTo(e) == 0)
			return true;
		else if (e.compareTo(e) < 0)
			return contains(node.left, e);
		else
			return contains(node.right, e);
	}

	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.e);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void preOrderNR() {
		Stack<Node> stack = new Stack<Node>();
		if (root == null)
			return;
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.e);
			// 由于是栈 所以前序遍历需要返过来
			if (node.right != null)
				stack.push(node.right);
		    if (node.left != null)
				stack.push(node.left);
		}
	}

	public void levelOrder() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.remove();
			System.out.println(node.e);
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}

	public E minimun() {
		if (size == 0)
			return null;
		return minimun(root).e;
	}

	// 找到最左侧的数就是最小的数
	private Node minimun(Node node) {
		if (node.left == null)
			return node;
		return minimun(node.left);
	}

	// 寻找二分搜索树的最大元素
	public E maximum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		return maximum(root).e;
	}

	// 返回以node为根的二分搜索树的最大值所在的节点
	private Node maximum(Node node) {
		if (node.right == null)
			return node;
		return maximum(node.right);
	}

	public E removeMin() {
		E e = minimun();
		root = removeMin(root);
		return e;
	}

	private Node removeMin(Node node) {
		//如果删除的最左侧元素中含有右结点   则把右结点的值给到父结点的左结点
		if (node.left == null) {
			size--;
			Node rightNode = node.right;
			node.right = null;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	public void remove(E e) {
		root = remove(root,e);
	}
	private Node remove(Node node,E e) {
		if(node == null )
			return null;
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left,e);
			return node;
		}
		else if(e.compareTo(node.e) >0) {
			node.right = remove(node.right,e);
			return node;
		}
		else {//e.compareTo(node.e) == 0
			if(node.left == null) {
				Node rightNode = node.right;
				size -- ;
				node.right = null;
				return rightNode;
			}
			if(node.right == null) {
				Node leftNode = node.left;
				size --;
				node.left = null;
				return leftNode;
			}
			//待删除的点含有左右结点
			//用删除结点的右子树最小结点代替待删除结点
			Node su = minimun(node.right);	
			su.right = removeMin(node.right);
			su.left = node.left;
			node.right = node.left = null;
			return su;
		}
	}
	public static void main(String[] args) {
	}
}