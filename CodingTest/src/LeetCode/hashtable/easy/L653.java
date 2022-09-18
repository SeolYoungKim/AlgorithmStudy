package LeetCode.hashtable.easy;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class L653 {

    public static boolean method(TreeNode root, int k) {

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode2, treeNode4);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6, null, treeNode7);

        root = new TreeNode(5, treeNode3, treeNode6);

        TreeNode left = root.left;
        TreeNode right = root.right;

        int temp = root.val;
        int tempLeft = left.val;
        int tempRight = right.val;

        return true;


    }
}
