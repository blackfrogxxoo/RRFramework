package me.shaoown.rrframework.engine;

import java.util.Date;

/**
 * Request基类
 * Created by black on 2017/3/17.
 */

public abstract class AbstractResponse {
    private int id;
    private int requestId;
    private Date createAt;
    private Object data;

    protected AbstractResponse(int id, int requestId, Object data) {
        this.id = id;
        this.requestId = requestId;
        this.createAt = new Date();
        this.data = data;
    }
    public int getId() {
        return id;
    }

    public int getRequestId() {
        return requestId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Object getData() {
        return data;
    }
}
