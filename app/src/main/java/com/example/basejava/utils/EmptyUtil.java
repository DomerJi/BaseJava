package com.example.basejava.utils;

import android.app.Activity;
import android.os.Build;
import android.support.v4.app.Fragment;


import androidx.annotation.RequiresApi;

import java.util.Collection;

/**
 * Created by v_jishuaipeng on 2021-03-16.
 * 描述: 判断是否为空
 */
public final class EmptyUtil {

    private EmptyUtil() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isEmpty(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean isEmpty(Fragment fragment) {
        return fragment == null || fragment.isDetached();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isEmpty(Object[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(int[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(float[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(double[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(long[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(short[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(char[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(boolean[] arrs) {
        return arrs == null || arrs.length == 0;
    }

    public static boolean isEmpty(byte[] arrs) {
        return arrs == null || arrs.length == 0;
    }
}
