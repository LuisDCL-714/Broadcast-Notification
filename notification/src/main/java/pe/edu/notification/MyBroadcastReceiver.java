package pe.edu.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private String action;
    private Intent newIntent;
    private PendingIntent pendingIntent;
    private NotificationCompat.Builder notification;
    private NotificationManagerCompat managerCompat;
    @Override
    public void onReceive(Context context, Intent intent) {
        action = intent.getAction();
        if(action.equals("pe.edu.cibertec.broadcast.ACTION")){
            newIntent = new Intent(context, NotificationReceiverActivity.class);

            pendingIntent = PendingIntent.getActivity(context, 1, newIntent, 0);
            notification = new NotificationCompat.Builder(context, "Canal")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Notificación nueva")
            .setContentText("Esto es una nueva notificación")
            .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent);

            managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(0, notification.build());

        }
    }
}
