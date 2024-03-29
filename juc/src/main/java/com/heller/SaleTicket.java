package com.heller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 虚假唤醒
 * if判断之后等待，再次唤醒时直接执行后续代码，造成数据混乱
 */
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket(30);
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <= 30; j++) {
                        ticket.sale();
                    }
                }
            }, "thread-" + i).start();
        }
    }

}

class Ticket {
    private int num;

    public Ticket(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /*public synchronized void sale() {
        while (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出" + num-- + "剩余" + num);
        }
    }*/
    private Lock lock = new ReentrantLock(true); //公平锁
    public void sale() {
        try {
            lock.lock();
            while (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出" + num-- + "剩余" + num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}