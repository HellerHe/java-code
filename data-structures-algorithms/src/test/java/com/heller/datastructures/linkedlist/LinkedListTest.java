package com.heller.datastructures.linkedlist;

import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @Test
    public void add() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
    }

    @Test
    public void addByOrder() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.update(new HeroNode(4, "林冲1", "豹子头1"));
        singleLinkedList.update(new HeroNode(5, "林冲1", "豹子头1"));
        singleLinkedList.delete(new HeroNode(4, "林冲1", "豹子头1"));
        singleLinkedList.list();

        System.out.println(singleLinkedList.length());
        System.out.println(singleLinkedList.findLastIndexNode(1));
        singleLinkedList.reverse();
        System.out.println("反转-----");
        singleLinkedList.list();
        System.out.println("反转打印-----");
        singleLinkedList.reversePrint();
    }

    @Test
    public void josepfu() {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.add(5);
        linkedList.list();
        System.out.println("约瑟夫问题");
        linkedList.getOrder(1, 2, 6);
    }
}