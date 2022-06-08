Problem 1 : Invert a binary tree.

            For example, given the following tree:

                a
               / \
              b   c
             / \  /
            d   e f
            should become:

              a
             / \
             c  b
             \  / \
              f e  d
             
Solution : class Solution {
            public TreeNode invertTree(TreeNode root) {
                if(root == null)
                    return null;

                TreeNode left = root.left;

                root.left = invertTree(root.right);
                root.right = invertTree(left);

                return root;
            }
        }
