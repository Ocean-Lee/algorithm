package list;

/**
 * 线性表常用操作定义
 *
 * @author yancy
 * @date 2019/3/20
 */
public interface IList {
    /**
     * 新增
     *
     * @param i 元素的位置
     * @param x 元素
     */
    void insert(int i, Object x);

    /**
     * 删除
     *
     * @param i
     */
    void remove(int i);

    /**
     * 查询 第i个位置的元素
     *
     * @param i
     * @return
     */
    Object get(int i);

    /**
     * 遍历线性表
     */
    void disply();
}
