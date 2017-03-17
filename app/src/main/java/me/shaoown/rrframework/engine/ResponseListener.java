package me.shaoown.rrframework.engine;

/**
 * Created by black on 2017/3/17.
 */

public interface ResponseListener {
    int getType();
    void onResponse(AbstractResponse response);
}
