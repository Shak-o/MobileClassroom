package ge.edu.btu.classroommobileversion.utils

import android.app.NotificationManager
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.app.NotificationCompat
import ge.edu.btu.classroommobileversion.R

object NotificationUtil {
    const val CHANNEL_ID = "MINE"
    fun  showNotification(context : Context, text : String, icon : Int) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(icon)
            .setContentTitle("This")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        manager.notify(1, builder.build())
    }
}