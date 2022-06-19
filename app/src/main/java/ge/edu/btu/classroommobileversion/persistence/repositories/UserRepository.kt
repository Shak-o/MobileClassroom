package ge.edu.btu.classroommobileversion.persistence.repositories

import androidx.lifecycle.LiveData
import ge.edu.btu.classroommobileversion.persistence.dao.UserDao
import ge.edu.btu.classroommobileversion.persistence.data.User

class UserRepository(private val userDao: UserDao) {
    val readAllData : LiveData<List<User>> = userDao.getUsers()

    suspend fun getOneUser(userName : String, password: String) : LiveData<User> {
        return userDao.getOneUser(userName, password)
    }

    suspend fun addUser(user : User) {
        userDao.addUser(user)
    }
}