Problem : Determine whether a tree is a valid binary search tree.

          A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child 
          must be less than or equal to the root and the key in the right child must be greater than or equal to the root.

Solution : 
            class Solution {
                public boolean isValidBST(TreeNode root) {

                    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);

                }
              
                public boolean validate(TreeNode root, long min, long max) {
                    if(root == null)
                        return true;

                    /* Checking if the node value exists in between the lower and upper limits, if it satisfies then 
                        limit the upper limit for left nodes to root.val and lower limit for right nodes to root.val
                        */
                    if(root.val > min && root.val < max) 
                        return validate(root.left, min, root.val) && validate(root.right, root.val, max);

                    return false;
                }
            }
