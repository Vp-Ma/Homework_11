package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit private var startActiv_A: Button// = findViewById(R.id.startActivityA)
    lateinit private var startActiv_B: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActiv_A = findViewById(R.id.startActivityA)
        startActiv_B = findViewById(R.id.startActivityB)

        startActiv_A.setOnClickListener{
            val intentActivityA = Intent( this@MainActivity, Activity_Fragment_A::class.java)
            startActivity(intentActivityA)
        }

        startActiv_B.setOnClickListener{
            val intentActivityB = Intent( this@MainActivity, Activity_Fragment_B::class.java)
            startActivity(intentActivityB)
        }


    }
}