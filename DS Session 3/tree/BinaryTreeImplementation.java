package tree;

public class BinaryTreeImplementation {

	public static void main(String[] args) {
		CompleteBinaryTree<Integer> tree = new CompleteBinaryTree<Integer>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
		System.out.println("Tree: " + tree.inOrder());
		System.out.println("PreOrder: ");
		System.out.println(tree.preOrder());
		System.out.println("Post order: ");
		System.out.println(tree.postOrder());

		CompleteBinaryTree<Integer> tree2 = new CompleteBinaryTree<Integer>();
		tree2.add(1);
		tree2.add(3);
		tree2.add(2);
		tree2.add(7);
		tree2.add(6);
		tree2.add(5);
		tree2.add(4);
		System.out.println("Tree2: " + tree2.inOrder());
		if (tree.isMirror(tree2)) {
			System.out.println("Mirror trees!!");
		} else {
			System.out.println("Not Mirror trees!!");
		}

		CompleteBinaryTree<Integer> tree3 = new CompleteBinaryTree<Integer>();
		tree3.add(1);
		tree3.add(2);
		tree3.add(7);
		tree3.add(6);
		tree3.add(5);
		tree3.add(4);
		System.out.println("Tree: " + tree3.inOrder());
		if (tree.isMirror(tree3)) {
			System.out.println("Mirror trees!!");
		} else {
			System.out.println("Not Mirror trees!!");
		}
	}
}