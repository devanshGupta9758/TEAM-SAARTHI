package com.example.saarthi

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        val logout = findViewById<Button>(R.id.logout_btn)
        logout.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("Saarthi")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("No", null)
                .show()

        }


        val search = findViewById<CardView>(R.id.option2)
        search.setOnClickListener {
            val intent = Intent(this , SearchForm::class.java)
            startActivity(intent)
        }
        val mywheel = findViewById<CardView>(R.id.option1)
        mywheel.setOnClickListener {
            val intent1 = Intent(this, MyWheelchair::class.java)
            startActivity(intent1)
        }

        val batteryPercentage = getBatteryPercentage(applicationContext).toString()
        if(batteryPercentage <= "100" && batteryPercentage > "90"){
            val img1 = findViewById<ImageView>(R.id.b100)
            img1.isVisible = true
        }
        if (batteryPercentage <= "90" && batteryPercentage > "80"){
            val img2 = findViewById<ImageView>(R.id.b90)
            img2.isVisible = true
        }
        if (batteryPercentage <= "80" && batteryPercentage > "70"){
            val img3 = findViewById<ImageView>(R.id.b80)
            img3.isVisible = true
        }
        if (batteryPercentage <= "70" && batteryPercentage > "60"){
            val img4 = findViewById<ImageView>(R.id.b70)
            img4.isVisible = true
        }
        if (batteryPercentage <= "60" && batteryPercentage > "50"){
            val img5 = findViewById<ImageView>(R.id.b60)
            img5.isVisible = true
        }
        if (batteryPercentage <= "50" && batteryPercentage > "40"){
            val img6 = findViewById<ImageView>(R.id.b50)
            img6.isVisible = true
        }
        if (batteryPercentage <= "40" && batteryPercentage > "30"){
            val img7 = findViewById<ImageView>(R.id.b40)
            img7.isVisible = true
        }
        if (batteryPercentage <= "30" && batteryPercentage > "20"){
            val img8 = findViewById<ImageView>(R.id.b30)
            img8.isVisible = true
        }
        if (batteryPercentage <= "20" && batteryPercentage > "10"){
            val img9 = findViewById<ImageView>(R.id.b20)
            img9.isVisible = true
        }
        if (batteryPercentage <= "10" && batteryPercentage > "00"){
            val img10 = findViewById<ImageView>(R.id.b10)
            img10.isVisible = true
        }




    }

    fun getBatteryPercentage(context: Context): Int {
        val batteryIntent: Intent? = context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        val level: Int = batteryIntent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale: Int = batteryIntent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1

        return (level.toFloat() / scale.toFloat() * 100).toInt()
    }
}