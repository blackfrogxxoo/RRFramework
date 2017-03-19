package me.shaoown.rrframework.bus;

import java.util.Date;

/**
 * Created by black on 2017/3/19.
 */

public class TapEvent {
    private final Date createdAt;
    public TapEvent(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
}
