package ge.edu.btu.classroommobileversion.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ge.edu.btu.classroommobileversion.persistence.data.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(vararg user: User);

    @Query("SELECT * FROM Users")
    fun getUsers(): LiveData<List<User>>
}