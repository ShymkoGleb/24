package com.example.a24.a3_UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a24.R
import com.example.a24.a3_UI.modelUi.UsersPostUIModel
import com.example.a24.a3_UI.recyclerViewAdapter.RecyclerViewAdapter
import com.example.a24.databinding.ActivityMainBinding

/*Додаток, де можна переглядати пости, які отримуються по цьому запиту:
https://jsonplaceholder.typicode.com/posts
На UI потрібно показувати userId, title, body. Дизайн на ваш розсуд.
Повинно також бути сховище даних, де будуть зберігатись id юзерів, у яких є “попередження” або “бан”.
В додатку повинно бути захардкоджено, що userId 3 та 4 є попередження. А у userId 7— бан.

Якщо у юзера “бан”, то замість КОЖНОГО його посту на ui повинні показуватися view, де буде написано, що “Тут міг бути пост юзера $userId, але він забанений”.
Якщо у юзера “попередження”, то після id юзера на ui повинен бути текст “З попередженням”, а фон всього посту повинен відрізнятись від фону постів юзерів, у яких немає попередження.
Наприклад, у звичайних постів білий фон, а у тих, що з попередженням — червоний.
*/
class MainActivity : AppCompatActivity() {

    companion object{
        fun start(context: Context){
            val intent=Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }

    }


    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var adapter: RecyclerViewAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDataBinding()
        setupAdapter()
        observeUsersPost()
        //   updateUsersPosts()
        viewModel.getUsersPost()
        setupButtonListener()
    }

    private fun setupButtonListener() {
        binding.btnAddPost.setOnClickListener {
            AddPostActivity.start(this)
        }
    }

    private fun observeUsersPost() {
        viewModel.reposUsersPostsLiveData.observe(this, Observer {
            updateUsersPosts(it)
        })
    }


    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun setupAdapter() {
        adapter = RecyclerViewAdapter()
        binding.rvUserData.adapter = adapter
        binding.rvUserData.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun updateUsersPosts(usersPostsList: List<UsersPostUIModel>) {
        adapter?.updateAdapter(usersPostsList)
    }
}


