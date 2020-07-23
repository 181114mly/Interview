//106. 从中序与后序遍历序列构造二叉树
//根据一棵树的中序遍历与后序遍历构造二叉树。
package Nowcoder;

public class BuildTreeByInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        return buildTreeCore(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] in, int in_start, int in_end, int[] post, int post_start, int post_end) {
        if (post_start > post_end || in_start > in_end) {
            return null;
        }
        TreeNode root = new TreeNode(post[post_end]);
        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == post[post_end]) {
                root.left = buildTreeCore(in, in_start, i - 1, post, post_start, i - 1 - in_start + post_start);
                root.right = buildTreeCore(in, i + 1, in_end, post, i - in_start + post_start, post_end - 1);
                break;
            }
        }
        return root;
    }
}
