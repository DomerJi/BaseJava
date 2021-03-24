package com.example.basejava;

import java.util.List;

/**
 * Created by v_jishuaipeng on 2019-09-09.
 * 描述:
 */
public interface LoadImp<T> {

    void loadData();

    void onSuccess(List<T> list);

    void onFail(int code, String msg);

}
