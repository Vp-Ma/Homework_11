package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentAB : Fragment(R.layout.fragment_ab) {

    private var backGroundColor: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            backGroundColor = savedInstanceState.getInt( FRAGMENT_AB_COLOR_KEY )
        } else {
            backGroundColor = getArguments()?.getInt( FRAGMENT_AB_COLOR_KEY )
        }
        backGroundColor?.let { view.setBackgroundColor(it) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        backGroundColor?.let{ outState.putInt( FRAGMENT_AB_COLOR_KEY, it ) }
    }

    companion object {
        @JvmStatic
        fun newInstance( ) = FragmentAB()
    }
}