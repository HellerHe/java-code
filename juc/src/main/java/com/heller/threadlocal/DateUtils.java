package com.heller.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类内部有一个Calendar对象引用，多线程造成共享引用混乱
 * 1.加锁，时间换空间，效率低
 * 2.使用ThreadLocal,用空间换时间,效率高
 * 3.DateTimeFormatter 代替 SimpleDateFormat
 */
public class DateUtils {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   /*public static synchronized Date parseDate(String stringDate)throws Exception
    {
        return sdf.parse(stringDate);
    }*/

    public static final java.lang.ThreadLocal<SimpleDateFormat> threadLocal = java.lang.ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    public static Date parseByThreadLocal(String stringDate) throws ParseException {
        return threadLocal.get().parse(stringDate);
    }
}
