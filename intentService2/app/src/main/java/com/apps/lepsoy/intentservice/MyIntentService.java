package com.apps.lepsoy.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService{

    private static final String TAG = "com.apps.lepsoy.service";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
    Log.i(TAG, "Service is running");
    }
}
