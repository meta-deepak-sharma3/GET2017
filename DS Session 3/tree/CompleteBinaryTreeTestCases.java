/**
 * The class CompleteBinaryTreeTestCases has methods to test the class CompleteBinaryTree.
 */

package tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class CompleteBinaryTreeTestCases {
	CompleteBinaryTree<Integer> tree;

	/**
	 * This method creates the tree before test cases run.
	 */
	@Before
	public void initializeArrayList() {
		tree = new CompleteBinaryTree<>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
	}

	// This method tests the preOrder() method of CompleteBinaryTree class.
	@Test
	public void preOrderTestCase1() {
		assertEquals("1,2,4,5,3,6,7,", tree.preOrder());
	}

	// This method tests the preOrder() method of CompleteBinaryTree class.
	@Test
	public void preOrderTestCase2() {
		assertNotEquals("1,4,5,3,6,7,", tree.preOrder());
	}

	// This method tests the postOrder() method of CompleteBinaryTree class.
	@Test
	public void postOrderTestCase1() {
		assertEquals("4,5,2,6,7,3,1,", tree.postOrder());
	}

	// This method tests the postOrder() method of CompleteBinaryTree class.
	@Test
	public void postOrderTestCase2() {
		assertNotEquals("4,5,2,6,7,3,", tree.postOrder());
	}

	// This method tests the isMirror() method of CompleteBinaryTree class.
	@Test
	public void mirrorTreeTestCase1() {
		CompleteBinaryTree<Integer> tree2 = new CompleteBinaryTree<Integer>();
		tree2.add(1);
		tree2.add(3);
		tree2.add(2);
		tree2.add(7);
		tree2.add(6);
		tree2.add(5);
		tree2.add(4);
		assertEquals(true, tree.isMirror(tree2));
	}

	// This method tests the isMirror() method of CompleteBinaryTree class.
	@Test
	public void mirrorTreeTestCase2() {
		CompleteBinaryTree<Integer> tree2 = new CompleteBinaryTree<Integer>();
		tree2.add(1);
		tree2.add(2);
		tree2.add(4);
		tree2.add(9);
		tree2.add(6);
		tree2.add(5);
		tree2.add(4);
		assertNotEquals(true, tree.isMirror(tree2));
	}
}