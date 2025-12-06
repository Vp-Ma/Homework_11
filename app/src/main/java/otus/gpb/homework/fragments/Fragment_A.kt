package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback

const val FRAGMENT_AA_COLOR_KEY = "SetColorAA"
const val FRAGMENT_AB_COLOR_KEY = "SetColorAB"

class Fragment_A : Fragment(R.layout.fragment__a) {

    private lateinit var startAA_Button:Button
    private lateinit var fragmentAA: FragmentAA

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val backPressedCallBack = object : OnBackPressedCallback(true)
        {
            override fun handleOnBackPressed() {
                if(parentFragmentManager.backStackEntryCount <= 1)
                    requireActivity().finish()
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallBack)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAA_Button = view.findViewById<Button>(R.id.StartFragmentAAButton)

        startAA_Button.setOnClickListener {

        val bundle = Bundle()
        bundle.putInt( FRAGMENT_AA_COLOR_KEY, ColorGenerator.generateColor() )
        fragmentAA = FragmentAA.newInstance()
        fragmentAA.setArguments(bundle)

            parentFragmentManager.beginTransaction()
                .replace(R.id.ContainerForFragments, fragmentAA)
                .addToBackStack("")
                .commit()
        }
    }

   companion object {
       @JvmStatic
       fun newInstance() = Fragment_A()
   }
}