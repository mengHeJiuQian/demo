package binarytree.TreeAHasSubTreeB;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/11 9:08
 * 版本：1.0
 * 内容描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class ATreeHasSubTreeB {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);

        n1.left = n2;




        System.out.println(hasSubtree(node1, n1));

    }


    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                res = isSameTree(root1, root2);
            }
            if (!res) {
                res = hasSubtree(root1.left, root2);
            }
            if (!res) {
                res = hasSubtree(root1.right, root2);
            }
        }
        return res;

    }

    public static boolean isSameTree(TreeNode root1,TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) &&isSameTree(root1.right, root2.right);

        /*if (root1 == null && root2 == null) {
            // 都为null
            return true;
        } else if (root1 != null && root2 != null) {
            // 都不为null
            if (root1.val != root2.val) {
                return false;
            } else {
                return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
            }
        } else {
            return false;
        }
*/
    }
}
