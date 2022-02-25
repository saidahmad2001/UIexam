package uz.pdp.uiexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uiexam.controller.SharedPref


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        controlActivity()
    }

    private fun controlActivity() {
        if (SharedPref(this).isSaved) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, EntryActivity::class.java))
        }
    }
}