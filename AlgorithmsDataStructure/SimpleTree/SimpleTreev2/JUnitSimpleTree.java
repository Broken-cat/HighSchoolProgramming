package SimpleTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitSimpleTree {

	@Before
	public void setUp() throws Exception {
	}

	SimpleTreeNode<Integer> node_L1;
	SimpleTreeNode<Integer> node2_L1;
	SimpleTreeNode<Integer> node3_L1;

	SimpleTreeNode<Integer> node_L2 = new SimpleTreeNode(2, null);
	SimpleTreeNode<Integer> node2_L2 = new SimpleTreeNode(3, null);
	SimpleTreeNode<Integer> node3_L2 = new SimpleTreeNode(5, null);
	SimpleTreeNode<Integer> node4_L2 = new SimpleTreeNode(6, null);
	SimpleTreeNode<Integer> node5_L2 = new SimpleTreeNode(7, null);
	SimpleTreeNode<Integer> node6_L2 = new SimpleTreeNode(9, null);

	SimpleTreeNode<Integer> node_L3 = new SimpleTreeNode(-1, null);
	SimpleTreeNode<Integer> node2_L3 = new SimpleTreeNode(10, null);
	SimpleTreeNode<Integer> node3_L3 = new SimpleTreeNode(-2, null);
	
	
	SimpleTreeNode<Integer> node_L4 = new SimpleTreeNode(88, null);
	SimpleTreeNode<Integer> node2_L4 = new SimpleTreeNode(99, null);
	SimpleTreeNode<Integer> node3_L5 = new SimpleTreeNode(123, null);
	SimpleTreeNode<Integer> node_L5 = new SimpleTreeNode(-1234, null);
	SimpleTreeNode<Integer> node2_L6 = new SimpleTreeNode(440, null);
	SimpleTreeNode<Integer> node3_L6 = new SimpleTreeNode(555, null);

	@Ignore
	public SimpleTree createTree() {
		SimpleTree<Integer> tree = new SimpleTree<Integer>(new SimpleTreeNode<Integer>(0, null));
		node_L1 = new SimpleTreeNode(1, tree.Root);
		node2_L1 = new SimpleTreeNode(4, tree.Root);
		node3_L1 = new SimpleTreeNode(8, tree.Root);
		tree.AddChild(tree.Root, node_L1); // 1
		tree.AddChild(tree.Root, node2_L1);// 2
		tree.AddChild(tree.Root, node3_L1);// 3

		// adding to parent 1 nodes: 2,3
		tree.AddChild(node_L1, node_L2);
		tree.AddChild(node_L1, node2_L2);

		// adding tp parent 4 nodes : 5, 6
		tree.AddChild(node2_L1, node3_L2);
		tree.AddChild(node2_L1, node4_L2);

		// adding to parent 8 nodes: 7,9
		tree.AddChild(node3_L1, node5_L2);
		tree.AddChild(node3_L1, node6_L2);

		//adding to 7: -1 and 10
		tree.AddChild(node5_L2, node_L3); // -1
		tree.AddChild(node5_L2, node2_L3); //

		
		return tree;

	}

	@Test
	public void add() {
		System.out.println("----------------add-------------");
		SimpleTree tree = createTree();
		tree.GetAllNodes();
		System.out.println("Nodes count: " + tree.Count());
		System.out.println("Leafs: " + tree.LeafCount());
	}

	@Test
	public void Delete() {
		System.out.println("----------------Deleting-------------");
		SimpleTree tree = createTree();
		tree.DeleteNode(node3_L1);
		tree.GetAllNodes();
		System.out.println("Nodes count: " + tree.Count());
		System.out.println("Leafs: " + tree.LeafCount());
	}
	
	
	@Test
	public void Move() {
		System.out.println("----------------Moving-------------");
		SimpleTree tree = createTree();
		tree.MoveNode(node2_L1, node_L3);
		tree.GetAllNodes();
		System.out.println("Nodes count: " + tree.Count());
		System.out.println("Leafs: " + tree.LeafCount());

	}

}
