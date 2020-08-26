package com.example.test.procon;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer3 {
    public static void main(String[] args) {
        final RefactorMessageQueue mq = new RefactorMessageQueue(5);
        System.out.println("***************task begin***************");
        //创建生产者线程并启动
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                while (true) {
                    mq.set(new Message());
                }
            }, "producer" + i).start();
        }
        //创建消费者线程并启动
        new Thread(() -> {
            while (true) {
                mq.get();
            }
        }, "consumer").start();
    }
    /**
     * 消息队列中存储的消息
     */
    static class Message {
    }
    /**
     * 消息队列
     */
    static class RefactorMessageQueue {
        /**
         * 队列最大值
         */
        private final int max;
        /*
         * 锁
         * */
        private final Lock lock = new ReentrantLock();
        /**
         * 条件变量，用于消费者，非空即可消费
         */
        private final Condition notEmptyCondition = lock.newCondition();
        /**
         * 条件变量，用于生产者，非满即可生产
         */
        private final Condition notFullCondition = lock.newCondition();
        /**
         * final确保发布安全
         */
        final LinkedList<Message> messageQueue = new LinkedList<>();
        /**
         * 构造函数默认队列大小为10
         */
        public RefactorMessageQueue() {
            max = 10;
        }
        /**
         * 构造函数设置队列大小
         */
        public RefactorMessageQueue(int x) {
            max = x;
        }
        public void  set(Message message) {
            lock.lock();
            try {
                //如果已经大于队列个数，队列满，进入等待
                while (messageQueue.size() > max) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " : queue is full ,waiting...");
                        //如果满了，生产者在“非满”这个条件上等待
                        notFullCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果队列未满，生产消息，随后通知lock上的等待线程
                //每一次的消息生产，都会通知消费者
                System.out.println(Thread.currentThread().getName() + " : add a message");
                messageQueue.addLast(message);
                //生产后，增加了消息，非空条件满足，需要唤醒消费者
                notEmptyCondition.signalAll();
            } finally {
                lock.unlock();
            }

        }
        public void get() {
            lock.lock();
            try {
                //如果队列为空，进入等待，无法获取消息
                while (messageQueue.isEmpty()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " : queue is empty ,waiting...");
                        //如果空了，消费者需要在“非空”条件上等待
                        notEmptyCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //队列非空时，读取消息，随后通知lock上的等待线程
                //每一次的消息读取，都会通知生产者
                System.out.println(Thread.currentThread().getName() + " : get a message");
                messageQueue.removeFirst();
                //消费后，减少了消息，所以非满条件满足，需要唤醒生产者
                notFullCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
