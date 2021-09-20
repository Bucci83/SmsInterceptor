package com.smsinterceptor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsInterceptorBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            //Toast.makeText(context, "SMS Received", Toast.LENGTH_SHORT).show();
            SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for(SmsMessage message : messages){
                Toast.makeText(context, message.getMessageBody(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
