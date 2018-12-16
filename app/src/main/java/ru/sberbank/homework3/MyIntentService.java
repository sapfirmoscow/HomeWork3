package ru.sberbank.homework3;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    public static final Intent newInteent(Context context) {
        return new Intent(context, MyIntentService.class);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent broadcastIntent = new Intent("ru.sberbank.SEND_MESSAGES_FILTER");

        boolean isUpdate = intent.getBooleanExtra("update", false);
        if (isUpdate) {
            broadcastIntent.putExtra("update", true);
        }

        sendBroadcast(broadcastIntent, "ru.sberbank.SEND_MESSAGES_PERMISSION");

    }
}
