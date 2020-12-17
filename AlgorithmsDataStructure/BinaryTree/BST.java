

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

//////////////To_left one time was used
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
		BSTFind<T> fNode = new BSTFind<T>(this.Root);
		if (Root == null) {
			fNode.NodeHasKey = false;
			return fNode;
		}
		fNode.NodeHasKey = true;
		while (fNode.Node.NodeKey != key) {
			if (fNode.Node.NodeKey > key) {
				if (fNode.Node.LeftChild != null)
					fNode.Node = fNode.Node.LeftChild;
				else {
					fNode.NodeHasKey = false;
					if (fNode.Node.NodeKey < key)
						fNode.ToLeft = false;
					else
						fNode.ToLeft = true;
					return fNode;
				}
			} else {
				if (fNode.Node.RightChild != null)
					fNode.Node = fNode.Node.RightChild;
				else {
					fNode.NodeHasKey = false;
					if (fNode.Node.NodeKey < key)
						fNode.ToLeft = false;
					else
						fNode.ToLeft = true;
					return fNode;
				}
				fNode.NodeHasKey = true;
			}
		}
		return fNode;
	}

	public boolean AddKeyValue(int key, T val) {
		BSTNode<T> nodeToAdd = new BSTNode<>(key, val, null);
		if (Root == null) {
			Root = nodeToAdd;
			return true;
		}
		BSTFind<T> current = FindNodeByKey(key);
		if (!current.NodeHasKey)
			if (current.ToLeft == false) {
				current.Node.RightChild = nodeToAdd;
				current.Node.RightChild.Parent = current.Node;
				return true;
			} else {
				current.Node.LeftChild = nodeToAdd;
				current.Node.LeftChild.Parent = current.Node;
				return true;
			}
		return false;
	}

	public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
		try {
			BSTFind<T> current = new BSTFind<T>(FromNode);
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
			if (currentNode.equals(Root)) {
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
			if (reciever.LeftChild == null && reciever.RightChild == null) {
				if (!currentNode.LeftChild.equals(reciever))
					currentNode.LeftChild.Parent = reciever;
				if (!currentNode.RightChild.equals(reciever))
					currentNode.RightChild.Parent = reciever;
				if (reciever.NodeKey > reciever.Parent.NodeKey)
					reciever.Parent.RightChild = null;
				else
					reciever.Parent.LeftChild = null;

				reciever.LeftChild = currentNode.LeftChild;
				reciever.RightChild = currentNode.RightChild;
				if (currentNode.equals(this.Root)) {
					this.Root = reciever;
					reciever.Parent = null;
				} else {

					if (reciever.NodeKey > currentNode.Parent.NodeKey) {
						currentNode.Parent.RightChild = reciever;
						;
					} else {
						currentNode.Parent.LeftChild = reciever;
					}
					reciever.Parent = currentNode.Parent;
				}
				return true;
			} else if (reciever.LeftChild == null && reciever.RightChild != null) {// 123123123
				if (reciever.NodeKey > reciever.Parent.NodeKey)
					reciever.Parent.RightChild = reciever.RightChild;
				else
					reciever.Parent.LeftChild = reciever.RightChild;
				reciever.RightChild.Parent = reciever.Parent;

				currentNode.LeftChild.Parent = reciever;
				currentNode.RightChild.Parent = reciever;
				reciever.LeftChild = currentNode.LeftChild;
				reciever.RightChild = currentNode.RightChild;
				if (currentNode.equals(this.Root)) {
					reciever.Parent = null;
					this.Root = reciever;
					currentNode = null;
					return true;
				} else {
					if (currentNode.NodeKey > currentNode.Parent.NodeKey) {
						currentNode.Parent.RightChild = reciever;
						reciever.Parent = currentNode.Parent;
					} else {
						currentNode.Parent.LeftChild = reciever;
						reciever.Parent = currentNode.Parent;
					}

				}

				return true;
			} else {
				if (reciever.RightChild != null) {
					reciever.RightChild.Parent = reciever.Parent;
					reciever.Parent.LeftChild = reciever.RightChild;
				}

				currentNode.LeftChild.Parent = reciever;
				currentNode.RightChild.Parent = reciever;
				reciever.LeftChild = currentNode.LeftChild;
				reciever.RightChild = currentNode.RightChild;
				if (currentNode.equals(this.Root))
					this.Root = reciever;
				return true;
			}
		}

		return false;
	}

	public void Show(BSTNode<T> _startNode) {
		System.out.println(_startNode.NodeKey);
		if (_startNode.LeftChild != null)
			Show(_startNode.LeftChild);
		if (_startNode.RightChild != null)
			Show(_startNode.RightChild);
	}

	public void recTest(BSTNode<T> _startNode) {
		// System.out.println(_startNode.NodeKey);
		count++;
		if (_startNode.LeftChild != null)
			recTest(_startNode.LeftChild);
		if (_startNode.RightChild != null)
			recTest(_startNode.RightChild);

	}

	public int Count() {
		count = 0;
		if (Root == null)
			return 0;
		recTest(Root);
		return count;
	}

	public ArrayList WideAllNodes() {
		ArrayList<BSTNode<T>> res = new ArrayList<BSTNode<T>>();
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(Root);
		while (!queue.isEmpty()) {
			BSTNode<T> node = queue.poll();
			res.add(node);
			if (node.LeftChild != null)
				queue.add(node.LeftChild);
			if (node.RightChild != null)
				queue.add(node.RightChild);
		}
		return res;
	}

	public ArrayList DeepAllNodes(int _order) {
		ArrayList<BSTNode<T>> res = new ArrayList<BSTNode<T>>();
		if(Root == null)return res;
		if(_order == 0) 
			postOrder(res, Root);
		if(_order == 1) 
			preOrder(res, Root);
		if(_order == 2) 
			inOrder(res, Root);
		return res;
	}

	private void inOrder(ArrayList<BSTNode<T>> _list, BSTNode<T> _startNode) {
		if (_startNode != null) {
			inOrder(_list, _startNode.LeftChild);
			_list.add(_startNode);
			inOrder(_list, _startNode.RightChild);
		}
	}

	private void preOrder(ArrayList<BSTNode<T>> _list, BSTNode<T> _startNode) {
		if (_startNode != null) {
			_list.add(_startNode);
			preOrder(_list, _startNode.LeftChild);
			preOrder(_list, _startNode.RightChild);
		}
	}

	private void postOrder(ArrayList<BSTNode<T>> _list, BSTNode<T> _startNode) {
		if (_startNode != null) {
			postOrder(_list, _startNode.LeftChild);
			postOrder(_list, _startNode.RightChild);
			_list.add(_startNode);
		}
	}

}
