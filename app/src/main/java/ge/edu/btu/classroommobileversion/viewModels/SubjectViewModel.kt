package ge.edu.btu.classroommobileversion.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.Subject
import ge.edu.btu.classroommobileversion.persistence.data.User
import ge.edu.btu.classroommobileversion.persistence.dbcontext.AppDatabase
import ge.edu.btu.classroommobileversion.persistence.repositories.GroupRepository
import ge.edu.btu.classroommobileversion.persistence.repositories.SubjectRepository
import ge.edu.btu.classroommobileversion.persistence.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Subject>>
    private val repo: SubjectRepository
    init {
        val subjectDao = AppDatabase.getDb(application).subjectDao()
        repo = SubjectRepository(subjectDao)
        readAllData = repo.readAllData
    }

    fun addSubject(subject: Subject) {
        viewModelScope.launch ( Dispatchers.IO) {
            repo.addSubject(subject)
        }
    }
}