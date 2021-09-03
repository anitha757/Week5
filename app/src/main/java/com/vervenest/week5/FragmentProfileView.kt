package com.vervenest.week5

import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.vervenest.week5.data.User


class FragmentProfileView : Fragment() {
    private var username: TextView? = null
    private var email: TextView? = null
    private var gender: TextView? = null
    private var dob: TextView? = null
    private var age: TextView? = null
    var time: TextView? = null
    var button: Button? = null
    var deleteButton: ImageButton? = null
    private var dialogClickListener =
        DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    val b = arguments
                    if (b != null) {
                        val uid: String? = b.getString("uid")
                        val ma1 = activity as MainActivity?
                        if (uid != null) {
                            ma1!!.deleteUser(uid)
                        }
                        ma1!!.listView()
                    }
                }
                DialogInterface.BUTTON_NEGATIVE -> {
                }
            }
        }

    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_profile_view, container, false)
        username = v.findViewById(R.id.textOne)
        email = v.findViewById(R.id.textTwo)
        gender = v.findViewById(R.id.textThree)
        dob = v.findViewById(R.id.textFour)
        age = v.findViewById(R.id.textFive)
        time = v.findViewById(R.id.textSix)
        deleteButton = v.findViewById(R.id.deleteButton)
        button = v.findViewById(R.id.okBtn)
        val b = arguments
        if (b != null) {
            val uid: String? = b.getString("uid")
            println("displayview:"+uid)
            val ma1 = activity as MainActivity?
            var user: User? = null
            if (uid != null) {
                user  = ma1!!.getUser(uid)
            }
            if (user != null) {
                username!!.text = "Username : " + user.userName
                email!!.text = "Email : " + user.email
                gender!!.text = "Gender : " + user.gender
                age!!.text = "Age : " + user.age
                dob!!.text = "DOB : " + user.dob
                time!!.text = "Time : " + user.time
            }

            deleteButton!!.setOnClickListener(View.OnClickListener { v ->
                val builder = AlertDialog.Builder(v.context)
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show()
            })
            button!!.setOnClickListener(View.OnClickListener {
                val ma = activity as MainActivity?
                ma!!.listView()
            })
        }
        return v
    }
}