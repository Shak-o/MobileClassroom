package ge.edu.btu.classroommobileversion

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ge.edu.btu.classroommobileversion.persistence.data.Subject
import ge.edu.btu.classroommobileversion.utils.MyBroadcastReceiver
import ge.edu.btu.classroommobileversion.utils.NotificationUtil
import ge.edu.btu.classroommobileversion.viewModels.SubjectViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var subjectViewModel: SubjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        bottomNavigationView.setupWithNavController(navController)
        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel :: class.java)

//        val subject = Subject(0,  "Test Group 2", "Lorem ipsum dolor sit amet", 5, 100)
//
//        subjectViewModel.addSubject(subject)
        val br: BroadcastReceiver = MyBroadcastReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_MANAGE_NETWORK_USAGE)
        }
        registerReceiver(br, filter)

        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel =
            NotificationChannel(NotificationUtil.CHANNEL_ID, "MINE", importance).apply {
                description = "descriptionText"
            }
        val notificationManager: NotificationManager =
            baseContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}