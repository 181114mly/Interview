//二叉树的深度
/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
package Interview;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTree {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //方法一：使用层序遍历
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //将二叉树本层节点全部出队列，将二叉树下一层所有元素入队列
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    //方法二：递归
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int depth1 = TreeDepth(root.left);
        int depth2 = TreeDepth(root.right);
        return Math.max(depth1, depth2) + 1;
        //return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
