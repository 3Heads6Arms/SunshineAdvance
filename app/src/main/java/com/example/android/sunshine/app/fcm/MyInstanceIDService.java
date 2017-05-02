package com.example.android.sunshine.app.fcm;
/*
 * Copyright (C) 2013 The Android Open Source Project
 */

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by AnhHo on 4/29/2017.
 */

public class MyInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        // This token suppose to be sent to server
        Log.d("test", FirebaseInstanceId.getInstance().getToken());

    }
}
