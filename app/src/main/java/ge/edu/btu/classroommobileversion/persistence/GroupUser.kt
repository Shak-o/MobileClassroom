package ge.edu.btu.classroommobileversion.persistence

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation


data class GroupUser(
    @Embedded val group: Group,
    @Relation(
        entityColumn = "userId",
        parentColumn = "groupId",
        associateBy = Junction(GroupUserReference::class)
    )
    val users: List<User>
)
