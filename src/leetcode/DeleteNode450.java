package leetcode;

public class DeleteNode450 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        DeleteNode450 deleteNode450 = new DeleteNode450();
        TreeNode root = deleteNode450.deleteNode(node1, 3);
        System.out.println(root);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right != null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            } else if (root.left != null && root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            } else if (root.left == null && root.right == null) {
                return null;
            } else {
                //左右子树都不为空
                //找到一个比当前节点的左子树的val大且比右子树的val小的值, 这个值就是代替被删除节点的值.
                //这个值就是当前节点右子树的最小值
                TreeNode newNode = new TreeNode(getMinNode(root.right).val);
                //将找到的最小值更新替代被删除的节点
                newNode.left = root.left;
                newNode.right = removeMin(root.right);
                root.left = root.right = null;
                return newNode;
            }
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode getMinNode(TreeNode node) {
        //不管当前节点有没有右子树, 只要左子树为空就是最小的节点
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

    private TreeNode removeMin(TreeNode node) {
        //只要当前节点的左子树为空就返回当前子树的右子树 不需要关心右子树是否为空，因为左子树为空就代表最小值
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        //需要更新最新的树结构
        node.left = removeMin(node.left);
        return node;
    }
}
