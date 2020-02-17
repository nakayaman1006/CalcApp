package jp.techacademy.yuuki.nakayama.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.text = "足し算(+)"
        button2.text = "引き算(-)"
        button3.text = "かけ算(×)"
        button4.text = "わり算(÷)"

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }


    override fun onClick(v: View) {
        var result: Double = 0.0

        if (editText1.text.length != 0 && editText2.text.length != 0) {
            when (v.id) {
                R.id.button1 -> result =
                    editText1.text.toString().toDouble() + editText2.text.toString().toDouble()
                R.id.button2 -> result =
                    editText1.text.toString().toDouble() - editText2.text.toString().toDouble()
                R.id.button3 -> result =
                    editText1.text.toString().toDouble() * editText2.text.toString().toDouble()
                R.id.button4 -> result =
                    editText1.text.toString().toDouble() / editText2.text.toString().toDouble()
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        } else {
            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("了解") {
                    Log.d("KADAI", "Snackbarをタップした")
                }.show()
        }
    }
}