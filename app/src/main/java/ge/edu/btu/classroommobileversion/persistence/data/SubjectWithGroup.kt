package ge.edu.btu.classroommobileversion.persistence.data

import androidx.room.Embedded
import androidx.room.Relation


data class SubjectWithGroup(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectId",
        entityColumn = "ParentSubjectId"
    )
    val groups: List<Group>
)
