package com.example.test.mycollection.list;

public class SinglyLinkedList<E> implements LList {

    protected Node<E> head;// 单链表头结点,指向单链表第一个结点

    /**
     * 构造空单链表
     */
    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     * 构造指定头结点的单链表
     *
     * @param head
     */
    public SinglyLinkedList(Node<E> head) {
        this.head = head;
    }


    /**
     * 判断单链表是否为空
     */
    @Override
    public boolean isEmpty() {
        return this.head==null;
    }

    /**
     * 遍历单链表返回单链表长度
     */
    @Override
    public int length() {
        int i=0;
        Node<E> p = head;// p从head指向的节点开始
        while (p!=null){// 若单链表未结束
            p=p.next;// p到达后继节点
            i++;
        }
        return i;
    }

    /**
     * 返回序号为index的的对象,如果链表为空或者序号错误则返回null
     */
    //获取单链表指定索引处的对象需要遍历单链表找到该索引，其实就是单链表的遍历操作
    @Override
    public Object get(int index) {
        Node<E> p = head;
        int i =0;
        while (p!=null && i<index){
            i++;
            p = p.next;
        }
        if(p != null){
            return p.data;
        }
        return null;
    }

    /**
     * 设置序号为index的对象的值为element,如果操作成功则返回原对象,操作失败返回null
     */
    @Override
    public Object set(int index, Object element) {
        if(this.head!=null && index>0 && element!=null){
            Node<E> p = this.head;
            int i = 0;
            while (p!=null && i<index){
                i++;
                p = p.next;
            }

            if(p!=null){
                E old = p.data;
                p.data = (E)element;
                return old;// 操作成功返回原对象
            }
        }
        return null;
    }

    /**
     * 插入elment元素,插入后对象序号为index,如果操作成功则返回true
     */
    //@Override
    public boolean add1(int index, Object element) {
        if(element == null){
            return false;
        }

        Node<E> q = new Node(element);// 创建要插入的结点
        if(this.head ==null || index<=0){// 在头结点后面插入
            q.next = this.head;
            this.head = q;
        }else {
            Node<E> p = this.head;
            int i =0;
            while (p.next!=null && i<index-1){// 寻找插入位置
                i++;
                p = p.next;
            }
            q.next = p.next;// q插入在p结点之后
            p.next = q;
        }

        return true;
    }

    @Override
    public boolean add(int index, Object element) {
        if(element == null){
            return false;
        }
        Node<E> q = new Node(element);
        if(this.head==null){
            q.next = this.head;
            this.head = q;
        }else {
            Node<E> p = this.head;
            int i = 0;
            while (p.next!=null&&i<index-1){
                i++;
                p = p.next;
            }
            p.next = q;
            q.next = p.next.next;
        }

        return true;
    }

    /**
     * 在单链表最后插入对象
     */
    @Override
    public boolean add(Object element) {

        return add(Integer.MAX_VALUE,element);
    }

    /**
     * 移除序号为index的对象,如果操作成功则返回被移除的对象,操作失败则返回null
     */
    @Override
    public Object remove(int index) {
        E old = null;
        if(this.head!=null && index>0){

            if(index==0){
                old = this.head.data;
                this.head = this.head.next;
            }else {
                Node p = this.head;
                int i =0;
                while (p!=null&&i<index-1){
                    i++;
                    p = p.next;
                }
                if(p!=null){
                    old = (E)p.next.data;
                    p.next = p.next.next;
                }
            }
        }

        return old;
    }

    @Override
    public void clear() {// 清空单链表
        this.head = null;
    }

    @Override
    public String toString() {// 返回所有元素值对应的字符串
        String str = "(";
        Node<E> p = this.head;
        while (p != null) {
            str += p.data.toString();
            p = p.next;
            if (p != null) {
                str += ", ";
            }
        }
        return str + ")";
    }

    public static void main(String[] args) {
        LList<String> linkedList = new SinglyLinkedList<String>();
        // 添加A,B,C三个元素
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        // 输出元素个数
        System.out.println("元素个数是："+linkedList.length());
    }
}
