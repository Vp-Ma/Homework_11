package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_Fragment_A : AppCompatActivity() {

    lateinit private var fragmentA:Fragment_A

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_a)


        if (savedInstanceState == null) {
            fragmentA = Fragment_A.newInstance()
            supportFragmentManager.beginTransaction()
                .replace( R.id.ContainerForFragments, fragmentA )
                .addToBackStack("")
                .commit()
        }


    }
}