package com.heller.proxy;

/**
 * ----静态代理
 * 被代理对象(即目标对象)与代理对象一起实现相同的接口或者是继承相同父类
 * 缺点：因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类
 */
public class TeacherDaoProxy implements Teacher{
    private TeacherDao teacherDao;

    public TeacherDaoProxy(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("静态代理开始。。。");
        teacherDao.teach();
    }
}
