package daily._2023._06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day_14 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        final List<Integer> results = new ArrayList<>();
        saveTreeValue(root, results);

        results.sort(Comparator.naturalOrder());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < results.size() - 1; i++) {
            min = Math.min(min, results.get(i + 1) - results.get(i));
        }

        return min;
    }

    private void saveTreeValue(final TreeNode root, final List<Integer> results) {
        if (root == null) {
            return;
        }

        saveTreeValue(root.left, results);
        results.add(root.val);
        saveTreeValue(root.right, results);
    }
}
