Problem 1 : Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

	For example, given the following preorder traversal:

	[a, b, d, e, c, f, g]

	And the following inorder traversal:

	[d, b, e, a, f, c, g]

	You should return the following tree:

	    a
	   / \
	  b   c
	 / \ / \
	d  e f  g
	
Solution :
	class Solution {
	    int idx = 0;
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
		return meth(preorder, inorder, 0, preorder.length-1);
	    }
	    
	    public TreeNode meth(int[] preorder, int[] inorder, int low, int high) {
		if(low > high)
		    return null;
		
		TreeNode root = new TreeNode(preorder[idx++]);
		
		if(low == high)
		    return root;
		
		//position is the index of preorder[idx] element in inorder
		int position = find(root.val, inorder, low, high);
		
		root.left = meth(preorder, inorder, low, position-1);
		root.right = meth(preorder, inorder, position+1, high);
		return root;
	    }
	    
	    public int find(int ele, int[] inorder, int low, int high) {
		
		for(int i = low; i <= high; i++) {
		    if(inorder[i] == ele)
		        return i;
		}
		return low;
	    }
	}
