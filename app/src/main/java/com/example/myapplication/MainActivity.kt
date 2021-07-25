package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          todoAdapter = TodoAdapter(mutableListOf())

          rvList.adapter = todoAdapter
          rvList.layoutManager =LinearLayoutManager(this)
          btnAdd.setOnClickListener {
              val todoTitle = etTodo.text.toString()
              if(todoTitle.isNotEmpty())
              {
                  val todo = Todo(todoTitle)
                  todoAdapter.addTodo(todo)
                  etTodo.text.clear()
              }
          }
          btnDelete.setOnClickListener{
              todoAdapter.deleteDoneTodos()
          }

    }
}