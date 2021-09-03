package com.vervenest.week5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.vervenest.week5.data.User


class UsersAdapter(context: Context?, users: List<User>?) :
    ArrayAdapter<User?>(context!!, 0, users!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val user = getItem(position)
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                .inflate(R.layout.activity_single_list_item, parent, false)
        }
        val name = convertView!!.findViewById<View>(R.id.name) as TextView
        val userDetails = convertView.findViewById<View>(R.id.userDetails) as TextView
        name.text = user!!.userName
        userDetails.text = "Age:" + user.age + " | Gender:" + user.gender
        return convertView
    }

}
