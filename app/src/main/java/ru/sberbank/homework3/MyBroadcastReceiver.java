package ru.sberbank.homework3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private ViewCallback viewCallback;

    public MyBroadcastReceiver() {
    }

    public MyBroadcastReceiver(ViewCallback viewCallback) {
        this.viewCallback = viewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        StateManager stateManager = StateManager.getInstanse();

        boolean isUpdate = intent.getBooleanExtra("update", false);
        if (isUpdate) {
            viewCallback.onStatusChanged(stateManager.getState().toString());
        } else {
            stateManager.updateState();
            viewCallback.onStatusChanged(stateManager.getState().toString());
        }

    }
}
