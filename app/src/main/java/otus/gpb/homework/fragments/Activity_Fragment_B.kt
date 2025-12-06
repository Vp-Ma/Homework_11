package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Activity_Fragment_B : AppCompatActivity() {

    lateinit private var fragmentBA : FragmentBA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_b)

        if( resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            if (savedInstanceState == null) {
                fragmentBA = FragmentBA.newInstance()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.ContainerForFragments, fragmentBA)
                    .addToBackStack("")
                    .commit()
            }
            else if( supportFragmentManager.backStackEntryCount == 0 )
                    finish()
        }
    }
}