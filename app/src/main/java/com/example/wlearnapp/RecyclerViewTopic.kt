package com.example.wlearnapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wlearnapp.databinding.ActivityRecyclerViewTopicBinding
import kotlinx.android.synthetic.main.activity_recycler_view_topic.*

class RecyclerViewTopic : AppCompatActivity(), OnTopicItemClickListener {
    private lateinit var binding: ActivityRecyclerViewTopicBinding
    private lateinit var topiclist: ArrayList<Topic>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_view_topic)
        topiclist = ArrayList()
        addTopic()
        val topSpacing = TopSpacingItemDecoration(30)
        topicRecycler.addItemDecoration(topSpacing)
        topicRecycler.layoutManager = LinearLayoutManager(this)
        topicRecycler.addItemDecoration(DividerItemDecoration(this,1))
        topicRecycler.adapter = RecyclerViewAdapter(topiclist,this)

    }

    fun addTopic(){
        topiclist.add(Topic( "Learning",
            "Internet Protocol(IP)\nTransport Control Protocol/User Datagram Protocol(UDP)" +
                    "\nInternet Control Message \nCharacteristics of OSI Model\nFunctions of the OSI Layers\nStop-and-Wait ARQ\n" +
                    "Go-Back-N ARQ\n" +
                    "Selective Repeat ARQ/Selective Reject ARQDistance Vector(RIP,IGRP)\n" +
                    "Link State(OSPF,IS-IS)\n\n",R.drawable.study))
        topiclist.add(Topic( "Exercise",
            "Practice helps improve skills and make you better at what you do. If you routinely practice a certain skill, you will get good at it.\n\n",R.drawable.practice))
        topiclist.add(Topic( "Quiz",
            "Exams and tests are a great way to assess what the students have learned with regards to particular subjects. Exams will show what part of the lesson each student seems to have taken the most interest in and has remembered\n\n",R.drawable.test))

    }


    override fun onItemClick(item: Topic, position: Int) {
        var intent = Intent(this, LoginActivity::class.java)
        if(position.toString() == "0"){
            //Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
            intent = Intent(this, LessonActivity::class.java)
        }else if(position.toString() == "1"){
            intent = Intent(this, FragmentTab::class.java)
        }else{
            intent = Intent(this, QuizActivity::class.java)
        }

        //intent.putExtra("TOPICNAME",item.topics)
        //intent.putExtra("TOPICDES",item.description)

        startActivity(intent)
    }
}