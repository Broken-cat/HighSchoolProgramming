package BinaryTree;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JUntiTestbBST {

	@Before
	public void setUp() throws Exception {
	}

	public BST createTree() {
		BSTNode root = new BSTNode(50, 50, null);
		BST tree = new BST(root);
		assertTrue(tree.Count() == 0);
		tree.AddKeyValue(25, 25);
		//assertTrue(tree.Count() == 1);
		tree.AddKeyValue(10, 10);
		//assertTrue(tree.Count() == 2);
		tree.AddKeyValue(20, 20);
		//assertTrue(tree.Count() == 3);
		tree.AddKeyValue(40, 40);
		//assertTrue(tree.Count() == 3);
		tree.AddKeyValue(30, 30);
		assertTrue(tree.Count() == 4);
		tree.AddKeyValue(45, 45);
		assertTrue(tree.Count() == 4);
		tree.AddKeyValue(80, 80);
		assertTrue(tree.Count() == 4);
		tree.AddKeyValue(70, 70);
		assertTrue(tree.Count() == 5);
		tree.AddKeyValue(90, 90);
		assertTrue(tree.Count() == 5);
		tree.AddKeyValue(55, 55);
		assertTrue(tree.Count() == 6);
		tree.AddKeyValue(65, 65);
		assertTrue(tree.Count() == 7);
		return tree;
	}
	
	
	@Test
	public void CheckRootWork() {
		BST tree = new BST(null);
		assertTrue(tree.FindNodeByKey(40).NodeHasKey == false);
		tree.AddKeyValue(40, 40);
		assertTrue(tree.Root.NodeKey == 40);
		tree.DeleteNodeByKey(50);
		tree.DeleteNodeByKey(40);
		tree.AddKeyValue(40, 40);
		tree.FinMinMax(tree.Root, false);
		tree.FindNodeByKey(40);
		
		BST tree2 = createTree();
		tree2.Show(tree2.Root);
	}

	
	//trying to find a stackOverflow exception by creating and filling tree with random and then deleting nodes
	@Test
	public void finalTest() {
		for (int qwe = 0; qwe < 1000; qwe++) {
			BSTNode root = new BSTNode(500, 500, null);
			BST tree = new BST(root);
			int r = 1000;
			int[] nodes = new int[r];
			for (int i = 0; i < r; i++) {
				nodes[i] = (int) ((Math.random() * (1000 - 0)) + 0);
				//tree.Show(tree.Root);
				tree.Count();
			}

			for (int i = 0; i < r; i++) {
				int k = (int) ((Math.random() * (r - 0)) + 0);
				tree.AddKeyValue(nodes[k], nodes[k]);
			}

			for (int i = 0; i < r; i++) {
				int k = (int) ((Math.random() * (r - 0)) + 0);
				tree.FindNodeByKey(k);
				tree.DeleteNodeByKey(nodes[k]);
				//tree.Show(tree.Root);
				tree.Count();
			}
		}
	}
	
	@Test
	public void deleteAndAdd() {
		BSTNode root = new BSTNode(500, 500, null);
		BST tree = new BST(root);
		tree.DeleteNodeByKey(500);
		tree.AddKeyValue(80, 80);
		tree.AddKeyValue(90, 90);
		tree.Show(tree.Root);
		assertTrue(tree.FindNodeByKey(500).NodeHasKey == false);
		tree.FindNodeByKey(80);
	}

	@Test
	public void deleteRoot() {
		BST<Integer> RootWithOneChild = new BST(null);
		RootWithOneChild.AddKeyValue(50, 50);
		RootWithOneChild.Show(RootWithOneChild.Root);
		assertTrue(findStackOverFlow(RootWithOneChild));
		RootWithOneChild.AddKeyValue(30, 30);
		RootWithOneChild.Show(RootWithOneChild.Root);
		assertTrue(findStackOverFlow(RootWithOneChild));
		RootWithOneChild.AddKeyValue(70, 70);
		RootWithOneChild.Show(RootWithOneChild.Root);
		assertTrue(findStackOverFlow(RootWithOneChild));
		assertTrue(RootWithOneChild.DeleteNodeByKey(50));
		RootWithOneChild.Show(RootWithOneChild.Root);
		assertTrue(findStackOverFlow(RootWithOneChild));
	}

	@Test
	public void FindNodByKey() {
		BST<Integer> tree = createTree();
		assertTrue(tree.FindNodeByKey(10).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(25).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(20).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(40).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(30).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(45).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(80).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(70).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(90).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(55).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(65).NodeHasKey == true);
		assertTrue(tree.FindNodeByKey(0).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(99).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(34).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(67).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(100).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(3).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(14).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(17).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(57).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(34).NodeHasKey == false);
		assertTrue(tree.Count() == 7);
		assertTrue(findStackOverFlow(tree));
	}

	
	
	@Test
	public void AddKeyValue() {
		BSTNode root = new BSTNode(50, 50, null);
		BST<Integer> tree = new BST<Integer>(root);
		tree.AddKeyValue(80, 80);
		tree.AddKeyValue(90, 90);
		tree.AddKeyValue(100, 100);
		tree.AddKeyValue(110, 110);
		tree.AddKeyValue(120, 120);
		tree.AddKeyValue(130, 130);

		for (int i = 130; i >= 80; i -= 10) {
			tree.FindNodeByKey(i);
			tree.DeleteNodeByKey(i);
			tree.AddKeyValue(i, i);
		}

		tree.AddKeyValue(40, 40);
		tree.AddKeyValue(30, 30);
		tree.AddKeyValue(20, 20);
		tree.AddKeyValue(10, 10);
		tree.AddKeyValue(0, 0);
		tree.AddKeyValue(-10, -10);

		for (int i = -10; i <= 40; i += 10) {
			tree.FindNodeByKey(i);
			tree.DeleteNodeByKey(i);
			tree.AddKeyValue(i, i);
		}

		BST<Integer> tree2 = new BST<Integer>(root);
		tree2.AddKeyValue(30, 30);
		tree2.AddKeyValue(49, 49);
		for (int i = 49; i > 30; i--) {
			tree2.AddKeyValue(i, i);
		}

		for (int i = 30; i < 50; i++) {
			assertTrue(tree2.FindNodeByKey(i).NodeHasKey);
			tree2.DeleteNodeByKey(i);
			assertTrue(tree2.FindNodeByKey(i).NodeHasKey == false);
		}

		tree.AddKeyValue(80, 80);
		for (int i = 80; i > 50; i--) {
			tree2.AddKeyValue(i, i);
		}

		for (int i = 80; i > 50; i--) {
			assertTrue(tree2.FindNodeByKey(i).NodeHasKey);
			tree2.DeleteNodeByKey(i);
			assertTrue(tree2.FindNodeByKey(i).NodeHasKey == false);
		}

		for (int i = 80; i > 50; i--) {
			tree2.AddKeyValue(i, i);
		}

		for (int i = 50; i < 80; i++) {
			assertTrue(tree2.FindNodeByKey(i).NodeHasKey);
			tree2.DeleteNodeByKey(i);
			assertTrue(tree2.FindNodeByKey(i).NodeHasKey == false);
		}
	}

	@Test
	public void FindMinMax() {
		BST<Integer> tree = createTree();
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FinMinMax(tree.Root, true).NodeValue == 90 && tree.FinMinMax(tree.Root, false).NodeValue == 10);
		assertTrue(tree.FinMinMax(tree.Root.RightChild, true).NodeValue == 90
				&& tree.FinMinMax(tree.Root.RightChild, false).NodeValue == 55);
		assertTrue(tree.FinMinMax(tree.Root.RightChild.RightChild, true).NodeValue == 90
				&& tree.FinMinMax(tree.Root.RightChild.RightChild, false).NodeValue == 90);
		assertTrue(tree.FinMinMax(tree.Root.LeftChild, true).NodeValue == 45
				&& tree.FinMinMax(tree.Root.LeftChild, false).NodeValue == 10);
	}

	@Test
	public void DeleteWithNoChilds() {
		BST<Integer> tree = createTree();
		tree.DeleteNodeByKey(20);
		tree.Count();
		assertTrue(tree.FindNodeByKey(10).Node.RightChild == null);
		assertTrue(tree.DeleteNodeByKey(10));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(25).Node.LeftChild == null);
		assertTrue(tree.DeleteNodeByKey(30));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.DeleteNodeByKey(45));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.DeleteNodeByKey(40));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.DeleteNodeByKey(25));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.DeleteNodeByKey(65));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(55).Node.RightChild == null);
		assertTrue(tree.DeleteNodeByKey(55));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.DeleteNodeByKey(90));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.DeleteNodeByKey(70));
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.DeleteNodeByKey(80));
		tree.Count();
		tree.Show(tree.Root);
		assertTrue(tree.DeleteNodeByKey(50));
	}

	@Test
	public void DeleteWithTwoChild() {
		BST<Integer> tree = createTree();
		tree.DeleteNodeByKey(80);
		tree.Show(tree.Root);
		tree.DeleteNodeByKey(40);
		tree.Count();
		tree.DeleteNodeByKey(25);
		tree.Count();

	}

	@Test
	public void DeleteWithOneChild() {
		BST<Integer> tree = createTree();
		tree.DeleteNodeByKey(10);tree.Count();
		assertTrue(findStackOverFlow(tree));
		tree.DeleteNodeByKey(55);tree.Count();
		assertTrue(findStackOverFlow(tree));
		tree.DeleteNodeByKey(45);tree.Count();
		assertTrue(findStackOverFlow(tree));
		tree.DeleteNodeByKey(25);tree.Count();
		tree.Show(tree.Root);
		assertTrue(findStackOverFlow(tree));
	}

	@Test
	public void Delete() {
		BST<Integer> tree = createTree();
		tree.DeleteNodeByKey(50);tree.Count();
		assertTrue(findStackOverFlow(tree));
		tree.DeleteNodeByKey(55);tree.Count();
		assertTrue(findStackOverFlow(tree));
		tree.DeleteNodeByKey(65);tree.Count();
		assertTrue(findStackOverFlow(tree));
		tree.DeleteNodeByKey(70);tree.Count();
		tree.Show(tree.Root);
		tree.DeleteNodeByKey(80);tree.Count();
		tree.Show(tree.Root);
		tree.DeleteNodeByKey(90);tree.Count();
		tree.Show(tree.Root);
		tree.DeleteNodeByKey(25);tree.Count();
		tree.Show(tree.Root);
		tree.DeleteNodeByKey(20);tree.Count();
		tree.Show(tree.Root);
		tree.DeleteNodeByKey(40);tree.Count();
		tree.Show(tree.Root);
		tree.DeleteNodeByKey(45);tree.Count();
		tree.Show(tree.Root);

		tree = createTree();
		tree.DeleteNodeByKey(90);	tree.Count();
	
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(80).Node.RightChild == null && !(tree.FindNodeByKey(90).NodeHasKey));
		tree.DeleteNodeByKey(55);	tree.Count();
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(65).Node.Parent.equals(tree.FindNodeByKey(70).Node)
				&& !(tree.FindNodeByKey(55).NodeHasKey));
		tree.DeleteNodeByKey(25);	tree.Count();
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(10).Node.Parent.equals(tree.FindNodeByKey(30).Node)
				&& !(tree.FindNodeByKey(25).NodeHasKey));
		tree.DeleteNodeByKey(30);	tree.Count();
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(10).Node.Parent.equals(tree.FindNodeByKey(40).Node)
				&& !(tree.FindNodeByKey(30).NodeHasKey));
		tree.DeleteNodeByKey(40);	tree.Count();
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(10).Node.Parent.equals(tree.FindNodeByKey(45).Node)
				&& !(tree.FindNodeByKey(40).NodeHasKey));
		tree.DeleteNodeByKey(50);
		tree.Count();
		assertTrue(findStackOverFlow(tree));
		assertTrue(tree.FindNodeByKey(65).Node.equals(tree.Root));

	}

	public boolean findStackOverFlow(BST tree) {
		tree.FindNodeByKey(10);
		tree.FindNodeByKey(25);
		tree.FindNodeByKey(20);
		tree.FindNodeByKey(40);
		tree.FindNodeByKey(30);
		tree.FindNodeByKey(45);
		tree.FindNodeByKey(80);
		tree.FindNodeByKey(70);
		tree.FindNodeByKey(90);
		tree.FindNodeByKey(55);
		tree.FindNodeByKey(65);
		tree.FindNodeByKey(52);
		tree.FindNodeByKey(34);
		tree.FindNodeByKey(12);
		tree.FindNodeByKey(32);
		return true;
	}

}
