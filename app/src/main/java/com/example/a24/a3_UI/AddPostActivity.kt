package com.example.a24.a3_UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.a24.R
import com.example.a24.a3_UI.postRulers.CheckPostRules
import com.example.a24.databinding.ActivityAddPostBinding
import java.sql.Timestamp

class AddPostActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AddPostActivity::class.java)
            context.startActivity(intent)
        }
    }

    lateinit var binding: ActivityAddPostBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        setupBinding()
        setupButtonListener()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_post)
    }

    private fun setupButtonListener() {
        binding.btnGoToMain.setOnClickListener {
            MainActivity.start(this)
        }
        binding.btnAddPost.setOnClickListener {
            var userPostBody = binding.etAddBody.text.toString()
            var userPostTitle = binding.etAddTitle.text.toString()


            checkPostRules(userPostBody, userPostTitle)

        }
    }

    private fun checkPostRules(userPostBody: String, userPostTitle: String)/*:Boolean*/ {
        val postRules = CheckPostRules(userPostBody, userPostTitle)
        println(postRules.checkLenghtTitle())
        println(postRules.checkLenghtBody())

        if (postRules.checkLenghtTitle() && postRules.checkLenghtBody()) {
            updateRepository(userPostBody,userPostTitle,20,Timestamp(System.currentTimeMillis()))
            println(Timestamp(System.currentTimeMillis()))
        }


    }

    private fun updateRepository(userPostBody: String, userPostTitle: String, id:Int, timestamp: Timestamp) {

    }
}