package koal.bst;

import javafx.scene.transform.Rotate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/18 20:47
 * 版本：1.0
 * 内容描述：试题一
 *
 * 实现要求：
 * 1、根据已有的代码片段，实现一个二叉排序树；
 * 2、用中序遍历输出排序结果，结果形如：0，1，2 ，3 ，4， 5， 6， 7， 8， 9，
 * 3、注意编写代码注释
 */

public class BinaryTree {

    public static void main(String[] args) {

        final int[] values = { 1, 3, 4, 5, 2, 8, 6, 7, 9, 0 };

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            // 此处的root只为了取最后结果的bst的根节点
            root = createBinaryTree(root, values[i]);
        }

        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        BFS(root);
        DFS(root);
    }

    /**
     * 向bst的根node节点添加新的节点，节点保存的值为value。
     * @param node
     * @param value
     * @return
     */
    public static Node createBinaryTree(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        }
        if (node.getValue() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                createBinaryTree(node.getLeft(), value);
            }
        }
        if (node.getValue() < value) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                createBinaryTree(node.getRight(), value);
            }
        }
        return node;
    }

    /**
     * 先序遍历 bst(根左右)，并打印出来
     * @param node
     */
    public static void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + "，");

            if (node.getLeft() != null) {
                preOrderTraversal(node.getLeft());
            }
            if (node.getRight() != null) {
                preOrderTraversal(node.getRight());
            }
        }
    }

    /**
     * 中序遍历 bst(左根右)，并打印出来
     * @param node
     */
    public static void inOrderTraversal(Node node) {
        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft());
        }
        System.out.print(node.getValue() + "，");
        if (node.getRight() != null) {
            inOrderTraversal(node.getRight());
        }
    }

    public static void DFS(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node != null) {
            stack.add(node);
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.print(pop.getValue() + ",");
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
            }
            if (pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }
        }
        System.out.println();
    }

    public static void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        if (node != null) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.getValue() + ",");
            if (n.getLeft() != null) {
                queue.add(n.getLeft());
            }
            if (n.getRight() != null) {
                queue.add(n.getRight());
            }
        }
        System.out.println();
    }
}

class Node {

    // 节点值
    private int value;

    // 左节点
    private Node left;

    // 右节点
    private Node right;

    public Node() { }

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
