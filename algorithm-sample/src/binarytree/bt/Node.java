package binarytree.bt;

/**
 * 内容描述：二叉树的节点定义
 * 创建人：yang.liu
 * 创建时间：2019/7/3 19:35
 * 版本：1.0
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
