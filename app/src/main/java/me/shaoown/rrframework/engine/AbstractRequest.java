package me.shaoown.rrframework.engine;

import java.util.Date;

/**
 * Request基类
 *
 * Created by black on 2017/3/17.
 */

public abstract class AbstractRequest { // TODO implements Parcelable
    private int id;
    private int type;
    private Date createAt;
    private Object data;

    protected AbstractRequest(int id, int type, Object data) {
        this.id = id;
        this.type = type;
        this.createAt = new Date();
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Object getData() {
        return data;
    }
}
