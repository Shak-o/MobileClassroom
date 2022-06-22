package ge.edu.btu.classroommobileversion.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.SubjectWithGroup
import ge.edu.btu.classroommobileversion.persistence.data.User

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addGroup(vararg group: Group);

    @Transaction
    @Query("SELECT * FROM Subjects WHERE subjectId = :subjectId")
    fun getGroupsBySubject(subjectId : Int) : LiveData<List<SubjectWithGroup>>

    @Query("SELECT * FROM Groups")
    fun getGroups(): LiveData<List<Group>>
}