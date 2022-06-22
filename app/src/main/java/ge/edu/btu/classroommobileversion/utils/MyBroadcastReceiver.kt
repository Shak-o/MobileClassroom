package ge.edu.btu.classroommobileversion.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import ge.edu.btu.classroommobileversion.R

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val test : Boolean

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            test = Settings.System.getInt(context?.getContentResolver(),
                Settings.System.WIFI_ON, 0) != 0;
        } else {
            test = Settings.Global.getInt(context?.getContentResolver(),
                Settings.Global.WIFI_ON, 0) != 0;
        }
        if (context != null) {
            if (test)
                NotificationUtil.showNotification(context,"You are connected to network, locally saved changes will be synced to cloud", R.drawable.ic_baseline_cloud_circle_24)
        }

    }
}