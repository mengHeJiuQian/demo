package list.reverselist;

/**
 * 内容描述：链表节点
 * 创建人：yang.liu
 * 创建时间：2019/7/3 19:35
 * 版本：1.0
 */
public class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
