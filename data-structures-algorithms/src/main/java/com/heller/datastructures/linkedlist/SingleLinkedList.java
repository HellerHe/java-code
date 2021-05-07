package com.heller.datastructures.linkedlist;

import java.util.Stack;

/**
 * ----有头单向链表
 */
public class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 不考虑顺序添加到最后
     */
    public void add(HeroNode hero) {
        HeroNode tmp = head;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        tmp.setNext(hero);
    }

    /**
     * 按排名添加到指定位置
     */
    public void addByOrder(HeroNode hero) {
        HeroNode tmp = head;
        boolean flag = true;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            //在 temp 的后面插入
            if (tmp.getNext().getNum() > hero.getNum()) {
                break;
            } else if (tmp.getNext().getNum() == hero.getNum()) {
                flag = false;
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            hero.setNext(tmp.getNext());
            tmp.setNext(hero);
        } else {
            System.out.println("已经存在该节点：" + hero);
        }
    }

    public void update(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = true;
        while (true) {
            if (tmp.getNum() == heroNode.getNum()) {
                tmp.setName(heroNode.getName());
                tmp.setNickName(heroNode.getNickName());
                flag = false;
                break;
            }
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            System.out.println("没有该节点：" + heroNode);
        }
    }

    public void delete(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = true;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNext().getNum() == heroNode.getNum()) {
                tmp.setNext(tmp.getNext().getNext());
                flag = false;
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            System.out.println("没有该节点：" + heroNode);
        }
    }

    public void list() {
        HeroNode tmp = head;
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

    public int length() {
        HeroNode tmp = head;
        int length = 0;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
            length++;
        }
        return length;
    }

    public HeroNode findLastIndexNode(int index) {
        HeroNode tmp = head;
        int num = 0;
        if (index < 0 || index > length()) {
            return null;
        }
        while (true) {
            if (length() - num == index) {
                break;
            }
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
            num++;
        }
        return tmp.getNext();
    }

    public void reverse() {
        HeroNode tmp = head.getNext();
        HeroNode reverse = new HeroNode();
        HeroNode next = null;
        while (true) {
            if (tmp == null) {
                break;
            }
            next = tmp.getNext();

            tmp.setNext(reverse.getNext());
            reverse.setNext(tmp);
            tmp = next;
        }
        head.setNext(reverse.getNext());
    }

    /**
     * 利用栈
     */
    public void reversePrint() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode tmp = head;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
            stack.push(tmp);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
