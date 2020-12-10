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
		tree.AddKeyValue(25, 25);
		tree.AddKeyValue(10, 10);
		tree.AddKeyValue(20, 20);
		tree.AddKeyValue(40, 40);
		tree.AddKeyValue(30, 30);
		tree.AddKeyValue(45, 45);
		tree.AddKeyValue(80, 80);
		tree.AddKeyValue(70, 70);
		tree.AddKeyValue(90, 90);
		tree.AddKeyValue(55, 55);
		tree.AddKeyValue(65, 65);
		
		return tree;
	}
	
	@Test
	public void deleteRoot() {
		BST<Integer> RootWithOneChild = new BST(null);
		RootWithOneChild.AddKeyValue(50, 50);
		RootWithOneChild.AddKeyValue(30, 30);
		RootWithOneChild.AddKeyValue(70, 70);
		assertTrue(RootWithOneChild.DeleteNodeByKey(50));
		assertTrue(RootWithOneChild.Root.NodeKey == 70);
		assertTrue(RootWithOneChild.DeleteNodeByKey(70));
		assertTrue(RootWithOneChild.Root.NodeKey == 30);
		assertTrue(RootWithOneChild.DeleteNodeByKey(30));
		assertTrue(RootWithOneChild.Root == null);
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
	}
	
	@Test
	public void AddKeyValue() {
		BST<Integer> tree = createTree();
		assertTrue(tree.FindNodeByKey(50).Node.RightChild.NodeValue == 80 && tree.FindNodeByKey(50).Node.LeftChild.NodeValue == 25);
		assertTrue(tree.FindNodeByKey(25).Node.RightChild.NodeValue == 40 && tree.FindNodeByKey(25).Node.LeftChild.NodeValue == 10);
		assertTrue(tree.FindNodeByKey(10).Node.RightChild.NodeValue == 20);
		assertTrue(tree.FindNodeByKey(80).Node.RightChild.NodeValue == 90 && tree.FindNodeByKey(80).Node.LeftChild.NodeValue == 70);
		assertTrue(tree.FindNodeByKey(55).Node.RightChild.NodeValue == 65);
	}
	
	
	@Test
	public void FindMinMax() {
		BST<Integer> tree = createTree();
		assertTrue(tree.FinMinMax(tree.Root, true).NodeValue == 90 && tree.FinMinMax(tree.Root, false).NodeValue == 10);
		assertTrue(tree.FinMinMax(tree.Root.RightChild, true).NodeValue == 90 && tree.FinMinMax(tree.Root.RightChild, false).NodeValue == 55);
		assertTrue(tree.FinMinMax(tree.Root.RightChild.RightChild, true).NodeValue == 90 && tree.FinMinMax(tree.Root.RightChild.RightChild, false).NodeValue == 90);
		assertTrue(tree.FinMinMax(tree.Root.LeftChild, true).NodeValue == 45 && tree.FinMinMax(tree.Root.LeftChild, false).NodeValue == 10);
	}
	
	
	@Test
	public void DeleteWithNoChilds() {
		BST<Integer> tree = createTree();
		tree.DeleteNodeByKey(20);
		assertTrue(tree.FindNodeByKey(10).Node.RightChild == null);
		assertTrue(tree.DeleteNodeByKey(10));
		assertTrue(tree.FindNodeByKey(25).Node.LeftChild == null);
		assertTrue(tree.DeleteNodeByKey(65));
		assertTrue(tree.FindNodeByKey(55).Node.RightChild == null);
		assertTrue(tree.DeleteNodeByKey(55));
		assertTrue(tree.DeleteNodeByKey(90));
		assertTrue(tree.FindNodeByKey(70).Node.LeftChild == null && tree.FindNodeByKey(80).Node.RightChild == null);
		assertTrue(tree.DeleteNodeByKey(50));
		assertTrue(tree.Root != null);
	}
	
	
	@Test
	public void DeleteWithTwoChild() {
		BST<Integer> tree = createTree();
		assertTrue(tree.DeleteNodeByKey(25));
		assertTrue(tree.DeleteNodeByKey(80));
		assertTrue(tree.Root.RightChild.equals(tree.FindNodeByKey(90).Node));
		assertTrue(tree.Root.LeftChild.equals(tree.FindNodeByKey(30).Node));
		assertTrue(tree.FindNodeByKey(25).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(80).NodeHasKey == false);
		tree.DeleteNodeByKey(50);
		tree.recTest(tree.Root);
		assertTrue(tree.FindNodeByKey(55).Node.equals(tree.Root));
		
		assertTrue(tree.FindNodeByKey(55).Node.LeftChild.equals(tree.FindNodeByKey(30).Node)
				&& tree.FindNodeByKey(55).Node.RightChild.equals(tree.FindNodeByKey(90).Node));
	
	}
	
	@Test
	public void DeleteWithOneChild() {
		BST<Integer> tree = createTree();
		assertTrue(tree.DeleteNodeByKey(10));
		assertTrue(tree.FindNodeByKey(25).Node.LeftChild.equals(tree.FindNodeByKey(20).Node));
		assertTrue(tree.DeleteNodeByKey(55));
		assertTrue(tree.FindNodeByKey(70).Node.LeftChild.equals(tree.FindNodeByKey(65).Node));
		assertTrue(tree.DeleteNodeByKey(70));
		assertTrue(tree.FindNodeByKey(80).Node.LeftChild.equals(tree.FindNodeByKey(65).Node));
		assertTrue(tree.FindNodeByKey(10).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(55).NodeHasKey == false);
		assertTrue(tree.FindNodeByKey(70).NodeHasKey == false);
	}

}
