package aBST;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitaBST {

	@Test
	public void add() {
		aBST tree = new aBST(4);
		assertTrue(tree.Tree.length == 15);
		assertTrue(tree.FindKeyIndex(50) == 0);
		tree.AddKey(50);
		tree.AddKey(25);
		tree.AddKey(75);
		tree.AddKey(37);
		tree.AddKey(62);
		tree.AddKey(82);
		assertTrue(tree.FindKeyIndex(31) == -9);
		tree.AddKey(31);
		assertTrue(tree.FindKeyIndex(31) == 9);
		tree.AddKey(43);
		tree.AddKey(55);
		assertTrue(tree.FindKeyIndex(92) == -14);
		tree.AddKey(92);
		
		assertTrue(tree.FindKeyIndex(20) == null);
		assertTrue(tree.Tree[3] == null);
		assertTrue(tree.Tree[7] == null);
		assertTrue(tree.Tree[8] == null);
		assertTrue(tree.Tree[12] == null);
		assertTrue(tree.Tree[13] == null);
	}
	
	public aBST makeTree() {
		aBST tree = new aBST(4);
		return tree;
	}

}
