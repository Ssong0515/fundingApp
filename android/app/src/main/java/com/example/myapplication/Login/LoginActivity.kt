package com.example.myapplication.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.Retrofit.FunClient
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.dto.Project
import com.example.myapplication.dto.User
import com.example.myapplication.retrofitPacket.LoginCheckPacket
import com.example.myapplication.retrofitPacket.ProjectDetail
import com.example.myapplication.retrofitPacket.UserPacket
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        FunClient.retrofit.getProjectList().enqueue(object:retrofit2.Callback<List<Project>>{
            override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
//                val dataMap = response.body() as Map<>
                Log.d("retrofit getProjectList", "-------")

            }

            override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                Log.d("retrofit getProjectList", "${t.message}")
            }
        })
//
//        val project = Project(
//            1,
//            1000,
//            "send",
//            "sedding",
//            "1111",
//            "22222",
//            100,
//            User(
//                1L,
//                "11",
//                "11",
//                "11",
//                "11",
//                "11",
//                listOf(),
//                listOf(),
//                listOf()
//            ),
//            listOf(),
//            listOf()
//        )
//        FunClient.retrofit.writeProject(project).enqueue(object: retrofit2.Callback<Void>{
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                Log.d("retrofit", "success")
//            }
//
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                Log.d("retrofit", "fail")
//            }
//
//        })


        binding.btnTryLogin.setOnClickListener{
            FunClient.retrofit.getProjectList().enqueue(object:retrofit2.Callback<List<Project>>{
                override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
//                val dataMap = response.body() as Map<>
                    Log.d("retrofit getProjectList", "-------")

                }

                override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                    Log.d("retrofit getProjectList", "${t.message}")
                }
            })

        }

        binding.btnGoSignIn.setOnClickListener{
            startActivity(Intent(this@LoginActivity, SignInActivity::class.java))
        }

        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
    }

    fun displayWarningDialog(msg:String){
        AlertDialog.Builder(this).run{
            setMessage(msg)
            setPositiveButton("확인", null)
            show()
        }
    }
}