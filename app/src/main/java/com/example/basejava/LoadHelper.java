package com.example.basejava;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_jishuaipeng on 2019-09-07.
 * 描述: 辅助分页加载
 */
public class LoadHelper<T> {


    private static String TAG = "LoadHelper";
    private long startTime = -1;
    private long delayTime = 800;
    private int page;
    private int firstPage = 1;
    private int pageSize = 100;



    public List<T> list = new ArrayList<>();

    private boolean refreshIng = false;
    private boolean loadMoreIng = false;
    private boolean hasMore = false;

    private LoadImp loadImp;

    public long getDelayTime() {
        return delayTime;
    }

    public LoadHelper(LoadImp loadImp) {
        this.loadImp = loadImp;
    }

    public LoadHelper setFirstPage(int firstPage) {
        this.firstPage = firstPage;
        return this;
    }

    public LoadHelper setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public LoadHelper setDelayTime(long delayTime) {
        this.delayTime = delayTime;
        return this;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public boolean isRefreshIng() {
        return refreshIng;
    }

    public boolean isLoadMoreIng() {
        return loadMoreIng;
    }

    public boolean refresh() {
        page = firstPage;
        if (refreshIng || loadMoreIng) {
            Log.e(TAG, "refresh() -> refreshIng = " + refreshIng + " ; loadMoreIng = " + loadMoreIng);
            return false;
        }
        refreshIng = true;
        loadMoreIng = false;
        startTime = System.currentTimeMillis();
        loadImp.loadData();
        return true;
    }


    public boolean loadMore() {
        if (refreshIng || loadMoreIng) {
            Log.e(TAG, "loadMore() -> refreshIng = " + refreshIng + " ; loadMoreIng = " + loadMoreIng);
            return false;
        }
        loadMoreIng = true;
        refreshIng = false;
        startTime = System.currentTimeMillis();
        loadImp.loadData();
        return true;
    }


    public void onResultData(List<T> list) {
        hasMore = hasMore(list);
        if (page == firstPage) {
            this.list.clear();
        }

        if (!isEmpty(list)) {
            this.list.addAll(list);
        }
        page++;
        refreshIng = false;
        loadMoreIng = false;

        long delay = System.currentTimeMillis() - startTime;
        if (delay >= this.delayTime) {
            loadImp.onSuccess(this.list);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadImp.onSuccess(LoadHelper.this.list);
                }
            }, this.delayTime - delay);
        }
    }

    public void onError(int code, String msg) {
        refreshIng = false;
        loadMoreIng = false;
        loadImp.onFail(code, msg);
    }

    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.size() == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isLive(Activity activity) {
        return !(activity == null || activity.isFinishing() || activity.isDestroyed());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isNotLive(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    public boolean hasMore(List<T> list) {
        return !isEmpty(list) && list.size() >= pageSize;
    }

}
