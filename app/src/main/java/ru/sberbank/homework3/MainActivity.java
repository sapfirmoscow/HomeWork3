package ru.sberbank.homework3;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver broadcastReceiver;
    IntentFilter intentFilter;

    Button onChangeButton;
    TextView stateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initViews();
        initListeners();


    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, intentFilter, "ru.sberbank.SEND_MESSAGES_PERMISSION", null);
        getState();
    }


    private void updateState() {
        startService(MyIntentService.newInteent(MainActivity.this));
    }

    private void getState() {
        startService(MyIntentService.newInteent(MainActivity.this).putExtra("update", true));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);

    }

    private void initListeners() {
        onChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateState();
            }
        });
    }

    private void initViews() {
        onChangeButton = findViewById(R.id.changeButton);
        stateTextView = findViewById(R.id.stateTextView);
    }

    private void init() {
        broadcastReceiver = new MyBroadcastReceiver(new ViewCallbackImpl());
        intentFilter = new IntentFilter("ru.sberbank.SEND_MESSAGES_FILTER");
    }

    private class ViewCallbackImpl implements ViewCallback {

        @Override
        public void onStatusChanged(String newStatus) {
            stateTextView.setText(newStatus);
        }
    }


}
