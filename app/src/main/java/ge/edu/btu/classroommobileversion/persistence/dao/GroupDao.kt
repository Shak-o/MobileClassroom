package ge.edu.btu.classroommobileversion.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.User

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addGroup(vararg group: Group);

    @Query("SELECT * FROM Groups")
    fun getGroups(): LiveData<List<Group>>
}