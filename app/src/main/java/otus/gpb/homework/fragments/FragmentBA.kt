package otus.gpb.homework.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.setFragmentResultListener

const val FRAGMENT_COLOR_KEY = "ColorBA"

class FragmentBA : Fragment(R.layout.fragment_ba) {

    private lateinit var startBB_Button: Button
    private lateinit var fragmentBB: FragmentBB
    private var backGroundColor: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val backPressedCallBack = object : OnBackPressedCallback(true)
        {
            override fun handleOnBackPressed() {
                if( parentFragmentManager.backStackEntryCount <= 1 )
                    requireActivity().finish()
                else   parentFragmentManager.popBackStackImmediate()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallBack)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            backGroundColor = getArguments()?.getInt(FRAGMENT_COLOR_KEY)
            backGroundColor?.let{ view.setBackgroundColor(it) }

            startBB_Button = view.findViewById<Button>(R.id.StartFragmentBB_Button)
            startBB_Button.setOnClickListener {
                fragmentBB = FragmentBB.newInstance()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.ContainerForFragments, fragmentBB)
                    .addToBackStack("")
                    .commit()
            }
        }
        else{
           setFragmentResultListener(FRAGMENT_COLOR_KEY) { _, bundle ->
               backGroundColor = bundle.getInt(FRAGMENT_COLOR_KEY)
               backGroundColor?.let{ view.setBackgroundColor(it) } }
        }
    }

   companion object {
        @JvmStatic
        fun newInstance() = FragmentBA()
    }
}