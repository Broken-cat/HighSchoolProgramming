

class BSTNode<T> {
	public int ChildsCount;
	public int NodeKey;
	public T NodeValue;
	public BSTNode<T> Parent;
	public BSTNode<T> LeftChild;
	public BSTNode<T> RightChild;
	public boolean isLeaf;

	public BSTNode(int key, T val, BSTNode<T> parent) {
		NodeKey = key;
		NodeValue = val;
		Parent = parent;
		LeftChild = null;
		RightChild = null;
		ChildsCount = 0;
	}

	public boolean isLeaf() {
		if (LeftChild == null && RightChild == null)
			return true;
		else
			return false;
	}

	public int ChildCount() {
		if (LeftChild == null && RightChild == null)
			return 0;
		if (LeftChild != null && RightChild != null)
			return 2;
		return 1;
	}
}

class BSTFind<T> {

	public BSTNode<T> Node;

	public boolean NodeHasKey;

	public boolean ToLeft;

	public BSTFind(BSTNode<T> _node) {
		Node = _node;
	}
}

public class BST<T> {
	BSTNode<T> Root;
	private int count;

	public BST(BSTNode<T> node) {
		Root = node;
		count = 0;
	}

	public BSTFind<T> FindNodeByKey(int key) {
		BSTNode<T> current = Root;
		BSTFind<T> fNode = new BSTFind<T>(current);
		fNode.NodeHasKey = true;
		while (fNode.Node.NodeKey != key) {
			if (fNode.Node.NodeKey > key) {
				if (fNode.Node.LeftChild != null)
					fNode.Node = fNode.Node.LeftChild;
				else {
					fNode.NodeHasKey = false;
					return fNode;
				}
			} else {
				if (fNode.Node.RightChild != null)
					fNode.Node = fNode.Node.RightChild;
				else {
					fNode.NodeHasKey = false;
					return fNode;
				}
				fNode.NodeHasKey = true;
			}
		}
		current = fNode.Node;
		return fNode;
	}

	public boolean AddKeyValue(int key, T val) {
		BSTNode<T> nodeToAdd = new BSTNode(key, val, null);
		if (Root == null) {
			Root = nodeToAdd;
			return true;
		}
		BSTFind<T> current = FindNodeByKey(key);
		if (!current.NodeHasKey)
			if (nodeToAdd.NodeKey > current.Node.NodeKey) {
				current.Node.RightChild = nodeToAdd;
				nodeToAdd.Parent = current.Node;
				return true;
			} else {
				current.Node.LeftChild = nodeToAdd;
				nodeToAdd.Parent = current.Node;
				return true;
			}
		return false;
	}

	public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
		try {
			BSTFind<T> current = new BSTFind(FromNode);
			if (FindMax) {
				while (current.Node.RightChild != null)
					current.Node = current.Node.RightChild;
				return current.Node;
			} else {
				while (current.Node.LeftChild != null)
					current.Node = current.Node.LeftChild;
				return current.Node;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public boolean DeleteNodeByKey(int key) {
		BSTFind<T> current = FindNodeByKey(key);
		if (current.NodeHasKey == false)
			return false;
		BSTNode<T> currentNode = current.Node;
		BSTNode<T> reciever;// = FinMinMax(current.Node, false);
		if (currentNode.ChildCount() == 0) {
			if(currentNode.equals(Root)) {
				currentNode = null;
				Root = null;
				return true;
			}
			if (currentNode.Parent.LeftChild != null && currentNode.Parent.LeftChild.equals(currentNode))
				currentNode.Parent.LeftChild = null;
			else
				currentNode.Parent.RightChild = null;
			currentNode = null;
			return true;
		}
		if (currentNode.ChildCount() == 1) {
			if (!currentNode.equals(Root)) {
				if (currentNode.NodeKey > currentNode.Parent.NodeKey) {
					if (currentNode.LeftChild != null) {
						currentNode.Parent.RightChild = currentNode.LeftChild;
						currentNode.LeftChild.Parent = currentNode.Parent;
					} else {
						currentNode.Parent.RightChild = currentNode.RightChild;
						currentNode.RightChild.Parent = currentNode.Parent;
					}
				} else {
					if (currentNode.LeftChild != null) {
						currentNode.Parent.LeftChild = currentNode.LeftChild;
						currentNode.LeftChild.Parent = currentNode.Parent;
					} else {
						currentNode.Parent.LeftChild = currentNode.RightChild;
						currentNode.RightChild.Parent = currentNode.Parent;
					}
				}
			} else {
				if (currentNode.LeftChild != null) {
					currentNode.LeftChild.Parent = null;
					Root = currentNode.LeftChild;
				} else {
					currentNode.RightChild.Parent = null;
					Root = currentNode.RightChild;
				}

			}
			currentNode = null;
			return true;
		} else if (currentNode.ChildCount() == 2) {
			reciever = FinMinMax(currentNode.RightChild, false);
			if(reciever.LeftChild == null && reciever.RightChild == null) {
				reciever.LeftChild = currentNode.LeftChild;
				reciever.RightChild = currentNode.RightChild;
				reciever.RightChild = null;
				if(currentNode.equals(Root)) {
					Root = reciever;
				} else {
					if(reciever.NodeKey > reciever.Parent.NodeKey) {
						currentNode.Parent.RightChild = reciever;;
					} else {
						currentNode.Parent.LeftChild = reciever;
					}
				}
					
				
				return true;
			} else if (reciever.LeftChild == null && reciever.RightChild != null) {
				reciever.RightChild.Parent = reciever.Parent;
				if(reciever.NodeKey > reciever.Parent.NodeKey)
					reciever.Parent.RightChild = reciever.RightChild;
				else
					reciever.Parent.LeftChild = reciever.RightChild;
				reciever = null;
				return true;
			} else {
				if(reciever.RightChild != null) {
					reciever.RightChild.Parent = reciever.Parent;
					reciever.Parent.LeftChild = reciever.RightChild;
				}
				reciever.LeftChild = currentNode.LeftChild;
				reciever.RightChild = currentNode.RightChild;
				if(currentNode.equals(Root))
					Root = reciever;
				return true;
			}
		}

		return false;
	}

	public void Show(BSTNode<T> _startNode) {
	//	System.out.println(_startNode.NodeKey);
		if (_startNode.LeftChild != null)
			Show(_startNode.LeftChild);
		if (_startNode.RightChild != null)
			Show(_startNode.RightChild);
	}

	public void recTest(BSTNode<T> _startNode) {
		System.out.println(_startNode.NodeKey);
		if (_startNode.LeftChild != null || _startNode.RightChild != null)
			count++;
		if (_startNode.LeftChild != null)
			recTest(_startNode.LeftChild);
		if (_startNode.RightChild != null)
			recTest(_startNode.RightChild);

	}

	public int Count() {
		count = 0;
		if(Root == null) return 0;
		recTest(Root);
		return count;
	}

}
