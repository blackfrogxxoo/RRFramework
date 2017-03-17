package me.shaoown.rrframework.engine;

import java.util.List;

/**
 * Created by black on 2017/3/17.
 */

public enum Manager {
    INSTANCE;
    private List<AbstractRequest> requestList;
    private List<AbstractResponse> responseList;

    public void addRequest(AbstractRequest request) {
        // TODO 判断能否Add
        requestList.add(request);
        // TODO Add后还有何操作
    }
}
