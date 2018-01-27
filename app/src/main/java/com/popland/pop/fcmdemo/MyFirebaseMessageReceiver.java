package com.popland.pop.fcmdemo;


import android.content.Intent;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessageReceiver extends FirebaseMessagingService {

    public MyFirebaseMessageReceiver() {
    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {//when foreground, the method receive message from notification composer
        super.onMessageReceived(remoteMessage);
        Log.i("MMM from:",remoteMessage.getFrom());
        Log.i("MMM notification: ",remoteMessage.getNotification().getBody());

        sendNotification(remoteMessage.getData().get("number"));
    }

    //get Data foreground app
    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//use old instance of MainActivity
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//call startActivity out of Activity
        intent.putExtra("number",messageBody);
        startActivity(intent);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        //String channelId = getString(R.string.default_notification_channel_id);
//        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder =
//                new NotificationCompat.Builder(this)
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setContentTitle("FCM Message")
//                        .setContentText(messageBody)
//                        .setAutoCancel(true)
//                        .setSound(defaultSoundUri)
//                        .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

}
