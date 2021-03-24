package com.example.basejava.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by v_jishuaipeng on 2021-03-16.
 * 描述: 吐司
 */
public final class ToastUtil {

    private ToastUtil() {
    }

    private static Context appContext;

    public static void init(Context context) {
        appContext = context.getApplicationContext();
    }

    public static void show(CharSequence charSequence) {
        Toast.makeText(appContext, charSequence, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(CharSequence charSequence) {
        Toast.makeText(appContext, charSequence, Toast.LENGTH_LONG).show();
    }

}
