package binarytree.bt;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/8 16:15
 * 版本：1.0
 * 内容描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *          假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *          例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 先序：{1,2,4,7,3,5,6,8} 1理所当然是根节点。
 * 中序：{4,7,2,1,5,3,8,6} 中序是先遍历左子树，到根节点，再遍历右子树。
 *
 * 确定1就是根节点后，有以下结论
 *
 * 先序：根{1}，左子树{2,4,7}，右子树{3,5,6,8}
 * 中序：所以1的左边是左子树{4,7,2}，根{1}，右边是右子树{5,3,8,6}。
 *
 * 相同的方法继续判断左子树和右子树。
 *
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] preOrder = {1,2,4,5,3,6,7};
        int[] inOrder = {4,2,5,1,6,3,7};
        Node node = reConstructBinaryTree(preOrder, inOrder);
        System.out.println(node);
    }

    public static Node reConstructBinaryTree(int[] pre,int [] in) {
        Node root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private static Node reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        Node root = new Node(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
                break;
            }
        }
        return root;
    }

}
