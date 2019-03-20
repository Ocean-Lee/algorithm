package list.linked;

/**
 * 节点类的描述
 *
 * @author yancy
 * @date 2019/3/20
 */
public class Node {
    public Object data;
    public Node next;


    /**
     * 构造一个空节点
     */
    public Node() {
        this(null, null);
    }


    /**
     * 初始化头结点
     *
     * @param data
     */

    public Node(Object data) {
        this.data = data;
    }


    /**
     * 构造一个节点
     *
     * @param data
     * @param next
     */
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

}
