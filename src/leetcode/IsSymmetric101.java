package leetcode;

import java.util.Queue;

public class IsSymmetric101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
             return true;
        }
        //上一步判断后到这里说明p、q都不为空, 那么只要有一方为空就说明两边不对称
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }
}
