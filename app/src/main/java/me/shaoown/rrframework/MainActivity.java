package me.shaoown.rrframework;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

import me.shaoown.rrframework.bus.RxBus;
import me.shaoown.rrframework.bus.TapEvent;
import me.shaoown.rrframework.engine.AbstractRequest;
import me.shaoown.rrframework.engine.AbstractResponse;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnTap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AbstractRequest request = RequestFactory.createRequest(RequestFactory.TYPE_MAIN, "Main Request");
//        AbstractRequest request = new MainRequest(1, RequestFactory.TYPE_MAIN, "Main Request");
//        Manager.INSTANCE.addRequest(request);

        btnTap = (Button) findViewById(R.id.btn_tap);
        btnTap.setOnClickListener(v -> {
            TapEvent event = new TapEvent(new Date());
//            new Handler().postDelayed(() -> RxBus.INSTANCE.post(event), 0);
            new Handler().post(() -> RxBus.INSTANCE.post(event));
        });
        RxBus.INSTANCE.toObserverable()
                .subscribe(o -> {
                    if(o instanceof TapEvent) {
                        Log.i(TAG, "Receive an TapEvent: " + o);
                    } else {
                        Log.i(TAG, "Receive an unknown event: " + o);
                    }
                });
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
