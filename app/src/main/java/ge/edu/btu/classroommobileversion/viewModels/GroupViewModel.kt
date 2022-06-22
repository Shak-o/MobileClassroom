package ge.edu.btu.classroommobileversion.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.SubjectWithGroup
import ge.edu.btu.classroommobileversion.persistence.data.User
import ge.edu.btu.classroommobileversion.persistence.dbcontext.AppDatabase
import ge.edu.btu.classroommobileversion.persistence.repositories.GroupRepository
import ge.edu.btu.classroommobileversion.persistence.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroupViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Group>>
    private val repo: GroupRepository
    init {
        val groupDao = AppDatabase.getDb(application).groupDao()
        repo = GroupRepository(groupDao)
        readAllData = repo.readAllData
    }

    fun getGroupsBySubject(subjectId : Int) : LiveData<List<SubjectWithGroup>> {
        return repo.getGroupsBySubject(subjectId)
    }

    fun addGroup(group: Group) {
        viewModelScope.launch ( Dispatchers.IO) {
            repo.addGroup(group)
        }
    }
}