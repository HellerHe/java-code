package com.heller.datastructures.hashtable;

public class EmployArr {
    private Employ head;
    public void add(Employ employ) {
        if (head == null) {
            head = employ;
            return;
        }
        Employ tmp = head;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        tmp.setNext(employ);
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("第 "+(i+1)+" 链表为空");
            return;
        }
        Employ tmp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", tmp.getId(), tmp.getName());
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public Employ find(int id) {
        if(head == null) { System.out.println("链表为空"); return null; }
        Employ tmp = head;
        while (true) {
            if (tmp.getId() == id) {
                break;
            }
            if (tmp.getNext() == null) {
                tmp = null;
                break;
            }
            tmp = tmp.getNext();

        }
        return tmp;
    }
}
