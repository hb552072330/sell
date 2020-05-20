package com.study.sell.utils;

import java.util.Random;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:58 2020/5/20
 * @Modified By:
 */
public class KeyUtils {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        return System.currentTimeMillis() + String.valueOf(random.nextInt(900000) + 100000);
    }
}
