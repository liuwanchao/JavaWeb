package com.zretc.test;

import com.zretc.util.DateUtils;
import org.junit.Test;

import java.util.Date;

public class DateTest {
    @Test
    public void sk(){
        System.out.println(DateUtils.dateToStr(new Date()));
    }
}
