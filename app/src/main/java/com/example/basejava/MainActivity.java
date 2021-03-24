package com.example.basejava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.basejava.strategy.Result;
import com.example.basejava.strategy.StrategyManager;
import com.example.basejava.strategy.Worker;
import com.example.basejava.strategy.WorkerCall;
import com.zyyoona7.picker.DatePickerView;
import com.zyyoona7.picker.base.BaseDatePickerView;
import com.zyyoona7.picker.listener.OnDateSelectedListener;
import com.zyyoona7.wheel.WheelView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoadImp<String> {

    private LoadHelper loadHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_selecte_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        findViewById(R.id.tv_selecte_time01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final DatePickerView defaultDpv = findViewById(R.id.dpv_default_bottom);
        findViewById(R.id.tv_selecte_time02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaultDpv.setVisibility(View.VISIBLE == defaultDpv.getVisibility() ? View.INVISIBLE : View.VISIBLE);
            }
        });
        defaultDpv.setTextSize(24, true);
        defaultDpv.setLabelTextSize(20);
        defaultDpv.setLabelTextColor(Color.RED);
        defaultDpv.setLineSpacing(1.2f);
        defaultDpv.setShowDivider(true);
        defaultDpv.setDividerType(WheelView.DIVIDER_TYPE_WRAP);
        defaultDpv.setDividerHeight(1);
        defaultDpv.setDividerColor(Color.BLUE);
        defaultDpv.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(BaseDatePickerView datePickerView, int year, int month, int day, @Nullable Date date) {
                Toast.makeText(MainActivity.this, "选中的日期：" + year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
            }
        });


        loadHelper = new LoadHelper(this);
        // 刷新
        loadHelper.refresh();
        // 加载更多
        loadHelper.loadMore();

        StrategyManager.getInstance().run(new Worker() {
            @Override
            public Result run() {

                return null;
            }
        }, new WorkerCall() {
            @Override
            public void call(Result result) {

            }
        });
    }

    @Override
    public void loadData() {
        // 加载成功的回调
        loadHelper.onResultData(null);
        // 加载失败的回调
        loadHelper.onError(-1, "服务器异常");
    }

    @Override
    public void onSuccess(List<String> list) {

    }

    @Override
    public void onFail(int code, String msg) {

    }

}
