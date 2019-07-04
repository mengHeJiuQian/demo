package list.reverselist;

/**
 * 内容描述：翻转链表，针对的是原来链表进行翻转。
 * 创建人：yang.liu
 * 创建时间：2019/7/4 13:29
 * 版本：1.0
 */
public class ReverseList {

    public static Node reverse(Node head) {
        // 空节点 或 只有一个节点，直接返回
        if (null == head || null == head.next) {
            return head;
        }

        // p head n，
        // 在链表长度大于1时，第一步的情况是：p（previous）表示第一个节点，head表示第二个节点，n（next）表示第三个节点
        // while循环操作是：head的next指向第一个节点（也就是p），
        // 之后p、head、n分别向前移动一节。
        // while之后是处理n到结尾时的情况。
        Node p = head;
        Node tmpHead = head.next;
        Node n = tmpHead.next;

        while (null != n) {
            tmpHead.next = p;
            p = tmpHead;
            tmpHead = n;
            n = n.next;
        }

        tmpHead.next = p;
        head.next = null;

        return tmpHead;
    }

    public static void printNodeList(Node head) {
        while (null != head) {
            System.out.print(head.value + " - ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        /* Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);*/

        n1.next = n2;
        /*n2.next = n3;
        n3.next = n4;
        n4.next = n5;*/

        printNodeList(n1);
        Node reverse = reverse(n1);
        printNodeList(reverse);
    }
}
