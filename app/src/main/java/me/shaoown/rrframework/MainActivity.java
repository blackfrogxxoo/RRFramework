package me.shaoown.rrframework;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

import me.shaoown.rrframework.bus.DeadEvent;
import me.shaoown.rrframework.bus.RxBus;
import me.shaoown.rrframework.bus.TapEvent;
import me.shaoown.rrframework.engine.AbstractRequest;
import me.shaoown.rrframework.engine.AbstractResponse;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends SubscriptionActivity {
    private static final String TAG = "MainActivity";
    private Subscription deadEventSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void subscribeDeadEvent() {
        deadEventSubscription = RxBus.INSTANCE.toObserverable()
                .subscribe(o -> {
                    if(o instanceof DeadEvent) {
                        startActivity(new Intent(getApplicationContext(),
                                LaunchedByDeadEventActivity.class));
                    }
                });
    }

    public void sendTapEvent(View view) {
        if(RxBus.INSTANCE.hasObservers()) {
            TapEvent event = new TapEvent(new Date());
            new Handler().post(() -> RxBus.INSTANCE.post(event));
        } else {
            subscribeDeadEvent();
            DeadEvent deadEvent = new DeadEvent(new Date());
            RxBus.INSTANCE.post(deadEvent);
        }
    }

    public void unsubscribe(View view) {
        unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(deadEventSubscription != null) {
            deadEventSubscription.unsubscribe();
        }
    }
}
