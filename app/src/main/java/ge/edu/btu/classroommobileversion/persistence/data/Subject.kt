package ge.edu.btu.classroommobileversion.persistence.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true) val subjectId: Int,
    @ColumnInfo(name = "GroupId") val groupId: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "HomeworkAmount") val homeworkAmount: Int,
    @ColumnInfo(name = "Barrier") val barrier: Int,
)
