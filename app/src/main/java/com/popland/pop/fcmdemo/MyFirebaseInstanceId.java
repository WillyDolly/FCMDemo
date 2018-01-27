package com.popland.pop.fcmdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

public class MyFirebaseInstanceId extends FirebaseInstanceIdService {
    public MyFirebaseInstanceId() {
    }

    @Override
    public void onTokenRefresh() {
       // super.onTokenRefresh();
        Log.d("MMM ","refresh token");
        String tokenRefresh = FirebaseInstanceId.getInstance().getToken();
        Log.i("MMMM token",tokenRefresh);

        //sendRegistrationToServer(tokenRefresh);
    }
}
