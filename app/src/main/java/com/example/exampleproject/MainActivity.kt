package com.example.exampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.exampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLength : EditText
    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var btnResult: Button
    private lateinit var tvResult : TextView
    lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edtLength = binding.edtLength
        edtWidth = binding.edtWidth
        edtHeight = binding.edtHeight
        btnResult = binding.btnResult

        btnResult.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_result){
            val getLength = edtLength.text.toString().trim()
            val getWidth = edtWidth.text.toString().trim()
            val getHeight = edtHeight.text.toString().trim()
            val msg = "This field is required"

            if (getLength.isEmpty()){
                edtLength.error = msg
                return
            }
            if (getWidth.isEmpty()){
                edtWidth.error = msg
                return
            }
            if (getHeight.isEmpty()){
                edtHeight.error = msg
                return
            }

            val result = getLength.toDouble() * getWidth.toDouble() * getHeight.toDouble()


            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra(ResultActivity.RESULT,result.toString())
            startActivity(intent)

        }
    }
}