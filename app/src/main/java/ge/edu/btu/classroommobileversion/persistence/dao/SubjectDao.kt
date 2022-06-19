package ge.edu.btu.classroommobileversion.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.Subject
import ge.edu.btu.classroommobileversion.persistence.data.User

@Dao
interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSubject(vararg subject: Subject);

    @Query("SELECT * FROM Subjects")
    fun getSubjects(): LiveData<List<Subject>>
}