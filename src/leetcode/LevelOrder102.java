package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>(16);
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            List<Integer> levelNodeVal = new ArrayList<>(8);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                levelNodeVal.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.offer(treeNode.right);
                }
            }
            result.add(levelNodeVal);
        }

        return result;
    }
}
