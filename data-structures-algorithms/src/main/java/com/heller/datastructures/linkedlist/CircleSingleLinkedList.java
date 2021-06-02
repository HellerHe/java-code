package com.heller.datastructures.linkedlist;

/**
 * ----环形链表
 */
public class CircleSingleLinkedList {
    private HeroNode first = null;

    public void add(int count) {
        if (count < 1) {
            System.out.println("参数错误");
        }
        HeroNode tmp = null;
        for (int i = 1; i <= count; i++) {
            HeroNode node = new HeroNode(i);
            if (i == 1) {
                first = node;
                first.setNext(first);
                tmp = first;
            } else {
                tmp.setNext(node);
                node.setNext(first);
                tmp = node;
            }
        }
    }

    public void list() {
        HeroNode tmp = first;
        while (true) {
            System.out.println(tmp);
            if (tmp.getNext() == first) {
                break;
            }
            tmp = tmp.getNext();
        }
    }

    /**
     * 约瑟夫问题
     * @param start
     * @param step
     * @param count 总人数
     */
    public void getOrder(int start, int step, int count) {
        HeroNode helper = first;
        //指向环形链表的最后节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //找到起始点
        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //first是出列节点，helper是剩余环形链表
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < step - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留下：" + first);
    }
}
