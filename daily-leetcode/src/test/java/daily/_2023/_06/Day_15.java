package daily._2023._06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day_15 {
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

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxLevel = -1;
        int maxSum = Integer.MIN_VALUE;
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSum = 0;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {  // 현재 레벨의 노드들을 모두 소진하여 현재 레벨의 합계를 구한다
                final TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {  // 다음 레벨의 노드들을 담는다
                    queue.add(node.left);
                }

                if (node.right != null) {  // 다음 레벨의 노드들을 담는다
                    queue.add(node.right);
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
}
