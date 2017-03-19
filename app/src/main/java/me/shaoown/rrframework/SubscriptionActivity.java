package me.shaoown.rrframework;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.shaoown.rrframework.bus.RxBus;
import me.shaoown.rrframework.bus.TapEvent;
import rx.Subscription;

/**
 * Created by black on 2017/3/19.
 */

public class SubscriptionActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private Subscription subscription;
    @Override
    protected void onResume() {
        super.onResume();
        subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unsubscribe();
    }

    protected void subscribe() {
        subscription = RxBus.INSTANCE.toObserverable()
                .subscribe(o -> {
                    if(o instanceof TapEvent) {
                        Log.i(TAG, "Receive an TapEvent: " + o);
                    } else {
                        Log.i(TAG, "Receive an unknown event: " + o);
                    }
                });
    }

    protected void unsubscribe() {
        if(subscription != null) {
            subscription.unsubscribe();
        }
    }
}
