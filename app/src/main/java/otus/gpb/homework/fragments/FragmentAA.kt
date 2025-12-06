package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentAA : Fragment(R.layout.fragment_aa) {

    private var backGroundColor: Int? = null
    private lateinit var startAB_Button:Button
    private lateinit var fragmentAB: FragmentAB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAB_Button = view.findViewById<Button>(R.id.StartFragmentAB_Button)

        if( savedInstanceState != null ) {
            backGroundColor = savedInstanceState.getInt(FRAGMENT_AA_COLOR_KEY)
        } else {
            backGroundColor = getArguments()?.getInt(FRAGMENT_AA_COLOR_KEY)
        }
        backGroundColor?.let{ view.setBackgroundColor(it) }

        startAB_Button.setOnClickListener {

            fragmentAB = FragmentAB.newInstance()
            val bundle = Bundle()
            bundle.putInt("SetColorAB", ColorGenerator.generateColor())
            fragmentAB.setArguments(bundle)

            parentFragmentManager.beginTransaction()
              .replace(R.id.ContainerForFragments, fragmentAB)
              .addToBackStack("")
              .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        backGroundColor?.let{ outState.putInt( FRAGMENT_AA_COLOR_KEY, it) }
    }

    companion object {
       @JvmStatic
       fun newInstance() = FragmentAA()
    }

}