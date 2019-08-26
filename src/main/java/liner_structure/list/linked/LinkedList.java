package liner_structure.list.linked;

import liner_structure.list.IList;

/**
 * @author yancy
 * @date 2019/3/20
 */
public class LinkedList {
    /**
     * 存储头指针
     */
    public Node head;

    /**
     * 初始化头结点
     */
    public LinkedList() {
        this.head = new Node();
    }


    /**
     * 构造一个长度为n链表
     * 头插法和尾插法
     *
     * @param n
     * @param order true 头插法  false 尾插法
     */
    public LinkedList(int n, boolean order) {
        //创建一个头结点
        this();
        if (order) {
            //头插法
            for (int i = 0; i < n; i++) {
                Node node = new Node();
                node.next = this.head;
                this.head.next = node;
            }
        } else {
            //尾插法
            Node last = head;
            for (int i = 0; i < n; i++) {
                Node node = new Node();
                last.next = node;
                last = node;
            }
        }

    }

    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList(5);
        System.out.println();
    }

}
