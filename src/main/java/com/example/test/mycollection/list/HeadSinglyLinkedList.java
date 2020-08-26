package com.example.test.mycollection.list;

public class HeadSinglyLinkedList<E> implements LList {

    protected Node<E> head;// 单链表的头结点,指向单链表的头结点
    protected Node<E> rear;// 单链表的尾结点,指向单链表的最后一个结点
    protected int n;// 单链表的长度

    public HeadSinglyLinkedList() {// 构造空单链表
        this.head = new Node<E>(null);// 构造头结点,元素值为空
        this.rear = this.head;// 构造尾结点,初始化的时候头结点和尾结点都指向头结点
        this.n = 0;// 初始化链表长度为0
    }

    @Override
    public boolean isEmpty() {
        return this.head.next==null;
    }

    @Override
    public int length() {
        return this.n;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public boolean add(int index, Object element) {
        if(element==null){
            return false;
        }

        if(index>=this.n){
            add(element);
        }else {
            Node<E> q = new Node(element);
            Node<E> p = this.head;
            int i =0;
            while (p.next!=null && i<index){
                p = p.next;
                i++;
            }
            q.next = p.next;
            p.next = q;
            this.n++;
        }
        return true;
    }

    @Override
    public boolean add(Object element) {
        if(element==null){
            return false;
        }
        this.rear.next = new Node<E>((E)element);
        this.rear = this.rear.next;
        this.n++;
        return true;
    }

    @Override
    public Object remove(int index) {
        E old = null;
        if(index>=0){
            Node p = this.head;
            int i=0;
            while (p.next!=null&&i<index){
                p = p.next;
                i++;
            }
            if(p.next!=null){
                old = (E)p.next.data;
                if(p.next == this.rear){
                    this.rear = p;
                }
                p = p.next.next;
                this.n--;
                return old;
            }
        }
        return old;
    }

    @Override
    public void clear() {

    }
}
