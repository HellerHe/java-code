package com.heller.prototype;

import org.junit.Test;

public class SheepTest {
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        Sheep sheep = new Sheep("tom", 2, "白色");
        Sheep friend = new Sheep("jerry", 2, "黑色");
        sheep.friend = friend;
        Sheep clone1 = (Sheep)sheep.clone();
        Sheep clone2 = (Sheep)sheep.clone();
        Sheep clone3 = (Sheep)sheep.clone();

        System.out.println(sheep.toString() + sheep.friend.hashCode());
        System.out.println(clone1.toString() + clone1.friend.hashCode());
        System.out.println(clone2.toString() + clone2.friend.hashCode());
        System.out.println(clone3.toString() + clone3.friend.hashCode());
        System.out.println(sheep == clone1);
    }

    @Test
    public void deepCloneTest() throws CloneNotSupportedException {
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.name = "tom";
        deepProtoType.deepCloneableTarget = new DeepCloneableTarget("a", "b");
        DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.clone();

        System.out.println(deepProtoType.name + deepProtoType.deepCloneableTarget.hashCode());
        System.out.println(deepProtoType1.name + deepProtoType1.deepCloneableTarget.hashCode());

        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType.deepClone();
        System.out.println(deepProtoType2.name + deepProtoType2.deepCloneableTarget.hashCode());
    }
}