package com.heller.datastructures.linkedlist;

/**
 * ----双向链表
 */
public class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public void list() {
        HeroNode2 tmp = head;
        if (tmp.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
            System.out.println(tmp);
        }
    }

    public void add(HeroNode2 node) {
        HeroNode2 tmp = head;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        tmp.setNext(node);
        node.setPre(tmp);
    }

    public void update(HeroNode2 node) {
        HeroNode2 tmp = head;
        boolean flag = true;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNum() == node.getNum()) {
                tmp.setName(node.getName());
                tmp.setNickName(node.getNickName());
                flag = false;
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            System.out.println("没有该节点：" + node);
        }
    }

    public void delete(int num) {
        HeroNode2 tmp = head;
        boolean flag = true;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNum() == num) {
                tmp.getPre().setNext(tmp.getNext());
                if (tmp.getNext() != null) {
                    tmp.getNext().setPre(tmp.getPre());
                }
                flag = false;
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            System.out.println("没有该节点：" + num);
        }
    }
}
