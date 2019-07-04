package binarytree.bt;

import java.util.Objects;

/**
 * 内容描述：构建二叉树
 * 创建人：yang.liu
 * 创建时间：2019/7/3 19:36
 * 版本：1.0
 */
public class BT {

    private Node root;

    public Node getRootNode() {
        return root;
    }

    public void addNode(Node node) {
        if (null == root) {
            root = node;
            return;
        }
        addNode(root, node);
    }

    /**
     * 向子树中添加node
     * @param root 子树的根
     * @param node 要添加的节点
     */
    private void addNode(Node root, Node node) {
        if (null == node) {
            return;
        }
        if (Objects.isNull(root)) {
            root = node;
        } else {
            if (node.value <= root.value) {
                if (null == root.left) {
                    root.left = node;
                } else {
                    addNode(root.left, node);
                }
            } else {
                if (null == root.right) {
                    root.right = node;
                } else {
                    addNode(root.right, node);
                }
            }
        }
    }

    public void printTailOrderTravel() {
        printTailOrderTravel(root);
    }

    private void printTailOrderTravel(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        printTailOrderTravel(root.left);
        printTailOrderTravel(root.right);
        System.out.print(root.value + " ");

    }

    public static void main(String[] args) {
        BT btree = new BT();
        btree.addNode(new Node(2));
        btree.addNode(new Node(8));
        btree.addNode(new Node(9));
        btree.addNode(new Node(13));
        btree.addNode(new Node(10));
        btree.addNode(new Node(14));
        btree.addNode(new Node(15));
        btree.addNode(new Node(5));
        btree.addNode(new Node(12));
        btree.addNode(new Node(7));

        btree.printTailOrderTravel();
    }


}
