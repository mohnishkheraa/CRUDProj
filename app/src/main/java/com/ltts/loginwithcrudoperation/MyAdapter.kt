package com.ltts.complexrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ltts.loginwithcrudoperation.R

class MyAdapter (var userlist:ArrayList<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    class MyViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)
    {
        fun holdingViews(users: Data)
        {
            var myName = itemView.findViewById<TextView>(R.id.textViewName)
            var myEmail = itemView.findViewById<TextView>(R.id.textViewEmail)
            var myNumber = itemView.findViewById<TextView>(R.id.textViewNumber)

            myName.setText(users.name)
            myEmail.setText(users.email)
            myNumber.setText(users.phone)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //var v=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        var v=LayoutInflater.from(parent.context).inflate(R.layout.carditem_layout,parent,false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.holdingViews(userlist[position])
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}