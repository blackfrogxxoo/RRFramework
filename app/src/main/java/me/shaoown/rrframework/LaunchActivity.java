package me.shaoown.rrframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import me.shaoown.rrframework.bus.RxBus;
import me.shaoown.rrframework.bus.TapEvent;
import rx.Subscription;

public class LaunchActivity extends SubscriptionActivity {
    private static final String TAG = "LaunchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    public void startNewActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
