package me.shaoown.rrframework;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.shaoown.rrframework.engine.AbstractRequest;
import me.shaoown.rrframework.engine.AbstractResponse;
import me.shaoown.rrframework.engine.Manager;
import me.shaoown.rrframework.engine.RequestFactory;
import me.shaoown.rrframework.engine.ResponseListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AbstractRequest request = RequestFactory.createRequest(RequestFactory.TYPE_MAIN, "Main Request");
        AbstractRequest request = new MainRequest(1, RequestFactory.TYPE_MAIN, "Main Request");
        Manager.INSTANCE.addRequest(request);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerResponseListenerOrNot(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        registerResponseListenerOrNot(false);
    }

    private void registerResponseListenerOrNot(boolean register) {

    }

    static class MainRequest extends AbstractRequest {

        MainRequest(int id, int type, Object data) {
            super(id, type, data);
        }
    }

    static class MainResponse extends AbstractResponse {

        protected MainResponse(int id, int requestId, Object data) {
            super(id, requestId, data);
        }

    }
}
