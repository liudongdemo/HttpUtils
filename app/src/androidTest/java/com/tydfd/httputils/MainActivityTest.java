package com.tydfd.httputils;

import android.util.Log;
import android.util.TimeUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Classname MainActivityTest
 * @Description TODO
 * @Date 2019/7/11 15:32
 * @Created by liudo
 * @Author by liudo
 */
public class MainActivityTest {
    private static final String TAG = "MainTEST";
    @Test
    public void TestDemo(){
        Log.i(TAG, "TestDemo: "+TimeUtils.getTimeZoneDatabaseVersion());
    }


}