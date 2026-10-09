package cn.edu.sicnu.cs.stu.baixinyuan.myapplication

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var llContainer: LinearLayout
    private lateinit var btnAddTv: Button
    private lateinit var spLanguage: Spinner
    private lateinit var btnQuery: Button
    private lateinit var tvResult: TextView

    private val model = ProgramAdviser()
    private var count = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //绑定控件
        llContainer = findViewById(R.id.llContainer)
        btnAddTv = findViewById(R.id.btnAddTv)
        spLanguage = findViewById(R.id.spLanguage)
        btnQuery = findViewById(R.id.btnQuery)
        tvResult = findViewById(R.id.tvResult)

        //区1：动态添加TextView
        btnAddTv.setOnClickListener {
            val newTv = TextView(this)
            val textStr = getString(R.string.new_text, count)
            newTv.text = textStr
            newTv.textSize = 18f
            val lp = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            newTv.layoutParams = lp
            llContainer.addView(newTv)
            count++
        }

        //区2 MVC
        btnQuery.setOnClickListener {
            val selectLang = spLanguage.selectedItem.toString()
            val strResId = model.getAdvice(selectLang)
            tvResult.text = selectLang
            Toast.makeText(this, getString(strResId, 99), Toast.LENGTH_SHORT).show()
        }
    }
}
