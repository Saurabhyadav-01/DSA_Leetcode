/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (subRoot != null && root != null && subRoot.val == root.val) {
            boolean leftsubtree = isIdentical(root.left, subRoot.left);
            boolean rightsubtree = isIdentical(root.right, subRoot.right);
            return leftsubtree && rightsubtree;

        } else {
            return false;
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        

        if (subRoot == null) {

            return true;
        }

        if (root == null) {
            return false;

        }

        if (root.val == subRoot.val) {

            if (isIdentical(root, subRoot) == true) {
                return true;
                // KYUNKI AGAR IK BAAR IDENTICAL NHI HUA TOH YE POSSIBILITY H KI WASISA HI
                // SUBTREE KAHI AUR HOGA, KYUNKI MAIN TREE ME VALUE REPEAT HO SAKTI HAI

            }

        }

        boolean found1 = isSubtree(root.left, subRoot);
        boolean found2 = isSubtree(root.right, subRoot);

        return (found1 || found2);

    }

    }
