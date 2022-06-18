package ge.edu.btu.classroommobileversion.persistence.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "LastName") val lastName: String,
    @ColumnInfo(name = "UserName") val userName: String,
    @ColumnInfo(name = "Age") val age: Int,
    @ColumnInfo(name = "PersonalId") val personalId: String,
    @ColumnInfo(name = "Type") val type: String,
    @ColumnInfo(name = "AcceptedDate") val acceptedDate: String,
    @ColumnInfo(name = "Password") val password: String
)
