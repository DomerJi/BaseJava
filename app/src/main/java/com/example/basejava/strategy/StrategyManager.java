package com.example.basejava.strategy;

import java.util.HashMap;

/**
 * Created by v_jishuaipeng on 2019-09-11.
 * 描述:
 */
public class StrategyManager {

    public HashMap<String, Worker> workers = new HashMap<>();

    public static StrategyManager getInstance() {
        return ImpInstance.strategyManager;
    }

    public void run(String key, WorkerCall call) {
        run(workers.get(key), call);
    }

    public void run(Worker worker, WorkerCall call) {
        Result result = worker.run();

        if (result != null) {
            if (result.isSuccess()) {
                call.call(result);
            } else if (result.worker != null) {
                run(result.worker, call);
            } else {
                call.call(result);
            }
        } else {
            call.call(null);
        }
    }


    public void put(String key, Worker worker) {
        workers.put(key, worker);
    }

    public Worker get(String key) {
        return workers.get(key);
    }

    public void remove(String key) {
        workers.remove(key);
    }

    public void clear() {
        workers.clear();
    }

    public static class ImpInstance {
        public static StrategyManager strategyManager = new StrategyManager();
    }

}
