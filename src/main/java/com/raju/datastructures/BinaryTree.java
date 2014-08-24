package com.raju.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTree {

	private int data = -1;
	private BinaryTree leftNode;
	private BinaryTree rightNode;
	private BinaryTree parentNode;

	public BinaryTree(int data) {
		this.data = data;
	}

	public BinaryTree insert(int data) {
		BinaryTree tree = find(data);
		if (null != tree) {
			System.out.println("Data already Exists!");
			return tree;
		}
		if (this.data == -1) { // Root node
			this.data = data;
			return this;
		} else if (data > this.data) {
			if (this.rightNode == null) {
				this.rightNode = new BinaryTree(data);
				this.rightNode.parentNode = this;
				return this.rightNode;
			} else {
				return this.rightNode.insert(data);
			}
		} else {
			if (this.leftNode == null) {
				this.leftNode = new BinaryTree(data);
				this.leftNode.parentNode = this;
				return this.leftNode;
			} else {
				return this.leftNode.insert(data);
			}
		}
	}

	public BinaryTree remove(int data) {
		BinaryTree tree = find(data);
		if (null == tree) {
			return null;
		}
		BinaryTree parentNode = tree.parentNode;
		// Case 1: Leaf node.
		if (null == tree.leftNode && null == tree.rightNode) {
			if (null == parentNode) { // Root Node!
				return null;
			}
			if (parentNode.leftNode.data == data) {
				parentNode.leftNode = null;
			} else {
				parentNode.rightNode = null;
			}
		}
		// Case 2: Node with 1 child node
		else if (null == tree.leftNode || null == tree.rightNode) {
			BinaryTree childNode = null;
			if (null == tree.leftNode) {
				childNode = tree.rightNode;
			} else {
				childNode = tree.leftNode;
			}
			//ParentNode
			if (null == parentNode) {
				this.data = childNode.data;
				if (null == tree.leftNode) {
					this.rightNode = null;
				} else {
					this.leftNode = null;
				}
			}
			if (parentNode.leftNode.data == data) {
				parentNode.leftNode = childNode;
			} else {
				parentNode.rightNode = childNode;
			}
		}
		//Case 3: Node with 2 Children
		else {
			BinaryTree smallest = tree.rightNode.getSmallest();
			int temp = smallest.data;
			remove(temp);
			tree.data = temp;
		}
		return tree;
	}

	private BinaryTree getSmallest() {
		if (null == this.leftNode) {
			return this;
		} else {
			return this.leftNode.getSmallest();
		}
	}

	public int depth() {
		int leftNodeDepth = 1,rightNodeDepth = 1;
		if (this.leftNode != null) {
			leftNodeDepth += this.leftNode.depth();
		}
		if (this.rightNode != null) {
			rightNodeDepth += this.rightNode.depth();
		}
		return Math.max(leftNodeDepth, rightNodeDepth);
	}

	public void print() {
		Map<Integer, List<Integer>> depthData = new HashMap<Integer, List<Integer>>();
		List<Integer> currentDepthData = new ArrayList<Integer>();
		currentDepthData.add(this.data);
		List<BinaryTree> currentNodes = new LinkedList<BinaryTree>();
		currentNodes.add(this);
		List<BinaryTree> currentNodesWithBlanks = new LinkedList<BinaryTree>();
		currentNodesWithBlanks.add(this);
		depthData.put(0, currentDepthData);
		int depth = 1;
		while (currentNodes.size() != 0) {
			currentDepthData = new ArrayList<Integer>();
			List<BinaryTree> nextNodes = new LinkedList<BinaryTree>();
			List<BinaryTree> nextNodesWithBlanks = new LinkedList<BinaryTree>();
			for (BinaryTree node : currentNodesWithBlanks) {
				if (node == null) {
					currentDepthData.add(null);
					currentDepthData.add(null);
					nextNodesWithBlanks.add(null);
					nextNodesWithBlanks.add(null);
				} else {
					if (node.leftNode == null) {
						currentDepthData.add(null);
						nextNodesWithBlanks.add(null);
					} else {
						nextNodes.add(node.leftNode);
						nextNodesWithBlanks.add(node.leftNode);
						currentDepthData.add(node.leftNode.data);
					}
					if (node.rightNode == null) {
						currentDepthData.add(null);
						nextNodesWithBlanks.add(null);
					} else {
						nextNodes.add(node.rightNode);
						nextNodesWithBlanks.add(node.rightNode);
						currentDepthData.add(node.rightNode.data);
					}
				}
			}
			depthData.put(depth, currentDepthData);
			depth++;
			currentNodes = nextNodes;
			currentNodesWithBlanks = nextNodesWithBlanks;
		}
		for (Integer dep : depthData.keySet()) {
			int spacer = (int)Math.pow(2, depth);
			int spacing = spacer;
			int i = 0;
			for (Integer data : depthData.get(dep)) {
				System.out.printf("%"+spacing+"s", (null == data ? "":data));
				if (i == 0) {
					spacing = spacing * 2;
				}
				i++;
			}
			--depth;
			System.out.println();
		}
	}

	public BinaryTree find(int data) {
		if (this.data == -1) {
			return null;
		} else if (this.data == data) {
			return this;
		} else if (data > this.data) {
			if (null == rightNode) {
				return null;
			}
			return this.rightNode.find(data);
		} else {
			if (null == leftNode) {
				return null;
			}
			return this.leftNode.find(data);
		}
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(10);
		root.insert(5);
		root.insert(7);
		root.insert(15);
		root.insert(12);
		root.insert(17);
		root.insert(18);
		root.insert(4);
		root.print();
		System.out.println();

		root.remove(17);
		root.print();

		System.out.println();
		root.remove(10);
		root.print();
	}
}
