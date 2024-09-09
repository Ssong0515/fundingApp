package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.Retrofit.FunClient
import com.example.myapplication.databinding.ActivityWriteBinding
import com.example.myapplication.retrofitPacket.CategoryPacket
import com.example.myapplication.retrofitPacket.ProjectWrite
import com.example.myapplication.retrofitPacket.UserPacket
import com.example.myapplication.utils.Const
import retrofit2.Call
import retrofit2.Response



class WriteActivity : AppCompatActivity() {
    lateinit var binding:ActivityWriteBinding
    lateinit var user: UserPacket

    val categoryMap = mapOf(
        0 to CategoryPacket(1, "전체"),
        1 to CategoryPacket(2, "캐릭터 · 굿즈"),
        2 to CategoryPacket(3, "홈 · 리빙"),
        3 to CategoryPacket(4, "테크 · 가전"),
        4 to CategoryPacket(5, "반려동물"),
        5 to CategoryPacket(6, "향수 · 뷰티"),
        6 to CategoryPacket(7, "의류"),
        7 to CategoryPacket(8, "잡화"),
        8 to CategoryPacket(9, "음악"),
        9 to CategoryPacket(10, "푸드"),
        10 to CategoryPacket(11, "주얼리")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_write)

        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var selectedCategory: CategoryPacket? = null // 카테고리
        lateinit var title: String // 타이틀
        var imagePath: String? = null // 이미지 절대 경로
        lateinit var contentText: String // 내용
        lateinit var goalAmount: String // 목표 금액
        lateinit var perPrice: String // 후원 금액(개당 금액)
        lateinit var startDate: String // 펀딩 일정(시작일)
        lateinit var endDate: String // 펀딩 일정(종료일)

        // 카테고리 선택
        binding.spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // 선택된 항목의 ID에 따라 CategoryPacket 생성
                selectedCategory = categoryMap[position]
                Log.d("category", "selectedCategory: $selectedCategory")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        }

        // 현재 선택된 ImageView를 저장할 변수
        var selectedImageView: ImageView? = null

        // 이미지 선택
        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val imageUri: Uri? = result.data?.data

                imageUri?.let { uri ->
                    // 절대 경로 가져옴
                    imagePath = getRealPathFromURI(uri).toString()

                    // 선택된 ImageView에 이미지 설정
                    selectedImageView?.setImageURI(uri)

                } ?: run {
                    Log.d("ImageLoad", "Image URI is null")
                }
            }
        }

        fun pickImage() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }

        // imageView1 클릭
        binding.imageView1.setOnClickListener {
            selectedImageView = binding.imageView1
            pickImage()
        }

        // imageView2 클릭
        binding.imageView2.setOnClickListener {
            selectedImageView = binding.imageView2
            pickImage()
        }

        // imageView3 클릭
        binding.imageView3.setOnClickListener {
            selectedImageView = binding.imageView3
            pickImage()
        }

        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)

        // 펀딩 일정(시작일) 버튼 클릭
        binding.tvStartDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
                // "YYYY-MM-DD" 형식으로 날짜 설정
                binding.tvStartDate.text = String.format("%04d-%02d-%02d", year, month + 1, day)
            }, year, month, day)
            datePickerDialog.show()
        }

        // 펀딩 일정(종료일) 버튼 클릭
        binding.tvEndDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
                // "YYYY-MM-DD" 형식으로 날짜 설정
                binding.tvEndDate.text = String.format("%04d-%02d-%02d", year, month + 1, day)
            }, year, month, day)
            datePickerDialog.show()
        }

        // 작성 완료 버튼 클릭
        binding.btnSubmit.setOnClickListener {
            // 카테고리 값 확인
            Log.d("button click", "category: $selectedCategory!!")

            // 프로젝트 제목
            title = binding.edtTitle.text.toString()
            Log.d("button click", "title: $title")

            // 이미지 절대 경로
            if(imagePath != null) {
                Log.d("button click", "imagePath: $imagePath")
            }

            // 프로젝트 내용(텍스트)
            contentText = binding.edtContents.getText().toString()
            Log.d("button click", "contentText: $contentText")

            // 펀딩 일정(시작일)
            startDate = binding.tvStartDate.getText().toString() + "T00:00:00"
            Log.d("button click", "startDate: $startDate")

            // 펀딩 일정(종료일)
            endDate = binding.tvEndDate.getText().toString() + "T00:00:00"
            Log.d("button click", "endDate: $endDate")

            // 목표 금액
            goalAmount = binding.edtGoalAmount.text.toString()
            Log.d("button click", "goalAmount: $goalAmount")

            // 후원 금액(개당 금액)
            perPrice = binding.edtPerPrice.text.toString()
            Log.d("button click", "perPrice: $perPrice")

            val shared = getSharedPreferences(Const.SHARED_PREF_LOGIN_NAME, Context.MODE_PRIVATE)
            val userId = shared?.getString(Const.SHARED_PREF_LOGIN_ID, "false")

            // userId가 유효한지 확인
            if (userId != "false") {
                // User 정보를 서버에서 가져옴
                FunClient.retrofit.getUser(userId!!).enqueue(object : retrofit2.Callback<UserPacket> {
                    override fun onResponse(call: Call<UserPacket>, response: Response<UserPacket>) {
                        if (response.isSuccessful) {
                            val user = response.body()
                            if (user != null) {
                                // User 정보가 정상적으로 반환된 경우
                                val projectWrite = ProjectWrite(
                                    0, goalAmount.toInt(), 0, title, contentText, startDate, endDate, perPrice.toInt(), imagePath!!, user, selectedCategory!!
                                )

                                FunClient.retrofit.writeProject(projectWrite).enqueue(object : retrofit2.Callback<Void> {
                                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                        Toast.makeText(this@WriteActivity, "작성 완료", Toast.LENGTH_SHORT).show()
                                    }

                                    override fun onFailure(call: Call<Void>, t: Throwable) {
                                        Log.e("Submit", "Error: ${t.message}")
                                        Toast.makeText(this@WriteActivity, "서버와의 연결이 실패했습니다", Toast.LENGTH_SHORT).show()
                                    }
                                })
                            } else {
                                Toast.makeText(this@WriteActivity, "사용자 정보를 가져올 수 없습니다", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@WriteActivity, "서버 응답 오류", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<UserPacket>, t: Throwable) {
                        Log.e("Submit", "Error: ${t.message}")
                        Toast.makeText(this@WriteActivity, "서버와의 연결이 실패했습니다", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this, "로그인 정보가 없습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 이미지 절대 경로
    fun getRealPathFromURI(uri: Uri): String? {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        contentResolver.query(uri, projection, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                return cursor.getString(columnIndex)
            }
        }
        return null
    }
}