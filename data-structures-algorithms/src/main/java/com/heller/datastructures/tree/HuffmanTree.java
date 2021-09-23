package com.heller.datastructures.tree;

import java.util.*;

/**
 * ----赫夫曼树
 * 带权路径长度之和（WPL）最小
 */
public class HuffmanTree {
    public NumNode create(int[] arr) {
        List<NumNode> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new NumNode(i));
        }
        while (nodes.size() > 1) {
            //1.从小到大进行排序
            Collections.sort(nodes, new Comparator<NumNode>() {
                @Override
                public int compare(NumNode o1, NumNode o2) {
                    return o1.getNum() - o2.getNum();
                }
            });
            //2.取出根节点权值最小的两颗二叉树，组成新二叉树，根节点值是前两节点之和
            NumNode first = nodes.get(0);
            NumNode second = nodes.get(1);
            NumNode parent = new NumNode(first.getNum() + second.getNum());
            parent.setLeft(first);
            parent.setRight(second);

            nodes.remove(first);
            nodes.remove(second);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
