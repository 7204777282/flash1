package com;

public class PrintDistance {
	public int findDistance(Node root, int n1, int n2) {
		int x = Pathlength(root, n1) - 1;
		int y = Pathlength(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).data;
		int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {

				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public Node findLCA(Node root, int n1, int n2) {
		if (root != null) {
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node left = findLCA(root.left, n1, n2);
			Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.left.left = new Node(9);
		root.right = new Node(3);
		root.right.right = new Node(1);
		root.right.right.right = new Node(6);
		root.right.right.left = new Node(4);
		PrintDistance i = new PrintDistance();
		System.out.println("Distance between 7 and 1 is : " + i.findDistance(root, 7, 1));
		System.out.println("Distance between 9 and 4 is : " + i.findDistance(root, 9, 4));
		System.out.println("Distance between 9 and 6 is : " + i.findDistance(root, 9, 6));
	}

}
