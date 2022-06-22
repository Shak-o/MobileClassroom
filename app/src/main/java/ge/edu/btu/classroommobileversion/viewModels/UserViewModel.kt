package ge.edu.btu.classroommobileversion.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ge.edu.btu.classroommobileversion.persistence.data.User
import ge.edu.btu.classroommobileversion.persistence.dbcontext.AppDatabase
import ge.edu.btu.classroommobileversion.persistence.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<User>>
    private val repo: UserRepository
    val userLiveData = MutableLiveData<User>()
    init {
        val userDao = AppDatabase.getDb(application).userDao()
        repo = UserRepository(userDao)
        readAllData = repo.readAllData
    }

//    fun getUser(name: String, password:String){
//        val disposableUser = repo.getOneUser(name, password).subscribe({
//                userLivedata.postValue(it)
//            })
    fun getUserByPassAndName(userName :String, password: String) : LiveData<User>? {
        var result : LiveData<User>
        viewModelScope.launch ( Dispatchers.IO) {
            result =  repo.getOneUser(userName, password)
        }
        return null
    }

    fun addUser(user: User) {
        viewModelScope.launch ( Dispatchers.IO) {
            repo.addUser(user)
        }
    }
}