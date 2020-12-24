package BalancedBST;

import java.util.*;

class BSTNode {
	public int NodeKey; 
	public BSTNode Parent; 
	public BSTNode LeftChild;
	public BSTNode RightChild; 
	public int Level; 

	public BSTNode(int key, BSTNode parent) {
		NodeKey = key;
		Parent = parent;
		LeftChild = null;
		RightChild = null;
	}
}

class BalancedBST {
	public BSTNode Root;

	public BalancedBST() {
		Root = null;
	}

	public void GenerateTree(int[] a) {
		Arrays.sort(a);
		Root = new BSTNode(a[a.length / 2], null);
		Root.Level = 0;
		Root = sortedArrayToBST(a, 0, a.length - 1, Root);
		Root.Parent = null;

	}

	public boolean IsBalanced(BSTNode root_node) {
		if (root_node == null)
			return true;
		int leftSubHeight = height(root_node.LeftChild);
		int rightSubHeigh = height(root_node.RightChild);
		if (Math.abs(leftSubHeight - rightSubHeigh) <= 1 && IsBalanced(root_node.LeftChild) && 
				IsBalanced(root_node.LeftChild))
			return true;
		return false;
	}
	
	
	int height(BSTNode node) 
    { 
        if (node == null) 
            return 0; 
        return 1 + Math.max(height(node.LeftChild), height(node.RightChild)); 
    } 


	BSTNode sortedArrayToBST(int arr[], int start, int end, BSTNode parent) {
		if (start > end) 
			return null;
		int mid = (start + end) / 2;
		BSTNode node = new BSTNode(arr[mid], parent);
		node.Level = parent.Level+1;
		node.LeftChild = sortedArrayToBST(arr, start, mid - 1, node);
		node.RightChild = sortedArrayToBST(arr, mid + 1, end, node);
		return node;
	}

}