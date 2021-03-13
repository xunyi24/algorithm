package leetcode;

import java.util.*;

public class ZigzagLevelOrder103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;

        ZigzagLevelOrder103 zigzagLevelOrder103 = new ZigzagLevelOrder103();
        zigzagLevelOrder103.zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
        //我自己做的 也使用了双向队列 但是不如上边leetcode官方的答案简洁，我复杂化了
        //leetcode将双向队列用作临时存储  而我将双向队列用作整个node的存储，无形中增加了case的复杂度
//        List<List<Integer>> res = new ArrayList<>();
//
//        if (root == null) {
//            return res;
//        }
//
//        Deque<TreeNode> levelOrderNodes = new LinkedList<>();
//        levelOrderNodes.addLast(root);
//        int level = 1;
//
//        while (!levelOrderNodes.isEmpty()) {
//            List<Integer> levelNodeVal = new ArrayList<>();
//            int dequeSize = levelOrderNodes.size();
//
//            for (int i = 0; i < dequeSize; i++) {
//                if (level % 2 != 0) {
//                    TreeNode node = levelOrderNodes.removeFirst();
//                    levelNodeVal.add(node.val);
//                    if (node.left != null) {
//                        levelOrderNodes.addLast(node.left);
//                    }
//                    if (node.right != null) {
//                        levelOrderNodes.addLast(node.right);
//                    }
//                } else {
//                    TreeNode node = levelOrderNodes.removeLast();
//                    levelNodeVal.add(node.val);
//                    if (node.right != null) {
//                        levelOrderNodes.addFirst(node.right);
//                    }
//                    if (node.left != null) {
//                        levelOrderNodes.addFirst(node.left);
//                    }
//                }
//            }
//            level++;
//            res.add(levelNodeVal);
//        }
//
//        return res;
    }
}
