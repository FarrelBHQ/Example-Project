package com.example.exampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.exampleproject.databinding.ActivityMainBinding
import com.example.exampleproject.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var tvMoveResult: TextView
    lateinit var binding: ActivityResultBinding

    companion object {
        const val RESULT = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvMoveResult = binding.tvResult
        val result = intent.getStringExtra(RESULT)
        tvMoveResult.text = result

        val btnBackToMain: Button = binding.btnBackToMain

        btnBackToMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}