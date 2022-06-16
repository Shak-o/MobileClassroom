package ge.edu.btu.classroommobileversion.persistence.data

import androidx.room.*


data class UserGroup (
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "groupId",
        associateBy = Junction(GroupUserReference::class)
    )
    val groups: List<Group>
)