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

    // საუკეთესო სელექტი არაა მარა ეგაა რაცაა.
    // ერორს აბრუნებდა, როცა username და password გადაეცემოდა
    @Query("SELECT * FROM Users WHERE UserName = :arg0 AND Password = :arg1 ")
    fun getOneUser(arg0: String, arg1: String) : LiveData<User>
}