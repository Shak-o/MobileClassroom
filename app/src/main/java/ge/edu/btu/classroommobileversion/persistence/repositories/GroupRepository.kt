package ge.edu.btu.classroommobileversion.persistence.repositories

import androidx.lifecycle.LiveData
import ge.edu.btu.classroommobileversion.persistence.dao.GroupDao
import ge.edu.btu.classroommobileversion.persistence.dao.UserDao
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.SubjectWithGroup
import ge.edu.btu.classroommobileversion.persistence.data.User

class GroupRepository(private val groupDao: GroupDao) {
    val readAllData : LiveData<List<Group>> = groupDao.getGroups()

    fun getGroupsBySubject(subjectId: Int) : LiveData<List<SubjectWithGroup>> {
        return groupDao.getGroupsBySubject(subjectId)
    }

    suspend fun addGroup(group: Group) {
        groupDao.addGroup(group)
    }
}