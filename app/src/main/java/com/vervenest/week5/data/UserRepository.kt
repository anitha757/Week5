package com.vervenest.week5.data

class UserRepository(private val userDao:UserDao) {
    val readAllData: List<User> = userDao.getAll()

    fun addUser(user:User){
        userDao.addUser(user)
    }
    fun deleteUser(user:User){
        userDao.delete(user)
    }
    fun getAll(): List<User> {
        return userDao.getAll()
    }
    fun deleteUser(uid:Int){
        userDao.deleteUser(uid)
    }
    fun getUser(uid: Int): User {
        return userDao.findById(uid)
    }

}