package me.shaoown.rrframework.engine;

/**
 * Created by black on 2017/3/17.
 */

public class RequestFactory {
    public static final int TYPE_MAIN = 1;
    public static final int TYPE_SECOND= 2;
    public static <T extends AbstractRequest> T createRequest(int type, Object data) {
        AbstractRequest request = null;
        switch (type) {
            case TYPE_MAIN:

                break;
            case TYPE_SECOND:

                break;
            default:
                throw new IllegalArgumentException("Request Type " + type + "is not implemented");
        }
        return (T) request;
    }
}
