package ge.edu.btu.classroommobileversion.persistence.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity("Groups")
data class Group (
    @PrimaryKey(autoGenerate = true) val groupId: Int,
    @ColumnInfo(name = "LecturerId") val lectureId: Int,
    @ColumnInfo(name = "ParentSubjectId") val parentSubjectId: Int,
    @ColumnInfo(name = "GroupNumber") val groupName: Float,
    @ColumnInfo(name = "RoomNumber") val roomNumber: Float,
    @ColumnInfo(name = "Capacity") val capacity: Int,
    @ColumnInfo(name = "Times") val times: Date,
)