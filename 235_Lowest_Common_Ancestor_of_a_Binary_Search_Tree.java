/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // compare with root if one of them on the left side
 // and one of them on the right side
 // then return root
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        while (((root.val - p.val) * (root.val - q.val)) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}