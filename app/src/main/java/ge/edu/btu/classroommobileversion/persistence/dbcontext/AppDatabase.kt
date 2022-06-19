package ge.edu.btu.classroommobileversion.persistence.dbcontext

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ge.edu.btu.classroommobileversion.persistence.dao.GroupDao
import ge.edu.btu.classroommobileversion.persistence.dao.SubjectDao
import ge.edu.btu.classroommobileversion.persistence.dao.UserDao
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.Subject
import ge.edu.btu.classroommobileversion.persistence.data.User

@Database(entities = [User :: class, Group :: class, Subject :: class], version = 2 )
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun groupDao(): GroupDao
    abstract fun subjectDao(): SubjectDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDb(context: Context): AppDatabase {
            val temporal = INSTANCE

            if (temporal != null)
                return temporal

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Classroom"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}