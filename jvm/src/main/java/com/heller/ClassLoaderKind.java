package com.heller;

class ClassLoaderKind {
    public static void main(String[] args) throws ClassNotFoundException {
        //系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        //上上层：引导类加载器 获取不到
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
        //自定义类：默认系统类加载
        ClassLoader classLoader = ClassLoaderKind.class.getClassLoader();
        //ClassLoader classLoader = Class.forName("com.heller.ClassLoaderKind").getClassLoader();
        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        //Java核心类库使用引导类加载器
        ClassLoader strKindClassLoader = String.class.getClassLoader();
        System.out.println(strKindClassLoader);
    }
}
