
class SimpleTreeNode<T> {
	public int NodeLevel;
	public T NodeValue;
	public SimpleTreeNode<T> Parent;
	public List<SimpleTreeNode<T>> Children;

	public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
		NodeValue = val;
		Parent = parent;
		Children = null;
	}
}

class SimpleTree<T> {
	public List<SimpleTreeNode<T>> treeNodes;
	public SimpleTreeNode<T> Root;
	public int count;
	public int Leaf;

	public SimpleTree(SimpleTreeNode<T> root) {
		Root = root;
		Root.NodeLevel = 0;
		treeNodes = new LinkedList<SimpleTreeNode<T>>();
		treeNodes.add(Root);
		count = 1;
		Leaf = 0;
	}

	public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {

		SimpleTreeNode<T> current = NewChild;
		if (ParentNode.NodeValue.equals(Root.NodeValue)) {
			if (Root.Children == null)
				Root.Children = new LinkedList<SimpleTreeNode<T>>();
			Root.Children.add(NewChild);
			current.Parent = Root;
			current.NodeLevel = Root.NodeLevel + 1;
			treeNodes.add(NewChild);
			return;
		}
		
		recSearch(Root, Root.Children, ParentNode, NewChild);
	
	}

	// getNode
	public List<SimpleTreeNode<T>> copyChildren(SimpleTreeNode<T> startNode, List<SimpleTreeNode<T>> list,
			SimpleTreeNode<T> searchingNode) {
		for (int i = 0; i < list.size(); i++) {
			SimpleTreeNode<T> res = list.get(i);
			if (res.NodeValue.equals(searchingNode.NodeValue))
				return res.Children;
			if (res.Children != null)
				copyChildren(res, res.Children, searchingNode);

		}
		return null;
	}

	// getNodesadd
	public void recSearch(SimpleTreeNode<T> startNode, List<SimpleTreeNode<T>> list) {
		for (int i = 0; i < list.size(); i++) {
			SimpleTreeNode<T> res = list.get(i);
			//System.out.println("Taking node: " + res.NodeValue);
			if (!treeNodes.contains(res))
				treeNodes.add(res);
			if (res.Children != null)
				recSearch(res, res.Children);

		}
		return;
	}

	public void leafC(SimpleTreeNode<T> startNode, List<SimpleTreeNode<T>> list){
		try {
			for (int i = 0; i < list.size(); i++) {
				SimpleTreeNode<T> res = list.get(i);
				if (res.Children != null)
					leafC(res, res.Children);
				else
					Leaf++;

			}
		} catch (Exception e) {
			// TODO: handle exception
			Leaf = 1;
		}
		
	}


	public void addNode(SimpleTreeNode<T> Parent, SimpleTreeNode<T> Child) {
		if (Parent.Children == null)
			Parent.Children = new LinkedList<SimpleTreeNode<T>>();
		Parent.Children.add(Child);
		Child.Parent = Parent;
		Child.NodeLevel = Parent.NodeLevel + 1;
		// treeNodes.add(Child);
	}

	// nodeToAdd
	public void recSearch(SimpleTreeNode<T> startNode, List<SimpleTreeNode<T>> list, SimpleTreeNode<T> searchingParent,
			SimpleTreeNode<T> NodeToAdd) {
		for (int i = 0; i < list.size(); i++) {
			SimpleTreeNode<T> res = list.get(i);
			if (res.NodeValue.equals(searchingParent.NodeValue)) {
				addNode(searchingParent, NodeToAdd);
			}
			if (res.Children != null) {
				recSearch(res, res.Children, searchingParent, NodeToAdd);
			}
		}
		return;
	}

	// deleting
	public void recSearch(SimpleTreeNode<T> startNode, List<SimpleTreeNode<T>> list, SimpleTreeNode<T> _nodeToRemove) {
		for (int i = 0; i < list.size(); i++) {
			SimpleTreeNode<T> res = list.get(i);
			if (res.NodeValue.equals(_nodeToRemove.NodeValue)) {
				_nodeToRemove.Children = null;
				list.remove(_nodeToRemove);
				treeNodes.remove(_nodeToRemove);
				return;
			} else if (res.Children != null) {
				recSearch(res, res.Children, _nodeToRemove);
			}

		}
		return;
	}

	public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
		if (Root.NodeValue.equals(NodeToDelete.NodeValue))
			return;
		recSearch(Root, Root.Children, NodeToDelete);
	}

	public List<SimpleTreeNode<T>> GetAllNodes() {
		treeNodes.clear();
		treeNodes.add(Root);
		recSearch(Root, Root.Children);
		for (int i = 1; i < treeNodes.size(); i++) {
			//System.out.print(treeNodes.get(i).NodeValue + " Parent: " + treeNodes.get(i).Parent.NodeValue + " Node Level: " + treeNodes.get(i).NodeLevel);
			//System.out.println();
		}
		return treeNodes;
	}

	public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
		List<SimpleTreeNode<T>> res = new LinkedList<SimpleTreeNode<T>>();
		List<SimpleTreeNode<T>> t = GetAllNodes();
		for (int i = 0; i < t.size(); i++) {
			if (val.equals(t.get(i).NodeValue))
				res.add(t.get(i));
		}
		return res;
	}

	public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
		SimpleTreeNode<T> tmp = new SimpleTreeNode(OriginalNode.NodeValue, null);
		tmp.Children = copyChildren(Root, Root.Children, OriginalNode);
		recSearch(Root, Root.Children, NewParent, tmp);
		DeleteNode(OriginalNode);
	}

	public int Count() {

		return treeNodes.size();
	}

	public int LeafCount() {
		Leaf = 0;
		leafC(Root, Root.Children);
		return Leaf;
	}

}
