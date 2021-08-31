package com.heller.flyweight;

import org.junit.jupiter.api.Test;

public class WebSiteFactoryTest {
    @Test
    public void test() {
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite webSite1 = webSiteFactory.createWebSite("微博");
        webSite1.user("a");

        WebSite webSite2 = webSiteFactory.createWebSite("新闻");
        webSite2.user("b");

        WebSite webSite3 = webSiteFactory.createWebSite("新闻");
        webSite3.user("c");

        System.out.println(webSiteFactory.count());
    }
}