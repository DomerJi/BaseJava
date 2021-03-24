package com.example.basejava;

import android.os.Message;

import java.util.Hashtable;

/**
 * Created by v_jishuaipeng on 2019-09-11.
 * 描述:
 */
public class Hint {

    /**
     * LinkedList、ArrayList、HashSet是非线程安全的，Vector是线程安全的;
     * HashMap是非线程安全的，HashTable是线程安全的;
     */
    private void hashTable() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("key", "value");
        hashtable.get("key");
        hashtable.clear();

    }

    /**
     * 一种是<? extends T>它通过确保类型必须是T的子类来设定类型的上界，
     * 另一种是<? super T>它通过确保类型必须是T的父类来设定类型的下界。
     * 另一方面<?>表 示了非限定通配符，因为<?>可以用任意类型来替代。
     * 例如List<? extends Number>可以接受List或List。
     */
}
