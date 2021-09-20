package com.smsinterceptor;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Telephony;

import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {
SmsInterceptorBroadcastReceiver smsInterceptor = new SmsInterceptorBroadcastReceiver();
  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "SmsInterceptor";
  }

  //Use this method to Register the Broadcast when the app is is first started
  @Override
  public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
  }

  //Use this method to Register the Broadcast when the app is in the foreground and actively using it
  @Override
  protected void onStart() {
    super.onStart();
    IntentFilter smsFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
    //IntentFilter smsFilter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
    //registerReceiver(smsInterceptor, smsFilter);
    registerReceiver(smsInterceptor, smsFilter);
    System.out.println("################### BROADCST CREATED ##################");
  }

  //Use this method to Unregister the Broadcast when the app has been minimized
  @Override
  protected void onStop() {
    super.onStop();
    unregisterReceiver(smsInterceptor);
    System.out.println("################### BROADCST UNREGISTERED ##################");
  }

  //Use this method to Unregister the Broadcast until the app has been removed, not just minimized
  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}
