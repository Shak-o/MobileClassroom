package ge.edu.btu.classroommobileversion.persistence.repositories

import androidx.lifecycle.LiveData
import ge.edu.btu.classroommobileversion.persistence.dao.GroupDao
import ge.edu.btu.classroommobileversion.persistence.dao.SubjectDao
import ge.edu.btu.classroommobileversion.persistence.dao.UserDao
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.Subject
import ge.edu.btu.classroommobileversion.persistence.data.User

class SubjectRepository(private val subjectDao: SubjectDao) {
    val readAllData : LiveData<List<Subject>> = subjectDao.getSubjects()

    suspend fun addSubject(subject: Subject) {
        subjectDao.addSubject(subject)
    }
}