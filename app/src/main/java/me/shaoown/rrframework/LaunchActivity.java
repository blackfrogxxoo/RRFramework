package me.shaoown.rrframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import me.shaoown.rrframework.bus.RxBus;
import me.shaoown.rrframework.bus.TapEvent;

public class LaunchActivity extends AppCompatActivity {
    private static final String TAG = "LaunchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        RxBus.INSTANCE.toObserverable()
                .subscribe(o -> {
                    if(o instanceof TapEvent) {
                        Log.i(TAG, "Receive an TapEvent: " + o);
                        Toast.makeText(getApplicationContext(),
                                "Tap at " + (System.currentTimeMillis() - ((TapEvent)o).getCreatedAt().getTime()) + " mills ago", Toast.LENGTH_LONG).show();
                    } else {
                        Log.i(TAG, "Receive an unknown event: " + o);
                    }
                });
    }

    public void startNewActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
