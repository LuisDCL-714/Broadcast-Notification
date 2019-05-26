package pe.edu.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

    private MyBroadcastReceiver myBroadcastReceiver;
    private IntentFilter intentFilter;
    private String name, description;
    private int importance;
    private NotificationChannel notificationChannel;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        register();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            name = "pe.edu.notification.CHANNEL";
            description = "Descripción";
            importance = NotificationManager.IMPORTANCE_DEFAULT;

            notificationChannel = new NotificationChannel("Canal", name, importance);
            notificationChannel.setDescription(description);

            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void register() {
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("pe.edu.cibertec.broadcast.ACTION");
        this.registerReceiver(myBroadcastReceiver, intentFilter);
    }
}
