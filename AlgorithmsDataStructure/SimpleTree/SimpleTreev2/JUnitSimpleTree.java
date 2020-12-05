package SimpleTree;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class JUnitSimpleTree {

	@Before
	public void setUp() throws Exception {
	}
	SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(0, null);
	SimpleTreeNode<Integer> node_L1 = new SimpleTreeNode<Integer>(1, root);;
	SimpleTreeNode<Integer> node2_L1 = new SimpleTreeNode<Integer>(4, root);;
	SimpleTreeNode<Integer> node3_L1 = new SimpleTreeNode<Integer>(8, root);;

	SimpleTreeNode<Integer> node_L2 = new SimpleTreeNode<Integer>(2, null);
	SimpleTreeNode<Integer> node2_L2 = new SimpleTreeNode<Integer>(3, null);
	SimpleTreeNode<Integer> node3_L2 = new SimpleTreeNode<Integer>(5, null);
	SimpleTreeNode<Integer> node4_L2 = new SimpleTreeNode<Integer>(6, null);
	SimpleTreeNode<Integer> node5_L2 = new SimpleTreeNode<Integer>(7, null);
	SimpleTreeNode<Integer> node6_L2 = new SimpleTreeNode<Integer>(9, null);

	SimpleTreeNode<Integer> node_L3 = new SimpleTreeNode<Integer>(-1, null);
	SimpleTreeNode<Integer> node2_L3 = new SimpleTreeNode<Integer>(10, null);
	SimpleTreeNode<Integer> node3_L3 = new SimpleTreeNode<Integer>(-2, null);
	
	
	SimpleTreeNode<Integer> node_L4 = new SimpleTreeNode<Integer>(88, null);
	SimpleTreeNode<Integer> node2_L4 = new SimpleTreeNode<Integer>(99, null);
	SimpleTreeNode<Integer> node3_L5 = new SimpleTreeNode(123, null);
	SimpleTreeNode<Integer> node_L5 = new SimpleTreeNode(-1234, null);
	SimpleTreeNode<Integer> node2_L6 = new SimpleTreeNode(440, null);
	SimpleTreeNode<Integer> node3_L6 = new SimpleTreeNode(555, null);

	SimpleTreeNode<Integer> q = new SimpleTreeNode<Integer>(1, node_L5);;
	SimpleTreeNode<Integer> w = new SimpleTreeNode<Integer>(4, root);;
	SimpleTreeNode<Integer> e = new SimpleTreeNode<Integer>(8, root);;

	SimpleTreeNode<Integer> a = new SimpleTreeNode<Integer>(2, null);
	SimpleTreeNode<Integer> s = new SimpleTreeNode<Integer>(3, null);
	SimpleTreeNode<Integer> d = new SimpleTreeNode<Integer>(5, null);
	SimpleTreeNode<Integer> z = new SimpleTreeNode<Integer>(6, null);
	SimpleTreeNode<Integer> x = new SimpleTreeNode<Integer>(7, null);
	SimpleTreeNode<Integer> c = new SimpleTreeNode<Integer>(9, null);

	SimpleTreeNode<Integer> r = new SimpleTreeNode<Integer>(-1, null);
	SimpleTreeNode<Integer> t = new SimpleTreeNode<Integer>(10, null);
	SimpleTreeNode<Integer> y = new SimpleTreeNode<Integer>(-2, null);
	

	public <T> SimpleTree<Integer> createTree() {
		SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
		
		tree.AddChild(root, node_L1); // 1
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
		
		tree.AddChild(node2_L2, node2_L4);
		//tree.AddChild(node4_L2, node_L1);
		
		return tree;
	}
	
	public  List<SimpleTreeNode<Integer>> fillList() {
		List<SimpleTreeNode<Integer>> testList = new LinkedList<>();
		testList.add(root);
		testList.add(node_L1);
		testList.add(node2_L1);
		testList.add(node3_L1);
		testList.add(node_L2);
		testList.add(node2_L2);
		testList.add(node3_L2);
		testList.add(node4_L2);
		testList.add(node5_L2);
		testList.add(node6_L2);
		testList.add(node_L3);
		testList.add(node2_L3);
		testList.add(q);
		return testList;
	}


	
	@Test
	public void AddChild() {
		SimpleTree<Integer> tree = createTree();
		assertTrue(tree.Root.Children.contains(node_L1) ); //1
		assertTrue(tree.Root.Children.contains(node2_L1) ); //4
		assertTrue(tree.Root.Children.contains(node3_L1) ); //8
		tree.recNodeT(tree.Root);
	}
	
	
	@Test
	public void DeleteChild() {
		SimpleTree<Integer> tree = createTree();
		tree.DeleteNode(node2_L1);
		tree.recNodeT(tree.Root);
	}
	
	
	@Test
	public void FindByValue() {
		SimpleTree<Integer> tree = createTree();
		List<SimpleTreeNode<Integer>> t = tree.FindNodesByValue(1);
		assertTrue(t.contains(node_L2));
		assertNull(tree.FindNodesByValue(99));
	}
	
	
	@Test
	public void GetAllNodes() {
		SimpleTree<Integer> tree = createTree();
		List<SimpleTreeNode<Integer>> t = tree.GetAllNodes();
		assertTrue(t.contains(node4_L2));
		assertTrue(t.contains(node_L2));
		assertTrue(t.contains(node2_L2));
		assertTrue(t.contains(node3_L2));
		assertTrue(t.contains(node4_L2));
		for(int i = 0; i < t.size(); i++) {
			if(!t.get(i).NodeValue.equals(node2_L3.NodeValue))continue;
			assertTrue(t.get(i).NodeValue.equals(node2_L3.NodeValue));
		}
	}
	
	
	@Test
	public void Move() {
		SimpleTree<Integer> tree = createTree();
		tree.MoveNode(node2_L1, node_L1);
		assertTrue(tree.FindNodesByValue(1).contains(node2_L1));
		List<SimpleTreeNode<Integer>> t = tree.FindNodesByValue(8);
		for (int i = 0; i < t.size(); i++)System.out.println(t.get(i).NodeValue);
		tree.recNodeT(tree.Root);
	}
}
