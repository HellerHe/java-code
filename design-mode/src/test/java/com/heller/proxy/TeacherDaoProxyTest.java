package com.heller.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherDaoProxyTest {
    @Test
    public void test() {
        TeacherDaoProxy proxy = new TeacherDaoProxy(new TeacherDao());
        proxy.teach();

        ProxyFactory JDKproxy = new ProxyFactory(new TeacherDao());
        Teacher proxyInstance = (Teacher) JDKproxy.getProxyInstance();
        proxyInstance.teach();


        CglibProxyFactory cglibProxy = new CglibProxyFactory(new TeacherDao());
        TeacherDao proxyInstance1 = (TeacherDao)cglibProxy.getProxyInstance();
        proxyInstance1.teach();
    }
}