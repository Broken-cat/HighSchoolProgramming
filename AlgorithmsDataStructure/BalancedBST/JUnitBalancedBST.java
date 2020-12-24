package BalancedBST;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitBalancedBST {

	@Test
	public void test() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		BalancedBST balancedBST= new BalancedBST();
		balancedBST.GenerateTree(arr);
		assertTrue(balancedBST.IsBalanced(balancedBST.Root));
		
	}

}
