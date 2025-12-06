package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.setFragmentResult

class FragmentBB : Fragment(R.layout.fragment_bb) {

    private lateinit var sendColorButton: Button
    private lateinit var fragmentBA: FragmentBA
    private val bundle = Bundle()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            sendColorButton = view.findViewById<Button>(R.id.SendColor_Button)

            sendColorButton.setOnClickListener {

                bundle.putInt(FRAGMENT_COLOR_KEY, ColorGenerator.generateColor())

                if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

                    fragmentBA = FragmentBA.newInstance()
                    fragmentBA.setArguments(bundle)
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.ContainerForFragments, fragmentBA)
                        .addToBackStack("")
                        .commit()
                }
                else{  setFragmentResult(FRAGMENT_COLOR_KEY, bundle)  }
            }

    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentBB()
    }
}