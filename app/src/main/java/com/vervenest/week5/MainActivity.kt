package com.vervenest.week5

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.vervenest.week5.data.AppDatabase
import com.vervenest.week5.data.User
import com.vervenest.week5.data.UserRepository


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView()
    }

    fun listView() {
        supportFragmentManager.beginTransaction().replace(R.id.frame1, FragmentListView())
            .commit()
    }

    fun listView(userList: List<User>) {
        supportFragmentManager.beginTransaction().replace(R.id.frame1, FragmentListView())
            .commit()
    }

    fun display(user: User) {
        val fdv = FragmentProfileView()
        val b = Bundle()
        println("@@@@@@@@@@@@@@@@@@@@@@@@display:"+user.uid)
        b.putString("userId", user.uid.toString())
        fdv.arguments = b
        supportFragmentManager.beginTransaction().replace(R.id.frame1, fdv)
            .commit()
    }

    fun replace() {
        supportFragmentManager.beginTransaction().replace(R.id.frame1, FragmentRegistration())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_items, menu)
        return true
    }

    fun saveUsersList(userInfoList: List<User?>?) {
        var userDao = AppDatabase.getDatabase(application).userDao()
        val repository = UserRepository(userDao)
        if (userInfoList != null) {
            for (user in userInfoList) {
                if (user != null) {
                    repository.addUser(user)
                }
            }
        }
    }

    fun getUsersList(): List<User> {
        var userDao = AppDatabase.getDatabase(application).userDao()
        val repository = UserRepository(userDao)
        return repository.getAll()
    }

    fun deleteUser(uid: String): List<User> {
        var userDao = AppDatabase.getDatabase(application).userDao()
        val repository = UserRepository(userDao)
        if (uid != null) {
            repository.deleteUser(Integer.parseInt(uid))
        }
        return repository.getAll()
    }
    fun getUser(uid: String): User {
        var userDao = AppDatabase.getDatabase(application).userDao()
        val repository = UserRepository(userDao)
        println("getUser:"+uid)
        return repository.getUser(Integer.parseInt(uid))
    }

    fun addUser(user: User): List<User>  {
        var userDao = AppDatabase.getDatabase(application).userDao()
        val repository = UserRepository(userDao)
        if (user != null) {
            repository.addUser(user)
        }
        return repository.getAll()
    }

}