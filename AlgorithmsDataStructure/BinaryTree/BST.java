
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
		if(LeftChild == null && RightChild == null) return true;
		else return false;
	}
	
	public int ChildCount() {
		if(LeftChild == null && RightChild == null) return 0;
		if(LeftChild != null && RightChild != null) return 2;
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
		if(Root == null) {
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
		BSTNode<T> currentNode = current.Node; 
		BSTNode<T> reciever;// = FinMinMax(current.Node, false);
		if(current.NodeHasKey==false)return false;
		if(current.Node.isLeaf()) {
			if(current.Node.Parent.NodeKey > current.Node.NodeKey)
				current.Node.Parent.LeftChild = null;
			else
				current.Node.Parent.RightChild = null;
			if(current.Node.equals(Root))
				Root = null;
			current.Node.Parent = null;
			current.Node = null;
			return true;
		} else if (current.Node.ChildCount() == 1) {
			if(current.Node.LeftChild != null) 
				reciever = current.Node.LeftChild;
			else
				reciever = current.Node.RightChild;
			if(!current.Node.equals(Root)) {
				if(current.Node.NodeKey > current.Node.Parent.NodeKey) 
					current.Node.Parent.RightChild = reciever;
				else
					current.Node.Parent.LeftChild = reciever;
			}
			reciever.Parent = current.Node.Parent;
			if(current.Node.equals(Root))
				Root = reciever;
			current.Node = null;
			return true;
		} else {
			//find a reciever
			reciever = FinMinMax(current.Node.RightChild, false);
			
			//link reciever RightChild with recieverParent
			if(reciever.RightChild != null) {
				reciever.RightChild.Parent = reciever.Parent;
				reciever.Parent.LeftChild = reciever.RightChild;
			} else if (!reciever.Parent.equals(Root))
				reciever.Parent.LeftChild = null;
			
			if(!reciever.equals(current.Node.LeftChild))
				reciever.LeftChild = current.Node.LeftChild;
			if(!reciever.equals(current.Node.RightChild))
				reciever.RightChild = current.Node.RightChild;
			if(reciever.NodeKey < reciever.Parent.NodeKey)
				reciever.Parent.LeftChild = null;
			else
				reciever.Parent.RightChild = null;
			
			//making parent of deleting node reference to reciever 
			if(!current.Node.equals(Root)){
				if(current.Node.NodeKey > current.Node.Parent.NodeKey)
					current.Node.Parent.RightChild = reciever;
				else
					current.Node.Parent.LeftChild = reciever;
			} 
			
			if(current.Node.equals(Root)) {
				if(Root.LeftChild != null)
					Root.LeftChild.Parent = reciever;
				if(Root.RightChild != null)
					Root.RightChild.Parent= reciever;
				Root = reciever;
			}	else
				reciever.Parent = current.Node.Parent;
			current.Node = null;
			return true;
			
		}
		
	}

	public void Show(BSTNode<T> _startNode) {
		System.out.println(_startNode.NodeKey);
		if (_startNode.LeftChild != null) 
			Show(_startNode.LeftChild);
		if (_startNode.RightChild != null) 
			Show(_startNode.RightChild);	
	}
	
	
	
	public void recTest(BSTNode<T> _startNode) {
		System.out.println(_startNode.NodeKey);
		if(_startNode.LeftChild != null || _startNode.RightChild != null)
			count++;
		if (_startNode.LeftChild != null) 
			recTest(_startNode.LeftChild);
		if (_startNode.RightChild != null) 
			recTest(_startNode.RightChild);
			
	}
	
	
	
	public int Count() {
		count = 0;
		recTest(Root);
		return count;
	}

}
