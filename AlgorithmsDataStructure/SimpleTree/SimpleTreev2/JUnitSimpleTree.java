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
	SimpleTreeNode<Integer> node3_L5 = new SimpleTreeNode(99, null);
	SimpleTreeNode<Integer> node_L5 = new SimpleTreeNode(-11, null);
	SimpleTreeNode<Integer> node2_L6 = new SimpleTreeNode(17, null);
	SimpleTreeNode<Integer> node3_L6 = new SimpleTreeNode(25, null);

	SimpleTreeNode<Integer> q = new SimpleTreeNode<Integer>(32, node_L5);;
	SimpleTreeNode<Integer> w = new SimpleTreeNode<Integer>(67, root);;
	SimpleTreeNode<Integer> e = new SimpleTreeNode<Integer>(54, root);;

	SimpleTreeNode<Integer> a = new SimpleTreeNode<Integer>(37, null);
	SimpleTreeNode<Integer> s = new SimpleTreeNode<Integer>(3, null);
	SimpleTreeNode<Integer> d = new SimpleTreeNode<Integer>(5, null);
	SimpleTreeNode<Integer> z = new SimpleTreeNode<Integer>(6, null);
	SimpleTreeNode<Integer> x = new SimpleTreeNode<Integer>(7, null);
	SimpleTreeNode<Integer> c = new SimpleTreeNode<Integer>(9, null);

	SimpleTreeNode<Integer> r = new SimpleTreeNode<Integer>(-1, null);
	SimpleTreeNode<Integer> t = new SimpleTreeNode<Integer>(10, null);
	SimpleTreeNode<Integer> y = new SimpleTreeNode<Integer>(0, null);
	

	public <T> SimpleTree<Integer> createTree() {
		SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
		
		tree.AddChild(root, node_L1); // 1
		assertTrue(tree.GetAllNodes2().size() == 2 && tree.LeafCount() == 1 && tree.GetAllNodes2().contains(node_L1));
		tree.AddChild(tree.Root, node2_L1);// 2
		assertTrue(tree.GetAllNodes2().size() == 3 && tree.LeafCount() == 2 && tree.GetAllNodes2().contains(node2_L1));
		tree.AddChild(tree.Root, node3_L1);// 3
		assertTrue(tree.GetAllNodes2().size() == 4 && tree.LeafCount() == 3 && tree.GetAllNodes2().contains(node3_L1));

		// adding to parent 1 nodes: 2,3
		tree.AddChild(node_L1, node_L2);
		assertTrue(tree.GetAllNodes2().size() == 5 && tree.LeafCount() == 3 && tree.GetAllNodes2().contains(node_L2));
		tree.AddChild(node_L1, node2_L2);
		assertTrue(tree.GetAllNodes2().size() == 6 && tree.LeafCount() == 4 && tree.GetAllNodes2().contains(node2_L2));

		// adding tp parent 4 nodes : 5, 6
		tree.AddChild(node2_L1, node3_L2);
		assertTrue(tree.GetAllNodes2().size() == 7 && tree.LeafCount() == 4 && tree.GetAllNodes2().contains(node3_L2));
		tree.AddChild(node2_L1, node4_L2);
		assertTrue(tree.GetAllNodes2().size() == 8 && tree.LeafCount() == 5 && tree.GetAllNodes2().contains(node4_L2));

		// adding to parent 8 nodes: 7,9
		tree.AddChild(node3_L1, node5_L2);
		assertTrue(tree.GetAllNodes2().size() == 9 && tree.LeafCount() == 5 && tree.GetAllNodes2().contains(node5_L2));
		tree.AddChild(node3_L1, node6_L2);
		assertTrue(tree.GetAllNodes2().size() == 10 && tree.LeafCount() == 6 && tree.GetAllNodes2().contains(node6_L2));

		//adding to 7: -1 and 10
		tree.AddChild(node5_L2, node_L3); // -1
		assertTrue(tree.GetAllNodes2().size() == 11 && tree.LeafCount() == 6 && tree.GetAllNodes2().contains(node_L3));
		tree.AddChild(node5_L2, node2_L3); //
		assertTrue(tree.GetAllNodes2().size() == 12 && tree.LeafCount() == 7 && tree.GetAllNodes2().contains(node2_L3));
		
		//adding to 2:11 17
		tree.AddChild(node_L2, node_L5);
		tree.AddChild(node_L2, node2_L6);
		
		//adding to 17: 25 
		tree.AddChild(node2_L6, node3_L6);
		
		//adding to 6
		tree.AddChild(node4_L2, q);
		tree.AddChild(q, w);
		tree.AddChild(q, e);
		tree.AddChild(e, a);
		tree.GetAllNodes2();
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
		tree.Count();
		tree.LeafCount();
		//tree.recNodeT(tree.Root);
	//	assertTrue(tree.Count() == 13);
		//assertTrue(tree.LeafCount() == 6);
	}
	
	
	@Test
	public void DeleteChild() {
		SimpleTree<Integer> tree = createTree();
		tree.DeleteNode(node2_L1);
		tree.DeleteNode(new SimpleTreeNode(909090, null));
		//tree.recNodeT(tree.Root);
	}
	
	
	@Test
	public void FindByValue() {
		SimpleTree<Integer> tree = createTree();
		List<SimpleTreeNode<Integer>> t = tree.FindNodesByValue(1);
		assertTrue(t.contains(node_L1));
		//assertNull(tree.FindNodesByValue(99));
		
		SimpleTree<Integer> tree2 = new SimpleTree<Integer>(new SimpleTreeNode(20, null));
		assertTrue(tree2.FindNodesByValue(20).contains(tree2.Root));
	}
	
	
	@Test
	public void GetAllNodes() {
		SimpleTree<Integer> tree = createTree();
		List<SimpleTreeNode<Integer>> t = tree.GetAllNodes();
		List<SimpleTreeNode<Integer>> t2 = tree.GetAllNodes2();
		assertTrue(t.contains(tree.Root));
		assertTrue(t.contains(node_L2));
		assertTrue(t.contains(node2_L2));
		assertTrue(t.contains(node3_L2));
		assertTrue(t.contains(node4_L2));
		for(int i = 0; i < t.size(); i++) {
			if(!t.get(i).NodeValue.equals(node2_L3.NodeValue))continue;
			assertTrue(t.get(i).NodeValue.equals(node2_L3.NodeValue));
		}
		
		
		SimpleTree<Integer> treeSolo = new SimpleTree<Integer>(null);
		treeSolo.AddChild(null, new SimpleTreeNode(20, null));
		assertTrue(treeSolo.LeafCount() == 1 && treeSolo.Count() == 1);
	}
	
	
	@Test
	public void Move() {
		SimpleTree<Integer> tree = createTree();
		tree.MoveNode(node2_L1, node_L1);
		//assertTrue(tree.FindNodesByValue(1).contains(node2_L1));
		List<SimpleTreeNode<Integer>> t = tree.FindNodesByValue(8);
	gg
		assertTrue(t.contains(node3_L1));
	//	assertTrue(t.contains(node6_L2));
	//	tree.recNodeT(tree.Root);
	}
}
