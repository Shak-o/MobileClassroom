package ge.edu.btu.classroommobileversion.persistence.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Groups")
data class Group (
    @PrimaryKey(autoGenerate = true) val groupId: Int,
    @ColumnInfo(name = "LecturerId") val lectureId: Int,
    @ColumnInfo(name = "ParentSubjectId") val parentSubjectId: Int,
    @ColumnInfo(name = "GroupNumber") val groupNumber: Float,
    @ColumnInfo(name = "RoomNumber") val roomNumber: Float,
    @ColumnInfo(name = "Capacity") val capacity: Int,
    @ColumnInfo(name = "StartTime") val startTime: String,
    @ColumnInfo(name = "EndTime") val endTime: String,
)