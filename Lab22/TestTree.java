import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** class Tree
 *
 * A binary tree data structure that stores TreeNodes.
 * Can:
 *	add new TreeNodes to the tree,
 *	sum all the values in the tree,
 *	find minimum value in the tree,
 *	find total number of entries in the tree,
 *	find maximum depth of the tree.
 */
class Tree {
	/** class TreeNode - a private member class of Tree
	 *
	 * A node in class Tree.
	 * Stores a value, and references to zero, one, or two children.
	 */
	private class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int v) {
			value = v;
			left = null;
			right = null;
		}
		
		int value() { return value; }
	}

	//////
	////// Class members of Tree
	//////
	TreeNode root;

	//////
	////// Class methods
	//////
	public Tree() {
		root = null;
	}

	/** Add an int value to the tree
	 * @param input the int value to be added to the tree
	 */
	public void add(int input) {
		TreeNode n = new TreeNode(input);

		if (root == null) {
			root = n;
			return;
		}
		add(root, input);
	}

	private void add(TreeNode top, int v) {
		// Put the new node into the tree, in "sorted order".
		// Nodes are added "to the left" of nodes with greater values
		// and "to the right" of nodes with smaller values.
		//
		// 'top' should not be null
		if (v > top.value()) {
			if (top.right == null) {
				top.right = new TreeNode(v);
			} else {
				add(top.right, v);
			}
		} else {
			if (top.left == null) {
				top.left = new TreeNode(v);
			} else {
				add(top.left, v); //opposite of top right
			}
		}
	}

	public int sum() {
		return sum(root);
	}
	private int sum(TreeNode n) {
		 // Recursive case
		if (n == null) {
			return 0;
		}
		return n.value + sum(n.left) + sum(n.right);
	}

	public int size() {
		return size(root);
	}
	
	private int size(TreeNode n) {
		if (n == null) {
			return 0;
		}
		int leftsize = size(n.left);
		int rightsize = size(n.right);
		return leftsize+ rightsize ;
	}
	

	public int depth() {
		
		return depth(root);
	}
	
	private int depth(TreeNode n) {
		if (n == null) {
			return 0;
		} else {
			int leftdepth = depth(n.left);
			int rightdepth = depth(n.right);
			return leftdepth+rightdepth;
		}
	}
		
	/** @return minimum value stored in the tree.
	 *
	 * If the tree is empty, throw an Exception.
	 */
	public int min() throws Exception {
		if (root == null) { throw new Exception("TreeMin() called with null arg"); }
		
		TreeNode current = root;
	    while (current.left != null) {
	        current = current.left;
	    }
	    
	    return current.value;
	}
}


public class TestTree {
	public static void main(String[] args) throws Exception {
		
		if (args.length < 1) {
			System.err.println("ERROR: need a filename");
			System.exit(0);
		}
		Tree myTree = new Tree();
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String start;
            while ((start = br.readLine()) != null) {
                int num = Integer.parseInt(start);
                myTree.add(num);
            }
        } catch (IOException e) {
            System.err.println("ERROR: Invalid inputs");
        }catch(NumberFormatException e){
			System.err.println("ERROR: Invalid inputs");
		}	

		System.out.println("Sum is " + myTree.sum());
		System.out.println("Min is " + myTree.min());
		System.out.println("Size is " + myTree.size());
		System.out.println("Depth is " + myTree.depth());
	}
}
