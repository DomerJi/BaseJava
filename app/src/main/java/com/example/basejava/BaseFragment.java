package com.example.basejava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by v_jishuaipeng on 2019-09-10.
 * 描述:
 */
public abstract class BaseFragment extends Fragment {

    private boolean isVisible = false;
    private boolean isCreateViewed = false;
    private boolean isLoadData = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isCreateViewed = true;
        load();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        load();
    }

    private void load() {
        if (isVisible && isCreateViewed && !isLoadData) {
            onLoadData(getView());
            isLoadData = true;
        }
    }

    public abstract void onLoadData(@NonNull View view);
}
