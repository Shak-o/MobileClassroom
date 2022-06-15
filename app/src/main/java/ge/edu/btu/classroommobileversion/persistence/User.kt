package ge.edu.btu.classroommobileversion.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "LastName") val lastName: String,
    @ColumnInfo(name = "Age") val age: Int,
    @ColumnInfo(name = "PersonalId") val personalId: Int,
    @ColumnInfo(name = "Type") val type: String,
    @ColumnInfo(name = "AcceptedDate") val acceptedDate: Date
)
