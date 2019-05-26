package pe.edu.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private String action;
    @Override
    public void onReceive(Context context, Intent intent) {
        action = intent.getAction();

        if(action.equals("pe.edu.cibertec.broadcast.ACTION")){
            Toast.makeText(context, "Llego una notificación", Toast.LENGTH_LONG).show();
        }

    }
}
